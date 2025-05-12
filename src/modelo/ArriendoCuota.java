package modelo;

import java.util.ArrayList;

public class ArriendoCuota {
    private int numeroArriendo;
    private int dias;
    private int precioDia;
    private int cantidadCuotas;
    private Cliente cliente;        // clase Cliente
    private Vehiculo vehiculo;      // clase Vehiculo
    private ArrayList<CuotaArriendo> listaCuotas;

    public ArriendoCuota(int numeroArriendo, int dias, int precioDia, int cantidadCuotas, Cliente cliente, Vehiculo vehiculo) {
        this.numeroArriendo = numeroArriendo;
        this.dias = dias;
        this.precioDia = precioDia;
        this.cantidadCuotas = cantidadCuotas;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.listaCuotas = new ArrayList<>();
    }

    public ArriendoCuota() {
    }

    public int getNumeroArriendo() {
        return numeroArriendo;
    }

    public void setNumeroArriendo(int numeroArriendo) {
        this.numeroArriendo = numeroArriendo;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(int precioDia) {
        this.precioDia = precioDia;
    }

    public int getCantidadCuotas() {
        return cantidadCuotas;
    }

    public void setCantidadCuotas(int cantidadCuotas) {
        this.cantidadCuotas = cantidadCuotas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public ArrayList<CuotaArriendo> getListaCuotas() {
        return listaCuotas;
    }

    public void setListaCuotas(ArrayList<CuotaArriendo> listaCuotas) {
        this.listaCuotas = listaCuotas;
    }

    public int obtenerMontoPagar() {
        return dias * precioDia;
    }

    public boolean evaluarArriendo() {
        return cliente.isVigente() && vehiculo.getCondicion() == 'D';
    }

    public ArrayList<CuotaArriendo> generarCuotas() {
        ArrayList<CuotaArriendo> cuotasGeneradas = new ArrayList<>();
        int total = obtenerMontoPagar();
        int montoBase = total / cantidadCuotas;
        int resto = total % cantidadCuotas;

        for (int i = 1; i <= cantidadCuotas; i++) {
            int monto = montoBase;
            if (i == cantidadCuotas) monto += resto;
            cuotasGeneradas.add(new CuotaArriendo(i, monto, false));
        }

        return cuotasGeneradas;
    }

    public boolean ingresarArriendoConCuota() {
        if (evaluarArriendo()) {
            vehiculo.setCondicion('A'); // Arrendado
            listaCuotas = generarCuotas(); // relación compuesta
            return true;
        } else {
            return false;
        }
    }

    public boolean pagarCuota(int numeroCuota) {
        for (CuotaArriendo c : listaCuotas) {
            if (c.getNumeroCuotas() == numeroCuota) {
                c.setFuePagada(true);
                return true;
            }
        }
        return false;
    }
}