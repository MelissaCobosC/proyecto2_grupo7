package javafxbase;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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


public class ConsultarOrdenController implements Initializable {

    @FXML
    private TextField codigo;
    @FXML
    private TextField fecha;
    @FXML
    private TextField cliente;
    @FXML
    private TableView<Orden> tablaConsulta;
    @FXML
    private TableColumn<Orden, String> colCod;
    @FXML
    private TableColumn<Orden, String> colFecha;
    @FXML
    private TableColumn<Orden, String> colCliente;
    @FXML
    private TableColumn<Orden, Double> colTotal;

    ArrayList<Orden> ordenes = cargarLista();//llamamos al metodo cargar Lista de ordenes 
    ArrayList<Cliente> clientes = cargarLista3();//llamamos al metodo cargar Lista de clientes 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.colCod.setCellValueFactory(new PropertyValueFactory<>("codigoCliente"));
        this.colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaServicio"));
        this.colCliente.setCellValueFactory(new PropertyValueFactory<>("nombreCliente"));
        this.colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        tablaConsulta.getItems().setAll(ordenes);//mostramos la tabla con los datos existentes 
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
    private void filtrar(ActionEvent event) throws IOException {
        filtro();//llamamos al metodo filtro para cuando usemos el boton "ver detalle" muestre la informacion 
    }

    private void btnJugar(ActionEvent event) throws IOException {
        App.setRoot("sesionClientes");
    }

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        App.setRoot("iniciaSesion");
    }

    private static void reestablecer(TextField c1, TextField c2, TextField c3) {//metodo para limpiar los componentes
        c1.setText(null);
        c2.setText(null);
        c3.setText(null);
    }

    public void filtro() throws IOException {
        String cod = codigo.getText();
        String fec = fecha.getText();
        String cli = cliente.getText();

        ArrayList<Orden> filtroOrden = new ArrayList<>();
        int cont = 0;//el contador nos ayudará a validar cuando exista ingreso datos incorrectos
        for (Orden o : ordenes) {
            if (codigo.getText() != null) {
                if (cod.equals(o.getCodigoCliente())) { //comparar que codigo del textField con el codigo de ordenes
                    filtroOrden.add(o);
                    cont++;
                }
            } if (cliente.getText() != null) {
                if (cli.equals(o.getNombreCliente())) { //comparar cliente del textField con el cliente de ordenes
                    filtroOrden.add(o);
                    cont++;
                }
            }
            if (fecha.getText() != null) {
                if (fec.equals(o.getFechaServicio())) { //comparar la fecha ingresada a la fecha de la orden requerida
                    filtroOrden.add(o);
                    cont++;
                }
            }
        }
        if (cont == 0) { //si los datos son incorrectos presenta mensaje de error
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("datos incorrectos");
            alerta.setHeaderText("ingrese datos validos para la consulta");
            alerta.showAndWait();
            App.setRoot("consultarOrden");
        }
        tablaConsulta.getItems().setAll(filtroOrden);//llenamos la tabla con los datos requeridos
        reestablecer(codigo, fecha, cliente);//llamamos al metodo que limpia los componentes 
    }
}
