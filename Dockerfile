FROM openjdk:17
EXPOSE 8084
ADD target/admin-service-0.0.1-SNAPSHOT.jar admin-service.jar
ENTRYPOINT ["java","-jar","/admin-service.jar"]