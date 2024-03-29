package modelo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    @Override
    public String toString() {
        return  codigo +" - "+ nombre+" - "+precio ;
    }
    
    //metodo que devuelve una lista que va a contener lo que se encuentra en el txt de servicio
    //este metodo lee linea por linea del txt y las guarda en un arraylist 
    public static ArrayList<Servicio> cargarLista1(){
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
    
    //este metodo agrega una linea al txt con informacion en especifico que se ha ingresado en la interfaz
    //agrega un nuevo servicio
    public static void sobreescribirFicheroServicio(ArrayList<Servicio> servicios){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/servicios.txt"));){
            bw.write("codigo,nombre,precio");
            for(Servicio s:servicios){
                bw.newLine();
                bw.write(s.getCodigo()+","+s.getNombre()+","+s.getPrecio());
            }
        }catch (IOException e){
            System.out.println("error");
        }
    }
    
    //en este metodo se puede obtener un objeto de la clase Servicio con informacion en especifica, en este caso
    //el objeto que contenga el mismo codigo que se ingresa por parametro 
    public static Servicio getServicio(String codigo){
        List<Servicio> servicios = Servicio.cargarLista1();
        
        for(Servicio servicio : servicios){
            if(servicio.getCodigo().equals(codigo)){
                return servicio;
            }
        }
        return null;
    }
}
