# 1. Usa uma imagem válida (Maven 3.9 com JDK 21 em Alpine Linux)
FROM maven:3.9.6-eclipse-temurin-21-alpine

# 2. Define o diretório de trabalho (sem os dois pontos, hein!)
WORKDIR /app

# 3. Copia o arquivo de configuração e os scripts do Maven Wrapper
COPY pom.xml ./
COPY mvnw* ./
COPY .mvn/ .mvn/

# 4. Dá permissão de execução pro script do Maven
RUN chmod +x mvnw

# 5. Baixa as dependências (camada de cache: só roda de novo se o pom.xml mudar)
RUN ./mvnw dependency:go-offline

# 6. Copia o código fonte para dentro do container
COPY src ./src

# Porta padrão do Spring Boot
EXPOSE 8080

# Comando para subir a aplicação
CMD ["./mvnw", "spring-boot:run"]
