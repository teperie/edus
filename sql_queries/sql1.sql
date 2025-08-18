SELECT * FROM emp; -- *는 전채 컬럼 조회를 의미, from 뒤에는 조회하고자 하는 테이블 이름이 온다

-- select와 from 사이에는 조회하고자 하는 컬럼을 쓴다
SELECT empno, ename, job FROM emp;

-- select from : 테이블의 데이터를 조회할 때 사용


-- dept 테이블에 있는 전체 컬럼 조회
SELECT * FROM dept;

-- dept 테이블에서 부서번호, 부서명 조회
SELECT deptno, dname FROM dept;

-- student 테이블에서 학번,이름,생일,전화번호 조회
SELECT * FROM student;
SELECT studno, NAME, birthday, tel FROM student;

-- where : 행에 대한 조건문(조건에 만족하는 행만 조회할 때 사용)
SELECT * FROM emp WHERE deptno=10;

SELECT empno, ename, job, deptno FROM emp WHERE deptno>10;

-- student 테이블에서 4학년 학생들의 학번, 이름, 생일, 전화번호, 학년 조회
SELECT * FROM student;

SELECT studno, NAME, birthday, tel, grade FROM student WHERE grade = 4;

-- where절 연산자
SELECT * FROM student WHERE grade=2 OR grade=3;
SELECT * FROM student WHERE grade>=2 AND grade<=3;
SELECT * FROM student WHERE grade IN(2,3);
SELECT * FROM student WHERE grade not IN(1,4);

-- emp 테이블에서 업무가 clerk이거나 saleman인 직원의 사번, 이름, 업무 조회
SELECT empno AS "사 띄고 번", ename, job FROM emp WHERE job = 'clerk' OR job = "salesman";


-- 날짜 형식도 비교 연산자 가능하다
SELECT * FROM emp WHERE hiredate >= '1985-01-01';

-- student 테이블에서 1976년생 학생 조회
SELECT * FROM student WHERE birthday >= '1976-01-01' AND birthday <= '1976-12-31';

-- between a and b
SELECT * FROM student WHERE birthday BETWEEN '1976-01-01' AND '1976-12-31';

-- professor 테이블에서 급여가 500대인 교수의 정보 조회
SELECT * FROM professor WHERE pay BETWEEN 500 AND 599;

-- order by : 정렬
SELECT * FROM emp ORDER BY sal ASC;
SELECT * FROM emp ORDER BY sal DESC;
SELECT * FROM emp WHERE deptno = 10 ORDER BY sal DESC;

SELECT * FROM student ORDER BY 1 DESC;

-- student 테이블에서 4학년 학생들을 이름순으로 정렬
SELECT * FROM student WHERE grade =4 ORDER BY NAME;

-- 부서번호 순으로 정렬
SELECT * FROM emp ORDER BY deptno desc, hiredate;

-- student 테이블에서 학년순으로 정렬, 같은 학년일 경우 키가 큰 순으로 정렬
SELECT * FROM student ORDER BY grade, height DESC;

-- distinct 중복 행 제거
SELECT DISTINCT(deptno) FROM emp;
SELECT DISTINCT(deptno), job FROM emp;

-- like 연산자
SELECT * FROM student WHERE NAME LIKE '서%';

SELECT * FROM student WHERE NAME LIKE '서_수';

SELECT * FROM student WHERE birthday LIKE '1976%';


-- student 테이블에서 주민번호상 생월이 3월인 학생의 학번, 이름, 주민번호 조회
SELECT studno, NAME, jumin FROM student WHERE jumin LIKE '__03%';

-- 컬럼의 값이 null인지 비교할 땐 is null 사용('='을 사용하지 않는다)
SELECT * FROM professor WHERE bonus IS NULL;
SELECT * FROM professor WHERE bonus IS NOT NULL;


-- emp 테이블에서 comm이 있는 직원만 조회
SELECT * FROM emp WHERE comm IS NOT NULL;

-- emp 테이블에서 sal이 1000보다 크고 comm 이 1000보다 작거나 없는 직원의 사번, 이름, 급여, 커미션 조회
SELECT empno, ename, sal, comm FROM emp WHERE sal>1000 AND (comm < 1000 OR comm IS NULL);

-- professor 테이블에서 모든 교수의 교수번호, 이름, 급여, 보너스, 연봉(12*pay+comm)을 조회
SELECT * FROM professor;
SELECT profno, NAME, pay, IFNULL( bonus,0), pay * 12 + IFNULL(bonus,0) FROM  professor;

-- emp 테이블에서 커미션이 없는 사람은 10으로 계산해서 연봉을 조회
-- 조회 칼럼은 사번, 이름 부서번호, 급여, 커미션, 연봉
SELECT empno, ename, deptno, sal, comm, sal * 12 + ifnull(comm,0) 연봉 FROM emp;