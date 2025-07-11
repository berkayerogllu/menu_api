# Java 17'nin hafif bir sürümü
FROM openjdk:17-jdk-slim

# Çalışma dizini
WORKDIR /app

# Projenin derlenmiş jar dosyasını kopyala
COPY target/appmenu-0.0.1-SNAPSHOT.jar appmenu.jar

# Spring Boot default portu aç
EXPOSE 8080

# Uygulamayı başlat
ENTRYPOINT ["java", "-jar", "appmenu.jar"]

