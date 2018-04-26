/**
* Universidad Del Valle de Guatemala
* Pablo Arriola 	Andres Oliva
*/

package dbms;

/**
 *
 * @author Pablo
 */
public class TuplaCheck {
    
    private String op1;
    private String op2;
    private String operador;
    private String operadorLogico;

    public TuplaCheck(String op1, String op2, String operador) {
        this.op1 = op1;
        this.op2 = op2;
        this.operador = operador;
    }

    public TuplaCheck() {
    }

    public String getOp1() {
        return op1;
    }

    public void setOp1(String op1) {
        this.op1 = op1;
    }

    public String getOp2() {
        return op2;
    }

    public void setOp2(String op2) {
        this.op2 = op2;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public String getOperadorLogico() {
        return operadorLogico;
    }

    public void setOperadorLogico(String operadorLogico) {
        this.operadorLogico = operadorLogico;
    }
    
    

    @Override
    public String toString() {
        return "TuplaCheck{" + "op1=" + op1 + ", op2=" + op2 + ", operador=" + operador + '}';
    }
    
    
    

}
