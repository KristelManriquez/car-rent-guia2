// controlador/ClientesControlador.java
package controlador;

import modelo.ArriendoCuota;
import modelo.Cliente;
import modelo.DatosMockArriendoCuota;
import vista.ClientesGUI;

import java.util.ArrayList;
import java.util.List;

public class ClientesControlador {
    private Cliente cliente;
    private ClientesGUI vista;
    private List<Cliente> listaClientes = new ArrayList<>();

    public ClientesControlador(ClientesGUI vista) {
        this.vista = vista;
    }

    public ClientesControlador() {
    }

    public void setVista(ClientesGUI vista) {
        this.vista = vista;
    }

    public void agregarCliente(Cliente cliente) {
        if (cliente.getCedula().isEmpty() || cliente.getNombre().isEmpty()) {
            vista.mostrarMensaje("Por favor, complete todos los campos.");
            return;
        }
        listaClientes.add(cliente);
        vista.mostrarMensaje("Cliente agregado con éxito.");
        vista.limpiarFormulario();
    }

    public List<Cliente> getClientes() {
        return listaClientes;
    }

    public String calcularCuotas(String txtMonto, String txtCuotas) {
        String cuotasString = "";
        double montoTotal = txtMonto.isEmpty() ? 0 : Double.parseDouble(txtMonto.trim());
        int cantidadCuotas = txtCuotas.isEmpty() ? 0 : Integer.parseInt(txtCuotas.trim());

        double valorCuota = montoTotal / cantidadCuotas;
        for (int i = 0; i < cantidadCuotas; i++) {
            int numeroCuota = i + 1;
            cuotasString = cuotasString.concat("Cuota numero: " + numeroCuota + " - Monto Cuota: " + valorCuota + "\n");
            if (numeroCuota == cantidadCuotas) {
                break;
            }
        }
        return cuotasString;
    }

//    public boolean guardarArriendo() {
//    }

    public List<ArriendoCuota> getArriendos() {
        return DatosMockArriendoCuota.generarArriendosMock();
    }
}
