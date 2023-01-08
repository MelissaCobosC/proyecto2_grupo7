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
    @Override
    public String toString() {
        return codigo + " - " + nombre + " - " + direccion + " - " + telefono ;
    }
    
    
    
}
