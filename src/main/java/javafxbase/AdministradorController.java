package javafxbase;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class AdministradorController implements Initializable {

    @FXML
    private Button btnvolveriniciosesion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private Button btnclientes;
    @FXML
    private Button btnproovedores;
    @FXML
    private Button btnservidores;
    
    
    
    @FXML
    private void administrarClientes(ActionEvent event) throws IOException {
    App.setRoot("administrarClientes");
    }

    @FXML
    private void administrarServicios(ActionEvent event) throws IOException {
    App.setRoot("administrarServicios");
    }

    @FXML
    private void administrarProovedores(ActionEvent event) throws IOException {
    App.setRoot("administrarProveedores");
    }
    
    @FXML
    private void volverInicioSesion(ActionEvent event) throws IOException {
    App.setRoot("iniciaSesion");
    }

    @FXML
    private void VerResultados(ActionEvent event) throws IOException {
        App.setRoot("resultadoJuego");
    }
    

    @FXML
    private void llamarJuego(ActionEvent event) throws IOException {
        App.setRoot("sesionClientes");
    }

  
}