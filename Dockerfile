FROM frolvlad/alpine-oraclejdk8:slim
EXPOSE 8080
ADD /target/happyfamily-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]