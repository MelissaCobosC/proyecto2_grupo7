
package javafxbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import modelo.*;


public class JuegoMemoriaController implements Initializable {

    
    Board board;
    Celda primeraCarta = null;
    Celda segundaCarta = null;
    
    @FXML
    public GridPane gameMatrix;
    @FXML
    private AnchorPane root;
    @FXML
    private BorderPane body;
    @FXML
    private HBox menuPanel;
    @FXML
    private Button start;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
        this.board = new Board();
        
        try {
            
            this.board.llenandoGridPane();
            for(int row=0; row<4; row++){
                for(int col=0; col<4; col++){
                    FileInputStream input = new FileInputStream("src/main/resources/archivos/pregunta.png");
                    Image image = new Image(input);
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(110);
                    imageView.setFitHeight(110);
                    imageView.setUserData(row + "," + col);
                    imageView.setOnMouseClicked(event -> {
                        try {
                            clickCarta(event);
                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    });
                    gameMatrix.add(imageView, row, col);
                }
            }
     
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }    
    
    public void clickCarta(MouseEvent event) throws FileNotFoundException{
        Node node = (Node)event.getSource();
        String posicion = (String)node.getUserData();
        int rowSeleccionada = Integer.parseInt(posicion.split(",")[0]);
        int colSeleccionada = Integer.parseInt(posicion.split(",")[1]);
        String imagen = board.board[rowSeleccionada][colSeleccionada].value;
        FileInputStream input = new FileInputStream("src/main/resources/archivos/"+imagen+".png");
        
        Image imagenSelecionada = new Image(input);
        ((ImageView)node).setImage(imagenSelecionada);
        parejaEncontrada(rowSeleccionada, colSeleccionada);
     
    }
    
    public void parejaEncontrada(int rowSeleccionada, int colSeleccionada) throws FileNotFoundException{
        if(primeraCarta == null){
            primeraCarta = board.board[rowSeleccionada][colSeleccionada];
        }else if(segundaCarta == null){
            segundaCarta = board.board[rowSeleccionada][colSeleccionada];
        }else{
            if(primeraCarta.value.equals(segundaCarta.value)){
            board.board[primeraCarta.row][primeraCarta.col].adivina = true;
            board.board[segundaCarta.row][segundaCarta.col].adivina = true;
            }else{
                
                FileInputStream input = new FileInputStream("src/main/resources/archivos/pregunta.png");
                
                int indicePrimeraCarta = (primeraCarta.row * 4) + primeraCarta.col;
                ((ImageView)gameMatrix.getChildren().get(indicePrimeraCarta)).setImage(new Image(input));
                
                int indiceSegundaCarta = (segundaCarta.row * 4) + segundaCarta.col;
                ((ImageView)gameMatrix.getChildren().get(indiceSegundaCarta)).setImage(new Image(input));
            
            }
        primeraCarta = board.board[rowSeleccionada][colSeleccionada];
        segundaCarta = null;
        }
         
    }  

    @FXML
    private void volver(ActionEvent event) {
    }
}
