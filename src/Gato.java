/*
 * Clase hija de Animal: agrega el color y su propio comportamiento.
 */
public class Gato extends Animal {

    private String color;

    public Gato(int id, String nombre, int edad, String color) {
        super(id, nombre, edad); // llama al constructor de Animal
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion(); // primero los datos generales
        System.out.println("Tipo: Gato");
        System.out.println("Color: " + color);
    }

    @Override
    public String realizarAccion() {
        return getNombre() + " juega con una pelota.";
    }
}