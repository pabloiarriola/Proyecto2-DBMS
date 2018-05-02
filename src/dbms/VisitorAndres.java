/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import antlr.sqlBaseVisitor;
import antlr.sqlParser;
import static dbms.ANTGui.bdActual;
import java.util.ArrayList;
import org.antlr.v4.runtime.misc.NotNull;

/**
 *
 * @author Andres
 */
public class VisitorAndres<T> extends sqlBaseVisitor{
    
    private JSONParser json = new JSONParser();
    private FileManager manejador = new FileManager();
    
    /**
     * TODO: 
     * - Verificación de Primary Key
     * - Verificación de constraints
     * - Referencias entre tablas
     */
    
    
    @Override
    public T visitInsert_value(@NotNull sqlParser.Insert_valueContext ctx) { 
        // Existen dos tipos de insert
        // 1. En donde se ingresan los nombres de las columnas y luego los valores
        // 2. En donde no se ingresan los nombres de las columnas y sólo valores
        // Esa diferencia de insert estará dado por una bandera simpleInsert en donde
        // true es cuando no tiene columnas definidas y el caso contrario pues se deduce
        
        String nombreTabla = ctx.getChild(2).getText();
        
        Tabla tabla = getTablaFromNombre(nombreTabla);
        
        /* Verificar si la tabla existe */
        if (tabla == null) {
            DBMS.throwMessage("ERROR: INSERT FALLIDO, LA TABLA " + nombreTabla + "NO EXISTE", ctx.getStart());
            
            return null;
        }
        
        // Todos los elementos que se iran en el insert
        ArrayList<String> insertValues = null;
        ArrayList<String> insertColumnNames = null;
        // Por default vamos a suponer que es un insertSimple
        boolean isSimpleInsert = true;
        
        if (ctx.getChildCount() == 8) {
            insertValues = (ArrayList<String>) visit(ctx.getChild(5));
        }
        
        if (ctx.getChildCount() == 9) {
            insertValues = (ArrayList<String>) visit(ctx.getChild(6));
            insertColumnNames = (ArrayList<String>) visit(ctx.getChild(3));
            
            isSimpleInsert = false;
        }
        
        // La cantidad de columnas de la tabla
        int cantColumnasTabla = tabla.getColumnas().size();
        
        // Si la cantidad de valores del insert es mayor que la que necesitamos está mal
        if (insertValues.size() > cantColumnasTabla) {
            DBMS.throwMessage("INSERT ERROR: LA CANTIDAD DE VALORES ES MAYOR DE LOS NECESARIOS ", ctx.getStart());
            
            return null;
        }
        
        // En el caso en donde se haya definido las columnas a insertar
        if (!isSimpleInsert) {
            // Validar cantidad de columnas contra inserts
            if (insertValues.size() != insertColumnNames.size()) {
                DBMS.throwMessage("INSERT ERROR: CANTIDAD DE COLUMNAS Y VALORES NO COINCIDEN ", ctx.getStart());

                return null;
            }
            
            // Validar que la cantidad de columnas a insertar no sean mayores que la definición de la tabla
            if (insertColumnNames.size() > cantColumnasTabla) {
                DBMS.throwMessage("INSERT ERROR: CANTIDAD DE COLUMNAS MAYOR DE LOS NECESARIOS ", ctx.getStart());
            
                return null;
            }
            
            // Validar que las columnas a ingresar no sean repetidas
            if (!verificarDobleLlamadaColumna(insertColumnNames)) {
                DBMS.throwMessage("INSERT ERROR: COLUMNAS REPETIDAS", ctx.getStart());
            
                return null;  
            }
        }
        
        // La cantidad de valores son exactamente los que necesita el INSERT de la tabla
        //if (isSimpleInsert && (insertValues.size() == cantColumnasTabla)) {
        if (isSimpleInsert) {
        // Vamos a comprar entonces que los tipos de los datos sean los de la tabla
            
            int contInvalidInsertValue = 0;
            ArrayList<TuplaColumna> columnasTabla = tabla.getColumnas();
            
            for (int i = 0; i  < columnasTabla.size(); i++) {
                String tipoColumna = columnasTabla.get(i).getTipo();
                if (!(i < insertValues.size())) {
                    continue;
                }
                if (!insertValues.get(i).contains(tipoColumna)) {
                    int indexOfSubs = insertValues.get(i).indexOf("€") + 1;
                    String valor = insertValues.get(i).substring(indexOfSubs);
                    
                    if (!verifyPossibleCast(insertValues.get(i), tipoColumna)) {
                        DBMS.throwMessage(
                                "INSERT ERROR: TIPO DE DATO DEL VALOR : " + valor + " ES INCORRECTO, SE REQUIERE UN " + tipoColumna,
                                ctx.getStart()
                        );

                        contInvalidInsertValue++;
                    }
                }
                if (insertValues.get(i).contains(tipoColumna) && tipoColumna.equals("DATE")) {
                    int indexOfSubs = insertValues.get(i).indexOf("€") + 1;
                    String valor = insertValues.get(i).substring(indexOfSubs);
                    if (!verifyDate(valor)) {
                        DBMS.throwMessage(
                                "INSERT ERROR: TIPO DE DATO DEL VALOR : " + valor + " ES INCORRECTO, SE REQUIERE UN  " + tipoColumna,
                                ctx.getStart()
                        );

                        contInvalidInsertValue++;
                    }
                }
            }
            
            if (contInvalidInsertValue > 0) {
                return null;
            }
        }
        
        // Si está definida la lista de columnas, vamos a verificar
        // que la columnas existan
        if (!isSimpleInsert) {
            int cantValidColumnNames = 0;
            
            ArrayList<TuplaColumna> columnasTabla = tabla.getColumnas();
            for (int i = 0; i < columnasTabla.size(); i++) {
                for (int j = 0; j < insertColumnNames.size(); j++) {
                    if (columnasTabla.get(i).getNombre().equals(insertColumnNames.get(j))) {
                        cantValidColumnNames++;
                    }
                }
            }
        
            if (cantValidColumnNames != insertColumnNames.size()) {
                    DBMS.throwMessage("INSERT ERROR: ES POSIBLE QUE UNA DE LAS COLUMNAS A HIDRATAR NO EXISTA ", ctx.getStart());
                    
                    return null;
            }
        }
        
        // Vemos si la cantidad de columnas listada en el insert es menor que la cantidad
        // de columnas en la tabla
        if (!isSimpleInsert && (insertColumnNames.size() < cantColumnasTabla)) {
            int contInvalidInsertValues = 0;
            for (int i = 0; i < insertColumnNames.size(); i++) {
                String tipoColumna = getColumnTypeFromColumnName(insertColumnNames.get(i), tabla);
                
                if (!insertValues.get(i).contains(tipoColumna)) {
                    if (!verifyPossibleCast(insertValues.get(i), tipoColumna)) {

                        ArrayList datosInsertValue = getTypeAndValueFromInsertValue(insertValues.get(i));

                        DBMS.throwMessage(
                                "INSERT ERROR: TIPO DE DATO DEL VALOR : " + datosInsertValue.get(0) +
                                " ES INCORRECTO, SE REQUIERE UN  " + datosInsertValue.get(1),
                                ctx.getStart()
                        );

                        contInvalidInsertValues++;
                    }
                }
                if (insertValues.get(i).contains(tipoColumna) && tipoColumna.equals("DATE")) {
                    int indexOfSubs = insertValues.get(i).indexOf("€") + 1;
                    String valor = insertValues.get(i).substring(indexOfSubs);
                    if (!verifyDate(valor)) {
                        DBMS.throwMessage(
                                "INSERT ERROR: TIPO DE DATO DEL VALOR : " + valor + " ES INCORRECTO, SE REQUIERE UN " + tipoColumna,
                                ctx.getStart()
                        );

                        contInvalidInsertValues++;
                    }
                }
            }
            
            if (contInvalidInsertValues > 0) {
                return null;
            }
            
        }
        
        // En el caso en el que se hayan definido las columnas y es la misma cantidad de la tabla
        if (!isSimpleInsert && (insertColumnNames.size() == cantColumnasTabla)) {
            int contInvalidInsertValue = 0;
            
            for (int i = 0; i < insertColumnNames.size(); i++) {
                String tipoColumna = getColumnTypeFromColumnName(insertColumnNames.get(i), tabla);
                if (!insertValues.get(i).contains(tipoColumna)) {
                    int indexOfSubs = insertValues.get(i).indexOf("€") + 1;
                    String valor = insertValues.get(i).substring(indexOfSubs);
                    String tipoInsertVal = insertValues.get(i).substring(0, indexOfSubs);
                    
                    if (!verifyPossibleCast(tipoInsertVal, tipoColumna)) {
                        DBMS.throwMessage(
                                "INSERT ERROR: TIPO DE DATO DEL VALOR: " + valor + " ES INCORRECTO, SE REQUIERE UN " + tipoColumna,
                                ctx.getStart()
                        );

                        contInvalidInsertValue++;
                    }
                }
                if (insertValues.get(i).contains(tipoColumna) && tipoColumna.equals("DATE")) {
                    int indexOfSubs = insertValues.get(i).indexOf("€") + 1;
                    String valor = insertValues.get(i).substring(indexOfSubs);
                    if (!verifyDate(valor)) {
                        DBMS.throwMessage(
                                "INSERT ERROR: TIPO DE DATO DEL VALOR: " + valor + " ES INCORRECTO, SE REQUIERE UN " + tipoColumna,
                                ctx.getStart()
                        );

                        contInvalidInsertValue++;
                    }
                }
            }
            
            if (contInvalidInsertValue > 0) {
                return null;
            }
        }
        
        // Al terminar de realizar todas las validaciones se procede a crear la estructura del insert
        ArrayList insertData = new ArrayList();
        
        if (isSimpleInsert) {
            // Caso en el que los datos del insert estén completos
            if (insertValues.size() == cantColumnasTabla) {
                ArrayList<TuplaColumna> columnasTabla = tabla.getColumnas();
                for (int i = 0; i < columnasTabla.size(); i++) {
                    String tipoColumna = columnasTabla.get(i).getTipo();
                    // Obtenemos el valor
                    int indexOfSubs = insertValues.get(i).indexOf("€") + 1;
                    String valor = insertValues.get(i).substring(indexOfSubs);
                    
                    if (!insertValues.get(i).contains(tipoColumna)) {
                        
                        if (tipoColumna.equals("INT")) {
                            int castedInsertVal = (Integer)casteoDatos(valor, false);
                            // Agregar valor
                            insertData.add(valor);
                        }
                        
                        if (tipoColumna.endsWith("FLOAT")) {
                            double castedInsertVal = (Double)casteoDatos(valor, true);
                            // Agregar valor
                            insertData.add(castedInsertVal);
                        }
                        continue;
                    }
                    // Si no se necesita casteo se agrega
                    if (tipoColumna.equals("INT")) {
                        insertData.add(Double.valueOf(valor));
                        continue;
                    }
                    if (tipoColumna.equals("FLOAT")) {
                        insertData.add(Double.valueOf(valor));
                        continue;
                    }
                    insertData.add(valor);
                }
            }
            // Caso en el que los datos del insert sean menor a los necesarios
            if (insertValues.size() < cantColumnasTabla) {
                ArrayList<TuplaColumna> columnasTabla = tabla.getColumnas();
                for (int i = 0; i < columnasTabla.size(); i++) {
                    String tipoColumna = columnasTabla.get(i).getTipo();
                    // Obtenemos el valor
                    if (!(i < insertValues.size())) {
                        insertData.add("NULL");
                        continue;
                    }
                    int indexOfSubs = insertValues.get(i).indexOf("€") + 1;
                    String valor = insertValues.get(i).substring(indexOfSubs);
                    
                    if (!insertValues.get(i).contains(tipoColumna)) {
                        
                        if (tipoColumna.equals("INT")) {
                            int castedInsertVal = (Integer)casteoDatos(valor, false);
                            // Agregar valor
                            insertData.add(valor);
                        }
                        
                        if (tipoColumna.endsWith("FLOAT")) {
                            double castedInsertVal = (Double)casteoDatos(valor, true);
                            // Agregar valor
                            insertData.add(castedInsertVal);
                        }
                        continue;
                    }
                    // Si no se necesita casteo se agrega
                    if (tipoColumna.equals("INT")) {
                        insertData.add(Double.valueOf(valor));
                        continue;
                    }
                    if (tipoColumna.equals("FLOAT")) {
                        insertData.add(Double.valueOf(valor));
                        continue;
                    }
                    insertData.add(valor);
                }
            }
        }
        
        if (!isSimpleInsert) {
            if (insertColumnNames.size() == cantColumnasTabla) {
                ArrayList<TuplaColumna> columnasTabla = tabla.getColumnas();
                for (int i = 0; i < columnasTabla.size(); i++) {
                    String nombreColumna = columnasTabla.get(i).getNombre();
                    String tipoColumna = columnasTabla.get(i).getTipo();
                    // Recorremos todos los nombres de las columnas en la lista de insert
                    // y si casa ingresamos el valor
                    for (int j = 0; j < insertColumnNames.size(); j++) {
                        String nombreColumnaInsert = insertColumnNames.get(j);
                        if (nombreColumna.equals(nombreColumnaInsert)) {
                            int indexOfSubs = insertValues.get(j).indexOf("€") + 1;
                            String valor = insertValues.get(j).substring(indexOfSubs);
                            
                            if (!insertValues.get(j).contains(tipoColumna)) {

                                if (tipoColumna.equals("INT")) {
                                    int castedInsertVal = (Integer)casteoDatos(valor, false);
                                    // Agregar valor
                                    insertData.add(valor);
                                }

                                if (tipoColumna.equals("FLOAT")) {
                                    double castedInsertVal = (Double)casteoDatos(valor, true);
                                    // Agregar valor
                                    insertData.add(castedInsertVal);
                                }
                                continue;
                            }
                            if (tipoColumna.equals("INT")) {
                                insertData.add(Double.valueOf(valor));
                                continue;
                            }
                            if (tipoColumna.equals("FLOAT")) {
                                insertData.add(Double.valueOf(valor));
                                continue;
                            }
                            insertData.add(valor);
                        }
                    }
                }
            }
            
            if (insertColumnNames.size() < cantColumnasTabla) {
                ArrayList<TuplaColumna> columnasTabla = tabla.getColumnas();
                for (int i = 0; i < columnasTabla.size(); i++) {
                    String nombreColumna = columnasTabla.get(i).getNombre();
                    String tipoColumna = columnasTabla.get(i).getTipo();
                    // Recorremos todos los nombres de las columnas en la lista de insert
                    // y si casa ingresamos el valor
                    for (int j = 0; j < insertColumnNames.size(); j++) {
                        String nombreColumnaInsert = insertColumnNames.get(j);
                        if (nombreColumna.equals(nombreColumnaInsert)) {
                            int indexOfSubs = insertValues.get(j).indexOf("€") + 1;
                            String valor = insertValues.get(j).substring(indexOfSubs);
                            
                            if (!insertValues.get(j).contains(tipoColumna)) {

                                if (tipoColumna.equals("INT")) {
                                    int castedInsertVal = (Integer)casteoDatos(valor, false);
                                    // Agregar valor
                                    insertData.add(valor);
                                }

                                if (tipoColumna.equals("FLOAT")) {
                                    double castedInsertVal = (Double)casteoDatos(valor, true);
                                    // Agregar valor
                                    insertData.add(castedInsertVal);
                                }
                                continue;
                            }
                            
                            if (tipoColumna.equals("INT")) {
                                insertData.add(Double.valueOf(valor));
                                continue;
                            }
                            if (tipoColumna.equals("FLOAT")) {
                                insertData.add(Double.valueOf(valor));
                                continue;
                            }
                            insertData.add(valor);
                            continue;
                        }
                    }
                    if (!insertColumnNames.contains(nombreColumna)) {
                        insertData.add("NULL");
                    }
                }
            }
        }
        
        // Al tener todos los datos que se van a ingresar procedemos a hacer validaciones de constraints
        for (Constraint cnt: tabla.getConstraints()) {
            switch (cnt.getTipo()) {
                case "primary":
                    boolean isOk_p = verifyPrimaryKeyInTable(insertData, tabla.getDataInTable(), cnt.getReferences(), tabla);
                    if (!isOk_p) {
                        DBMS.throwMessage(
                                "INSERT ERROR: PRIMARY KEY VIOLATION; YA EXISTE TUPLA CON ESOS DATOS",
                                ctx.getStart()
                        );
                        return null;
                    }
                    break;
                case "PRIMARY":
                    boolean isOk_P = verifyPrimaryKeyInTable(insertData, tabla.getDataInTable(), cnt.getReferences(), tabla);
                    if (!isOk_P) {
                        DBMS.throwMessage(
                                "INSERT ERROR: PRIMARY KEY VIOLATION; YA EXISTE UNA TUPLA CON ESOS DATOS",
                                ctx.getStart()
                        );
                        return null;
                    }
                    break;
                case "foreign":
                    String nombreTablaRef_1 = cnt.getReferencesForeign().getNombreTablaRef();
                    Tabla tablaRef_1 = getTablaFromNombre(nombreTablaRef_1);
                    
                    for (int i = 0; i < cnt.getReferencesForeign().getReferencesForeign().size(); i++) {

                        String nombreColumnaRef_1 = cnt.getReferencesForeign().getReferencesForeign().get(i);
                        String nombreColumnOwner_1 = cnt.getReferences().get(i);

                        //boolean isOk_f = verifyPrimaryKeyInTable(insertData, tabla.getDataInTable(), cnt.getReferences(), tabla);
                        boolean isOk_f = verifyForeignKeyInTable(insertData, nombreColumnOwner_1, nombreColumnaRef_1, tabla, tablaRef_1);
                        if (!isOk_f) {
                            DBMS.throwMessage(
                                    "INSERT ERROR: FOREIGN KEY VIOLATION; NO EXISTE EL VALOR AL QUE SE LE HACE REFERENCIA",
                                    ctx.getStart()
                            );
                            return null;
                        }
                    }
                    break;
                case "FOREIGN":
                    String nombreTablaRef = cnt.getReferencesForeign().getNombreTablaRef();
                    Tabla tablaRef = getTablaFromNombre(nombreTablaRef);
                    
                    for (int i = 0; i < cnt.getReferencesForeign().getReferencesForeign().size(); i++) {

                        String nombreColumnaRef = cnt.getReferencesForeign().getReferencesForeign().get(i);
                        String nombreColumnOwner = cnt.getReferences().get(i);

                        //boolean isOk_f = verifyPrimaryKeyInTable(insertData, tabla.getDataInTable(), cnt.getReferences(), tabla);
                        boolean isOk_F = verifyForeignKeyInTable(insertData, nombreColumnOwner, nombreColumnaRef, tabla, tablaRef);
                        if (!isOk_F) {
                            DBMS.throwMessage(
                                    "INSERT ERROR: FOREIGN KEY VIOLATION; NO EXISTE VALOR REFERENCIADO",
                                    ctx.getStart()
                            );
                            return null;
                        }
                    }
                    break;
                case "check":
                    break;
                case "CHECK":
                    break;
            }
        }
        
        tabla.addRowToTable(insertData);
        json.objectToJSON(bdActual, nombreTabla, tabla);
        ArchivoMaestroTabla maestroTabla = (ArchivoMaestroTabla) json.JSONtoObject(bdActual, "MasterTable"+bdActual, "ArchivoMaestroTabla");
        maestroTabla.aumentarColumnaCount(nombreTabla);
        json.objectToJSON(bdActual, "MasterTable"+bdActual, maestroTabla);
        
        DBMS.throwMessage(
                "INSERT CORRECTO: EN TABLA: " + nombreTabla,
                ctx.getStart()
        );
        
        return (T)tabla;
    }
    
