package modelo;

import java.util.ArrayList;

public class ArriendoCuota {
    private int cantidadCuotas;

    public ArriendoCuota(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    @Override
    public String toString() {
        return "ArriendoCuota{" +
                "cantidadCuotas=" + cantidadCuotas +
                '}';
    }

    public void crearArriendoCuota(int numeroA, String fecha, int dias, int cantidadCuotas) {

    }

    public boolean ingresarArriendoConCuota(int precioDia) {
        return false;
    }

    public ArrayList<ArriendoCuota> generarCuotas(int precioDia) {
        return null;
    }
}
