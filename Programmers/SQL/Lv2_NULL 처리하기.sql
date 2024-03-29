# IF 사용 방법
SELECT ANIMAL_TYPE, IF(NAME IS NULL, "No name",NAME) AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS 
ORDER BY ANIMAL_ID ASC;

# IFNULL 사용 방법
SELECT ANIMAL_TYPE, IFNULL(NAME,'No name') AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC;

# CASE WHEN 사용 방법
SELECT ANIMAL_TYPE, CASE WHEN NAME IS NULL 
                         THEN "No name" 
                         ELSE NAME END AS NAME, SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID ASC;