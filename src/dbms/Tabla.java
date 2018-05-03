/**
* Universidad Del Valle de Guatemala
* Pablo Arriola
* Andres Oliva
*/

package dbms;

import java.util.ArrayList;

/**
 * Esta clase modela la cada estructura tabla que se guarda en un JSON.
 * @author Pablo
 */
public class Tabla {
    
    private final ArrayList<TuplaColumna> tablaDeclaration;
    private final ArrayList<Constraint> constraints;
    private ArrayList<ArrayList> tableData;

    public Tabla(){
        this.tablaDeclaration = new ArrayList(50);
        this.constraints = new ArrayList(50);
        this.tableData = new ArrayList(10000);
    }
    
    public void agregarColumna(TuplaColumna tupla){
        tablaDeclaration.add(tupla);
        printColumns();
    }
    
    public ArrayList<TuplaColumna> getColumnas(){
        return this.tablaDeclaration;
    }
    
    public void merge(Tabla t){
       this.tablaDeclaration.addAll(t.getColumnas());
    }
    
    public void printColumns(){
        for (int i = 0;i<this.tablaDeclaration.size();i++){
            System.out.println(tablaDeclaration.get(i));
        }
    }
    
    public ArrayList<Constraint> getConstraints(){
        return this.constraints;
    }
    
    public void addConstraint(Constraint constraint){
        this.constraints.add(constraint);
    }

    public void addRowToTable(ArrayList element) {
        this.tableData.add(element);
    }
    
    public ArrayList<ArrayList> getDataInTable() {
        return this.tableData;
    }
    
    //devolver el indice y el tipo
    public ArrayList getIndexOfColumn(String nombreColumna){
        ArrayList array = new ArrayList();
        for (int i = 0;i<this.tablaDeclaration.size();i++){
            TuplaColumna tupla = this.tablaDeclaration.get(i);
            if (tupla.getNombre().equals(nombreColumna)){
                array.add(i);
                array.add(tupla.getTipo());
                if (tupla.getTipo().equals("CHAR"))
                    array.add(tupla.getTamaño());
                return array;
            }
        }
        return new ArrayList();
    }
    
    public boolean checkPrimaryKey(String nombreColumna){
        for (Constraint constraint : this.constraints) {
            if (constraint.getTipo().equals("PRIMARY") &&
                    constraint.getReferences().contains(nombreColumna)) {
                return true;
            }
        }
        return false;
    }
    
    
    @Override
    public String toString() {
        return "Tabla{" + "tablaDeclaration=" + tablaDeclaration + ", constraints=" + constraints + '}';
    }
    
    
}
