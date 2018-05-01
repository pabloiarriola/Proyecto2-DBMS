/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbms;

import static dbms.ANTGui.jTable1;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pablo
 */
public class GeneralFunctions {
    public JTable generarTabla(ArrayList<ArrayList> datos, ArrayList nombreColumnas) {
        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        // Nombres de columna
        model.setColumnIdentifiers(nombreColumnas.toArray());

        for(int i = 0; i < datos.size(); i++) {
            System.out.println("Datos: " + datos.get(i).toArray());
            model.addColumn("-", datos.get(i).toArray());
            //model.addColumn(datos.get(i).toArray());
        }
        
        return null;
    }
}
