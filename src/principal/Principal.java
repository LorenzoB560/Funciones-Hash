package principal;

/**
 * Clase principal para probar la Tabla Hash con gestión de personas.
 */
public class Principal {
    public static void main(String[] args) {
        GestorPersonas gestor = new GestorPersonas();

        // Insertando personas en la tabla hash
        gestor.agregarPersona(1, "Juan", 25);
        gestor.agregarPersona(12, "Ana", 30);
        gestor.agregarPersona(23, "Luis", 40);
        gestor.agregarPersona(34, "Marta", 35);
        gestor.agregarPersona(45, "Carlos", 28);

        // Mostrando la tabla hash
        System.out.println("Contenido de la tabla hash:");
        gestor.mostrarPersonas();

        // Buscando una persona
        gestor.buscarPersona(12);

        // Eliminando una persona
        gestor.eliminarPersona(23);

        // Mostrando la tabla después de eliminación
        System.out.println("Tabla hash después de eliminar:");
        gestor.mostrarPersonas();
    }
}
