package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
   
    public  Cliente getTablaClienteSeleccionado() {
        if (tablaClientes != null) {
            List<Cliente> tabla = tablaClientes.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                Cliente clSeleccionado = tabla.get(0);
                return clSeleccionado;
            }
            
        }
        return null; 
    }
    
    
    
    
     @FXML
    private void agregarClientes(ActionEvent event) throws IOException {
    App.setRoot("agregarCliente");
    }
    
    @FXML
    private void editarClientes(ActionEvent event) throws IOException {
    App.setRoot("editarCliente");    
    }
    
    @FXML
    private void eliminarClientes(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Eliminar Cliente");
        alert.setContentText("Esta seguro de que quiere eliminar?");     
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            listacliente.remove(getTablaClienteSeleccionado());
            cargarClientes();
              
        } else {
            alert.close();
        }
    }
    
    
    
    @FXML
    private void volvermenuAdmin(ActionEvent event) throws IOException {
    App.setRoot("administrador");
    }
    
}
