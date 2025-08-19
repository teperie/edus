-- -------------------------------
-- 문자열 함수
-- -------------------------------
-- format
SELECT FORMAT(25053523.1254, 2);

SELECT empno, ename, format(sal,0) AS sal FROM emp;

-- insert
SELECT INSERT('http://naver.com',8,5, 'kosta') AS "kosta.com";

-- instr
SELECT INSTR('http://naver.com','n');
-- student 테이블의 tel 컬럼에서 ')'의 위치 구하기
SELECT *, INSTR(tel, ')') AS 뭐요 FROM student;

-- substr (= substring)
SELECT SUBSTR('http://naver.com', 8, 5);
SELECT SUBSTRING('http://naver.com', 8);
-- tel에서 지역번호만 갖고오래요
SELECT substr(tel, 1, INSTR(tel,')')) FROM student;

-- length 문자열의 길이
SELECT LENGTH(tel) FROM student;
-- professor 테이블의 email 컬럼에서 @ 뒤 문자열 조회(email 서버 이름 조회)
SELECT substr(email, INSTR(email, '@') + 1) FROM professor;
SELECT length(substr(email, INSTR(email, '@') + 1)) FROM professor;

-- professor 테이블에서 email 서버 이름을 'kosta.com'으로 변경
SELECT INSERT(email, INSTR(email, '@') + 1, LENGTH(substr(email, INSTR(email, '@') + 1)), 'kosta.com') FROM professor;

-- length : 텍스트의 바이트 수
SELECT ename, LENGTH(ename) FROM emp;
SELECT NAME, LENGTH(NAME) FROM student; -- 한글은 한 글자가 3바이트

-- char_length : 글자 수
SELECT ename, CHAR_LENGTH(ename) FROM emp;
SELECT NAME, CHAR_LENGTH(NAME) FROM student;

-- lower, lcase : 소문자로 변경
SELECT ename, LOWER(ename), LCASE(ename) FROM emp;

-- upper, ucase : 대문자로 변경
SELECT id, UPPER(id), UCASE(id) FROM professor;

-- trim : 앞뒤 공백 삭제
SELECT length('  asdf    ');
SELECT length(TRIM('  asdf    '));
-- ltrim : 왼쪽 공백 삭제
SELECT length(LTRIM('  asdf    '));
-- rtrim : 오른쪽 공백 삭제
SELECT length(RTRIM('  asdf    '));

