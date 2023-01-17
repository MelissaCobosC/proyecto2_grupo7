
package modelo;


public class Celda {
    
    public String value;
    public int row;
    public int col;
    public boolean adivina;

    public Celda(String value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
        this.adivina = false;
    }
    
}
