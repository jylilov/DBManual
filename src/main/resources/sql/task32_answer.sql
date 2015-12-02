select country, round(avg((pow(bore,3)/2)),2) as weight
from
(select country, class, bore, name from classes left join ships using(class)
union all
select distinct country, class, bore, ship
from classes t1 left join outcomes t2 on t1.class=t2.ship
where ship=class and ship not in (select name from ships)
) a
where name!='null'
group by country