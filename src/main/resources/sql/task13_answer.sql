SELECT AVG(speed)
FROM pc LEFT JOIN product ON product.model=pc.model
WHERE product.maker='A'