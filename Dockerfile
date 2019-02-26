FROM openjdk:11-jdk-alpine

ARG USER=pilger-suite
ARG GROUP=pilger-suite
ARG UID=1000
ARG GID=1000

EXPOSE 8085

# Process is run with user ${USER}, uid = ${UID}
# If you bind mount a volume from the host or a data container, ensure you use the same uid
RUN addgroup -g ${GID} ${GROUP} \
  && adduser -u ${UID} -G ${GROUP} -s /bin/sh -D ${USER}


USER ${USER}

ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.awt.headless=true","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]