    public boolean verifyPrimaryKeyInTable(
        ArrayList dataInsert,           // Datos a validar
        ArrayList<ArrayList> datosTabla,           // Datos en tabla
        ArrayList<String> references,   // Columnas a validar
        Tabla tabla                     // Por cualquier cosa lol
    ) {
        ArrayList<Integer> indicesEval = getArrayIndicesDataToEval(references, tabla.getColumnas());
        
        for (int i = 0; i < datosTabla.size(); i++) {
            int contMatch = 0;
            for (Integer index: indicesEval) {
                T valor_1 = (T)datosTabla.get(i).get(index);
                T valor_2 = (T)dataInsert.get(index);
                
                if (valor_1.equals(valor_2)) {
                    contMatch++;
                }
            }
            if (contMatch == indicesEval.size()) {
                return false;
            }
        }
        
        return true;
    }
    
    public boolean verifyCheckInTable(
        ArrayList insert_values,// Datos que se van a insertar
        String first_operator,  // Se asume que el primer valor siempre va a ser un nombre de columna
        String second_operator, // No sabemso si es un nombre columna o si es un terminal
        String tipo_comparacion,       // Criterio de comparación
        Tabla tabla
    ) {
        TuplaColumna columnaCheck = getColumnInTableFromName(first_operator, tabla.getColumnas());
        TuplaColumna posibleColumna = getColumnInTableFromName(second_operator, tabla.getColumnas());
        
        int indexInData = getIndexOfColumn(columnaCheck.getNombre(), tabla.getColumnas());
        int indexInData_2 = -1;
        
        T valor1 = (T)insert_values.get(indexInData);
        T valor2 = (T)second_operator;
        
        boolean secondOp_isColumn = false;
        
        if (columnaCheck == null) {
            System.out.println("NO EXISTE LA COLUMNA: " + columnaCheck);
            return false;
        }
        
        if (posibleColumna != null) {
            secondOp_isColumn = true;
            indexInData_2 = getIndexOfColumn(columnaCheck.getNombre(), tabla.getColumnas());
            valor2 = (T)insert_values.get(indexInData_2);
        }
        
        switch(tipo_comparacion) {
            case "=":
                if (valor1.equals(valor2)) {
                    return true;
                }
                break;
            case "!=":
                if (!valor1.equals(valor2)) {
                    return true;
                }
                break;
            case ">":
                break;
            case "<":
                break;
            case ">=":
                break;
            case "<=":
                break;
        }
        
        return true;
    }
    
