#
# Build stage
#
FROM maven:3.8.6-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM eclipse-temurin:18-jdk-jammy
COPY --from=build /home/app/target/bankdemo-0.0.3-SNAPSHOT.war /usr/local/lib/bankdemo-0.0.3-SNAPSHOT.war
EXPOSE 80
ENTRYPOINT ["java","-jar","/usr/local/lib/bankdemo-0.0.3-SNAPSHOT.war"]