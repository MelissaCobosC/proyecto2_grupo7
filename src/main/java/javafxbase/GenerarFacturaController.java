/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class GenerarFacturaController implements Initializable {

    @FXML
    private TextField año;
    @FXML
    private TextField mes;
    @FXML
    private TextField codigo;
    @FXML
    private TableView<?> tablaFactura;
    @FXML
    private TableColumn<?, ?> colPlaca;
    @FXML
    private TableColumn<?, ?> colFecha;
    @FXML
    private TableColumn<?, ?> colTipo;
    @FXML
    private TableColumn<?, ?> colServicio;
    @FXML
    private TableColumn<?, ?> colCant;
    @FXML
    private TableColumn<?, ?> colTotal;
    @FXML
    private TextField totalPagar;
    @FXML
    private TextField empresa;
    @FXML
    private TextField periodo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    }
    
}
