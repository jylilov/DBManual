select distinct maker from product right join (select distinct a.model from pc as a where a.speed >= 750
union
select distinct b.model from laptop as b where b.speed >= 750) as t on product.model = t.model group by maker having count(distinct type) >= 2