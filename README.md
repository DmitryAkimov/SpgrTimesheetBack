# SpgrTimesheetBack
Back для системы сбора загрузки v3.0
Образ базы https://disk.yandex.ru/d/z7hUL349xQHyCg
### Полезные может быть ссылки
- https://spring-projects.ru/guides/rest-service/
- https://javarush.com/groups/posts/3916-rest-api-ili-ocherednoe-testovoe-zadanie
- https://habr.com/ru/articles/483374/
- [Как пользоваться Postman](https://habr.com/ru/companies/vk/articles/750096/)

Используем Swagger, Postman, Spring
Даты указываются в формате YYYYMMDD   23 апреля 2027 > 20270423
Делаем для начала без авторизации только GET запросы, отдаём JSON объекты или массив объектов
Для имён используем[PascalCase](https://github.com/hyoo-ru/mam_mol/wiki/PascalCase-vs-camelCase-vs-kebab-case-vs-snake_case)
Название класса = его тесктовое представление > Employee = Иванов Аккакий Акакиевич
Название класса + 'Id' =  идентификатор > EmployeeId = 0000005423

### Корень API - /api
* /project - все проекты
* /project/{pid} - информация по одному проекту
* /project/{id}/stage - все стадии конкретного проекта

* /timesheet/{employeeid}/{start}/{finish} - данные для одного юзера
* /calendar/{start}/{finish} - даты с учётом праздников от старта до финиша включительно
