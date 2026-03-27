--Number 2
/*
select emp_name
from employees
where manager_id is not null 
	and salary between 1500 and 2500;

-- Ans: ADELYN and TUCKER
*/

--Number 3
/*
select emp_name
from employees
where dep_id IN (
		select dep_id 
		from department
		where dep_location = 'SYDNEY'
);

-- Ans: KAYLING, CLARE, MARKER
*/

--Number 4
/*
select emp_name
from employees
where (	select grade 
		from salary_grade
		where employees.salary between min_sal and max_sal) = 2;
		
-- Ans: WADE, MADDEN, MARKER
*/

--Number 5
/*
select emp_name, 
	  (select grade 
		from salary_grade
		where employees.salary between min_sal and max_sal) as sal_grade
from employees
order by sal_grade;

--Ans:
*SANDRINE |         1
 JULIUS   |         1
 ADNRES   |         1
 MARKER   |         2
 MADDEN   |         2
 WADE     |         2
 ADELYN   |         3
 TUCKER   |         3
 FRANK    |         4
 SCARLET  |         4
 BLAZE    |         4
 JONAS    |         4
 CLARE    |         4
 KAYLING  |         5
**/

--Number 6
/*
select dep_name
from department
where dep_location = 'MELBOURNE';

--Ans: AUDIT
*/

--Number 7
/*
select concat(emp_name, ' ', job_name)
from employees;

--ANS:
*
*KAYLING PRESIDENT
 BLAZE MANAGER
 CLARE MANAGER
 JONAS MANAGER
 SCARLET ANALYST
 FRANK ANALYST
 SANDRINE CLERK
 ADELYN SALESMAN
 WADE SALESMAN
 MADDEN SALESMAN
 TUCKER SALESMAN
 ADNRES CLERK
 JULIUS CLERK
 MARKER CLERK
*/

--Number 8
/*
select emp_name
from employees
where date_part('MONTH', cast(hire_date as date)) = 1;

--Ans: MARKER
*/

--Number 9
/*
select hire_date, job_name, emp_name
from employees
where hire_date < '1992-12-31';

Ans:
*hire_date  | job_name  | emp_name
------------+-----------+----------
 1991-11-18 | PRESIDENT | KAYLING
 1991-05-01 | MANAGER   | BLAZE
 1991-06-09 | MANAGER   | CLARE
 1991-04-02 | MANAGER   | JONAS
 1991-12-03 | ANALYST   | FRANK
 1990-12-18 | CLERK     | SANDRINE
 1991-02-20 | SALESMAN  | ADELYN
 1991-02-22 | SALESMAN  | WADE
 1991-09-28 | SALESMAN  | MADDEN
 1991-09-08 | SALESMAN  | TUCKER
 1991-12-03 | CLERK     | JULIUS
 1992-01-23 | CLERK     | MARKER
*/

--Number 10
/*
select emp_id, emp_name, salary
from employees
where EXTRACT(YEAR FROM AGE(now(), hire_date)) > 10;

Ans:
emp_id | emp_name | salary
--------+----------+---------
  68319 | KAYLING  | 6000.00
  66928 | BLAZE    | 2750.00
  67832 | CLARE    | 2550.00
  65646 | JONAS    | 2957.00
  67858 | SCARLET  | 3100.00
  69062 | FRANK    | 3100.00
  63679 | SANDRINE |  900.00
  64989 | ADELYN   | 1700.00
  65271 | WADE     | 1350.00
  66564 | MADDEN   | 1350.00
  68454 | TUCKER   | 1600.00
  68736 | ADNRES   | 1200.00
  69000 | JULIUS   | 1050.00
  69324 | MARKER   | 1400.00
*/

/*
--Number 11
select emp_name
from employees
where emp_name like '%AR%';

Ans:
 emp_name
----------
 CLARE
 SCARLET
 MARKER
 */
