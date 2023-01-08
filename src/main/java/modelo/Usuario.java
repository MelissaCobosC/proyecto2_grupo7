package modelo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Usuario {
    protected String usuario, clave, nombre, nivel;
    protected ArrayList<Usuario> userLista;   
    

    public Usuario(String usuario, String clave, String nombre, String nivel) {
        this.usuario = usuario;
        this.clave = clave;
        this.nombre = nombre;
        this.nivel = nivel;
        this.userLista = new ArrayList<Usuario>();
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

    @Override
    public String toString() {
        return "Usuario{" + "usuario=" + usuario + ", clave=" + clave + ", nombre=" + nombre + ", nivel=" + nivel  + '}';
    }
    
   public static ArrayList<Usuario> cargarLista(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/usuarios.txt"));){
            br.readLine();
            String linea;
            while ((linea = br.readLine())!=null){
                String[] datos = linea.split(","); 
                usuarios.add(new Usuario(datos[0],datos[1],datos[2],datos[3]));
            }
        }catch (IOException e){
            
        }
        return usuarios;
    }
    
}
