# syntax=docker/dockerfile:1
FROM eclipse-temurin:18-jdk-jammy

# Create  unprivileged user to run the release
RUN useradd -ms /bin/bash juan

# run as user
USER juan

WORKDIR /home/juan/app  

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ["/bin/bash", "-c","/home/juan/app/mvnw", "dependency:go-offline"]

COPY src ./src

CMD ["/home/juan/app/mvnw", "spring-boot:run"]