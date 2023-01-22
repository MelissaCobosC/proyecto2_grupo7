
package modelo;

import java.util.ArrayList;


public class Cobranzas extends Usuario{
        //constructor de la clase Cobranzas que es clase hija de Usuario 
    public Cobranzas(String usuario, String clave, String nombre, String tipoUsuario) {
        //recibe el super de la clase padre Usuario
        super(usuario,clave,nombre,tipoUsuario); 
    }

    //getters & setters
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