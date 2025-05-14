package modelo.mock;

import modelo.Arriendo;
import modelo.ArriendoCuota;
import modelo.Cliente;
import modelo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class DatosMockArriendo {

    private final List<Arriendo> lista;
    private static int mockIndex = 3;

    public DatosMockArriendo() {
        lista = new ArrayList<>();

        Cliente cliente1 = new Cliente("11111111-1", "Juan Pérez", true);
        Cliente cliente2 = new Cliente("22222222-2", "Ana López", true);

        Vehiculo vehiculo1 = new Vehiculo("ABC123", 'D');
        Vehiculo vehiculo2 = new Vehiculo("XYZ789", 'D');

        Arriendo arriendo1 = new Arriendo(1, "2025-05-14", 5);
        ArriendoCuota cuotas1 = new ArriendoCuota(20000, 3, cliente1, vehiculo1);
        if (cuotas1.ingresarArriendoConCuota(arriendo1)) {
            arriendo1.setArriendoCuota(cuotas1);
            cuotas1.pagarCuota(1);
            lista.add(arriendo1);
        }

        Arriendo arriendo2 = new Arriendo(2, "2025-05-12", 7);
        ArriendoCuota cuotas2 = new ArriendoCuota(180000, 12, cliente2, vehiculo2);
        if (cuotas2.ingresarArriendoConCuota(arriendo2)) {
            arriendo2.setArriendoCuota(cuotas2);
            cuotas2.pagarCuota(2);
            lista.add(arriendo2);
        }
    }

    public Arriendo agregarArriendoMock(String fecha, int dias, int valorDiario, int cantCuotas,
                                        Cliente cliente, Vehiculo vehiculo) {
        Arriendo nuevo = new Arriendo(mockIndex++, fecha, dias);
        ArriendoCuota cuotas = new ArriendoCuota(valorDiario, cantCuotas, cliente, vehiculo);
        if (cuotas.ingresarArriendoConCuota(nuevo)) {
            nuevo.setArriendoCuota(cuotas);
            lista.add(nuevo);
            return nuevo;
        }
        return null;
    }

    public List<Arriendo> getLista() {
        return lista;
    }
}
