## Recupercion-ud3-hibernate
Un pequeño proyecto de recuperacion de la unidad 3 de programacion de 2ºDAM en el que se utiliza hibernate para la gestion de una base de datos a través de una ORM. 
El proyecto consiste en una pequeña aplicacion parecida a una red social en la que se pueden crear usuarios, grupos y publicaciones. Tambien se pueden hacer unas pequeñas consultas sobre los usuarios, las publicaciones y los grupos.

## Guia Usuario 👥
Al ejecutar el programa se nos mostrara el menu que se muestra a continuacion con las diferentes opciones que podemos realizar.

![01-Menu.png](src/main/resources/img/01-Menu.png)

Para escoger una opcion solo tendremos que introducir el numero de la opcion que queramos realizar y pulsar enter.

Al entrar en cualquiera de los 3 primeros veremos casi el mismo menu, en el que podremos crear, modificar, eliminar o consultar los usuarios, grupos o publicaciones.
salvo en el caso de grupos que tiene un opcion mas que es la de añadir usuarios a un grupo.

![02-Opciones.png](src/main/resources/img/02-Opciones.png)

En el caso de las consultas, se nos mostrara un menu con las diferentes opciones de consulta que podemos realizar.

![03-Consultas.png](src/main/resources/img/03-Consultas.png)

Cada una de las consultas hace respectivamente lo siguiente:
- Consulta 1: Muestra todos los usuarios que han realizado una publicacion.
- Consulta 2: Muestra todas las publicaciones que tienen una cadena en especifico en el contenido.
- Consulta 3: Muestra todos los grupos a los que pertenece un usuario en concreto.

Por último para salir del programa solo tendremos que seleccionar la opcion 5 del menu principal.

`

![04-Salir.png](src/main/resources/img/04-Salir.png)

## Guia Desarrollador 🛠

El proycto inicia en Main pero lo unico que hace este es llamar al metodo accionPrincipal de la clase Menu.

Esta clase Menu es la que se encarga de mostrar el menu principal y de llamar a los metodos de las otras clases para realizar las acciones que el usuario seleccione.
y conectarse con los controladores de las otras clases.

![05-ClaseMenu.png](src/main/resources/img/05-ClaseMenu.png)

El metodo accionPrincipal es el que se encarga de mostrar el menu principal y de mostrar al usuario las opciones de lo que puede hacer. Este metodo se repite hasta que el usuario seleccione la opcion de salir.

La base de datos es generada por hibernate y se declara todos los datos importantes en el paquete entities.

![06-Entities.png](src/main/resources/img/06-Entities.png)

En el paquete dao se encuentran todas las interacciones con la base de datos, entre las clases sus relaciones y las consultas.

![07-Dao.png](src/main/resources/img/07-Dao.png)

Por último en el paquete views se encuentran las clases que se encargan de mostrar los menus y de pedir los datos al usuario.

![08-ClaseView.png](src/main/resources/img/08-ClaseView.png)


## Diagrama de clases 📊

![DiagramaClases.png](src/main/resources/img/DiagramaClases.png)


## Diagrama crowfoot 📊

![crowfoot.png](src/main/resources/img/crowfoot.png)

## Propuesta de mejora y conclusión 📈

En mi opinion el proyecto esta bastante bien, pero se podria mejorar añadiendo mas opciones de consulta y añadiendo mas opciones de modificacion de los datos de los usuarios, grupos y publicaciones.
mas interaccion entre las relaciones y tal vez añadir alguna identidad mas. Tambien existen datos que necesitan pulirse como el
numero de amigos y el numero de miembros de un grupo.
Como conclusión, el proyecto me ha parecido bastante interesante y me ha gustado bastante hacerlo, ya que he refinado de una mejor manera el uso hibernate y me he topado con problemas que antes no había visto como alguno en las consultas.

```java
