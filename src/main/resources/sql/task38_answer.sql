select distinct country
from classes
where type='bb' and country in
(
select country
from classes
where type='bc'
)