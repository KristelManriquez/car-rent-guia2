// controlador/ClientesControlador.java
package controlador;

import modelo.Cliente;
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

    public void agregarCliente() {
        String cedula = vista.getCedula();
        String nombre = vista.getNombre();
        boolean vigente = vista.isVigente();

        if (cedula.isEmpty() || nombre.isEmpty()) {
            vista.mostrarMensaje("Por favor, complete todos los campos.");
            return;
        }

        Cliente nuevoCliente = new Cliente(cedula, nombre, vigente);
        listaClientes.add(nuevoCliente);
        vista.mostrarMensaje("Cliente agregado con éxito.");
        vista.limpiarFormulario();
    }

    public List<Cliente> getClientes() {
        return listaClientes;
    }
}
