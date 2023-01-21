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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import modelo.Cliente;
import modelo.Orden;
import static modelo.Orden.cargarLista;
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
    ArrayList<Orden> ordenes = cargarLista();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
}
