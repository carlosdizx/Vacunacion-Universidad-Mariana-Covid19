# Vacunacion-Universidad-Mariana-Covid19
Protecto para la materia de arquitectura de desarrollo de software, esto es el backend de la aplicación

#Requisitos/Recomendaciones para poder ejecutar la aplicacion:
1. PostgreSQL (se utiliza la v.13, recomendable usar la v.9 en adelante)
2. Java OpenJDK 11
3. Eclipse (con el plugin de Spring), Intellij o spring tool suite

#Pasos para ejecucion correcta
1. Crear una base de datos en PostgreSQL llamada 'umarianaTraza', se puede cambiar el nombre pero tambien se debera cambiar en el archivo application.properties en la primera linea por el nombre de la base de datos que se desee.
2. Cambiar el modo de arranque de hibernate (cambiar 'update' por 'create-drop')
3. Correr la aplicacion
4. Posteriormente se debe volver a cambiar en el archivo properties el valor de arranque de hibernate (cambiar 'create-drop' por 'update') esto para aligerar la aplicacion.
