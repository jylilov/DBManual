SELECT t1.point, t1.datetime, out_m, inc
FROM (
SELECT point, datetime, SUM(inc) AS inc
FROM income
GROUP BY point, datetime
) t1 LEFT JOIN (
SELECT point, datetime, SUM(out_m) AS out_m
FROM outcome
GROUP BY point, datetime
) t2
USING(point,datetime)
UNION
SELECT t2.point, t2.datetime, out_m, inc
FROM (
SELECT point, datetime, SUM(inc) AS inc FROM income
GROUP BY point, datetime
) t1 RIGHT JOIN (
SELECT point, datetime, SUM(out_m) AS out_m
FROM outcome
GROUP BY point, datetime) t2
USING(point,datetime)