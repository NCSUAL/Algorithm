-- -- -- 코드를 입력하세요
-- SELECT
--     A.*
-- FROM (SELECT
-- INS.NAME,
-- INS.DATETIME
-- FROM ANIMAL_INS INS
-- LEFT JOIN ANIMAL_OUTS OUTS
-- ON INS.NAME = OUTS.NAME
-- WHERE OUTS.NAME IS NULL AND INS.NAME IS NOT NULL
-- ORDER BY DATETIME ASC) A
-- WHERE ROWNUM<=3

SELECT
A.*
FROM (
    SELECT
INS.NAME,
INS.DATETIME
FROM ANIMAL_INS INS
LEFT JOIN ANIMAL_OUTS OUTS
ON INS.ANIMAL_ID = OUTS.ANIMAL_ID
WHERE OUTS.ANIMAL_ID IS NULL
ORDER BY DATETIME)
A
WHERE ROWNUM<=3