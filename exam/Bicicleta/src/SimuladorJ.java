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

public class SimuladorJ extends JFrame{
    
    private JButton PedalIz,PedalDer;
    private JLabel Indicador1,Indicador2, TemporizadorLabel;
    private Timer timer;
    private int contadorPedalIz, contadorPedalDer, sT, velocidad;
    
   public SimuladorJ(){
       setTitle("Simulador de bicicleta estatica");
       setSize(800,400);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       TemporizadorLabel = new JLabel("Temporizador");
       Indicador1 = new JLabel("Pedalazos");
       Indicador2 = new JLabel("Velocidad");
       
       PedalIz = new JButton("Pedal izquierdo");
       PedalDer = new JButton ("Pedal derecho");
       
       setLayout(new GridLayout(2,2));
       add(TemporizadorLabel);
       add(Indicador1);
       add(Indicador2);
       add (PedalIz);
       add(PedalDer);
       
       timer = new Timer(1000,new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
           Indicador1.setText("Pedales dados: "+contadorPedalIz);
           Indicador2.setText("Velocidad: "+ "pedales/minuto");
           TemporizadorLabel.setText(timer);
           }
       });
       timer.start();
       
       PedalIz.addActionListener(new ActionListener(){
       @Override
       public void actionPerformed(ActionEvent e){
           PedalDer.setVisible(true);
           PedalIz.setVisible(false);
           contadorPedalIz++;
       }});
       PedalDer.addActionListener(new ActionListener(){
       @Override
       public void actionPerformed(ActionEvent e){
           PedalDer.setVisible(false);
           PedalIz.setVisible(true);
           
       }});
       
   }
       public static void main(String[] args){
           SwingUtilities.invokeLater(new Runnable(){
               @Override
               public void run(){
                   new SimuladorJ().setVisible(true);
               }
           });
       
   }
}
