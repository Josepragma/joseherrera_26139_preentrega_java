// Importamos las clases necesarias para el funcionamiento del programa
// ArrayList para manejar la lista de artículos, Scanner para leer la entrada del usuario
import java.util.ArrayList;

// Importamos la clase Scanner para leer la entrada del usuario
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        // Creamos el escáner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);

        // Creamos un arraylist de strings para almacenar los artículos
        ArrayList<String> articulos = new ArrayList<String>();  

        // Creamos la variable opcion para almacenar la opción seleccionada por el usuario
        int opcion;

        // Bucle principal del menú
        do {
             System.out.println(" \n****************************************************************");
             System.out.println("Sistema de Gestion Pragmatech: ");
             System.out.println("Seleccione una opcion: ");
             System.out.println("1. Ingrese un Articulo");
             System.out.println("2. Listar articulos");
             System.out.println("3. Consultar un articulo");
             System.out.println("4. Modificar un articulo");
             System.out.println("5. Eliminar un articulo");
             System.out.println("0. Salir");
             System.out.println("****************************************************************");

            opcion = leerEntero(sc, "Ingrese una opcion: ");

            // Validación adicional de rango
            if (opcion < 0 || opcion > 5) {
                System.out.println("Opcion fuera de rango. Debe ser entre 0 y 5.");
                continue;
            }
            
            switch (opcion) {
                case 1:
                    ingresarArticulo(sc, articulos);
                    break;

                case 2:
                    listarArticulos(articulos);
                    break;

                case 3:
                    consultarArticulo(sc, articulos);
                    break;

                case 4:
                    modificarArticulo(sc, articulos);
                    break;

                case 5:
                    eliminarArticulo(sc, articulos);
                    break;

                case 0:
                    System.out.println("Gracias por usar el sistema de gestion Pragmatech, hasta luego!");
                    sc.close();
                    break;
             }

         } while (opcion != 0);
    }

    // -------------------------------------------------------------
    // MÉTODO AUXILIAR PARA LEER ENTEROS
    // -------------------------------------------------------------
    /**
     * Lee un número entero desde teclado de forma segura.
     * Evita que el programa se rompa si el usuario escribe letras.
     */
    private static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero válido.");
            }
        }
    }

    // -------------------------------------------------------------
    // MÉTODO AUXILIAR PARA VALIDAR NOMBRE PARA INGRESAR (NO DUPLICADO)
    // -------------------------------------------------------------
    /**
     * Este método se usa SOLO para ingresar artículos.
     * Valida que el nombre no esté vacío y no exista previamente.
     */
    private static String leerNombreValido(Scanner sc, ArrayList<String> articulos, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String nombre = sc.nextLine().trim();

            if (nombre.isEmpty()) {
                System.out.println("Error: el nombre del artículo no puede estar vacío.");
                continue;
            }

            boolean existe = false;
            for (String art : articulos) {
                String nombreExistente = art.split(" - ")[0].trim();
                if (nombreExistente.equalsIgnoreCase(nombre)) {
                    existe = true;
                    break;
                }
            }

            if (existe) {
                System.out.println("Error: el artículo '" + nombre + "' ya existe.");
                continue;
            }

            return nombre;
        }
    }

    // -------------------------------------------------------------
    // MÉTODO AUXILIAR PARA VALIDAR NOMBRE PARA MODIFICAR (PERMITE MANTENER EL MISMO)
    // -------------------------------------------------------------
    /**
     * Este método se usa SOLO para modificar artículos.
     * Permite mantener el mismo nombre, pero evita duplicados con otros artículos.
     */
    private static String leerNombreParaModificar(Scanner sc, ArrayList<String> articulos, String nombreActual) {
        while (true) {
            System.out.print("Ingrese el nuevo nombre del artículo: ");
            String nombre = sc.nextLine().trim();

            if (nombre.isEmpty()) {
                System.out.println("Error: el nombre no puede estar vacío.");
                continue;
            }

            if (nombre.equalsIgnoreCase(nombreActual)) {
                return nombre;
            }

            boolean existe = false;
            for (String art : articulos) {
                String nombreExistente = art.split(" - ")[0].trim();
                if (nombreExistente.equalsIgnoreCase(nombre)) {
                    existe = true;
                    break;
                }
            }

            if (existe) {
                System.out.println("Error: ya existe otro artículo con ese nombre.");
                continue;
            }

            return nombre;
        }
    }

    // -------------------------------------------------------------
    // MÉTODO AUXILIAR PARA VALIDAR PRECIO ENTERO
    // -------------------------------------------------------------
    /**
     * Lee un precio válido:
     * - Debe ser un número entero
     * - Debe ser mayor a 0
     */
    private static int leerPrecioEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int precio = Integer.parseInt(sc.nextLine().trim());
                if (precio <= 0) {
                    System.out.println("Error: el precio debe ser mayor a 0.");
                    continue;
                }
                return precio;
            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un número entero válido.");
            }
        }
    }

    // -------------------------------------------------------------
    // 1. INGRESAR ARTÍCULO
    // -------------------------------------------------------------
    private static void ingresarArticulo(Scanner sc, ArrayList<String> articulos) {

        String nombre = leerNombreValido(sc, articulos, "Ingrese el nombre del artículo: ");
        int precio = leerPrecioEntero(sc, "Ingrese el precio del artículo (solo enteros): ");

        String articulo = nombre + " - $" + precio;

        articulos.add(articulo);
        System.out.println("Artículo agregado correctamente.");
    }

    // -------------------------------------------------------------
    // 2. LISTAR ARTÍCULOS
    // -------------------------------------------------------------
    private static void listarArticulos(ArrayList<String> articulos) {
        if (articulos.isEmpty()) {
            System.out.println("No hay artículos cargados.");
            return;
        }

        System.out.println("\nListado de artículos:");
        for (int i = 0; i < articulos.size(); i++) {
            System.out.println((i + 1) + ". " + articulos.get(i));
        }
    }

    // -------------------------------------------------------------
    // 3. CONSULTAR ARTÍCULO POR NOMBRE
    // -------------------------------------------------------------
    private static void consultarArticulo(Scanner sc, ArrayList<String> articulos) {

        if (articulos.isEmpty()) {
            System.out.println("No hay artículos para consultar.");
            return;
        }

        System.out.print("Ingrese el nombre del artículo a consultar: ");
        String nombreBuscado = sc.nextLine().trim();

        for (String art : articulos) {
            String nombreExistente = art.split(" - ")[0].trim();
            if (nombreExistente.equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Artículo encontrado: " + art);
                return;
            }
        }

        System.out.println("No se encontró un artículo con ese nombre.");
    }

    // -------------------------------------------------------------
    // 4. MODIFICAR ARTÍCULO POR NOMBRE
    // -------------------------------------------------------------
    private static void modificarArticulo(Scanner sc, ArrayList<String> articulos) {

        if (articulos.isEmpty()) {
            System.out.println("No hay artículos para modificar.");
            return;
        }

        System.out.print("Ingrese el nombre del artículo a modificar: ");
        String nombreBuscado = sc.nextLine().trim();

        int index = -1;

        // Buscar artículo por nombre
        for (int i = 0; i < articulos.size(); i++) {
            String nombreExistente = articulos.get(i).split(" - ")[0].trim();
            if (nombreExistente.equalsIgnoreCase(nombreBuscado)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("No se encontró un artículo con ese nombre.");
            return;
        }

        System.out.println("Artículo actual: " + articulos.get(index));

        String nombreActual = articulos.get(index).split(" - ")[0].trim();

        // Nuevo nombre
        String nuevoNombre = leerNombreParaModificar(sc, articulos, nombreActual);

        // Nuevo precio
        int nuevoPrecio = leerPrecioEntero(sc, "Ingrese el nuevo precio (solo enteros): ");

        articulos.set(index, nuevoNombre + " - $" + nuevoPrecio);
        System.out.println("Artículo modificado correctamente.");
    }

    // -------------------------------------------------------------
    // 5. ELIMINAR ARTÍCULO POR NOMBRE
    // -------------------------------------------------------------
    private static void eliminarArticulo(Scanner sc, ArrayList<String> articulos) {

        if (articulos.isEmpty()) {
            System.out.println("No hay artículos para eliminar.");
            return;
        }

        System.out.print("Ingrese el nombre del artículo a eliminar: ");
        String nombreBuscado = sc.nextLine().trim();

        for (int i = 0; i < articulos.size(); i++) {
            String nombreExistente = articulos.get(i).split(" - ")[0].trim();
            if (nombreExistente.equalsIgnoreCase(nombreBuscado)) {
                articulos.remove(i);
                System.out.println("Artículo eliminado correctamente.");
                return;
            }
        }

        System.out.println("No se encontró un artículo con ese nombre.");
    }
}
