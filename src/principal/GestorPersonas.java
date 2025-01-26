package principal;

import modelo.Persona;
import estructura.TablaHash;

/**
 * Clase que gestiona las operaciones sobre la Tabla Hash.
 * Permite agregar, eliminar, buscar y listar personas almacenadas en la tabla hash.
 */
public class GestorPersonas {
    private TablaHash tabla;

    /**
     * Constructor que inicializa la tabla hash.
     */
    public GestorPersonas() {
        tabla = new TablaHash();
    }

    /**
     * Verifica si la tabla hash está vacía e imprime un mensaje en consola.
     */
    public void verificarSiEstaVacia() {
        if (tabla.estaVacia()) {
            System.out.println("La tabla hash está vacía.");
        } else {
            System.out.println("La tabla hash tiene personas almacenadas.");
        }
    }

    /**
     * Agrega una persona a la tabla hash.
     *
     * @param id    Identificador único de la persona.
     * @param nombre Nombre de la persona.
     * @param edad   Edad de la persona.
     */
    public void agregarPersona(int id, String nombre, int edad) {
        tabla.insertar(new Persona(id, nombre, edad));
    }

    /**
     * Elimina una persona de la tabla hash usando su ID.
     *
     * @param id Identificador único de la persona a eliminar.
     */
    public void eliminarPersona(int id) {
        if (tabla.eliminar(id)) {
            System.out.println("Persona con ID " + id + " eliminada correctamente.");
        } else {
            System.out.println("No se encontró la persona con ID " + id + ".");
        }
    }

    /**
     * Busca una persona en la tabla hash e imprime su información.
     *
     * @param id Identificador único de la persona a buscar.
     */
    public void buscarPersona(int id) {
        Persona encontrada = tabla.buscar(id);
        if (encontrada != null) {
            System.out.println("Persona encontrada: " + encontrada);
        } else {
            System.out.println("Persona con ID " + id + " no encontrada.");
        }
    }

    /**
     * Muestra todas las personas almacenadas en la tabla hash.
     */
    public void mostrarPersonas() {
        tabla.mostrarTabla();
    }

    /**
     * Muestra la cantidad de personas almacenadas en la tabla hash.
     */
    public void mostrarCantidadPersonas() {
        System.out.println("Número de personas en la tabla hash: " + tabla.obtenerCantidadElementos());
    }
}
