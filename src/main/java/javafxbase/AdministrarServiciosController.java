package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cliente;

import modelo.Servicio;


public class AdministrarServiciosController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarServicios();
    }    
    
    
    
   
    ArrayList<Servicio> listaservicios = Servicio.cargarLista1();
   
    @FXML
    private TableView<Servicio> tablaServicios;
    @FXML
    private TableColumn<Servicio,String> colCod;
    @FXML
    private TableColumn<Servicio,String> colNombre;
    @FXML
    private TableColumn <Servicio,Integer> colPrecio;
   
    
   
    
    
    @FXML
    private Button agregar;
    @FXML
    private Button editar;
    @FXML
    private Button eliminar;
    
    @FXML
    private Button volverAdmin;
   
    
    private void cargarServicios(){
       this.colCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
       this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
       this.colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
       
       tablaServicios.getItems().setAll(listaservicios);
    }
    
    public  Servicio getTablaServicioSeleccionado() {
        if (tablaServicios != null) {
            List<Servicio> tabla = tablaServicios.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                Servicio svSeleccionado = tabla.get(0);
                return svSeleccionado;
            }
            
        }
        return null; 
    }
    
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
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Eliminar Cliente");
        alert.setContentText("Esta seguro de que quiere eliminar?");     
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            listaservicios.remove(getTablaServicioSeleccionado());
            cargarServicios();
              
        } else {
            alert.close();
        }
    }
    
    
    
    @FXML
    private void volvermenuAdmin(ActionEvent event) throws IOException {
    App.setRoot("administrador");
    }
    
}