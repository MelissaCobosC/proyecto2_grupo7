
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cliente extends Persona{
    private String tipoCliente;
    
public Cliente(String codigo, String nombre, String direccion, String telefono, String tipoCliente){    
    super(codigo,nombre,direccion,telefono);
    this.tipoCliente = tipoCliente;
}

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    
    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    

@Override
    public String toString() {
        return super.toString() + " - " + tipoCliente ;
    }
    
    public static ArrayList<Cliente> cargarLista3(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/clientes.txt"));){
            br.readLine();
            String linea;
            while ((linea = br.readLine())!=null){
                String[] datos = linea.split(","); 
                clientes.add(new Cliente(datos[0],datos[1],datos[2],datos[3],datos[4]));
            }
        }catch (IOException e){
            
        }
        return clientes;
    }
 
    public static void sobreescribirFichero(ArrayList<Cliente> clientes){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/clientes.txt"));){
            bw.write("cedula,nombre,direccion,telefono,tipoCliente");
            for(Cliente c:clientes){
                bw.newLine();
                bw.write(c.getCod()+","+c.getNom()+","+c.getDir()+","+c.getTel()+","+c.getTipoCliente());
            }
        }catch (IOException e){
            System.out.println("error");
        }
    }
    
    
}
