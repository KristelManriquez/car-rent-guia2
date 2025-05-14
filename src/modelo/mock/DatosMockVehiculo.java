package modelo.mock;

import modelo.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class DatosMockVehiculo {

    public static List<Vehiculo> generarVehiculosMock() {
        List<Vehiculo> lista = new ArrayList<>();

        // Lote generado de forma manual + patrón repetible
        lista.add(new Vehiculo("ABC123", 'A'));
        lista.add(new Vehiculo("XYZ789", 'A'));
        lista.add(new Vehiculo("LMN456", 'D'));
        lista.add(new Vehiculo("JKL321", 'D'));
        lista.add(new Vehiculo("QWE987", 'R'));
        lista.add(new Vehiculo("POI654", 'D'));

        // Vehículos adicionales generados programáticamente
        char[] estados = {'D', 'R', 'A'};
        for (int i = 1; i <= 25; i++) {
            String patente = "V" + String.format("%05d", i);
            char estado = estados[i % estados.length];
            lista.add(new Vehiculo(patente, estado));
        }

        return lista;
    }
}
