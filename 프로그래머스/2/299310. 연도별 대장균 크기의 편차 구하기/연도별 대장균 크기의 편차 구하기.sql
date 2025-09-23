# 분화한 연도(YEAR), 분화된 연도별 대장균 크기의 편차(YEAR_DEV), 대장균 개체의 ID(ID)
# 편차: 분화된 연도별 가장 큰 대장균의 크기 - 각 대장균의 크기
# 연도에 대해 오름차순 정렬, 대장균 크기의 편차에 대해 오름차순 정렬
SELECT YEAR(DIFFERENTIATION_DATE) AS YEAR,
    (
        SELECT MAX(SIZE_OF_COLONY)
          FROM ECOLI_DATA
         WHERE YEAR(DIFFERENTIATION_DATE)=YEAR
    ) - SIZE_OF_COLONY AS YEAR_DEV
    , ID
  FROM ECOLI_DATA
 ORDER
    BY YEAR, YEAR_DEV;