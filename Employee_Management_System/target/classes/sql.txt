create table user_details( USER_ID    NOT NULL VARCHAR2(255 CHAR) ,
ADDRESS             VARCHAR2(255 CHAR) ,
EMAIL               VARCHAR2(255 CHAR) ,
FIRST_NAME          VARCHAR2(255 CHAR) ,
LAST_NAME           VARCHAR2(255 CHAR) ,
PASSWORD            VARCHAR2(255 CHAR) ,
EMP_ID              NUMBER(10));
 
select * from user_details;
desc user_details;
insert into user_details(user_Id,password,first_Name,last_Name,email,address,emp_id) values ('1','raja','raja','roy','abc@gmail.com','chennai',1);
insert into user_details(user_Id,password,first_Name,last_Name,email,address,emp_id) values ('3','akku','akku','roy','cdf@gmail.com','chennai',1);


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