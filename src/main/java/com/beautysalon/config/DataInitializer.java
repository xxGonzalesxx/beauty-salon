package com.beautysalon.config;

import com.beautysalon.entity.*;
import com.beautysalon.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final SalonServiceRepository salonServiceRepository;
    private final MasterRepository masterRepository;
    private final ClientRepository clientRepository;
    private final AppointmentRepository appointmentRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Очистка данных
        appointmentRepository.deleteAll();
        masterRepository.deleteAll();
        salonServiceRepository.deleteAll();
        clientRepository.deleteAll();

        // Создание услуг
        SalonService haircutWomen = new SalonService();
        haircutWomen.setName("Стрижка женская");
        haircutWomen.setDescription("Модная стрижка с укладкой");
        haircutWomen.setPrice(new BigDecimal("1500.00"));
        haircutWomen.setDuration(60);
        haircutWomen.setCategory("HAIR");
        salonServiceRepository.save(haircutWomen);

        SalonService haircutMen = new SalonService();
        haircutMen.setName("Мужская стрижка");
        haircutMen.setDescription("Стрижка машинкой и ножницами");
        haircutMen.setPrice(new BigDecimal("800.00"));
        haircutMen.setDuration(30);
        haircutMen.setCategory("HAIR");
        salonServiceRepository.save(haircutMen);

        SalonService coloring = new SalonService();
        coloring.setName("Окрашивание волос");
        coloring.setDescription("Стойкое окрашивание премиум краской");
        coloring.setPrice(new BigDecimal("3000.00"));
        coloring.setDuration(120);
        coloring.setCategory("HAIR");
        salonServiceRepository.save(coloring);

        SalonService manicure = new SalonService();
        manicure.setName("Маникюр");
        manicure.setDescription("Аппаратный маникюр с покрытием");
        manicure.setPrice(new BigDecimal("1200.00"));
        manicure.setDuration(90);
        manicure.setCategory("NAILS");
        salonServiceRepository.save(manicure);

        // Создание мастеров
        Master anna = new Master();
        anna.setFirstName("Анна");
        anna.setLastName("Иванова");
        anna.setSpecialization("Стилист-парикмахер");
        anna.setPhone("+7-999-123-45-67");
        anna.setEmail("anna@salon.ru");
        anna.setPhotoUrl("/images/anna.jpg");
        anna.setDescription("Опыт работы 5 лет. Специализация: окрашивание, сложные стрижки");
        anna.getServices().add(haircutWomen);
        anna.getServices().add(coloring);
        masterRepository.save(anna);

        Master maria = new Master();
        maria.setFirstName("Мария");
        maria.setLastName("Петрова");
        maria.setSpecialization("Мастер ногтевого сервиса");
        maria.setPhone("+7-999-123-45-68");
        maria.setEmail("maria@salon.ru");
        maria.setPhotoUrl("/images/maria.jpg");
        maria.setDescription("Ведущий мастер маникюра. Работает с премиальными материалами");
        maria.getServices().add(manicure);
        masterRepository.save(maria);

        // Создание клиентов
        Client olga = new Client();
        olga.setFirstName("Ольга");
        olga.setLastName("Смирнова");
        olga.setEmail("olga@test.ru");
        olga.setPhone("+7-999-111-11-11");
        olga.setPassword(passwordEncoder.encode("password123"));
        olga.setRole("CLIENT");
        clientRepository.save(olga);

        Client dmitry = new Client();
        dmitry.setFirstName("Дмитрий");
        dmitry.setLastName("Васильев");
        dmitry.setEmail("dmitry@test.ru");
        dmitry.setPhone("+7-999-222-22-22");
        dmitry.setPassword(passwordEncoder.encode("password123"));
        dmitry.setRole("CLIENT");
        clientRepository.save(dmitry);

        // Создание записей
        Appointment appointment1 = new Appointment();
        appointment1.setDateTime(LocalDateTime.of(2024, 1, 15, 14, 0));
        appointment1.setClient(olga);
        appointment1.setMaster(anna);
        appointment1.setService(haircutWomen);
        appointment1.setStatus("COMPLETED");
        appointment1.setNotes("Хочу каре");
        appointmentRepository.save(appointment1);

        System.out.println("✅ Данные успешно инициализированы!");
    }
}