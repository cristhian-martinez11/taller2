import java.util.ArrayList;

/*
 * Clase gestora: administra la colección de animales del refugio.
 */
public class Refugio {

    private ArrayList<Animal> animales;

    public Refugio() {
        animales = new ArrayList<Animal>();
    }

    // Indica si todavía no hay animales
    public boolean estaVacio() {
        return animales.isEmpty();
    }

    // Registra un animal. Devuelve false si los datos son inválidos o el ID ya existe
    public boolean registrarAnimal(Animal animal) {
        if (animal == null) {
            return false;
        }
        if (animal.getId() <= 0 || animal.getNombre().trim().isEmpty() || animal.getEdad() < 0) {
            return false;
        }
        if (buscarPorId(animal.getId()) != null) {
            return false; // ID repetido
        }
        animales.add(animal);
        return true;
    }

    // Búsqueda secuencial: devuelve la primera coincidencia o null
    public Animal buscarPorId(int id) {
        for (Animal a : animales) {
            if (a.getId() == id) {
                return a;
            }
        }
        return null;
    }

    // Muestra todos los animales y su acción (polimorfismo)
    public void mostrarAnimales() {
        if (animales.isEmpty()) {
            System.out.println("\nNo hay animales registrados todavía.");
            return;
        }
        System.out.println("\n--- Animales del refugio ---");
        for (Animal a : animales) {
            a.mostrarInformacion();
            System.out.println("Acción: " + a.realizarAccion());
            System.out.println("-----------------------------");
        }
    }

    // Cambia el estado a ADOPTADO. Devuelve false si no existe o ya está adoptado
    public boolean adoptarAnimal(int id) {
        Animal a = buscarPorId(id);
        if (a == null) {
            return false;
        }
        if (a.getEstado().equals("ADOPTADO")) {
            return false;
        }
        a.setEstado("ADOPTADO");
        return true;
    }
}