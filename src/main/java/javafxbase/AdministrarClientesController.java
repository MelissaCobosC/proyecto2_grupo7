
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

import modelo.Cliente;


public class AdministrarClientesController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       /* DefaultTableModel model = new DefaultTableModel(varclientes,0);
        
        for(int i=0;i<listaclientes.size();i++){
            String Cedula = listaclientes.get(i).getCod();
            String Nombre = listaclientes.get(i).getNom();
            String Direccion = listaclientes.get(i).getDir();
            String Telefono = listaclientes.get(i).getTel();
            String Tipo = listaclientes.get(i).getTipoCliente();
            
            Object[] data = {Cedula,Nombre,Direccion,Telefono,Tipo};
            model.add(data);
        }
        tablaClientes = newJtable(model);*/
        
    }    
    
    
    
   /* Jtable tablaClientes;
    String[] varclientes = {"Codigo","Nombre","Direccion","Telefono","Tipo"};
    ArrayList<Cliente> listaclientes = Cliente.cargarLista();*/
   
    @FXML
    private TableView<Cliente> tablaClientes;
    @FXML
    private TableColumn<Cliente, String> colCod;
    @FXML
    private TableColumn<Cliente, String> colNombre;
    @FXML
    private TableColumn<Cliente, String> colDir;
    @FXML
    private TableColumn<Cliente, String> colTelf;
    @FXML
    private TableColumn<Cliente, String> colTipo;
    
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
