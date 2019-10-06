###################
# Websphere Liberty - funkar inte med ear-applikationen
###################

# FROM open-liberty:javaee8
# COPY ear/target/multicontext.ear /config/dropins/
# COPY dockerfiles/server.xml /config/
# EXPOSE 9080



#########
# Wildfly
#########

FROM jboss/wildfly
ADD ear/target/multicontext.ear /opt/jboss/wildfly/standalone/deployments/
EXPOSE 8080



#######
# TOMEE - funkar inte med ear-applikationen
#######

# FROM tomee:8-jre-7.1.0-plus
# ADD ear/target/multicontext.ear /usr/local/tomee/webapps/
# EXPOSE 8080
