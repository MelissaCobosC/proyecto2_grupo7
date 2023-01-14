package modelo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Orden {
    private String codigoCliente, fechaServicio, placa;
    private TipoVehiculo tipoVehiculo;
    
    
    public Orden(String codigoCliente, String fechaServicio,TipoVehiculo tipoVehiculo, String placa){
        this.codigoCliente = codigoCliente;
        this.fechaServicio = fechaServicio;
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public String getFechaServicio() {
        return fechaServicio;
    }

    public String getPlaca() {
        return placa;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }
  
    public static ArrayList<Orden> cargarLista(){
        ArrayList<Orden> ordenes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/ordenes.txt"));){
            br.readLine();
            String linea;
            while ((linea = br.readLine())!=null){
                String[] datos = linea.split(","); 
                ordenes.add(new Orden(datos[0],datos[1],TipoVehiculo.valueOf(datos[2]),datos[3]));
            }
        }catch (IOException e){
            
        }
        return ordenes;
    }
    
}

