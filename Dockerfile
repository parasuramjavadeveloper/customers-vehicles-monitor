FROM openjdk:8
EXPOSE 8097
ADD target/vehicle-tracker-1.0.jar  vehicle-tracker-1.0.jar
ENTRYPOINT ["java","-jar","/vehicle-tracker-1.0.jar"]