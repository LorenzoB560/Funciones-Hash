package estructura;

import java.util.LinkedList;
import modelo.Persona;

/**
 * Implementación de una Tabla Hash básica con manejo de colisiones mediante listas enlazadas.
 */
public class TablaHash {
    private static final int TAMANIO = 10;
    private LinkedList<Persona>[] tabla;

    @SuppressWarnings("unchecked")
    public TablaHash() {
        tabla = new LinkedList[TAMANIO];
        for (int i = 0; i < TAMANIO; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    /**
     * Función de hash para determinar la posición en la tabla.
     */
    private int funcionHash(int clave) {
        return clave % TAMANIO;
    }

    /**
     * Agrega una persona a la tabla hash.
     */
    public void insertar(Persona persona) {
        int indice = funcionHash(persona.getId());
        tabla[indice].add(persona);
    }

    /**
     * Busca una persona por ID en la tabla hash.
     */
    public Persona buscar(int id) {
        int indice = funcionHash(id);
        for (Persona p : tabla[indice]) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    /**
     * Elimina una persona de la tabla hash por ID.
     */
    public boolean eliminar(int id) {
        int indice = funcionHash(id);
        return tabla[indice].removeIf(p -> p.getId() == id);
    }

    /**
     * Muestra la tabla hash.
     */
    public void mostrarTabla() {
        for (int i = 0; i < TAMANIO; i++) {
            System.out.println("Índice " + i + ": " + tabla[i]);
        }
    }
}