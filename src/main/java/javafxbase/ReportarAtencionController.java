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
    
    //Listas que se usaran, cargan los txt 
    ArrayList<Usuario> usuarios = cargarListaU();
    ArrayList<Cliente> clientes = cargarLista3();
    ArrayList<Orden> ordenes = cargarLista();
    ArrayList<Servicio> servicios = cargarLista1();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //se agregan los datos a la tabla
        this.colTecnico.setCellValueFactory(new PropertyValueFactory<>("nombTecnico"));
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

    //Boton consultar el cual va a presentar la informacion que se requiere saber en la tabla contenido
    @FXML
    private void consultarAtencion(ActionEvent event) {
        //listas de las clases con las que se va a trabajar
        List<Orden> ordenes = Orden.cargarLista();
        List<Servicio> servicios = Servicio.cargarLista1();
        //extrae lo que el usuario ingreso en los textfield y los guarda en variables
        int añol = Integer.parseInt(this.año.getText());
        int mesl = Integer.parseInt(this.mes.getText());
        
        int intento = 0; //va a sumar los intentos correctos, verificando que la informacion ingresada es correcta
        ArrayList<Orden> ordenTecnico = new ArrayList<>(); //lista en la que se va a guardar la informacion obtenida
        //Se va a recorrer la lista de usuario con un foreach y si tiene tecnico va a recorrer la lista de ordenes
        //en donde va a comparar la informacion ingresada por el usuario por lo que se encuentra en esa linea del txt,
        //si es igual, da paso a comparar los nombres del tecnico en donde si son iguales se va a sumar cada total 
        //recaudado por cada tecnico en el contador
        for(Usuario u:usuarios){ 
            int cont = 0;
            if("tecnico".equals(u.getNivel())){
            
                for(Orden o: ordenes){
                    if((añol == o.getAnio() && mesl == o.getMes())){
                        if(o.getNombTecnico().equals(u.getNombre())){
                            cont += o.getTotal();
                            reestablecer(año, mes);
                        }
                        intento++;
                    }
                }
                ordenTecnico.add(new Orden(cont, u.getNombre())); //constructor que se encuentra en la clase orden
            }
        }
        this.tablaAtencion.getItems().setAll(ordenTecnico);//va a llenar la tabla 
        
        //si no ingresa los datos correctos va a presentar una alerta
        if (intento == 0) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("datos incorrectos");
            alerta.setHeaderText("ingrese datos validos");
            alerta.showAndWait();
            reestablecer(año, mes);
        }      
    }

    //boton de regresar a inicio 
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
