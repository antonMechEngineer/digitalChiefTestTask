# digitalChiefTestTask

## Описание предметной области 

Предметная область – IT компания. Компания имеет департаменты (Department). В департаменте работают сотрудники (Worker). Сотрудники работают только в одном департаменте, совместительство не практикуется. В этом случае одному департаменту соответствует множество сотрудников (отношение один ко многим) – это отношение и будет рассматриваться.
Каждый сотрудник имеет следующие поля: фамилию, имя, должность, зарплата, электронную почту.
Каждый департамент имеет следующие поля: номер, направление деятельности, страну, количество вакансий, kPi (эффективность).
Имеется в обоих случаях поле id, но это не является характеристикой сущности, а  является синтетическим ключом для бд.

## Описание сущностей

Описание сущностей модели:
Department:
-	Id;
-	Number
-	Direction;
-	City;
-	Number Vacancies;
-	KPI
-	Workers

Worker:
-	Id;
-	Name;
-	Surname;
-	E-mail;
-	Position;
-	Salary;
-	DepartmentID

## Описание программы

Программа по архитектурному стилю схожа с MVC, однако в данном случае отсутствует слой представления
VIEW. В данном случае он замещен DTO которые при передаче во FrontEnd преобразуются JSON объекты.
Клиент серверное взаимодействие построено по архитектурному принципу REST. API построен по принципу CRUD и использует HTTP протокол.
При разработке были использованы следующие методы GET, POST, PUT, UPDATE, DELETE.

## Тестирование

Программа протестирована в ручном режиме при помощи Talend API. Тестовые данные лежат в папке resources. При запуске сервера данная база проливается автоматически.