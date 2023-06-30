import java.util.ArrayList;

public class baseDeDatos {
    private static ArrayList<String[]> registros = new ArrayList<>();

    public static void agregarRegistro(String name, String number) {
        String[] registro = {name, number};
        registros.add(registro);
    }

    public static String[][] getRegistros() {
        String[][] arr = new String[registros.size()][2];
        for (int i = 0; i < registros.size(); i++) {
            arr[i] = registros.get(i);
        }
        return arr;
    }

    public static String[] buscarRegistro(String name) {
        for (String[] registro : registros) {
            if (registro[0].equals(name)) {
                return registro;
            }
        }
        return null;
    }

    public static void actualizarRegistro(String name, String number) {
        for (String[] registro : registros) {
            if (registro[0].equals(name)) {
                registro[1] = number;
                break;
            }
        }
    }

    public static void eliminarRegistro(String name, String number) {
        for (int i = 0; i < registros.size(); i++) {
            String[] registro = registros.get(i);
            if (registro[0].equals(name) && registro[1].equals(number)) {
                registros.remove(i);
                break;
            }
        }
    }
}
