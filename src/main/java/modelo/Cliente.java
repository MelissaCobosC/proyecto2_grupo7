
package modelo;

public class Cliente extends Persona{
    
    private TipoCliente tipoCliente;
    
public Cliente(String codigo, String nombre, String direccion, String telefono){    
    super(codigo,nombre,direccion,telefono);
    this.tipoCliente = tipoCliente;
}

@Override
    public String toString() {
        return super.toString() + " - " + tipoCliente ;
    }

}
