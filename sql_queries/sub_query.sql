-- sub query

-- select
-- from table
-- where 조건연산자 (select column1, column2, ... from table where 조건);

-- 조건연산자 : =, <>(!=), >, <, >=, <= : 단일행 서브쿼리 연산자
-- 조건연산자 : in, exists, >any, <any, >all, <all : 다중행 서브쿼리 연산자

-- student, exam_01, hakjum : 학점이 A0인 학생의 학번, 이름, 점수 조회
-- join
SELECT s.studno, s.name, e.total
FROM
    student s
    JOIN exam_01 e ON s.studno = e.studno
    JOIN hakjum h ON (
        e.total BETWEEN h.min_point AND h.max_point
    )
WHERE
    h.grade = 'A0';

-- sub query
SELECT s.studno, s.name, e.total
FROM student s
    JOIN exam_01 e ON s.studno = e.studno
WHERE
    e.total BETWEEN (
        SELECT min_point
        FROM hakjum
        WHERE
            grade = 'A0'
    ) AND (
        SELECT max_point
        FROM hakjum
        WHERE
            grade = 'A0'
    );

-- emp : CLARK 보다 급여를 많이 받는 사원의 사번, 이름, 급여 조회
SELECT empno, ename, sal
FROM emp
WHERE
    sal > (
        SELECT sal
        FROM emp
        WHERE
            ename = 'CLARK'
    );

SELECT e1.empno, e1.ename, e1.sal
FROM emp e1
    JOIN emp e2 ON e1.SAL > e2.SAL
WHERE
    e2.ename = 'CLARK';

-- emp : WARD보다 커미션이 작은 사원의 이름과 커미션 조회
SELECT ename, ifnull(comm, 0)
FROM emp
WHERE
    ifnull(comm, 0) < (
        SELECT ifnull(comm, 0)
        FROM emp
        WHERE
            ename = 'WARD'
    );

-- student, department : 서진수 학생과 제1전공이 동일한 학생들의 이름과 전공명 조회
SELECT s.name, d.dname
FROM student s
    LEFT JOIN department d ON s.deptno1 = d.deptno
WHERE
    s.deptno1 = (
        SELECT deptno1
        FROM student
        WHERE
            NAME = '서진수'
    );

-- professor, department : 박원범 교수보다 나중에 입사한 교수의 이름과 입사일 학과명 조회
SELECT p.NAME, p.hiredate, d.dname
FROM professor p
    JOIN department d USING (deptno)
WHERE
    p.hiredate > (
        SELECT hiredate
        FROM professor
        WHERE
            NAME = '박원범'
    );

SELECT p.NAME, p.hiredate, d.dname
FROM (
        SELECT NAME, hiredate, deptno
        FROM professor
        WHERE
            hiredate > (
                SELECT hiredate
                FROM professor
                WHERE
                    NAME = '박원범'
            )
    ) p
    JOIN department d USING (deptno);

-- 컴퓨터공학과 학생들의 평균 몸무게보다 많이 나가는 학생들의 학번, 이름, 학과, 몸무게 조회
SELECT s.studno, s.name, d.dname, s.weight
FROM student s
    JOIN department d ON s.deptno1 = d.deptno
WHERE
    s.weight > (
        SELECT avg(weight)
        FROM student
        WHERE
            deptno1 = (
                SELECT deptno
                FROM department
                WHERE
                    dname = '컴퓨터공학과'
            )
    );

-- '노트북'을 받을 수 있는 포인트를 소유한 고객의 번호, 이름, 포인트 조회
SELECT gno, gname, `point`
FROM gogak
WHERE
    POINT >= (
        SELECT g_start
        FROM gift
        WHERE
            gname = '노트북'
    );

-- '이윤나' 고객이 받을 수 있는 선물 목록 조회
SELECT gname
FROM gift
WHERE
    g_start <= (
        SELECT point
        FROM gogak
        WHERE
            gname = '이윤나'
    );

-- emp : BLAKE가 관리하는 사원의 사번, 이름, 업무 조회
SELECT empno, ename, job
FROM emp
WHERE
    mgr = (
        SELECT empno
        FROM emp
        WHERE
            ename = 'BLAKE'
    );

-- emp. dept : 'new york'에서 근무하는 직원목록 조회
SELECT *
FROM emp
WHERE
    deptno = (
        SELECT deptno
        FROM dept
        WHERE
            loc = 'new york'
    );

-- student, exam_01, hakjum : 학점이 B0 미만인 학생의 학번, 이름, 점수 조회
SELECT s.studno, s.name, e.total
FROM student s
    JOIN exam_01 e USING (studno)
WHERE
    e.total < (
        SELECT min_point
        FROM hakjum
        WHERE
            grade = 'B0'
    );

