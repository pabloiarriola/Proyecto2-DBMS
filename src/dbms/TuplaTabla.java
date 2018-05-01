/**
* Universidad Del Valle de Guatemala
* Pablo Arriola   Andres Oliva
*/

package dbms;

/**
 * Esta estructura sirve para el archivo maestro de cada tabla.
 * Se actualiza o se debería actualizar la cantidad de registros con cada insert statement.
 * @author Pablo
 */
public class TuplaTabla {
    private String nombreTabla;
    private int cantidadRegistros = 0;

    public TuplaTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public int getCantidadRegistros() {
        return cantidadRegistros;
    }

    public void setCantidadRegistros(int cantidadRegistros) {
        this.cantidadRegistros = cantidadRegistros;
    }

    
     public void registroIncrease(){
        this.cantidadRegistros++;
    }
    
    @Override
    public String toString() {
        return "TuplaTabla{" + "nombreTabla=" + nombreTabla + ", cantidadRegistros=" + cantidadRegistros + '}';
    }
   
}