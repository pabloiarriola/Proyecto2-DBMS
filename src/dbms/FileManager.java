package dbms;

import java.io.File;
import java.io.IOException;

/**
 * Clase que maneja la escritura/lectura de archivos en JAVA.
 * @author Andres
 */
public class FileManager {
    
    public void FieManager()
    {
        
    }
    
    /**
     * Método que crea el directorio para cada base de datos
     * @param nameDir nombre de la base de datos
     * @return regresa true si fue correcta la creación
     * regresa false si hay error o no es válido.
     */
    public boolean createDirectory(String nameDir){
    
        File file = new File("DB/"+nameDir);
        if (!file.exists()) {
            if (file.mkdir()) {
               DBMS.debug("BASE DE DATOS CREADA CON EXITO");
            }
            else{
                 DBMS.debug("HA OCURRIDO UN ERROR AL CREAR LA BASE DE DATOSr");
                return false;
            }
        return true;
        }else{
             DBMS.debug("ERROR, LA BASE DE DATOS" +nameDir+ "YA EXISTE");
            return false;
        }
    }
    /**
     * Este método sirve para revisar si existe un archivo para la tabla
     * @param path
     * @param fileName
     * @return true si existe, false si no
     */
    public boolean checkFileTabla(String path,String fileName){
        if (path.isEmpty()){
         
            return false;
        }

        File file = new File("DB/"+path+"/",fileName+".json");
        path = path.replaceAll("//", path);
        if (!file.exists()) {

                //DBMS.debug("La tabla " +fileName + " ha sido creado en la base de datos " + path );

        return true;
        }else{
            DBMS.debug("LA TABLA" +fileName + " YA EXISTE EN LA BASE DE DATOS" + path );
            return false;
    }
    }
     /**
     * Este método sirve para revisar si existe un archivo para la tabla
     * @param path
     * @param fileName
     * @return true si existe, false si no
     */
    public boolean checkFile(String path,String fileName){
       
        File file = new File("DB/"+path+"/"+fileName+".json");
      
        return file.exists();
    }
    /**
     * Este método sirve para revisar si existe una base de datos
     * @param db nombre de la base de datos
     * @return true si existe, false si no existe.
     */
    public boolean checkDB(String db){
        if (db.isEmpty()){
            DBMS.debug("ERROR, LA BASE DE DATOS NO ES VÁLIDA");
            return false;
        }

        File file = new File("DB/"+db+"/");
        
        if (!file.exists()) {

           return false;
        }else{
            
            return true;
    }
    }
    
    public void eliminarDB(String nombreDB){
        File directory = new File("DB/"+nombreDB);
        try{
            deleteFile(directory);
        }
        catch(Exception e){}
    }
    
    public boolean deleteTable(String dbActual, String nombreTabla) {
        File file = new File("DB/"+dbActual+"/"+nombreTabla+".json");
        return file.delete();
    }
        
    public void deleteFile(File file) throws IOException{
 
    	if(file.isDirectory()){
 
    		//directory is empty, then delete it
    		if(file.list().length==0){
    			
    		   file.delete();
    		   DBMS.debug("LA BASE DE DATOS HA SIDO ELIMINADA: " 
                                                 + file.getAbsolutePath());
    			
    		}else{
    			
    		   //list all the directory contents
        	   String files[] = file.list();
     
        	   for (String temp : files) {
        	      //construct the file structure
        	      File fileDelete = new File(file, temp);
        		 
        	      //recursive delete
        	      deleteFile(fileDelete);
        	   }
        		
        	   //check the directory again, if empty then delete it
        	   if(file.list().length==0){
           	    file.delete();
                    DBMS.debug("LA BASE DE DATOS HA SIDO ELIMINADA : "
                                + file.getAbsolutePath());
                   }
    		}
    		
    	}else{
    		//if file, then delete it
    		file.delete();
    		DBMS.debug("EL ARCHIVO HA SIDO ELIMINADO: " + file.getAbsolutePath());
    	}
    }
    
    public void renameFile(String db,String file1, String file2){
        File oldfile =new File("DB/"+file1);
        File newfile =new File("DB/"+file2);

        if(oldfile.renameTo(newfile)){
               DBMS.debug("SE HA RENOMBRADO LA BASE DE DATOS");
        }else{
               DBMS.debug("ERROR, NO SE HA PODIDO RENOMBRAR LA BASE DE DATOS");
        }
        
        
    }
    
    public void renameFileJSON(String db, String file1, String file2){
        File oldfile =new File("DB/"+db+"/"+file1+".json");
        File newfile =new File("DB/"+db+"/"+file2+".json");

        if(oldfile.renameTo(newfile)){
               DBMS.debug("SE HA RENOMBRADO EL ARCHIVO" + file1 +" a " +file2);
        }else{
               DBMS.debug("ERROR: NO SE HA RENOMBRADO EL ARCHIVO " + file1 +" a " +file2);
        }
    }
    
}
