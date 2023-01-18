/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxbase;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author carmi
 */
public class EditarClienteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    private Button btnaceptar;

    @FXML
    private Label codigolb;

    @FXML
    private TextField codigotf;

    public TextField getCodigotf() {
        return codigotf;
    }

    public TextField getDirecciontf() {
        return direcciontf;
    }

    public TextField getNombretf() {
        return nombretf;
    }

    public TextField getTelefonotf() {
        return telefonotf;
    }

    public TextField getTipotf() {
        return tipotf;
    }

    @FXML
    private Label direccionlb;

    @FXML
    private TextField direcciontf;

    @FXML
    private Label nombrelb;

    @FXML
    private TextField nombretf;

    @FXML
    private Label telefonolb;

    @FXML
    private TextField telefonotf;

    @FXML
    private Label tipoclientelb;

    @FXML
    private TextField tipotf;

    @FXML
    private Button volverAdmin;

    @FXML
    private void aceptarCliente(ActionEvent event) {
        
    }

    @FXML
    private void volveradministrarClientes(ActionEvent event) {

    }

}
