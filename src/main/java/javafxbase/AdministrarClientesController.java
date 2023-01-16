
package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import modelo.Cliente;


public class AdministrarClientesController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //colCed.setItems
    }    
    
    ArrayList<Cliente> clientes = Cliente.cargarLista();
    
    @FXML
    private TableView<?> tablaClientes;
    @FXML
    private TableColumn<?, ?> colCed;
    @FXML
    private TableColumn<?, ?> colNombre;
    @FXML
    private TableColumn<?, ?> colDir;
    @FXML
    private TableColumn<?, ?> colTelf;
    @FXML
    private TableColumn<?, ?> colTipo;
    
    @FXML
    private Button agregar;
    @FXML
    private Button editar;
    @FXML
    private Button eliminar;
    
    @FXML
    private Button volverAdmin;
   
    
     @FXML
    private void agregarClientes(ActionEvent event) throws IOException {
    App.setRoot("administrarClientes");
    }
    
         @FXML
    private void editarClientes(ActionEvent event) throws IOException {
    App.setRoot("administrarClientes");
    }
    
    @FXML
    private void eliminarClientes(ActionEvent event) throws IOException {
    App.setRoot("administrarClientes");
    }
    
    
    
    @FXML
    private void volvermenuAdmin(ActionEvent event) throws IOException {
    App.setRoot("administrador");
    }
    
}
