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
    private int contadorPedalIz, contadorPedalDer, sT, PedalesSol;
    private double velocidad;
   public SimuladorJ(){
       //tamaño y distrubicion del frame
       setTitle("Simulador de bicicleta estatica");
       setSize(800,400);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       
       //cositas del frame, botones, labels...
       TemporizadorLabel = new JLabel("Temporizador");
       Indicador1 = new JLabel("Pedales dados: ");
       Indicador2 = new JLabel("Velocidad ");
       
       PedalIz = new JButton("Pedal izquierdo");
       PedalDer = new JButton ("Pedal derecho");
       
        JTextField PedalesSolField = new JTextField(2);
       
       JPanel panelClicks = new JPanel();
       panelClicks.add(new JLabel("Limite de clicks: "));
       panelClicks.add(PedalesSolField);
       
       
       //añadimos las cositas en el orden que le damos abajo en este caso  2x2
       setLayout(new GridLayout(3,3));
       add (panelClicks);
       add(TemporizadorLabel);
       add(Indicador1);
       add(Indicador2);
       add (PedalIz);
       add(PedalDer);
       
       //temporizador e indicadores de solicitud
       
       timer = new Timer(1000,new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e){
           sT++;
           velocidad = contadorPedalIz/sT;                  // La velocidad no imprime datos decimales
           TemporizadorLabel.setText("Tiempo transcurrido: "+ sT + " segundos");
           Indicador1.setText("Pedales dados: "+contadorPedalIz);
           Indicador2.setText("Velocidad: "+ velocidad + " pedales/minuto");
           
          // get.Text.panelClicks
           
           }
       });
       timer.start();
       
       
       //acciones de los pedales
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
   //main
   
       public static void main(String[] args){
           SwingUtilities.invokeLater(new Runnable(){
               @Override
               public void run(){
                   new SimuladorJ().setVisible(true);
               }
           });
       
   }
}