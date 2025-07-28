# Usar imagem base com Java 21
FROM eclipse-temurin:21-jdk as builder

# Instalar Maven
RUN apt-get update && apt-get install -y maven

WORKDIR /app

# Copiar arquivos do projeto
COPY . .

# Fazer o build do projeto com Maven
RUN mvn clean package -DskipTests


# Imagem final minimalista
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copiar apenas o JAR gerado
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]