-- GalquieraDbEx1 query answers

-- 2. What are the names of managers that have a salary between 1500 and 2500?
SELECT emp_name
FROM employees
WHERE job_name = 'MANAGER'
AND salary >= 1500
AND salary <= 2500;

-- 3. What are the names of the employees that work in Sydney?
SELECT emp_name
FROM employees
WHERE dep_id = 1001;

-- 4. Which salesmen earn a salary of grade 2?
SELECT emp_name, salary
FROM employees
WHERE job_name = 'SALESMAN'
AND salary >= 1301
AND salary <= 1500;

-- 5. What is the salary grade of each employee? (Sort the output according to the salary grades.)
SELECT emp_name, salary,
CASE
    WHEN salary >= 800 AND salary <= 1300 THEN 1
    WHEN salary >= 1301 AND salary <= 1500 THEN 2
    WHEN salary >= 1501 AND salary <= 2100 THEN 3
    WHEN salary >= 2101 AND salary <= 3100 THEN 4
    WHEN salary >= 3101 AND salary <= 9999 THEN 5
END AS grade
FROM employees;

-- 6. Which are the departments that are located in Melbourne?
SELECT dep_id, dep_name, dep_location
FROM department
WHERE dep_location = 'MELBOURNE';

-- 7. Write a query in SQL to produce the output of employees name and job name in a format: "Employee & Job"
SELECT emp_name || ' & ' || job_name as "Employee & Job"
FROM employees;

-- 8. Write a query in SQL to list the employees who joined in the month January.
SELECT emp_id, emp_name, hire_date
FROM employees
WHERE hire_date >= '1991-01-01'
AND hire_date <= '1991-01-31'
OR hire_date >= '1992-01-01'
AND hire_date <= '1992-01-31';

-- 9. Write a query in SQL to list the hired date, job, and employee name who joined the company before 1992-12-31
SELECT hire_date, job_name, emp_name
FROM employees
WHERE hire_date < '1992-12-31';

-- 10. Write a query in SQL to list the id, name, and salary with an experience over 10 years
SELECT emp_id, emp_name, salary
FROM employees
WHERE hire_date <= '2016-01-01';

-- 11. Write a query in SQL to list the employees whose names containing the character set 'AR' together
SELECT emp_id, emp_name
FROM employees
WHERE emp_name LIKE '%AR%';