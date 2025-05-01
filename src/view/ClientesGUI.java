package view;

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

    public ClientesGUI() {
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

        setVisible(true);

    }
}
