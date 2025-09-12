# 진료과: CS이거나 GS인 의사 이름, ID, 진료과, 고용일자 조회, 고용일자를 기준으로 내림차순 정렬
SELECT DR_NAME, DR_ID, MCDP_CD, DATE_FORMAT(HIRE_YMD, '%Y-%m-%d') AS HIRE_YMD
  FROM DOCTOR
 WHERE (MCDP_CD='CS') OR (MCDP_CD='GS')
 ORDER
    BY HIRE_YMD DESC, DR_NAME ASC;