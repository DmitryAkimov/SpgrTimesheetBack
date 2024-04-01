# SpgrTimesheetBack
Back для системы сбора загрузки v3.0
Образ базы https://disk.yandex.ru/d/z7hUL349xQHyCg
### Полезные может быть ссылки
- https://spring-projects.ru/guides/rest-service/
- https://javarush.com/groups/posts/3916-rest-api-ili-ocherednoe-testovoe-zadanie
- https://habr.com/ru/articles/483374/

Используем Swagger
Даты указываются в формате YYYYMMDD   23 апреля 2027 > 20270423
Делаем для начала без авторизации только GET запросы, отдаём JSON объекты или массив объектов

### Корень API - /api
* /timesheet/user/{employeeid}/{start}/{finish} - данные для одного юзера
* /project - все проекты
* /project/{pid} - информация по одному проекту
* /project/{id}/stage - все стадии конкретного проекта
* /calendar/{start}/{finish} - даты с учётом праздников от старта до финиша включительно
