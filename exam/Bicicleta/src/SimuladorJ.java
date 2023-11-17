import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
/**
 *
 * @author Santiago Rubiano
 */

public class SimuladorJ extends JFrame {

    private JButton PedalIz, PedalDer;
    private JLabel Indicador1, Indicador2, TemporizadorLabel;
    private Timer timer;
    private int contadorPedalIz, contadorPedalDer, sT;
    private double velocidad;
    private int limitePedalIzquierdo = 0;
    private int limitePedalDerecho = 0;

    public SimuladorJ() {
        setTitle("Simulador de bicicleta estatica");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TemporizadorLabel = new JLabel("Temporizador");
        Indicador1 = new JLabel("Pedales dados: ");
        Indicador2 = new JLabel("Velocidad ");

        JTextField PedalesSolField = new JTextField(2);

        JPanel panelClicks = new JPanel();
        panelClicks.add(new JLabel("Limite de clicks(se debe dar enter para que lo aplique): "));
        panelClicks.add(PedalesSolField);
        add(panelClicks);

        setLayout(new GridLayout(3, 3));
        add(TemporizadorLabel);
        add(Indicador1);
        add(Indicador2);

        PedalIz = new JButton("Pedal izquierdo");
        PedalDer = new JButton("Pedal derecho");

        add(PedalIz);
        add(PedalDer);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sT++;
                velocidad = contadorPedalIz / sT;
                TemporizadorLabel.setText("Tiempo transcurrido: " + sT + " segundos");
                Indicador1.setText("Pedales dados: " + contadorPedalIz);
                Indicador2.setText("Velocidad: " + velocidad + " pedales/minuto");
            }
        });
        timer.start();

        PedalIz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contadorPedalIz++;
                if (contadorPedalIz >= limitePedalIzquierdo) {
                    PedalDer.setVisible(true);
                    PedalIz.setVisible(false);
                }
            }
        });

        PedalDer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contadorPedalDer++;
                if (contadorPedalDer >= limitePedalDerecho) {
                    PedalDer.setVisible(false);
                    PedalIz.setVisible(true);
                }
            }
        });

        PedalesSolField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int limiteTotal = Integer.parseInt(PedalesSolField.getText());
                    limitePedalIzquierdo = limiteTotal;
                    limitePedalDerecho = limiteTotal;
                } catch (NumberFormatException ex) {
                    // Manejar la entrada no numérica si es necesario
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SimuladorJ().setVisible(true);
            }
        });
    }
}