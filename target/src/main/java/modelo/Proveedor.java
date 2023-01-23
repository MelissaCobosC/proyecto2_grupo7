
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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    

    @Override
    public String toString() {
        return super.toString();
    }
    
    //metodo que devuelve una lista que va a contener lo que se encuentra en el txt del proveedor
    //este metodo lee linea por linea del txt y las guarda en un arraylist 
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
    
    //este metodo agrega una linea al txt con informacion en especifico que se ha ingresado en el controller proveedores 
    public static void sobreescribirFicheroProveedor(ArrayList<Proveedor> proveedores){
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

