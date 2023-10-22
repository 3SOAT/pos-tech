FROM maven:3.9 AS maven
#setting up our base image

WORKDIR /usr/src/app
#setting up our base path

COPY . /usr/src/app
#coping files from host to container

RUN mvn clean package -DskipTests -q
#RUN mvn package
#packing application in target path
 
FROM openjdk:17-jdk-slim
#from Java 17

ARG JAR_FILE=application.jar
#setting jar file name to be reused

EXPOSE 8080
#enabling access

WORKDIR /opt/app
#setting path to run the app

COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app/
#coping built app to container path

#CMD mvn spring-boot:run
CMD ["java -jar /opt/app/${JAR_FILE}"]
#initializing app inside container 
