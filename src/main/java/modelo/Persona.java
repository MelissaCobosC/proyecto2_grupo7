package modelo;

public abstract class Persona {
protected String codigo, nombre, direccion, telefono;

    public Persona(String codigo, String nombre, String direccion, String telefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " - " + direccion + " - " + telefono ;
    }
    
    
    
}