    public boolean verifyForeignKeyInTable(
        ArrayList<T> dataInsert,           // Datos a validar
        String referenceOwner,          // Columna que guarda la referencia
        String reference,               // Columnas a quien se hace referencia
        Tabla tablaOwner,               // Tabla a la que pertenece el Foreign Key
        Tabla tablaRef                  // Tabla a la que se hace una referencia
    ) {
        ArrayList<T> datosColumna = getDataInColumnFromTable(reference, tablaRef);
        
        if (datosColumna == null) {
            System.out.println(" NO SE ENCONTRARON DATOS PARA FK VALIDATION ");
        }
        
        int indexOfColumn = getIndexOfColumn(referenceOwner, tablaOwner.getColumnas());
        
        if (indexOfColumn == -1) {
            System.out.println("La vida no es justa JA JA, no encontró el índice");
        }
        
        T dato_eval = dataInsert.get(indexOfColumn);
        
        String columnType = getColumnTypeFromColumnName(reference, tablaRef);
        
        System.out.println("Datos columna: " + datosColumna + " DatoEval: " + dato_eval);
        if (datosColumna.contains(dato_eval)) {
            return true;
        }
        
        return false;
    }
    
    public ArrayList<T> getDataInColumnFromTable(
        String nombreColumna,
        Tabla table
    ) {
        ArrayList<T> returnData = new ArrayList();
        
        ArrayList<ArrayList> dataTable = table.getDataInTable();
        int indexOfColumn = getIndexOfColumn(nombreColumna, table.getColumnas());
        
        if (indexOfColumn == -1) {
            System.out.println("Error, No se encontró índice de la columna");
            return null;
        }
        
        for (int i = 0; i < dataTable.size(); i++) {
            ArrayList dataRegistro = dataTable.get(i);
            returnData.add((T)dataRegistro.get(indexOfColumn));
        }
        
        return returnData;
    }
    
