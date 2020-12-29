# Get base image
FROM frolvlad/alpine-java
EXPOSE 8080
ADD /target/visenzeviclim-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]