-- 음식종류별로 즐겨찾기 수가 가장 많은 식당의 음식종류, id, 식당 이름, 즐겨찾기수 조회
-- 음식 종류를 기준으로 내림차순 정렬
-- 각 음식 종류별로 즐겨찾기 수가 많은 식당을 찾아야 함.

SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
FROM REST_INFO
WHERE FAVORITES IN (
    SELECT MAX(FAVORITES)
    FROM REST_INFO
    GROUP BY FOOD_TYPE
)
GROUP BY FOOD_TYPE
ORDER BY FOOD_TYPE DESC;