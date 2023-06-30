public class Buscar {
    public static void buscarRegistro(String name) {
        String[] registro = baseDeDatos.buscarRegistro(name);
        if (registro != null) {
            System.out.println("Nombre: " + registro[0]);
            System.out.println("Número: " + registro[1]);
        } else {
            System.out.println("Registro no encontrado");
        }
    }
}