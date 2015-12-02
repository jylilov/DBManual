SELECT DISTINCT product.type, laptop.model, laptop.speed
FROM laptop, product
WHERE speed <
(
SELECT MIN(speed) FROM pc
)
AND product.type='Laptop'