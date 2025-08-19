-- case
-- emp 테이블에서
-- deptno가 10이면 'accounting',
-- deptno가 20이면 'research',
-- deptno가 30이면 'sales',
-- deptno가 40이면 'operations'

SELECT
    empno,
    ename,
    case
        when deptno = 10 then 'accounting'
        when deptno = 20 then 'research'
        when deptno = 30 then 'sales'
        when deptno = 40 then 'operations'
    END AS dname,
    deptno
FROM emp;

SELECT
    empno,
    ename,
    case deptno
        when 10 then 'accounting'
        when 20 then 'research'
        when 30 then 'sales'
        when 40 then 'operations'
        else 'none'
    END AS dname,
    deptno
FROM emp;

-- exam_01 : total이 90점 이상이면 A, ... 60점 이상이면 D 나머지는 F
SELECT
    studno,
    total,
    CASE
        WHEN total >= 90 THEN 'A'
        WHEN total >= 80 THEN 'B'
        WHEN total >= 70 THEN 'C'
        WHEN total >= 60 THEN 'D'
        ELSE 'F'
    END AS grade
FROM exam_01;

-- student : 주민번호를 이용하여 성별을 조회
-- 주민번호 7번째 자리가 1이나 3이면 MAN, 2나 4이면 WOMAN으로 조회
-- 이름, 주민번호, 성별
SELECT
    name,
    jumin,
    case substr(jumin, 7, 1)
        when '1' then 'MAN'
        when '3' then 'MAN'
        when '2' then 'WOMAN'
        when '4' then 'WOMAN'
    END AS gender
FROM student

-- student : 학생의 이름, 전화번호, 지역 조회
-- 단, 지역은 전화번호의 지역번호로,
-- 02: 서울, 031: 경기도, 051: 부산, 052: 울산, 053: 대구, 055: 경남으로 표시
select
    name,
    tel,
    case substr(tel, 1, instr(tel, ')') - 1)
        when '02' then '서울'
        when '031' then '경기도'
        when '051' then '부산'
        when '052' then '울산'
        when '053' then '대구'
        when '055' then '경남'
    end as region
from student

-- student : 생년월일을 참조하여 태어난 달과 분기 조회
-- 태어난 달이 1~3월이면 1/4분기
-- 태어난 달이 4~6월이면 2/4분기
-- 태어난 달이 7~9월이면 3/4분기
-- 태어난 달이 10~12월이면 4/4분기
-- 이름, 생년월일, 태어난 달, 분기
SELECT
    name,
    birthday,
    month(birthday),
    case
        when month(birthday) between 1 and 3  then '1/4분기'
        when month(birthday) between 4 and 6  then '2/4분기'
        when month(birthday) between 7 and 9  then '3/4분기'
        when month(birthday) between 10 and 12  then '4/4분기'
    end as quarter
from student;

select
    name,
    birthday,
    month(birthday) 달,
    case extract(
            quarter
            from birthday
        )
        when 1 then '1/4분기'
        when 2 then '2/4분기'
        when 3 then '3/4분기'
        when 4 then '4/4분기'
    end as quarter
from student;

select name 이름, birthday 생일, month(birthday) "태어난 달", concat(
        extract(
            quarter
            from birthday
        ), '/4분기'
    ) as quarter
from student;

-- professor : 학과번호, 교수명, 학과명 조회
-- 단, 학과번호가 101인 교수만 학과명을 'Computer Engineering'으로 하고 나머지는 아무것도 출력하지 않음
SELECT
    deptno,
    NAME,
    case
        when deptno = 101 then 'Computer Engineering'
        ELSE ''
    END AS dname
FROM professor;