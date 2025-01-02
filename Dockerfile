FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY build/libs/practice-cicd-0.0.1-SNAPSHOT.jar /app/practice-cicd.jar
CMD ["java", "-Duser.timezone=Asia/Seoul", "-jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "practice-cicd.jar"]