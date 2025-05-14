package modelo.mock;

import modelo.ArriendoCuota;
import modelo.Cliente;
import modelo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class DatosMockArriendoCuota {

    private static final List<ArriendoCuota> lista = new ArrayList<>();
    private static int mockIndex = 4;

    public static List<ArriendoCuota> generarArriendosMock() {

        // Clientes
        Cliente cliente1 = new Cliente("11111111-1", "Juan Pérez", false);
        Cliente cliente2 = new Cliente("22222222-2", "Ana López", false); // No vigente

        // Vehículos
        Vehiculo vehiculo1 = new Vehiculo("ABC123", 'A');
        Vehiculo vehiculo2 = new Vehiculo("XYZ789", 'A');

        // Arriendos con cuotas generadas automáticamente
        ArriendoCuota arriendo1 = new ArriendoCuota(1, 5, 20000, 3, cliente1, vehiculo1);
        arriendo1.ingresarArriendoConCuota();

        ArriendoCuota arriendo2 = new ArriendoCuota(2, 7, 180000, 12, cliente2, vehiculo2);
        arriendo2.ingresarArriendoConCuota();

        // Simular algunos pagos
        arriendo1.pagarCuota(1);
        arriendo2.pagarCuota(2);
        arriendo2.pagarCuota(5);

        // Agregar a la lista
        lista.add(arriendo1);
        lista.add(arriendo2);

        return lista;
    }


    public static ArriendoCuota agregarArriendoMock(int dias, int valorDiario, int cantCuotas,
                                                    Cliente cliente, Vehiculo vehiculo) {
        ArriendoCuota nuevo = new ArriendoCuota(mockIndex++, dias, valorDiario, cantCuotas, cliente, vehiculo);
        nuevo.ingresarArriendoConCuota();
        lista.add(nuevo);
        return nuevo;
    }
}
