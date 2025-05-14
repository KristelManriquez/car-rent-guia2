package modelo.mock;

import modelo.Cliente;

import java.util.ArrayList;
import java.util.List;

public class DatosMockCliente {
    private static final List<Cliente> clientes = new ArrayList<>();

    static {
        clientes.add(new Cliente("11111111-1", "Juan Pérez", false));
        clientes.add(new Cliente("22222222-2", "Ana López", false));
        clientes.add(new Cliente("33333333-3", "Carla Pérez", true));
        clientes.add(new Cliente("44444444-4", "Daniel Soto", true));
        clientes.add(new Cliente("55555555-5", "Eva Martínez", true));
    }

    public static List<Cliente> obtenerClientes() {
        return new ArrayList<>(clientes);
    }

    public static void agregarCliente(Cliente nuevo) {
        clientes.add(nuevo);
    }

    public static void limpiarClientes() {
        clientes.clear();
    }
}
