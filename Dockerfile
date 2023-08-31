FROM adoptopenjdk/openjdk11:jre-11.0.6_10-alpine

# Argumentos (Sobreescribir al hacer build)

# Spring Security Args
ARG SS_USER=admin
ARG SS_PASS=password

# Base de Datos Args
ARG DB_HOST=localhost
ARG DB_PORT=1433
ARG DB_NAME=config_server
ARG DB_USER=sa
ARG DB_PASS=MyPass@word

# Encriptacion Args
ARG CS_ENCRYPT_KEY=5c0744940b5c369b
ARG CS_ENCRYPT_PASS=password

#  Setteo de Variables de Entorno
ENV SS_USER=${SS_USER}
ENV SS_PASS=${SS_PASS}
ENV DB_HOST=${DB_HOST}
ENV DB_PORT=${DB_PORT}
ENV DB_NAME=${DB_NAME}
ENV DB_USER=${DB_USER}
ENV DB_PASS=${DB_PASS}
ENV CS_ENCRYPT_KEY=${CS_ENCRYPT_KEY}
ENV CS_ENCRYPT_PASS=${CS_ENCRYPT_PASS}

COPY target/*.jar app.jar
CMD  java -jar /app.jar