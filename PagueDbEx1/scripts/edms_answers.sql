-- 1. my creation of the tables and records
create database edms;


\c edms


create table department (
	dep_id integer not null primary key,
	dep_name varchar(20) not null,
	dep_location varchar(15) not null
);


create table salary_grade (
	grade integer not null primary key,
	min_salary integer not null,
	max_salary integer not null
);


create table employees (
	emp_id integer not null primary key,
	emp_name varchar(15) not null,
	job_name varchar(10) not null,
	manager_id integer,
	hire_date date not null,
	salary decimal(10,2) not null,
	commission decimal(7,2),
	dep_id integer not null
);

insert into department (dep_id, dep_name, dep_location) values
(1001, 'FINANCE', 'SYDNEY'),
(2001, 'AUDIT', 'MELBOURNE'),
(3001, 'MARKETING', 'PERTH'),
(4001, 'PRODUCTION', 'BRISBANE');


insert into salary_grade (grade, min_salary, max_salary) values
(1, 800, 1300),
(2, 1301, 1500),
(3, 1501, 2100),
(4, 2101, 3100),
(5, 3101, 9999);


insert into employees (emp_id, emp_name, job_name, manager_id, hire_date, salary, commission, dep_id) values
(68319, 'KAYLING', 'PRESIDENT', null, '1991-11-18', 6000.00, null, 1001),
(66928, 'BLAZE', 'MANAGER', 68319, '1991-05-01', 2750.00, null, 3001),
(67832, 'CLARE', 'MANAGER', 68319, '1991-06-09', 2550.00, null, 1001),
(65646, 'JONAS', 'MANAGER', 68319, '1991-04-02', 2957.00, NULL, 2001),
(67858, 'SCARLET', 'ANALYST', 65646, '1997-04-19', 3100.00, NULL, 2001),
(69062, 'FRANK', 'ANALYST', 65646, '1991-12-03', 3100.00, NULL, 2001),
(63679, 'SANDRINE', 'CLERK', 69062, '1990-12-18', 900.00, NULL, 2001),
(64989, 'ADELYN', 'SALESMAN', 66928, '1991-02-20', 1700.00, 400.00, 3001),
(65271, 'WADE', 'SALESMAN', 66928, '1991-02-22', 1350.00, 600.00, 3001),
(66564, 'MADDEN', 'SALESMAN', 66928, '1991-09-28', 1350.00, 1500.00, 3001),
(68454, 'TUCKER', 'SALESMAN', 66928, '1991-09-08', 1600.00, 0.00, 3001),
(68736, 'ADNRES', 'CLERK', 67858, '1997-05-23', 1200.00, NULL, 2001),
(69000, 'JULIUS', 'CLERK', 66928, '1991-12-03', 1050.00, NULL, 3001),
(69324, 'MARKER', 'CLERK', 67832, '1992-01-23', 1400.00, NULL, 1001);


select * from department;
select * from salary_grade;
select * from employees;


-- 2. names of manager with salary between 1500 and 2500

select emp_name, salary
from employees
where job_name = 'manager'
and salary between 1500 and 2500;


-- 3. names of employees that work in Sydney

select emp_name 
from employees
where dep_id = (
	select dep_id
	from department
	where dep_location = 'SYDNEY'
);


-- 4. salesmen earn salary of grade 2

select employees.emp_name
from employees, salary_grade
where employees.salary 
between salary_grade.min_salary
and salary_grade.max_salary
and employees.job_name = 'SALESMAN'
and salary_grade.grade = 2;


-- 5. salary grade of each employee

select employees.emp_name, employees.salary, salary_grade.grade
from employees, salary_grade
where employees.salary
between salary_grade.min_salary
and salary_grade.max_salary
order by salary_grade.grade;


-- 6. departments located in Melbourne

select dep_name, dep_location
from department
where dep_location = 'MELBOURNE';


-- 7. employees name and job in format

select emp_name || ' & ' || job_name
as "Employee & Job"
from employees;


-- 8. employees who joined in January

select emp_name, hire_date
from employees
where extract(month 
from hire_date) = 1;


-- 9. hired date, job, and employees who joined the company before 1992-12-31 

select hire_date, job_name, emp_name
from employees
where hire_date < '1992-12-31'
order by hire_date;


-- 10. id, name, and salary with exp over 10 years

select emp_id, emp_name, salary, hire_date
from employees
where extract(year from age(
current_date, hire_date)) > 10;


-- 11. employees whose names contain the char set 'AR' together

select emp_name
from employees
where emp_name
like '%AR%';






