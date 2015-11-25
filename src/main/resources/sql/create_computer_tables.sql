create table product(maker varchar(10), model varchar(50), type varchar(50));

create table laptop(code int, model varchar(50), speed smallint, ram smallint, hd real, price double, screen SMALLINT);

create table pc(code int, model varchar(50), speed smallint, ram smallint, hd real, cd varchar(10), price double);

create table printer(code int, model varchar(50), color char(1), type varchar(10),price double);

insert into pc(code, model, speed, ram, hd, cd, price) values (1, '1232', 500, 64, 5.0, '12x', 600.00);
insert into pc(code, model, speed, ram, hd, cd, price) values (10, '1260', 500, 32, 10.0, '12x', 350.0000);
insert into pc(code, model, speed, ram, hd, cd, price) values (11, '1233', 900, 128, 40.0, '40x', 980.0000);
insert into pc(code, model, speed, ram, hd, cd, price) values (12, '1233', 800, 128, 20.0, '50x', 970.0000);
insert into pc(code, model, speed, ram, hd, cd, price) values (2, '1121', 750, 128, 14.0, '40x', 850.0000);
insert into pc(code, model, speed, ram, hd, cd, price) values (3, '1233', 500, 64, 5.0, '12x', 600.0000);
insert into pc(code, model, speed, ram, hd, cd, price) values (4, '1121', 600, 128, 14.0, '40x', 850.0000);
insert into pc(code, model, speed, ram, hd, cd, price) values (5, '1121', 600, 128, 8.0, '40x', 850.0000);
insert into pc(code, model, speed, ram, hd, cd, price) values (6, '1233', 750, 128, 20.0, '50x', 950.0000);
insert into pc(code, model, speed, ram, hd, cd, price) values (7, '1232', 500, 32, 10.0, '12x', 400.0000);
insert into pc(code, model, speed, ram, hd, cd, price) values (8, '1232', 450, 64, 8.0, '24x', 350.0000);
insert into pc(code, model, speed, ram, hd, cd, price) values (9, '1232', 450, 32, 10.0, '24x', 350.0000);

insert into product(maker, model, type) values ('A', '1232', 'PC');
insert into product(maker, model, type) values ('A', '1233', 'PC');
insert into product(maker, model, type) values ('A', '1276', 'Printer');
insert into product(maker, model, type) values ('A', '1298', 'Laptop');
insert into product(maker, model, type) values ('A', '1401', 'Printer');
insert into product(maker, model, type) values ('A', '1408', 'Printer');
insert into product(maker, model, type) values ('A', '1752', 'Laptop');
insert into product(maker, model, type) values ('B', '1121', 'PC');
insert into product(maker, model, type) values ('B', '1750', 'Laptop');
insert into product(maker, model, type) values ('C', '1321', 'Laptop');
insert into product(maker, model, type) values ('D', '1288', 'Printer');
insert into product(maker, model, type) values ('D', '1433', 'Printer');
insert into product(maker, model, type) values ('E', '1260', 'PC');
insert into product(maker, model, type) values ('E', '1434', 'Printer');
insert into product(maker, model, type) values ('E', '2112', 'PC');
insert into product(maker, model, type) values ('E', '2113', 'PC');

insert into laptop(code, model, speed, ram, hd, price, screen) values (1, '1298', 350, 32, 4.0, 700.00, 11);
insert into laptop(code, model, speed, ram, hd, price, screen) values (2, '1321', 500, 64, 8.0, 970.00, 12);
insert into laptop(code, model, speed, ram, hd, price, screen) values (3, '1750', 750, 128, 12.0, 1200.00, 14);
insert into laptop(code, model, speed, ram, hd, price, screen) values (4, '1298', 600, 64, 10.0, 1050.00, 15);
insert into laptop(code, model, speed, ram, hd, price, screen) values (5, '1752', 750, 128, 10.0, 1150.00, 14);
insert into laptop(code, model, speed, ram, hd, price, screen) values (6, '1298', 450, 64, 10.0, 950.00, 12);

insert into printer(code, model, color, type, price) values (1, '1276', 'n', 'Laser', 400.00);
insert into printer(code, model, color, type, price) values (2, '1433', 'y', 'Jet', 270.00);
insert into printer(code, model, color, type, price) values (3, '1434', 'y', 'Jet', 290.00);
insert into printer(code, model, color, type, price) values (4, '1401', 'n', 'Matrix', 150.00);
insert into printer(code, model, color, type, price) values (5, '1408', 'n', 'Matrix', 270.00);
insert into printer(code, model, color, type, price) values (6, '1288', 'n', 'Laser', 400.00);