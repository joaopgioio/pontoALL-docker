FROM openjdk:17-jdk-alpine

#FROM alpine
ARG H2_TCP_PORT_ARG='9092'
ARG H2_WEB_PORT_ARG='8082'

ENV H2_TCP_PORT=${H2_TCP_PORT_ARG} \
    H2_WEB_PORT=${H2_WEB_PORT_ARG}

WORKDIR /app

#RUN apk add openjdk17
COPY target/pontoallv0-0.0.1-SNAPSHOT.jar /app/pontoallv0.jar
#COPY target/h2-2.1.214.jar /app/h2-2.1.214.jar
EXPOSE 8082 9092
#ENTRYPOINT ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "/app/pontoallv0-0.0.1-SNAPSHOT.jar", "-web -webAllowOthers -tcp -tcpAllowOthers -browser"]
#ENTRYPOINT ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "/app/pontoallv0.jar", "org.h2.tools.Server" , "-web -webAllowOthers -tcp -tcpAllowOthers -tcpPort ${H2_TCP_PORT} -browser"]
#ENTRYPOINT ["java", "-cp", "/app/h2-2.1.214.jar", "org.h2.tools.Server", "-tcp"] && ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "/app/pontoallv0.jar", "-web -webAllowOthers ${H2_WEB_PORT} -tcp -tcpAllowOthers -tcpPort ${H2_TCP_PORT} -browser"]
ENTRYPOINT ["java", "-jar", "-Djava.security.egd=file:/dev/./urandom", "/app/pontoallv0.jar", "-web -webAllowOthers ${H2_WEB_PORT} -tcp -tcpAllowOthers -tcpPort ${H2_TCP_PORT} -browser"]