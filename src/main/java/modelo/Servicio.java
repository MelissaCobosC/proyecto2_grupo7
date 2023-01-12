package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Servicio {
    public String codigo, nombre;
    public double precio;
    
    public Servicio(String codigo, String nombre, double precio){
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public void setPrecio(double p){
        this.precio = p;
    }
     public String getCodigo(){
         return codigo;
     }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return  codigo +" - "+ nombre+" - "+precio ;
    }
    
    public static ArrayList<Servicio> cargarLista(){
        ArrayList<Servicio> servicios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/servicios.txt"));){
            br.readLine();
            String linea;
            while ((linea = br.readLine())!=null){
                String[] datos = linea.split(","); 
                servicios.add(new Servicio(datos[0],datos[1],Double.parseDouble(datos[2].strip())));
            }
        }catch (IOException e){
            
        }
        return servicios;
    }
    
    
}
