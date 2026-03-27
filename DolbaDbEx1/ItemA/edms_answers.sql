-- A1. Create database, tables, and initial data
-- Database selection/creation can be done outside this script in PostgreSQL.

CREATE TABLE department (
    dep_id INTEGER PRIMARY KEY,
    dep_name VARCHAR(20) NOT NULL,
    dep_location VARCHAR(15) NOT NULL
);

CREATE TABLE salary_grade (
    grade INTEGER PRIMARY KEY,
    min_sal INTEGER NOT NULL,
    max_sal INTEGER NOT NULL
);

CREATE TABLE employees (
    emp_id INTEGER PRIMARY KEY,
    emp_name VARCHAR(15) NOT NULL,
    job_name VARCHAR(10) NOT NULL,
    manager_id INTEGER NULL,
    hire_date DATE NOT NULL,
    salary DECIMAL(10,2) NOT NULL,
    commission DECIMAL(7,2) NULL,
    dep_id INTEGER NOT NULL
);

-- department seed data
INSERT INTO department (dep_id, dep_name, dep_location) VALUES
(1001, 'FINANCE', 'SYDNEY'),
(2001, 'AUDIT', 'MELBOURNE'),
(3001, 'MARKETING', 'PERTH'),
(4001, 'PRODUCTION', 'BRISBANE');

-- salary grade seed data
INSERT INTO salary_grade (grade, min_sal, max_sal) VALUES
(1, 800, 1300),
(2, 1301, 1500),
(3, 1501, 2100),
(4, 2101, 3100),
(5, 3101, 9999);

-- employee seed data
INSERT INTO employees (emp_id, emp_name, job_name, manager_id, hire_date, salary, commission, dep_id) VALUES
(68319, 'KAYLING', 'PRESIDENT', NULL, '1991-11-18', 6000.00, NULL, 1001),
(66928, 'BLAZE', 'MANAGER', 68319, '1991-05-01', 2750.00, NULL, 3001),
(67832, 'CLARE', 'MANAGER', 68319, '1991-06-09', 2550.00, NULL, 1001),
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

-- A2. Names of managers with salary between 1500 and 2500
SELECT emp_name
FROM employees
WHERE job_name = 'MANAGER'
  AND salary BETWEEN 1500 AND 2500;

-- A3. Names of employees who work in Sydney
SELECT emp_name
FROM employees, department
WHERE employees.dep_id = department.dep_id
  AND dep_location = 'SYDNEY';

-- A4. Salesmen who earn a salary of grade 2
SELECT emp_name
FROM employees, salary_grade
WHERE employees.salary BETWEEN salary_grade.min_sal AND salary_grade.max_sal
  AND employees.job_name = 'SALESMAN'
  AND salary_grade.grade = 2;

-- A5. Salary grade of each employee (sorted by salary grade)
SELECT employees.emp_id, employees.emp_name, employees.salary, salary_grade.grade
FROM employees, salary_grade
WHERE employees.salary BETWEEN salary_grade.min_sal AND salary_grade.max_sal
ORDER BY salary_grade.grade, employees.emp_name;

-- A6. Departments located in Melbourne
SELECT dep_id, dep_name
FROM department
WHERE dep_location = 'MELBOURNE';

-- A7. Employee name and job name in format: "Employee & Job"
SELECT emp_name || ' & ' || job_name AS employee_and_job
FROM employees;

-- A8. Employees who joined in January
SELECT emp_id, emp_name, hire_date
FROM employees
WHERE EXTRACT(MONTH FROM hire_date) = 1;

-- A9. Hired date, job, and employee name who joined before 1992-12-31
SELECT hire_date, job_name, emp_name
FROM employees
WHERE hire_date < '1992-12-31'
ORDER BY hire_date;

-- A10. ID, name, and salary with experience over 10 years
SELECT emp_id, emp_name, salary
FROM employees
WHERE hire_date < (CURRENT_DATE - INTERVAL '10 years');

-- A11. Employees whose names contain the character set 'AR'
SELECT emp_id, emp_name
FROM employees
WHERE emp_name LIKE '%AR%';
