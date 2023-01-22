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

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
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

    ArrayList<Orden> ordenes = cargarLista();
    ArrayList<Cliente> clientes = cargarLista3();
    ArrayList<Servicio> servicios = cargarLista1();
    ArrayList<String> listVehiculo = Orden.listaTipoVehiculo();

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
        comboBoxVehiculo.getItems().setAll(listVehiculo);
        tablaGenerar.getItems().setAll(ordenes);
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
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo().contains(codigo)) {

                double total = 0;
//                int cont2 = 0;
                for (Servicio ts : servicios) {
                        if (servicio.equals(ts.getCodigo())) {
                            total = ts.getPrecio() * Integer.parseInt(cantidad);
//                            cont2++;
                        }
                }
//                if (cont2 == 0) {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setTitle("Codigo de servicio invalido");
//                    alert.setContentText("El codigo de servicio ingresado no existe, por favor reescriba su orden con datos validos");
//                    reestablecer(cod, fec, placa, codServicio, textCant, comboBoxVehiculo);
//                }

                ordenes.add(new Orden(codigo, fecha, numPlaca, tipo, servicio, Integer.parseInt(cantidad), total));
                tablaGenerar.getItems().setAll(ordenes);
                Orden.sobreescribirFichero(ordenes);//se agrega una orden nueva
                Servicio.sobreescribirFicheroServicio(servicios);
                reestablecer(cod, fec, placa, codServicio, textCant, comboBoxVehiculo);
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Orden Registrada");
                alerta.setHeaderText("Su orden ha sido registrada, revise al final de la tabla");
                alerta.showAndWait();
                cont++;
            }
        }
        if (cont == 0) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Codigo de cliente invalido");
            alerta.setHeaderText("El codigo de cliente ingresado no existe, por favor reescriba su orden con datos validos");
            alerta.showAndWait();
            reestablecer(cod, fec, placa, codServicio, textCant, comboBoxVehiculo);
        }

    }

    private void btnJugar(ActionEvent event) throws IOException {
        App.setRoot("sesionClientes");
    }

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        App.setRoot("iniciaSesion");
    }

    private static void reestablecer(TextField c1, TextField c2, TextField c3, TextField c4, TextField c5, ComboBox c6) {
        c1.setText(null);
        c2.setText(null);
        c3.setText(null);
        c4.setText(null);
        c5.setText(null);
        c6.setValue(null);
    }
}
