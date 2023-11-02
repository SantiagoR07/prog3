/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Santiago Rubiano Garzón - 7004147
 */
import java.util.Random;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

class Carro implements Runnable {
    String nombre;
    int distanciaRecorrida;
    private int distanciaMeta;
    private Random random;
    private JLabel label;

    public Carro(String nombre, int distanciaMeta, JLabel label) {
        this.nombre = nombre;
        this.distanciaRecorrida = 0;
        this.distanciaMeta = distanciaMeta;
        this.random = new Random();
        this.label = label;
    }

    @Override
    public void run() {
        while (distanciaRecorrida < distanciaMeta) {
            int avance = random.nextInt(10) + 1; // Avance aleatorio entre 1 y 10
            distanciaRecorrida += avance;
            label.setLocation(distanciaRecorrida, label.getY());
            try {
                Thread.sleep(100); // Simula el tiempo de espera entre movimientos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class CompetenciaCarrosGUI {
    private JFrame frame;
    private JButton btnIniciarCompetencia;
    private JTextArea textArea;
    private JLabel[] labels;

    public CompetenciaCarrosGUI() {
        frame = new JFrame("Competencia de Carros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        btnIniciarCompetencia = new JButton("Iniciar Competencia");
        textArea = new JTextArea();
        textArea.setEditable(false);

        btnIniciarCompetencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarCompetencia();
            }
        });

        frame.add(btnIniciarCompetencia);
        frame.add(new JScrollPane(textArea));
        frame.setLayout(null);
        btnIniciarCompetencia.setBounds(50, 10, 150, 30);
        textArea.setBounds(20, 50, 550, 300);

        labels = new JLabel[4];
        for (int i = 0; i < 4; i++) {
            labels[i] = new JLabel();
            labels[i].setBounds(20, 50 + 40 * i, 100, 30);
            frame.add(labels[i]);
        }
    }

    public void mostrarMensaje(String mensaje) {
        textArea.append(mensaje + "\n");
    }

    public void mostrarGanador(String mensaje) {
        JOptionPane.showMessageDialog(frame, mensaje);
    }

    public void iniciarCompetencia() {
        System.out.println("Iniciando competencia...");
        mostrarMensaje("Iniciando competencia...");

        int distanciaMeta = 550;

        ImageIcon carro1Icon = new ImageIcon("src/Images/carro1.png"); 
        ImageIcon carro2Icon = new ImageIcon("/Images/carro2.png");
        ImageIcon carro3Icon = new ImageIcon("/Images/carro3.png"); 
        ImageIcon carro4Icon = new ImageIcon("/Images/carro4.png"); 

        labels[0].setIcon(carro1Icon);
        labels[1].setIcon(carro2Icon);
        labels[2].setIcon(carro3Icon);
        labels[3].setIcon(carro4Icon);

        Carro carro1 = new Carro("Carro 1", distanciaMeta, labels[0]);
        Carro carro2 = new Carro("Carro 2", distanciaMeta, labels[1]);
        Carro carro3 = new Carro("Carro 3", distanciaMeta, labels[2]);
        Carro carro4 = new Carro("Carro 4", distanciaMeta, labels[3]);

        Thread threadCarro1 = new Thread(carro1);
        Thread threadCarro2 = new Thread(carro2);
        Thread threadCarro3 = new Thread(carro3);
        Thread threadCarro4 = new Thread(carro4);

        threadCarro1.start();
        threadCarro2.start();
        threadCarro3.start();
        threadCarro4.start();

        try {
            threadCarro1.join();
            threadCarro2.join();
            threadCarro3.join();
            threadCarro4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Carro[] carros = {carro1, carro2, carro3, carro4};
        Carro ganador = carros[0];
        for (int i = 1; i < carros.length; i++) {
            if (carros[i].distanciaRecorrida > ganador.distanciaRecorrida) {
                ganador = carros[i];
            }
        }

        mostrarGanador("El ganador es " + ganador.nombre);
    }

    public static void main(String[] args) {
        CompetenciaCarrosGUI gui = new CompetenciaCarrosGUI();
        gui.frame.setVisible(true);
    }
}
