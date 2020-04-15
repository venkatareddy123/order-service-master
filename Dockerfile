FROM openjdk:8
EXPOSE 8080
ADD target/order-service-0.0.1-SNAPSHOT-exec.jar order-service-0.0.1-SNAPSHOT-exec.jar
ENTRYPOINT ["java","-jar","/order-service-0.0.1-SNAPSHOT-exec.jar"]