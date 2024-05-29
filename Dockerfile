FROM tomcat:10.1.24-jdk21-temurin-jammy



COPY /target/employeeManagementSystem.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]






