# RetoBit: RPG a medias 🧝 (Parte 2, ahora es personal 🤭)

Seguimos con el RetoBit del RPG. Ahora ya tenemos completa la clase abstracta de Character, hicimos tan buen trabajo que nuestro equipo nos ha elegido como la voz cantante en este desarrollo. 👑

## ¿Qué practicarás?

- Herencia
- Métodos
- Interpretar diagramas UML
- Detección de errores
- Desarrollar a partir de tests (Test Driven Development)

## Fork del repositorio:

Haz un fork del repo.

Pulsa el botón Fork en github:

![fork](public/img1.png)

Esto creará una copia del repositorio en tu perfil de Github. 

## Clona el repo en tu computadora

Ahora hay que descargarse el proyecto en tu computadora.

### 1. Asegúrate de que estás en la URL de TU copia del repositorio
   

Si la URL es esta: https://github.com/curso-java-marshall-bits/retobit-RPG **NO ES CORRECTO**.
    

Donde aparece 'curso-java-marshall-bits' debería aparecer tu nombre de usuario. Haz click en tu perfil y mira tus repositorios para comprobar si hiciste el fork. En caso contrario vuelve al paso anterior. 


### 2. Pulsa en "code" para ver la URL del repositorio y cópiala

![clone](public/img2.png)

Para ello deberás abrir una terminal y navegar a la carpeta donde quieras añadir este retoBit.

Utiliza el siguiente comando:

```commandline
git clone https://aqui.debes.pegar.la.url
```

**Nota: Después del 'git clone' debes pegar la url del repositorio. No pongas la que he puesto yo en el ejemplo 🤣*

Ahora se va a crear un nuevo directorio con el nombre del retobit.

### 3. ¡Ya puedes abrir este reto en IntelliJ!

# Instrucciones

## Parte 1: Interpretar el diagrama UML actualizado

La Tech Lead nos ha proporcionado el **diagrama UML** actualizado que servirá como nuestra guía principal para este sprint.

Recordarás que en el retoBit anterior se introdujeron las clases Warrior y Mage en el diagrama, pero su implementación se pospuso. En este sprint, nuestra tarea es implementar completamente estas dos clases, incluyendo sus constructores y los métodos especificados en el diagrama, simplemente échale un vistazo:

 ![img.png](public/diagrama.png)

## Parte 2: Crear las clases Mage y Warrior

Como el diagrama está bastante claro, solamente debemos seguirlo al pie de la letra. Crea las dos clases que extiendan de Character, su constructor y los métodos. Puedes empezar con métodos vacíos de momento.

Ejecuta los tests para comprobar si se han declarado correctamente. Hasta que no estén creadas las clases y métodos no compilará correctamente, por tanto, no se podrán ejecutar los tests.

## Parte 3: Implementar la lógica

Deberás basarte en los tests para implementar la lógica de los métodos. 


## Testing

Para comprobar si has realizado bien el ejercicio ejecuta los tests. Cada clase tiene los suyos. Puedes ejecutarlos todos a la vez con el botón derecho en el directorio **src/test/java** seleccionando la opción 'Run tests in Java' o bien individualmente en: 
- **src/test/java/MageTest**
- **src/test/java/WarriorTest**
- **src/test/java/CharacterTest** (éste no debería dar problemas si no modificamos la clase de Character)

El test te indicará si has pasado con un tick verde ✅. En caso contrario verás el error.

Ejemplo:

![img.png](public/img3.png)

Pulsa en cualquiera de los tests que has fallado y mira el mensaje de la derecha.

- *Expected*: es el valor que el test estaba esperando.
- *Actual*: es el valor que tu reto está retornando. 

## Solución

Si quieres ver una posible solución para el retoBit que pasa todos los tests puedes mirar la rama *solution* dentro del repositorio.

![rama solution](public/img4.png)

Ten en cuenta que hay muchas formas de resolver los ejercicios y la tuya puede pasar los tests iguales, pero ser completamente distinta a la solución. No significa que la tuya esté mal. Compara los resultados y decide cuál te gusta más o te parece más legible.

## Entrega

Realiza un commit con los cambios desde la terminal:

1. Añade todos los cambios
````commandline
git add .
````

2. Haz el commit con el mensaje
````commandline
git commit -m "retobit finalizado"
````

3. Haz un push
````commandline
git push origin main
````

Debes realizar una pull request para entregar el ejercicio. Abre el link del repositorio en github y haz click en la pestaña *pull requests*.

Selecciona *New pull request*, *Create pull request* y confírmala. Esto hará que yo pueda verlo y revisarlo en caso de que haya fallado algún test para poder darte feedback.

Mucha suerte con el reto. Te mando un abrazo y ¡Sigamos desarrollando! 🫂

[marshall-bits.dev](http://marshall-bits.dev)

*Nota: Estos retos pertenecen al curso de Marcel Bosch de Java para desarrolladores junior. Cualquier uso fuera de este contexto debe estar autorizado explícitamente. Si quieres usar estos ejercicios ponte en contacto conmigo a través de mis redes sociales (visita mi página para [más información](http://marshall-bits.dev)).* 