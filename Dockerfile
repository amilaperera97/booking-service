FROM openjdk:11
ADD target/*.jar booking-service.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","booking-service.jar"]