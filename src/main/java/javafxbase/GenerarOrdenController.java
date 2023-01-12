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
public class GenerarOrdenController implements Initializable {

    @FXML
    private TextField cod;
    @FXML
    private TextField fec;
    @FXML
    private TextField placa;
    @FXML
    private TableView<?> tablaGenerar;
    @FXML
    private TableColumn<?, ?> colCliente;
    @FXML
    private TableColumn<?, ?> colTotal;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    }
    
}
