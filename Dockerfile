FROM openjdk:11
ADD target/spring-boot-prototyp1-docker.jar spring-boot-prototyp1-docker1.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-prototyp1-docker1.jar"]