FROM openjdk:8
WORKDIR /app
EXPOSE 8084
COPY target/hebergement-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "hebergement-0.0.1-SNAPSHOT.jar"]