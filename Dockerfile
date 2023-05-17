# Utiliza una imagen base con Java y Maven instalados
FROM maven:3.8.3-openjdk-11-slim AS build

# Establece el directorio de trabajo en el directorio del proyecto
WORKDIR /app

# Copia el archivo pom.xml al directorio de trabajo
COPY pom.xml .

# Descarga las dependencias del proyecto
RUN mvn dependency:go-offline

# Copia los archivos del proyecto al directorio de trabajo
COPY src ./src

# Compila el proyecto
RUN mvn package -DskipTests

# Etapa final: crea una imagen ligera con el archivo JAR compilado
FROM openjdk:11-slim
WORKDIR /app
COPY --from=build /app/target/*.jar notification.jar

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "notification.jar"]