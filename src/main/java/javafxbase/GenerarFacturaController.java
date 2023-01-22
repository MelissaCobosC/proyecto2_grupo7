package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.*;
import static modelo.Cliente.cargarLista3;
import static modelo.Orden.cargarLista;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class GenerarFacturaController implements Initializable {

    @FXML
    private TextField anio;
    @FXML
    private TextField mes;
    @FXML
    private TextField codigo;
    @FXML
    private TableView<Orden> tablaFactura;
    @FXML
    private TableColumn<Orden, String> colPlaca;
    @FXML
    private TableColumn<Orden, String> colFecha;
    @FXML
    private TableColumn<Orden, String> colTipo;
    @FXML
    private TableColumn<Orden, String> colServicio;
    @FXML
    private TableColumn<Orden, Integer> colCant;
    @FXML
    private TableColumn<Orden, Double> colTotal;
    @FXML
    private Label totalPagar;
    @FXML
    private Label empresa;
    @FXML
    private Label periodo;
    ArrayList<Cliente> clientes = cargarLista3();
    ArrayList<Orden> ordenes = cargarLista();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.colPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        this.colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaServicio"));
        this.colTipo.setCellValueFactory(new PropertyValueFactory<>("tipoVehiculo"));
        this.colServicio.setCellValueFactory(new PropertyValueFactory<>("nombreServicio"));
        this.colCant.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
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
    private void consultaGenerar(ActionEvent event) {
        List<Orden> ordenes = Orden.cargarLista();
        int anio1 = Integer.parseInt(this.anio.getText());
        int mes1 = Integer.parseInt(this.mes.getText());

        List<Orden> ordenesEncontradas = new ArrayList<>();
        Double pagoFinal = 50.0;
        int cont = 0;
        for (Orden orden : ordenes) {
            final boolean cumpleCodigo = codigo.getText().equals(orden.getCodigoCliente());
            final boolean cumpleAnio = anio1 == orden.getAnio();
            final boolean cumpleMes = mes1 == orden.getMes();
            if (cumpleCodigo && cumpleAnio && cumpleMes) {
                pagoFinal += orden.getTotal();
                ordenesEncontradas.add(orden);
                periodo.setText(Month.of(mes1).toString() + " " + Integer.toString(anio1));
                for (Cliente c : clientes) {
                    if (orden.getCodigoCliente().equals(c.getCodigo())) {
                        empresa.setText(c.getNombre());
                    }
                }
                cont++;
            }
        }
        totalPagar.setText(Double.toString(pagoFinal));
        this.tablaFactura.getItems().setAll(ordenesEncontradas);

        if (cont == 0) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("datos incorrectos");
            alerta.setHeaderText("ingrese datos validos para generar la factura");
            alerta.showAndWait();
            reestablecer(codigo, anio, mes);
        }
    }

    @FXML
    private void regresar(ActionEvent event) throws IOException {
        App.setRoot("iniciaSesion");
    }

    private static void reestablecer(TextField c1, TextField c2, TextField c3) {
        c1.setText(null);
        c2.setText(null);
        c3.setText(null);
    }

}
