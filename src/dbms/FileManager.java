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
               DBMS.debug("Base de datos creada");
            }
            else{
                 DBMS.debug("Ha ocurrido un error");
                return false;
            }
        return true;
        }else{
             DBMS.debug("La base de datos ya existe");
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
            DBMS.debug("La tabla " +fileName + " ya existe en la base de datos " + path );
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
            DBMS.debug("La base de datos es inválida");
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
    		   DBMS.debug("Base de datos eliminada : " 
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
                    DBMS.debug("Base de datos eliminada : "
                                + file.getAbsolutePath());
                   }
    		}
    		
    	}else{
    		//if file, then delete it
    		file.delete();
    		DBMS.debug("Archivo eliminado : " + file.getAbsolutePath());
    	}
    }
    
    public void renameFile(String db,String file1, String file2){
        File oldfile =new File("DB/"+file1);
        File newfile =new File("DB/"+file2);

        if(oldfile.renameTo(newfile)){
               DBMS.debug("Se ha renombrado la base de datos");
        }else{
               DBMS.debug("No se ha podido renombrar la base de datos");
        }
        
        
    }
    
    public void renameFileJSON(String db, String file1, String file2){
        File oldfile =new File("DB/"+db+"/"+file1+".json");
        File newfile =new File("DB/"+db+"/"+file2+".json");

        if(oldfile.renameTo(newfile)){
               DBMS.debug("Se ha renombrado el archivo " + file1 +" a " +file2);
        }else{
               DBMS.debug("Error: No se ha renombrado " + file1 +" a " +file2);
        }
    }
    
}
