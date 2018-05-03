package dbms;

import java.util.ArrayList;

/**
 * Esta clase tiene como objetivo ser el manejador maestro de las bases de datos
 * y guardar la metadata (cantidad de tablas por base de datos).
 * @author Andres
 */
public class ArchivoMaestroDB {

    private ArrayList<TuplaDB> basesDeDatos;
   
    public ArchivoMaestroDB() {
         this.basesDeDatos = new ArrayList();
    }
   
    public void agregarDB(String nombreDB){
        this.basesDeDatos.add(new TuplaDB(nombreDB));
    }

    public ArrayList<TuplaDB> getNombreDB() {
        return basesDeDatos;
    }

    public void setNombreDB(ArrayList<TuplaDB> nombreDB) {
        this.basesDeDatos = nombreDB;
    }
    
    public void agregarExistente(ArchivoMaestroDB mdb){
        if (mdb != null)
            this.basesDeDatos.addAll(mdb.getNombreDB());
    }
  
    public void aumentarTablaCount(String nombreDB){
        for (int i = 0;i<this.basesDeDatos.size();i++){
            if (basesDeDatos.get(i).getNombreDB().equals(nombreDB)){
                basesDeDatos.get(i).tablaIncrease();
            }
            
        }
    }
    
    
    @Override
    public String toString() {
        return "BaseDatos{" + "nombreDB=" + basesDeDatos+ '}';
    }

}