-- emp2 : '최일도'와 같은 직급인 사람들의 평균 급여보다 많이 받는 사람들의 사번, 이름, 직급, 급여 조회
SELECT empno, NAME, POSITION, pay
FROM emp2
WHERE
    pay > (
        SELECT AVG(pay)
        FROM emp2
        WHERE
            POSITION = (
                SELECT POSITION
                FROM emp2
                WHERE
                    NAME = '최일도'
            )
    );

-- 박승곤 교수가 담당하는 학생들의 학번, 이름, 학년 조회
SELECT studno, NAME, grade
FROM student
WHERE
    profno = (
        SELECT profno
        FROM professor
        WHERE
            NAME = '박승곤'
    );

-- 컴퓨터정보학부에 속하는 학과 목록 조회
SELECT *
FROM department
WHERE
    part = (
        SELECT deptno
        FROM department
        WHERE
            dname = '컴퓨터정보학부'
    );

-- 공과대학에 속하는 학과 목록 조회
SELECT *
FROM department
WHERE
    part IN (
        SELECT deptno
        FROM department
        WHERE
            part = (
                SELECT deptno
                FROM department
                WHERE
                    dname = '공과대학'
            )
    );

-- 공과대학에 속하는 학생 목록 조회
SELECT *
FROM student s
    JOIN department d ON (s.deptno1 = d.deptno)
WHERE
    deptno1 IN (
        SELECT deptno
        FROM department
        WHERE
            part IN (
                SELECT deptno
                FROM department
                WHERE
                    part IN (
                        SELECT deptno
                        FROM department
                        WHERE
                            dname = '공과대학'
                    )
            )
    );

-- emp2, dept2 : '포항 본사'에서 근무하는 직원들의 사번, 이름, 직급, 부서명 조회
SELECT e.empno,
       e.name,
       e.deptno,
       d.dname
FROM emp2 e
JOIN dept2 d ON e.deptno = d.dcode
WHERE deptno IN
    (SELECT dcode
     FROM dept2
     WHERE AREA = '포항본사' );

-- emp2 : '과장' 직급의 최소연봉자보다 연봉이 높은 직원의 사번, 이름, 연봉, 직급 조회
SELECT empno,
       name,
       pay,
       POSITION
FROM emp2
WHERE pay >
    (SELECT MIN(pay)
     FROM emp2
     WHERE POSITION = '과장' );

SELECT empno,
       name,
       pay,
       POSITION
FROM emp2
WHERE pay > ANY
    (SELECT pay
     FROM emp2
     WHERE POSITION = '과장' );

-- student : 각 학년별 가장 큰 학생의 이름과 학년 키 조회
SELECT grade,
       NAME,
       MAX(height)
FROM student
GROUP BY grade;

SELECT grade,
       NAME,
       height
FROM student
WHERE (grade,
       height) IN
    (SELECT grade,
            MAX(height)
     FROM student
     GROUP BY grade);
-- 2학년 학생들 중 몸무게가 가장 적게 나가는 학생보다 더 적게 나가는 학생의 이름, 학년, 몸무게 조회
SELECT studno,
       NAME,
       grade,
       weight
FROM student
WHERE weight <
    (SELECT min(weight)
     FROM student
     WHERE grade = 2 );
     
SELECT NAME,
       grade,
       weight
FROM student
WHERE weight < ALL
    (SELECT weight
     FROM student
     WHERE grade = 2 );
     
-- dept : 소속된 직원이 있는 부서의 부서번호, 부서명 조회
SELECT d.deptno,
       d.dname
FROM dept d
WHERE EXISTS
    (SELECT *
     FROM emp
     WHERE deptno = d.deptno );
     
-- dept : 소속된 직원이 없는 부서의 부서번호, 부서명 조회
SELECT d.deptno,
       d.dname
FROM dept d
WHERE NOT EXISTS
    (SELECT *
     FROM emp
     WHERE deptno = d.deptno );
-- emp2 : 본인이 속한 부서의 평균 연봉보다 적게 받는 직원의 이름, 연봉, 부서명 조회
SELECT e.NAME,
       e.pay,
       d.dname
FROM emp2 e
JOIN dept2 d ON e.DEPTNO = d.DCODE
WHERE pay <
    (SELECT AVG(pay)
     FROM emp2
     WHERE deptno = e.deptno );
-- professor, department : 각 학과별 입사일이 가장 오래된 교수의 교수번호,이름,입사일,학과명 조회
-- 다중행 서브쿼리로 작성:
SELECT p.profno,
       p.name,
       p.hiredate,
       d.dname
FROM professor p
JOIN department d USING (deptno)
WHERE (deptno,
       hiredate) IN
    (SELECT deptno,
            min(hiredate)
     FROM professor
     GROUP BY deptno);

-- student : 학년별 나이가 가장 많은 학생의 학번, 이름, 학년, 나이 조회
SELECT studno,
       NAME,
       grade,
       MIN(birthday)
FROM student
GROUP BY grade;

SELECT studno,
       NAME,
       grade,
       format(datediff(curdate(), birthday) / 365, 0)
FROM student
WHERE (grade,
       birthday) IN
    (SELECT grade,
            MIN(birthday)
     FROM student
     GROUP BY grade);
     
