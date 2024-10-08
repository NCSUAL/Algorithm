-- 코드를 입력하세요
WITH NEW_DATA AS (
    SELECT
    FOOD_TYPE,
    MAX(FAVORITES) AS FAVORITES
    FROM REST_INFO
    GROUP BY FOOD_TYPE
)

SELECT
R.FOOD_TYPE FOOD_TYPE,
R.REST_ID,
R.REST_NAME,
N.FAVORITES
FROM REST_INFO R
INNER JOIN NEW_DATA N
ON N.FAVORITES = R.FAVORITES AND N.FOOD_TYPE = R.FOOD_TYPE
ORDER BY FOOD_TYPE DESC

-- SELECT * FROM NEW_DATA

