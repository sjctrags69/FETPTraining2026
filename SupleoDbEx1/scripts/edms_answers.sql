-- ---------------------------------------------------------
-- 1. Create tables and insert initial records
-- ---------------------------------------------------------

create table employees(
    emp_id integer not null primary key,
    emp_name varchar(15) not null,
    job_name varchar(10) not null,
    manager_id integer,
    hire_date date not null,
    salary decimal(10,2) not null,
    commission decimal(7,2),
    dep_id integer not null
);

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

insert into department (dep_id, dep_name, dep_location) values
(1001, 'finance', 'sydney'),
(2001, 'audit', 'melbourne'),
(3001, 'marketing', 'perth'),
(4001, 'production', 'brisbane');

insert into salary_grade (grade, min_salary, max_salary) values
(1, 800, 1300),
(2, 1301, 1500),
(3, 1501, 2100),
(4, 2101, 3100),
(5, 3101, 9999);

insert into employees (emp_id, emp_name, job_name, manager_id, hire_date, salary, commission, dep_id) values
(68319, 'kayling', 'president', null, '1991-11-18', 6000.00, null, 1001),
(66928, 'blaze', 'manager', 68319, '1991-05-01', 2750.00, null, 3001),
(67832, 'clare', 'manager', 68319, '1991-06-09', 2550.00, null, 1001),
(65646, 'jonas', 'manager', 68319, '1991-04-02', 2957.00, null, 2001),
(67858, 'scarlet', 'analyst', 65646, '1997-04-19', 3100.00, null, 2001),
(69062, 'frank', 'analyst', 65646, '1991-12-03', 3100.00, null, 2001),
(63679, 'sandrine', 'clerk', 69062, '1990-12-18', 900.00, null, 2001),
(64989, 'adelyn', 'salesman', 66928, '1991-02-20', 1700.00, 400.00, 3001),
(65271, 'wade', 'salesman', 66928, '1991-02-22', 1350.00, 600.00, 3001),
(66564, 'madden', 'salesman', 66928, '1991-09-28', 1350.00, 1500.00, 3001),
(68454, 'tucker', 'salesman', 66928, '1991-09-08', 1600.00, 0.00, 3001),
(68736, 'adnres', 'clerk', 67858, '1997-05-23', 1200.00, null, 2001),
(69000, 'julius', 'clerk', 66928, '1991-12-03', 1050.00, null, 3001),
(69324, 'marker', 'clerk', 67832, '1992-01-23', 1400.00, null, 1001);

-- ---------------------------------------------------------
-- 2. What are the names of managers that have a salary between 1500 and 2500?
-- ---------------------------------------------------------
select emp_name 
from employees 
where job_name = 'manager' 
and salary between 1500 and 2500;

-- ---------------------------------------------------------
-- 3. What are the names of the employees that work in sydney?
-- ---------------------------------------------------------
select e.emp_name 
from employees e
join department d on e.dep_id = d.dep_id
where d.dep_location = 'sydney';

-- ---------------------------------------------------------
-- 4. Which salesmen earn a salary of grade 2?
-- ---------------------------------------------------------
select e.emp_name 
from employees e
join salary_grade s on e.salary between s.min_salary and s.max_salary
where e.job_name = 'salesman' 
and s.grade = 2;

-- ---------------------------------------------------------
-- 5. What is the salary grade of each employee? (Sort the output according to the salary grades.)
-- ---------------------------------------------------------
select e.emp_name, s.grade 
from employees e
join salary_grade s on e.salary between s.min_salary and s.max_salary
order by s.grade;

-- ---------------------------------------------------------
-- 6. Which are the departments that are located in melbourne?
-- ---------------------------------------------------------
select dep_name 
from department 
where dep_location = 'melbourne';

-- ---------------------------------------------------------
-- 7. Write a query in SQL to produce the output of employees name and job name in a format: "Employee & Job"
-- ---------------------------------------------------------
select emp_name || ' & ' || job_name as "employee & job" 
from employees;

-- ---------------------------------------------------------
-- 8. Write a query in SQL to list the employees who joined in the month january.
-- ---------------------------------------------------------
select emp_name 
from employees 
where extract(month from hire_date) = 1;

-- ---------------------------------------------------------
-- 9. Write a query in SQL to list the hired date, job, and employee name who joined the company before 1992-12-31
-- ---------------------------------------------------------
select hire_date, job_name, emp_name 
from employees 
where hire_date < '1992-12-31';

-- ---------------------------------------------------------
-- 10. Write a query in SQL to list the id, name, and salary with an experience over 10 years
-- ---------------------------------------------------------
select emp_id, emp_name, salary 
from employees 
where extract(year from age(current_date, hire_date)) > 10;

-- ---------------------------------------------------------
-- 11. Write a query in SQL to list the employees whose names containing the character set 'ar' together
-- ---------------------------------------------------------
select emp_name 
from employees 
where emp_name like '%ar%';