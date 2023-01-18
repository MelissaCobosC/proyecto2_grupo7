package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import modelo.Proveedor;


public class AdministrarProveedoresController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarProveedores();
    }    
    
    
    
   
    ArrayList<Proveedor> listaproveedores = Proveedor.cargarListaProveedor();
   
    @FXML
    private TableView<Proveedor> tablaClientes;
    @FXML
    private TableColumn colCed;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colDir;
    @FXML
    private TableColumn colTelf;
   
    private void cargarProveedores(){
       this.colCed.setCellValueFactory(new PropertyValueFactory<>("codigo"));
       this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
       this.colDir.setCellValueFactory(new PropertyValueFactory<>("direccion"));
       this.colTelf.setCellValueFactory(new PropertyValueFactory<>("telefono"));
       tablaClientes.getItems().setAll(listaproveedores);
    }
   
    
    
    @FXML
    private Button agregar;
    @FXML
    private Button editar;
    @FXML
    private Button eliminar;
    
    @FXML
    private Button volverAdmin;
   
    
     @FXML
    private void agregarProveedor(ActionEvent event) throws IOException {
    App.setRoot("agregarProveedor");
    }
    
         @FXML
    private void editarProveedores(ActionEvent event) throws IOException {
    App.setRoot("administrarProveedores");
    }
    
    @FXML
    private void eliminarProveedores(ActionEvent event) throws IOException {
    App.setRoot("administrarProveedores");
    }
    
    
    
    @FXML
    private void volvermenuAdmin(ActionEvent event) throws IOException {
    App.setRoot("administrador");
    }
    
}
