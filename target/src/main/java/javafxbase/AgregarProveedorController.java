package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Proveedor;

/**
 * FXML Controller class
 *
 * @author carmi
 */
public class AgregarProveedorController implements Initializable {

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
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    ArrayList<Proveedor> listaProveedores = Proveedor.cargarListaProveedor();
   
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
    private void aceptarProveedor(ActionEvent event) throws IOException {
        String codigo = codigotf.getText();
        String nombre = nombretf.getText();
        String direccion = direcciontf.getText();
        String telefono = telefonotf.getText();
        
        
        Proveedor c = new Proveedor(codigo,nombre,direccion,telefono);
        listaProveedores.add(c);
        Proveedor.sobreescribirFicheroProveedor(listaProveedores);
        App.setRoot("administrarProveedores");
    }
    
    
    @FXML
    private void volveradministrarProveedores(ActionEvent event) throws IOException {
    App.setRoot("administrarProveedores");
    }
}
