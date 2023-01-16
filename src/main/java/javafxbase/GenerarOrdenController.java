/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
import modelo.*;
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
    private TableView<Orden> tablaGenerar;
    @FXML
    private TableColumn<Orden, String> colCliente;
    @FXML
    private TableColumn<Servicio, Double> colTotal;
    @FXML
    private ComboBox<String> comboBoxVehiculo;
    
    ArrayList<Orden> ordenes = cargarLista();
    ArrayList<Servicio> servicios =cargarLista1();

    ArrayList<String> listVehiculo = Orden.listaTipoVehiculo();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxVehiculo.getItems().addAll(listVehiculo);
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
        String tipo= comboBoxVehiculo.getValue();
        String cantidad = textCant.getText();

        for(Orden or:ordenes){
            double total = 0;
            //double cant=or.getCantidad();
            if(servicio.equals(or.getCodServicio())){
            for(Servicio ts: servicios){
                if(or.getCodServicio().equals(ts.getCodigo())){
                total=ts.getPrecio()*Double.parseDouble(cantidad);
                System.out.println(total);
                }
            }
        }
        ordenes.add(new Orden(codigo, fecha, numPlaca, tipo,servicio,Double.parseDouble(cantidad),total));
        Orden.sobreescribirFichero(ordenes);//se agrega una orden nueva
        cod.setText(null);
        fec.setText(null);
        placa.setText(null);
        codServicio.setText(null);
        comboBoxVehiculo.setValue(null);
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Orden Registrada");
        alerta.setHeaderText("Su orden ha sido registrada");
        alerta.showAndWait();
        }

        //double pago = 0;
        //for(Servicio ts: servicios){
        //if(servicio.equals(ts.getNombre())){
        //double price = ts.getPrecio();
          //          pago+=price;
        //}
        //}
    }
    
}
