-- Question 1: Create Database & Tables

CREATE DATABASE edms;
\c edms

CREATE TABLE department(
  dep_id INTEGER NOT NULL PRIMARY KEY,
  dep_name VARCHAR(20),
  dep_location VARCHAR(15)
);

CREATE TABLE salary_grade(
  grade INTEGER NOT NULL PRIMARY KEY,
  min_sal INTEGER,
  max_sal INTEGER
);

CREATE TABLE employees(
  emp_id INTEGER NOT NULL PRIMARY KEY,
  emp_name VARCHAR(15),
  job_name VARCHAR(10),
  manager_id INTEGER,
  hire_date DATE,
  salary DECIMAL(10,2),
  commission DECIMAL(7,2),
  dep_id INTEGER
);

INSERT INTO department VALUES
(1001, 'FINANCE', 'SYDNEY'),
(2001, 'AUDIT', 'MELBOURNE'),
(3001, 'MARKETING', 'PERTH'),
(4001, 'PRODUCTION', 'BRISBANE');

INSERT INTO salary_grade VALUES
(1, 800, 1300),
(2, 1301, 1500),
(3, 1501, 2100),
(4, 2101, 3100),
(5, 3101, 9999);

INSERT INTO employees VALUES
(68319, 'KAYLING',  'PRESIDENT', NULL,  '1991-11-18', 6000.00, NULL,    1001),
(66928, 'BLAZE',    'MANAGER',   68319, '1991-05-01', 2750.00, NULL,    3001),
(67832, 'CLARE',    'MANAGER',   68319, '1991-06-09', 2550.00, NULL,    1001),
(65646, 'JONAS',    'MANAGER',   68319, '1991-04-02', 2957.00, NULL,    2001),
(67858, 'SCARLET',  'ANALYST',   65646, '1997-04-19', 3100.00, NULL,    2001),
(69062, 'FRANK',    'ANALYST',   65646, '1991-12-03', 3100.00, NULL,    2001),
(63679, 'SANDRINE', 'CLERK',     69062, '1990-12-18', 900.00,  NULL,    2001),
(64989, 'ADELYN',   'SALESMAN',  66928, '1991-02-20', 1700.00, 400.00,  3001),
(65271, 'WADE',     'SALESMAN',  66928, '1991-02-22', 1350.00, 600.00,  3001),
(66564, 'MADDEN',   'SALESMAN',  66928, '1991-09-28', 1350.00, 1500.00, 3001),
(68454, 'TUCKER',   'SALESMAN',  66928, '1991-09-08', 1600.00, 0.00,    3001),
(68736, 'ADNRES',   'CLERK',     67858, '1997-05-23', 1200.00, NULL,    2001),
(69000, 'JULIUS',   'CLERK',     66928, '1991-12-03', 1050.00, NULL,    3001),
(69324, 'MARKER',   'CLERK',     67832, '1992-01-23', 1400.00, NULL,    1001);


-- Question 2: Managers with salary between 1500 and 2500
SELECT emp_name
FROM employees
WHERE job_name = 'MANAGER' AND salary BETWEEN 1500 AND 2500;


-- Question 3: Employees working in Sydney
SELECT emp_name
FROM employees
WHERE dep_id IN (SELECT dep_id FROM department WHERE dep_location = 'SYDNEY');


-- Question 4: Salesmen with salary grade 2
SELECT emp_name
FROM employees
WHERE job_name = 'SALESMAN'
AND salary BETWEEN (SELECT min_sal FROM salary_grade WHERE grade = 2)
               AND (SELECT max_sal FROM salary_grade WHERE grade = 2);


-- Question 5: Salary grade of each employee sorted by grade
SELECT emp_name,
  (SELECT grade FROM salary_grade WHERE employees.salary BETWEEN min_sal AND max_sal) AS grade
FROM employees
ORDER BY grade;


-- Question 6: Departments located in Melbourne
SELECT dep_name
FROM department
WHERE dep_location = 'MELBOURNE';


-- Question 7: Employee name and job in "Employee & Job" format
SELECT emp_name || ' & ' || job_name AS "Employee & Job"
FROM employees;


-- Question 8: Employees who joined in January
SELECT emp_name
FROM employees
WHERE EXTRACT(MONTH FROM hire_date) = 1;


-- Question 9: Hired date, job, and name of employees who joined before 1992-12-31
SELECT hire_date, job_name, emp_name
FROM employees
WHERE hire_date < '1992-12-31';


-- Question 10: Employees with id, name, and salary with experience over 10 years
SELECT emp_id, emp_name, salary
FROM employees
WHERE EXTRACT(YEAR FROM AGE(hire_date)) > 10;


-- Question 11: Employees whose names contain 'AR'
SELECT emp_name
FROM employees
WHERE emp_name LIKE '%AR%';