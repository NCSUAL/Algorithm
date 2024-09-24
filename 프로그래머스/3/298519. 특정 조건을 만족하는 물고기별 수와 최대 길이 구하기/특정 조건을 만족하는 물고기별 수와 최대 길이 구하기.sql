-- 코드를 작성해주세요
WITH
NEWDATA AS(
    SELECT
    A.FISH_TYPE FISH_TYPE,
    AVG(A.LENGTH) AVG
    FROM (
    SELECT
    ID,
    FISH_TYPE,
    IFNULL(LENGTH,10) LENGTH
    FROM FISH_INFO
    )A
    GROUP BY A.FISH_TYPE
)

SELECT
COUNT(F.ID) FISH_COUNT,
MAX(F.LENGTH) MAX_LENGTH,
F.FISH_TYPE
FROM FISH_INFO F
INNER JOIN NEWDATA N
ON F.FISH_TYPE = N.FISH_TYPE
WHERE AVG >= 33
GROUP BY F.FISH_TYPE
ORDER BY F.FISH_TYPE