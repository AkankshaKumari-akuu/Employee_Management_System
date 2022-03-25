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
VALUES('ib123','bittu','kumar','jackbabu661@gmail.com',878956,'ib','abc');
 
INSERT INTO "user"(userid,first,last,email,phone,password,address)
VALUES('bittu','bittu','indian','bittu@gmail.com',878956,'bittu','abc');

commit;