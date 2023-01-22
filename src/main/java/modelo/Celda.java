
package modelo;

//clase que indica el tamaño de la matriz que se usara para ir poniendo las cartas
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
