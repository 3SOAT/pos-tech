FROM maven:3-openjdk-17-slim AS builder
#setting up our base image

WORKDIR /build
#setting up our base path

COPY . . 
#coping files from host to container

RUN mvn -DskipTests=true clean install
#packing application in target path

EXPOSE 8080
#enabling access

COPY --from=builder /build/target/*.jar /app/app/application.jar
#coping built app to container path

CMD ["java -jar /app/app/application -Dspring.profiles.active=local"]
#initializing app inside container 
