
package modelo;

import java.util.ArrayList;
import java.util.List;


public class Tecnico extends Usuario {
    
    private ArrayList<Orden> ordenesTecnico;
   
    public Tecnico(String usuario, String clave, String nombre, String tipoUsuario) {
        super(usuario,clave,nombre,tipoUsuario); 
        ordenesTecnico = new ArrayList();
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public ArrayList<Usuario> getUserLista() {
        return userLista;
    }

    public void setUserLista(ArrayList<Usuario> userLista) {
        this.userLista = userLista;
    }

    public ArrayList<Orden> getOrdenesTecnico() {
        return ordenesTecnico;
    }

    public void setOrdenesTecnico(ArrayList<Orden> ordenesTecnico) {
        this.ordenesTecnico = ordenesTecnico;
    }
    
    public static Usuario getTecnico(String nombTecnico){
        List<Usuario> tecnicos = Usuario.cargarListaU();
        for(Usuario tecnico : tecnicos){
            if(tecnico.getNombre().equals(nombTecnico)){
                return tecnico;
            }
        }
        return null;
    } 
    
    
}
