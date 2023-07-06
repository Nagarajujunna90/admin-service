FROM openjdk:8.0
EXPOSE 8081
ADD target/admin-service-0.0.1-SNAPSHOT.jar admin-service
ENTRYPOINT ["java","-jar","admin-service"]