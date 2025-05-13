package vista;

import controlador.ClientesControlador;
import modelo.ArriendoCuota;
import modelo.CuotaArriendo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class PagoCuotaArriendoGUI extends JFrame {

    private boolean isOpen = false;

    private JComboBox<String> comboClientes;
    private JList<String> listaArriendos;
    private JButton botonMostrarPagos;
    private JButton botonRealizarPago;
    private JPanel panelFilas;
    private JScrollPane scrollPagos;

    private ClientesControlador clientesControlador;

    public PagoCuotaArriendoGUI() {
        setTitle("PAGAR CUOTAS ARRIENDOS");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // PANEL IZQUIERDO
        JPanel panelIzquierdo = new JPanel(new GridBagLayout());
        panelIzquierdo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        // ComboBox clientes
        gbc.gridy = 0;
        comboClientes = new JComboBox<>();
        comboClientes.addItemListener(el -> {
            if (el.getStateChange() == ItemEvent.SELECTED) {
                cargarArriendosDelCliente(el.getItem().toString());
            }
        });
        panelIzquierdo.add(comboClientes, gbc);

        // Etiqueta
        gbc.gridy++;
        panelIzquierdo.add(new JLabel("Seleccione arriendo:"), gbc);

        // Lista de arriendos
        gbc.gridy++;
        listaArriendos = new JList<>();
        JScrollPane scrollArriendo = new JScrollPane(listaArriendos);
        scrollArriendo.setPreferredSize(new Dimension(150, 100));
        panelIzquierdo.add(scrollArriendo, gbc);

        // Botón mostrar pagos
        gbc.gridy++;
        botonMostrarPagos = new JButton("Mostrar pagos de cliente");
        botonMostrarPagos.addActionListener(e -> cargarCuotasArriendo());
        panelIzquierdo.add(botonMostrarPagos, gbc);

        // PANEL DERECHO
        JPanel panelDerecho = new JPanel(new BorderLayout(5, 5));
        panelDerecho.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel lblPagos = new JLabel("P  A  G  O  S", SwingConstants.CENTER);
        lblPagos.setFont(lblPagos.getFont().deriveFont(Font.BOLD, 14f));
        panelDerecho.add(lblPagos, BorderLayout.NORTH);

        panelFilas = new JPanel();
        panelFilas.setLayout(new BoxLayout(panelFilas, BoxLayout.Y_AXIS));
        scrollPagos = new JScrollPane(panelFilas);
        panelDerecho.add(scrollPagos, BorderLayout.CENTER);

        botonRealizarPago = new JButton("Realizar Pago");
        botonRealizarPago.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelDerecho.add(botonRealizarPago, BorderLayout.SOUTH);

        // AGREGAR A LA VENTANA
        add(panelIzquierdo, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.CENTER);

        // Evento cerrar
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                setVisible(false);
                setOpen(false);
            }
        });
    }

    public void MostrarPagoCuotaArriendoGUI() {
        if (clientesControlador == null) {
            JOptionPane.showMessageDialog(this, "Controlador no asignado.");
            return;
        }

        limpiarPanelPagos();
        comboClientes.removeAllItems();

        List<ArriendoCuota> arriendos = clientesControlador.getArriendos();
        for (ArriendoCuota arriendo : arriendos) {
            String cedula = arriendo.getCliente().getCedula();
            if (((DefaultComboBoxModel<String>) comboClientes.getModel()).getIndexOf(cedula) == -1) {
                comboClientes.addItem(cedula);
            }
        }

        if (comboClientes.getItemCount() > 0) {
            comboClientes.setSelectedIndex(0);
            cargarArriendosDelCliente(comboClientes.getSelectedItem().toString());
        }

        setVisible(true);
        setOpen(true);
    }

    private void cargarArriendosDelCliente(String cedula) {
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        int index = 1;
        for (ArriendoCuota arriendo : clientesControlador.getArriendos()) {
            if (arriendo.getCliente().getCedula().equals(cedula)) {
                modeloLista.addElement("Arriendo " + index++);
            }
        }
        listaArriendos.setModel(modeloLista);
    }

    private void cargarCuotasArriendo() {
        String selectedCliente = (String) comboClientes.getSelectedItem();
        String selectedArriendo = listaArriendos.getSelectedValue();

        if (selectedCliente == null || selectedArriendo == null) {
            JOptionPane.showMessageDialog(this, "Seleccione un cliente y un arriendo");
            return;
        }

        limpiarPanelPagos();

        for (ArriendoCuota arriendo : clientesControlador.getArriendos()) {
            if (arriendo.getCliente().getCedula().equals(selectedCliente)) {
                List<CuotaArriendo> cuotas = arriendo.getListaCuotas();
                for (CuotaArriendo cuota : cuotas) {
                    panelFilas.add(getJPanel(cuota));
                }
                break;
            }
        }

        panelFilas.revalidate();
        panelFilas.repaint();
    }

    private static JPanel getJPanel(CuotaArriendo cuota) {
        JPanel fila = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JCheckBox check = new JCheckBox();
        check.setEnabled(!cuota.isFuePagada());
        JLabel label = new JLabel("Cuota " + cuota.getNumeroCuotas() +
                " – $" + cuota.getValorCuota() + " " +
                (cuota.isFuePagada() ? "✅" : "⏳"));
        fila.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        fila.add(check);
        fila.add(label);
        return fila;
    }

    public void limpiarPanelPagos() {
        panelFilas.removeAll();
        panelFilas.revalidate();
        panelFilas.repaint();
    }

    public void setClientesControlador(ClientesControlador clientesControlador) {
        this.clientesControlador = clientesControlador;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }
}
