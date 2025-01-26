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


        // Mostrando la tabla hash
        System.out.println("Contenido de la tabla hash:");
        gestor.mostrarPersonas();

        // Buscando una persona
        gestor.buscarPersona(12);

        // Eliminando una persona
        gestor.eliminarPersona(1);

        // Mostrando la tabla después de eliminación
        System.out.println("Tabla hash después de eliminar:");
        gestor.mostrarPersonas();

        // Buscar un ID que no existe
        gestor.buscarPersona(100);

        // Insertar varias personas para probar el redimensionamiento
        for (int i = 200; i < 220; i++) {
            gestor.agregarPersona(i, "Persona" + i, 20 + (i % 10));
        }
        gestor.mostrarPersonas();
    }
}
