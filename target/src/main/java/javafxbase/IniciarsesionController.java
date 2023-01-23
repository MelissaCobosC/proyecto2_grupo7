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
import modelo.Usuario;

public class IniciarsesionController implements Initializable {
    
    ArrayList<Usuario> usuarioLista = Usuario.cargarListaU(); //lista donde carga los datos que hay en el txt de usuario
    
    //nombres que pertenecen a nodos hijos de la interfaz
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
        //extrae lo que el usuario ingreso en los textfield y los guarda en variables
        String user = usuario.getText();
        String pass = clave.getText();
        int cont=0; //va a sumar los intentos correctos, verificando que la informacion ingresada es correcta
        for(Usuario u: usuarioLista){ //recorre la lista usuario en donde si pertence a un nivel lo lleve a la interfaz de ese
            GenerarOrdenController.setNombreUsuario(user);
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
                        iniciarSesion.setDisable(true);
                    }
                }
               cont++; 
            }
        }
        
        //si no ingresa los datos correctos va a presentar una alerta
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
