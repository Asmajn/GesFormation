FROM maven:3.8.1-jdk-8
ADD target/GesF-1.0.jar GesF-1.0.jar
ENTRYPOINT ["java","-jar","/GesF-1.0.jar"]
EXPOSE 8081