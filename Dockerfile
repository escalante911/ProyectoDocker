# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
FROM maven:3.6.3-jdk-8-slim AS compilador
WORKDIR /ProyectoDocker
COPY pom.xml .
RUN mvn -e -B dependency:resolve
COPY src ./src
RUN mvn -e -B package
######
FROM tomcat:10.0.2-jdk15-openjdk-oraclelinux7
#COPY --from=compilador /src/main/java /usr/local/tomcat/ProyectoDocker/pr.war
#COPY holamundo2.war /usr/local/tomcat/webapps
EXPOSE 3306
CMD ["catalina.sh", "run"]