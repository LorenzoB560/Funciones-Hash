package principal;

import modelo.Persona;
import estructura.TablaHash;

/**
 * Clase que gestiona las operaciones sobre la Tabla Hash.
 */
public class GestorPersonas {
    private TablaHash tabla;

    public GestorPersonas() {
        tabla = new TablaHash();
    }

    public void agregarPersona(int id, String nombre, int edad) {
        tabla.insertar(new Persona(id, nombre, edad));
    }

    public void eliminarPersona(int id) {
        if (tabla.eliminar(id)) {
            System.out.println("Persona con ID " + id + " eliminada correctamente.");
        } else {
            System.out.println("No se encontró la persona con ID " + id + ".");
        }
    }

    public void buscarPersona(int id) {
        Persona encontrada = tabla.buscar(id);
        if (encontrada != null) {
            System.out.println("Persona encontrada: " + encontrada);
        } else {
            System.out.println("Persona con ID " + id + " no encontrada.");
        }
    }

    public void mostrarPersonas() {
        tabla.mostrarTabla();
    }
}