FROM tomcat:8.5.16-jre8-alpine
COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY target/JavaPoolTask1.war /usr/local/tomcat/webapps/myapp.war

#CMD ["catalina.sh","run"]
#docker build -t testrest .
#docker run --rm --name tomcattest -p 8080:8080 testrest