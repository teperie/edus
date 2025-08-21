-- ------------------------------------------------------------------------------------
-- DML (Data Manipulation Language) : insert(삽입), update(수정), delete(삭제)
-- ------------------------------------------------------------------------------------
-- insert into table_name (column1, column2, column3, ...)
-- values (value1, value2, value3, ...);
-- ------------------------------------------------------------------------------------
use testdb;

create table user ( id varchar(10), name varchar(20) );

insert into user (id, name) values ('hong', '홍길동');

insert into user (name, id) values ('고길동', 'gogo');

insert into user VALUES ('song', '송길동');
-- 모든 컬럼을 삽입 시 컬럼 목록 생략 가능. 단, 컬럼 순서대로 입력
insert into user (id) values ('park');
-- 일부 컬럼만 삽입 시 컬럼 목록 생략 불가능

create table article (
    num int auto_increment primary key,
    title varchar(50),
    content varchar(1000),
    writer varchar(30)
)

-- article data insert
-- 1. 'title1', 'content1'
insert into article (title, content) values ('title1', 'content1');
-- 2. 'title2'
insert into article (title) values ('title2');
-- 3. 'content3'
insert into article (content) values ('content3');
-- 4. 'title4', 'content4', 'hong'
insert into
    article (title, content, writer)
values ('title4', 'content4', 'hong');
-- 5. 'title5', 'gong'
insert into article (title, writer) values ('title5', 'gong');
-- 6. 'content6', 'park'
insert into article (content, writer) values ('content6', 'park');

-- insert into select : select의 결과물을 테이블에 삽입
create table emp_sub2 (id int, name varchar(30));

insert into
    emp_sub2 (id, name)
select empno, ename
from emp
where
    deptno = 10;

-- ----------------------------------------------------------
select @@AUTOCOMMIT;

set autocommit = 1;

update user set name = '공길동' where id = 'kong';

update user set name = '코길동' where id = 'kong';

-- ------------------------------------------
-- update table_name set column_name1 = value1, column_name2 = value2 where condition;

insert into
    emp
values (
        9999,
        'gildong',
        'SALES',
        7521,
        curdate(),
        400,
        0,
        10
    );

-- gildong의 담당업무를 'clerk'로 변경, 담당매니저를 7782로 변경
update emp set job = 'CLERK', mgr = '7782' where ename = 'GILDONG';

-- emp : comm이 없는 사람은 100을 준다
update emp set comm = 100 where ifnull(comm, 0) = 0;

-- emp : 부서번호가 10인 부서만 comm을 급여의 10% 더 준다
update emp set comm = sal * 0.1 where deptno = 10;

-- emp : smith와 같은 업무를 담당하는 사람들의 급여를 30% 인상
update emp
set
    sal = sal * 1.3
where
    job = (
        select job
        from emp
        where
            ename = 'SMITH'
    );

-- -----------------------------------------
-- delete from table_name where 조건;
-- -----------------------------------------
-- emp : 이름이 gildong인 데이터 삭제
DELETE from emp where ename = 'gildong';

delete from dept_temp where deptno = 40;

start TRANSACTION;
-- rollback이나 commit까지를 한 단위로 묶음(복구 또는 영구적 반영 위해)
delete from emp_sub2;
rollback;
commit;

start TRANSACTION;
delete from article WHERE writer = 'park';
update article set writer ='song' where num =1;
delete from article where writer = 'gong';
rollback;
commit;

UPDATE article set writer ='park' where num=4;
rollback;

commit;

rollback;