create table account(
    id int primary key,
    name varchar(20),
    balance int
);

insert into account values(1, 'kosta', 1000);
insert into account values(2, 'hong', 2000);

alter Table `account` add COLUMN `grade` varchar(20);