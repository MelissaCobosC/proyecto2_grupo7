package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cliente;
import static modelo.Cliente.cargarLista3;
import modelo.Orden;
import static modelo.Orden.cargarLista;
import modelo.Servicio;
import static modelo.Servicio.cargarLista1;
import modelo.Usuario;
import static modelo.Usuario.cargarListaU;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class ReportarAtencionController implements Initializable {

    @FXML
    private TableView<Orden> tablaAtencion;
    @FXML
    private TableColumn<Orden, String> colTecnico;
    @FXML
    private TableColumn<Orden, Double> colTotal;
    @FXML
    private TextField año;
    @FXML
    private TextField mes;
    
    ArrayList<Usuario> usuarios = cargarListaU();
    ArrayList<Cliente> clientes = cargarLista3();
    ArrayList<Orden> ordenes = cargarLista();
    ArrayList<Servicio> servicios = cargarLista1();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.colTecnico.setCellValueFactory(new PropertyValueFactory<>("nombreServicio"));
        this.colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
    }    

    @FXML
    private void generarFactura(ActionEvent event) throws IOException {
    App.setRoot("generaFactura");
    }

    @FXML
    private void reportarIngreso(ActionEvent event) throws IOException {
    App.setRoot("reportarIngresos");
    }

    @FXML
    private void reportarAtencion(ActionEvent event) throws IOException {
    App.setRoot("reportarAtencion");
    
    }

    @FXML
    private void consultarAtencion(ActionEvent event) {
         ArrayList<String> listTecnico = new ArrayList<>();
         
        for(Usuario u:usuarios){ 
            if("tecnico".equals(u.getNivel())){
                listTecnico.add(u.getNombre());
            }
        }
        
        for(Orden o:ordenes){
            
        }                
    }

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        App.setRoot("iniciaSesion");
    }
    
}
