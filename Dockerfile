FROM openjdk:17.0-oracle
ADD target/keycloak-with-kong-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]