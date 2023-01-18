package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Cliente;
import static modelo.Cliente.cargarLista3;
import modelo.Orden;
import static modelo.Orden.cargarLista;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
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

    ArrayList<Orden> ordenes = cargarLista();
    ArrayList<Cliente> clientes = cargarLista3();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.colCod.setCellValueFactory(new PropertyValueFactory<>("codigoCliente"));
        this.colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaServicio"));
       // this.colCliente.setCellValueFactory(new PropertyValueFactory<>("placa"));
        this.colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

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
    private void verDetalle(ActionEvent event) {
    }

    @FXML
    private void filtrar(ActionEvent event) {
        String cod = codigo.getText();
        String fec = fecha.getText();
        String cli = cliente.getText();

        ArrayList<Orden> filtroOrden = new ArrayList<>();
        for (Orden o : ordenes) {
            if (cod.equals(o.getCodigoCliente())) {
                filtroOrden.add(o);
            }
        }
        tablaConsulta.getItems().setAll(filtroOrden);
        codigo.setText(null);
        fecha.setText(null);
        cliente.setText(null);
    }

    @FXML
    private void btnJugar(ActionEvent event) throws IOException {
        App.setRoot("sesionClientes");
    }

}
