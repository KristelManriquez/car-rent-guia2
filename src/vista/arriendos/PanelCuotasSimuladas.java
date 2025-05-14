package vista.arriendos;

import javax.swing.*;
import java.awt.*;

public class PanelCuotasSimuladas extends JPanel {
    public final JTextArea areaCuotas = new JTextArea(10, 30);
    public final JButton btnGuardarArriendo = new JButton("Guardar arriendo");

    public PanelCuotasSimuladas() {
        setLayout(new BorderLayout(5, 5));
        areaCuotas.setEditable(false);
        add(new JLabel("Simulación cuotas a pagar"), BorderLayout.NORTH);
        add(new JScrollPane(areaCuotas), BorderLayout.CENTER);
        add(btnGuardarArriendo, BorderLayout.SOUTH);
    }
}
