# Sistema de gestión de un refugio de animales

**Autor:** Cristhian Martinez Vargas

## Descripción

Programa de consola en Java que permite a un refugio registrar perros y gatos, consultar los animales almacenados y gestionar su adopción. Aplica los conceptos de Programación Orientada a Objetos: clases, encapsulamiento, herencia, polimorfismo, colecciones y manejo básico de errores.

## Clases

| Clase | Responsabilidad |
|---|---|
| `Animal` | Clase padre con los datos comunes: id, nombre, edad y estado (inicia como DISPONIBLE). |
| `Perro` | Hereda de `Animal`. Agrega la raza y sobrescribe `mostrarInformacion()` y `realizarAccion()`. |
| `Gato` | Hereda de `Animal`. Agrega el color y sobrescribe `mostrarInformacion()` y `realizarAccion()`. |
| `Refugio` | Administra un `ArrayList<Animal>`: registra, busca, muestra y adopta. |
| `Main` | Maneja el `Scanner`, el menú y la creación de objetos. |

## Funcionalidades

1. **Registrar animal:** elige perro o gato y valida los datos (ID positivo y único, nombre no vacío, edad mayor o igual a 0).
2. **Mostrar animales:** lista todos los animales con sus datos, estado y la acción propia de cada uno (polimorfismo).
3. **Buscar animal por ID:** búsqueda secuencial; si no existe muestra "Animal no encontrado".
4. **Adoptar animal:** cambia el estado de DISPONIBLE a ADOPTADO y no permite adoptar dos veces.
5. **Salir:** termina el programa de forma controlada.

El menú se repite hasta elegir la opción 5. Las entradas no numéricas se controlan con `try-catch` y el programa continúa.

## Cómo compilar y ejecutar

Requiere tener instalado el JDK (versión 17 o superior). Desde la carpeta del proyecto:

```bash
javac *.java
java Main
```