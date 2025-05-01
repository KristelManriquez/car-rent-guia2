package model;

public class Arriendo {
    private int numeroArriendo;
    private String fechaArriendo;
    private int diasArriendo;

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

    @Override
    public String toString() {
        return "Arriendo{" +
                "numeroArriendo=" + numeroArriendo +
                ", fechaArriendo='" + fechaArriendo + '\'' +
                ", diasArriendo=" + diasArriendo +
                '}';
    }

    public void crearArriendo() {

    }

    public int obtenerMontoAPagar() {
        return 0;
    }

    public boolean evaluarArriendo() {
        return false;
    }
}
