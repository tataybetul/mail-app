FROM openjdk:8-jdk-alpine

VOLUME /tmp
ADD target/mailapp-0.0.1-SNAPSHOT.jar mailapp-0.0.1-SNAPSHOT.jar
RUN sh -c 'mkdir test'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","mailapp-0.0.1-SNAPSHOT.jar"]