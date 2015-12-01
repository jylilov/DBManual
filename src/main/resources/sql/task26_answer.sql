
SELECT AVG(price)
FROM (
SELECT code, price, pc.model, ram, hd
FROM pc
WHERE model IN (
SELECT model
FROM product
WHERE maker='a'
)
UNION
SELECT code, price, laptop.model, ram, hd
FROM laptop
WHERE model IN (
SELECT model
FROM product
WHERE maker='a'
)
) a