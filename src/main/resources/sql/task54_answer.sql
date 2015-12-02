select round(avg(numguns),2)
from (
Select numguns, name
from classes left join ships using(class)
where type='bb' and name!='null' and class!='null'
union all
select distinct numguns, ship
from classes left join outcomes on classes.class=outcomes.ship
where ship not in (select name from ships) and class!='null' and type='bb' )a