package modelo;

import java.util.ArrayList;
import java.util.List;

public class DatosMockVehiculo {

    public static List<Vehiculo> generarVehiculosMock() {
        List<Vehiculo> lista = new ArrayList<>();

        lista.add(new Vehiculo("ABC123", 'D'));
        lista.add(new Vehiculo("XYZ789", 'R'));
        lista.add(new Vehiculo("LMN456", 'A'));
        lista.add(new Vehiculo("JKL321", 'D'));
        lista.add(new Vehiculo("QWE987", 'R'));
        lista.add(new Vehiculo("POI654", 'D'));

        return lista;
    }
}