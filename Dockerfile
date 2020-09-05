FROM tomcat:9.0.27-jdk8-adoptopenjdk-openj9

RUN rm -rf ${CATALINA_HOME}/webapps/*
COPY web/target/web-1.0-SNAPSHOT.war ${CATALINA_HOME}/webapps/ROOT.war
COPY web2/target/web2-1.0-SNAPSHOT.war ${CATALINA_HOME}/webapps/web2.war
COPY dockerfiles/server.xml ${CATALINA_HOME}/conf

EXPOSE 8080
