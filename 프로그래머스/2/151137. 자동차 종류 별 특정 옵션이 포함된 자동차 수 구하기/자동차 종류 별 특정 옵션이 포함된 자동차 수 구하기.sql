-- '통풍시트', '열선시트', '가죽시트' 하나 이상의 옵션이 
-- 포함된 자동차가 자동차 종류 별로 몇 대인지 출력

SELECT CAR_TYPE, COUNT(CAR_TYPE) AS CARS
  FROM CAR_RENTAL_COMPANY_CAR
 WHERE OPTIONS REGEXP '통풍시트|열선시트|가죽시트'
 GROUP
    BY CAR_TYPE
 ORDER
    BY CAR_TYPE;