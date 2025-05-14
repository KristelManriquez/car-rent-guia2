package vista;

import controlador.ClientesControlador;
import vista.arriendos.ArriendosConCuotasGUI;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class MainGUI extends JFrame {
    private static final ClientesControlador controlador = new ClientesControlador();
    private static final ArriendosConCuotasGUI arriendosConCuotasGUI = new ArriendosConCuotasGUI(controlador);
    private static final ClientesGUI clientesGUI = new ClientesGUI(controlador);
    private static final PagoCuotaArriendoGUI pagoCuotaArriendoGUI = new PagoCuotaArriendoGUI();

    public MainGUI() {
        setTitle("Sistema de Arriendo de Vehículos");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Sistema de Arriendo de Vehículos", SwingConstants.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 20));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
        add(titulo, BorderLayout.NORTH);

        ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/res/logo.png")));

        Image imagenRedimensionada = originalIcon.getImage().getScaledInstance(640, 480, Image.SCALE_SMOOTH); // ancho, alto
        ImageIcon iconRedimensionado = new ImageIcon(imagenRedimensionada);

        JLabel imagen = new JLabel(iconRedimensionado, SwingConstants.CENTER);
        add(imagen, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnArriendoCuotas = new JButton("Arrendar con cuotas");
        JButton btnPagarCuota = new JButton("Pagar cuota");
        JButton btnClientes = new JButton("Agregar cliente");

        panelBotones.add(btnArriendoCuotas);
        panelBotones.add(btnPagarCuota);
        panelBotones.add(btnClientes);
        add(panelBotones, BorderLayout.SOUTH);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");

        JMenuItem itemSalir = new JMenuItem("Salir");
        itemSalir.addActionListener(e -> {
            System.exit(0);
        });

        menu.add(itemSalir);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        btnArriendoCuotas.addActionListener(e -> {
                    if (!arriendosConCuotasGUI.isActive()) {
                        arriendosConCuotasGUI.updateCombos();
                        arriendosConCuotasGUI.setVisible(true);
                    }
                }
        );
        btnPagarCuota.addActionListener(e -> {
            if (!pagoCuotaArriendoGUI.isActive()) {
                pagoCuotaArriendoGUI.setClientesControlador(controlador);
                pagoCuotaArriendoGUI.MostrarPagoCuotaArriendoGUI();
                pagoCuotaArriendoGUI.setVisible(true);
            }
        });
        btnClientes.addActionListener(e -> {
            if (!clientesGUI.isActive()) {
                clientesGUI.setVisible(true);
            }
        });
        setVisible(true);
    }
}
