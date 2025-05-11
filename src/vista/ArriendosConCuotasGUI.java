package vista;

import controlador.ClientesControlador;
import modelo.Cliente;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import java.util.ArrayList;

public class ArriendosConCuotasGUI extends JFrame {
    ArrayList<Cliente> clientes = new ArrayList<>();

    private JLabel titulo = new JLabel("Arriendos con cuotas");

    private JComboBox<String> comboBoxClientes = new JComboBox<>();
    private JComboBox<String> comboBoxAutomovil = new JComboBox<>();

    private JButton btnNuevoCliente = new JButton("Ingresar nuevo Cliente");

    private JLabel lblFecha = new JLabel("Fecha Arriendo:");
    SpinnerDateModel modeloFecha = new SpinnerDateModel();
    JSpinner spinnerFecha = new JSpinner(modeloFecha);

    private JLabel lblDias = new JLabel("Días:");
    private JTextField txtDias = new JTextField();

    private JLabel lblPrecio = new JLabel("Precio por día:");
    private JTextField txtPrecio = new JTextField();

    private JLabel lblMonto = new JLabel("Monto a pagar:");
    private JTextField txtMonto = new JTextField();

    private JLabel lblCuotas = new JLabel("Cantidad de cuotas:");
    private JTextField txtCuotas = new JTextField();

    private JButton btnGuardar = new JButton("Guardar arriendo y mostrar cuotas >>");

    private JLabel lblCuotasAPagar = new JLabel("CUOTAS A PAGAR");

    private JTextArea areaCuotas = new JTextArea();
    private JScrollPane scrollCuotas = new JScrollPane(areaCuotas);

    private JButton btnPagar = new JButton("Pagar Primera Cuota");

    //Controlador global
    ClientesControlador controlador = new ClientesControlador();


    public ArriendosConCuotasGUI() {
        setTitle("Arriendos con cuotas");
        setSize(750, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        titulo.setBounds(270, 10, 300, 30);
        add(titulo);

        comboBoxClientes.setBounds(50, 60, 200, 25);
        cargarClientes();
        add(comboBoxClientes);

        btnNuevoCliente.setBounds(50, 95, 200, 25);
        btnNuevoCliente.addActionListener(el -> this.abrirClientesGUI());
        add(btnNuevoCliente);

        comboBoxAutomovil.setBounds(280, 60, 200, 25);
        comboBoxAutomovil.addItem("Seleccione AUTOMOVIL");
        add(comboBoxAutomovil);

        lblFecha.setBounds(50, 150, 100, 20);
        spinnerFecha.setBounds(150, 150, 100, 20);
        add(lblFecha);
        add(spinnerFecha);

        lblDias.setBounds(50, 180, 100, 20);
        txtDias.setBounds(150, 180, 50, 20);
        txtDias.getDocument().addDocumentListener(new DocumentListenerCustom() {
            @Override
            public void onChange() {
                mostrarMontoAPagar();
            }
        });
        add(lblDias);
        add(txtDias);


        lblPrecio.setBounds(50, 210, 100, 20);
        txtPrecio.setBounds(150, 210, 100, 20);
        txtPrecio.getDocument().addDocumentListener(new DocumentListenerCustom() {
            @Override
            public void onChange() {
                mostrarMontoAPagar();
            }
        });
        add(lblPrecio);
        add(txtPrecio);

        lblMonto.setBounds(50, 240, 150, 20);
        txtMonto.setBounds(200, 240, 150, 20);
        txtMonto.setEditable(false);
        add(lblMonto);
        add(txtMonto);

        lblCuotas.setBounds(280, 150, 150, 20);
        txtCuotas.setBounds(420, 150, 50, 20);
        add(lblCuotas);
        add(txtCuotas);

        btnGuardar.setBounds(280, 180, 250, 25);
        add(btnGuardar);

        lblCuotasAPagar.setBounds(550, 50, 150, 25);
        add(lblCuotasAPagar);

        scrollCuotas.setBounds(530, 80, 180, 200);
        areaCuotas.setEditable(false);
        add(scrollCuotas);

        btnPagar.setBounds(550, 300, 150, 25);
        add(btnPagar);

        setVisible(true);
    }

    private void cargarClientes() {
        comboBoxClientes.removeAllItems();
        comboBoxClientes.addItem("Seleccione CLIENTE");

        for (Cliente cliente : controlador.getClientes()) {
            comboBoxClientes.addItem(cliente.getNombre() + " - " + cliente.getCedula());
        }
    }

    public void actualizarClientes() {
        cargarClientes();
    }

    private void abrirClientesGUI() {
        ClientesGUI clientesGUI = new ClientesGUI(controlador, this);
        clientesGUI.setVisible(true);
    }

    private void mostrarMontoAPagar() {
        double precio = Double.parseDouble(txtPrecio.getText().isEmpty() ? "0" : txtPrecio.getText());
        double dias = Double.parseDouble(txtDias.getText().isEmpty() ? "0" : txtDias.getText());
        txtMonto.setText(String.valueOf(dias * precio));
    }
}
