// controlador/ClientesControlador.java
package controlador;

import modelo.*;
import modelo.mock.DatosMockVehiculo;
import vista.ClientesGUI;

import java.util.List;

import static modelo.mock.DatosMockArriendoCuota.agregarArriendoMock;

public class ClientesControlador {
    private Cliente cliente;
    private ClientesGUI vista;
    private final List<Cliente> listaClientes = modelo.mock.DatosMockCliente.obtenerClientes();
    private final List<Vehiculo> listaVehiculos = DatosMockVehiculo.generarVehiculosMock();

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

    public boolean guardarArriendo(int dias, int valorDiario, int cantCuotas, Cliente cliente, Vehiculo vehiculo) {
        if (vehiculo.getCondicion() == 'D') {
            agregarArriendoMock(dias, valorDiario, cantCuotas, cliente, vehiculo);
            vista.mostrarMensaje("El vehiculo a sido arrendado correctamente!");
            vehiculo.setCondicion('A');
            return true;
        } else {
            vista.mostrarMensaje("El vehiculo no puede ser arrendado");
            return false;
        }
    }

    public List<ArriendoCuota> getArriendos() {
        return modelo.mock.DatosMockArriendoCuota.generarArriendosMock();
    }

    public List<Vehiculo> getVehiculos() {
        return listaVehiculos;
    }

    public Cliente encontrarCliente(String clienteRut) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(clienteRut)) {
                return cliente;
            }
        }
        return null;
    }

    public Vehiculo encontrarVehiculo(String patente) {
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPatente().equals(patente)) {
                return vehiculo;
            }
        }
        return null;
    }
}
