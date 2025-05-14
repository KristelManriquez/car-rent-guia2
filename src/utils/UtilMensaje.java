package utils;

public class UtilMensaje {

    public static String mostrarMensaje(String mensaje, char tipo) {
        return switch (tipo) {
            case 'i' -> "[INFO]: " + mensaje;
            case 'e' -> "[ERROR]: " + mensaje;
            case 'a' -> "[ADVERTENCIA] ⚠: " + mensaje;
            default -> "[MENSAJE]: " + mensaje;
        };
    }
}