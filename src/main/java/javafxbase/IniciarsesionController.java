/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package javafxbase;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class IniciarsesionController implements Initializable {


    @FXML
    private TextField usuario;
    @FXML
    private TextField clave;
    @FXML
    private Button iniciarSesion;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }

    public boolean verificar(){
        String user = usuario.getText();
        String pass = clave.getText();
        ArrayList<Cliente> clientes = Cliente. 
    }
    
}
