/*
 * Palanca - Track 9: Java Exercise 15; DB Exercise 1
 */

create database edms;
\echo 'Created Database: edms'
\c edms;

\echo '1. Create tables and insert records\n'

create table department (
    dep_id integer not null primary key,
    dep_name varchar(20) not null,
    dep_location varchar(15) not null
);

create table salary_grade (
    grade integer  not null primary key,
    min_salary integer  not null,
    max_salary integer  not null
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

insert into department
values (1001, 'FINANCE', 'SYDNEY'),
(2001, 'AUDIT', 'MELBOURNE'),
(3001, 'MARKETING', 'PERTH'),
(4001, 'PRODUCTION', 'BRISBANE');


insert into salary_grade
values (1, 800, 1300),
(2, 1301, 1500),
(3, 1501, 2100),
(4, 2101, 3100),
(5, 3101, 9999);

insert into employees
values (68319, 'KAYLING', 'PRESIDENT', null, '1991-11-18', 6000.00, null, 1001),
(66928, 'BLAZE', 'MANAGER', 68319, '1991-05-01', 2750.00, null, 3001),
(67832, 'CLARE', 'MANAGER', 68319, '1991-06-09', 2550.00, null, 1001),
(65646, 'JONAS', 'MANAGER', 68319, '1991-04-02', 2957.00, null, 2001),
(67858, 'SCARLET', 'ANALYST', 65646, '1997-04-19', 3100.00, null, 2001),
(69062, 'FRANK', 'ANALYST', 65646, '1991-12-03', 3100.00, null, 2001),
(63679, 'SANDRINE', 'CLERK', 69062, '1990-12-18',  900.00, null, 2001),
(64989, 'ADELYN', 'SALESMAN', 66928, '1991-02-20', 1700.00, 400.00, 3001),
(65271, 'WADE', 'SALESMAN', 66928, '1991-02-22', 1350.00, 600.00, 3001),
(66564, 'MADDEN', 'SALESMAN', 66928, '1991-09-28', 1350.00, 1500.00, 3001),
(68454, 'TUCKER', 'SALESMAN', 66928, '1991-09-08', 1600.00, 0.00, 3001),
(68736, 'ADNRES', 'CLERK', 67858, '1997-05-23', 1200.00, null, 2001),
(69000, 'JULIUS', 'CLERK', 66928, '1991-12-03', 1050.00, null, 3001),
(69324, 'MARKER', 'CLERK', 67832, '1992-01-23', 1400.00, null, 1001);


\echo '\nemployees table'

table employees;

\echo 'department table'

table department;

\echo 'salary_grade table'

table salary_grade;

\echo '2. Names of managers that have a salary between 1500 and 2500\n'

select emp_name as "Employee Name"
from employees
where job_name = 'MANAGER'
  and salary > 1500
  and salary < 2500;

\echo '3. Names of employees that work in Sydney\n'

select emp_name as "Employee Name"
from employees
where dep_id = (
    select dep_id
    from department
    where dep_location = 'SYDNEY'
);

\echo '4. Salesmen that earn a salary of grade 2\n'

select emp_name as "Employee Name"
from employees
where job_name = 'SALESMAN' 
and salary >= (
	select min_salary
	from salary_grade 
	where grade = 2) 
and salary <= (
	select min_salary 
	from salary_grade 
	where grade = 2);

\echo '5. Salary grade of each employee sorted by salary grade\n'
  
select emp_name as "Employee Name", salary as "Salary", (
	select grade
	from salary_grade
	where employees.salary >= min_salary
		and employees.salary <= max_salary
) as "Grade"
from employees
order by 3;

\echo '6. Departments located in Melbourne\n'

select dep_name as "Department Name"
from department
where dep_location = 'MELBOURNE';

\echo '7. Employee name and job name in format "Employee & Job"\n'

select concat(emp_name, ' & ', job_name) as "Employee & Job"
from employees;

\echo '8. Employees who joined in the month of January\n'

select emp_name as "Employee Name"
from employees
where date_part('month', hire_date) = 1;

\echo '9. Hire date, job, and employee name who joined before 1992-12-31\n'

select hire_date as "Date Hired", 
job_name as "Job Name", emp_name as "Employee Name"
from employees
where hire_date < '1992-12-31'::date;

\echo '10. ID, name, and salary of employees with experience over 10 years\n'

select emp_id as "Employee ID", 
emp_name as "Employee Name", salary as "Salary"
from employees
where date_part('year', age(hire_date)) > 10;

\echo '11. Employees whose names contain the character set ''AR''\n'

select emp_name as "Employee Name"
from employees
where strpos(emp_name, 'AR') > 0;
