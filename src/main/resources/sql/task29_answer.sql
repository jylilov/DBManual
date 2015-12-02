SELECT t1.point, t1.datetime, inc, out_m
FROM income_o t1 LEFT JOIN outcome_o t2 USING(point,datetime)
UNION
SELECT t2.point, t2.datetime, inc, out_m
FROM income_o t1 RIGHT JOIN outcome_o t2 USING(point,datetime)