package modelo;

/**
 * Clase que representa una Persona con un ID, un nombre y una edad.
 */
public class Persona {
    private int id;
    private String nombre;
    private int edad;

    public Persona(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Persona{ID=" + id + ", Nombre='" + nombre + "', Edad=" + edad + "}";
    }
}