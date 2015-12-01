select 
distinct product.maker 
from 
product 
inner join 
   (select 
    distinct maker 
    from 
    product 
    inner join 
       (select 
        distinct a.model 
        from 
        pc as a 
        inner join 
           (select 
            max(a.speed) as speed, min(a.ram) as ram 
            from 
            pc as a 
            inner join
               (select 
                min(ram) as ram from pc) as b on a.ram = b.ram) 
            as b 
            on a.speed = b.speed and a.ram = b.ram)
        as a 
        on product.model = a.model) as a 
on product.maker = a.maker 
where product.type = 'Printer'