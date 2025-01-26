package estructura;

import java.util.LinkedList;
import modelo.Persona;

/**
 * Implementación de una Tabla Hash básica con manejo de colisiones mediante listas enlazadas.
 * Utiliza un factor de carga para determinar si necesita redimensionarse.
 */
public class TablaHash {
    private static int TAMANIO = 10;

    // Variable para llevar cuenta de los elementos insertados
    private int cantidadElementos = 0;
    private LinkedList<Persona>[] tabla;

    /**
     * Constructor que inicializa la tabla hash con una lista enlazada en cada índice.
     */
    @SuppressWarnings("unchecked")
    public TablaHash() {
        tabla = new LinkedList[TAMANIO];
        for (int i = 0; i < TAMANIO; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    /**
     * Calcula la posición de almacenamiento utilizando una función hash mejorada.
     * Se usa un número primo para mejorar la distribución de los valores.
     *
     * @param clave ID de la persona.
     * @return Índice en la tabla hash donde se almacenará la persona.
     */
    private int funcionHash(int clave) {
        int hash = clave * 31; // Multiplicador primo para mejorar la dispersión
        return Math.abs(hash) % TAMANIO;
    }

    /**
     * Inserta una persona en la tabla hash. Si la tabla alcanza un factor de carga superior al 75%,
     * se redimensiona antes de insertar el nuevo elemento.
     *
     * @param persona Objeto de tipo Persona que se agregará a la tabla.
     */
    public void insertar(Persona persona) {
        if ((double) cantidadElementos / TAMANIO > 0.75) {
            redimensionarTabla();
        }

        int indice = funcionHash(persona.getId());
        tabla[indice].add(persona);
        cantidadElementos++;
    }

    /**
     * Busca una persona en la tabla hash a partir de su ID.
     *
     * @param id Identificador único de la persona.
     * @return El objeto Persona si se encuentra, o null si no está en la tabla.
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
     * Verifica si la tabla hash está vacía.
     *
     * @return true si no hay elementos en la tabla, false en caso contrario.
     */
    public boolean estaVacia() {
        return cantidadElementos == 0;
    }

    /**
     * Elimina una persona de la tabla hash usando su ID.
     *
     * @param id Identificador único de la persona a eliminar.
     * @return true si la persona fue eliminada con éxito, false si no se encontraba en la tabla.
     */
    public boolean eliminar(int id) {
        int indice = funcionHash(id);
        boolean eliminado = tabla[indice].removeIf(p -> p.getId() == id);
        if (eliminado) {
            cantidadElementos--;
        }
        return eliminado;
    }

    /**
     * Obtiene la cantidad de elementos almacenados actualmente en la tabla hash.
     *
     * @return Número de elementos en la tabla.
     */
    public int obtenerCantidadElementos() {
        return cantidadElementos;
    }

    /**
     * Calcula el factor de carga de la tabla hash.
     *
     * @return Factor de carga, definido como cantidad de elementos dividida por el tamaño de la tabla.
     */
    public double obtenerFactorCarga() {
        return (double) cantidadElementos / TAMANIO;
    }

    /**
     * Muestra el contenido de la tabla hash, imprimiendo cada índice y su lista de personas almacenadas.
     */
    public void mostrarTabla() {
        for (int i = 0; i < TAMANIO; i++) {
            System.out.println("Índice " + i + ": " + tabla[i]);
        }
    }

    /**
     * Redimensiona la tabla hash, duplicando su tamaño y reinsertando todos los elementos en la nueva estructura.
     * Este proceso ayuda a mantener la eficiencia de las operaciones de inserción y búsqueda.
     */
    private void redimensionarTabla() {
        LinkedList<Persona>[] nuevaTabla = new LinkedList[TAMANIO * 2];
        for (int i = 0; i < nuevaTabla.length; i++) {
            nuevaTabla[i] = new LinkedList<>();
        }

        for (LinkedList<Persona> lista : tabla) {
            for (Persona persona : lista) {
                int nuevoIndice = persona.getId() % nuevaTabla.length;
                nuevaTabla[nuevoIndice].add(persona);
            }
        }

        tabla = nuevaTabla;
        TAMANIO *= 2;
    }
}
