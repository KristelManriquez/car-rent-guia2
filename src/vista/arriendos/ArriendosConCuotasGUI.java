package vista.arriendos;

import controlador.ClientesControlador;
import modelo.Cliente;
import modelo.Vehiculo;
import utils.UtilMensaje;
import vista.*;

import javax.swing.*;
import java.awt.*;

public class ArriendosConCuotasGUI extends JFrame {
    private final ClientesControlador controlador;
    private final PanelCliente panelCliente;
    private final PanelDatosArriendo panelDatos;
    private final PanelCuotasSimuladas panelCuotas;

    private final PagoCuotaArriendoGUI pagoCuotaArriendoGUI = new PagoCuotaArriendoGUI();

    public ArriendosConCuotasGUI(ClientesControlador controlador) {
        super("Arriendos con cuotas");
        this.controlador = controlador;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(900, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        panelCliente = new PanelCliente(controlador);
        panelDatos = new PanelDatosArriendo(this::mostrarMontoAPagar);
        panelCuotas = new PanelCuotasSimuladas();

        JPanel panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new BoxLayout(panelIzquierdo, BoxLayout.Y_AXIS));
        panelIzquierdo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // margen interno
        panelIzquierdo.add(panelCliente);
        panelIzquierdo.add(Box.createVerticalStrut(15));
        panelIzquierdo.add(panelDatos);

        panelCuotas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // margen interno

        JSplitPane splitPane = new JSplitPane(
                JSplitPane.HORIZONTAL_SPLIT,
                panelIzquierdo,
                panelCuotas
        );
        splitPane.setResizeWeight(0.65); // izquierda ocupa un poco más
        splitPane.setDividerSize(5);
        splitPane.setContinuousLayout(true);
        splitPane.setBorder(null);

        JPanel sur = new JPanel(new FlowLayout(FlowLayout.LEFT));

        add(splitPane, BorderLayout.CENTER);
        add(sur, BorderLayout.SOUTH);

        panelDatos.btnCalcularCuotas.addActionListener(e -> calcularCuotas());
        panelCuotas.btnGuardarArriendo.addActionListener(e -> guardarArriendo());

        pagoCuotaArriendoGUI.setClientesControlador(controlador);
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
        if (validarCuotas()) return;
        if (!panelDatos.txtCuotas.getText().isEmpty() && !panelDatos.txtPrecio.getText().isEmpty()) {
            String cuotas = controlador.calcularCuotas(panelDatos.txtMonto.getText(), panelDatos.txtCuotas.getText());
            panelCuotas.areaCuotas.setText(cuotas);
        } else {
            JOptionPane.showMessageDialog(this, UtilMensaje.mostrarMensaje("Debe ingresar las cuotas para realizar el cálculo", 'i'));
        }
    }

    private boolean validarCuotas() {
        if (panelDatos.txtCuotas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, UtilMensaje.mostrarMensaje("Ingrese las cuotas", 'i'));
            return true;
        }
        if (Integer.parseInt(panelDatos.txtCuotas.getText()) > 6) {
            panelDatos.txtCuotas.setText("6");
            JOptionPane.showMessageDialog(this, UtilMensaje.mostrarMensaje("Las cuotas no pueden ser mayor a 6", 'i'));
            return true;
        }
        return false;
    }

    private void guardarArriendo() {
        try {
            int dias = Integer.parseInt(panelDatos.txtDias.getText());
            int valorDiario = Integer.parseInt(panelDatos.txtPrecio.getText());
            int cuotas = Integer.parseInt(panelDatos.txtCuotas.getText());
            String[] clienteSplit = panelCliente.obtenerClienteSeleccionado().split("-", 2);
            Cliente cliente = controlador.encontrarCliente(clienteSplit[1].trim());
            String[] vehiculoSplit = panelCliente.obtenerVehiculoSeleccionado().split("-");
            Vehiculo vehiculo = controlador.encontrarVehiculo(vehiculoSplit[0].trim());
            if (controlador.guardarArriendo(dias, valorDiario, cuotas, cliente, vehiculo)){
                limpiarForm();
                updateCombos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, UtilMensaje.mostrarMensaje("Las cuotas no pueden ser mayor a 12", 'e'));
        }
    }

    private void limpiarForm() {
        panelDatos.txtCuotas.setText("");
        panelDatos.txtPrecio.setText("");
        panelDatos.txtDias.setText("");
        panelCuotas.areaCuotas.setText("");
    }

    public void updateCombos() {
        panelCliente.actualizarCombos(controlador);
    }
}
