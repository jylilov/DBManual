SELECT class, name, country
FROM classes LEFT JOIN ships USING(class)
WHERE numguns>=10 AND name!='null'