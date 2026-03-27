-- Number 2
SELECT emp_name
FROM employees
WHERE job_name = 'MANAGER'
AND salary BETWEEN 1500 AND 2500;

--Number 3
SELECT emp_name
FROM employees
WHERE dep_id IN (
    SELECT dep_id
    FROM department
    WHERE dep_location = 'SYDNEY');

--Number 4
SELECT emp_name
FROM employees
WHERE job_name = 'SALESMAN'
AND salary BETWEEN (
    SELECT min_salary FROM salary_grade WHERE grade = 2
) AND (
    SELECT max_salary FROM salary_grade WHERE grade = 2
);

--Number 5
SELECT emp_name,
(
    SELECT grade
    FROM salary_grade
    WHERE employees.salary BETWEEN min_salary AND max_salary
) AS salary_grade
FROM employees
ORDER BY salary_grade;

--Number 6
SELECT dep_name
FROM department
WHERE dep_location = 'MELBOURNE';

--Number 7
SELECT emp_name || ' & ' || job_name AS "Employee & Job"
FROM employees;

--Number 8
SELECT emp_name
FROM employees
WHERE EXTRACT(MONTH FROM hire_date) = 1;

--Number 9
SELECT hire_date, job_name, emp_name
FROM employees
WHERE hire_date < '1992-12-31';

--Number 10
SELECT emp_id, emp_name, salary
FROM employees
WHERE AGE(hire_date) > INTERVAL '10 years';

--Number 11
SELECT emp_name
FROM employees
WHERE emp_name LIKE '%AR%';
