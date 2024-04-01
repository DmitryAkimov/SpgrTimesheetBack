# SpgrTimesheetBack
Back для системы сбора загрузки v3.0
Образ базы https://disk.yandex.ru/d/z7hUL349xQHyCg

Даты указываются в формате YYYYMMDD   23 апреля 2027 > 20270423
Корень API - /api
* /timesheet/user/{id}/{start}/{finish} - данные для одного юзера
* /project - все проекты
* /project/{pid} - информация по одному проекту
* /project/{id}/stage - стадии конкретного проекта
* /calendar/{start}/{finish} - даты с учётом праздников от старта до финиша включительно
!
