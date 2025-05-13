package modelo;

import java.util.ArrayList;
import java.util.List;

public class DatosMockArriendoCuota {

    public static List<ArriendoCuota> generarArriendosMock() {
        List<ArriendoCuota> lista = new ArrayList<>();

        Cliente cliente1 = new Cliente("11111111-1", "Juan Pérez", true);
        Cliente cliente2 = new Cliente("22222222-2", "Ana López", true);
        Cliente cliente3 = new Cliente("33333333-3", "Carlos Díaz", false); // No vigente

        Vehiculo vehiculo1 = new Vehiculo("ABC123", 'D');
        Vehiculo vehiculo2 = new Vehiculo("XYZ789", 'D');
        Vehiculo vehiculo3 = new Vehiculo("LMN456", 'R'); // En reparación

        ArriendoCuota arriendo1 = new ArriendoCuota(1, 5, 20000, 3, cliente1, vehiculo1);
        arriendo1.ingresarArriendoConCuota();

        ArriendoCuota arriendo2 = new ArriendoCuota(2, 7, 180000, 12, cliente2, vehiculo2);
        arriendo2.ingresarArriendoConCuota();

        ArriendoCuota arriendo3 = new ArriendoCuota(3, 10, 15000, 4, cliente3, vehiculo3);
        arriendo3.ingresarArriendoConCuota();

        lista.add(arriendo1);
        lista.add(arriendo2);
        lista.add(arriendo3);

        return lista;
    }
}
