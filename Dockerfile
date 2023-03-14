FROM maven:3.9.0-eclipse-temurin-17-alpine AS MAVEN_BUILD
COPY ./ ./
RUN mvn clean package

FROM eclipse-temurin:17-alpine
ARG DEFAULT_SPRING_PROFILE=test
ENV ENV_SPRING_PROFILE=$DEFAULT_SPRING_PROFILE
COPY --from=MAVEN_BUILD ./target/*.jar /demo.jar
CMD ["java", "-Dspring.profiles.active=$ENV_SPRING_PROFILE", "-jar", "/demo.jar"]