-- 노선, 총 누계 거리 (둘째자리), 평균 역 사이 거리(셋째자리)를 노선별로 조회
-- 누계 거리: 테이블 내 존재하는 역들의 역 사이 거리의 총합
-- 누계 거리를 기준으로 내림차순 정렬

SELECT ROUTE, 
       CONCAT(ROUND(SUM(D_BETWEEN_DIST), 1), 'km') AS TOTAL_DISTANCE,
       CONCAT(ROUND(AVG(D_BETWEEN_DIST), 2), 'km') AS AVERAGE_DISTANCE
FROM SUBWAY_DISTANCE
GROUP BY ROUTE
ORDER BY ROUND(SUM(D_BETWEEN_DIST), 1) DESC;