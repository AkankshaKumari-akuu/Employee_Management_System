 drop table "user" ;
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
VALUES('Raja','Raja','kumar','raja661@gmail.com',878956,'Ak','abc');
 
INSERT INTO "user"(userid,first,last,email,phone,password,address)
VALUES('Akanksha','Akanksha','Choudhary','Ac@gmail.com',878956,'Akanksha','abc');

commit;