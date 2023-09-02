FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp

COPY target/demo-0.0.1-SNAPSHOT-exec.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
expose 8083