FROM tomcat:8.5.37-jre8
COPY ./angular/newsui/dist/newsui/. /usr/local/tomcat/webapps/newsui
COPY ./service/target/news-service.war /usr/local/tomcat/webapps
