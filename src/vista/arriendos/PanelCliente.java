package vista;

import controlador.ClientesControlador;
import modelo.Cliente;
import modelo.Vehiculo;

import javax.swing.*;
import java.util.List;

public class PanelCliente extends JPanel {
    private final JComboBox<String> comboClientes = new JComboBox<>();
    private final JComboBox<String> comboVehiculos = new JComboBox<>();
    private final JButton btnNuevoCliente = new JButton("Ingresar nuevo Cliente");

    public PanelCliente(ClientesControlador controlador, Runnable onNuevoCliente) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel lblClientes = new JLabel("Seleccione Cliente");
        add(lblClientes);
        add(Box.createVerticalStrut(10));
        cargarCombo(controlador.getClientes(), comboClientes);

        btnNuevoCliente.addActionListener(e -> onNuevoCliente.run());

        add(comboClientes);
        add(Box.createVerticalStrut(10));

        JLabel lblAutomovil = new JLabel("Seleccione Automovil");
        add(lblAutomovil);
        add(Box.createVerticalStrut(10));
        cargarCombo(controlador.getVehiculos(), comboVehiculos);
        add(comboVehiculos);
        add(Box.createVerticalStrut(10));
        add(btnNuevoCliente);
    }

    public <T> void cargarCombo(List<T> elementos, JComboBox<String> combo) {
        combo.removeAllItems();
        for (T list : elementos) {
            if (list instanceof Cliente cliente) {
                combo.addItem(cliente.getNombre() + " - " + cliente.getCedula());
            }
            if (list instanceof Vehiculo vehiculo) {
                combo.addItem(vehiculo.getPatente() + " - " + vehiculo.getCondicion());
            }
        }
    }

    public JComboBox<String> getComboClientes() {
        return comboClientes;
    }

    public JComboBox<String> getComboVehiculos() {
        return comboVehiculos;
    }

    public String obtenerClienteSeleccionado() {
        return (String) comboClientes.getSelectedItem();
    }

    public String obtenerVehiculoSeleccionado() {
        return (String) comboVehiculos.getSelectedItem();
    }

}
