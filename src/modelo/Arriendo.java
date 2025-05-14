package modelo;

public class Arriendo {
    private int numeroArriendo;
    private String fechaArriendo;
    private int diasArriendo;
    private ArriendoCuota arriendoCuota;

    public Arriendo(int numeroArriendo, String fechaArriendo, int diasArriendo) {
        this.numeroArriendo = numeroArriendo;
        this.fechaArriendo = fechaArriendo;
        this.diasArriendo = diasArriendo;
    }

    public int getNumeroArriendo() {
        return numeroArriendo;
    }

    public void setNumeroArriendo(int numeroArriendo) {
        this.numeroArriendo = numeroArriendo;
    }

    public String getFechaArriendo() {
        return fechaArriendo;
    }

    public void setFechaArriendo(String fechaArriendo) {
        this.fechaArriendo = fechaArriendo;
    }

    public int getDiasArriendo() {
        return diasArriendo;
    }

    public void setDiasArriendo(int diasArriendo) {
        this.diasArriendo = diasArriendo;
    }

    public ArriendoCuota getArriendoCuota() {
        return arriendoCuota;
    }

    public void setArriendoCuota(ArriendoCuota arriendoCuota) {
        this.arriendoCuota = arriendoCuota;
    }

    public int obtenerMontoAPagar(int precioPorDia) {
        return diasArriendo * precioPorDia;
    }

    public boolean evaluarArriendo(Cliente cliente, Vehiculo vehiculo) {
        return cliente.isVigente() && vehiculo.getCondicion() == 'D';
    }

    @Override
    public String toString() {
        return "Arriendo{" +
                "numeroArriendo=" + numeroArriendo +
                ", fechaArriendo='" + fechaArriendo + '\'' +
                ", diasArriendo=" + diasArriendo +
                '}';
    }
}
