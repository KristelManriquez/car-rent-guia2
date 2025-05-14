package vista;

import controlador.ClientesControlador;
import modelo.Cliente;
import utils.CedulaValidador;
import utils.UtilMensaje;
import vista.filters.RutSimpleFormatter;

import javax.swing.*;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class ClientesGUI extends JFrame {

    private final JTextField inputCedula = new JTextField(15);
    private final JTextField inputNombre = new JTextField(15);
    private final JCheckBox checkBoxEstaVigente = new JCheckBox("Vigente");
    private final JButton botonAgregar = new JButton("Agregar");

    public ClientesGUI(ClientesControlador controlador) {
        controlador.setVista(this);
        setTitle("Clientes");
        setSize(350, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Contenedor con margen
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        JLabel titulo = new JLabel("Clientes");
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 18f));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titulo, gbc);

        // Cédula
        gbc.gridy++;
        gbc.gridwidth = 1;
        panel.add(new JLabel("Cédula:"), gbc);

        gbc.gridx = 1;
        PlainDocument doc = (PlainDocument) inputCedula.getDocument();
        doc.setDocumentFilter(new RutSimpleFormatter());
        panel.add(inputCedula, gbc);

        // Nombre
        gbc.gridy++;
        gbc.gridx = 0;
        panel.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        panel.add(inputNombre, gbc);

        // Checkbox vigente
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panel.add(checkBoxEstaVigente, gbc);

        // Botón agregar
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        botonAgregar.setPreferredSize(new Dimension(100, 30));
        panel.add(botonAgregar, gbc);

        // Acción del botón
        botonAgregar.addActionListener(e -> {
            if (CedulaValidador.validarCedula(inputCedula.getText())) {
                Cliente cliente = new Cliente();
                cliente.setCedula(inputCedula.getText());
                cliente.setNombre(inputNombre.getText());
                cliente.setVigente(checkBoxEstaVigente.isSelected());
                controlador.agregarCliente(cliente);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Numero de cedula no valido");
            }
        });

        add(panel);
    }

    public void mostrarMensaje(String mensaje, char tipo) {
        JOptionPane.showMessageDialog(this, UtilMensaje.mostrarMensaje(mensaje, tipo));

    }

    public void limpiarFormulario() {
        inputCedula.setText("");
        inputNombre.setText("");
        checkBoxEstaVigente.setSelected(false);
    }
}
