FROM tomcat:9.0.27-jdk8-adoptopenjdk-openj9

COPY web/target/web-1.0-SNAPSHOT.war ${CATALINA_HOME}/deploy/web.war
COPY dockerfiles/server.xml ${CATALINA_HOME}/conf

# debug-inställningar
ENV JPDA_ADDRESS=8000
ENV JPDA_TRANSPORT=dt_socket

EXPOSE 8000 8080

CMD [ "catalina.sh", "jpda", "run" ]
