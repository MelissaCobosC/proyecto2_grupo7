package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private TableView<Proveedor> tablaProveedor;
    @FXML
    private TableColumn colCed;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colDir;
    @FXML
    private TableColumn colTelf;
    
     @FXML
    private Label cedulalb;

    @FXML
    private TextField cedulatf;
    
    @FXML
    private Label direccionlb;

    @FXML
    private TextField direcciontf;
    
    @FXML
    private Label nombrelb;

    @FXML
    private TextField nombretf;
    
    @FXML
    private Label telefonolb;

    @FXML
    private TextField telefonotf;
   
    private void cargarProveedores(){
       this.colCed.setCellValueFactory(new PropertyValueFactory<>("codigo"));
       this.colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
       this.colDir.setCellValueFactory(new PropertyValueFactory<>("direccion"));
       this.colTelf.setCellValueFactory(new PropertyValueFactory<>("telefono"));
       tablaProveedor.getItems().setAll(listaproveedores);
    }
    
    @FXML
    private Button agregar;
    @FXML
    private Button editar;
    @FXML
    private Button eliminar;
    
    @FXML
    private Button volverAdmin;
   
    public  Proveedor getTablaProveedorSeleccionado() {
        if (tablaProveedor != null) {
            List<Proveedor> tabla = tablaProveedor.getSelectionModel().getSelectedItems();
            if (tabla.size() == 1) {
                Proveedor pvSeleccionado = tabla.get(0);
                return pvSeleccionado;
            }
            
        }
        return null; 
    }
    
    @FXML
    public  void mostrarProveedorSeleccionado(){
        tablaProveedor.setOnMouseClicked((Event ev) -> {
            Proveedor proveedor = getTablaProveedorSeleccionado();
            cedulatf.setText(proveedor.getCodigo());
            nombretf.setText(proveedor.getNombre());
            direcciontf.setText(proveedor.getDireccion());
            telefonotf.setText(proveedor.getTelefono());
            cedulatf.setDisable(true);
        });
    
    }
    
     @FXML
    private void agregarProveedor(ActionEvent event) throws IOException {
    App.setRoot("agregarProveedor");
    }
    
         @FXML
    private void editarProveedores(ActionEvent event) throws IOException {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Editar Proveedor");
        alert.setContentText("Esta seguro de que quiere editar?");     
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            String cedula = this.cedulatf.getText();
            String nombre = this.nombretf.getText();
            String direccion = this.direcciontf.getText();
            String telefono = this.telefonotf.getText();
            
            Proveedor proveedor = new Proveedor(cedula,nombre,direccion,telefono);
        
            int indice =  listaproveedores.indexOf(getTablaProveedorSeleccionado());
            listaproveedores.set(indice, proveedor);
              
        } else {
            alert.close();
        } 
    }
    
    @FXML
    private void eliminarProveedores(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Eliminar Cliente");
        alert.setContentText("Esta seguro de que quiere eliminar?");     
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            listaproveedores.remove(getTablaProveedorSeleccionado());
            cargarProveedores();
              
        } else {
            alert.close();
        }
    }
    @FXML
    private void volvermenuAdmin(ActionEvent event) throws IOException {
    App.setRoot("administrador");
    }
    
}
