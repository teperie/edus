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
mydbmydbmydb
use mydb;

CREATE TABLE persons(
    id int,
    last_name varchar(255),
    first_name varchar(255),
    address varchar(255),
    city VARCHAR(255)
);