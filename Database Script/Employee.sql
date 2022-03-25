drop table Employee;

create table Employee(
ID  NUMBER(10)  NOT NULL  ,       
BASIC_PAY  FLOAT(126)  ,       
DA         FLOAT(126),         
DATE_OF_JOINING    VARCHAR2(255 CHAR) ,
GROSS    FLOAT(126),       
HRA   FLOAT(126) ,        
NAME  VARCHAR2(255 CHAR),
NET   FLOAT(126),  
TAX    FLOAT(126),
primary key (ID)
                 );

insert into Employee(ID,NAME,DATE_OF_JOINING,BASIC_PAY,DA,HRA,GROSS,TAX,NET) values (55,'akku','2022-03-15',50000,20,1600,10000,0,10000);
commit;
