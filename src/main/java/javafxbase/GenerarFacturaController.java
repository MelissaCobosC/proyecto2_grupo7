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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cliente;
import static modelo.Cliente.cargarLista3;
import modelo.Orden;

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
        int anio = Integer.parseInt(this.anio.getText());
        int mes = Integer.parseInt(this.mes.getText());

        List<Orden> ordenesEncontradas = new ArrayList<>();
        Double pagoFinal = 50.0;
        for (Orden orden : ordenes) {
            final boolean cumpleCodigo = codigo.getText().equals(orden.getCodigoCliente());
            final boolean cumpleAnio = anio == orden.getAnio();
            final boolean cumpleMes = mes == orden.getMes();
                if (cumpleCodigo && cumpleAnio && cumpleMes) {
                    pagoFinal += orden.getTotal();
                    ordenesEncontradas.add(orden);
                    periodo.setText(Month.of(mes).toString() + " " + Integer.toString(anio));
                    for (Cliente c : clientes) {
                        if (orden.getCodigoCliente().equals(c.getCodigo())) {
                            empresa.setText(c.getNombre());
                    }
                }
            }
        }
        totalPagar.setText(Double.toString(pagoFinal));

        this.tablaFactura.getItems().setAll(ordenesEncontradas);
    }

}
