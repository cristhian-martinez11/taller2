/*
 * Clase hija de Animal: agrega la raza y su propio comportamiento.
 */
public class Perro extends Animal {

    private String raza;

    public Perro(int id, String nombre, int edad, String raza) {
        super(id, nombre, edad); // llama al constructor de Animal
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // primero los datos generales
        System.out.println("Tipo: Perro");
        System.out.println("Raza: " + raza);
    }

    @Override
    public String realizarAccion() {
        return getNombre() + " mueve la cola.";
    }
}