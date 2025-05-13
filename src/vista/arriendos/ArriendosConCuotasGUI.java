package arriendos;

import controlador.ClientesControlador;
import vista.*;
import vista.PanelCliente;
import vista.PanelCuotasSimuladas;
import vista.PanelDatosArriendo;

import javax.swing.*;
import java.awt.*;

public class ArriendosConCuotasGUI extends JFrame {
    private final ClientesControlador controlador = new ClientesControlador();
    private final PanelCliente panelCliente;
    private final PanelDatosArriendo panelDatos;
    private final PanelCuotasSimuladas panelCuotas;
    private final JButton btnVerArriendos = new JButton("Ver arriendos");

    private final ClientesGUI clientesGUI = new ClientesGUI(controlador, this);
    private final PagoCuotaArriendoGUI pagoCuotaArriendoGUI = new PagoCuotaArriendoGUI();

    public ArriendosConCuotasGUI() {
        super("Arriendos con cuotas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 450);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Paneles
        panelCliente = new vista.PanelCliente(controlador, this::abrirClientesGUI);
        panelDatos = new PanelDatosArriendo(this::mostrarMontoAPagar);
        panelCuotas = new PanelCuotasSimuladas();

        // Panel izquierdo: cliente + datos
        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
        panelIzquierdo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // margen interno
        panelIzquierdo.add(panelCliente);
        panelIzquierdo.add(Box.createVerticalStrut(15));
        panelIzquierdo.add(panelDatos);

        // Panel derecho: cuotas
        panelCuotas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // margen interno

        // SplitPane
        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                panelIzquierdo,
                panelCuotas
        );
        splitPane.setResizeWeight(0.65); // izquierda ocupa un poco más
        splitPane.setDividerSize(5);
        splitPane.setContinuousLayout(true);
        splitPane.setBorder(null);

        // Panel inferior
        JPanel sur = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnVerArriendos.setBackground(new Color(52, 152, 219)); // azul
        btnVerArriendos.setContentAreaFilled(true); // necesario para mostrar color de fondo
        btnVerArriendos.setBorderPainted(false); // opcional, quita borde si quieres estilo plano
        btnVerArriendos.setForeground(Color.BLACK); // texto amarillo
        btnVerArriendos.addActionListener(e -> {
            if (!pagoCuotaArriendoGUI.isOpen()) {
                mostrarArriendosGUI();
            }
        });
        sur.add(btnVerArriendos);

        // Agregar todo al frame
        add(splitPane, BorderLayout.CENTER);
        add(sur, BorderLayout.SOUTH);

        // Eventos
        panelDatos.btnCalcularCuotas.addActionListener(e -> calcularCuotas());
        panelCuotas.btnGuardarArriendo.addActionListener(e -> guardarArriendo());

        pagoCuotaArriendoGUI.setClientesControlador(controlador);
        setVisible(true);
    }

    private void abrirClientesGUI() {
        if (!clientesGUI.getIsOpen()){
            clientesGUI.setVisible(true);
        }
    }

    public void actualizarClientes() {
        panelCliente.cargarClientes(controlador.getClientes());
    }

    private void mostrarMontoAPagar() {
        try {
            double precio = Double.parseDouble(panelDatos.txtPrecio.getText());
            double dias = Double.parseDouble(panelDatos.txtDias.getText());
            double monto = dias * precio;
            panelDatos.txtMonto.setText(String.valueOf(monto));
        } catch (NumberFormatException ignored) {
            panelDatos.txtMonto.setText("");
        }
    }

    private void calcularCuotas() {
        if (!panelDatos.txtCuotas.getText().isEmpty() && !panelDatos.txtPrecio.getText().isEmpty()) {
            String cuotas = controlador.calcularCuotas(panelDatos.txtMonto.getText(), panelDatos.txtCuotas.getText());
            panelCuotas.areaCuotas.setText(cuotas);
        } else {
            JOptionPane.showMessageDialog(this, "Debe ingresar las cuotas para realizar el cálculo");
        }
    }

    private void guardarArriendo() {
        JOptionPane.showMessageDialog(this, "Arriendo guardado (simulado)");
    }

    private void mostrarArriendosGUI() {
        pagoCuotaArriendoGUI.MostrarPagoCuotaArriendoGUI();
        pagoCuotaArriendoGUI.setOpen(true);
        pagoCuotaArriendoGUI.limpiarPanelPagos();
    }
}
