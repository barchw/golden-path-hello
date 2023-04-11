FROM maven as build
WORKDIR /workspace/app

COPY srv srv
COPY pom.xml .
RUN mvn -f pom.xml clean package

FROM eclipse-temurin:20-jre-alpine
COPY --from=build /workspace/app/srv/target/*-exec.jar /app.jar
RUN addgroup -S appgroup && adduser -S 1234 -G appgroup
USER 1234
ENTRYPOINT ["java", "-jar", "/app.jar"]