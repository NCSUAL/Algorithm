WITH NEW_DATE AS(
-- 코드를 입력하세요
SELECT
CAR_ID,
COUNT(CAR_ID) CNT
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE EXTRACT(MONTH FROM START_DATE) >= 8 AND EXTRACT(MONTH FROM START_DATE)<=10 
AND EXTRACT(YEAR FROM START_DATE) = 2022
GROUP BY CAR_ID
HAVING COUNT(CAR_ID) >=5
)

SELECT
EXTRACT(MONTH FROM C.START_DATE) MONTH,
C.CAR_ID,
COUNT(C.CAR_ID) RECORDS
FROM  CAR_RENTAL_COMPANY_RENTAL_HISTORY C
INNER JOIN NEW_DATE N
ON C.CAR_ID = N.CAR_ID
WHERE EXTRACT(MONTH FROM C.START_DATE) >= 8 AND EXTRACT(MONTH FROM C.START_DATE)<=10 
AND EXTRACT(YEAR FROM C.START_DATE) = 2022
GROUP BY C.CAR_ID, EXTRACT(MONTH FROM C.START_DATE)
ORDER BY MONTH,C.CAR_ID DESC


