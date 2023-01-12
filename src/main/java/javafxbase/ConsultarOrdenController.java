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
import javafx.scene.input.MouseEvent;
import modelo.*;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class ConsultarOrdenController implements Initializable {

    @FXML
    private TableColumn<?, ?> colCliente;
    @FXML
    private TableColumn<?, ?> colTotal;
    ArrayList<Orden> ordenes = Orden.cargarLista();
    @FXML
    private TextField codigo;
    @FXML
    private TextField fecha;
    @FXML
    private TextField cliente;
    @FXML
    private TableView<?> tablaConsulta;
    @FXML
    private TableColumn<?, ?> colCod;
    @FXML
    private TableColumn<?, ?> colFecha;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));
        //tablaGenerar.getItems().setAll(clientes);
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
    private void consultarOrden(MouseEvent event) {
    }

    @FXML
    private void verDetalle(ActionEvent event) {
    }

    
}


//ArrayList<Orden> discriminante = new ArrayList<>();
      //  for (Orden o : ordenes){
        //    if (o.getCodigoCliente().equals(cod.getText())){
          //      discriminante.add(o);
            //}
        //}
        //tablaGenerar.getItems().setAll(discriminante);