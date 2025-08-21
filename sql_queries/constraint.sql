-- ------------------------------------------------------------------------------------
-- constraint : 제약조건
-- ------------------------------------------------------------------------------------
-- not null, unique, primary key, foreign key, check
-- ------------------------------------------------------------------------------------

create table temp (
    id int primary key,
    name varchar(20) not NULL
);

insert into temp values (null, 'jang');
-- primary key는 null이 될 수 없다
insert into temp values (1, 'jang');

insert into temp values (1, 'song');
-- primary key는 중복될 수 없다
insert into temp VALUES (2, null);
-- name은 null 허용하지 않음

-- unique
create table temp2 (email varchar(50) unique);

insert into temp2 values ('kosta@kosta.com');

insert into temp2 values ('kosta@kosta.com');

-- check
create table temp3 (
    name varchar(20) not NULL,
    age int default 1 check (age > 0)
);

insert into temp3 (name) values ('hong');
-- age default 1
insert into temp3 (name, age) values ('song', -10);
-- age check 제한 벗어남

drop table article;

drop table user;

-- foreign key : 다른 테이블의 특정 칼럼에 있는 값만 삽입이 가능하도록 관계를 맺는 것
-- 참조되는 테이블을 부모 테이블, 참조하는 테이블을 자식 테이블로 간주
-- 참조되는 테이블의 row를 참조하는 데이터가 있으면 삭제나 변경이 불가능

create table user (
    id varchar(20) primary key,
    name varchar(20) not null
);

create table article (
    num int AUTO_INCREMENT primary key,
    title varchar(20) not null,
    content varchar(1000),
    writer varchar(20) references user (id) -- user 테이블에 존재하는 id만 삽입 가능, 단 null 허용
);

insert into user values ('hong', '홍길동');

insert into
    article (title, content, writer)
values ('제목1', '내용1', 'hong');
-- success
insert into
    article (title, content, writer)
values ('제목2', '내용2', 'song');
-- error
insert into
    article (title, content, writer)
values ('제목3', '내용3', null);
-- foreign key : null 허용

delete from user where id = 'hong';
-- error: article 테이블에 hong이 참조되고 있음
delete from article where writer = 'hong';

delete from user where id = 'hong';
-- success: article 테이블에서 참조되지 않은 데이터 삭제 가능

update user set id = 'gong' where id = 'hong';
-- error: article 테이블에 hong이 참조되고 있음
update user set name = '길동이' where id = 'hong';

delete from article where writer = 'hong';

-- 제약조건 방식 2
drop table article;

create table article (
    num int AUTO_INCREMENT,
    title varchar(50) not null,
    content varchar(50),
    writer varchar(20),
    primary key (num),
    foreign key (writer) references user (id)
);

-- 제약조건 방식 3
drop table article;

create table article (
    num INT,
    title varchar(50) not null,
    content varchar(50),
    writer varchar(20)
);

alter table article add primary key (num);
-- primary key 추가
alter table article drop PRIMARY key;

alter table article add constraint ARTICLE_PK primary key (num);

alter table article
add constraint ARTICLE_USER_FK foreign key (writer) references `user` (id);

alter table user add PRIMARY key (id);

alter table article drop article_user_fk;

create table dept3(
    dcode varchar(6) primary key,
    dname varchar(30) not null,
    pdept varchar(6),
    area varchar(20)
);

create table tcons(
    no int, -- primary key
    name varchar(20), -- not null
    jumin varchar(13), -- not null, unique
    area int, -- check 1, 2, 3, 4
    deptno VARCHAR(6) -- foreign key
);
alter table tcons add primary key (no);
alter table tcons MODIFY COLUMN name VARCHAR(20) NOT NULL;
alter table tcons MODIFY COLUMN jumin VARCHAR(13) NOT NULL;
alter table tcons add constraint TCONS_JUMIN_UQ unique (jumin);
alter table tcons add constraint TCONS_AREA_CK check (area in (1, 2, 3, 4));
alter table tcons add constraint TCONS_DEPTNO_FK foreign key (deptno) references dept3 (dcode);

-- 제약조건 삭제
-- primary key
alter table tcons drop primary key;
-- not null
alter table tcons modify column name varchar(20);
-- unique
alter table tcons drop constraint TCONS_JUMIN_UQ;
-- check
alter table tcons drop constraint TCONS_AREA_CK;
-- foreign key
alter table tcons drop constraint TCONS_DEPTNO_FK;

set autocommit = 1;

commit;