-- emp2 : 직급별 최대 연봉을 받는 직원의 이름과 직급, 연봉 조회
SELECT NAME, POSITION, pay
FROM emp2
WHERE (POSITION, pay) IN (SELECT POSITION, max(pay) FROM emp2 GROUP BY IFNULL(POSITION,''));

-- student, exam_01, department : 같은 학과 같은 학년 학생의 평균 점수보다 점수가 높은 학생의
-- 학번, 이름, 학과, 학년, 점수 조회
SELECT s.studno, s.name, d.dname, e.total
FROM student s
JOIN exam_01 e
USING(studno)
JOIN department d
ON s.deptno1 = d.deptno
WHERE e.total > 
	(SELECT AVG(total)
	 FROM student s2
	 JOIN exam_01 e2
	 USING(studno)
	 WHERE s2.deptno1=s.deptno1 AND s2.grade = s.grade);

-- student, exam_01, department : 같은 학과 같은 학년 학생의 평균 점수보다 점수가 높은 학생의
-- 학번, 이름, 학과, 학년, 점수 조회
SELECT s.studno, s.name, d.dname, s.grade, e.total
FROM student s
JOIN exam_01 e USING(studno)
JOIN department d ON s.deptno1 = d.deptno
JOIN (
    SELECT deptno1, grade, AVG(total) as avg_total
    FROM student s2
    JOIN exam_01 e2 USING(studno)
    GROUP BY deptno1, grade
) avg_scores ON s.deptno1 = avg_scores.deptno1 
    AND s.grade = avg_scores.grade
WHERE e.total > avg_scores.avg_total;

-- student, professor : 담당 학생이 있는 교수들의 교수번호, 교수명 조회
SELECT p.profno, p.name
FROM professor p
WHERE EXISTS
    (SELECT *
     FROM student
     WHERE profno = p.profno );

-- student, professor : 담당 학생이 없는 교수들의 교수번호, 교수명 조회
SELECT p.profno, p.name
FROM professor p
WHERE NOT EXISTS
    (SELECT *
     FROM student
     WHERE profno = p.profno );

-- 1) student, professor 테이블 조인 : 곱
SELECT * FROM student, professor;
-- 2) 조인하여 profno 같은 것 걸러내기
SELECT *
FROM student JOIN professor USING(profno);
-- 3) professor 테이블에서 조인되지 않은 것 포함 (right join)
SELECT * 
FROM student RIGHT JOIN professor USING(profno);
-- 4) 그 중 조인되지 않은 것만 가져오기 (s.profno is null)
SELECT p.profno,
       p.name
FROM student s
RIGHT JOIN professor p USING(profno)
WHERE s.profno IS NULL;

-- emp2 : 직원들 중 자신의 직급의 평균연봉과 같거나 많이 받는 사람들의 이름, 직급, 연봉 조회
SELECT NAME,
       POSITION,
       pay
FROM emp2 e
WHERE pay >=
    (SELECT AVG(pay)
     FROM emp2
     WHERE POSITION=e.position );
     
-- student, department : '전자제어관' 건물에 있는 학과 소속인 학생의 학번, 이름, 학과 조회
SELECT s.studno,
       s.name,
       d.dname
FROM student s
JOIN department d ON s.deptno1 = d.deptno
OR s.deptno2 = d.deptno
WHERE s.deptno1 IN
    (SELECT deptno
     FROM department
     WHERE build='전자제어관');

-- emp2, p_grade : 이름, 직위, 급여, 같은 직급의 최소급여, 최대급여 조회
SELECT e.`NAME`, e.`POSITION`, e.PAY, p.s_pay, p.e_pay
FROM emp2 e
JOIN p_grade p
ON e.position = p.`position`;

-- emp : 사번, 이름, 입사일, 자신보다 먼저 입사한 사람의 인원 수 조회(smith 포함)
SELECT e1.empno, e1.ename, e1.hiredate, COUNT(*)
FROM emp e1
LEFT JOIN emp e2
ON e1.HIREDATE > e2.hiredate
GROUP BY e1.empno
ORDER BY 1;

-- emp : 사번, 이름, 입사일, 자신보다 먼저 입사한 사람의 인원 수 조회(smith 포함: 가장 먼저 입사한 사람 포함)
SELECT e1.empno, e1.ename, e1.hiredate, COUNT(e2.deptno)
FROM emp e1
LEFT JOIN emp e2
ON e1.HIREDATE > e2.hiredate
GROUP BY e1.empno
ORDER BY 1;

-- limit
SELECT *
FROM emp
ORDER BY sal DESC
LIMIT 0, 5; -- 첫번째(0)부터 5개

SELECT *
FROM emp
ORDER BY sal DESC
LIMIT 5, 5; -- 6번째(5)부터 5개

SELECT *
FROM emp
ORDER BY sal DESC
LIMIT 5 OFFSET 0; -- 첫번째(0)부터 5개
