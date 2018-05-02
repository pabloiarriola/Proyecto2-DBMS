/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import antlr.sqlBaseVisitor;
import antlr.sqlParser;
import static dbms.ANTGui.bdActual;
import static dbms.ANTGui.jTable1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class VisitorPablo <T> extends sqlBaseVisitor {
    private JSONParser json = new JSONParser();
    private FileManager manejador = new FileManager();
    private String globalLogic ="";
    private ArrayList indexActuales = new ArrayList();
    private ArrayList<String> nombreTablas;
    private ArrayList indexGlobal = new ArrayList();
    private GeneralFunctions funciones = new GeneralFunctions();
    
    @Override
    public Object visitUse_schema_statement(sqlParser.Use_schema_statementContext ctx) {
        bdActual = ctx.getChild(2).getText();
        if (manejador.checkDB(bdActual)==false)
            bdActual = "";
        return super.visitUse_schema_statement(ctx); //To change body of generated methods, choose Tools | Templates.
    } 

    @Override
    public Object visitShow_schema_statement(sqlParser.Show_schema_statementContext ctx) {
        ArchivoMaestroDB ar = (ArchivoMaestroDB)json.JSONtoObject("","MasterDB" , "ArchivoMaestroDB");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[]{"Nombre de la BDD","Cantidad de tablas"});
        for(int i = 0;i<ar.getNombreDB().size();i++)
            model.addRow(new Object[]{ar.getNombreDB().get(i).getNombreDB(),ar.getNombreDB().get(i).getCantidadTablas()});
        return super.visitShow_schema_statement(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitDrop_table_statement(sqlParser.Drop_table_statementContext ctx) {
        String nombreTabla =  ctx.getChild(2).getText(); 
        int dialogResult = JOptionPane.showConfirmDialog (null, "¿SEGURO QUE DESEA ELIMINAR LA TABLA "+nombreTabla+" ?");
        if(dialogResult == JOptionPane.NO_OPTION || dialogResult == JOptionPane.CANCEL_OPTION){
            return super.visitDrop_table_statement(ctx); //To change body of generated methods, choose Tools | Templates.
        }
        //ir a buscar la tabla str 
        boolean check = manejador.checkFile(bdActual, nombreTabla);
        if (check ){
            ArchivoMaestroTabla ar = (ArchivoMaestroTabla)json.JSONtoObject(bdActual+"/", "MasterTable"+bdActual, "ArchivoMaestroTabla");
            Tabla tab = (Tabla)json.JSONtoObject(bdActual,nombreTabla , "Tabla");
            boolean existe = false;
            for(int i = 0; i<ar.getTablas().size();i++){
                String nombreTablaActual = ar.getTablas().get(i).getNombreTabla();
                if(!nombreTabla.equals(nombreTablaActual)){
                    tab = (Tabla)json.JSONtoObject(bdActual,nombreTablaActual , "Tabla");
                    for(int j = 0 ;j<tab.getConstraints().size();j++){
                        if(tab.getConstraints().get(j).getTipo().equals("foreign")){
                            if(tab.getConstraints().get(j).getReferencesForeign().getNombreTablaRef().equals(nombreTabla)){
                                existe = true;
                            }
                        }
                    }
                }
            }
            if(existe){
                DBMS.throwMessage( "ERROR: LA TABLA: "+nombreTabla+" TIENE REFERENCIA EN OTRA(S) TABLAS SOBRE LLAVES FORANEAS, NO SE PUEDE ELIMINAR ", ctx.getStart());
                return super.visitDrop_table_statement(ctx); //To change body of generated methods, choose Tools | Templates.
            }
          
            boolean eliminacion = manejador.deleteTable(bdActual, nombreTabla);
            if (eliminacion ){
                DBMS.throwMessage("SE HA ELIMINADO LA TABLA " + nombreTabla, ctx.getStart());
            }
            else{
                DBMS.throwMessage("ERROR: HA OCURRIDO UN PROBLEMA AL ELIMINAR LA TABLA " + nombreTabla, ctx.getStart());
            }
        
            for(int i = 0;i<ar.getTablas().size();i++){
                if(ar.getTablas().get(i).getNombreTabla().equals(nombreTabla))
                    ar.getTablas().remove(i);
            }
            json.objectToJSON(bdActual, "MasterTable"+bdActual, ar);
        }else
            DBMS.throwMessage( "ERROR: LA TABLA: "+nombreTabla+" NO EXISTE EN LA BASE DE DATOS  "+ bdActual, ctx.getStart());
        return super.visitDrop_table_statement(ctx); //To change body of generated methods, choose Tools | Templates.
    }  
    @Override
    public Object visitTipo_literal(sqlParser.Tipo_literalContext ctx) {
        if (ctx.getChild(0).getChildCount()>1){
            return ctx.getChild(0).getChild(0).getText()+"€" + ctx.getChild(0).getChild(2).getText();
        }
        
       return ctx.getChild(0).getChild(0).getText();//To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public Object visitAccionAddColumn(sqlParser.AccionAddColumnContext ctx) {
        String nombreTabla = ctx.getParent().getChild(2).getText();
        String nombreColumna = ctx.getChild(2).getText();
        String tipo = (String)visit(ctx.getChild(3));
        TuplaColumna tupla = new TuplaColumna();
        if (tipo.contains("€")){
            int tam = Integer.parseInt(tipo.substring(tipo.indexOf("€")+1));
            tupla.setTamaño(tam);
            tipo = tipo.substring(0,tipo.indexOf("€"));
        }
        Tabla tabla = (Tabla)json.JSONtoObject(bdActual,nombreTabla , "Tabla");
        boolean existe = false;
        for(int i = 0;i<tabla.getColumnas().size();i++) {
            if(tabla.getColumnas().get(i).getNombre().equals(nombreColumna)){
                existe = true;
                DBMS.throwMessage( "ERROR: LA COLUMNA: "+nombreColumna+" YA EXISTE EN LA TABLA"+ nombreTabla, ctx.getStart());
               
            }   
        }
        if(!existe){
            tupla.setNombre(nombreColumna);
            tupla.setTipo(tipo.toUpperCase());
            tabla.agregarColumna(tupla);
            for(int i = 0;i<tabla.getDataInTable().size();i++)
                tabla.getDataInTable().get(i).add("NULL");
            json.objectToJSON(bdActual, nombreTabla, tabla);
            DBMS.throwMessage( "LA COLUMNA: "+nombreColumna+" SE HA AGREGADO A LA TABLA: "+ nombreTabla, ctx.getStart());
        }
      return super.visitAccionAddColumn(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitAccionDropColumn(sqlParser.AccionDropColumnContext ctx) {
        String nombreTabla = ctx.getParent().getChild(2).getText();
        String nombreColumna = ctx.getChild(2).getText();
        Tabla tabla = (Tabla)json.JSONtoObject(bdActual,nombreTabla , "Tabla");
        boolean error = true;
        for(int i = 0;i<tabla.getColumnas().size();i++)
            if(tabla.getColumnas().get(i).getNombre().equals(nombreColumna))
                error = false;
        if(!error){
            ArchivoMaestroTabla ar = (ArchivoMaestroTabla)json.JSONtoObject(bdActual, "MasterTable"+bdActual, "ArchivoMaestroTabla");
            Tabla tab = (Tabla)json.JSONtoObject(bdActual,nombreTabla , "Tabla");
            boolean existe = false;
            ArrayList indices = new ArrayList();
            for(int i = 0; i<ar.getTablas().size();i++){
                String nombreTablaActual = ar.getTablas().get(i).getNombreTabla();
                if(!nombreTabla.equals(nombreTablaActual)){
                    tab = (Tabla)json.JSONtoObject(bdActual,nombreTablaActual , "Tabla");
                    for(int j = 0 ;j<tab.getConstraints().size();j++){
                        if(tab.getConstraints().get(j).getTipo().equals("foreign")){
                            if(tab.getConstraints().get(j).getReferencesForeign().getNombreTablaRef().equals(nombreTabla)&&tab.getConstraints().get(j).getReferencesForeign().getReferencesForeign().contains(nombreColumna)){
                                existe = true;
                                DBMS.throwMessage( "ERROR:LA COLUMNA: "+nombreColumna+" TIENE REFERENCIAS EN OTRA(S) TABLAS SOBRE LLAVES FORANEAS, NO SE PUEDE ELIMINAR ", ctx.getStart());
                                return super.visitAccionDropColumn(ctx); //To change body of generated methods, choose Tools | Templates.
                            }
                        }
                    }
                }else{
                    tab = (Tabla)json.JSONtoObject(bdActual,nombreTablaActual , "Tabla");
                    for(int j = 0 ;j<tab.getConstraints().size();j++){
                       if(tab.getConstraints().get(j).getTipo().equals("primary")){
                            if(tab.getConstraints().get(j).getReferences().contains(nombreColumna)){
                                tabla.getConstraints().get(j).getReferences().remove(tabla.getConstraints().get(j).getReferences().lastIndexOf(nombreColumna));
                                if(tabla.getConstraints().get(j).getReferences().isEmpty())
                                    indices.add(j);
                            }
                        }else
                           if(tab.getConstraints().get(j).getTipo().equals("check")){
                               //hay un error en esta línea porque se cambio la estructura de tupla check
                               //ahora es un arraylist.
                               int cont=0;
                               for(int p = 0;p<tab.getConstraints().get(j).getTuplaCheck().size();p++)
                                   if(tab.getConstraints().get(j).getTuplaCheck().get(p).getOp1().contains(nombreColumna)||tab.getConstraints().get(j).getTuplaCheck().get(p).getOp2().contains(nombreColumna)){
                                       tab.getConstraints().get(j).getTuplaCheck().remove(p-cont);
                                       cont++;
                                   }
                               if(tab.getConstraints().get(j).getTuplaCheck().isEmpty()){
                                    indices.add(j);
                               }
                           }else{
                               if(tab.getConstraints().get(j).getReferences().contains(nombreColumna)){
                                    tabla.getConstraints().get(j).getReferences().remove(tabla.getConstraints().get(j).getReferences().lastIndexOf(nombreColumna));
                                    if(tabla.getConstraints().get(j).getReferences().isEmpty())
                                        indices.add(j);
                                }
                           }
                    }
                }
            }
            if(!existe){
                for(int i = 0;i<tabla.getColumnas().size();i++)
                    if(tabla.getColumnas().get(i).getNombre().equals(nombreColumna))
                        tabla.getColumnas().remove(i);
                for(int i = 0;i<indices.size();i++)
                    tabla.getConstraints().remove((int) indices.get(i)-i);
                DBMS.throwMessage( "columna: "+nombreColumna+" eliminada de la tabla: "+ nombreTabla, ctx.getStart());
                json.objectToJSON(bdActual, nombreTabla, tabla);
            }
        }else
            DBMS.throwMessage( "Error: Columna: "+nombreColumna+" no existe en la tabla "+ nombreTabla, ctx.getStart());
        return super.visitAccionDropColumn(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitAccionDropConstraint(sqlParser.AccionDropConstraintContext ctx) {
        String nombreTabla = ctx.getParent().getChild(2).getText();
        String nombreConstraint = ctx.getChild(2).getText();
        Tabla tabla = (Tabla)json.JSONtoObject(bdActual,nombreTabla , "Tabla");
        ArrayList<Constraint> constraints = tabla.getConstraints();
        boolean existe = false;
        int indice =0;
        for(int i = 0;i<constraints.size();i++)
         if(constraints.get(i).getNombre().equals(nombreConstraint)){
             existe = true;
             indice = i;
         }
        if(!existe)
             DBMS.throwMessage( "Error: constraint: "+nombreConstraint+" no existe en la tabla "+ nombreTabla, ctx.getStart());
        else{
             tabla.getConstraints().remove(indice);
             DBMS.throwMessage( "constraint: "+nombreConstraint+" eliminado la tabla "+ nombreTabla, ctx.getStart());
             json.objectToJSON(bdActual, nombreTabla, tabla);
        }
        return super.visitAccionDropConstraint(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object visitAlter_table_statement(sqlParser.Alter_table_statementContext ctx) {
        String nombreTabla =  ctx.getChild(2).getText();  
        boolean check = manejador.checkFile(bdActual, nombreTabla);
        if (check ){
            for (int i = 0;i<ctx.getChildCount();i++)
                this.visit(ctx.getChild(i));
        }else
            DBMS.throwMessage( "Error: La tabla: "+nombreTabla+" no existe en la base de datos "+ bdActual, ctx.getStart());
        return null;
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
    public Object visitConstraintPrimaryKeyAlter(sqlParser.ConstraintPrimaryKeyAlterContext ctx) {
        String nombreTabla = ctx.getParent().getParent().getParent().getChild(2).getText();
        String nombreConstraint = ctx.getChild(0).getText();
        String tipoConstraint = ctx.getChild(1).getText();
        ArrayList<String> listadoIDS = (ArrayList<String>)visit(ctx.getChild(4));
        Constraint constraint = new Constraint();
        constraint.setTipo(tipoConstraint);
        constraint.setNombre(nombreConstraint);
         //ahora busco la tabla y verifico los campos de los constraints
        Tabla tabla = (Tabla) json.JSONtoObject(bdActual+"/", nombreTabla, "Tabla");
        Tabla tabla_c = tabla;
        if(tipoConstraint.equals("primary"))
            for(int i = 0;i<tabla.getConstraints().size();i++){
                if(tabla.getConstraints().get(i).getTipo().equals("primary")){
                     DBMS.throwMessage("Error: Constraint primary key ya existe en la tabla " + nombreTabla, ctx.getStart() );
                    return super.visitConstraintPrimaryKeyAlter(ctx); //To change body of generated methods, choose Tools | Templates.
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
            DBMS.debug("Se ha agregado el constraint " + nombreConstraint + " a la tabla " + nombreTabla, ctx.getStart());
            json.objectToJSON(bdActual, nombreTabla, tabla);
        }
        else{
             DBMS.throwMessage("Error: campo "+listadoIDS+" no existe en la tabla " + nombreTabla, ctx.getStart() );
             tabla = null; //ya no se guarda la tabla.
        }
        return super.visitConstraintPrimaryKeyAlter(ctx); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public Object visitConstraintForeignKeyAlter(sqlParser.ConstraintForeignKeyAlterContext ctx) {
        String nombreTabla = ctx.getParent().getParent().getParent().getChild(2).getText();
        String nombreConstraint = ctx.getChild(0).getText();
        String tipoConstraint = ctx.getChild(1).getText();
        ArrayList<String> listadoIDS = (ArrayList<String>)visit(ctx.getChild(4));
        Constraint constraint = new Constraint();
        constraint.setTipo(tipoConstraint);
        constraint.setNombre(nombreConstraint);
        Tabla tabla = (Tabla) json.JSONtoObject(bdActual, nombreTabla, "Tabla");
        for(int i = 0;i<tabla.getConstraints().size();i++)
            if(tabla.getConstraints().get(i).getNombre().equals(nombreConstraint)){
                DBMS.throwMessage("Error: Constraint "+nombreConstraint+" ya existe en la tabla " + nombreTabla,ctx.getStart() );
                return super.visitConstraintForeignKeyAlter(ctx); //To change body of generated methods, choose Tools | Templates.
            }
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

            ArrayList<TuplaColumna> camposActuales = tabla_c.getColumnas();
            boolean verificador = revisarListadoIDs(camposActuales, listadoIDS);
            if (verificador){
                constraint.setReferences(listadoIDS);
                tabla.addConstraint(constraint);
                DBMS.debug("Se ha agregado el constraint " + nombreConstraint,ctx.getStart());
                json.objectToJSON(bdActual, nombreTabla, tabla);
            }
            else{
                 DBMS.throwMessage("Error: campo "+listadoIDS+" no existe en la tabla " + nombreTabla,ctx.getStart() );
                 tabla = null; //ya no se guarda la tabla.
            }
        
        
        return super.visitConstraintForeignKeyAlter(ctx); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public Object visitConstraintCheckAlter(sqlParser.ConstraintCheckAlterContext ctx) {
         String nombreTabla = ctx.getParent().getParent().getParent().getChild(2).getText();
            Tabla tabla = (Tabla) json.JSONtoObject(bdActual, nombreTabla, "Tabla");
            String nombreConstraint = ctx.getChild(0).getText();
            String tipoConstraint = ctx.getChild(1).getText();
           
            Constraint constraint = new Constraint();
            constraint.setTipo(tipoConstraint);
            constraint.setNombre(nombreConstraint);
        
            
         
            
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
            json.objectToJSON(bdActual, nombreTabla, tabla);
        
        
        return super.visitConstraintCheckAlter(ctx); //To change body of generated methods, choose Tools | Templates.
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
        return verificador;
    }

    @Override
    public Object visitShow_table_statement(sqlParser.Show_table_statementContext ctx) {
        if(!bdActual.isEmpty()){
            ArchivoMaestroTabla archivo = (ArchivoMaestroTabla)json.JSONtoObject(bdActual+"/", "MasterTable"+bdActual, "ArchivoMaestroTabla");
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            model.setColumnIdentifiers(new Object[]{"Nombre de la Tabla","Cantidad de Registros"});
            for(int i = 0;i<archivo.getTablas().size();i++)
                model.addRow(new Object[]{archivo.getTablas().get(i).getNombreTabla(),archivo.getTablas().get(i).getCantidadRegistros()});
        }else
           DBMS.throwMessage("Error: No hay base de datos seleccionada ", ctx.getStart() ); 
        return super.visitShow_table_statement(ctx); //To change body of generated methods, choose Tools | Templates.
    }
 
    @Override
    public Object visitFinal_where(sqlParser.Final_whereContext ctx) {
        ArrayList indexes = new ArrayList();
         String nombrePapa = ctx.getParent().getChild(0).getText();
     
   
        for(int i = 0;i<ctx.getChildCount();i++){
            indexes = (ArrayList) this.visit(ctx.getChild(i));
            System.out.println(indexes + "test");
            indexActuales = (indexes);
            this.indexGlobal.addAll(indexes);
        }
        
        return indexes;
    }
    @Override
    public Object visitFirst_where_statement(sqlParser.First_where_statementContext ctx) {
        indexActuales = new ArrayList();
        String nombrePapa = ctx.getParent().getParent().getChild(0).getText();
        String nombreTabla = "";
        if(nombrePapa.equals("delete"))
            nombreTabla = ctx.getParent().getParent().getChild(2).getText();
        else
            if(nombrePapa.equals("update"))
                nombreTabla = ctx.getParent().getParent().getChild(1).getText();
            else
                nombreTabla = ctx.getParent().getParent().getChild(3).getChild(0).getText();
        
        Tabla tabla = (Tabla) json.JSONtoObject(bdActual, nombreTabla, "Tabla");
        for(int i = 0;i<tabla.getDataInTable().size();i++)
            indexActuales.add(i);
        return (ArrayList) this.visit(ctx.getChild(0));
    }

    @Override
    public Object visitWhere_statement(sqlParser.Where_statementContext ctx) {
         String nombrePapa = ctx.getParent().getParent().getChild(0).getText();
        String nombreTabla = "";
        if(nombrePapa.equals("delete"))
            nombreTabla = ctx.getParent().getParent().getChild(2).getText();
        else
            if(nombrePapa.equals("update"))
                nombreTabla = ctx.getParent().getParent().getChild(1).getText();
            else{
                if (ctx.getParent().getParent().getChild(3).getChildCount()==1)
                    nombreTabla = ctx.getParent().getParent().getChild(3).getText();
                else{
                    nombreTabla = ctx.getChild(1).getChild(0).getChild(0).getText();
                }
            
            }
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
    public Object visitCondition(sqlParser.ConditionContext ctx) {
      String nombrePapa = ctx.getParent().getParent().getParent().getChild(0).getText();
        String nombreTabla = "";
        if(nombrePapa.equals("delete")||nombrePapa.equals("DELETE"))
            nombreTabla = ctx.getParent().getParent().getParent().getChild(2).getText();
        else
            if(nombrePapa.equals("update")|nombrePapa.equals("UPDATE"))
                nombreTabla = ctx.getParent().getParent().getParent().getChild(1).getText();
            else{
                if (ctx.getParent().getParent().getParent().getChild(3).getChildCount()==1)
                    nombreTabla = ctx.getParent().getParent().getParent().getChild(3).getText();
                else
                    nombreTabla = ctx.getChild(0).getChild(0).getText();
            }
        System.out.println("nombreTabla " + nombreTabla);
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
        
        boolean op1IsValue = false;
        boolean op2IsValue = false;
        
        //la columna esta en el primero y no en el segundo
        ArrayList registro = new ArrayList();
        ArrayList listaFinal = new ArrayList();
        if(!op1Value&&op2Value){
             int columna ;
            if (ctx.getChild(0).getChildCount() > 1)
                columna = columnExist(nombreTabla,ctx.getChild(0).getChild(2).getText());
            else
                columna = columnExist(nombreTabla,ctx.getChild(0).getChild(0).getText());
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
                        }else if (op1.equals("CHAR")){
                            String operador1 = ctx.getChild(2).getText();
                            String operador2 = (String)registro.get(columna);
                        
                            if (operador1.equals(operador2)){
                                listaFinal.add(indexActuales.get(i));
                            }
                        }
                        else if (op1.equals("DATE")){
                             String operador1 = ctx.getChild(2).getText();
                             System.out.println(registro);
                             System.out.println(columna);
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
            int columna = columnExist(nombreTabla,ctx.getChild(2).getChild(0).getText());
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
            int columna1 = columnExist(nombreTabla,ctx.getChild(0).getChild(0).getText());
            int columna2= columnExist(nombreTabla,ctx.getChild(2).getChild(0).getText());
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
    
    @Override
    public Object visitIdentifier(sqlParser.IdentifierContext ctx) {
    
        if(ctx.getChildCount()>1){
          
            String nombreColumna = ctx.getChild(2).getText();
             String nombreTabla = ctx.getChild(0).getText();
            Tabla tabla = (Tabla) json.JSONtoObject(bdActual, nombreTabla, "Tabla");
            if(tableExist(nombreTabla)<0){
                DBMS.throwMessage( "Error: La tabla: "+nombreTabla+" no existe en la base de datos "+ bdActual, ctx.getStart());
                return "error";
            }
            int indiceColumna = columnExist(nombreTabla,nombreColumna);
            if(indiceColumna<0){
                DBMS.throwMessage( "Error: La Columna: "+nombreColumna+" no existe en la tabla "+ nombreTabla, ctx.getStart());
                return "error";
            }
            System.out.println(tabla.getColumnas().get(indiceColumna).getTipo());
            return tabla.getColumnas().get(indiceColumna).getTipo();
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
                        //this.columnas.push(contenido);
                    }
                    else
                        if(nombrePapa.equals("update")||nombrePapa.equals("UPDATE")){
                            nombreTabla = ctx.getParent().getParent().getParent().getParent().getChild(1).getText();
                        }
                        else{
                            System.out.println(nombreTablas);
                            if (ctx.getParent().getParent().getParent().getParent().getChild(3).getChildCount()==1)
                                nombreTabla = this.nombreTablas.get(0);
                            else{
                                    nombreTabla = ctx.getChild(0).getText();
                            }
                        }
                      
                    int indiceColumna = columnExist(nombreTabla,contenido);
                    if(indiceColumna<0){
                        DBMS.throwMessage( "Error: La Columna: "+contenido+" no existe en la tabla ", ctx.getStart());
                        return "error";
                    }
                    Tabla tabla = (Tabla) json.JSONtoObject(bdActual, nombreTabla, "Tabla");
                    return tabla.getColumnas().get(indiceColumna).getTipo();
                    //System.out.println(contenido.charAt(0));
                    //DBMS.throwMessage( "Error de referencia, debe ir de la forma tabla.columna ", ctx.getStart());
                   // return "ID";
                }
             }

        }//To change body of generated methods, choose Tools | Templates.

        
    }
    
    public int tableExist(String nombreTabla){
        ArchivoMaestroTabla archivo = (ArchivoMaestroTabla)json.JSONtoObject(bdActual, "MasterTable"+bdActual, "ArchivoMaestroTabla");
        for(int i = 0;i<archivo.getTablas().size();i++)
            if(archivo.getTablas().get(i).getNombreTabla().equals(nombreTabla))
                return i;
        return -1;
    }
    
    /**
     * Determina si existe una columna en una tabla
     * @param nombreTabla
     * @param nombreColumna
     * @return el índice de la columna, retorna -1 si no lo encuentra
     */
    public int columnExist(String nombreTabla,String nombreColumna){
        Tabla tabla = (Tabla) json.JSONtoObject(bdActual, nombreTabla, "Tabla");
        for(int i = 0;i<tabla.getColumnas().size();i++)
            if(tabla.getColumnas().get(i).getNombre().equals(nombreColumna))
                return i;
        return -1;
    }
    
    /**
     * Contar el número de ocurrencias de un char
     * @param haystack
     * @param needle
     * @return int
     */
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
    public Object visitSelect_value(sqlParser.Select_valueContext ctx) {
        
        ArrayList<ArrayList> returnArray = new ArrayList();
    
        visit(ctx.getChild(3));
       
       
        //esto pasa cuando no hay where statement
        if (ctx.getChildCount()==5){
            ArrayList<String> columnasVerificadas = (ArrayList)visit(ctx.getChild(1));
            for (String columnasVerificada : columnasVerificadas) {
                for (String nombreTabla1 : nombreTablas) {
                    //buscar cada columna en cada tabla
                    ArrayList innerReturnArray = new ArrayList();
                    String nombreTabla = (String) nombreTabla1;
                    Tabla tabla = (Tabla) json.JSONtoObject(bdActual, nombreTabla, "Tabla");
                    int columnaIndex = this.columnExist(nombreTabla1, columnasVerificada);
                    ArrayList<ArrayList> data = tabla.getDataInTable();
                    if (columnaIndex >= 0){
                        for (ArrayList data1 : data) {
                            System.out.println(columnaIndex);
                            innerReturnArray.add(data1.get(columnaIndex));
                        }
                        returnArray.add(innerReturnArray);
                    }
                }
            }
            System.out.println(returnArray);
            
           //PRODUCTO CARTESIANO
            if (nombreTablas.size() > 1 ){
                System.out.println(computeCombinations2(returnArray));
                returnArray = computeCombinations2(returnArray);
            }
            System.out.println("NO where statement");
            funciones.generarTabla(returnArray, new ArrayList());
            return "";
        }
       //EN RETURN ARRAY SE TIENE LA DATA A MOSTRAR EN EL IDE
       
        super.visitSelect_value(ctx);
        
            ArrayList<String> columnasVerificadas = (ArrayList)visit(ctx.getChild(1));
            for (String columnasVerificada : columnasVerificadas) {
                for (String nombreTabla1 : nombreTablas) {
                    //buscar cada columna en cada tabla
                    ArrayList innerReturnArray = new ArrayList();
                
                    Tabla tabla = null;
                    int columnaIndex = 0;
                    if (columnasVerificada.contains(".")){
                        String nombreTablaMafiosa = columnasVerificada.substring(0, columnasVerificada.indexOf("."));
                        String nombreColumnaMafiosa = columnasVerificada.substring(columnasVerificada.indexOf(".")+1);
                        tabla = (Tabla) json.JSONtoObject(bdActual, nombreTablaMafiosa, "Tabla");
                        columnaIndex = this.columnExist(nombreTablaMafiosa, nombreColumnaMafiosa);
                       
                    }
                    else {
                        tabla = (Tabla) json.JSONtoObject(bdActual, nombreTabla1, "Tabla");
                        columnaIndex = this.columnExist(nombreTabla1, columnasVerificada);
                    }
                    ArrayList<ArrayList> data = tabla.getDataInTable();
                    if (columnaIndex >= 0) {
                        for (int index = 0; index < this.indexGlobal.size(); index++) {
                            innerReturnArray.add(data.get((int)indexGlobal.get(index)).get(columnaIndex));
                        }
                        returnArray.add(innerReturnArray);
                    }
                }
            }
            System.out.println("result");
           
            System.out.println(returnArray);
             funciones.generarTabla(returnArray, new ArrayList());
      
        return ""; //To change body of generated methods, choose Tools | Templates.
    }

  
    public ArrayList<ArrayList> computeCombinations2(ArrayList<ArrayList> lists) {
        List<List<T>> combinations = Arrays.asList(Arrays.asList());
        for (ArrayList<T> list : lists) {
           List<List<T>> extraColumnCombinations = new ArrayList<>();

            for (List<T> combination : combinations) {
                for (T element : list) {
                  List<T> newCombination = new ArrayList<>(combination);
                    newCombination.add(element);

                    extraColumnCombinations.add(newCombination);

                }
            }
            combinations = extraColumnCombinations;
        }
        return new ArrayList(combinations);
}
    
    @Override
    public Object visitSelect_values(sqlParser.Select_valuesContext ctx) {
        ArrayList<String> columnasVerificadas = new ArrayList();
        for (int i = 0;i<ctx.getChildCount();i++){
            
             String select_value = "";
             
            if (ctx.getChild(i).getChildCount()>1){
                select_value = ctx.getChild(i).getChild(2).getText();
            }
            else
                select_value =ctx.getChild(i).getText();
            
            boolean verificador = false;
            if (!select_value.equals(",")&&!select_value.equals("*")){
                //verificar que exista este campo en las tablas seleccionadas
                for (int j= 0;j<nombreTablas.size();j++){
                    String nombreTabla = nombreTablas.get(j);
                    int verColumn = columnExist(nombreTabla, select_value);
                    if (verColumn >= 0){
                        verificador = true;
                    }
                }
                if (!verificador){
                   
                        DBMS.throwMessage("Error: La columna " + select_value +" no existe en las tablas seleccionadas ", ctx.getStart());
                        return new ArrayList();
                   
                }
               
               select_value =ctx.getChild(i).getText();
                columnasVerificadas.add(select_value);
            }
            if (select_value.equals("*")){
                  for (int j= 0;j<nombreTablas.size();j++){
                      System.out.println(nombreTablas);
                       Tabla tabla = (Tabla) json.JSONtoObject(bdActual, nombreTablas.get(j), "Tabla");
                      for (TuplaColumna columna : tabla.getColumnas()) {
                          columnasVerificadas.add(columna.getNombre());
                      }
                  }
            }
        }
        //return super.visitSelect_values(ctx); //To change body of generated methods, choose Tools | Templates.
        return columnasVerificadas;
    }

    @Override
    public Object visitFrom_multiple(sqlParser.From_multipleContext ctx) {
        nombreTablas = new ArrayList();
       //no revise que las tablas existieran
        for (int i = 0;i<ctx.getChildCount();i++){
            String tabla_string = ctx.getChild(i).getText();
            if (!tabla_string.equals(",")){
                nombreTablas.add(tabla_string);
            }
        }
        
        return super.visitFrom_multiple(ctx); //To change body of generated methods, choose Tools | Templates.
    }

    
}
