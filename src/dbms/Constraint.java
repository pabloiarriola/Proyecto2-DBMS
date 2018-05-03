package dbms;

import java.util.ArrayList;

/**
 * Esta clase tiene como objetivo modelar cada constraint simple en una tabla.
 * @author Andres
 */
public class Constraint {
    
    private String nombre;
    private String tipo;
    private ArrayList<String> references;
    private TuplaRefForeign referencesForeign;
    private ArrayList<TuplaCheck>  tuplaCheck;

    public Constraint(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.references = new ArrayList();
        this.tuplaCheck = new ArrayList();
        
    }
    
    public Constraint(){
        this.references = new ArrayList();
        this.tuplaCheck = new ArrayList();
        
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

    public ArrayList<String> getReferences() {
        return references;
    }

    public void setReferences(ArrayList<String> references) {
        this.references = references;
    }
    
    public void setReferencesForeign(TuplaRefForeign references) {
        this.referencesForeign = references;
    }
    
    public TuplaRefForeign getReferencesForeign(){
        return this.referencesForeign;
    }

    public ArrayList<TuplaCheck> getTuplaCheck() {
        return tuplaCheck;
    }

    public void setTuplaCheck(ArrayList<TuplaCheck> tuplaCheck) {
        this.tuplaCheck = tuplaCheck;
    }

   public void addTuplaCheck(TuplaCheck tupla){
       this.tuplaCheck.add(tupla);
   }

    @Override
    public String toString() {
        return "Constraint{" + "nombre=" + nombre + ", tipo=" + tipo + ", references=" + references + ", referencesForeign=" + referencesForeign + ", tuplaCheck=" + tuplaCheck + '}';
    }
    
    

    
    
            

}