    public int getIndexOfColumn(String nombreColumna, ArrayList<TuplaColumna> columnas) {
        for (int i = 0; i < columnas.size(); i++) {
            String nombreColumnaTablaActual = columnas.get(i).getNombre();
            if (nombreColumna.equals(nombreColumnaTablaActual)) {
                return i;
            }
        }
        
        return -1;
    }
    
       
    public TuplaColumna getColumnInTableFromName(String nombreColumna, ArrayList<TuplaColumna> columnas) {
        for (int i = 0; i < columnas.size(); i++) {
            String nombreColumnaTablaActual = columnas.get(i).getNombre();
            if (nombreColumna.equals(nombreColumnaTablaActual)) {
                return columnas.get(i);
            }
        }
        
        return null;
    }
    
    public ArrayList<Integer> getArrayIndicesDataToEval(
        ArrayList<String> referencias,          // Columnas a las que hacemos referencia
        ArrayList<TuplaColumna> columnasTabla   // Columnas definción de la tabla
    ) {
        ArrayList<Integer> indices = new ArrayList();
        for (int i = 0; i < referencias.size(); i++) {
            String nombreReferencia = referencias.get(i);
            for (int j = 0; j < columnasTabla.size(); j++) {
                String nombreColumna = columnasTabla.get(j).getNombre();
                if (nombreReferencia.equals(nombreColumna)) {
                    indices.add(j);
                }
            }
        }
        
        return indices;
    }
    
