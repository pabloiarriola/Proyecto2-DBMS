/**
* Universidad Del Valle de Guatemala
* Pablo Arriola		Andres Oliva
*/

package dbms;

/**
 * Esta estructura sirve para guardar las columnas disponibles para cada tabla.
 * El atributo tamaño solo aplica para chars.
 * @author Pablo
 */
public class TuplaColumna {
    
    private String nombre;
    private String tipo;
    private int tamaño;

    public TuplaColumna(String tipo, String nombre) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.tamaño = 0;
    }

    public TuplaColumna(String nombre, String tipo, int tamaño) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.tamaño = tamaño;
    }
    
    
    public TuplaColumna(String nombre) {
        this.nombre = nombre;
        this.tamaño = 0;
    }

    public TuplaColumna() {
        this.tamaño = 0;
    }
   
    public String getNombre() {
       
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return "Tupla{" + "nombre=" + nombre + ", tipo=" + tipo + '}';
    }
}
