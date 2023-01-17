
package modelo;

import java.util.Random;

public class Board {
    
    public Celda[][] board = new Celda[4][4];
    
    public void llenandoGridPane(){
       board = new Celda[4][4];
       String[] imagenes = {"monito1", "monito2", "monito3", "monito4", "monito5", "monito6", "monito7", "monito8", "monito9", "monito10", "monito11", "monito12", "monito13", "monito14", "monito15"};
       Random random = new Random();
       while(!completoGridPane()){
           int randomImagen = random.nextInt(imagenes.length);
           String imagenSeleccionada = imagenes[randomImagen];
           int randomRow1 = random.nextInt(4);
           int randomCol1 = random.nextInt(4);
           while(board[randomRow1][randomCol1] != null){
               randomRow1 = random.nextInt(4);
               randomCol1 = random.nextInt(4);
           }
           int randomRow2 = random.nextInt(4);
           int randomCol2 = random.nextInt(4);
           while((randomRow1 == randomRow2 && randomCol1 == randomCol2) || board[randomRow2][randomCol2] != null){
               randomRow2 = random.nextInt(4);
               randomCol2 = random.nextInt(4);
           }
           
           board[randomRow1][randomCol1] = new Celda(imagenSeleccionada, randomRow1, randomCol1);
           board[randomRow2][randomCol2] = new Celda(imagenSeleccionada, randomRow2, randomCol2);
       }
    }
    
    public boolean completoGridPane(){
        
        for(int i=0; i<4; i++){
            for(int j=0; j<4; j++){
                if(board[i][j]==null){
                    return false;
                }
            }
        }
        
        return true;
    }
    
}
