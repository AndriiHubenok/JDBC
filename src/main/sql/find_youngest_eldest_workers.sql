SELECT
    CASE
	WHEN birthday = (
      SELECT MAX(birthday)
      FROM worker
    ) THEN 'YOUNGEST'
  END AS type, NAME, BIRTHDAY
FROM 
    worker
WHERE 
    birthday = (SELECT birthday FROM worker ORDER BY birthday DESC LIMIT 1)
UNION
SELECT
CASE
	WHEN birthday = (
      SELECT MIN(birthday)
      FROM worker
    ) THEN 'OLDEST'
  END AS type, NAME, BIRTHDAY
FROM 
    worker
WHERE 
    birthday = (SELECT birthday FROM worker ORDER BY birthday LIMIT 1);