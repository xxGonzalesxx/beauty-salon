# Используем официальный образ Java
FROM openjdk:21-jdk-slim

# Устанавливаем метаданные
LABEL maintainer="Beauty Salon Team"
LABEL description="Beauty Salon Booking System"

# Создаем пользователя для безопасности (не root)
RUN useradd -m -u 1000 spring
USER spring

# Рабочая директория
WORKDIR /app

# Копируем JAR файл
COPY --chown=spring:spring target/beauty-salon-0.0.1-SNAPSHOT.jar app.jar

# Открываем порт
EXPOSE 8080

# Здоровье приложения (health check)
HEALTHCHECK --interval=30s --timeout=3s --start-period=5s --retries=3 \
  CMD curl -f http://localhost:8080/ || exit 1

# Запускаем приложение с оптимизациями
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "-Djava.security.egd=file:/dev/./urandom", "app.jar"]