package vista;

import controlador.ClientesControlador;
import modelo.Arriendo;
import modelo.CuotaArriendo;
import utils.UtilMensaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;

public class PagoCuotaArriendoGUI extends JFrame {

    private final JComboBox<String> comboClientes;
    private final JList<String> listaArriendos;
    private final JPanel panelFilas;

    private ClientesControlador clientesControlador;

    public PagoCuotaArriendoGUI() {
        setTitle("PAGAR CUOTAS ARRIENDOS");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel panelIzquierdo = new JPanel(new GridBagLayout());
        panelIzquierdo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;

        gbc.gridy = 0;
        comboClientes = new JComboBox<>();
        comboClientes.addItemListener(el -> {
            if (el.getStateChange() == ItemEvent.SELECTED) {
                cargarArriendosDelCliente(el.getItem().toString());
            }
        });
        panelIzquierdo.add(comboClientes, gbc);

        gbc.gridy++;
        panelIzquierdo.add(new JLabel("Seleccione arriendo:"), gbc);

        gbc.gridy++;
        listaArriendos = new JList<>();
        JScrollPane scrollArriendo = new JScrollPane(listaArriendos);
        scrollArriendo.setPreferredSize(new Dimension(150, 100));
        panelIzquierdo.add(scrollArriendo, gbc);

        gbc.gridy++;
        JButton botonMostrarPagos = new JButton("Mostrar pagos de cliente");
        botonMostrarPagos.addActionListener(e -> cargarCuotasArriendo());
        panelIzquierdo.add(botonMostrarPagos, gbc);

        JPanel panelDerecho = new JPanel(new BorderLayout(5, 5));
        panelDerecho.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel lblPagos = new JLabel("P  A  G  O  S", SwingConstants.CENTER);
        lblPagos.setFont(lblPagos.getFont().deriveFont(Font.BOLD, 14f));
        panelDerecho.add(lblPagos, BorderLayout.NORTH);

        panelFilas = new JPanel();
        panelFilas.setLayout(new BoxLayout(panelFilas, BoxLayout.Y_AXIS));
        JScrollPane scrollPagos = new JScrollPane(panelFilas);
        panelDerecho.add(scrollPagos, BorderLayout.CENTER);

        JButton botonRealizarPago = new JButton("Realizar Pago");
        botonRealizarPago.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonRealizarPago.addActionListener(el -> pagarCuotas());
        panelDerecho.add(botonRealizarPago, BorderLayout.SOUTH);

        add(panelIzquierdo, BorderLayout.WEST);
        add(panelDerecho, BorderLayout.CENTER);
    }

    public void MostrarPagoCuotaArriendoGUI() {
        if (clientesControlador == null) {
            JOptionPane.showMessageDialog(this, UtilMensaje.mostrarMensaje("Controlador no asignado.", 'i'));
            return;
        }

        limpiarPanelPagos();
        comboClientes.removeAllItems();

        List<Arriendo> arriendos = new ArrayList<>(clientesControlador.getArriendos());
        for (Arriendo arriendo : arriendos) {
            String cedula = arriendo.getArriendoCuota().getCliente().getCedula();
            if (((DefaultComboBoxModel<String>) comboClientes.getModel()).getIndexOf(cedula) == -1) {
                comboClientes.addItem(cedula);
            }
        }

        if (comboClientes.getItemCount() > 0) {
            comboClientes.setSelectedIndex(0);
            cargarArriendosDelCliente((String) comboClientes.getSelectedItem());
        }
    }

    private void cargarArriendosDelCliente(String cedula) {
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        List<Arriendo> arriendos = clientesControlador.getArriendos();
        for (Arriendo arriendo : arriendos) {
            if (arriendo.getArriendoCuota().getCliente().getCedula().equals(cedula)) {
                modeloLista.addElement("Arriendo " + arriendo.getNumeroArriendo());
                break;
            }
        }
        listaArriendos.setModel(modeloLista);
    }

    private void cargarCuotasArriendo() {
        String selectedCliente = (String) comboClientes.getSelectedItem();
        String selectedArriendo = listaArriendos.getSelectedValue();

        if (selectedCliente == null || selectedArriendo == null) {
            JOptionPane.showMessageDialog(this, UtilMensaje.mostrarMensaje("Seleccione un cliente y un arriendo", 'i'));
            return;
        }

        limpiarPanelPagos();

        for (Arriendo arriendo : clientesControlador.getArriendos()) {
            if (arriendo.getArriendoCuota().getCliente().getCedula().equals(selectedCliente)) {
                List<CuotaArriendo> cuotas = arriendo.getArriendoCuota().getListaCuotas();
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
        JLabel label = new JLabel("Cuota 🐍" + cuota.getNumeroCuotas() +
                " – $" + cuota.getValorCuota() + " - " +
                (cuota.isFuePagada() ? "✅" : "⏳"));
        fila.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
        fila.add(check);
        fila.add(label);
        return fila;
    }

    private void pagarCuotas() {
        try {
            Component[] filas = panelFilas.getComponents();
            int index = 1;

            for (Component filaComponent : filas) {
                if (filaComponent instanceof JPanel fila) {
                    for (Component comp : fila.getComponents()) {
                        if (comp instanceof JCheckBox check && check.isSelected()) {
                            clientesControlador.pagarCuotasArriendo(
                                    (String) comboClientes.getSelectedItem(),
                                    index
                            );
                            JOptionPane.showMessageDialog(this, UtilMensaje.mostrarMensaje("La cuota " + index + " ha sido pagada!", 'e'));
                            check.setEnabled(false);
                            check.setSelected(false);
                        }
                    }
                }
                index++;
                cargarCuotasArriendo();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, UtilMensaje.mostrarMensaje("La cuota no pudo ser pagada", 'e'));
        }
    }


    public void limpiarPanelPagos() {
        panelFilas.removeAll();
        panelFilas.revalidate();
        panelFilas.repaint();
    }

    public void setClientesControlador(ClientesControlador clientesControlador) {
        this.clientesControlador = clientesControlador;
    }
}
