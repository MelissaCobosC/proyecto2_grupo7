package javafxbase;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import modelo.Usuario;
/**
 * FXML Controller class
 *
 * @author USUARIO
 */
public class IniciarsesionController implements Initializable {
    
    ArrayList<Usuario> usuarioLista = Usuario.cargarLista();
    
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
    
    @FXML
    public void verificar() throws IOException{
        String user = usuario.getText();
        String pass = clave.getText();
        int cont=0;
        for(Usuario u: usuarioLista){
            if(user.equals(u.getUsuario()) && pass.equals(u.getClave())){
                 if("admin".equals(u.getNivel())){
                    try {
                        FXMLLoader loader = new FXMLLoader(App.class.getResource("administrador.fxml"));
                        Parent vistaAdmin = loader.load();
                        App.setRoot(vistaAdmin);
                    } 
                    catch (IOException ex) {
                        iniciarSesion.setDisable(true);
                    }
                }
                if("tecnico".equals(u.getNivel())){
                    try {
                        FXMLLoader loader = new FXMLLoader(App.class.getResource("generarOrden.fxml"));
                        Parent vistaTecnico = loader.load();
                        App.setRoot(vistaTecnico);
                    } 
                    catch (IOException ex) {
                        ex.printStackTrace();
                        iniciarSesion.setDisable(true);
                    }
                    }
                else if("cobranzas".equals(u.getNivel())){
                    try {
                        FXMLLoader loader = new FXMLLoader(App.class.getResource("generaFactura.fxml"));
                        Parent vistaCobranzas = loader.load();
                        App.setRoot(vistaCobranzas);
                    }
                    catch (IOException ex) {
                        ex.printStackTrace();
                        iniciarSesion.setDisable(true);
                    }
                }
               cont++; 
            }
        }
        if(cont==0){
    Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Alerta");
                alert.setContentText("Su usuario o contraseña son erroneas, intentelo de nuevo");

                alert.showAndWait();
                App.setRoot("iniciaSesion");
                alert.close();
        }
    }
}
