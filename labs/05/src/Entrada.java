import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Entrada {

    private List<Relleno> rellenos;

    public Entrada() {
        rellenos = new ArrayList<>();
        cargarDesdeArchivo();
    }

    private void cargarDesdeArchivo() {
        try (Scanner scanner = new Scanner(new File("rellenos.csv"))) {
            while (scanner.hasNextLine()) {
                String[] datosRellenos = scanner.nextLine().split(",");
                Relleno temp = new Relleno(Integer.parseInt(datosRellenos[0]), datosRellenos[1], Float.parseFloat(datosRellenos[2]));
                rellenos.add(temp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo de municipios: " + e.getMessage());
        }
    }
    
    public float[] rellenosPorMesTodos(){
        float rellenosMes[] = new float [12];
        int i=0;
        while (i<rellenos.size()){
            Relleno temp = rellenos.get(i);
            
            switch (temp.mes) {
                case "ENERO":
                    rellenosMes[0] += temp.cantidad;
                    break;
                case "FEBRERO":
                    rellenosMes[1] += temp.cantidad;
                    break;
                case "MARZO":
                    rellenosMes[2] += temp.cantidad;
                    break;
                case "ABRIL":
                    rellenosMes[3] += temp.cantidad;
                    break;
                case "MAYO":
                    rellenosMes[4] += temp.cantidad;
                    break;
                case "JUNIO":
                    rellenosMes[5] += temp.cantidad;
                    break;
                case "JULIO":
                    rellenosMes[6] += temp.cantidad;
                    break;
                case "AGOSTO":
                    rellenosMes[7] += temp.cantidad;
                    break;
                case "SEPTIEMBRE":
                    rellenosMes[8] += temp.cantidad;
                    break;
                case "OCTUBRE":
                    rellenosMes[9] += temp.cantidad;
                    break;
                case "NOVIEMBRE":
                    rellenosMes[10] += temp.cantidad;
                    break;
                case "DICIEMBRE":
                    rellenosMes[11] += temp.cantidad;
                    break;
                default:
                    System.out.println("Error: El mes "+temp.mes+" no esta dentro de las posibles.");
                    break;
            }
            
            
            i++;
        }
        
        return rellenosMes;
    }
    
    public float[] rellenosPorMesAnio() {
        float rellenosMes[] = new float[12];
        int i = 0;
        while (i < rellenos.size()) {
            Relleno temp = rellenos.get(i);

            if(temp.anio>2020){
                switch (temp.mes) {
                    case "ENERO":
                        rellenosMes[0] += temp.cantidad;
                        break;
                    case "FEBRERO":
                        rellenosMes[1] += temp.cantidad;
                        break;
                    case "MARZO":
                        rellenosMes[2] += temp.cantidad;
                        break;
                    case "ABRIL":
                        rellenosMes[3] += temp.cantidad;
                        break;
                    case "MAYO":
                        rellenosMes[4] += temp.cantidad;
                        break;
                    case "JUNIO":
                        rellenosMes[5] += temp.cantidad;
                        break;
                    case "JULIO":
                        rellenosMes[6] += temp.cantidad;
                        break;
                    case "AGOSTO":
                        rellenosMes[7] += temp.cantidad;
                        break;
                    case "SEPTIEMBRE":
                        rellenosMes[8] += temp.cantidad;
                        break;
                    case "OCTUBRE":
                        rellenosMes[9] += temp.cantidad;
                        break;
                    case "NOVIEMBRE":
                        rellenosMes[10] += temp.cantidad;
                        break;
                    case "DICIEMBRE":
                        rellenosMes[11] += temp.cantidad;
                        break;
                    default:
                        System.out.println("Error: El mes " + temp.mes + " no esta dentro de las posibles.");
                        break;
                }
            }
            i++;
        }
        return rellenosMes;
    }
    
    
}
