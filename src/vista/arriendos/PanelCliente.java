package vista;

import controlador.ClientesControlador;
import modelo.Cliente;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelCliente extends JPanel {
    private final JComboBox<String> comboClientes = new JComboBox<>();
    private final JButton btnNuevoCliente = new JButton("Ingresar nuevo Cliente");

    public PanelCliente(ClientesControlador controlador, Runnable onNuevoCliente) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        comboClientes.addItem("Seleccione CLIENTE");
        cargarClientes(controlador.getClientes());

        btnNuevoCliente.addActionListener(e -> onNuevoCliente.run());

        add(comboClientes);
        add(Box.createVerticalStrut(10));
        add(btnNuevoCliente);
    }

    public void cargarClientes(List<Cliente> clientes) {
        comboClientes.removeAllItems();
        comboClientes.addItem("Seleccione CLIENTE");
        for (Cliente cliente : clientes) {
            comboClientes.addItem(cliente.getNombre() + " - " + cliente.getCedula());
        }
    }

    public JComboBox<String> getComboClientes() {
        return comboClientes;
    }
}
