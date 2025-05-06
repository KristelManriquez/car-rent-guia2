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

    // Arraylist [cuota1, cuota2, cuota3, cuota4]
    // encontrar la forma de generar instancias para ir llenando el arraylist de cuotas dependiendo el número de cuotas pactadas (según cantCuotas en clase ArriendoCuotas
    // recorrer el array y debe encontrar la cuota que quiere pagar el usuario (ciclo for)
    // si por ejemplo, en la función ingresamos la cuota3, a esa cuota debe establecer el valor de fuePagada en true
    // si no la encuentra, retorna false.

    public boolean pagarCuota(CuotaArriendo cuotaArriendo) {
        if (!fuePagada) {
            fuePagada = true;
            return true;
        }
        return false;
    }
}
