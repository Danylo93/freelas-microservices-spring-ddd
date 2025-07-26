# Usar imagem base com Java 21
FROM eclipse-temurin:21-jdk as builder

# Diretório de trabalho dentro do container
WORKDIR /app

# Copiar arquivos do projeto
COPY . .

# Fazer o build do projeto com Maven (instalado na imagem base)
RUN ./mvnw clean package -DskipTests

# Imagem final minimalista
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copiar apenas o JAR gerado
COPY --from=builder /app/target/*.jar app.jar

# Expor a porta padrão
EXPOSE 8081

# Comando para rodar o app
ENTRYPOINT ["java", "-jar", "app.jar"]
