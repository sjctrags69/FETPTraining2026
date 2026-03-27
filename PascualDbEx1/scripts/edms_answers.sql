/*
CREATE TABLE department (
    dep_id       INTEGER      NOT NULL,
    dep_name     VARCHAR(20),
    dep_location VARCHAR(15),
    CONSTRAINT pk_department      PRIMARY KEY (dep_id),
    CONSTRAINT uq_department_name UNIQUE      (dep_name)
);
*/

/*
INSERT INTO department (dep_id, dep_name, dep_location) VALUES
    (1001, 'FINANCE',    'SYDNEY'),
    (2001, 'AUDIT',      'MELBOURNE'),
    (3001, 'MARKETING',  'PERTH'),
    (4001, 'PRODUCTION', 'BRISBANE');
*/

/*
CREATE TABLE salary_grade (
    grade   INTEGER NOT NULL,
    min_sal INTEGER,
    max_sal INTEGER,
    CONSTRAINT pk_salary_grade PRIMARY KEY (grade)
);
*/

/*
INSERT INTO salary_grade (grade, min_sal, max_sal) VALUES
    (1,  800, 1300),
    (2, 1301, 1500),
    (3, 1501, 2100),
    (4, 2101, 3100),
    (5, 3101, 9999);
*/

/*
CREATE TABLE employees (
    emp_id     INTEGER      NOT NULL,
    emp_name   VARCHAR(15),
    job_name   VARCHAR(10),
    manager_id INTEGER,
    hire_date  DATE,
    salary     DECIMAL(10,2),
    commission DECIMAL(7,2),
    dep_id     INTEGER,
    CONSTRAINT pk_employees      PRIMARY KEY (emp_id),
    CONSTRAINT uq_employees_name UNIQUE      (emp_name)
);
*/

/*
INSERT INTO employees (emp_id, emp_name, job_name, manager_id, hire_date, salary, commission, dep_id) VALUES
    (68319, 'KAYLING',  'PRESIDENT', NULL,  '1991-11-18', 6000.00, NULL,    1001),
    (66928, 'BLAZE',    'MANAGER',   68319, '1991-05-01', 2750.00, NULL,    3001),
    (67832, 'CLARE',    'MANAGER',   68319, '1991-06-09', 2550.00, NULL,    1001),
    (65646, 'JONAS',    'MANAGER',   68319, '1991-04-02', 2957.00, NULL,    2001),
    (67858, 'SCARLET',  'ANALYST',   65646, '1997-04-19', 3100.00, NULL,    2001),
    (69062, 'FRANK',    'ANALYST',   65646, '1991-12-03', 3100.00, NULL,    2001),
    (63679, 'SANDRINE', 'CLERK',     69062, '1990-12-18',  900.00, NULL,    2001),
    (64989, 'ADELYN',   'SALESMAN',  66928, '1991-02-20', 1700.00,  400.00, 3001),
    (65271, 'WADE',     'SALESMAN',  66928, '1991-02-22', 1350.00,  600.00, 3001),
    (66564, 'MADDEN',   'SALESMAN',  66928, '1991-09-28', 1350.00, 1500.00, 3001),
    (68454, 'TUCKER',   'SALESMAN',  66928, '1991-09-08', 1600.00,    0.00, 3001),
    (68736, 'ADNRES',   'CLERK',     67858, '1997-05-23', 1200.00, NULL,    2001),
    (69000, 'JULIUS',   'CLERK',     66928, '1991-12-03', 1050.00, NULL,    3001),
    (69324, 'MARKER',   'CLERK',     67832, '1992-01-23', 1400.00, NULL,    1001);
*/

-- ============================================================
-- Q2
SELECT emp_name
FROM employees
WHERE job_name = 'MANAGER'
  AND salary BETWEEN 1500 AND 2500;

-- 3 managers (BLAZE=2750, CLARE=2550, JONAS=2957)
-- ============================================================

-- ============================================================
--Q3

SELECT emp_name
FROM employees
WHERE dep_id = (
    SELECT dep_id
    FROM department
    WHERE dep_location = 'SYDNEY'
);

--    KAYLING, CLARE, MARKER 
-- ============================================================

-- ============================================================
-- Q4

SELECT emp_name, salary
FROM employees
WHERE job_name = 'SALESMAN'
  AND salary BETWEEN
      (SELECT min_sal FROM salary_grade WHERE grade = 2)
  AND (SELECT max_sal FROM salary_grade WHERE grade = 2);

--    emp_name | salary
--   ----------+---------
--    WADE     | 1350.00
--    MADDEN   | 1350.00

-- ============================================================

-- ============================================================
--Q5
SELECT emp_name,
       salary,
       (SELECT grade
        FROM salary_grade
        WHERE employees.salary BETWEEN min_sal AND max_sal) AS salary_grade
FROM employees
ORDER BY salary_grade;

-- EXPECTED OUTPUT (sorted by grade):
--    emp_name  | salary  | salary_grade
--   -----------+---------+--------------
--    SANDRINE  |  900.00 |      1
--    JULIUS    | 1050.00 |      1
--    ADNRES    | 1200.00 |      1
--    WADE      | 1350.00 |      2
--    MADDEN    | 1350.00 |      2
--    MARKER    | 1400.00 |      2
--    TUCKER    | 1600.00 |      3
--    ADELYN    | 1700.00 |      3
--    BLAZE     | 2750.00 |      4
--    CLARE     | 2550.00 |      4
--    JONAS     | 2957.00 |      4
--    SCARLET   | 3100.00 |      4
--    FRANK     | 3100.00 |      4
--    KAYLING   | 6000.00 |      5

-- ============================================================

-- ============================================================
-- Q6

SELECT dep_name
FROM department
WHERE dep_location = 'MELBOURNE';

--    AUDIT
-- ============================================================

SELECT emp_name || ' & ' || job_name AS "Employee & Job"
FROM employees;


SELECT emp_name, hire_date
FROM employees
WHERE EXTRACT(MONTH FROM hire_date) = 1;


SELECT hire_date, job_name, emp_name
FROM employees
WHERE hire_date < '1992-12-31';


SELECT emp_id,
       emp_name,
       salary,
       EXTRACT(YEAR FROM AGE(hire_date)) AS years_experience
FROM employees
WHERE EXTRACT(YEAR FROM AGE(hire_date)) > 10;


SELECT emp_name
FROM employees
WHERE emp_name LIKE '%AR%';
