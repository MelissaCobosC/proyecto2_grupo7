package modelo;

public abstract class Persona {
protected String codigo, nombre, direccion, telefono;

    public Persona(String codigo, String nombre, String direccion, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
public String getCod() {
        return codigo;
    }

    public String getNom() {
        return nombre;
    }

    public String getTel() {
        return telefono;
    }


    public String getDir() {
        return direccion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString() {
        return codigo + " - " + nombre + " - " + direccion + " - " + telefono ; 
        
    }
    
    
    
}
