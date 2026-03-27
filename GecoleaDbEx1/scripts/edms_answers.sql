\echo 2. Names of managers with salary between 1500 and 2500
SELECT emp_name
FROM employees
WHERE job_name = 'MANAGER'
  AND salary >= 1500
  AND salary <= 2500;

\echo 3. Names of employees working in Sydney
SELECT emp_name
FROM employees
WHERE dep_id = 1001;

\echo 4. Salesmen earning salary grade 2
SELECT emp_name
FROM employees
WHERE job_name = 'SALESMAN'
  AND salary >= 1301
  AND salary <= 1500;

\echo 5. Salary grade of each employee (sorted by grade)
SELECT emp_name, salary,
(
    SELECT grade
    FROM salary_grade
    WHERE employees.salary BETWEEN min_salary AND max_salary
) AS grade
FROM employees
ORDER BY grade;

\echo 6. Departments located in Melbourne
SELECT dep_name
FROM department
WHERE dep_location = 'MELBOURNE';

\echo 7. Employee & Job format
SELECT emp_name || ' & ' || job_name AS "Employee & Job"
FROM employees;

\echo 8. Employees who joined in January
SELECT emp_name
FROM employees
WHERE EXTRACT(MONTH FROM hire_date) = 1;

\echo 9. Hired date, job, and employee name before 1992-12-31
SELECT hire_date, job_name, emp_name
FROM employees
WHERE hire_date < '1992-12-31';

\echo 10. Employees with more than 10 years experience
SELECT emp_id, emp_name, salary
FROM employees
WHERE hire_date < '2016-03-26';

\echo 11. Employees whose names contain 'AR'
SELECT emp_name
FROM employees
WHERE emp_name LIKE '%AR%';