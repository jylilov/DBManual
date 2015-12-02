SELECT AVG(hd)
FROM product t1 JOIN pc t2 ON t1.model=t2.model
WHERE maker IN (
SELECT maker
FROM product
WHERE type='printer'
);