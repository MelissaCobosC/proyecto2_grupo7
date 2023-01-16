package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Orden {
    private String codigoCliente, fechaServicio, placa, tipoVehiculo, codServicio ; 
    private Double cantidad,total;
    
    
    public Orden(String codigoCliente, String fechaServicio, String placa, String tipoVehiculo, String codServicio, Double cantidad, Double total){
        this.codigoCliente = codigoCliente;
        this.fechaServicio = fechaServicio;
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.codServicio=codServicio;
        this.cantidad=cantidad;
        this.total=total;
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

   public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public String getCodServicio() {
        return codServicio;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public Double getTotal() {
        return total;
    }
  
    public static ArrayList<Orden> cargarLista(){
        ArrayList<Orden> ordenes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/ordenes.txt"));){
            br.readLine();
            String linea;
            while ((linea = br.readLine())!=null){
                String[] datos = linea.split(","); 
                 ordenes.add(new Orden(datos[0],datos[1],datos[2],datos[3],datos[4],Double.parseDouble(datos[5]),Double.parseDouble(datos[6])));
            }
        }catch (IOException e){
            
        }
        return ordenes;
    }
    
    public static void sobreescribirFichero(ArrayList<Orden> ordenes){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/ordenes.txt"));){
            bw.write("Codigo,fecha,placa,tipoVehiculo,cod-serv-valor,cantidad,total");
            for(Orden o:ordenes){
                bw.newLine();
                bw.write(o.getCodigoCliente()+","+o.getFechaServicio()+","+o.getPlaca()+","+o.getTipoVehiculo()+","+o.getCodServicio()+","+o.getCantidad()+","+o.getTotal());
            }
        }catch (IOException e){
            System.out.println("error");
        }
    }
    
    public static ArrayList<String> listaTipoVehiculo() {
       ArrayList<String> listVehiculos = new ArrayList<>();
       ArrayList<Orden> ordenes = cargarLista();
        for(Orden o: ordenes){
            if(!listVehiculos.contains(o.getTipoVehiculo())){
                listVehiculos.add(o.tipoVehiculo);
            }

        }
        return listVehiculos;
    }
    public static ArrayList<String> listaCodServ() {
       ArrayList<String> listCodServ = new ArrayList<>();
       ArrayList<Orden> ordenes = cargarLista();
        for(Orden o: ordenes){
            if(!listCodServ.contains(o.getCodServicio())){
                 //separando codigo de servicio
                //listCodServ.add(o.codServicio);
            }

        }
        return listCodServ;
    }
}

