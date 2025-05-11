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
}
