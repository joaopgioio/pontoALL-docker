FROM openjdk:17-jdk-alpine

#FROM alpine

WORKDIR /app

#RUN apk add openjdk17
COPY target/pontoallv0-0.0.1-SNAPSHOT.jar /app/pontoallv0.jar
EXPOSE 8082
#ENTRYPOINT ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "/app/pontoallv0-0.0.1-SNAPSHOT.jar", "-web -webAllowOthers -tcp -tcpAllowOthers -browser"]
ENTRYPOINT ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "/app/pontoallv0.jar", "-web -webAllowOthers -tcp -tcpAllowOthers -browser"]