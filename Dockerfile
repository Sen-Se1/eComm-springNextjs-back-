FROM maven:3.9.8-amazoncorretto-21-al2023 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk-slim
COPY --from=build /target/E-Commerce-0.0.1-SNAPSHOT.jar E-Commerce.jar
EXPOSE 5000
ENTRYPOINT [ "java","-jar","E-Commerce.jar" ]