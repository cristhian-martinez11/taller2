/*
 * Clase padre: representa la información común de todos los animales.
 * Autor: Cristhian Martinez Vargas
 */
public class Animal {

    // Atributos privados (encapsulamiento)
    private int id;
    private String nombre;
    private int edad;
    private String estado;

    // Constructor: el estado inicial siempre es DISPONIBLE
    public Animal(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.estado = "DISPONIBLE";
    }

    // Getters: permiten consultar los datos
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getEstado() {
        return estado;
    }

    // Único setter: solo se puede cambiar el estado
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Muestra los datos generales (las hijas lo sobrescriben y agregan lo suyo)
    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Estado: " + estado);
    }

    // Acción general: las hijas la sobrescriben con su comportamiento propio
    public String realizarAccion() {
        return nombre + " hace un ruido.";
    }
}