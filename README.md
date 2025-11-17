# Dungeons and Gags

**Dungeons and Gags** - это веб-приложение, посвящённое Dungeons & Dragons с элементами юмора.  
Приложение позволяет создавать персонажей, просматривать арты, управлять ролями пользователей, создавать и арендовать мастеров для компании и использовать справочник по игре.

---

## Функциональность

- **Галерея артов** - галерея изображений персонажей и монстров.
- **Создание персонажей** - пользователи могут создавать и сохранять своих персонажей в базе данных.
- **Роли пользователей** - система ролей с различными правами доступа (например, администратор, пользователь).
- **Справочник DnD** - справочная информация по правилам и механикам игры.
- **Хранение данных** - персонажи и данные пользователей сохраняются в PostgreSQL.
- **Создание мастеров** - админы могут создавать мастеров прям из админ-панели.

---

## Технологический стек

- **Java 21**
- **Servlet API / JSP**
- **PostgreSQL** - база данных
- **BCrypt** - хэширование паролей
- **Lombok** - сокращение шаблонного кода
- **JSTL** - работа с JSP тегами

---

## Установка и запуск

1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/PalmaDae/FISD-and-Stuff

2. Настройте базу данных PostgreSQL:

    Создайте базу данных и пользователя.

    Импортируйте схему и таблицы, если есть SQL-скрипт.

3. Настройте подключение к БД в файлах проекта (DAO или конфигурационные файлы).

4. Разверните проект на Tomcat 10+ или другом совместимом сервере.

5. Перейдите по URL сервера и начните использовать приложение.

---

## Структура проекта

```bash
src/
└── main/
    ├── java/
    │   ├── dao/           # Работа с БД (CharakterDAO, MasterDAO, UserDAO)
    │   ├── entity/        # Сущности (Charakter, User, Master, Role, Race, Clasz)
    │   ├── filter/        # Фильтры запросов (MyFilter)
    │   ├── service/       # Сервисы (CharService, UserService, MasterService)
    │   ├── servlet/       # Сервлеты для страниц и действий пользователей
    │   └── util/          # Утилиты (HashUtil)
    └── webapp/
        ├── css/           # Стили приложения
        ├── images/        # Изображения (арт, мастера, логотип)
        ├── js/            # Скрипты
        ├── jsp/           # JSP страницы
        └── WEB-INF/       # web.xml и конфигурации

```
---

## Создание бд

``` bash
sudo -i -u postgres
psql
create database characters
``` 

---

## Скрипты для создания таблиц

``` sql
   CREATE TABLE public.characters (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    player_name VARCHAR(100),
    race VARCHAR(50) NOT NULL,
    clasz VARCHAR(50) NOT NULL,
    level INT DEFAULT 1 CHECK (level >= 1),
    strength INT CHECK (strength BETWEEN 1 AND 30),
    dexterity INT CHECK (dexterity BETWEEN 1 AND 30),
    constitution INT CHECK (constitution BETWEEN 1 AND 30),
    intelligence INT CHECK (intelligence BETWEEN 1 AND 30),
    wisdom INT CHECK (wisdom BETWEEN 1 AND 30),
    charisma INT CHECK (charisma BETWEEN 1 AND 30),
    speed INT DEFAULT 30 CHECK (speed >= 0),
    armor_class INT DEFAULT 10 CHECK (armor_class >= 0),
    initiative INT DEFAULT 0,
    hit_points INT DEFAULT 0,
    temporary_hit_points INT DEFAULT 0,
    hit_dice VARCHAR(10),
    gold INT DEFAULT 0 CHECK (gold >= 0),
    silver INT DEFAULT 0 CHECK (silver >= 0),
    copper INT DEFAULT 0 CHECK (copper >= 0)
);
```
``` sql
CREATE TABLE public.masters (
	id bigserial NOT NULL,
	"name" varchar(255) NOT NULL,
	photo_path varchar(300) NOT NULL,
	description text NULL,
	"cost" int4 NULL,
	CONSTRAINT masters_cost_check CHECK ((cost >= 0)),
	CONSTRAINT masters_pkey PRIMARY KEY (id)
);
```

``` sql
CREATE TABLE public.user_characters (
    user_id BIGINT NOT NULL,
    character_id BIGINT NOT NULL,
    CONSTRAINT user_characters_pkey PRIMARY KEY (user_id, character_id),
    CONSTRAINT user_characters_user_id_fkey FOREIGN KEY (user_id) 
        REFERENCES public.users(id) ON DELETE CASCADE,
    CONSTRAINT user_characters_character_id_fkey FOREIGN KEY (character_id) 
        REFERENCES public.characters(id) ON DELETE CASCADE
);

```

``` sql
CREATE TABLE public.users (
	id bigserial NOT NULL,
	username varchar(100) NOT NULL,
	hash_pass varchar(255) NOT NULL,
	"role" varchar(50) NOT NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id),
	CONSTRAINT users_username_key UNIQUE (username)
);
```
---
## JSP страницы

- **page-main.jsp** - главная страница приложения.

- **page-arts.jsp** - галерея артов.

- **page-registration.jsp** - регистрация пользователей.

- **page-login.jsp** - страница логина.

- **page-admin.jsp** - административная панель.

- **page-guide.jsp**- справочник по DnD.

- **page-quiz.jsp** - викторина по BG3.

- **page-character.jsp** - создание персонажа.

- **page-masters.jsp** - список мастеров.

- **header.jsp** - общий заголовок и навигация.

## Автор

PalmaDae - разработка, дизайн, архитектура приложения.
