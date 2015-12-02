SELECT t1.point, t1.date, `out_m`, inc
FROM (
SELECT point, date, SUM(inc) AS inc
FROM income
GROUP BY point, date
) t1 LEFT JOIN (
SELECT point, date, SUM(`out_m`) AS `out_m`
FROM outcome
GROUP BY point, date
) t2
USING(point,date)
UNION
SELECT t2.point, t2.date, `out_m`, inc
FROM (
SELECT point, date, SUM(inc) AS inc FROM income
GROUP BY point, date
) t1 RIGHT JOIN (
SELECT point, date, SUM(`out_m`) AS `out_m`
FROM outcome
GROUP BY point, date) t2
USING(point,date)