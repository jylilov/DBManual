create table Classes (class varchar(50), type varchar(2), country varchar(20), numGuns smallint, bore real, displacement int);

create table Ships (name varchar(50), class varchar(50), launched smallint);

create table Battles (name varchar(20), date timestamp);

create table Outcomes (ship varchar(50), battle varchar(50), result varchar(10)); 


insert into classes(class, type, country, numGuns, bore, displacement) values ('Bismarck', 'bb', 'Germany', 8, 15.0, 42000);
insert into classes(class, type, country, numGuns, bore, displacement) values ('Iowa', 'bb', 'USA', 9, 16.0, 46000);
insert into classes(class, type, country, numGuns, bore, displacement) values ('Kongo', 'bc', 'Japan', 8, 14.0, 32000);
insert into classes(class, type, country, numGuns, bore, displacement) values ('North Carolina', 'bb', 'USA', 12, 16.0, 37000);
insert into classes(class, type, country, numGuns, bore, displacement) values ('Renown', 'bc', 'Gt.Britain', 6, 15.0, 32000);
insert into classes(class, type, country, numGuns, bore, displacement) values ('Revenge', 'bb', 'Gt.Britain', 8, 15.0, 29000);
insert into classes(class, type, country, numGuns, bore, displacement) values ('Tennessee', 'bb', 'USA', 12, 14.0, 32000);
insert into classes(class, type, country, numGuns, bore, displacement) values ('Yamato', 'bb', 'Japan', 9, 18.0, 65000);


insert into ships(name, class, launched) values ('California', 'Tennessee', 1921);
insert into ships(name, class, launched) values ('Haruna', 'Kongo', 1916);
insert into ships(name, class, launched) values ('Hiei', 'Kongo', 1914);
insert into ships(name, class, launched) values ('Iowa', 'Iowa', 1943);
insert into ships(name, class, launched) values ('Kirishima', 'Kongo', 1915);
insert into ships(name, class, launched) values ('Kongo', 'Kongo', 1913);
insert into ships(name, class, launched) values ('Missouri', 'Iowa', 1944);
insert into ships(name, class, launched) values ('Musashi', 'Yamato', 1942);
insert into ships(name, class, launched) values ('New Jersey', 'Iowa', 1943);
insert into ships(name, class, launched) values ('North Carolina', 'North Carolina', 1941);
insert into ships(name, class, launched) values ('Ramillies', 'Revenge', 1917);
insert into ships(name, class, launched) values ('Renown', 'Renown', 1916);
insert into ships(name, class, launched) values ('Repulse', 'Renown', 1916);
insert into ships(name, class, launched) values ('Resolution', 'Renown', 1916);
insert into ships(name, class, launched) values ('Revenge', 'Revenge', 1916);
insert into ships(name, class, launched) values ('Royal Oak', 'Revenge', 1916);
insert into ships(name, class, launched) values ('Royal Sovereign', 'Revenge', 1916);
insert into ships(name, class, launched) values ('South Dakota', 'North Carolina', 1941);
insert into ships(name, class, launched) values ('Tennessee', 'Tennessee', 1920);
insert into ships(name, class, launched) values ('Washington', 'North Carolina', 1941);
insert into ships(name, class, launched) values ('Wisconsin', 'Iowa', 1944);
insert into ships(name, class, launched) values ('Yamato', 'Yamato', 1941);


insert into battles(name, date) values ('#Cuba62a', '1962-10-20 00:00:00.000');
insert into battles(name, date) values ('#Cuba62b', '1962-10-25 00:00:00.000');
insert into battles(name, date) values ('Guadalcanal', '1942-11-15 00:00:00.000');
insert into battles(name, date) values ('North Atlantic', '1941-05-25 00:00:00.000');
insert into battles(name, date) values ('North Cape', '1943-12-26 00:00:00.000');
insert into battles(name, date) values ('Surigao Strait', '1944-10-25 00:00:00.000');


insert into Outcomes(ship, battle, result) values ('Bismarck', 'North Atlantic', 'sunk');
insert into Outcomes(ship, battle, result) values ('California', 'Guadalcanal', 'damaged');
insert into Outcomes(ship, battle, result) values ('CAlifornia', 'Surigao Strait', 'ok');
insert into Outcomes(ship, battle, result) values ('Duke of York', 'North Cape', 'ok');
insert into Outcomes(ship, battle, result) values ('Fuso', 'Surigao Strait', 'sunk');
insert into Outcomes(ship, battle, result) values ('Hood', 'North Atlantic', 'sunk');
insert into Outcomes(ship, battle, result) values ('King George V', 'North Atlantic', 'ok');
insert into Outcomes(ship, battle, result) values ('Kirishima', 'Guadalcanal', 'sunk');
insert into Outcomes(ship, battle, result) values ('Prince of Wales', 'North Atlantic', 'damaged');
insert into Outcomes(ship, battle, result) values ('Rodney', 'North Atlantic', 'OK');
insert into Outcomes(ship, battle, result) values ('Schamhorst', 'North Cape', 'sunk');
insert into Outcomes(ship, battle, result) values ('South Dakota', 'Guadalcanal', 'damaged');
insert into Outcomes(ship, battle, result) values ('Tennessee', 'Surigao Strait', 'ok');
insert into Outcomes(ship, battle, result) values ('Washington', 'Guadalcanal', 'ok');
insert into Outcomes(ship, battle, result) values ('West Virginia', 'Surigao Strait', 'ok');
insert into Outcomes(ship, battle, result) values ('Yamashiro', 'Surigao Strait', 'sunk');