SELECT LENGTH('a s d f');
SELECT LENGTH(TRIM(('a s d f'));

-- lpad : 
SELECT LPAD('MariaDB', 20, '#');
SELECT RPAD('MariaDB', 20, '$');
SELECT LPAD(email, 20, '123456789') FROM professor;

-- concat : 문자열을 이을 때 사용하는 함수
-- smith(clerk)
SELECT concat(ename, '(', job, ')') job FROM emp;

-- smith's sal is $800
SELECT CONCAT(ename, '''s sal is ', sal, '$') FROM emp;


-- -------------------------------
-- 날짜 함수
-- -------------------------------
-- curdate() : 시스템 현재 날짜
SELECT CURDATE();
SELECT CURDATE()+14;

-- adddate (= date_add)
SELECT ADDDATE(CURDATE(), 14);
SELECT DATE_ADD(CURDATE(), INTERVAL 14 DAY);

SELECT ADDDATE(CURDATE(), INTERVAL -2 MONTH);

SELECT DATE_ADD(CURDATE(), INTERVAL 10 YEAR);

-- emp 테이블에서 입사일과 입사 후 10년 기념일 조회
SELECT hiredate, DATE_ADD(hiredate, INTERVAL 10 year) FROM emp;

-- curtime() : 시스템 현재 시간
SELECT CURTIME();

-- now() : 현재 날짜 & 시간
SELECT NOW();

-- addtime
SELECT CURTIME(), ADDTIME(CURTIME(), '1:10:5');
SELECT now(), ADDTIME(now(), '2 1:10:5'); -- ADD 2day, 1hour, 10 MINUTE, 5second

-- datediff
SELECT hiredate, DATEDIFF(CURDATE(), hiredate) FROM emp;


-- subdate (= date_sub) : 날짜 빼기
SELECT CURDATE(), SUBDATE(CURDATE(), INTERVAL 10 DAY);
SELECT CURDATE(), DATE_SUB(CURDATE(), INTERVAL 10 DAY);
SELECT CURDATE(), adddate(CURDATE(), INTERVAL -10 DAY);

-- date_format
SELECT DATE_FORMAT('2017-06-15','%W %M %D %Y');
SELECT DATE_FORMAT('2017-06-15','%w %m %d %y');
SELECT DATE_FORMAT(CURDATE(),'%M %D %Y');
SELECT DATE_FORMAT(CURDATE(),'%y-%m-%d');
-- 월 (month) : %M(August), %b(Aug), %m(08), %c(8)
-- 연 (year) : %Y(2025), %y(25)
-- 일 (Day) : %d(05), %e(5)
-- 요일 (Week) : %W(Monday), %w(1)
-- 시간 (Hour) : %H(16), %l(4)
-- %r : hh:mm:ss AM(PM)
-- 분 : %i(36)
-- 초 : %S(15)

-- student 테이블에서 학생들의 생일과 태어난 요일 조회
SELECT DATE_FORMAT('1994-11-23', '%W');
SELECT birthday, DATE_FORMAT(birthday, '%W') FROM student;

-- day : 날짜에서 일 추출
SELECT hiredate, DAY(hiredate) FROM emp;
SELECT birthday FROM student WHERE DAY(birthday) = 23;

-- dayofmonth : 날짜에서 월 추출
SELECT hiredate, DAYofMONTH(hiredate) FROM emp;

-- dayname: 날짜에서 요일 추출
SELECT hiredate, DAYNAME(hiredate) FROM emp;

-- dayofweek: 날짜에서 요일 추출
SELECT CURDATE(), DAYOFWEEK('2025-08-24'); -- 일: 1, 월: 2, ...
SELECT CURDATE(), DATE_FORMAT(CURDATE(), '%w'); -- 일: 0, 월: 1...

-- extract
SELECT CURDATE(), EXTRACT(MONTH FROM CURDATE()) AS 월;
SELECT CURDATE(), EXTRACT(DAY FROM CURDATE()) AS 일;
SELECT CURDATE(), EXTRACT(year FROM CURDATE()) AS 년;
SELECT now(), EXTRACT(hour FROM now()) AS 시간;
SELECT now(), EXTRACT(minute FROM now()) AS 분;
SELECT now(), EXTRACT(SECOND FROM now()) AS 초;
SELECT NOW(), EXTRACT(year_month FROM NOW()) AS 연월;

SELECT NOW(), YEAR(NOW());
SELECT NOW(), MONTH(NOW());
SELECT NOW(), DAY(NOW());
SELECT NOW(), HOUR(NOW());
SELECT NOW(), MINUTE(NOW());
SELECT NOW(), SECOND(NOW());


-- time_to_sec : 시간을 초로 변환
SELECT CURTIME(), TIME_TO_SEC(CURTIME());

-- timediff
SELECT CURTIME(), TIMEDIFF(CURTIME(), '17:00:00');

-- student 테이블에서 이번달에 생일인 학생의 학번, 이름, 학년, 생일 조회
SELECT studno, NAME, grade, birthday FROM student WHERE MONTH(birthday) = MONTH(CURDATE());




-- -------------------------------
-- 숫자 함수
-- -------------------------------
-- count : 조건에 만족하는 레코드(행)의 수
SELECT COUNT(*) FROM emp;
SELECT COUNT(*) FROM emp WHERE deptno=10;

SELECT COUNT(empno) FROM emp;
SELECT COUNT(comm) FROM emp; -- 선택한 컬럼이 null인 행은 제외

-- sum
SELECT SUM(sal) FROM emp;
SELECT SUM(sal) FROM emp WHERE deptno=10;

-- avg
SELECT format(AVG(sal),2) FROM emp;
SELECT FORMAT(AVG(sal),2) FROM emp WHERE deptno = 10;

-- emp 테이블에서 전채 직원 수, 전체 직원의 급여합, 평균 조회
SELECT COUNT(*), SUM(sal), SUM(sal)/COUNT(*), AVG(sal) FROM emp;

-- emp 테이블에서 전체 직원의 커미션의 합, 커미션의 평균 조회
SELECT SUM(comm), SUM(comm)/COUNT(*), AVG(comm), AVG(IFNULL(comm,0)) FROM emp;

-- emp 테이블에서 이름, 급여, 급여+상여금 조회
SELECT eNAME, sal, sal + ifnull(comm,0) FROM emp;

-- min, max
-- emp 테이블에서 사원 중에서 급여와 보너스를 합친 금액이 가장 많은 경우와 가장 적은 경우, 평균 금액을 조회
SELECT max(sal + ifnull(comm,0)), MIN(sal+ifnull(comm,0)), AVG(sal+IFNULL(comm,0)) FROM emp;

-- group by
SELECT deptno, ename, COUNT(*), SUM(sal) 
FROM emp
GROUP BY deptno;

-- student 테이블에서 제1학과별 학과번호, 학생 수 조회
SELECT deptno1, COUNT(*) FROM student GROUP BY deptno1;

-- professor 테이블에서 직급별 급여 평균 조회
SELECT POSITION, AVG(pay) FROM professor GROUP BY POSITION;

-- emp2 테이블에서 고용타입별 인원수
SELECT emp_type, COUNT(*) FROM emp2 GROUP BY emp_type;

SELECT POSITION, COUNT(*)
FROM emp2
GROUP BY POSITION;

-- 그룹핑한 것에 대한 조건은 having절을 사용
-- professor 테이블에서 학과별 급여 평균이 400 이상인 학과의 인원 수 급여 평균 조회
SELECT deptno, AVG(pay) 
FROM professor
GROUP BY deptno
HAVING AVG(pay) >= 400;

-- deptno가 101인 학생들의 학년별 평균 키를 구하디 평균 키가 180 이상인 학년만 조회
SELECT deptno1, grade, AVG(height)
FROM student
WHERE deptno1 = 101
GROUP BY grade
HAVING AVG(height) >= 180
ORDER BY AVG(height);

-- gogak 테이블에서 출생연도별 포인트 평균 조회
SELECT SUBSTR(jumin, 1, 2), avg(POINT) 
FROM gogak
GROUP BY SUBSTR(jumin,1,2);

-- student 테이블에서 각 학과(제1학과)와 학년별 평균 몸무게, 최대/최소 몸무게 조회
SELECT deptno1, grade, AVG(weight), MAX(weight), MIN(weight)
FROM student
GROUP BY deptno1, grade;

-- emp 테이블에서 부서와 직군별 인원 수 조회
SELECT deptno, job, COUNT(*)
FROM emp
GROUP BY deptno, job;
