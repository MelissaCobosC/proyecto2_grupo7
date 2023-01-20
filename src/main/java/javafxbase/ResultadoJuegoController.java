package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Resultado;
import static modelo.Resultado.cargarListaRes;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class ResultadoJuegoController implements Initializable {

    @FXML
    private TableView<Resultado> tablaResultados;
    @FXML
    private TableColumn<Resultado, String> colNom;
    @FXML
    private TableColumn<Resultado, ZonedDateTime> colFec;
    @FXML
    private TableColumn<Resultado, Integer> colTiempo;
    @FXML
    private TableColumn<Resultado, Integer> colAcierta;
    @FXML
    private TableColumn<Resultado, Integer> colFalla;
    
    ArrayList<Resultado> resultados = cargarListaRes();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.colNom.setCellValueFactory(new PropertyValueFactory<>("resNom"));
        this.colFec.setCellValueFactory(new PropertyValueFactory<>("resFecha"));
        this.colTiempo.setCellValueFactory(new PropertyValueFactory<>("resTiempo"));
        this.colAcierta.setCellValueFactory(new PropertyValueFactory<>("resAciertos"));
        this.colFalla.setCellValueFactory(new PropertyValueFactory<>("resFallos"));
        tablaResultados.getItems().setAll(resultados);
        
    }    

    @FXML
    private void regresarMenu(ActionEvent event) throws IOException {
        App.setRoot("administrador");
    }
    
}
