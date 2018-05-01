/**
* Universidad Del Valle de Guatemala
* Pablo Arriola   Andres Oliva
*/

package dbms;

/**
 * Esta estructura sirve para guardar en el archivo maestro de 
 * bases de datos, el nombre de la BD y la cantidad de tablas.
 * Se actualiza la cantidad de tablas con cada create table statement.
 * @author Pablo
 */
public class TuplaDB {

    private String nombreDB;
    private int cantidadTablas =0;

    public TuplaDB(String nombreDB) {
        this.nombreDB = nombreDB;
    }

    public TuplaDB(String nombreDB, int cantidadTablas) {
        this.nombreDB = nombreDB;
        this.cantidadTablas = cantidadTablas;
    }

    public String getNombreDB() {
        return nombreDB;
    }

    public void setNombreDB(String nombreDB) {
        this.nombreDB = nombreDB;
    }

    public int getCantidadTablas() {
        return cantidadTablas;
    }

    public void setCantidadTablas(int cantidadTablas) {
        this.cantidadTablas = cantidadTablas;
    }
    public void tablaIncrease(){
        this.cantidadTablas++;
    }
    
    @Override
    public String toString() {
        return "TuplaDB{" + "nombreDB=" + nombreDB + ", cantidadTablas=" + cantidadTablas + '}';
    }
    
}