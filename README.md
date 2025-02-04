# Proyecto: Implementación de Tabla Hash en Java

## Descripción

Este proyecto implementa una estructura de datos de **Tabla Hash** en Java, utilizando **listas enlazadas** para manejar colisiones. La implementación incluye operaciones fundamentales como inserción, búsqueda, eliminación y redimensionamiento dinámico.

El programa permite almacenar objetos de tipo `Persona`, los cuales tienen atributos como `id`, `nombre` y `edad`. Se utiliza una función hash con un número primo para optimizar la distribución de los datos y mejorar el rendimiento de las búsquedas.

## Funcionamiento

1. **Inserción de datos**: Cada persona se almacena en la tabla hash utilizando su `id` como clave. Si el índice ya está ocupado, se maneja la colisión mediante listas enlazadas.
2. **Búsqueda**: Se puede buscar una persona por su `id`, verificando la lista enlazada correspondiente al índice hash calculado.
3. **Eliminación**: Se puede eliminar una persona mediante su `id`, eliminándola de la lista enlazada si existe.
4. **Redimensionamiento**: Si el factor de carga supera el 75%, la tabla se duplica y todos los elementos se reinsertan en la nueva estructura.
5. **Visualización**: Se puede imprimir el contenido de la tabla hash con las personas almacenadas en cada índice.

## Estructura del Proyecto

```
ProyectoFuncionesHash/
│── src/
│   ├── modelo/
│   │   ├── Persona.java
│   ├── estructura/
│   │   ├── TablaHash.java
│   ├── principal/
│   │   ├── GestorPersonas.java
│   │   ├── Principal.java
│── .gitignore
│── Funciones Hash.iml
│── Funciones Hash.jar
│── LICENSE
│── README.md
```

### Clases Principales

- **Persona**: Representa a una persona con `id`, `nombre` y `edad`.
- **TablaHash**: Implementa la estructura de datos hash con inserción, búsqueda, eliminación y redimensionamiento.
- **GestorPersonas**: Gestiona la interacción con la tabla hash y ofrece una interfaz más amigable para el usuario.
- **Principal**: Punto de entrada del programa, donde se ejecutan pruebas con la tabla hash.

## Requisitos

- **JDK 21**
- **IntelliJ IDEA**

## Instalación y Ejecución

1. Clonar el repositorio:
   ```sh
   git clone https://github.com/tu-usuario/ProyectoFuncionesHash.git
   ```
2. Ingresar al directorio del proyecto:
   ```sh
   cd ProyectoFuncionesHash
   ```
3. Abrir IntelliJ IDEA y cargar el proyecto.
4. Asegurar que la versión de JDK configurada en IntelliJ es **JDK 21**.
5. Compilar y ejecutar la clase `Principal.java` desde IntelliJ.

## Uso

La aplicación permite:

- Agregar personas a la tabla hash.
- Buscar personas por su `id`.
- Eliminar personas de la tabla hash.
- Mostrar el contenido de la tabla.
- Verificar si la tabla está vacía.
- Observar el redimensionamiento automático cuando el factor de carga es alto.

## Ejemplo de Salida

```
Contenido de la tabla hash:
Índice 0: [Persona{ID=12, Nombre='Ana', Edad=30}]
Índice 1: []
Índice 2: [Persona{ID=23, Nombre='Luis', Edad=40}]
...
Persona encontrada: Persona{ID=12, Nombre='Ana', Edad=30}
Persona con ID 1 eliminada correctamente.
```

## Autor

- **Lorenzo Carlos Boda Székely** - Desarrollador

## Licencia

Este proyecto está bajo la licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.