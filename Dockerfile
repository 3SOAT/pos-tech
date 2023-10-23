FROM maven:3.6.3-openjdk-17 AS build

WORKDIR usr/src/app

COPY . ./

RUN mvn clean package -DskipTests=true

FROM openjdk:17-slim

ARG JAR_NAME="application"

WORKDIR /usr/src/app

EXPOSE 8080

COPY --from=build /usr/src/app/target/${JAR_NAME}.jar ./app.jar

CMD ["java","-jar", "./app.jar"]
