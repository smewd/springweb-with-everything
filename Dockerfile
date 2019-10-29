FROM tomcat:9.0.27-jdk8-adoptopenjdk-openj9

COPY web1/target/web1-1.0-SNAPSHOT.war ${CATALINA_HOME}/deploy/web1.war
COPY dockerfiles/server.xml ${CATALINA_HOME}/conf

EXPOSE 8080