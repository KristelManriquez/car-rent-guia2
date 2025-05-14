package modelo;

public class CuotaArriendo {
    private int numeroCuotas;
    private int valorCuota;
    private boolean fuePagada;

    public CuotaArriendo(int numeroCuotas, int valorCuota, boolean fuePagada) {
        this.numeroCuotas = numeroCuotas;
        this.valorCuota = valorCuota;
        this.fuePagada = fuePagada;
    }

    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public int getValorCuota() {
        return valorCuota;
    }
    public void setValorCuota(int valorCuota) {
        this.valorCuota = valorCuota;
    }

    public boolean isFuePagada() {
        return fuePagada;
    }

    public void setFuePagada(boolean fuePagada) {
        this.fuePagada = fuePagada;
    }

    @Override
    public String toString() {
        return "CuotaArriendo{" +
                "numeroCuotas=" + numeroCuotas +
                ", valorCuota=" + valorCuota +
                ", fuePagada=" + fuePagada +
                '}';
    }
}
