package vista;
import javax.swing.*;

public class PagoCuotaArriendoGUI extends JFrame {
    private JComboBox<String> comboClientes;
    private JList<String> listaArriendos;
    private JList<String> listaPagos;
    private JButton botonMostrarPagos;
    private JButton botonRealizarPago;
    private JCheckBox[] checkPagos;

    public PagoCuotaArriendoGUI() {
        setTitle("PAGAR CUOTAS ARRIENDOS");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // ComboBox de clientes
        comboClientes = new JComboBox<>(new String[]{"Seleccione cliente", "Cliente 1", "Cliente 2"});
        comboClientes.setBounds(180, 50, 250, 25);
        add(comboClientes);

        // Etiqueta "Seleccione arriendo"
        JLabel lblArriendo = new JLabel("Seleccione arriendo:");
        lblArriendo.setBounds(40, 90, 150, 20);
        add(lblArriendo);

        // Lista de arriendos
        listaArriendos = new JList<>(new String[]{"Arriendo 1", "Arriendo 2"});
        JScrollPane scrollArriendo = new JScrollPane(listaArriendos);
        scrollArriendo.setBounds(40, 120, 120, 100);
        add(scrollArriendo);

        // Botón para mostrar pagos
        botonMostrarPagos = new JButton("Mostrar pagos arriendo seleccionado >>>");
        botonMostrarPagos.setBounds(160, 140, 250, 30);
        add(botonMostrarPagos);

        // Etiqueta "PAGOS"
        JLabel lblPagos = new JLabel("P  A  G  O  S");
        lblPagos.setBounds(460, 90, 100, 20);
        add(lblPagos);

        // Lista de pagos (datos de ejemplo)
        listaPagos = new JList<>(new String[]{
                "1    $10000    No",
                "2    $10000    Sí",
                "3    $10000    No"
        });
        JScrollPane scrollPagos = new JScrollPane(listaPagos);
        scrollPagos.setBounds(430, 120, 120, 100);
        add(scrollPagos);

        // Checkboxes a la izquierda de la lista de pagos
        checkPagos = new JCheckBox[3];
        for (int i = 0; i < checkPagos.length; i++) {
            checkPagos[i] = new JCheckBox();
            checkPagos[i].setBounds(403, 120 + i * 20, 20, 20);
            add(checkPagos[i]);
        }

        // Botón "Realizar Pago"
        botonRealizarPago = new JButton("Realizar Pago");
        botonRealizarPago.setBounds(450, 230, 120, 30);
        add(botonRealizarPago);

        setVisible(true);
    }
}
