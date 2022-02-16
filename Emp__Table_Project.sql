create table Employee
(
id int primary key,
Name varchar(50) not null,
dateofjoining varchar(50),
Basic int
);
INSERT INTO Employee VALUES(1,'XXX','10.10.20','40000');
INSERT INTO Employee VALUES(2,'yyy','10.08.19','80000');

SELECT * FROM Employee;