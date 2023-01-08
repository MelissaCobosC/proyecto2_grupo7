package javafxbase;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class IniciarsesionController implements Initializable {


    @FXML
    private TextField usuario;
    @FXML
    private TextField clave;
    @FXML
    private Button iniciarSesion;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }

    public boolean verificar(){
        String user = usuario.getText();
        String pass = clave.getText();
       // ArrayList<Cliente> clientes = Cliente. 
   return false; }
    
}
