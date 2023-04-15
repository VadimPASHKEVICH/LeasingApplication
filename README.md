Leasing Application проект для TeachMeSkills

Описание:
Клиент-приложение для Лизинговой компании, позволяющий пользователям (клиентам) компании
отслеживать свой Договор, получать текущую информацию о Договоре (срок, платеж, задолженность),
а также получить информацию по Предмету Договора (автомобиль - марка, модель, год выпуска).

DataBase:
В данном проекте в качестве базы данных используется PostgresSQL. Для подключения к базе данных
необходимо знать username and password, а также прописать настройки в application.properties

База данных содержит 5 таблиц:
users - хранит информацию о пользователях;
roles - хранит роль пользователя. В таблице может быть только две роли: 'USER', 'ADMIN';
agreement - хранит информацию о договоре лизинга (номер договора, срок действия, ежемесячный платеж,
просроченный платеж, основной долг);
agreement_info - хранит информацию о машине (марка, модель, год выпуска);
credit_card - хранит информацию о банковских картах пользователей.

Registration:
Для запуска приложения его нужно запустить и перейти по ссылке http://localhost:8080/swagger-ui/index.html#/,
передав в сплывающее окно пользователя из базы данных.
Либо воспользоваться вторым методом, в который мы должны передать формат JSON пользователя login, password
"http://localhost:8080/registration", после чего пользователь будет создан и перемещен в базу данных. 

Возможности пользователя с ролью USER и ADMIN
/user/update - позволяет обновить информацию о пользователе;
/user/deleteUser/{id} - удалить пользователя по id.

Возможности пользователя с ролью ADMIN
/user/all - позволяет получить информацию о всех пользователя приложения;
/user/{id} - получить информацию о конкретном пользователе, передав id.
/agreement/** - позволяет проводить все действия, описанные в контроллере, с Договором;
/info/** - позволяет проводить все действия, описанные в контроллере, по Предмету лизинга.

Возможности пользователя с ролью USER
/card/** - позволяет проводить все действия, описанные в контроллере, по банковским картам. 


Leasing Application project for TeachMeSkills

Description:
Client-application for the Leasing Company, which allows users (clients) of the company
track your Agreement, receive current information about the Agreement (term, payment, debt),
as well as obtain information on the Subject of the Agreement (car - brand, model, year of manufacture).

database:
This project uses PostgreSQL as a database. To connect to a database
you need to know the username and password, as well as set the settings in application.properties

The database contains 5 tables:
users - stores information about users;
roles - stores the user's role. There can only be two roles in a table: 'USER', 'ADMIN';
agreement - stores information about the leasing agreement (agreement number, validity period, monthly payment,
overdue payment, principal debt);
agreement_info - stores information about the car (make, model, year of manufacture);
credit_card - stores information about users' bank cards.

registration:
To run the application, you need to run it and follow the link http://localhost:8080/swagger-ui/index.html#/,
passing the user from the database to the popup window.
Or use the second method, in which we must pass the JSON format of the user login, password
"http://localhost:8080/registration", after which the user will be created and moved to the database.

Features of the user with the USER and ADMIN roles
/user/update - allows you to update information about the user;
/user/deleteUser/{id} - delete a user by id.

Features of a user with the ADMIN role
/user/all - allows you to get information about all users of the application;
/user/{id} - get information about a specific user by passing id.
/agreement/** - allows you to perform all the actions described in the controller with the Agreement;
/info/** - allows you to perform all the actions described in the controller for the Lease Subject.

Features of a user with the USER role
/card/** - allows you to perform all the actions described in the controller using bank cards.