    public String getColumnTypeFromColumnName(String nombreColumna, Tabla tabla) {
        for (TuplaColumna tc: tabla.getColumnas()) {
            if (tc.getNombre().equals(nombreColumna)) {
                return tc.getTipo();
            }
        }
        
        return null;
    }
    
    public Tabla getTablaFromNombre(String nombre) {
        if (!manejador.checkFile(bdActual, nombre)) {
            return null;
        }
        
        Tabla tabla = (Tabla)json.JSONtoObject(bdActual + "/", nombre, "Tabla");
        
        return tabla;
    }
    
    public ArrayList getTypeAndValueFromInsertValue(String value) {
        int indexOfEpsilon = value.indexOf("€");
        ArrayList returnData = new ArrayList();
        
        returnData.add(0, value.substring(0, indexOfEpsilon));
        returnData.add(0, value.substring(indexOfEpsilon + 1));
        
        return returnData;
    }
    
    public boolean verificarDobleLlamadaColumna(ArrayList<String> columnasEval) {
        for (String s: columnasEval) {
            int contRepetidos = 0;
            for (String s_1: columnasEval) {
                if (s.equals(s_1)) {
                    contRepetidos++;
                }
            }
            
            if (contRepetidos > 1) {
                return false;
            }
            
            contRepetidos = 0;
        }
        
        return true;
    }
    
