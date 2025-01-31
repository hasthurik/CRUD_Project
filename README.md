Простой проект для демонстрации базовых операций CRUD (Create, Read, Update, Delete) с использованием Spring Boot и REST API.

Проект разработан с использованием следующих технологий:
Backend: Spring Boot (Java).
База данных: PostgreSQL (или другая, в зависимости от конфигурации).
API: RESTful.
Maven: Для управления зависимостями и сборки проекта.

**API Endpoints**
1. Получить приветственное сообщение
Метод: GET
URL: /api

2. Получить список всех продуктов
Метод: GET
URL: /api/products

3. Получить продукт по ID
Метод: GET
URL: /api/products/{id}

4. Добавить новый продукт
Метод: POST
URL: /api/products

5. Обновить продукт по ID
Метод: PUT
URL: /api/products/{id}

**Структура проекта**
CRUD_Project/
├── src/
│   ├── main/
│   │   ├── java/com/example/ecom_project/
│   │   │   ├── controller/          # Контроллеры (ProductController)
│   │   │   ├── model/               # Модели данных (Product)
│   │   │   ├── service/             # Сервисы (ProductService)
│   │   │   └── EcomProjectApplication.java # Главный класс приложения
│   │   └── resources/               # Ресурсы (application.properties, настройки PostgreSQL)
│   └── test/                        # Тесты
├── pom.xml                          # Файл конфигурации Maven
└── README.md                        # Документация
