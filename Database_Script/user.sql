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
VALUES('100','Akanksha','Choudhary','Ac@gmail.com',878956,'U2FsdGVkX1/lHopzF3zhfA7y8/pwfKzBiCA1YvZm5OE=','abc');
INSERT INTO "user"(userid,first,last,email,phone,password,address)
VALUES('101','Akku','Choudhary','Ac@gmail.com',878956,'UU2FsdGVkX1/WVNbFe3tyj9W5l5VP1AMzfxY+6YkiwE0=','abc');


commit;
