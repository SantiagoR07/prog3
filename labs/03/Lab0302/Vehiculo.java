import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

class Vehiculo {
    protected String placa;
    protected String tipo;
    protected Date fechaHoraIngreso;
    protected int numero;
    protected boolean haSalido;
    
    public Vehiculo(String placa, String tipo) {
        this.placa = placa;
        this.tipo = tipo;
        this.fechaHoraIngreso = new Date();
        this.numero = Parqueadero.generarNumeroVehiculo();
        this.haSalido = false;
    }
    
    public void registrarSalida() {
        if (!haSalido) {
            haSalido = true;
            Date fechaHoraSalida = new Date();
            long tiempoTotal = (fechaHoraSalida.getTime() - fechaHoraIngreso.getTime()) / (60 * 1000); // Tiempo en minutos
            double tarifa = calcularTarifa(tiempoTotal);
            Parqueadero.registrarSalida(this, fechaHoraSalida, tiempoTotal, tarifa);
        }
    }
    
    public double calcularTarifa(long tiempoTotal) {
        if (tiempoTotal >= 12 * 60) {
            return 12 * 60 * obtenerTarifaPorMinuto();
        } else {
            return tiempoTotal * obtenerTarifaPorMinuto();
        }
    }
    
    public double obtenerTarifaPorMinuto() {
        switch (tipo) {
            case "Bicicleta":
            case "Ciclomotor":
                return 20;
            case "Motocicleta":
                return 30;
            case "Carro":
                return 60;
            default:
                return 0;
        }
    }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return "Número: " + numero + "\nPlaca: " + placa + "\nTipo: " + tipo + "\nFecha y hora de ingreso: " + sdf.format(fechaHoraIngreso);
    }
}

class Parqueadero {
    private static ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private static Stack<Vehiculo> vehiculosEnParqueadero = new Stack<>();
    
    public static int generarNumeroVehiculo() {
        return vehiculos.size() + 1;
    }
    
    public static void registrarIngreso(String placa, String tipo) {
        Vehiculo vehiculo = new Vehiculo(placa, tipo);
        vehiculos.add(vehiculo);
        vehiculosEnParqueadero.push(vehiculo);
    }
    
    public static void registrarSalida(Vehiculo vehiculo, Date fechaHoraSalida, long tiempoTotal, double tarifa) {
        vehiculosEnParqueadero.pop();
        JOptionPane.showMessageDialog(null, "Información de salida:\n" + vehiculo.toString() + "\nFecha y hora de salida: " + fechaHoraSalida
                + "\nTiempo total de parqueo (minutos): " + tiempoTotal + "\nValor total a pagar: $" + tarifa);
    }
    
    public static ArrayList<Vehiculo> obtenerVehiculosDeDosRuedas(Date inicio, Date fin) {
        ArrayList<Vehiculo> vehiculosDosRuedas = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            if (!vehiculo.haSalido && (vehiculo.tipo.equals("Bicicleta") || vehiculo.tipo.equals("Ciclomotor"))) {
                if (vehiculo.fechaHoraIngreso.after(inicio) && vehiculo.fechaHoraIngreso.before(fin)) {
                    vehiculosDosRuedas.add(vehiculo);
                }
            }
        }
        return vehiculosDosRuedas;
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Parqueadero");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 1));

        JButton ingresarButton = new JButton("1. Ingreso de Vehículo");
        JButton salidaButton = new JButton("2. Salida de Vehículo");
        JButton consultarButton = new JButton("3. Consultar Vehículos de 2 Ruedas");
        
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
                String tipo = JOptionPane.showInputDialog("Ingrese el tipo de vehículo (Bicicleta, Motocicleta, Carro, etc.):");
                registrarIngreso(placa, tipo);
                JOptionPane.showMessageDialog(null, "Vehículo ingresado correctamente.");
            }
        });
        
        salidaButton.addActionListener(new ActionListener() {
            @Overridepublic public void actionPerformed(ActionEvent e) {
                String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo a dar salida:");
                for (Vehiculo vehiculo : vehiculos) {
                    if (!vehiculo.haSalido && vehiculo.placa.equals(placa)) {
                        vehiculo.registrarSalida();
                        return;
                    }
                }
                JOptionPane.showMessageDialog(null, "Vehículo no encontrado o ya ha salido.");
            }
        });
        
        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inicioStr = JOptionPane.showInputDialog("Ingrese la hora de inicio (HH:mm):");
                String finStr = JOptionPane.showInputDialog("Ingrese la hora de fin (HH:mm):");
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                try {
                    Date inicio = sdf.parse(inicioStr);
                    Date fin = sdf.parse(finStr);
                    ArrayList<Vehiculo> vehiculosDosRuedas = obtenerVehiculosDeDosRuedas(inicio, fin);
                    if (vehiculosDosRuedas.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay vehículos de dos ruedas en ese intervalo de tiempo.");
                    } else {
                        StringBuilder mensaje = new StringBuilder("Vehículos de dos ruedas en el intervalo " + inicioStr + " - " + finStr + ":\n");
                        for (Vehiculo vehiculo : vehiculosDosRuedas) {
                            mensaje.append(vehiculo.toString()).append("\n\n");
                        }
                        JOptionPane.showMessageDialog(null, mensaje.toString());
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Formato de hora incorrecto.");
                }
            }
        });
        
        frame.add(ingresarButton);
        frame.add(salidaButton);
        frame.add(consultarButton);
        frame.setVisible(true);
    }
}