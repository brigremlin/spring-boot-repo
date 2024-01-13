FROM eclipse-temurin:17-jdk-jammy

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY target/capstone-backend-0.0.1-SNAPSHOT.jar capstone-jar

EXPOSE 8080

CMD ["java", "-jar", "/capstone.jar"]
