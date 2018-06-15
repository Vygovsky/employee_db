drop table if exists DEPARTMENT;

drop table if exists EMPLOYEE;

drop table if exists EMPLOYEE_DEPARTMENT;

create table "EMPLOYEE"
(
  "ID" BIGINT NOT NULL,
  "FIRST_NAME" VARCHAR (100) NOT NULL,
  "EMAIL" VARCHAR (100) NOT NULL,
  "BIRTHDAY" DATE NOT NULL,
  CONSTRAINT "EMPLOYEE_PKEY" PRIMARY KEY ("ID")
);

insert into EMPLOYEE (ID, FIRST_NAME, EMAIL, BIRTHDAY)
values
  (1, 'Mark', 'Markovich@mail.net', '1988-12-13'),
  (2, 'Marina', 'poli@ukr.net', '2000-05-13'),
  (3, 'Petr', 'petrosik@gmail.net', '2005-08-23'),
  (4, 'Gosh', 'lombok@meta.net', '1986-09-30'),
  (5, 'Mila', 'romik@ukr.net', '1996-06-27'),
  (6, 'Yaroslav', '113Yar@yahoo.com', '1980-10-21'),
  (7, 'Gena', '98Gen@.ru', '1996-06-27'),
  (8, 'Sergey', 'qqqq@ukr.com', '1975-04-15'),
  (9, 'Igor', 'igorNarkoman@ukr.org', '2000-01-27'),
  (10, 'Alex', 'face@ukr.org', '2008-06-06');

create table "DEPARTMENT"
(
  "ID" BIGINT NOT NULL,
  "NAME" VARCHAR (100) NOT NULL,
  CONSTRAINT "DEPARTMENT_PKEY" PRIMARY KEY ("ID")
);

insert into DEPARTMENT (ID, NAME)
values
  (1, 'Google'),
  (2, 'Yahoo'),
  (3, 'Oracle'),
  (4, 'Linux');

create table EMPLOYEE_DEPARTMENT
(
  "EMPLOYEE_ID" BIGINT NOT NULL,
  "DEPARTMENT_ID" BIGINT NOT NULL,
  CONSTRAINT "EMPLOYEE_DEPARTMENT_PKEY" PRIMARY KEY (EMPLOYEE_ID, DEPARTMENT_ID),
  FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(ID),
  FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT(ID)
);

insert into EMPLOYEE_DEPARTMENT (EMPLOYEE_ID, DEPARTMENT_ID)
values
  (1, 1),
  (2, 2),
  (3, 3),
  (4, 4),
  (5, 2),
  (6, 3),
  (7, 4),
  (8, 4),
  (9, 1),
  (10, 3);
