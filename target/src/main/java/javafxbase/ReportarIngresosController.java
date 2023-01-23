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
import modelo.*;
import static modelo.Cliente.cargarLista3;
import static modelo.Orden.cargarLista;
import static modelo.Servicio.cargarLista1;


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

    //Listas que se usaran, cargan los txt 
    ArrayList<Cliente> clientes = cargarLista3();
    ArrayList<Orden> ordenes = cargarLista();
    ArrayList<Servicio> servicios = cargarLista1();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //se agregan los datos a la tabla
        this.colServicio.setCellValueFactory(new PropertyValueFactory<>("nombreServicio"));
        this.colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));    
    }    

    //Son los botones para ir de una pestaña a otra siempre y cuando pertenezca al 
    //usuario con el que se ingreso
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
        int añol = Integer.parseInt(this.año.getText());
        int mesl = Integer.parseInt(this.mes.getText());
        
        int intento = 0; //va a sumar los intentos correctos, verificando que la informacion ingresada es correcta
        ArrayList<Orden> ordenesIgual = new ArrayList<>(); //lista en la que se va a guardar la informacion obtenida
        //Se va a recorrer la lista de servicio con un foreach y va a recorrer la lista de ordenes
        //en donde va a comparar la informacion ingresada por el usuario por lo que se encuentra en el txt,
        //si es igual, da paso a comparar los codigos en donde si son iguales se va a sumar cada total 
        //recaudado por cada servicio en el contador
        for(Servicio s: servicios){
            int cont = 0;
            for(Orden o: ordenes){
                if((añol == o.getAnio() && mesl == o.getMes())){
                    if(o.getCodServicio().equals(s.getCodigo())){
                        cont += o.getTotal();
                        reestablecer(año, mes);
                    }
                    intento++;
                }
            
            }
            
            ordenesIgual.add(new Orden(s.getNombre(), cont)); //constructor que se encuentra en la clase orden
        }
        
        this.tablaIngresos.getItems().setAll(ordenesIgual); //va a llenar la tabla 
        
        //si no ingresa los datos correctos va a presentar una alerta
        if (intento == 0) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("datos incorrectos");
            alerta.setHeaderText("ingrese datos validos para reportar los ingresos");
            alerta.showAndWait();
            reestablecer(año, mes);
        }
    }

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        App.setRoot("iniciaSesion");
    }
    
    //metodo para limpiar los textfield una vez se haya ingresado la informacion
    private static void reestablecer(TextField c1, TextField c2) {
        c1.setText(null);
        c2.setText(null);
    }
    
}
