
-- Item A
create table province_names(
	province_id char(2) not null primary key,
	province_name varchar(30) not null
);


create table doctors(
	doctor_id integer not null primary key,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	specialty varchar(25) not null
);


create table patients(
	patient_id integer not null primary key,
	first_name varchar(30) not null,
	last_name varchar(30) not null,
	gender char(1),
	birth_date date,
	city varchar(30),
	province_id char(2),
	allergies varchar(80),
	height decimal(3,0),
	weight decimal(4,0),
	foreign key (province_id) references province_names(province_id)
);


create table admissions(
	patient_id integer not null,
	admission_date date not null,
	discharge_date date,
	diagnosis varchar(50),
	attending_doctor_id integer,
	foreign key (patient_id) references patients(patient_id),
	foreign key (attending_doctor_id) references doctors(doctor_id)
);



-- Item B

-- 1. DDL Transactions

-- a.)
update patients
set allergies = 'NKA'
where allergies is null;


-- b.)
delete from admissions
where patient_id in (
	select patient_id
	from patients
	where first_name = 'Penelope'
);

delete from patients
where first_name = 'Penelope';


-- c.)

with discharged_patients as (
	select distinct patient_id
	from admissions
	where discharge_date is not null
),
deleted_admissions as (
	delete from admissions
	where patient_id in (
		select patient_id
		from discharged_patients
	)
	returning patient_id
)
delete from patients
where patient_id in (
	select patient_id
	from discharged_patients
);


-- 2. Single-row transactions without JOIN 

-- a.)

select first_name, last_name, gender
from patients
where gender = 'M';


-- b.) 

select first_name, last_name
from patients
where allergies is null
or allergies = '';


-- c.)

select first_name
from patients
where first_name like 'C%';


-- d.)

select (max(weight) - min(weight)) as weight_difference
from patients
where last_name = 'Maroni';


-- e.)

select first_name, last_name, birth_date
from patients
where birth_date between '1970-01-01' and '1979-12-31'
order by birth_date asc;


-- f.)

select *
from patients
where patient_id in (1, 45, 534, 879, 1000);


-- g.)

select first_name, last_name, allergies, city
from patients
where allergies is not null
and city = 'Hamilton';


-- h.)

select first_name, last_name, weight
from patients
where weight between 100 and 120;


-- i.)

select patient_id, weight, height,
	case
		when weight / power(height / 100.0, 2) >= 30 then 1
		else 0
	end as isObese
from patients;


-- 3. Single-row transactions with JOIN

-- a.)

select patients.patient_id, patients.first_name, patients.last_name, doctors.specialty
from patients, admissions, doctors
where patients.patient_id = admissions.patient_id
and admissions.attending_doctor_id = doctors.doctor_id;


-- b.)

select patients.first_name, patients.last_name
from patients, admissions, doctors
where patients.patient_id = admissions.patient_id
and admissions.attending_doctor_id = doctors.doctor_id
and admissions.diagnosis = 'Epilepsy'
and doctors.first_name = 'Lisa';


-- c.)

select patients.first_name, patients.last_name, province_names.province_name
from patients, province_names
where patients.province_id = province_names.province_id;


-- d.)

select doctors.doctor_id,
       doctors.first_name || ' ' || doctors.last_name as full_name,
       min(admissions.admission_date) as first_admission_date,
       max(admissions.admission_date) as last_admission_date
from doctors, admissions
where doctors.doctor_id = admissions.attending_doctor_id
group by doctors.doctor_id, doctors.first_name, doctors.last_name;


-- e.)

select distinct patients.patient_id,
       patients.patient_id::varchar ||
       length(patients.last_name)::varchar ||
       extract(year from patients.birth_date)::varchar as temp_password
from patients, admissions
where patients.patient_id = admissions.patient_id;


-- 4. Multiple-row transactions

-- a.) 

select first_name
from patients
group by first_name
having count(*) = 1;


-- b.)

select *
from admissions
where patient_id = 542
and admission_date = (
	select max(admission_date)
	from admissions
	where patient_id = 542
);


-- c.) 

select doctors.doctor_id, doctors.first_name, doctors.last_name, count(*) as total_admissions
from doctors, admissions
where doctors.doctor_id = admissions.attending_doctor_id
group by doctors.doctor_id, doctors.first_name, doctors.last_name;


-- d.)

select province_id, count(*) as total_patients
from patients
group by province_id
order by total_patients desc;


-- e.)

select province_id, sum(height) as total_height
from patients
group by province_id
having sum(height) >= 7000;


-- f.) 

select patient_id, diagnosis
from admissions
group by patient_id, diagnosis
having count(*) > 1;