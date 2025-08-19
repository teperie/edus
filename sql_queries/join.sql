-- join
create table test1 (A VARCHAR(10));

create table test2 (B VARCHAR(20));

insert into test1 values ('a1');

insert into test1 values ('a2');

insert into test2 values ('b1');

insert into test2 values ('b2');

insert into test2 values ('b3');

select * from test1, test2 order by 1, 2;

select * from test1 join test2;

select e.empno, e.ename, e.job, e.deptno, d.dname, d.`LOC`
from emp e
    join dept d USING (deptno);

-- ANSI JOIN(표준 JOIN)
SELECT s.studno, s.name, s.deptno1, d.dname
from student s
    join department d on (s.deptno1 = d.deptno);

SELECT s.studno, s.name, s.deptno1, d.dname
from student s, department d
where
    s.deptno1 = d.deptno;

-- left join : 왼쪽 테이블에서 조인 조건 항목에 null인 행도 포함
-- student, professor : 학번, 이름, 담당교수번호, 담당교수명
SELECT s.studno as 학번, s.name as 이름, s.profno as 담당교수번호, p.name as 담당교수명
from student s
    left join professor p on (s.profno = p.profno);

-- student, department, professor : 학번, 이름, 학과명, 담당교수명 조회
SELECT s.studno as 학번, s.name as 이름, d.dname as 학과명, p.name as 담당교수명
from
    student s
    left join department d on (s.deptno1 = d.deptno)
    LEFT JOIN professor p USING (profno);

-- emp : 사번, 사원이름, 관리자 사번, 관리자 이름 조회
SELECT e.empno as 사번, e.ename as 사원이름, e.mgr as 관리자사번, p.name as 관리자이름
from emp e
    left join emp p on (e.mgr = p.empno);

-- student, department : 학번, 이름, 제1전공이름, 제2전공이름 조회
SELECT s.studno, s.NAME, d1.deptno, d1.dname, s.deptno2, d2.dname
FROM
    student AS s
    JOIN department AS d1 ON (s.deptno1 = d1.deptno)
    LEFT JOIN department AS d2 ON (s.deptno2 = d2.deptno);

-- emp2, dept2 : 사번, 이름, 관리자사번, 관리자 이름 조회
SELECT e.empno, e.name, e.pempno, p.name
FROM emp2 e
    LEFT JOIN emp2 p ON (e.pempno = p.EMPNO);

-- 학번, 이름, 학년, 점수, 학점
SELECT s.studno, s.name, s.grade, e.total, h.grade
FROM
    student AS s
    LEFT JOIN exam_01 AS e USING (studno)
    left JOIN hakjum AS h ON (
        e.total BETWEEN h.min_point AND h.max_point
    );

-- 고객의 이름, 보유포인트, 포인트로 받을 수 있는 가장 좋은 선물 조회


SELECT

.gname,

.point, gi.gname FROM gogak

left JOIN gift gi ON(

.point BETWEEN gi.g_start AND gi.g_end);

SELECT empno, NAME, YEAR(CURDATE()) - year(birthday) AS 나이, position
FROM emp2;

-- emp2, p_grade : 이름, 직위, 급여, 같은 직급의 최소급여, 같은 직급의 최대급여 조회
SELECT e.name, e.position, e.pay, p.s_pay, p.e_pay
FROM emp2 e
    left join p_grade p on (e.position = p.position);

-- emp2, p_grade : 본인의 직급에 해당하는 최대 급여보다 많이 받는 직원의
-- 이름, 직위, 급여, 같은 직급의 최소급여, 같은 직급의 최대급여 조회
SELECT e.name, e.position, e.pay, p.s_pay, p.e_pay
FROM emp2 e
    LEFT JOIN p_grade p USING (POSITION)
WHERE
    p.e_pay < e.PAY;

SELECT e.name, e.position, e.pay, p.s_pay, p.e_pay
FROM emp2 e, p_grade p
WHERE
    e.position = p.position
    and p.e_pay < e.PAY;

-- 본인의 나이에 해당하는 예상 직급
select format( datediff(curdate(), birthday) / 365, 0 ) from emp2;

select e.name, format(
        datediff(curdate(), e.birthday) / 365, 0
    ) as age, e.position, p.position
from emp2 e
    left join p_grade p ON (
        format(
            datediff(curdate(), e.birthday) / 365, 0
        ) BETWEEN p.s_age AND p.e_age
    );

-- emp2, dept2 : 포항 본사에서 일하는 직원 조회
-- 사번, 이름, 부서명
select e.empno, e.name, d.dname
from emp2 e
    left join dept2 d on (e.`DEPTNO` = d.`DCODE`)
where
    d.`AREA` = '포항본사';

-- 박승곤 교수가 담당하는 학생의 학번, 이름, 전공 조회
select s.studno, s.name, d.dname
from
    student s
    left join professor p USING (profno)
    left join department d on (s.deptno1 = d.deptno)
where
    p.name = '박승곤';

-- 제1전공이나 제2전공이 컴퓨터공학인 학생의 학번, 이름, 제1전공이름, 제2전공이름 조회
EXPLAIN
select s.studno, s.name, d1.dname, d2.dname
from
    student s
    left join department d1 on (s.deptno1 = d1.deptno)
    left join department d2 on (s.deptno2 = d2.deptno)
where
    d1.dname = '컴퓨터공학과'
    or d2.dname = '컴퓨터공학과';

-- 이윤나 학생이 담당교수로 선택할 수 있는 교수 이름 조회
SELECT p.name
FROM professor p
    left JOIN student s ON (
        p.deptno = s.deptno1
        OR p.deptno = s.deptno2
    )
WHERE
    s.`name` = '이윤나'

-- '이윤나' 고객이 받을 수 있는 선물 목록 조회
select gi.gname
from gift gi
    left join gogak gog on (gog.point >= gi.g_start)
where
    gog.gname = '이윤나';

-- 담당학생이 없는 교수 목록 조회
select s.studno, p.profno, p.name
from student s
    right join professor p using (profno)
where
    s.profno is null;

select p.name
from professor p
where
    p.profno not in(
        select profno
        from student
    );

-- 학점이 a인 학생의 학번, 이름, 학년, 학과명 조회
select s.studno, s.name, s.grade, d1.dname d1, d2.dname d2, e.total, h.grade
from
    student s
    left join exam_01 e using (studno)
    left join hakjum h on (
        e.total BETWEEN h.min_point AND h.max_point
    )
    left join department d1 on (s.deptno1 = d1.deptno)
    left join department d2 on (s.deptno2 = d2.deptno)
where
    h.grade like 'A_';

-- 학년별 평균 점수
explain
select s.grade, format(avg(e.total), 0) AS avg
from student s
    left join exam_01 e using(studno)
group by
    s.grade;