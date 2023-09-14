/**
 *
 * @author Santiago Rubiano 7004147
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

class Carro {
    String marca;
    String modelo;
    String color;
    int kilometraje;

    public Carro(String marca, String modelo, String color, int kilometraje) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.kilometraje = kilometraje;
    }

    @Override
    public String toString() {
        return "<html><b>" + marca + " " + modelo + "</b><br/>Color: " + color + "<br/>Kilometraje: " + kilometraje + " km</html>";
    }
}

public class VentaCarrosApp extends JFrame {
    private Carro[] carros;
    private JList<Carro> list;

    public VentaCarrosApp() {
        setTitle("Venta de Carros Usados");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Botones
        JButton btnOrdenarModelo = new JButton("Ordenar por Modelo");
        JButton btnOrdenarKilometraje = new JButton("Ordenar por Kilometraje");

        // Lista de carros
        DefaultListModel<Carro> model = new DefaultListModel<>();
        list = new JList<>(model);
        list.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(list);

        // Paneles
        JPanel btnPanel = new JPanel(new GridLayout(1, 2));
        btnPanel.add(btnOrdenarModelo);
        btnPanel.add(btnOrdenarKilometraje);

        // Layout
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(btnPanel, BorderLayout.SOUTH);

        // Acciones de los botones
        btnOrdenarModelo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ordenarPorModelo();
            }
        });

        btnOrdenarKilometraje.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ordenarPorKilometraje();
            }
        });

        // Mostrar la ventana
        setVisible(true);
    }

    private void ordenarPorModelo() {
        Arrays.sort(carros, (c1, c2) -> c1.modelo.compareTo(c2.modelo));
        actualizarLista();
    }

    private void ordenarPorKilometraje() {
        Arrays.sort(carros, (c1, c2) -> Integer.compare(c1.kilometraje, c2.kilometraje));
        actualizarLista();
    }

    private void actualizarLista() {
        DefaultListModel<Carro> model = new DefaultListModel<>();
        for (Carro carro : carros) {
            model.addElement(carro);
        }
        list.setModel(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                int cantidadCarros = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de carros:"));
                Carro[] carros = new Carro[cantidadCarros];
                for (int i = 0; i < cantidadCarros; i++) {
                    carros[i] = new Carro(
                            JOptionPane.showInputDialog("Ingrese la marca del carro " + (i + 1) + ":"),
                            JOptionPane.showInputDialog("Ingrese el modelo del carro " + (i + 1) + ":"),
                            JOptionPane.showInputDialog("Ingrese el color del carro " + (i + 1) + ":"),
                            Integer.parseInt(JOptionPane.showInputDialog("Ingrese el kilometraje del carro " + (i + 1) + ":"))
                    );
                }
                VentaCarrosApp app = new VentaCarrosApp();
                app.carros = carros;
            }
        });
    }
}