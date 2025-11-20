package com.beautysalon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDateTime;

@SpringBootApplication
public class BeautySalonApplication {

    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("🚀 ЗАПУСК BEAUTY SALON APPLICATION");
        System.out.println("⏰ Время запуска: " + LocalDateTime.now());
        System.out.println("=".repeat(60));

        SpringApplication.run(BeautySalonApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("✅ BEAUTY SALON УСПЕШНО ЗАПУЩЕН!");
        System.out.println("=".repeat(60));
        System.out.println("🌐 Главная страница: http://localhost:8080");
        System.out.println("💅 Страница услуг: http://localhost:8080/services");
        System.out.println("👩‍💼 Наши мастера: http://localhost:8080/masters");
        System.out.println("📅 Онлайн запись: http://localhost:8080/appointments/book");
        System.out.println("🔐 Панель входа: http://localhost:8080/auth/login");
        System.out.println("🗄️  H2 Database: http://localhost:8080/h2-console");
        System.out.println("📊 База данных: jdbc:h2:mem:beautysalon");
        System.out.println("👤 Пользователь: sa / (пустой пароль)");
        System.out.println("=".repeat(60));
        System.out.println("💡 Демо пользователи:");
        System.out.println("   📧 olga@test.ru / 🔑 password123");
        System.out.println("   📧 dmitry@test.ru / 🔑 password123");
        System.out.println("=".repeat(60));
        System.out.println("🛠️  Технологический стек:");
        System.out.println("   • Spring Boot 3.5.8");
        System.out.println("   • Java 21");
        System.out.println("   • Spring Data JPA");
        System.out.println("   • Spring Security");
        System.out.println("   • Thymeleaf");
        System.out.println("   • H2 Database");
        System.out.println("   • Lombok");
        System.out.println("   • Maven");
        System.out.println("=".repeat(60));
        System.out.println("🎓 Курсовая работа: Сайт салона красоты");
        System.out.println("👨‍💻 Автор: [Твое имя]");
        System.out.println("📅 " + LocalDateTime.now().getYear() + " год");
        System.out.println("=".repeat(60) + "\n");
    }
}