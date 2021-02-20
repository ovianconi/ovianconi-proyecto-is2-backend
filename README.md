INSTALACION

Pre-requisitos del proyecto.
En postgreSQL, crear una BD llamada is2 con el propietario postgres y contraseña postgres.

En Eclipse, selecionar la opción de Importar -> Proyecto Maven Existente
Con el plugin de Spring instalado, en el menú del proyecto ir a Run As -> Spring Boot App
 - Si la opción Spring Boot App no se muestra
   En cambio ir a la opción de Run As -> Maven Build...
   Luego en la sección Goals colocar spring-boot:run y darle al botón Run
Luego acceder a través de:

http://localhost:8080/


