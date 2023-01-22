package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Cliente;

/**
 * FXML Controller class
 *
 * @author carmi
 */
public class AgregarClienteController implements Initializable {

    @FXML
    private Button volverAdmin;
    @FXML
    private Label codigolb;
    @FXML
    private Label nombrelb;
    @FXML
    private Label direccionlb;
    @FXML
    private Label telefonolb;
    @FXML
    private Label tipoclientelb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        this.cmbTipos.getItems().add("personal");
        this.cmbTipos.getItems().add("empresarial");
        
    }    
    ArrayList<Cliente> listaClientes = Cliente.cargarLista3();
   
    @FXML
    private Button btnaceptar;
    @FXML
    private TextField codigotf;
    @FXML
    private TextField nombretf;
    @FXML
    private TextField direcciontf;
    @FXML
    private TextField telefonotf;
    @FXML
    private ComboBox cmbTipos;
    
    
    @FXML
    private void aceptarCliente(ActionEvent event) throws IOException {
        String codigo = codigotf.getText();
        String nombre = nombretf.getText();
        String direccion = direcciontf.getText();
        String telefono = telefonotf.getText();
        String tipo = (String) cmbTipos.getValue();
        
        Cliente c = new Cliente(codigo,nombre,direccion,telefono,tipo);
        listaClientes.add(c);
        Cliente.sobreescribirFichero(listaClientes);
        App.setRoot("administrarClientes");
    }
    
    
    @FXML
    private void volveradministrarClientes(ActionEvent event) throws IOException {
    App.setRoot("administrarClientes");
    }
}
