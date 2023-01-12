package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class ReportarInsumoController implements Initializable {

    @FXML
    private TextArea reporte;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void consultarOrden(ActionEvent event) throws IOException {
    App.setRoot("consultarOrden");
    }

    @FXML
    private void generarOrden(ActionEvent event) throws IOException {
    App.setRoot("generarOrden");
    }

    @FXML
    private void reportarInsumo(ActionEvent event) throws IOException {
    App.setRoot("reportarInsumo");
    }

    @FXML
    private void enviarReporte(ActionEvent event) {
    }
    
}
