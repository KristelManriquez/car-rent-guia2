package modelo;

import java.util.ArrayList;
import java.util.List;

public class DatosMockCuotaArriendo {

    public static List<CuotaArriendo> generarCuotasMock() {
        List<CuotaArriendo> lista = new ArrayList<>();

        lista.add(new CuotaArriendo(1, 15000, true));
        lista.add(new CuotaArriendo(2, 15000, false));
        lista.add(new CuotaArriendo(3, 15000, false));
        lista.add(new CuotaArriendo(4, 20000, false));

        return lista;
    }
}
