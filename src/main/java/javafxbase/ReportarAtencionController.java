package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
        this.colTecnico.setCellValueFactory(new PropertyValueFactory<>("nombTecnico"));
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
         
        List<Orden> ordenes = Orden.cargarLista();
        List<Servicio> servicios = Servicio.cargarLista1();
        int añol = Integer.parseInt(this.año.getText());
        int mesl = Integer.parseInt(this.mes.getText());
        
        int intento = 0;
        ArrayList<Orden> ordenTecnico = new ArrayList<>();
        for(Usuario u:usuarios){ 
            int cont = 0;
            if("tecnico".equals(u.getNivel())){
            
                for(Orden o: ordenes){
                    if((añol == o.getAnio() && mesl == o.getMes())){
                    
                        if(o.getNombTecnico().equals(u.getNombre())){
                        
                            cont += o.getTotal();
                        }
                        intento++;
                    
                    }
            
                }
                ordenTecnico.add(new Orden(cont, u.getNombre()));
            }
            
        }
        this.tablaAtencion.getItems().setAll(ordenTecnico);
        
        if (intento == 0) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("datos incorrectos");
            alerta.setHeaderText("ingrese datos validos");
            alerta.showAndWait();
            reestablecer(año, mes);
        }      
    }

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        App.setRoot("iniciaSesion");
    }
    
    private static void reestablecer(TextField c1, TextField c2) {
        c1.setText(null);
        c2.setText(null);
    }
    
}
