FROM openjdk:17-jdk-alpine
VOLUME /tmp
COPY target/order-service-1.0-SNAPSHOT.jar order-service.jar
ENTRYPOINT ["java","-jar","/order-service.jar"]
