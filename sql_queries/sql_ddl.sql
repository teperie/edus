-- ------------------------------------------------------------------------------------
-- DDL (Data Definition Language) : create(생성), alter(수정), drop(삭제), truncate(잘라내기), rename(이름바꾸기)
-- ------------------------------------------------------------------------------------
-- DCL (Data Control Language) : grant(권한주기), revoke(권한빼기)
-- ------------------------------------------------------------------------------------
-- TCL (Transaction Control Language) : commit(확정), rollback(취소)
-- ------------------------------------------------------------------------------------
-- DQL (Data Query Language) : select(조회)
-- ------------------------------------------------------------------------------------
-- DML (Data Manipulation Language) : insert(삽입), update(수정), delete(삭제)
-- ------------------------------------------------------------------------------------
-- CRUD (Create, Read, Update, Delete) : 데이터를 넣고(insert) 읽고(select) 수정하고(update) 삭제하는 것(delete)
-- ------------------------------------------------------------------------------------

-- database(schema) 생성
create database mydb;
drop database mydb;

use mydb;

create table persons(
    id int,
    last_name varchar(255),
    first_name varchar(255),
    address varchar(255),
    city VARCHAR(255)
);

-- 컬럼 타입 참조
-- https://www.w3schools.com/mysql/mysql_datatypes.asp

-- 테이블 삭제
drop table persons;

use testdb;
-- create table as
create table emp_sub1 as
select empno, ename, job, hiredate, sal from emp where deptno=10;

-- emp, dept 테이블을 이용하여 emp_dept 테이블 생성
-- 컬럼 : emp의 모든 컬럼과 dept의 부서명
create table emp_dept as
select e.*, d.dname
from emp e join dept d
using(deptno);

-- 데이터를 제외하고 테이블의 틀만 복사해서 새로운 테이블 생성
create table emp_cpy as
select * from emp where 1=2;

-- 테이블 비우기
truncate table emp_dept;

-- ----------------------
-- alter table
-- ----------------------
-- add column : 컬럼 추가
alter table persons add column email varchar(255);

-- drop column : 컬럼 삭제
alter table persons drop column email;

-- modify column : 컬럼 수정
alter table persons modify column email varchar(300);

-- rename column : 컬럼 이름 변경
alter table persons rename column city to area;

create table dept_t as
select * from dept;

-- dept_t 테이블에 loc2 컬럼 추가, 크기 255, 기본값 'SEOUL'
alter table dept_t add column loc2 varchar(255) default 'SEOUL';

-- loc2를 area로 변경
alter table dept_t rename column loc2 to area;

-- table 이름 변경
rename table dept_t to dept_temp;

drop table emp_sub1;

COMMIT;