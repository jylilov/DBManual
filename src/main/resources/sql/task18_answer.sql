SELECT DISTINCT maker, price
FROM product JOIN printer ON product.model=printer.model
WHERE price=
(
SELECT MIN(price)
FROM printer
WHERE color='y'
)
AND color='y'