FROM eclipse-temurin:17-jdk-alpine as builder
WORKDIR /opt/app
COPY .mvn/ .mvn
COPY mvnw pom.xml
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline
COPY ./src ./src
RUN ./mvnw clean install

FROM eclipse-temurin:17-jre-alpine
WORKDIR /opt/app
COPY --from=builder /opt/app/target/*.jar /opt/app/*.jar

EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]

#ARG JAR_FILE=target/FinMangerFrontEnd-0.0.1-SNAPSHOT.jar
#COPY ${JAR_FILE} app.jar
