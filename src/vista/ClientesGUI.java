package vista;

import controlador.ClientesControlador;

import javax.swing.*;

public class ClientesGUI extends JFrame {
    private JLabel labelCedula = new JLabel("Cédula");
    private JTextField inputCedula = new JTextField();
    private JLabel labelNombre = new JLabel("Nombre");
    private JTextField inputNombre = new JTextField();
    private JLabel labelEstaVigente = new JLabel("Vigente");
    private JCheckBox checkBoxEstaVigente = new JCheckBox();
    private JButton botonAgregar = new JButton("Agregar");
    private JLabel titulo = new JLabel("Clientes");

    public ClientesGUI(ClientesControlador controlador) {
        setTitle(titulo.getText());
        setSize(350, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        titulo.setBounds(10, 3, 600  , 100);
        add(titulo);

        labelCedula.setBounds(10, 50, 100, 110);
        add(labelCedula);

        inputCedula.setBounds(60, 90, 150, 30);
        add(inputCedula);

        labelNombre.setBounds(10, 150, 100, 110);
        add(labelNombre);

        inputNombre.setBounds(70, 190, 150, 30);
        add(inputNombre);

        labelEstaVigente.setBounds(35, 220, 100, 100);
        add(labelEstaVigente);

        checkBoxEstaVigente.setBounds(10, 220, 150, 100);
        add(checkBoxEstaVigente);

        botonAgregar.setBounds(150, 350, 100, 40);
        add(botonAgregar);

        botonAgregar.addActionListener(e -> {
            controlador.agregarCliente();
            // Después de agregar, abrir la vista de arriendos con el controlador actualizado
            ArriendosConCuotasGUI arriendosGUI = new ArriendosConCuotasGUI(controlador);
            this.dispose();
        });

        setVisible(true);
    }

    public String getCedula() { return inputCedula.getText(); }
    public String getNombre() { return inputNombre.getText(); }
    public boolean isVigente() { return checkBoxEstaVigente.isSelected(); }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void limpiarFormulario() {
        inputCedula.setText("");
        inputNombre.setText("");
        checkBoxEstaVigente.setSelected(false);
    }
}
