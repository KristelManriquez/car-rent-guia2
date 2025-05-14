package modelo;

import java.util.ArrayList;

public class ArriendoCuota {
    private int precioDia;
    private int cantidadCuotas;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private ArrayList<CuotaArriendo> listaCuotas;

    public ArriendoCuota(int precioDia, int cantidadCuotas, Cliente cliente, Vehiculo vehiculo) {
        this.precioDia = precioDia;
        this.cantidadCuotas = cantidadCuotas;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.listaCuotas = new ArrayList<>();
    }

    public int obtenerMontoPagar(int diasArriendo) {
        return diasArriendo * precioDia;
    }

    public boolean evaluarArriendo(Cliente cliente, Vehiculo vehiculo) {
        return cliente.isVigente() && vehiculo.getCondicion() == 'D';
    }

    public ArrayList<CuotaArriendo> generarCuotas(int montoTotal) {
        ArrayList<CuotaArriendo> cuotasGeneradas = new ArrayList<>();
        int montoBase = montoTotal / cantidadCuotas;
        int resto = montoTotal % cantidadCuotas;

        for (int i = 1; i <= cantidadCuotas; i++) {
            int monto = montoBase;
            if (i == cantidadCuotas) monto += resto;
            cuotasGeneradas.add(new CuotaArriendo(i, monto, false));
        }

        return cuotasGeneradas;
    }

    public boolean ingresarArriendoConCuota(Arriendo arriendo) {
        if (evaluarArriendo(cliente, vehiculo)) {
            int monto = obtenerMontoPagar(arriendo.getDiasArriendo());
            listaCuotas = generarCuotas(monto);
            vehiculo.setCondicion('A');
            return true;
        }
        return false;
    }

    public boolean pagarCuota(int numeroCuota) {
        for (CuotaArriendo c : listaCuotas) {
            if (c.getNumeroCuotas() == numeroCuota && !c.isFuePagada()) {
                c.setFuePagada(true);
                return true;
            }
        }
        return false;
    }

    public ArrayList<CuotaArriendo> getListaCuotas() {
        return listaCuotas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}
