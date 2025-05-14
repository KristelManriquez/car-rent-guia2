package utils;

public class CedulaValidador {

    public static boolean validarCedula(String cedula) {
        if (cedula == null || cedula.isEmpty()) return false;

        cedula = cedula.replace(".", "").toUpperCase();

        if (!cedula.contains("-")) return false;

        String[] partes = cedula.split("-");
        if (partes.length != 2) return false;

        String cuerpo = partes[0];
        String dv = partes[1];

        if (!cuerpo.matches("\\d+")) return false;

        String dvEsperado = calcularDigitoVerificador(cuerpo);

        return dv.equals(dvEsperado);
    }

    private static String calcularDigitoVerificador(String CedulaCuerpo) {
        int suma = 0;
        int multiplicador = 2;

        for (int i = CedulaCuerpo.length() - 1; i >= 0; i--) {
            suma += Character.getNumericValue(CedulaCuerpo.charAt(i)) * multiplicador;
            multiplicador = (multiplicador == 7) ? 2 : multiplicador + 1;
        }

        int resto = suma % 11;
        int dv = 11 - resto;

        if (dv == 11) return "0";
        else if (dv == 10) return "K";
        else return String.valueOf(dv);
    }
}

