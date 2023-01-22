package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Orden {
    private String codigoCliente, fechaServicio, placa, tipoVehiculo, codServicio, usuarioTecnico;
    private String nombreServicio,nombTecnico;
    private String nombreCliente;
    private int cantidad;
    private double total;
    
    public Orden(String codigoCliente, String fechaServicio, String placa, String tipoVehiculo, String codServicio, int cantidad, double total,String usuarioTecnico){
        this.codigoCliente = codigoCliente;
        this.usuarioTecnico=usuarioTecnico;
        this.fechaServicio = fechaServicio;
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.codServicio=codServicio;
        this.cantidad=cantidad;
        this.total=total;
        this.nombTecnico=Usuario.getNomTecnico(usuarioTecnico).getNombre();
        this.nombreServicio = Servicio.getServicio(codServicio).getNombre();
        this.nombreCliente = Cliente.getCodCliente(codigoCliente).getNombre();
    }
    
    //constructor que va a servir para generar las ordenes en el txt 
    public Orden(String codigoCliente, String fechaServicio, String placa, String tipoVehiculo, String codServicio, int cantidad, double total){
        this.codigoCliente = codigoCliente;
        this.fechaServicio = fechaServicio;
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.codServicio=codServicio;
        this.cantidad=cantidad;
        this.total=total;
        this.nombreServicio = Servicio.getServicio(codServicio).getNombre();
        this.nombreCliente = Cliente.getCodCliente(codigoCliente).getNombre();  
    }

    //constructor que va a servir para reportar ingresos en donde solo se necesita el nombreServicio y el total
    public Orden(String nombreServicio, double total) {
        this.nombreServicio = nombreServicio;
        this.total = total;
    }
    
    //constructor que va a servir para llenar la tabla de facturas
    public Orden(String codigoCliente,String fechaServicio,String nombreServicio, double total) {
        this.codigoCliente=codigoCliente;
        this.fechaServicio=fechaServicio;
        this.nombreServicio = nombreServicio;
        this.total = total;
    }
    
    //constructor que va a servir para reportar atencion en donde solo se necesita el nombreTecnico y el total
    public Orden(double total, String nombTecnico) {
        this.nombTecnico = nombTecnico;
        this.total = total;
    }
    
    //getters 
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

    public int getCantidad() {
        return cantidad;
    }
    
    public String getNombreServicio(){
        return nombreServicio;
    }
    
    public String getNombreCliente(){
        return nombreCliente;
    }

    public double getTotal() {
        return total;
    }


    public String getUsuarioTecnico() {
        return usuarioTecnico;
    }

    public String getNombTecnico() {
        return nombTecnico;
    }
    
    //setter de nombre y usuario de tecnico  
    public void setNombTecnico(String nombTecnico) {
        this.nombTecnico = nombTecnico;
    }
    
    public void setUsuarioTecnico(String usuarioTecnico) {
        this.usuarioTecnico = usuarioTecnico;
    }
    
    //metodo que devuelve una lista que va a contener lo que se encuentra en el txt de orden
    //este metodo lee linea por linea del txt y las guarda en un arraylist 
    public static ArrayList<Orden> cargarLista(){
        ArrayList<Orden> ordenes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/ordenes.txt"));){
            br.readLine();
            String linea;
            
            while ((linea = br.readLine())!=null){
                String[] datos = linea.split(","); 
                
                ordenes.add(new Orden(datos[0],datos[1],datos[2],datos[3],datos[4],Integer.parseInt(datos[5]),Double.parseDouble(datos[6]),datos[7]));
            
            }
        }catch (IOException e){
            
        }
        return ordenes;
    }
    
    //este metodo agrega una linea al txt con informacion en especifico que se ha ingresado en la interfaz,
    //ingresa una nueva orden
    public static void sobreescribirFichero(ArrayList<Orden> ordenes){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/ordenes.txt"));){
            bw.write("Codigo,fecha,placa,tipoVehiculo,codServicio,cantidad,total,NombreTecnico");
            for(Orden o:ordenes){
                bw.newLine();
                bw.write(o.getCodigoCliente()+","+o.getFechaServicio()+","+o.getPlaca()+","+o.getTipoVehiculo()+","+o.getCodServicio()+","+o.getCantidad()+","+o.getTotal()+","+o.getNombTecnico());
            }
        }catch (IOException e){
            System.out.println("error");
        }
    }
    
    //es una lista que contiene a los tipos de vehiculos, se usara para un comboBox en generar orden 
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
    
    //nos devuelve el mes de la fecha de las ordenes que es la segunda posicion del string fecha separado por /
    public int getMes(){
        String[] datos = this.fechaServicio.split("/");
        return Integer.parseInt(datos[1]); 
    }
    
    //nos devuelve el año de la fecha de las ordenes que es la tercera posicion del string fecha separado por /
    public int getAnio(){
        String[] datos = this.fechaServicio.split("/");
        return Integer.parseInt(datos[2]);
    }
}

