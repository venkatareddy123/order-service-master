FROM openjdk:8
EXPOSE 8787
ADD target/order-service-0.0.1-SNAPSHOT-exec.jar order-service-0.0.1-SNAPSHOT-exec.jar
ENTRYPOINT ["java","-jar","/order-service-0.0.1-SNAPSHOT-exec.jar"]