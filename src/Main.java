import java.util.Scanner;

/*
 * Clase principal: maneja el Scanner, el menú y crea los objetos.
 * La lógica de los animales está en la clase Refugio.
 */
public class Main {

    // Lee un entero. Si el usuario escribe texto, el try-catch avisa y vuelve a pedirlo
    public static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Error: debes escribir un número entero.");
            }
        }
    }

    // Lee un texto y lo repite hasta que no esté vacío
    public static String leerTexto(Scanner sc, String mensaje) {
        String texto;
        do {
            System.out.print(mensaje);
            texto = sc.nextLine().trim();
            if (texto.isEmpty()) {
                System.out.println("Error: este dato no puede estar vacío.");
            }
        } while (texto.isEmpty());
        return texto;
    }

    public static void mostrarMenu() {
        System.out.println("\n=========== REFUGIO ===========");
        System.out.println("1. Registrar animal");
        System.out.println("2. Mostrar animales");
        System.out.println("3. Buscar animal por ID");
        System.out.println("4. Adoptar animal");
        System.out.println("5. Salir");
    }

    public static void registrar(Scanner sc, Refugio refugio) {
        int tipo = leerEntero(sc, "Tipo (1 = Perro, 2 = Gato): ");
        while (tipo != 1 && tipo != 2) {
            System.out.println("Error: el tipo debe ser 1 o 2.");
            tipo = leerEntero(sc, "Tipo (1 = Perro, 2 = Gato): ");
        }

        int id = leerEntero(sc, "ID: ");
        if (id <= 0) {
            System.out.println("Error: el ID debe ser mayor que 0. No se registró el animal.");
            return;
        }
        if (refugio.buscarPorId(id) != null) {
            System.out.println("Error: ya existe un animal con ese ID. No se registró.");
            return;
        }

        String nombre = leerTexto(sc, "Nombre: ");

        int edad = leerEntero(sc, "Edad: ");
        if (edad < 0) {
            System.out.println("Error: la edad no puede ser negativa. No se registró el animal.");
            return;
        }

        Animal animal;
        if (tipo == 1) {
            String raza = leerTexto(sc, "Raza: ");
            animal = new Perro(id, nombre, edad, raza);
        } else {
            String color = leerTexto(sc, "Color: ");
            animal = new Gato(id, nombre, edad, color);
        }

        if (refugio.registrarAnimal(animal)) {
            System.out.println("Animal registrado correctamente.");
        } else {
            System.out.println("No se pudo registrar el animal.");
        }
    }

    public static void buscar(Scanner sc, Refugio refugio) {
        if (refugio.estaVacio()) {
            System.out.println("\nNo hay animales registrados todavía.");
            return;
        }
        int id = leerEntero(sc, "ID a buscar: ");
        Animal animal = refugio.buscarPorId(id);
        if (animal == null) {
            System.out.println("Animal no encontrado");
        } else {
            System.out.println();
            animal.mostrarInformacion();
            System.out.println("Acción: " + animal.realizarAccion());
        }
    }

    public static void adoptar(Scanner sc, Refugio refugio) {
        if (refugio.estaVacio()) {
            System.out.println("\nNo hay animales registrados todavía.");
            return;
        }
        int id = leerEntero(sc, "ID del animal a adoptar: ");
        Animal animal = refugio.buscarPorId(id);
        if (animal == null) {
            System.out.println("Animal no encontrado");
        } else if (animal.getEstado().equals("ADOPTADO")) {
            System.out.println("Este animal ya está adoptado.");
        } else if (refugio.adoptarAnimal(id)) {
            System.out.println("¡" + animal.getNombre() + " fue adoptado! Estado: " + animal.getEstado());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Refugio refugio = new Refugio();
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(sc, "Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    registrar(sc, refugio);
                    break;
                case 2:
                    refugio.mostrarAnimales();
                    break;
                case 3:
                    buscar(sc, refugio);
                    break;
                case 4:
                    adoptar(sc, refugio);
                    break;
                case 5:
                    System.out.println("\nPrograma finalizado. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción inválida. Debe estar entre 1 y 5.");
            }
        } while (opcion != 5);

        sc.close();
    }
}