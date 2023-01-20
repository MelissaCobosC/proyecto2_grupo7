
package javafxbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import modelo.*;


public class JuegoMemoriaController implements Initializable {

    static String nombreJugador;
    Board board;
    Celda primeraCarta = null;
    Celda segundaCarta = null;
    int aciertos = 0;
    int fallos = 0;
    int minuto = 1;
    int segundos = 60;
    Thread temporizador;
    
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
    @FXML
    public Label minutoCronometro;
    @FXML
    public Label segundosCronometro;
    @FXML
    public Label cantidadAciertos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
        instanciarHilo();
        this.board = new Board();
        
        try {
            
            this.board.llenandoGridPane();
            for(int row=0; row<4; row++){
                for(int col=0; col<4; col++){
                    FileInputStream input = new FileInputStream("src/main/resources/imagenes/pregunta.png");
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
        FileInputStream input = new FileInputStream("src/main/resources/imagenes/"+imagen+".png");
        
        Image imagenSelecionada = new Image(input);
        ((ImageView)node).setImage(imagenSelecionada);
        parejaEncontrada(rowSeleccionada, colSeleccionada);
        iniciarTemporizador();
     
    }
    
    public void parejaEncontrada(int rowSeleccionada, int colSeleccionada) throws FileNotFoundException{
        if (primeraCarta == null) {
            primeraCarta = board.board[rowSeleccionada][colSeleccionada];
        } else {
            segundaCarta = board.board[rowSeleccionada][colSeleccionada];
            if (primeraCarta == segundaCarta) {
                segundaCarta = null;
                return;
            }

            if (primeraCarta.value.equals(segundaCarta.value)) {
                board.board[primeraCarta.row][primeraCarta.col].adivina = true;
                board.board[segundaCarta.row][segundaCarta.col].adivina = true;
                aciertos++;
                cantidadAciertos.setText(Integer.toString(aciertos));

                int indicePrimeraCarta = (primeraCarta.row * 4) + primeraCarta.col;
                ((ImageView) gameMatrix.getChildren().get(indicePrimeraCarta)).setOnMouseClicked(null);

                int indiceSegundaCarta = (segundaCarta.row * 4) + segundaCarta.col;
                ((ImageView) gameMatrix.getChildren().get(indiceSegundaCarta)).setOnMouseClicked(null);

            } else {
                fallos++;
                FileInputStream input = new FileInputStream("src/main/resources/imagenes/pregunta.png");
                FileInputStream input2 = new FileInputStream("src/main/resources/imagenes/pregunta.png");

                int indicePrimeraCarta = (primeraCarta.row * 4) + primeraCarta.col;
                ((ImageView) gameMatrix.getChildren().get(indicePrimeraCarta)).setImage(new Image(input));

                int indiceSegundaCarta = (segundaCarta.row * 4) + segundaCarta.col;
                ((ImageView) gameMatrix.getChildren().get(indiceSegundaCarta)).setImage(new Image(input2));

            }
            primeraCarta = null;
            segundaCarta = null;
            if (aciertos == 8) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("¡HAZ GANADO WUP WUP!");
                alert.setTitle("Informacion del juego");
                alert.setContentText("Ha logrado acertar los 8 pares de cartas en el tiempo estimado, ENHORABUENA");
                this.guardarDatos();

                alert.showAndWait();
                try {
                    App.setRoot("juegoMemoria");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                alert.close();
            }
        }
        System.out.println("contador de aciertos: " + aciertos);
        System.out.println("contador de fallos: " + fallos);
         
    }  

    @FXML
    private void volver(ActionEvent event) throws IOException {
        App.setRoot("generarOrden");
    }
    
    @FXML
    public void iniciarTemporizador() {
        try {
            temporizador.start();
        } catch (IllegalThreadStateException ex) {
        }
    }

    private void instanciarHilo() {
        this.temporizador = new Thread(() -> {
            try {
                while (minuto > 0) {
                    if (segundos > 0) {
                        Thread.sleep(1000);
                        segundos -= 1;
                        Platform.runLater(() -> {
                            minutoCronometro.setText("" + minuto);
                            segundosCronometro.setText("" + segundos);
                        });
                    } else if (segundos == 0) {
                        Thread.sleep(1000);
                        minuto -= 1;
                        segundos = 60;
                        Platform.runLater(() -> {
                            minutoCronometro.setText("" + minuto);
                            segundosCronometro.setText("" + segundos);
                        });

                    }
                }
                while (segundos > 0) {
                    Thread.sleep(1000);
                    segundos -= 1;
                    Platform.runLater(() -> {
                        minutoCronometro.setText("" + minuto);
                        segundosCronometro.setText("" + segundos);
                    });

                }
                
            } catch (InterruptedException ex) {
                System.out.println("Error con el metodo sleep");
            } 

            this.guardarDatos();
        });
        temporizador.setDaemon(true);
    }
    
    public static void setJugador(String nombre) {
        nombreJugador = nombre;
    }

    public void guardarDatos() {
        List<Resultado> resultados = Resultado.cargarListaRes();
        String formatoSegundo = (segundos > 9) ? (Integer.toString(segundos)) : ("0" + segundos);
        String tiempo = "0" + minuto + ":" + formatoSegundo;
        resultados.add(new Resultado(nombreJugador, tiempo, aciertos, fallos));
        Resultado.sobreescribirResultados(resultados);
    }
    
}
