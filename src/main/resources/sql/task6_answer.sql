SELECT maker, speed
FROM product INNER JOIN laptop ON Product.model = Laptop.model
WHERE laptop.hd >=10