package javafxbase;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.*;
import static modelo.Cliente.cargarLista3;
import static modelo.Orden.cargarLista;
import static modelo.Servicio.cargarLista1;
import static modelo.Usuario.cargarListaU;


public class GenerarOrdenController implements Initializable {

    @FXML
    private TextField textCant;
    @FXML
    private TextField cod;
    @FXML
    private TextField fec;
    @FXML
    private TextField placa;
    @FXML
    private TextField codServicio;
    @FXML
    private ComboBox<String> comboBoxVehiculo;
    @FXML
    private TableColumn<Orden, String> colFecha;
    @FXML
    private TableColumn<Orden, String> colPlaca;
    @FXML
    private TableColumn<Orden, String> colVehiculo;
    @FXML
    private TableColumn<Orden, String> codServ;
    @FXML
    private TableColumn<Orden, Double> colCant;
    @FXML
    private TableColumn<Orden, Double> codTotal;
    @FXML
    private TableColumn<Orden, String> colCliente;
    @FXML
    private TableView<Orden> tablaGenerar;

    static String nombreUsuario;
    ArrayList<Orden> ordenes = cargarLista();//llamamos al metodo cargar Lista de la clase Orden 
    ArrayList<Usuario> usuarios = cargarListaU();//llamamos al metodo cargar Lista de Usuario 
    ArrayList<Cliente> clientes = cargarLista3();//llamamos al metodo cargar Lista de clientes 
    ArrayList<Servicio> servicios = cargarLista1();//llamamos al metodo cargar Lista de Servicio 
    ArrayList<String> listVehiculo = Orden.listaTipoVehiculo();//llamamos al metodo con los 3 tipos e vehiculos

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.colCliente.setCellValueFactory(new PropertyValueFactory<>("codigoCliente"));
        this.colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaServicio"));
        this.colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        this.colVehiculo.setCellValueFactory(new PropertyValueFactory<>("tipoVehiculo"));
        this.codServ.setCellValueFactory(new PropertyValueFactory<>("codServicio"));
        this.colCant.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        this.codTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        comboBoxVehiculo.getItems().setAll(listVehiculo);//mostramos la lista de vehiculos en el comboBox
        tablaGenerar.getItems().setAll(ordenes);//mostramos la tabla con datos existentes 
    }

    @FXML
    private void consultarOrden(ActionEvent event) throws IOException {
        App.setRoot("consultarOrden");
    }

    @FXML
    private void generarOrden(ActionEvent event) throws IOException {
        App.setRoot("generarOrden");
    }

    @FXML
    private void reportarInsumo(ActionEvent event) throws IOException {
        App.setRoot("reportarInsumo");
    }

    @FXML
    private void agregarOrden(ActionEvent event) {
        String codigo = cod.getText();
        String fecha = fec.getText();
        String numPlaca = placa.getText();
        String servicio = codServicio.getText();
        String tipo = comboBoxVehiculo.getValue();
        String cantidad = textCant.getText();
        int cont = 0;
        String nomTec="";//guarda el nombre del tecnico que registra la orden
        double total = 0;//guarda el total de precio * cantidad   
        for (Cliente cliente : clientes) { //entramos a la lista clientes
            for(Servicio ts : servicios){ //entramos a la lista servicios
            if (cliente.getCodigo().contains(codigo) && servicio.equals(ts.getCodigo())) { //validamos el codigo de cliente y servicio
                total = ts.getPrecio() * Integer.parseInt(cantidad); //el total es el valor del servcio por la cantidad de veces requerido 
                
                for(Usuario usuario: usuarios){ //entramos a la lista de usuarios
                    if(usuario.getUsuario().contains(nombreUsuario)){ //verificamos que el usuario exista en los usuarios de la lista 
                        nomTec=usuario.getNombre(); //guardamos los nombre de tecnicos
                    }
                }
                ordenes.add(new Orden(codigo, fecha, numPlaca, tipo, servicio, Integer.parseInt(cantidad), total,nomTec));//agregamos nueva orden con sus parametros
                tablaGenerar.getItems().setAll(ordenes);//se llena la tabla junto con el nuevo registro
                Orden.sobreescribirFichero(ordenes);//se sobreescribe el archivo txt con los datos nuevos 
                reestablecer(cod, fec, placa, codServicio, textCant, comboBoxVehiculo);//limpiamos los componentes de ingreso
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);//un mensaje que muestre que se ha creado la orden
                alerta.setTitle("Orden Registrada");
                alerta.setHeaderText("Su orden ha sido registrada, revise al final de la tabla");
                alerta.showAndWait();
                cont++;
            }
            }
        }
        if (cont == 0) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);//en caso de que algun codigo no existe, se presenta error 
            alerta.setTitle("Codigo de cliente o servicio invalido");
            alerta.setHeaderText("El codigo de cliente o servicio ingresados no existe, por favor reescriba su orden con datos validos");
            alerta.showAndWait();
            reestablecer(cod, fec, placa, codServicio, textCant, comboBoxVehiculo);//llamamos al metodo reestablecer 
        }

    }

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        App.setRoot("iniciaSesion");
    }
    
    public static void setNombreUsuario(String nombre) {
        nombreUsuario = nombre;
    }
    //metodo para limpiar los componentes de la interfaz grafica 
    private static void reestablecer(TextField c1, TextField c2, TextField c3, TextField c4, TextField c5, ComboBox c6) {
        c1.setText(null);
        c2.setText(null);
        c3.setText(null);
        c4.setText(null);
        c5.setText(null);
        c6.setValue(null);
    }
}
