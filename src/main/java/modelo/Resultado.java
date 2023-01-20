package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Resultado {
    private String resNom, resTiempo;
    private int  resAciertos, resFallos;
    private LocalDate resFecha = LocalDate.now();

    public Resultado(String resNom, String resTiempo, int resAciertos, int resFallos) {
        this.resNom = resNom;
        this.resTiempo = resTiempo;
        this.resAciertos = resAciertos;
        this.resFallos = resFallos;
    }
    
    public Resultado(String resNom, LocalDate localDate, String resTiempo, int resAciertos, int resFallos) {
        this.resNom = resNom;
        this.resFecha = localDate;
        this.resTiempo = resTiempo;
        this.resAciertos = resAciertos;
        this.resFallos = resFallos;
    }

    public String getResNom() {
        return resNom;
    }

    public int getResAciertos() {
        return resAciertos;
    }

    public int getResFallos() {
        return resFallos;
    }

    public String getResTiempo() {
        return resTiempo;
    }

    public LocalDate getResFecha() {
        return resFecha;
    }
    public static ArrayList<Resultado> cargarListaRes(){
        ArrayList<Resultado> resultados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/resultados.txt"));){
            br.readLine();
            String linea;
            while ((linea = br.readLine())!=null){
                String[] datos = linea.split(","); 
                resultados.add(new Resultado(datos[0],LocalDate.parse(datos[1]),datos[2],Integer.parseInt(datos[3]),Integer.parseInt(datos[4])));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return resultados;
    }
    
    public static void sobreescribirResultados(List<Resultado> resultados){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/resultados.txt"));){
            bw.write("nombre,fecha,tiempoTotal,aciertos,fallos");
            for(Resultado r:resultados){
                bw.newLine();
                bw.write(r.getResNom()+","+r.getResFecha()+","+r.getResTiempo()+","+r.getResAciertos()+","+r.getResFallos());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
    

