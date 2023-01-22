package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.*;
import static modelo.Cliente.cargarLista3;
import static modelo.Orden.cargarLista;
import static modelo.Servicio.cargarLista1;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class ReportarIngresosController implements Initializable {

    @FXML
    private TableView<Orden> tablaIngresos;
    @FXML
    private TableColumn<Orden, String> colServicio;
    @FXML
    private TableColumn<Orden, String> colTotal;
    @FXML
    private TextField año;
    @FXML
    private TextField mes;

    ArrayList<Cliente> clientes = cargarLista3();
    ArrayList<Orden> ordenes = cargarLista();
    ArrayList<Servicio> servicios = cargarLista1();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.colServicio.setCellValueFactory(new PropertyValueFactory<>("nombreServicio"));
        this.colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));    }    

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
    private void consultarIngreso(ActionEvent event) {
        List<Orden> ordenes = Orden.cargarLista();
        List<Servicio> servicios = Servicio.cargarLista1();
        int año = Integer.parseInt(this.año.getText());
        int mes = Integer.parseInt(this.mes.getText());
        
        ArrayList<Orden> ordenesIgual = new ArrayList<>();
        for(Servicio s: servicios){
            int cont = 0;
            for(Orden o: ordenes){
                if((año == o.getAnio() && mes == o.getMes())){
                    if(o.getCodServicio().equals(s.getCodigo())){
                        cont += o.getTotal();
                    }
                }
            }
            
            ordenesIgual.add(new Orden(s.getNombre(), cont));
        }
        
        this.tablaIngresos.getItems().setAll(ordenesIgual);
    }

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        App.setRoot("iniciaSesion");
    }
    
}
