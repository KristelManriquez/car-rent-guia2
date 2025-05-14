package modelo.mock;

import modelo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class DatosMockVehiculo {

    public static List<Vehiculo> generarVehiculosMock() {
        List<Vehiculo> lista = new ArrayList<>();

        lista.add(new Vehiculo("ABC123", 'A'));
        lista.add(new Vehiculo("XYZ789", 'A'));
        lista.add(new Vehiculo("LMN456", 'D'));
        lista.add(new Vehiculo("JKL321", 'D'));
        lista.add(new Vehiculo("QWE987", 'R'));
        lista.add(new Vehiculo("POI654", 'D'));

        char[] estados = {'D', 'R', 'A'};
        for (int i = 1; i <= 200; i++) {
            String patente = "V" + String.format("%05d", i);
            char estado = estados[i % estados.length];
            lista.add(new Vehiculo(patente, estado));
        }

        return lista;
    }
}
