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

import modelo.Servicio;


public class AdministrarServiciosController implements Initializable {

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
    
    
    
   
    ArrayList<Servicio> listacliente = Servicio.cargarLista1();
   
    @FXML
    private TableView<Servicio> tablaServicios;
    @FXML
    private TableColumn colCod;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colPrecio;
   
    
    ObservableList<Servicio> listaservicios;
    
    
    @FXML
    private Button agregar;
    @FXML
    private Button editar;
    @FXML
    private Button eliminar;
    
    @FXML
    private Button volverAdmin;
   
    
     @FXML
    private void agregarServicio(ActionEvent event) throws IOException {
    App.setRoot("agregarServicio");
    }
    
    @FXML
    private void editarServicio(ActionEvent event) throws IOException {
    App.setRoot("administrarServicio");
    }
    
    @FXML
    private void eliminarServicio(ActionEvent event) throws IOException {
    App.setRoot("administrarServicio");
    }
    
    
    
    @FXML
    private void volvermenuAdmin(ActionEvent event) throws IOException {
    App.setRoot("administrador");
    }
    
}