    public boolean verifyPossibleCast(String insertType, String columnType) {
        if ((insertType.contains("INT") && columnType.contains("FLOAT")) ||
            (insertType.contains("FLOAT") && columnType.contains("INT"))
        ) {
            return true;
        }
        
        return false;
    }
    
    /**
     * tipoCasteo nos indica el casteo a realizar, en donde:
     * true: indica que se debe castear de int a float
     * false: indica que se debe castear de float a int
     * 
     * El parametro "dato" es lo que se debe castear
     */
    public T casteoDatos(String dato1, boolean tipoCasteo) {
        if (tipoCasteo) {
            return (T)Double.valueOf(dato1);
        }
        
        double val = Double.valueOf(dato1);
        Integer val_casteado = (int)Math.round(val);
        return (T)val_casteado;
    }
    
    public boolean verifyDate(String date) {
        String[] partition = date.substring(1, date.length() - 1).split("-");
        
        if (partition.length != 3) {
            return false;
        }
        
        int anio, mes, dia;
        
        try {
            anio = Integer.valueOf(partition[0]);
            mes = Integer.valueOf(partition[1]);
            dia = Integer.valueOf(partition[2]);
        } catch (Exception e) {
            return false;
        }
        
        if (anio == 0 || anio < 0 || partition[0].length() != 4) {
            return false;
        }
        
        if (mes == 0 || mes < 0 || mes > 12) {
            return false;
        }
        
        if (dia == 0 || dia < 0 || dia > 31) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public ArrayList<String> visitList_values(@NotNull sqlParser.List_valuesContext ctx) {
        ArrayList<String> valores = new ArrayList();
        
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (visit(ctx.getChild(i)) == null) {
                continue;
            }
            valores.add((String) visit(ctx.getChild(i)));
        }
        
        return valores;
    }
    
