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



