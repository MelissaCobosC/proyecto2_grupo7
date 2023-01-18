package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modelo.Servicio;

/**
 * FXML Controller class
 *
 * @author carmi
 */
public class AgregarServicioController implements Initializable {

    @FXML
    private Button volverAdmin;
    @FXML
    private Label codigolb;
    @FXML
    private Label nombrelb;
    @FXML
    private Label preciolb;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    ArrayList<Servicio> listaServicio = Servicio.cargarLista1();
   
    @FXML
    private Button btnaceptar;
    @FXML
    private TextField codigotf;
    @FXML
    private TextField nombretf;
    @FXML
    private TextField preciotf;
   
    
    
    @FXML
    private void aceptarServicio(ActionEvent event) throws IOException {
        String codigo = codigotf.getText();
        String nombre = nombretf.getText();
        Double precio  = Double.parseDouble(preciotf.getText());
        Servicio s = new Servicio(codigo,nombre,precio);
        listaServicio.add(s);
        Servicio.sobreescribirFicheroServicio(listaServicio);
        App.setRoot("administrarServicios");
    }
    
    
    @FXML
    private void volveradministrarClientes(ActionEvent event) throws IOException {
    App.setRoot("administrarServicios");
    }
}