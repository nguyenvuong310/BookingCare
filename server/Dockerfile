FROM openjdk:23-jdk-slim
#VOLUME /tmp
#ARG JAR_FILE = target/*.jar
COPY target/bookingCare-0.0.1-SNAPSHOT.jar bookingCare-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/bookingCare-0.0.1-SNAPSHOT.jar"]