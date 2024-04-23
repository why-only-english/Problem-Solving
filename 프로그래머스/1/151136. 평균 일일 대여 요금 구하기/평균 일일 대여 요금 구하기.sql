SELECT ROUND(AVG(DAILY_FEE), 0) AS AVERAGE_FEE  # 3. 평균 -> 반올림 -> 컬럼명 지정
FROM CAR_RENTAL_COMPANY_CAR                     # 1. 테이블
WHERE CAR_TYPE = 'SUV';                         # 2. SUV

