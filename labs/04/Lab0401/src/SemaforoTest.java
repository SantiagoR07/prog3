import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SemaforoTest extends javax.swing.JFrame {
    
    private String[] animacionPeaton = {"contact", "contact2", "high-point", "high-point2", "passing", "passing2", "recoil", "recoil2"};
    private int indiceAnimacion = 0;
    private Timer timer;
    private int tiempoVerde = 25;
    private int tiempoAmarillo = 3;
    private int tiempoRojo = 20;
    private int tiempoRestante = tiempoVerde;

    private Timer Tiempo = new Timer(1000, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        tiempoRestante--;
        if (tiempoRestante == 0) {
            cambiarColor();
        }
        jLabel2.setText("Tiempo: " + tiempoRestante + " segundos");
    }
});

private Timer timerAnimacion = new Timer(200, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (indiceAnimacion % 2 == 0) {
            lblPeaton.setIcon(new ImageIcon(getClass().getResource("/Images/" + animacionPeaton[indiceAnimacion / 2] + ".png")));
        } else {
            lblPeaton.setIcon(new ImageIcon(getClass().getResource("/Images/contact.png")));
        }
        indiceAnimacion++;
        if (indiceAnimacion == animacionPeaton.length * 2) {
            timerAnimacion.stop();
            indiceAnimacion = 0;
        }
    }
});
    
    public SemaforoTest() {
        initComponents();
        iniciarTemporizador(); // Iniciamos el temporizador al crear la ventana
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        tiempoRestante += 5;
    }

    private void iniciarTemporizador() {
        Tiempo = new Timer(1000, (ActionEvent e) -> {
            tiempoRestante--;
            if (tiempoRestante == 0) {
                cambiarColor();
            }
            jLabel2.setText("Tiempo: " + tiempoRestante + " segundos");
        });
        Tiempo.start();
    }

    private void cambiarColor() {
    if (tiempoRestante > 0) {
        return;
    }

    if (tiempoRestante == 0) {
        if (lblSemaforo.getIcon().toString().contains("verde")) {
            lblSemaforo.setIcon(new ImageIcon(getClass().getResource("/Images/amarillo.png")));
            tiempoRestante = tiempoAmarillo;
        } else if (lblSemaforo.getIcon().toString().contains("amarillo")) {
            lblSemaforo.setIcon(new ImageIcon(getClass().getResource("/Images/rojo.png")));
            tiempoRestante = tiempoRojo;
            // Aquí empieza la animación del peatón
            timerAnimacion.start();
        } else {
            lblSemaforo.setIcon(new ImageIcon(getClass().getResource("/Images/verde.png")));
            tiempoRestante = tiempoVerde;
        }
    }
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblPeaton = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        sldTrafico = new javax.swing.JSlider();
        lblSemaforo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblPeaton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/contact.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Tráfico");

        lblSemaforo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/rojo.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tiempo: 5 segundos");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Prioridad peatonal");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(lblPeaton)
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sldTrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(lblSemaforo)
                    .addContainerGap(319, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(lblPeaton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(sldTrafico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(lblSemaforo)
                    .addContainerGap(326, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
   public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SemaforoTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SemaforoTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SemaforoTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SemaforoTest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SemaforoTest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblPeaton;
    private javax.swing.JLabel lblSemaforo;
    private javax.swing.JSlider sldTrafico;
    // End of variables declaration//GEN-END:variables
}
