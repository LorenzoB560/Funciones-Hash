package estructura;

import java.util.LinkedList;
import modelo.Persona;

/**
 * Implementación de una Tabla Hash básica con manejo de colisiones mediante listas enlazadas.
 */
public class TablaHash {
    private static int TAMANIO = 10;

    // Variable para llevar cuenta de los elementos insertados
    private int cantidadElementos = 0;
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
     * Si la tabla está llena, se redimensiona antes de agregar.
     */
    public void insertar(Persona persona) {
        // Verificamos si la tabla necesita redimensionarse (si la carga es superior al 75%)
        if ((double) cantidadElementos / TAMANIO > 0.75) {
            redimensionarTabla();
        }

        // Insertamos la persona en la posición correspondiente
        int indice = funcionHash(persona.getId());
        tabla[indice].add(persona);
        cantidadElementos++;  // Incrementamos el contador de elementos
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
        boolean eliminado = tabla[indice].removeIf(p -> p.getId() == id);
        if (eliminado) {
            cantidadElementos--;  // Decrementamos el contador de elementos si se eliminó una persona
        }
        return eliminado;
    }

    /**
     * Devuelve la cantidad de elementos almacenados en la tabla hash.
     * @return Número de elementos en la tabla hash.
     */
    public int obtenerCantidadElementos() {
        return cantidadElementos;
    }



    /**
     * Muestra la tabla hash.
     */

    public void mostrarTabla() {
        for (int i = 0; i < TAMANIO; i++) {
            System.out.println("Índice " + i + ": " + tabla[i]);
        }
    }

    /**
     * Redimensiona la tabla hash, duplicando su tamaño y reinsertando todos los elementos.
     */
    private void redimensionarTabla() {
        // Creamos una nueva tabla con el doble de tamaño
        LinkedList<Persona>[] nuevaTabla = new LinkedList[TAMANIO * 2];
        for (int i = 0; i < nuevaTabla.length; i++) {
            nuevaTabla[i] = new LinkedList<>();
        }

        // Reinsertamos todos los elementos en la nueva tabla
        for (LinkedList<Persona> lista : tabla) {
            for (Persona persona : lista) {
                int nuevoIndice = persona.getId() % nuevaTabla.length;
                nuevaTabla[nuevoIndice].add(persona);
            }
        }

        // Actualizamos la tabla original a la nueva tabla
        tabla = nuevaTabla;
        TAMANIO *= 2;  // Actualizamos el tamaño de la tabla
    }
}
