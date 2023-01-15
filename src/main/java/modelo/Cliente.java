
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cliente extends Persona{
    
    private TipoCliente tipoCliente;
    
public Cliente(String codigo, String nombre, String direccion, String telefono){    
    super(codigo,nombre,direccion,telefono);
    this.tipoCliente = tipoCliente;
}

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

@Override
    public String toString() {
        return super.toString() + " - " + tipoCliente ;
    }
    
    public static ArrayList<Cliente> cargarLista(){
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/clientes.txt"));){
            br.readLine();
            String linea;
            while ((linea = br.readLine())!=null){
                String[] datos = linea.split(","); 
                clientes.add(new Cliente(datos[0],datos[1],datos[2],datos[3]));
            }
        }catch (IOException e){
            
        }
        return clientes;
    }
 
    public static void sobreescribirFichero(ArrayList<Cliente> clientes){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/clientes.txt"));){
            bw.write("codigo,nombre,telefono,tipoCliente");
            for(Cliente c:clientes){
                bw.newLine();
                bw.write(c.getCod()+","+c.getNom()+","+c.getTel()+","+c.tipoCliente);
            }
        }catch (IOException e){
            System.out.println("error");
        }
    }
    
    
}
