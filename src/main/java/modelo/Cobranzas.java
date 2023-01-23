
package modelo;

import java.util.ArrayList;


public class Cobranzas extends Usuario{
    
    public Cobranzas(String usuario, String clave, String nombre, String tipoUsuario) {
        super(usuario,clave,nombre,tipoUsuario); 
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
    
}