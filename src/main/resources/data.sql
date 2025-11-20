-- Услуги
INSERT INTO salon_service (id, name, description, price, duration, category) VALUES
(1, 'Стрижка женская', 'Модная стрижка с укладкой', 1500.00, 60, 'HAIR'),
(2, 'Мужская стрижка', 'Стрижка машинкой и ножницами', 800.00, 30, 'HAIR'),
(3, 'Окрашивание волос', 'Стойкое окрашивание премиум краской', 3000.00, 120, 'HAIR'),
(4, 'Маникюр', 'Аппаратный маникюр с покрытием', 1200.00, 90, 'NAILS'),
(5, 'Педикюр', 'Комплексный уход за стопами', 1500.00, 60, 'NAILS'),
(6, 'Макияж', 'Вечерний макияж', 2000.00, 60, 'MAKEUP');

-- Мастера
INSERT INTO master (id, first_name, last_name, specialization, phone, email, photo_url, description) VALUES
(1, 'Анна', 'Иванова', 'Стилист-парикмахер', '+7-999-123-45-67', 'anna@salon.ru', '/images/anna.jpg', 'Опыт работы 5 лет. Специализация: окрашивание, сложные стрижки'),
(2, 'Мария', 'Петрова', 'Мастер ногтевого сервиса', '+7-999-123-45-68', 'maria@salon.ru', '/images/maria.jpg', 'Ведущий мастер маникюра. Работает с премиальными материалами'),
(3, 'Елена', 'Сидорова', 'Визажист', '+7-999-123-45-69', 'elena@salon.ru', '/images/elena.jpg', 'Профессиональный визажист. Создает образы для фотосессий и мероприятий'),
(4, 'Иван', 'Кузнецов', 'Барбер', '+7-999-123-45-70', 'ivan@salon.ru', '/images/ivan.jpg', 'Специалист по мужским стрижкам и бритью');

-- Связи мастеров и услуг
INSERT INTO master_services (master_id, service_id) VALUES
(1, 1), (1, 3),
(2, 4), (2, 5),
(3, 6),
(4, 2);

-- Клиенты
INSERT INTO client (id, first_name, last_name, email, phone, password, role) VALUES
(1, 'Ольга', 'Смирнова', 'olga@test.ru', '+7-999-111-11-11', '$2a$10$xyz123', 'CLIENT'),
(2, 'Дмитрий', 'Васильев', 'dmitry@test.ru', '+7-999-222-22-22', '$2a$10$xyz124', 'CLIENT');

-- Записи
INSERT INTO appointment (id, date_time, client_id, master_id, service_id, status, notes) VALUES
(1, '2024-01-15 14:00:00', 1, 1, 1, 'COMPLETED', 'Хочу каре'),
(2, '2024-01-20 16:00:00', 2, 4, 2, 'CONFIRMED', 'Под ноль');