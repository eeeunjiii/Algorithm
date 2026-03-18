-- 몇 시에 입양이 가장 활발하게 일어나는지
-- 각 시간대별로 입양이 몇 건이 발생하는지 조회- 각 시간대별로 입양이 몇 건이 발생하는지 조회
-- 시간대 순으로 정렬
SELECT HOUR(DATETIME) AS HOUR, COUNT(ANIMAL_ID)
FROM ANIMAL_OUTS
GROUP BY HOUR
HAVING HOUR>8 AND HOUR<=19
ORDER BY HOUR;