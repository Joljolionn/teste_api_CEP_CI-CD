FROM maven:3.9.6-eclipse-temurin-21-alpine

WORKDIR /app

# 1. Copia apenas o pom.xml
COPY pom.xml ./

# 2. Baixa as dependências usando o Maven da imagem (não o wrapper)
RUN mvn dependency:go-offline

# 3. Copia o código fonte
COPY src ./src

EXPOSE 8080

# 4. Sobe a aplicação usando mvn
CMD ["mvn", "spring-boot:run"]
