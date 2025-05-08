import controlador.ClientesControlador;
import vista.ArriendosConCuotasGUI;
import vista.ClientesGUI;
import vista.PagoCuotaArriendoGUI;

public class Main {
    public static void main(String[] args) {
        ClientesControlador controlador = new ClientesControlador();
        ClientesGUI clientesGUI = new ClientesGUI(controlador);
        controlador.setVista(clientesGUI);
        // PagoCuotaArriendoGUI ventana = new PagoCuotaArriendoGUI();
    }
}