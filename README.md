# ¡Presiona el botón!

En este repositorio se trabaja el código en Android Studio usando Java para desarrollar un juego, ¡presionar el botón en el color adecuado!, en dónde el botón se mueve constantemente hasta que se oprime en el color elegido.

![Imagen de WhatsApp 2025-06-17 a las 12 04 06_ed3e8f04](https://github.com/user-attachments/assets/424cfc98-defd-4892-88e9-41dfa996b53e)


## Elementos (Código en XML)

Aquí se crean los elemento de la interfaz de usuario y se aplican sus respectivos atributos, en este caso es necesario un TextView, un contenedor de texto y un botón.

![image](https://github.com/user-attachments/assets/780d8221-080f-4547-94e2-de818aaae2a3)

Este es nuestro botón inicial, llamado "buttonGame", el cual de atributos tiene: 
- Texto: "Presioname"
- Tamaño de la fuente: 20
- Altura y ancho: Ajustarse al contenido.
- Ubicación: centro.

Ya que el color cambia constatemente no lo definimos aquí.

![image](https://github.com/user-attachments/assets/12f523f9-6263-468c-bdf9-b8e350d712f3)

Aquí se mostrará el color que se desea buscar. Se llama "textViewColor" Sus atributos son:
- Texto: "" (No posee texto)
- Tamaño de la fuente: 30
- Altura y ancho: Ajustarse al contenido.
- Estilo de la fuente: Negrita.
- Ubicación: cnetrado hacía arriba.
- Margen: 50dp desde arriba.

## Resources (Código en XML)

Sí necesitas acceder constantemente a un atributo que no varía, lo mejor es establecerlos en resources, para acceder fácilmente a ellos. En este caso los colores los definimos allí.

Se implementan en el bloque "Resources" con la estructura de <color name="Nombre del color"(>) #(Código HEX del color) </color>

![image](https://github.com/user-attachments/assets/f490d34b-89b8-438f-976c-5b73c7dc0b86)

## Lógica del juego (Java)

### - Importación de librerias:

Librerias de android. Varias vienen por defecto, pero vamos a necesitar "Toast", para mostrar los mensajes y "Handler" para manejar tareas.

![image](https://github.com/user-attachments/assets/9cef8f4f-5a40-45b8-8779-82e60a7e8ec9)

Librerias de la clase. Son clases que permiten la comunicación entre la lógica y la interfaz de usuario.

![image](https://github.com/user-attachments/assets/d87902a0-f26b-4c19-bf9b-dbd882918dc7)

Librerias de Java. Librerias que nos ofrecen funciones requeridas en la aplicación. Map para crear un diccionario, en este caso, uno de tipo HashMap. List, para crear listas, en este caso una ArrayList. Random, para que nos dé un número aleatorio.

![image](https://github.com/user-attachments/assets/c21f2119-a040-4b4b-838f-8f42c3eeb996)







