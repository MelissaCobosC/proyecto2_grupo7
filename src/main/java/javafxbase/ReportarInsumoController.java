package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText("¿Estas seguro de confirmar la acción?");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Reporte");
        alerta.setHeaderText("Su reporte ha sido enviado correctamente");
        alerta.showAndWait(); 
        
        } 
    }

    @FXML
    private void btnJugar(ActionEvent event) throws IOException {
        App.setRoot("sesionClientes");
    }
}
