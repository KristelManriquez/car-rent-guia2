package vista.arriendos;

import vista.filters.DocumentListenerCustom;

import javax.swing.*;
import java.awt.*;

public class PanelDatosArriendo extends JPanel {
    public final JSpinner spinnerFecha = new JSpinner(new SpinnerDateModel());
    public final JTextField txtDias = new JTextField(5);
    public final JTextField txtPrecio = new JTextField(8);
    public final JTextField txtCuotas = new JTextField(5);
    public final JTextField txtMonto = new JTextField(10);
    public final JButton btnCalcularCuotas = new JButton("mostrar cuotas");

    public PanelDatosArriendo(Runnable onDatosCambiados) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        addLabel("Fecha Arriendo:", gbc, row, 0);
        addComponent(spinnerFecha, gbc, row++, 1);

        addLabel("Días:", gbc, row, 0);
        addComponent(txtDias, gbc, row++, 1);

        addLabel("Precio por día:", gbc, row, 0);
        addComponent(txtPrecio, gbc, row++, 1);

        addLabel("Cantidad de cuotas:", gbc, row, 0);
        addComponent(txtCuotas, gbc, row++, 1);

        addLabel("Monto a pagar:", gbc, row, 0);
        txtMonto.setEditable(false);
        addComponent(txtMonto, gbc, row++, 1);

        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = row;
        add(btnCalcularCuotas, gbc);

        DocumentListenerCustom listener = new DocumentListenerCustom() {
            public void onChange() {
                onDatosCambiados.run();
            }
        };
        txtDias.getDocument().addDocumentListener(listener);
        txtPrecio.getDocument().addDocumentListener(listener);
    }

    private void addLabel(String text, GridBagConstraints gbc, int y, int x) {
        gbc.gridx = x;
        gbc.gridy = y;
        add(new JLabel(text), gbc);
    }

    private void addComponent(JComponent comp, GridBagConstraints gbc, int y, int x) {
        gbc.gridx = x;
        gbc.gridy = y;
        add(comp, gbc);
    }
}
