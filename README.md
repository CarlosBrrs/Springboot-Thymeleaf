# Springboot-Thymeleaf

Para hacer deploy del jar

1. Verificar que se tenga el JAVA_HOME en las variables de entorno
2. Ejecutar el comando .\mvnw.cmd package desde el CMD como administrador para empaquetar el proyecto en un .jar
3. Ejecutar el comando java -jar .\<la dirección donde se encuentra el archivo jar> siempre con backslashs
