
package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Proveedor extends Persona{

    public Proveedor(String codigo, String nombre, String direccion, String telefono) {
        super(codigo, nombre, direccion, telefono);
    }

    @Override
    public String toString() {
        return super.toString();
    }
    
    public static ArrayList<Proveedor> cargarListaProveedor(){
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/proveedores.txt"));){
            br.readLine();
            String linea;
            while ((linea = br.readLine())!=null){
                String[] datos = linea.split(","); 
                proveedores.add(new Proveedor(datos[0],datos[1],datos[2],datos[3]));
            }
        }catch (IOException e){
            
        }
        return proveedores;
    }
    
    public static void sobreescribirFicheroServicio(ArrayList<Proveedor> proveedores){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/proveedores.txt"));){
            bw.write("cedula,nombre,direccion,telefono");
            for(Proveedor p:proveedores){
                bw.newLine();
                bw.write(p.getCod()+","+p.getNom()+","+p.getDir()+","+p.getTel());
            }
        }catch (IOException e){
            System.out.println("error");
        }
    }
}

