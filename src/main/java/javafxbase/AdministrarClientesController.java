package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import static modelo.Cliente.cargarLista3;
import modelo.*;


public class AdministrarClientesController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
       cargarClientes();
        
    }    
    
    
    
   
    ArrayList<Cliente> listacliente = cargarLista3();
   
    @FXML
    private TableView<Cliente> tablaClientes;
    @FXML
    private TableColumn<Cliente,String> colCod;
    @FXML
    private TableColumn<Cliente,String> colNombre;
    @FXML
    private TableColumn<Cliente,String> colDir;
    @FXML
    private TableColumn<Cliente,String> colTelf;
    @FXML
    private TableColumn<Cliente,String> colTipo;
    
    
    
    
    @FXML
    private Button agregar;
    @FXML
    private Button editar;
    @FXML
    private Button eliminar;
    
    @FXML
    private Button volverAdmin;
    
    private void cargarClientes(){
       this.colCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
       this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
       this.colDir.setCellValueFactory(new PropertyValueFactory<>("direccion"));
       this.colTelf.setCellValueFactory(new PropertyValueFactory<>("telefono"));
       this.colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoCliente"));
       tablaClientes.getItems().setAll(listacliente);
    }
   
    
     @FXML
    private void agregarClientes(ActionEvent event) throws IOException {
    App.setRoot("agregarCliente");
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
