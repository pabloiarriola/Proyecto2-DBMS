package dbms;

import java.util.ArrayList;

/**
 * Esta clase tiene como objetivo guardar la meta data de todas las tablas
 * en una base de datos. Se debe crear este archivo por cada DB.
 * @author Andres
 */
public class ArchivoMaestroTabla {
    
    private ArrayList<TuplaTabla> tablas;

    public ArchivoMaestroTabla() {
        this.tablas = new ArrayList();
    }
    
    public ArrayList<TuplaTabla> getTablas() {
        return tablas;
    }

    public void agregarTabla(String nombreTabla){
        this.tablas.add(new TuplaTabla(nombreTabla));
    }
    public void agregarExistente(ArchivoMaestroTabla mdb){
        if (mdb != null)
            this.tablas.addAll(mdb.getTablas());
    }
    
    public void setTablas(ArrayList<TuplaTabla> tablas) {
        this.tablas = tablas;
    }

    @Override
    public String toString() {
        return "ArchivoMaestroTabla{" + "tablas=" + tablas + '}';
    }
    
      public void aumentarColumnaCount(String nombreTabla){
        for (TuplaTabla tabla : this.tablas) {
            if (tabla.getNombreTabla().equals(nombreTabla)) {
                tabla.registroIncrease();
            }
        }
    }
}
