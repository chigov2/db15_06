create table person
(
id integer not null,
name varchar(255) not null,
location varchar(255),
birth_date timestamp,
primary key(id)
);

INSERT INTO PERSON
(ID,NAME,LOCATION,BIRTH_DATE)
VALUES(817,'MIKEEE','Chigov',now());
INSERT INTO PERSON
(ID,NAME,LOCATION,BIRTH_DATE)
VALUES(1000,'Max','Stoba',now());
INSERT INTO PERSON
(ID,NAME,LOCATION,BIRTH_DATE)
VALUES(1001,'MIKE','Herasim',now());

