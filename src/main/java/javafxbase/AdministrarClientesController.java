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

import modelo.Cliente;


public class AdministrarClientesController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//       listaclientes = new FXCollections.observableArrayList();
//       colCod.setCellValueFactory(new PropertyValueFactory<Cliente,String>("codigo"));
//       colNombre.setCellValueFactory(new PropertyValueFactory<Cliente,String>("nombre"));
//       colDir.setCellValueFactory(new PropertyValueFactory<Cliente,String>("direccion"));
//       colTelf.setCellValueFactory(new PropertyValueFactory<Cliente,String>("telefono"));
//       colTipo.setCellValueFactory(new PropertyValueFactory<Cliente,String>("tipo"));
//       
//       tablaClientes.setItems(listaclientes);
//        
    }    
    
    
    
   
    ArrayList<Cliente> listacliente = Cliente.cargarLista3();
   
    @FXML
    private TableView<Cliente> tablaClientes;
    @FXML
    private TableColumn colCod;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colDir;
    @FXML
    private TableColumn colTelf;
    @FXML
    private TableColumn colTipo;
    
    ObservableList<Cliente> listaclientes;
    
    
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
