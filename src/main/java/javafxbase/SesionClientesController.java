package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import modelo.Cliente;
import static modelo.Cliente.cargarLista3;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class SesionClientesController implements Initializable {

    @FXML
    private TextField nombre;
    @FXML
    private TextField cedula;

    ArrayList<Cliente> listClientes = cargarLista3();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void jugar(ActionEvent event) throws IOException {
        String nom = nombre.getText();
        String ced = cedula.getText();
        int cont=0;
        for (Cliente c : listClientes) {
            if (nom.equals(c.getNom()) && ced.equals(c.getCod())) {
                JuegoMemoriaController.setJugador(nom);
                App.setRoot("juegoMemoria");
                cont++; 
            }
            
        }
        if(cont==0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alerta");
                alert.setContentText("Su usuario o cedula son erroneas, intentelo de nuevo");

                alert.showAndWait();
                App.setRoot("sesionClientes");
                alert.close();
        }
        Cliente.sobreescribirFichero(listClientes);
    }

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        App.setRoot("administrador");
    }

}
