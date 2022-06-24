[ 풀이 ]
SELECT COUNT(DISTINCT(NAME)) AS count
FROM ANIMAL_INS;

ex) SELECT COUNT(*) FROM TABLE_NAME
     : 이 결과에는 NULL이 포함되어서 세어진다. 
ex) SELECT COUNT(COLUMN_NAME) FROM TABLE_NAME
     : 칼럼의 이름을 사용하면 그 칼럼의 < NULL인 값을 제외한 개수 >가 반환된다.
