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

Ya que el color cambia constantemente no lo definimos aquí.

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

### Variables iniciales.

Se crea la clase.

![image](https://github.com/user-attachments/assets/94147215-e13e-4b7b-88e6-9f7ce093b895)

Se crea un Binding el cual nos va a a permitir comunicarnos con la interfaz de usuario.

![image](https://github.com/user-attachments/assets/4cecdddc-0ea7-4f9e-b8ae-d78b8b10e434)

Se crean variables del juego, privadas para que únicamente la lógica las edite. Son: El color a buscar, el color actual y un booleano sí el botón fue presionado correctamente o no.

![image](https://github.com/user-attachments/assets/92c7c010-b30a-4dbe-a9de-7eee26c8ab85)

Se crea el objeto handler, el cual sirve para administrar tareas con ciclos, nos va a ser útil para manejar el ciclo.

![image](https://github.com/user-attachments/assets/2a2fb983-dcae-480e-a157-2e763e20423d)

Se crea un mapa, con key de tipo Integer y value de tipo String. Este almacena los cólores en código Hexadécimal y su respectivo nombre.

![image](https://github.com/user-attachments/assets/2d9a0657-7b47-42ca-ba4b-7ff056602e47)

La vista es creada, no necesita modificacioes, solo añadir el binding.

![image](https://github.com/user-attachments/assets/384be95f-cd46-4f40-883d-bbfd2302e615)

Se inicializa la vista, allí se ejecutan las funciones.

![image](https://github.com/user-attachments/assets/2f93d7de-00b1-4b49-841e-8e50557f731e)

Se colocan las keys y valores del mapa. Se usa put y se separan con ",". Para obtener el código en Hex se usa R.ID el cual permite acceder a los valores según el ID del color.

![image](https://github.com/user-attachments/assets/e795244d-6eda-4eb1-bf97-47cf223ef4da)

Se llaman a las funciones del código, chagingButton y Select Color.

![image](https://github.com/user-attachments/assets/130db4a1-a20c-4f47-9641-80153fbdc8a7)

## Changing Button.

Es la función que cambia los atributos del botón, para ello se usa un runnable, el cuál ejecuta un ciclo, que es manejado por el Handler. Posteriormente se usa un if que comprueba sí el botón fue presionado en el color incorrecto, sí es true:

![image](https://github.com/user-attachments/assets/41cc158e-b526-4b0b-bd1d-e30a899dc0e4)

**COLOR**

- Se crea una lista con las keys del map, es decir, una lista con los códigos HEX.
- Se crea una variable random que va desde 0 al tamaño de la lista.
- Según el color que da el random, se accede a ese índice y se guarda ese código en una variable.
- Usando Binding, se establece el color del fondo con el código HEX que se guardó en la Variable.

![image](https://github.com/user-attachments/assets/313577e6-2024-4d4a-881d-5d35d0b220c5)


**POSICION**

- Con Binding se obtienen los límites de la vista, es decir, el tamaño que ocupa la pantalla, en el eje x y en el el eje y. Se le resta la altura y la anchura del botón para que no se escape.
- Según ese tamaño, se crea un random que escoge valores entre el límite máximo y el mínimo.
- Usando animate, se dice a que posición se mueve, en cuanto tiempo y se inicia.

![image](https://github.com/user-attachments/assets/85753d8c-bff8-42b7-8e17-f85d3d67fb98)

Una vez hecho eso, el handler se repite cada 750ms, cuando sea falso, es decir, cuando se presionó el botón correctamente, no entra al if y no se vuelve a repetir.

![image](https://github.com/user-attachments/assets/1ab783a6-4114-48bf-a2b1-52fe0a7c263a)

## Select Color

Aquí se le ínidca al usuario que color debe presionar. Para ello.

- Se crea una lista con las keys del map, es decir, una lista con los códigos HEX.
- Se crea una variable random que va desde 0 al tamaño de la lista.
- Se accede a la lista en ese índice y se guarda en una variable.
- Se accede al mapa y se busca el valor de dicha key, y se concatena en un String
- Se define el color a buscar.
- Se establece el texto del textview con el String.

![image](https://github.com/user-attachments/assets/b0e6f12c-38ee-4160-b004-abab980b2739)

## Volviendo a OnCreatedView

Después de inicializar las dos funciones, con binding, se crea un listener que se activa cuando el botón es presionado, y verifica con un if, sí el color actual concuerda con el color a buscar. Sí es así, devuelve un toast que informa que se presionó correctamente y se detiene cambiando la variable booleana a False. Sí no es así, se informa al usuario que el color es incorrecto y el ciclo sigue.

![image](https://github.com/user-attachments/assets/9b12351c-6023-4902-b692-1e144c2ff54e)


