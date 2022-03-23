 create table "user"(
    userid varchar2(255) not null,
    address varchar2(255),
    email varchar2(255),
    first varchar2(255),
    last varchar2(255),
    password varchar2(255),
    phone number(19),
    primary key (userid)
);
 
INSERT INTO "user"(userid,first,last,email,phone,password,address)
VALUES(ak23,akku,kumari,jackbabu661@gmail.com,878956,ak,abc);
 
INSERT INTO "user"(userid,first,last,email,phone,password,address)
VALUES(pawan,pawan,kumar,pawan@gmail.com,878956,pawan,abc);

create table Employee(ID NOT NULL NUMBER(10)  ,       
BASIC_PAY                FLOAT(126)  ,       
DA                       FLOAT(126),         
DATE_OF_JOINING          VARCHAR2(255 CHAR) ,
GROSS                    FLOAT(126)  ,       
HRA                      FLOAT(126) ,        
NAME                     VARCHAR2(255 CHAR) ,
NET                      FLOAT(126)   ,  
TAX                      FLOAT(126)  );
insert into Employee(ID,NAME,DATE_OF_JOINING,BASIC_PAY,DA,HRA,GROSS,TAX,NET) values (55,'akku','2022-03-15',50000,20,1600,10000,0,10000);
commit;

select * from Employee;
desc Employee;