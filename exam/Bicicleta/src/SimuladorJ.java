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
    private JLabel Indicador1,Indicador2;
    
   public SimuladorJ(){
       setTitle("Simulador de bicicleta estatica");
       setSize(400,200);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       PedalIz = new JButton("Pedal izquierdo");
       PedalDer = new JButton ("Pedal derecho");
       
       Indicador1 = new JLabel("indicador 1:0");
       Indicador2 = new JLabel("indicador 2:0");
       
       
       setLayout(new GridLayout(2,2));
       add (PedalIz);
       add(PedalDer);
       add(Indicador1);
       add(Indicador2);
       
       PedalIz.addActionListener(new ActionListener(){
       @Override
       public void actionPerformed(ActionEvent e){
           PedalDer.setVisible(true);
           PedalIz.setVisible(false);
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
