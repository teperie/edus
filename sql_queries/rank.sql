-- ----------------------------
-- rank() : 1, 2, 3, 3, 5... 순위를 매김, 동률은 같은 등수로 처리, 동률이 있을 경우 다음 등수 건너뛰기
-- dense_rank() : 1, 2, 3, 3, 4... rank()와 같으나, 동률을 같은 등수로 처리하되 다음 등수를 동률의 수만큼 제외하지 않는다.
-- row_number() : 동률을 반영하지 않음, 즉, 동일한 등수는 존재하지 않고 모든 행은 다른 등수를 가짐
-- ----------------------------
-- 사용법
-- RANK() OVER([PARTITION BY 그룹기준명] ORDER BY 순위기준칼럼 {ASC/DESC})

SELECT
    studno,
    total,
    RANK() OVER (
        ORDER BY total DESC
    ) as RANK,
    DENSE_RANK() OVER (
        ORDER BY total DESC
    ) AS DENSERANK,
    ROW_NUMBER() OVER (
        ORDER BY total DESC
    ) AS ROWNUMBER
FROM exam_01;

SELECT
    empno,
    ename,
    deptno,
    sal,
    RANK() OVER (
        PARTITION BY
            deptno
        ORDER BY sal DESC
    ) 부서별급여순위1,
    DENSE_RANK() OVER (
        PARTITION BY
            deptno
        ORDER BY sal DESC
    ) 부서별급여순위2,
    ROW_NUMBER() OVER (
        PARTITION BY
            deptno
        ORDER BY sal DESC
    ) 부서별급여순위3
FROM emp;

-- sum(누적할 칼럼) over([partition by 그룹기준명] order by 순위기준칼럼 {asc/desc})
SELECT empno, ename, sal, SUM(sal) OVER ( ORDER BY sal ) FROM emp;

SELECT empno, ename, deptno, sal, SUM(sal) OVER (
        PARTITION BY
            deptno
        ORDER BY sal
    )
FROM emp;