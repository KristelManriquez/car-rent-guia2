package controlador;

import modelo.*;
import modelo.mock.DatosMockArriendo;
import modelo.mock.DatosMockVehiculo;
import vista.ClientesGUI;

import java.time.LocalDateTime;
import java.util.List;

public class ClientesControlador {
    private Cliente cliente;
    private ClientesGUI vista;
    private final List<Cliente> listaClientes = modelo.mock.DatosMockCliente.obtenerClientes();
    private final List<Vehiculo> listaVehiculos = DatosMockVehiculo.generarVehiculosMock();
    private DatosMockArriendo arriendos = new DatosMockArriendo();

    public ClientesControlador() {
    }

    public void setVista(ClientesGUI vista) {
        this.vista = vista;
    }

    public void agregarCliente(Cliente cliente) {
        if (cliente.getCedula().isEmpty() || cliente.getNombre().isEmpty()) {
            vista.mostrarMensaje("Por favor, complete todos los campos.", 'i');
            return;
        }
        listaClientes.add(cliente);
        vista.mostrarMensaje("Cliente agregado con éxito.", 'i');
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
        if (!cliente.isVigente()) {
            vista.mostrarMensaje("El cliente no se encuentra vigente.", 'a');
            return false;
        }

        if (vehiculo.getCondicion() == 'D' && cliente.isVigente()) {
            arriendos.agregarArriendoMock(LocalDateTime.now().toString(), dias, valorDiario, cantCuotas, cliente, vehiculo);
            vista.mostrarMensaje("El vehiculo a sido arrendado correctamente!", 'i');
            vehiculo.setCondicion('A');
            cliente.setVigente(false);
            return true;
        } else {
            if (vehiculo.getCondicion() != 'D') {
                vista.mostrarMensaje("El vehiculo no puede ser arrendado", 'a');
            }
        }
        return false;
    }

    public List<Arriendo> getArriendos() {
        return arriendos.getLista();
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

    public void pagarCuotasArriendo(String cedula, int indexCuota) {
        List<Arriendo> arriendosList = arriendos.getLista();
        for (Arriendo arriendo : arriendosList) {
            if (arriendo.getArriendoCuota().getCliente().getCedula().equals(cedula)) {
                ArriendoCuota arriendoCuotas = arriendo.getArriendoCuota();
                arriendoCuotas.pagarCuota(indexCuota);
            }
        }
    }
}
