package dbms;

import antlr.sqlBaseVisitor;
import antlr.sqlParser;
import static dbms.ANTGui.bdActual;
import static dbms.ANTGui.jTable1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;


/**
 *
 * @author Andres
 * 
 */
public class Visitor<T> extends sqlBaseVisitor {

    private FileManager manejador = new FileManager();
    private ArchivoMaestroDB  mdb = new ArchivoMaestroDB();
    private ArchivoMaestroTabla mdt = new ArchivoMaestroTabla();
    private JSONParser json = new JSONParser();
    private Tabla tabla;
    public String tablaActual="";
    private String globalLogic="";
    private VisitorAndres visitorAndres = new VisitorAndres();
    private VisitorPablo visitorPablo = new VisitorPablo();
    private ArrayList indexActuales = new ArrayList();
    private Stack columnas = new Stack();
    private boolean op1IsValue = false;
    private boolean op2IsValue = false;
   
    /**
     * Método que crea la base de datos y actualiza el archivo maestro de bases de datos.
     * @param ctx
     * @return 
     */
    @Override
    public Object visitSchema_definition(sqlParser.Schema_definitionContext ctx) {
        
        String nombreBaseDatos = ctx.getChild(2).getText();
        DBMS.debug("DB name " + nombreBaseDatos);
        boolean carpeta = manejador.createDirectory(nombreBaseDatos);
        boolean master = manejador.checkFile("", "MasterDB");
        if (carpeta){
            DBMS.debug("Agregando "+ nombreBaseDatos + " al archivo maestro", ctx.getStart());
            mdb.agregarDB(nombreBaseDatos);
        }
        if (carpeta && master){
            DBMS.debug("Actualizando archivo maestro de bases de datos", ctx.getStart());
            ArchivoMaestroDB masterSaved = (ArchivoMaestroDB) json.JSONtoObject("", "MasterDB", "ArchivoMaestroDB");
            mdb.agregarExistente(masterSaved);
         
        
        }
        if (carpeta){
            DBMS.throwMessage("Se ha creado la base de datos", ctx.getStart());
            
            json.objectToJSON("", "MasterDB", mdb);//convierte el objeto a JSON
            mdb = new ArchivoMaestroDB(); //sirve para perder la referencia
        }
        else{
            DBMS.throwMessage("Error: la base de datos ya existe", ctx.getStart());
        }
        
        
        return super.visitSchema_definition(ctx); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método que crea la tabla
     * Este método tiene que visitar los hijos para terminar de crear la tabla.
     * @param ctx
     * @return 
     */
    @Override
    public Object visitTable_definition(sqlParser.Table_definitionContext ctx) {
        
        tabla = new Tabla();
        String nombreTabla = ctx.getChild(2).getText();
        tablaActual = nombreTabla;
       
        for (int i = 0;i<ctx.getChildCount();i++){
            this.visit(ctx.getChild(i));
        }
        
       
        ArchivoMaestroDB masterSaved = (ArchivoMaestroDB) json.JSONtoObject("", "MasterDB", "ArchivoMaestroDB");
       
        if (manejador.checkFileTabla(bdActual, nombreTabla)){
            DBMS.debug("Nombre tabla " + nombreTabla + " existe", ctx.getStart());
            mdt.agregarTabla(nombreTabla);
            if (tabla != null){
                DBMS.throwMessage("Se ha guardado la tabla " + nombreTabla, ctx.getStart());
                json.objectToJSON(bdActual, nombreTabla, tabla);
            }
            else{
                DBMS.throwMessage("Error: Ha ocurrido un error al crear la tabla", ctx.getStart());
            }    
            if (manejador.checkFile(bdActual, "MasterTable"+bdActual)){
                DBMS.debug("Actualizando archivo maestro de tablas", ctx.getStart());
                ArchivoMaestroTabla masterTable = (ArchivoMaestroTabla) json.JSONtoObject(bdActual, "MasterTable"+bdActual, "ArchivoMaestroTabla");
                mdt.agregarExistente(masterTable);
            }
            json.objectToJSON(bdActual, "MasterTable"+bdActual, mdt);
            
            
            
            masterSaved.aumentarTablaCount(bdActual);
            mdb.agregarExistente(masterSaved);
            
            json.objectToJSON("", "MasterDB", mdb);
            
            mdb = new ArchivoMaestroDB(); //sirve para perder la referencia
        }
        else{
            if (bdActual.isEmpty())
                DBMS.throwMessage("Error: No se ha seleccionado la base de datos", ctx.getStart());
            else
                DBMS.throwMessage("Error: La tabla ya existe", ctx.getStart());
        }
       
        mdt = new ArchivoMaestroTabla(); //sirve para perder la referencia
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitColumn(sqlParser.ColumnContext ctx) {
        if (tabla != null){
            String nombreColumna = ctx.getChild(0).getText();
            String tipo = (String)visit(ctx.getChild(1));
            DBMS.debug("Verificando unicidad en nombre de columnas ", ctx.getStart());
            for (TuplaColumna columna : tabla.getColumnas()) {
                if (columna.getNombre().equals(nombreColumna)){
                    DBMS.throwMessage("Error: La columna  " + nombreColumna +" ya está definida", ctx.getStart());
                    tabla = null;
                    return super.visitColumn(ctx);
                }
            }
            TuplaColumna tupla = new TuplaColumna();
            if (tipo.contains("€")){
                int tam = Integer.parseInt(tipo.substring(tipo.indexOf("€")+1));
                tupla.setTamaño(tam);
                tipo = tipo.substring(0,tipo.indexOf("€"));
            }
            DBMS.debug(nombreColumna);
            DBMS.debug(tipo);

            tupla.setNombre(nombreColumna);
            tupla.setTipo(tipo.toUpperCase());
            tabla.agregarColumna(tupla);
        }
        else{
            DBMS.debug("Ha ocurrido un error en cascada en la tabla ", ctx.getStart());
        }
        return super.visitColumn(ctx);
    }

    @Override
    public Object visitUse_schema_statement(sqlParser.Use_schema_statementContext ctx) {
        
        bdActual = ctx.getChild(2).getText();
       
        if (manejador.checkDB(bdActual)==false){
            DBMS.throwMessage("Error: la base de datos "  + bdActual + " no existe " , ctx.getStart());
            bdActual = "";
           return super.visitUse_schema_statement(ctx); 
        }
        DBMS.throwMessage("La base de datos " + bdActual + " ha sido seleccionada",ctx.getStart());
        return super.visitUse_schema_statement(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitConstraintPrimaryKey(sqlParser.ConstraintPrimaryKeyContext ctx) {
        String nombreTabla = ctx.getParent().getParent().getParent().getChild(2).getText();
        String nombreConstraint = ctx.getChild(0).getText();
        String tipoConstraint = ctx.getChild(1).getText();
        ArrayList<String> listadoIDS = (ArrayList<String>)visit(ctx.getChild(4));
        Constraint constraint = new Constraint();
        constraint.setTipo(tipoConstraint.toUpperCase());
        constraint.setNombre(nombreConstraint);
    
         //ahora busco la tabla y verifico los campos de los constraints
        Tabla tabla_c = tabla;
            if(tabla!=null){ 
                if(tipoConstraint.equals("PRIMARY"))
                    for(int i = 0;i<tabla.getConstraints().size();i++){
                        if(tabla.getConstraints().get(i).getTipo().equals("PRIMARY")){
                            DBMS.throwMessage("Error: Constraint primary key ya existe en la tabla " + nombreTabla, ctx.getStart() );
                            tabla  = null;
                            return null; //To change body of generated methods, choose Tools | Templates.
                        }
                    }
            ArrayList<TuplaColumna> camposActuales = tabla_c.getColumnas();
            for (int i =0;i<tabla.getConstraints().size();i++){
                 if (tabla.getConstraints().get(i).getNombre().equals(nombreConstraint)){
                     DBMS.throwMessage("Error: el nombre del constraint " + nombreConstraint + " ya ha sido usado",ctx.getStart());
                     tabla = null;
                     return null;
                    }
            }
            boolean verificador = revisarListadoIDs(camposActuales, listadoIDS);
            if (verificador){
                constraint.setReferences(listadoIDS);
                tabla.addConstraint(constraint);
                DBMS.debug("Se ha agregado el constraint" + nombreConstraint + "a la tabla " + nombreTabla, ctx.getStart());
            }
            else{
                 DBMS.throwMessage("Error: campo "+listadoIDS+" no existe en la tabla " + nombreTabla, ctx.getStart() );
                 tabla = null; //ya no se guarda la tabla.
            }
        }
        return super.visitConstraintPrimaryKey(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitConstraintCheck(sqlParser.ConstraintCheckContext ctx) {
        
            String nombreConstraint = ctx.getChild(0).getText();
            String tipoConstraint = ctx.getChild(1).getText();
           
            Constraint constraint = new Constraint();
            constraint.setTipo(tipoConstraint);
            constraint.setNombre(nombreConstraint);
        
           
                    
            if(tabla!=null){
                ArrayList<Constraint> columnas = tabla.getConstraints();
                boolean verCheck = true;
                for (int i = 0;i<columnas.size();i++){
                    if (columnas.get(i).getNombre().equals(nombreConstraint)){
                        verCheck= false;
                    }
                }
                if (!verCheck){
                    tabla = null;
                    DBMS.throwMessage("Error: El nombre del constraint "+nombreConstraint + " ya existe " , ctx.getStart());
                    return null;
                }
                for (int i = 3;i<ctx.getChildCount();i++){
                    T visitCheck = (T)this.visit(ctx.getChild(i));
                    if (visitCheck instanceof TuplaCheck){
                        if (!this.globalLogic.isEmpty()){
                           
                            ((TuplaCheck)visitCheck).setOperadorLogico(globalLogic);
                        }
                        constraint.addTuplaCheck((TuplaCheck)visitCheck);
                    }
                    
                }
                this.globalLogic = "";
                tabla.addConstraint(constraint);
                DBMS.debug("Se ha agregado el constraint " + nombreConstraint, ctx.getStart());
            }
        
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitLogic(sqlParser.LogicContext ctx) {
        this.globalLogic = ctx.getChild(0).getText();
        return super.visitLogic(ctx); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public Object visitCheck_exp(sqlParser.Check_expContext ctx) {
        String op1Check = ctx.getChild(0).getText();
        String operatorCheck = ctx.getChild(1).getText();
        String op2Check = ctx.getChild(2).getText();
        TuplaCheck tupla = new TuplaCheck();
        tupla.setOp1(op1Check);
        tupla.setOperador(operatorCheck);
        tupla.setOp2(op2Check);
        return tupla; //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public Object visitConstraintForeignKey(sqlParser.ConstraintForeignKeyContext ctx) {
        String nombreTabla = ctx.getParent().getParent().getParent().getChild(2).getText();
        String nombreConstraint = ctx.getChild(0).getText();
        String tipoConstraint = ctx.getChild(1).getText();
        ArrayList<String> listadoIDS = (ArrayList<String>)visit(ctx.getChild(4));
        Constraint constraint = new Constraint();
        constraint.setTipo(tipoConstraint);
        constraint.setNombre(nombreConstraint);
        
         String nombreTablaRef = ctx.getChild(7).getText();
            ArrayList<String> listadoIDSREF = (ArrayList<String>)visit(ctx.getChild(9));
            
            //ahora tengo que revisar que existe la tabla que se referencia
            //y revisar que el listado IDS REF existe en esa tabla.
            
            //paso 1. ir a buscar tabla de referencia
            Tabla tablaRef = (Tabla)json.JSONtoObject(bdActual, nombreTablaRef, "Tabla");
            //TODO: ¿Qué pasa si no existe la tabla? falta validar esto.
            //paso 2. verificar que los campos de referencia existan en la tabla de referencia
            ArrayList<TuplaColumna> columnasRef = tablaRef.getColumnas();
         
            boolean verificadorRef = this.revisarListadoIDs(columnasRef, listadoIDSREF);
            //si no existen los campos en la referencia
            if (!verificadorRef){//no pasa la validación
                DBMS.throwMessage("No existe algún campo de " +listadoIDSREF, ctx.getStart());
                tabla = null;
                return null;
            }
            //si llega aquí es porque si existen
            TuplaRefForeign tuplaForeign = new TuplaRefForeign(nombreTablaRef);
            tuplaForeign.setReferencesForeign(listadoIDSREF);
            constraint.setReferencesForeign(tuplaForeign);
            
             //ahora busco la tabla y verifico los campos de los constraints
            Tabla tabla_c = tabla;
                if(tabla!=null){
                    for(int i = 0;i<tabla.getConstraints().size();i++)
                        if(tabla.getConstraints().get(i).getNombre().equals(nombreConstraint)){
                            DBMS.throwMessage("Error: Constraint "+nombreConstraint+" ya existe en la tabla " + nombreTabla,ctx.getStart() );
                            return super.visitConstraintForeignKey(ctx); //To change body of generated methods, choose Tools | Templates.
                        }
                ArrayList<TuplaColumna> camposActuales = tabla_c.getColumnas();
                boolean verificador = revisarListadoIDs(camposActuales, listadoIDS);
                if (verificador){
                    constraint.setReferences(listadoIDS);
                    tabla.addConstraint(constraint);
                    DBMS.debug("Se ha agregado el constraint " + nombreConstraint,ctx.getStart());
                }
                else{
                     DBMS.throwMessage("Error: campo "+listadoIDS+" no existe en la tabla " + nombreTabla,ctx.getStart() );
                     tabla = null; //ya no se guarda la tabla.
                }
            }
        
        
        return super.visitConstraintForeignKey(ctx); //To change body of generated methods, choose Tools | Templates.
    }

   
    /**
     * Método para revisar los campos referenciados en los constraints
     * @param camposActuales
     * @param listadoIDS
     * @return true si es válido, false contrario
     */
    public boolean revisarListadoIDs(ArrayList<TuplaColumna> camposActuales, ArrayList<String> listadoIDS){
        boolean verificador = true;
        for (int i = 0;i<listadoIDS.size();i++){
            String idActual = listadoIDS.get(i);
            boolean verificadorInterno = false;
            for (int j = 0;j<camposActuales.size();j++){
                
                String campoActual = camposActuales.get(j).getNombre();
                if (idActual.equals(campoActual)){
                    verificadorInterno = true;
                }
            }
            verificador = verificadorInterno;
            
        }
        if (checkDuplicates(listadoIDS)){
            DBMS.throwMessage("Error: Hay elementos repetidos en constraint");
            return false;
        }
        return verificador;
    }
    
   /**
    * Revisar si hay duplicados en un arraylist
    * @param list
    * @return 
    */
   public boolean checkDuplicates(ArrayList<String> list){
       
    Set<String> set = new HashSet<String>(list);

    return set.size() < list.size();
   
   }
    
    /**
     * Método que regresa un array con los nombres de los ids en constraints
     * 
     * @param ctx
     * @return ArrayList de Strings
     */
    @Override
    public Object visitId_list(sqlParser.Id_listContext ctx) {
        
        ArrayList<String> listadoId = new ArrayList();
        for (int i = 0; i<ctx.getChildCount(); i++) {
            
            if (!ctx.getChild(i).getText().equals(",")) {
                listadoId.add(ctx.getChild(i).getText());
            }
        }
        
       return listadoId; //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public Object visitTipo_literal(sqlParser.Tipo_literalContext ctx) {
        if (ctx.getChild(0).getChildCount()>1){
            return ctx.getChild(0).getChild(0).getText()+"€" + ctx.getChild(0).getChild(2).getText();
        }
        
       return ctx.getChild(0).getChild(0).getText();//To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Eliminar una base de datos, todas las tablas y actualizar el archivo maestro
     * @param ctx
     * @return 
     */
    @Override
    public Object visitDrop_schema_statement(sqlParser.Drop_schema_statementContext ctx) {
        String nombreDB = ctx.getChild(2).getText();
        int dialogResult = JOptionPane.showConfirmDialog (null, "Seguro que desea eliminar la base de datos "+nombreDB+" ?");
        if(dialogResult == JOptionPane.NO_OPTION || dialogResult == JOptionPane.CANCEL_OPTION){
            return super.visitDrop_schema_statement(ctx);
        }
        
        boolean verificador = manejador.checkDB(nombreDB);
        if (!verificador){
            DBMS.throwMessage("La base de datos " + nombreDB + " no existe",ctx.getStart());
            return super.visitDrop_schema_statement(ctx);
        }
        manejador.eliminarDB(nombreDB);
        ArchivoMaestroDB mdbActual = (ArchivoMaestroDB)json.JSONtoObject("", "MasterDB", "ArchivoMaestroDB");
        ArrayList<TuplaDB> arrayDB = mdbActual.getNombreDB();
        ArrayList<TuplaDB> modificarArrayDB = arrayDB;
        for (int i = 0;i<arrayDB.size();i++){
            if (arrayDB.get(i).getNombreDB().equals(nombreDB)){
                modificarArrayDB.remove(i);
            }
        }
        json.objectToJSON("", "MasterDB", mdbActual);
        DBMS.throwMessage("Se ha eliminado la base de datos " + nombreDB, ctx.getStart());
        
        return super.visitDrop_schema_statement(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Método que altera la estructura de una base de datos
     * @param ctx
     * @return 
     */
    @Override
    public Object visitAlter_database_statement(sqlParser.Alter_database_statementContext ctx) {
        
        String nombreDBActual = ctx.getChild(2).getText();
        String nombreNuevoDB = ctx.getChild(5).getText();
        if (!manejador.checkDB(nombreDBActual)){
            DBMS.throwMessage("Error: la base de datos " + nombreDBActual + " no existe" , ctx.getStart());
            return null;
        }
        manejador.renameFile(bdActual, nombreDBActual, nombreNuevoDB);
        ArchivoMaestroDB mdbActual = (ArchivoMaestroDB)json.JSONtoObject("", "MasterDB", "ArchivoMaestroDB");
        ArrayList<TuplaDB> arrayDB = mdbActual.getNombreDB();
        ArrayList<TuplaDB> modificarArrayDB = arrayDB;
        for (int i = 0;i<arrayDB.size();i++){
            if (arrayDB.get(i).getNombreDB().equals(nombreDBActual)){
                modificarArrayDB.get(i).setNombreDB(nombreNuevoDB);
            }
        }
        json.objectToJSON("", "MasterDB", mdbActual);
        DBMS.debug("Se ha cambiado el nombre de la base de datos "+ nombreDBActual + " a " + nombreNuevoDB, ctx.getStart());
        
        return super.visitAlter_database_statement(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitRename_table_statement(sqlParser.Rename_table_statementContext ctx) {
        String nombreActual = ctx.getChild(2).getText();
        String nombreNuevo = ctx.getChild(5).getText();
       
        //antes reviso que exista la tabla en la base de datos actual
        DBMS.debug("Verificando si la tabla " + nombreActual + " existe");
        boolean verificador = manejador.checkFile(bdActual, nombreActual);
        if (!verificador){
            DBMS.throwMessage("Error: la tabla" + nombreActual + " no existe", ctx.getStart());
            return super.visitRename_table_statement(ctx); //To change body of generated methods, choose Tools | Templates.
        }
        DBMS.debug("La tabla " + nombreActual + "si existe", ctx.getStart());
        //renombra el archivo
        manejador.renameFileJSON(bdActual, nombreActual, nombreNuevo);
        ArchivoMaestroTabla tablita = (ArchivoMaestroTabla)json.JSONtoObject(bdActual, "MasterTable"+bdActual, "ArchivoMaestroTabla");
        ArrayList<TuplaTabla> arrayTablas = tablita.getTablas();
        for (TuplaTabla t : arrayTablas) {
            if (t.getNombreTabla().equals(nombreActual)){
                t.setNombreTabla(nombreNuevo);
                break; //optimización para no seguir buscando
            }
        }
        json.objectToJSON(bdActual, "MasterTable"+bdActual, tablita);
        DBMS.throwMessage("Se ha renombrado la tabla "+ nombreActual +" a "+ nombreNuevo, ctx.getStart());
        return super.visitRename_table_statement(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitShow_column_statement(sqlParser.Show_column_statementContext ctx) {
      
            String nombreTabla =  ctx.getChild(3).getText();
            
            //ir a buscar la tabla str 
            
            boolean check = manejador.checkFile(bdActual, nombreTabla);
            System.out.println(check);
            if (check ){
                Tabla tab = (Tabla)json.JSONtoObject(bdActual,nombreTabla , "Tabla");
                DBMS.debug(tab.getConstraints().toString(), ctx.getStart());
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                model.setRowCount(0);
                model.setColumnIdentifiers(new Object[]{"Nombre","Tipo","Constraints","Referencias"});
                String temp = "",ref = "";
                for(int i = 0;i<tab.getColumnas().size();i++){
                    temp = "";ref = "";
                    for(int j = 0;j<tab.getConstraints().size();j++)
                        if(tab.getConstraints().get(j).getReferences().contains(tab.getColumnas().get(i).getNombre().toString())){
                            temp = tab.getConstraints().get(j).getTipo();
                            if(tab.getConstraints().get(j).getTipo().equals("foreign"))
                                ref = "Tabla: "+tab.getConstraints().get(j).getReferencesForeign().getNombreTablaRef()+" Columna: "+tab.getConstraints().get(j).getReferencesForeign().getReferencesForeign().toString();
                        }
                    model.addRow(new Object[]{tab.getColumnas().get(i).getNombre().toString(), tab.getColumnas().get(i).getTipo().toString(),temp,ref});
                        
                }
            }else{
                DBMS.throwMessage( "Error:La tabla: "+nombreTabla+" no existe en la base de datos "+ bdActual, ctx.getStart());
                if (bdActual.isEmpty()){
                    DBMS.throwMessage("Error: No se ha seleccionado una base de datos", ctx.getStart());
                }
            }
        return super.visitShow_column_statement(ctx); //To change body of generated methods, choose Tools | Templates.
    
    }

  
    
    
    @Override
    public Object visitUpdate_value(sqlParser.Update_valueContext ctx) {
        
        String nombreTabla = ctx.getChild(1).getText();
        if (bdActual.isEmpty()){
            DBMS.throwMessage("Error: no se ha seleccionado la base de datos");
            return null;
        }
        if (!manejador.checkFile(bdActual, nombreTabla)){
            DBMS.throwMessage("Error: la tabla "+ nombreTabla +" no existe", ctx.getStart());
            return null;
        }
        tabla = (Tabla)json.JSONtoObject(bdActual, nombreTabla, "Tabla");
        //visitar todas las reglas de los hijos antes de guardar la tabla actualizada
        super.visitUpdate_value(ctx);
        //si no hubo errores, se guarda la data.
        if (tabla!= null){
             json.objectToJSON(bdActual, nombreTabla, tabla);
        }
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitUpdate_colmn(sqlParser.Update_colmnContext ctx) {
        String nombreColumna = ctx.getChild(0).getText();
        boolean verificadorColumna = verificarColumnaUpdate(nombreColumna);
        if (!verificadorColumna){
            DBMS.throwMessage("Error: La columna " +nombreColumna+ " no existe ");
            tabla = null;
            return null;
        }
        if (ctx.getParent().getParent().getChildCount() < 6){
            updateALLColumnTable(nombreColumna, (String)(ctx.getChild(2).getText()));
            return null;
        }
        
        //actualizar solo los del where
        updateSelectedColumns(nombreColumna,(String)(ctx.getChild(2).getText()), (ArrayList)this.visit(ctx.getParent().getParent().getChild(5)) );
        
        //return super.visitUpdate_colmn(ctx); //To change body of generated methods, choose Tools | Templates.
        return null;
    }
    
    
    public void updateSelectedColumns(String nombreColumna, String valor, ArrayList<Integer> indexUpdates){
         System.out.println("valor" + valor);
        ArrayList array = tabla.getIndexOfColumn(nombreColumna);
        System.out.println(array);
        int indiceActualizar = (int)array.get(0);
        String tipo = (String)array.get(1);
      
        boolean unique = tabla.checkPrimaryKey(nombreColumna);
        boolean pass = true;
        
        try {
        //recorrer toda la data en la tabla
        int cantidadUpdates = 0;
        for (int index : indexUpdates){
            
            ArrayList innerArray = tabla.getDataInTable().get(index);
            //si es numérico hay que hacer casteo 
           if (tipo.equals("INT")||tipo.equals("FLOAT")) {
               
                //si el indice a actualizar no existe, lo agregamos a la data
               if (innerArray.size() < indiceActualizar+1) {
                   if (unique){
                       pass = this.revisarPrimaryKey(innerArray , indiceActualizar , casteoNumerico(valor));
                   }
                   if (pass){
                        innerArray.add(casteoNumerico(valor));
                        cantidadUpdates++;
                   }
               }
               //si ya existe lo seteamos
               else{
                    if (unique) {
                        pass = this.revisarPrimaryKey(tabla.getDataInTable(), indiceActualizar, casteoNumerico(valor));
                    }
                    if (pass) {
                        
                        innerArray.set(indiceActualizar, casteoNumerico(valor));
                        cantidadUpdates++;
                    }
                    else{
                        tabla = null;
                        DBMS.throwMessage("Se ha actualizado 1 columna");
                        DBMS.throwMessage("Error: no ha pasado verificacion de primary key");
                    }
               }
           }
           //si no hay que hacer casteo
           else if (tipo.equals("DATE")){
               if (visitorAndres.verifyDate(valor))
               {
                   innerArray.set(indiceActualizar, valor);
                   cantidadUpdates++;
               } 
               else {
                       tabla = null;
                       DBMS.throwMessage("Error: fecha con formato inválido ");
                }
               
           }
           else if (tipo.equals("CHAR"))
           {   //hay que restar los 2 apostrofes del string
               if (valor.length()-2 > (int)array.get(2)){
                    tabla = null;
                   DBMS.throwMessage("Error: el tamaño del char se excede del límite establecido ");
               }
               else {
                    //si el indice a actualizar no existe, lo agregamos a la data
                    if (innerArray.size() < indiceActualizar+1){
                        innerArray.add(valor);
                        cantidadUpdates++;
                    }
                    //si ya existe lo seteamos
                    else{       
                        innerArray.set(indiceActualizar, valor);
                        cantidadUpdates++;
                    }
                }
           }
           else{
               //si el indice a actualizar no existe, lo agregamos a la data
                if (innerArray.size() < indiceActualizar+1){
                    innerArray.add(valor);
                    cantidadUpdates++;
                }
                //si ya existe lo seteamos
                else{       
                    innerArray.set(indiceActualizar, valor);
                    cantidadUpdates++;
                }
           }
        }
        
        DBMS.throwMessage("Se han actualizado " + cantidadUpdates + " columnas");
        } catch (Exception e){
            tabla = null;
            DBMS.throwMessage("Error: ha ingresado un tipo incorrecto");
        }
      
    }
    
    /**
     * Método para actualizar toda la data de una tabla
     * No considera where statement
     * @param nombreColumna
     * @param valor 
     */
    public void updateALLColumnTable(String nombreColumna, String valor){
        System.out.println("valor" + valor);
        ArrayList array = tabla.getIndexOfColumn(nombreColumna);
        System.out.println(array);
        int indiceActualizar = (int)array.get(0);
        String tipo = (String)array.get(1);
      
        boolean unique = tabla.checkPrimaryKey(nombreColumna);
        boolean pass = true;
        
        try {
        //recorrer toda la data en la tabla
        int cantidadUpdates = 0;
        for (int i = 0;i<tabla.getDataInTable().size();i++){
            ArrayList innerArray = tabla.getDataInTable().get(i);
            //si es numérico hay que hacer casteo 
           if (tipo.equals("INT")||tipo.equals("FLOAT")) {
               
                //si el indice a actualizar no existe, lo agregamos a la data
               if (innerArray.size() < indiceActualizar+1) {
                   if (unique){
                       pass = this.revisarPrimaryKey(innerArray , indiceActualizar , casteoNumerico(valor));
                   }
                   if (pass){
                        innerArray.add(casteoNumerico(valor));
                        cantidadUpdates++;
                   }
               }
               //si ya existe lo seteamos
               else{
                    if (unique) {
                        pass = this.revisarPrimaryKey(tabla.getDataInTable(), indiceActualizar, casteoNumerico(valor));
                    }
                    if (pass) {
                        
                        innerArray.set(indiceActualizar, casteoNumerico(valor));
                        cantidadUpdates++;
                    }
                    else{
                        tabla = null;
                        DBMS.throwMessage("Se ha actualizado 1 columna");
                        DBMS.throwMessage("Error: no ha pasado verificacion de primary key");
                    }
               }
           }
           //si no hay que hacer casteo
           else if (tipo.equals("DATE")){
               if (visitorAndres.verifyDate(valor))
               {
                   innerArray.set(indiceActualizar, valor);
                   cantidadUpdates++;
               } 
               else {
                       tabla = null;
                       DBMS.throwMessage("Error: fecha con formato inválido ");
                }
               
           }
           else if (tipo.equals("CHAR"))
           {   //hay que restar los 2 apostrofes del string
               if (valor.length()-2 > (int)array.get(2)){
                    tabla = null;
                   DBMS.throwMessage("Error: el tamaño del char se excede del límite establecido ");
               }
               else {
                    //si el indice a actualizar no existe, lo agregamos a la data
                    if (innerArray.size() < indiceActualizar+1){
                        innerArray.add(valor);
                        cantidadUpdates++;
                    }
                    //si ya existe lo seteamos
                    else{       
                        innerArray.set(indiceActualizar, valor);
                        cantidadUpdates++;
                    }
                }
           }
           else{
               //si el indice a actualizar no existe, lo agregamos a la data
                if (innerArray.size() < indiceActualizar+1){
                    innerArray.add(valor);
                    cantidadUpdates++;
                }
                //si ya existe lo seteamos
                else{       
                    innerArray.set(indiceActualizar, valor);
                    cantidadUpdates++;
                }
           }
        }
        
        DBMS.throwMessage("Se han actualizado " + cantidadUpdates + " columnas");
        } catch (Exception e){
            tabla = null;
            DBMS.throwMessage("Error: ha ingresado un tipo incorrecto");
        }
      
    }
    
    public T casteoNumerico(String valor){
        if (valor.equals("NULL")){
            return (T)"NULL";
        }
        return (T)Double.valueOf(valor);
    }
    
    public boolean revisarPrimaryKey(ArrayList valoresActuales, int indexActualiar, T valorNuevo){
      
        for (int i = 0;i < valoresActuales.size();i++){
            ArrayList innerArray = tabla.getDataInTable().get(i);
           
            if (innerArray.get(indexActualiar).equals(valorNuevo)){
               return false;
               
            }
        }
        
        return true;
    }
  
          
    /**
     * Método para verificar si existe una columna en una tabla
     * UPDATE statement
     * @param nombreColumna
     * @return boolean
     */
    public boolean verificarColumnaUpdate(String nombreColumna){
        boolean verificadorColumna = false;
        if (tabla != null) {
            for(TuplaColumna columna : tabla.getColumnas()) {
             
                if (columna.getNombre().equals(nombreColumna)) {
                    verificadorColumna = true;
                }
            }
        }
     
        //si es false no existe, si es true si existe.
        return verificadorColumna;
    }



    @Override
    public Object visitIdentifier_update(sqlParser.Identifier_updateContext ctx) {
       if(ctx.getChildCount()>1){
            String nombreTabla = ctx.getChild(0).getText();
            String nombreColumna = ctx.getChild(2).getText();
            Tabla tablaLocal = (Tabla) json.JSONtoObject(bdActual, nombreTabla, "Tabla");
            if(visitorPablo.tableExist(nombreTabla)<0){
                DBMS.throwMessage( "Error: La tabla: "+nombreTabla+" no existe en la base de datos "+ bdActual, ctx.getStart());
                return "error";
            }
            int indiceColumna = visitorPablo.columnExist(nombreTabla, nombreColumna);
            if(indiceColumna<0){
                DBMS.throwMessage( "Error: La Columna: "+nombreColumna+" no existe en la tabla "+ nombreTabla, ctx.getStart());
                return "error";
            }
            return tablaLocal.getColumnas().get(indiceColumna).getTipo();
        }else{
            String contenido = ctx.getChild(0).getText();
            try {

                Integer.parseInt(contenido);
                return "INT";
            } catch (NumberFormatException e) {
                System.out.println(contenido+ " contenido");
                if(contenido.contains("\'")){
                    if(!contenido.startsWith("\'")){
                        DBMS.throwMessage( "String o char debe comenzar con \'", ctx.getStart());
                        return "error";
                    }else
                        if(!contenido.endsWith("\'")){
                            DBMS.throwMessage( "String o char debe terminar con \'", ctx.getStart());
                            return "error";
                        }else if (this.countOccurrences(contenido, '-')==2){
                            return "DATE";
                        }
                        else
                            return "CHAR";
                }
                else if (contenido.equals("NULL")){
                    return "NULL";
                }
                else{
                    String nombrePapa = ctx.getParent().getParent().getParent().getParent().getChild(0).getText();
                    String nombreTabla = "";

                    if(nombrePapa.equals("delete")||nombrePapa.equals("DELETE")){
                        nombreTabla = ctx.getParent().getParent().getParent().getParent().getChild(2).getText();
                        this.columnas.push(contenido);
                    }
                    else
                        if(nombrePapa.equals("update")||nombrePapa.equals("UPDATE"))
                            nombreTabla = ctx.getParent().getParent().getParent().getParent().getChild(1).getText();
                    int indiceColumna = visitorPablo.columnExist(nombreTabla,contenido);
                    if(indiceColumna<0){
                        DBMS.throwMessage( "Error: La Columna: "+contenido+" no existe en la tabla ", ctx.getStart());
                        return "error";
                    }
                    return tabla.getColumnas().get(indiceColumna).getTipo();
                    //System.out.println(contenido.charAt(0));
                    //DBMS.throwMessage( "Error de referencia, debe ir de la forma tabla.columna ", ctx.getStart());
                   // return "ID";
                }
             }

        }//To change body of generated methods, choose Tools | Templates.
    }
    
        @Override
    public Object visitFinal_where_update(sqlParser.Final_where_updateContext ctx) {
        ArrayList indexes = new ArrayList();
         String nombrePapa = ctx.getParent().getChild(0).getText();
        String nombreTabla = "";
        if(nombrePapa.equals("delete")||nombrePapa.equals("DELETE"))
            nombreTabla = ctx.getParent().getChild(2).getText();
        else
            if(nombrePapa.equals("update")||nombrePapa.equals("UPDATE"))
                nombreTabla = ctx.getParent().getChild(1).getText();
            else
                nombreTabla = ctx.getParent().getChild(3).getText();
        Tabla tabla = (Tabla) json.JSONtoObject(bdActual, nombreTabla, "Tabla");
        for(int i = 0;i<ctx.getChildCount();i++){
            indexes = (ArrayList) this.visit(ctx.getChild(i));
            indexActuales = indexes;
        }
            System.out.println(indexes);
        return indexes;
    }
  
    
    @Override
    public Object visitFirst_where_statement_update(sqlParser.First_where_statement_updateContext ctx) {
        indexActuales = new ArrayList();
        String nombrePapa = ctx.getParent().getParent().getChild(0).getText();
        String nombreTabla = "";
        if(nombrePapa.equals("delete"))
            nombreTabla = ctx.getParent().getParent().getChild(2).getText();
        else
            if(nombrePapa.equals("update"))
                nombreTabla = ctx.getParent().getParent().getChild(1).getText();
            else
                nombreTabla = ctx.getParent().getParent().getChild(3).getText();
        Tabla tabla = (Tabla) json.JSONtoObject(bdActual, nombreTabla, "Tabla");
        for(int i = 0;i<tabla.getDataInTable().size();i++)
            indexActuales.add(i);
        return (ArrayList) this.visit(ctx.getChild(0));
    }
     
     @Override
    public Object visitWhere_statement_update(sqlParser.Where_statement_updateContext ctx) {
         String nombrePapa = ctx.getParent().getParent().getChild(0).getText();
        String nombreTabla = "";
        if(nombrePapa.equals("delete"))
            nombreTabla = ctx.getParent().getParent().getChild(2).getText();
        else
            if(nombrePapa.equals("update"))
                nombreTabla = ctx.getParent().getParent().getChild(1).getText();
            else
                nombreTabla = ctx.getParent().getParent().getChild(3).getText();
        Tabla tabla = (Tabla) json.JSONtoObject(bdActual, nombreTabla, "Tabla");
        String logic = ctx.getChild(0).getText().toLowerCase();
        ArrayList indexReturn = new ArrayList();
        indexReturn.addAll(indexActuales);
        if(logic.equals("or")){
            indexActuales = new ArrayList();
            for(int i = 0;i<tabla.getDataInTable().size();i++)
                indexActuales.add(i);
            indexReturn.addAll((ArrayList) this.visit(ctx.getChild(1)));
            return indexReturn;
        }else
            if(logic.equals("and")){
               return (ArrayList) this.visit(ctx.getChild(1)); 
            }
        return null;
    }

    @Override
    public Object visitCondition_update(sqlParser.Condition_updateContext ctx) {
        String nombrePapa = ctx.getParent().getParent().getParent().getChild(0).getText();
        String nombreTabla = "";
        if(nombrePapa.equals("delete")||nombrePapa.equals("DELETE"))
            nombreTabla = ctx.getParent().getParent().getParent().getChild(2).getText();
        else
            if(nombrePapa.equals("update")|nombrePapa.equals("UPDATE"))
                nombreTabla = ctx.getParent().getParent().getParent().getChild(1).getText();
            else
                nombreTabla = ctx.getParent().getParent().getParent().getChild(3).getText();
        Tabla tabla = (Tabla) json.JSONtoObject(bdActual, nombreTabla, "Tabla");
        String op1 =(String) (this.visit(ctx.getChild(0)));
        op1 = op1.toUpperCase();
        String op2 =(String) (this.visit(ctx.getChild(2)));
        op2 = op2.toUpperCase();
        String operacion = ctx.getChild(1).getText();
        System.out.println(op1);
        System.out.println(op2);
        boolean op1Value = false;
        boolean op2Value = false;
        if(ctx.getChild(0).getText().contains("\'"))
            op1Value = true;
        else
             try {
                Integer.parseInt(ctx.getChild(0).getText());
                op1Value = true;
            } catch (NumberFormatException e) {
                op1Value = false;
            }
         if(ctx.getChild(2).getText().contains("\'"))
            op2Value = true;
        else
             try {
                Integer.parseInt(ctx.getChild(2).getText());
                op2Value = true;
            } catch (NumberFormatException e) {
                op2Value = false;
            }
            
        String x = ctx.getChild(0).getText();String z = ctx.getChild(2).getText();
        //CAMBIAR CAMBIAR CAMBIAR CAMBIAR CAMBIAR EL RETURN
        if(!op1.equals(op2)&&!op1.equals("NULL")&&!op2.equals("NULL")){
            DBMS.throwMessage( "Error: La comparación no se realizó con los mismos tipos de variables", ctx.getStart());
            return "error";
        }
        
        op1IsValue = false;
        op2IsValue = false;
        
        //la columna esta en el primero y no en el segundo
        ArrayList registro = new ArrayList();
        ArrayList listaFinal = new ArrayList();
        if(!op1Value&&op2Value){
            int columna = visitorPablo.columnExist(nombreTabla,ctx.getChild(0).getChild(0).getText());
            for(int i = 0;i<indexActuales.size();i++){
                registro = tabla.getDataInTable().get((int)indexActuales.get(i));
                switch(operacion){
                    case "<":
                        if(op1.equals("INT")){
                            try{
                               int operador2 = Integer.parseInt(ctx.getChild(2).getText());
                               int operador1 =(int)Math.round((Double) registro.get(columna));
                               if(operador1<operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                
                            }
                           
                        }else if (op1.equals("DATE")){
                            String operador1 = ctx.getChild(2).getText();
                            String operador2 = (String)registro.get(columna);
                            //para comparar fechas se utiliza una clase de java
                            //y hay que quitar los apostrofes
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            operador1  = operador1.replaceAll("\'", "");
                            operador1  = operador1.replaceAll("\"", "");
                            operador2  = operador2.replaceAll("\'", "");
                            operador2  = operador2.replaceAll("\"", "");
                            try{
                                Date date1 = sdf.parse(operador1);
                                Date date2 = sdf.parse(operador2);
                                if (date2.compareTo(date1)<0){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }catch(Exception e){
                                System.out.println("error fecha");
                            }
                        }
                        
                        else{
                            DBMS.throwMessage( "Error: la comparacion < solo se puede entre int", ctx.getStart());
                            return "error";
                        }
                    break;
                    case "<=":
                        if(op1.equals("INT")){
                             try{
                               int operador2 = Integer.parseInt(ctx.getChild(2).getText());
                               int operador1 =(int)Math.round((Double) registro.get(columna));
                               if(operador1<=operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                
                            }
                           
                        }else if (op1.equals("DATE")){
                             String operador1 = ctx.getChild(2).getText();
                            String operador2 = (String)registro.get(columna);
                               //para comparar fechas se utiliza una clase de java
                            //y hay que quitar los apostrofes
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            operador1  = operador1.replaceAll("\'", "");
                            operador1  = operador1.replaceAll("\"", "");
                            operador2  = operador2.replaceAll("\'", "");
                            operador2  = operador2.replaceAll("\"", "");
                            try{
                                Date date1 = sdf.parse(operador1);
                                Date date2 = sdf.parse(operador2);
                                if (date2.compareTo(date1)<=0){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }catch(Exception e){
                                
                            }
                        }
                        else{
                           DBMS.throwMessage( "Error: la comparacion <= solo se puede entre int o dates", ctx.getStart());
                            return "error";
                        }
                    case ">":
                        if(op1.equals("INT")){
                            try{
                               int operador2 = Integer.parseInt(ctx.getChild(2).getText());
                               int operador1 =(int)Math.round((Double) registro.get(columna));
                               if(operador1>operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                
                            }
                         
                        }else if (op1.equals("DATE")){
                            String operador1 = ctx.getChild(2).getText();
                            String operador2 = (String)registro.get(columna);
                            //para comparar fechas se utiliza una clase de java
                            //y hay que quitar los apostrofes
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            operador1  = operador1.replaceAll("\'", "");
                            operador1  = operador1.replaceAll("\"", "");
                            operador2  = operador2.replaceAll("\'", "");
                            operador2  = operador2.replaceAll("\"", "");
                            try{
                                Date date1 = sdf.parse(operador1);
                                Date date2 = sdf.parse(operador2);
                                if (date2.compareTo(date1)>0){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }catch(Exception e){
                                
                            }
                        }
                        else{
                             DBMS.throwMessage( "Error: la comparacion > solo se puede entre int o dates", ctx.getStart());
                            return "error";
                        }
                    break;
                    case ">=":
                        if(op1.equals("INT")){
                            try{
                               int operador2 = Integer.parseInt(ctx.getChild(2).getText());
                               int operador1 =(int)Math.round((Double) registro.get(columna));
                               if(operador1>=operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                
                            }
                        }
                        else if(op1.equals("DATE")){
                            String operador1 = ctx.getChild(2).getText();
                            String operador2 = (String)registro.get(columna);
                            //para comparar fechas se utiliza una clase de java
                            //y hay que quitar los apostrofes
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            operador1  = operador1.replaceAll("\'", "");
                            operador1  = operador1.replaceAll("\"", "");
                            operador2  = operador2.replaceAll("\'", "");
                            operador2  = operador2.replaceAll("\"", "");
                            try{
                                Date date1 = sdf.parse(operador1);
                                Date date2 = sdf.parse(operador2);
                               
                                if (date2.compareTo(date1)>=0){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }catch(Exception e){
                                e.printStackTrace();
                                System.out.println("Error fecha");
                            }
                        }
                        else{
                              DBMS.throwMessage( "Error: la comparacion >= solo se puede entre int o date", ctx.getStart());
                            return "error";
                        }
                    break;
                    case "<>":
                        if(op1.equals("INT")){
                            try{
                               int operador2 = Integer.parseInt(ctx.getChild(2).getText());
                               int operador1 =(int)Math.round((Double) registro.get(columna));
                               if(operador1!=operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                String operador1 = ctx.getChild(2).getText();
                                String operador2 = (String)registro.get(columna);

                                if (!operador1.equals(operador2)){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }
                        }else if (op1.equals("CHAR")||op1.equals("DATE") ){
                            String operador1 = ctx.getChild(2).getText();
                            String operador2 = (String)registro.get(columna);
                            if (!operador1.equals(operador2)){
                                listaFinal.add(indexActuales.get(i));
                            }
                        }
                        else
                            if(!Integer.toString((int)Math.round((Double) registro.get(columna))).equals(ctx.getChild(2).getText())){
                                listaFinal.add(indexActuales.get(i));
                            }
                    break;
                    case "!=":
                        if(op1.equals("INT")){
                            try{
                               int operador2 = Integer.parseInt(ctx.getChild(2).getText());
                               int operador1 =(int)Math.round((Double) registro.get(columna));
                               if(operador1!=operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                String operador1 = ctx.getChild(2).getText();
                                String operador2 = (String)registro.get(columna);

                                if (!operador1.equals(operador2)){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }
                        }else if (op1.equals("CHAR")||op1.equals("DATE")){
                            String operador1 = ctx.getChild(2).getText();
                            String operador2 = (String)registro.get(columna);
                            if (!operador1.equals(operador2)){
                                listaFinal.add(indexActuales.get(i));
                            }
                        }else
                            if(!Integer.toString((int)Math.round((Double) registro.get(columna))).equals(ctx.getChild(2).getText())){
                                listaFinal.add(indexActuales.get(i));
                            }
                    break;
                    case "=":
                        if(op1.equals("INT")){
                            Object reg = registro.get(columna);
                            if (!reg.equals("NULL")){
                                int operador2 = Integer.parseInt(ctx.getChild(2).getText());
                                int operador1 =(int)Math.round((Double)(reg));

                                if(operador1==operador2){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }
                            else{//si es NULL se trata como string
                                String operador1 = ctx.getChild(2).getText();
                                String operador2 = (String)registro.get(columna);

                                if (operador1.equals(operador2)){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }
                        }else if (op1.equals("CHAR")||op1.equals("DATE")){
                            String operador1 = ctx.getChild(2).getText();
                            String operador2 = (String)registro.get(columna);
                        
                            if (operador1.equals(operador2)){
                                listaFinal.add(indexActuales.get(i));
                            }
                        }
                        else
                            if(Integer.toString((int)Math.round((Double) registro.get(columna))).equals(ctx.getChild(2).getText())){
                                listaFinal.add(indexActuales.get(i));
                            }
                    break;
                }
            }
        }
        //la columna no esta en el primero sino que en el segundo 
        if(op1Value&&!op2Value){
            int columna = visitorPablo.columnExist(nombreTabla,ctx.getChild(2).getChild(0).getText());
            for(int i = 0;i<indexActuales.size();i++){
                registro = tabla.getDataInTable().get((int)indexActuales.get(i));
                switch(operacion){
                    case "<":
                        if(op1.equals("INT")){
                            try{
                               int operador1 = Integer.parseInt(ctx.getChild(0).getText());
                               int operador2 =(int)Math.round((Double) registro.get(columna));
                               if(operador1<operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                
                            }
                           
                        }else if (op1.equals("DATE")){
                            String operador2 = ctx.getChild(0).getText();
                            String operador1 = (String)registro.get(columna);
                            //para comparar fechas se utiliza una clase de java
                            //y hay que quitar los apostrofes
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            operador1  = operador1.replaceAll("\'", "");
                            operador1  = operador1.replaceAll("\"", "");
                            operador2  = operador2.replaceAll("\'", "");
                            operador2  = operador2.replaceAll("\"", "");
                            try{
                                Date date1 = sdf.parse(operador1);
                                Date date2 = sdf.parse(operador2);
                                if (date2.compareTo(date1)<0){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }catch(Exception e){
                                System.out.println("error fecha");
                            }
                        }
                        
                        else{
                            DBMS.throwMessage( "Error: la comparacion < solo se puede entre int", ctx.getStart());
                            return "error";
                        }
                    break;
                    case "<=":
                        if(op1.equals("INT")){
                             try{
                               int operador1 = Integer.parseInt(ctx.getChild(0).getText());
                               int operador2 =(int)Math.round((Double) registro.get(columna));
                               if(operador1<=operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                
                            }
                           
                        }else if (op1.equals("DATE")){
                             String operador2 = ctx.getChild(0).getText();
                            String operador1 = (String)registro.get(columna);
                               //para comparar fechas se utiliza una clase de java
                            //y hay que quitar los apostrofes
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            operador1  = operador1.replaceAll("\'", "");
                            operador1  = operador1.replaceAll("\"", "");
                            operador2  = operador2.replaceAll("\'", "");
                            operador2  = operador2.replaceAll("\"", "");
                            try{
                                Date date1 = sdf.parse(operador1);
                                Date date2 = sdf.parse(operador2);
                                if (date2.compareTo(date1)<=0){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }catch(Exception e){
                                
                            }
                        }
                        else{
                           DBMS.throwMessage( "Error: la comparacion <= solo se puede entre int o dates", ctx.getStart());
                            return "error";
                        }
                    case ">":
                        if(op1.equals("INT")){
                            try{
                               int operador1 = Integer.parseInt(ctx.getChild(0).getText());
                               int operador2 =(int)Math.round((Double) registro.get(columna));
                               if(operador1>operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                
                            }
                         
                        }else if (op1.equals("DATE")){
                            String operador2 = ctx.getChild(0).getText();
                            String operador1 = (String)registro.get(columna);
                            //para comparar fechas se utiliza una clase de java
                            //y hay que quitar los apostrofes
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            operador1  = operador1.replaceAll("\'", "");
                            operador1  = operador1.replaceAll("\"", "");
                            operador2  = operador2.replaceAll("\'", "");
                            operador2  = operador2.replaceAll("\"", "");
                            try{
                                Date date1 = sdf.parse(operador1);
                                Date date2 = sdf.parse(operador2);
                                if (date2.compareTo(date1)>0){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }catch(Exception e){
                                
                            }
                        }
                        else{
                             DBMS.throwMessage( "Error: la comparacion > solo se puede entre int o dates", ctx.getStart());
                            return "error";
                        }
                    break;
                    case ">=":
                        if(op1.equals("INT")){
                            try{
                               int operador1 = Integer.parseInt(ctx.getChild(0).getText());
                               int operador2 =(int)Math.round((Double) registro.get(columna));
                               if(operador1>=operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                
                            }
                        }
                        else if(op1.equals("DATE")){
                            String operador2 = ctx.getChild(0).getText();
                            String operador1 = (String)registro.get(columna);
                            //para comparar fechas se utiliza una clase de java
                            //y hay que quitar los apostrofes
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            operador1  = operador1.replaceAll("\'", "");
                            operador1  = operador1.replaceAll("\"", "");
                            operador2  = operador2.replaceAll("\'", "");
                            operador2  = operador2.replaceAll("\"", "");
                            try{
                                Date date1 = sdf.parse(operador1);
                                Date date2 = sdf.parse(operador2);
                               
                                if (date2.compareTo(date1)>=0){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }catch(Exception e){
                                e.printStackTrace();
                                System.out.println("Error fecha");
                            }
                        }
                        else{
                              DBMS.throwMessage( "Error: la comparacion >= solo se puede entre int o date", ctx.getStart());
                            return "error";
                        }
                    break;
                    case "<>":
                        if(op1.equals("INT")){
                            try{
                               int operador1 = Integer.parseInt(ctx.getChild(0).getText());
                               int operador2 =(int)Math.round((Double) registro.get(columna));
                               if(operador1!=operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                String operador2 = ctx.getChild(0).getText();
                                String operador1 = (String)registro.get(columna);

                                if (!operador1.equals(operador2)){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }
                        }else if (op1.equals("CHAR")||op1.equals("DATE") ){
                            String operador2 = ctx.getChild(0).getText();
                            String operador1 = (String)registro.get(columna);
                            if (!operador1.equals(operador2)){
                                listaFinal.add(indexActuales.get(i));
                            }
                        }
                        else
                            if(!Integer.toString((int)Math.round((Double) registro.get(columna))).equals(ctx.getChild(2).getText())){
                                listaFinal.add(indexActuales.get(i));
                            }
                    break;
                    case "!=":
                        if(op1.equals("INT")){
                            try{
                               int operador1 = Integer.parseInt(ctx.getChild(0).getText());
                               int operador2 =(int)Math.round((Double) registro.get(columna));
                               if(operador1!=operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                String operador2 = ctx.getChild(0).getText();
                                String operador1 = (String)registro.get(columna);

                                if (!operador1.equals(operador2)){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }
                        }else if (op1.equals("CHAR")||op1.equals("DATE")){
                            String operador2 = ctx.getChild(0).getText();
                            String operador1 = (String)registro.get(columna);
                            if (!operador1.equals(operador2)){
                                listaFinal.add(indexActuales.get(i));
                            }
                        }else
                            if(!Integer.toString((int)Math.round((Double) registro.get(columna))).equals(ctx.getChild(2).getText())){
                                listaFinal.add(indexActuales.get(i));
                            }
                    break;
                    case "=":
                        if(op1.equals("INT")){
                            Object reg = registro.get(columna);
                            if (!reg.equals("NULL")){
                                int operador1 = Integer.parseInt(ctx.getChild(0).getText());
                                int operador2 =(int)Math.round((Double)(reg));

                                if(operador1==operador2){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }
                            else{//si es NULL se trata como string
                                String operador2 = ctx.getChild(0).getText();
                                String operador1 = (String)registro.get(columna);

                                if (operador1.equals(operador2)){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }
                        }else if (op1.equals("CHAR")||op1.equals("DATE")){
                            String operador2 = ctx.getChild(0).getText();
                            String operador1 = (String)registro.get(columna);
                        
                            if (operador1.equals(operador2)){
                                listaFinal.add(indexActuales.get(i));
                            }
                        }
                        else
                            if(Integer.toString((int)Math.round((Double) registro.get(columna))).equals(ctx.getChild(2).getText())){
                                listaFinal.add(indexActuales.get(i));
                            }
                    break;
                }
            }
        }
        //la columna  esta en el primero y en el segundo 
        if(!op1Value&&!op2Value){
            int columna1 = visitorPablo.columnExist(nombreTabla,ctx.getChild(0).getChild(0).getText());
            int columna2= visitorPablo.columnExist(nombreTabla,ctx.getChild(2).getChild(0).getText());
            for(int i = 0;i<indexActuales.size();i++){
                registro = tabla.getDataInTable().get((int)indexActuales.get(i));
                switch(operacion){
                    case "<":
                        if(op1.equals("INT")){
                            try{
                               int operador1 =(int)Math.round((Double) registro.get(columna1));
                               int operador2 =(int)Math.round((Double) registro.get(columna2));
                               if(operador1<operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                
                            }
                           
                        }else if (op1.equals("DATE")){
                            String operador1 = (String)registro.get(columna1);
                            String operador2 = (String)registro.get(columna2);
                            //para comparar fechas se utiliza una clase de java
                            //y hay que quitar los apostrofes
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            operador1  = operador1.replaceAll("\'", "");
                            operador1  = operador1.replaceAll("\"", "");
                            operador2  = operador2.replaceAll("\'", "");
                            operador2  = operador2.replaceAll("\"", "");
                            try{
                                Date date1 = sdf.parse(operador1);
                                Date date2 = sdf.parse(operador2);
                                if (date2.compareTo(date1)<0){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }catch(Exception e){
                                System.out.println("error fecha");
                            }
                        }
                        
                        else{
                            DBMS.throwMessage( "Error: la comparacion < solo se puede entre int", ctx.getStart());
                            return "error";
                        }
                    break;
                    case "<=":
                        if(op1.equals("INT")){
                             try{
                               int operador1 =(int)Math.round((Double) registro.get(columna1));
                               int operador2 =(int)Math.round((Double) registro.get(columna2));
                               if(operador1<=operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                
                            }
                           
                        }else if (op1.equals("DATE")){
                            String operador1 = (String)registro.get(columna1);
                            String operador2 = (String)registro.get(columna2);
                               //para comparar fechas se utiliza una clase de java
                            //y hay que quitar los apostrofes
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            operador1  = operador1.replaceAll("\'", "");
                            operador1  = operador1.replaceAll("\"", "");
                            operador2  = operador2.replaceAll("\'", "");
                            operador2  = operador2.replaceAll("\"", "");
                            try{
                                Date date1 = sdf.parse(operador1);
                                Date date2 = sdf.parse(operador2);
                                if (date2.compareTo(date1)<=0){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }catch(Exception e){
                                
                            }
                        }
                        else{
                           DBMS.throwMessage( "Error: la comparacion <= solo se puede entre int o dates", ctx.getStart());
                            return "error";
                        }
                    case ">":
                        if(op1.equals("INT")){
                            try{
                               int operador1 =(int)Math.round((Double) registro.get(columna1));
                               int operador2 =(int)Math.round((Double) registro.get(columna2));
                               if(operador1>operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                
                            }
                         
                        }else if (op1.equals("DATE")){
                            String operador1 = (String)registro.get(columna1);
                            String operador2 = (String)registro.get(columna2);
                            //para comparar fechas se utiliza una clase de java
                            //y hay que quitar los apostrofes
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            operador1  = operador1.replaceAll("\'", "");
                            operador1  = operador1.replaceAll("\"", "");
                            operador2  = operador2.replaceAll("\'", "");
                            operador2  = operador2.replaceAll("\"", "");
                            try{
                                Date date1 = sdf.parse(operador1);
                                Date date2 = sdf.parse(operador2);
                                if (date2.compareTo(date1)>0){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }catch(Exception e){
                                
                            }
                        }
                        else{
                             DBMS.throwMessage( "Error: la comparacion > solo se puede entre int o dates", ctx.getStart());
                            return "error";
                        }
                    break;
                    case ">=":
                        if(op1.equals("INT")){
                            try{
                               int operador1 =(int)Math.round((Double) registro.get(columna1));
                               int operador2 =(int)Math.round((Double) registro.get(columna2));
                               if(operador1>=operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                
                            }
                        }
                        else if(op1.equals("DATE")){
                            String operador1 = (String)registro.get(columna1);
                            String operador2 = (String)registro.get(columna2);
                            //para comparar fechas se utiliza una clase de java
                            //y hay que quitar los apostrofes
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            operador1  = operador1.replaceAll("\'", "");
                            operador1  = operador1.replaceAll("\"", "");
                            operador2  = operador2.replaceAll("\'", "");
                            operador2  = operador2.replaceAll("\"", "");
                            try{
                                Date date1 = sdf.parse(operador1);
                                Date date2 = sdf.parse(operador2);
                               
                                if (date2.compareTo(date1)>=0){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }catch(Exception e){
                                e.printStackTrace();
                                System.out.println("Error fecha");
                            }
                        }
                        else{
                              DBMS.throwMessage( "Error: la comparacion >= solo se puede entre int o date", ctx.getStart());
                            return "error";
                        }
                    break;
                    case "<>":
                        if(op1.equals("INT")){
                            try{
                               int operador1 =(int)Math.round((Double) registro.get(columna1));
                               int operador2 =(int)Math.round((Double) registro.get(columna2));
                               if(operador1!=operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                String operador1 = (String)registro.get(columna1);
                                String operador2 = (String)registro.get(columna2);

                                if (!operador1.equals(operador2)){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }
                        }else if (op1.equals("CHAR")||op1.equals("DATE") ){
                            String operador1 = (String)registro.get(columna1);
                            String operador2 = (String)registro.get(columna2);
                            if (!operador1.equals(operador2)){
                                listaFinal.add(indexActuales.get(i));
                            }
                        }
                        else
                            if(!Integer.toString((int)Math.round((Double) registro.get(columna1))).equals(Integer.toString((int)Math.round((Double) registro.get(columna2))))){
                                listaFinal.add(indexActuales.get(i));
                            }
                    break;
                    case "!=":
                        if(op1.equals("INT")){
                            try{
                               int operador1 =(int)Math.round((Double) registro.get(columna1));
                               int operador2 =(int)Math.round((Double) registro.get(columna2));
                               if(operador1!=operador2){
                                   listaFinal.add(indexActuales.get(i));
                            }
                            }catch(ClassCastException e){
                                String operador1 = (String)registro.get(columna1);
                                String operador2 = (String)registro.get(columna2);

                                if (!operador1.equals(operador2)){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }
                        }else if (op1.equals("CHAR")||op1.equals("DATE")){
                            String operador1 = (String)registro.get(columna1);
                            String operador2 = (String)registro.get(columna2);
                            if (!operador1.equals(operador2)){
                                listaFinal.add(indexActuales.get(i));
                            }
                        }else
                            if(!Integer.toString((int)Math.round((Double) registro.get(columna1))).equals(Integer.toString((int)Math.round((Double) registro.get(columna2))))){
                                listaFinal.add(indexActuales.get(i));
                            }
                    break;
                    case "=":
                        if(op1.equals("INT")){
                            Object reg = registro.get(columna1);
                            if (!reg.equals("NULL")||registro.get(columna2).equals("NULL")){
                                int operador1 =(int)Math.round((Double) registro.get(columna1));
                                int operador2 =(int)Math.round((Double) registro.get(columna2));

                                if(operador1==operador2){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }
                            else{//si es NULL se trata como string
                                String operador1 = (String)registro.get(columna1);
                                String operador2 = (String)registro.get(columna2);

                                if (operador1.equals(operador2)){
                                    listaFinal.add(indexActuales.get(i));
                                }
                            }
                        }else if (op1.equals("CHAR")||op1.equals("DATE")){
                            String operador1 = (String)registro.get(columna1);
                            String operador2 = (String)registro.get(columna2);
                        
                            if (operador1.equals(operador2)){
                                listaFinal.add(indexActuales.get(i));
                            }
                        }
                        else
                            if(Integer.toString((int)Math.round((Double) registro.get(columna1))).equals(Integer.toString((int)Math.round((Double) registro.get(columna2))))){
                                listaFinal.add(indexActuales.get(i));
                            }
                    break;
                }
            }
        }
        indexActuales = new ArrayList();
        return listaFinal;
    }
    
    
      public int columnExistActual(String nombreColumna){
       
        for(int i = 0;i<tabla.getColumnas().size();i++)
            if(tabla.getColumnas().get(i).getNombre().equals(nombreColumna))
                return i;
        return -1;
    }
  
    public int countOccurrences(String haystack, char needle)
    {
        int count = 0;
        for (int i=0; i < haystack.length(); i++)
        {
            if (haystack.charAt(i) == needle)
            {
                 count++;
            }
        }

        return count;
    }

    @Override
    public Object visitDelete_value(sqlParser.Delete_valueContext ctx) {
     String nombreTabla = ctx.getChild(2).getText();
        if (bdActual.isEmpty()){
            DBMS.throwMessage("Error: no se ha seleccionado la base de datos");
            return null;
        }
        if (!manejador.checkFile(bdActual, nombreTabla)){
            DBMS.throwMessage("Error: la tabla "+ nombreTabla +" no existe", ctx.getStart());
            return null;
        }
        tabla = (Tabla)json.JSONtoObject(bdActual, nombreTabla, "Tabla");
        //visitar todas las reglas de los hijos antes de guardar la tabla actualizada
        super.visitDelete_value(ctx);
        //revisar foreign key 
        ArchivoMaestroTabla masterTable = (ArchivoMaestroTabla) json.JSONtoObject(bdActual, "MasterTable"+bdActual, "ArchivoMaestroTabla");
        for(int i = 0;i<masterTable.getTablas().size();i++){
            Tabla tab=(Tabla)json.JSONtoObject(bdActual, masterTable.getTablas().get(i).getNombreTabla(), "Tabla");
            for(int j = 0;j<tab.getConstraints().size();j++){
                if(tab.getConstraints().get(j).getTipo().toUpperCase().equals("FOREIGN")){
                        if(tab.getConstraints().get(j).getReferencesForeign().getNombreTablaRef().equals(nombreTabla)){
                            for(int p = 0;p<tab.getConstraints().get(j).getReferences().size();p++){
                                String columnaForeign = tab.getConstraints().get(j).getReferencesForeign().getReferencesForeign().get(p);
                                int temp = 0;
                                for(int h = 0;h<tab.getColumnas().size();h++){
                                    if(tab.getColumnas().get(h).getNombre().equals(tab.getConstraints().get(j).getReferences().get(p)))
                                        temp = h;
                                } 
                                int index2 = 0;
                                for(int h = 0;h<tabla.getColumnas().size();h++){
                                    if(tabla.getColumnas().get(h).getNombre().equals(tab.getConstraints().get(j).getReferencesForeign().getReferencesForeign().get(p)))
                                        index2 = h;
                                }
                                for(int h = 0;h<indexActuales.size();h++){
                                    for(int y = 0;y<tab.getDataInTable().size();y++){
                                        T valor1 = (T)tab.getDataInTable().get(y).get(temp);
                                        T valor2 = (T)tabla.getDataInTable().get((int)indexActuales.get(h)).get(index2);
                                        if(valor1.equals(valor2)){
                                            DBMS.throwMessage( "Error: La tabla: "+nombreTabla+" tiene referencias en otra(s) tablas sobre llaves foraneas, no se puede eliminar", ctx.getStart());
                                        return null;
                                        }
                                    }
                                }
                            }
                        }
                }
            }
        }
        while (!columnas.isEmpty())
            updateSelectedColumns((String)columnas.pop(),"NULL",this.indexActuales );
        //si no hubo errores, se guarda la data.
        if (tabla!= null){
             json.objectToJSON(bdActual, nombreTabla, tabla);
        }
        return null; //To change body of generated methods, choose Tools |    }
    
    }
    
    
    
  
}
