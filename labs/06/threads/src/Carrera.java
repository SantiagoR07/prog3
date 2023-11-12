package carrera;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Carrera extends Thread {
    private JLabel etiqueta;
    private CarroCarrera auto;

    public Carrera(JLabel etiqueta, CarroCarrera auto) {
        this.etiqueta = etiqueta;
        this.auto = auto;
    }

    @Override
    public void run() {
        int auto1 = 0;
        int auto2 = 0;
        int auto3 = 0;
        int auto4 = 0;

        while (true) {
            try {
                sleep((int) (Math.random() * 100));
                auto1 = auto.getPrimerAuto().getLocation().x;
                auto2 = auto.getSegundoAuto().getLocation().x;
                auto3 = auto.getTercerAuto().getLocation().x;
                auto4 = auto.getCuartoAuto().getLocation().x;

                if (auto1 < auto.getBarrera().getLocation().x - 125 && auto2 < auto.getBarrera().getLocation().x - 125 && auto3 < auto.getBarrera().getLocation().x - 125 && auto4 < auto.getBarrera().getLocation().x - 125) {
                    etiqueta.setLocation(etiqueta.getLocation().x + 10, etiqueta.getLocation().y);
                    auto.repaint();
                } else {
                    break;
                }

            } catch (InterruptedException e) {
                System.out.println(e);
            }

            if (etiqueta.getLocation().x >= auto.getBarrera().getLocation().x - 125) {
                int ganador = 0; // Variable para almacenar el número del auto ganador
                int max1 = Math.max(auto1, auto2);
                int max2 = Math.max(auto3, auto4);
                int maxDistancia = Math.max(max1, max2);


                if (auto1 == maxDistancia) {
                    ganador = 1;
                } else if (auto2 == maxDistancia) {
                    ganador = 2;
                } else if (auto3 == maxDistancia) {
                    ganador = 3;
                } else if (auto4 == maxDistancia) {
                    ganador = 4;
                }

                if (ganador == 1) {
                    JOptionPane.showMessageDialog(null, "Gano el primer auto");
                } else if (ganador == 2) {
                    JOptionPane.showMessageDialog(null, "Gano el segundo auto");
                } else if (ganador == 3) {
                    JOptionPane.showMessageDialog(null, "Gano el tercer auto");
                } else if (ganador == 4) {
                    JOptionPane.showMessageDialog(null, "Gano el cuarto auto");
                } else {
                    JOptionPane.showMessageDialog(null, "Empate");
                }
            }
        }
    }
}

