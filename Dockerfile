FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=app_builder /build/target/ecommerce.jar app.jar

ENV SPRING_PROFILES_ACTIVE=docker
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