    @Override
    public Object visitUse_schema_statement(sqlParser.Use_schema_statementContext ctx) {
        
        bdActual = ctx.getChild(2).getText();
       
        if (manejador.checkDB(bdActual)==false)
            bdActual = "";
        return super.visitUse_schema_statement(ctx); //To change body of generated methods, choose Tools | Templates.
    }
    //"€"
    
    @Override
    public Object visitInsert_column_names(@NotNull sqlParser.Insert_column_namesContext ctx) {
        ArrayList<String> columnNames = new ArrayList();
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i).getText().contains("(") ||
                ctx.getChild(i).getText().contains(")") ||
                ctx.getChild(i).getText().contains(",")
            ) {
                continue;
            }
            columnNames.add(ctx.getChild(i).getText());
        }
        return columnNames;
    }
    
    @Override
    public Object visitInt_literal(@NotNull sqlParser.Int_literalContext ctx) {
        return "INT_literal" + "€" + ctx.getText();
    }
    
    @Override
    public Object visitDate_literal(@NotNull sqlParser.Date_literalContext ctx) {
        return "DATE_literal" + "€" + ctx.getText();
    }
    
    @Override
    public Object visitFloat_literal(@NotNull sqlParser.Float_literalContext ctx) {
        return "FLOAT_literal" + "€" + ctx.getText();
    }
    
    @Override
    public Object visitChar_literal(@NotNull sqlParser.Char_literalContext ctx) {
        return "CHAR_literal" + "€" + ctx.getText();
    }
}