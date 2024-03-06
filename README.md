# Лабораторная работа 4
# Выполнили: Боринский Игорь и Трафимов Владислав

## Вариант `2475`

[![Made with: Spring](https://img.shields.io/badge/Spring-white?style=for-the-badge&logo=spring&logoColor=6DB33F)](https://rubyonrails.org/)
[![Made with: Spring Boot](https://img.shields.io/badge/Spring%20Boot-white?style=for-the-badge&logo=springboot&logoColor=6DB33F)](https://rubyonrails.org/)
[![Made with: Spring Security](https://img.shields.io/badge/Spring%20Security-white?style=for-the-badge&logo=springsecurity&logoColor=6DB33F)](https://rubyonrails.org/) 
[![Made with: Spring MVC](https://img.shields.io/badge/Spring%20MVC-white?style=for-the-badge&logo=spring&logoColor=6DB33F)](https://spring.io/guides/gs/serving-web-content/) \
[![Made with: Java](https://img.shields.io/badge/Java-176579?style=for-the-badge&logo=coffeescript&logoColor=E78A2A)](https://www.ruby-lang.org/) 
[![Made with: PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)](https://rubyonrails.org/)
[![Made with: Vue.js](https://img.shields.io/badge/Vue.js-11C38C?style=for-the-badge&logo=vue.js&logoColor=2F465A)](https://rubyonrails.org/)

Переписать приложение из [предыдущей лабораторной работы](../Web-Lab3) с использованием следующих технологий:

- Уровень **back-end** должен быть основан на [Spring](https://spring.io/).
- Уровень **front-end** должен быть построен на [Vue.js](https://vuejs.org/) с использованием обычных полей ввода HTML
- Взаимодействие между уровнями **back-end** и **front-end** должно быть организовано посредством **REST API**.

Приложение по-прежнему должно включать в себя 2 страницы - _стартовую_ и _основную_ страницу приложения. Обе страницы приложения должны быть адаптированы для отображения в 3 режимах:
- **"Десктопный"** - для устройств, ширина экрана которых равна или превышает **1266** пикселей.
- **"Планшетный"** - для устройств, ширина экрана которых равна или превышает **649**, но меньше **1266** пикселей.
- **"Мобильный"**- для устройств, ширина экрана которых меньше **649** пикселей.

#### Заданная область:
<img width="233" alt="Снимок экрана 2024-03-06 в 16 20 02" src="https://github.com/xmnlssv/WEB-Lab4/assets/114988501/3e19ea10-8cbf-4a76-b848-5a0662ba208f">

### Стартовая страница должна содержать следующие элементы:

- "**Шапку**", содержащую ФИО студента, номер группы и номер варианта.
- **Форму для ввода логина и пароля**. Информация о зарегистрированных в системе пользователях должна храниться в отдельной таблице БД (пароль должен храниться в виде хэш-суммы). Доступ неавторизованных пользователей к основной странице приложения должен быть запрещён.

### Основная страница приложения должна содержать следующие элементы:

- Набор полей ввода для задания координат точки и радиуса области в соответствии с вариантом задания: Select {'-5','-4','-3','-2','-1','0','1','2','3'} для координаты по оси X, Text (-5 ... 3) для координаты по оси Y, и Select {'-5','-4','-3','-2','-1','0','1','2','3'} для задания радиуса области. Если поле ввода допускает ввод заведомо некорректных данных (таких, например, как буквы в координатах точки или отрицательный радиус), то приложение должно осуществлять их валидацию.
- **Динамически обновляемую картинку**, изображающую область на координатной плоскости в соответствии с номером варианта и точки, координаты которых были заданы пользователем. Клик по картинке должен инициировать сценарий, осуществляющий определение координат новой точки и отправку их на сервер для проверки её попадания в область. Цвет точек должен зависить от факта попадания / непопадания в область. Смена радиуса также должна инициировать перерисовку картинки.
- **Таблицу** со списком результатов предыдущих проверок.
- Ссылку, по которой аутентифицированный пользователь может **закрыть свою сессию** и вернуться на стартовую страницу приложения.

### Дополнительные требования к приложению:

- Все результаты проверки должны сохраняться в базе данных под управлением СУБД `PostgreSQL`.
- Для **доступа к БД** необходимо использовать `Spring Data`.

### Вопросы к защите лабораторной работы:

1. Платформа `Java EE`. Спецификации и их реализации.
2. Принципы `IoC`, `CDI` и `Location Transpanency`. Компоненты и контейнеры.
3. Управление жизненным циклом компонентов. Дескрипторы развёртывания.
4. `Java EE API`. Виды компонентов. Профили платформы `Java EE`.
5. Компоненты `EJB`. `Stateless` & `Stateful` `Session Beans`. `EJB Lite` и `EJB Full`.
6. Работа с электронной почтой в `Java EE`. `JavaMail API`.
7. `JMS`. Реализация очередей сообщений. Способы доставки сообщений до клиента. `Message-Driven Beans`.
8. Понятие транзакции. Управление транзакциями в `Java EE`. `JTA`.
9. Веб-сервисы. Технологии `JAX-RS` и `JAX-WS`.
10. Платформа `Spring`. Сходства и отличия с `Java EE`.
11. Модули `Spring`. Архитектура `Spring Runtime`. `Spring Security` и `Spring Data`.
12. Реализация `IoC` и `CDI` в `Spring`. Сходства и отличия с `Java EE`.
13. Реализация `REST API` в `Java EE` и `Spring`.
14. `React JS.` Архитектура и основные принципы разработки приложений.
15. Компоненты `React`. `State` & `props`. "Умные" и "глупые" компоненты.
16. Разметка страниц в `React`-приложениях. `JSX`.
17. Навигация в `React`-приложениях. `ReactRouter`.
18. Управление состоянием интерфейса. `Redux`.
19. `Angular`: архитектура и основные принципы разработки приложений.
20. `Angular`: модули, компоненты, сервисы и `DI`.
21. `Angular`: шаблоны страниц, жизненный цикл компонентов, подключение `CSS`.
22. `Angular`: клиент-серверное взаимодействие, создание, отправка и валидация данных форм.
  
