create database test;
use test;
create table Article(
    id varchar(5) primary key ,
    title varchar(50),
    Date date
);
create table Author
(
    id  varchar(5),
    name varchar(10),
    institution varchar(50),
    gender varchar(1) check (gender = 'M' or gender = 'F'),
    dob date,
    aid varchar(5) foreign key references Article(id),
    primary key (id,aid)
);