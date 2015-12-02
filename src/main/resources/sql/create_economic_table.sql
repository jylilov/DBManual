create table Income_o(point smallint, datetime timestamp, inc real);

create table Outcome_o(point smallint, datetime TIMESTAMP, out_m real);

create table Income(code int, point smallint, datetime TIMESTAMP, inc real);

create table Outcome(code int, point smallint, datetime TIMESTAMP, out_m real);

insert into Income_o(point, datetime, inc) values (1, '2001-03-22 00:00:00.000', 15000.0000);
insert into Income_o(point, datetime, inc) values (1, '2001-03-23 00:00:00.000', 15000.0000);
insert into Income_o(point, datetime, inc) values (1, '2001-03-24 00:00:00.000', 3400.0000);
insert into Income_o(point, datetime, inc) values (1, '2001-04-13 00:00:00.000', 5000.0000);
insert into Income_o(point, datetime, inc) values (1, '2001-05-11 00:00:00.000', 4500.0000);
insert into Income_o(point, datetime, inc) values (2, '2001-03-22 00:00:00.000', 10000.0000);
insert into Income_o(point, datetime, inc) values (2, '2001-03-24 00:00:00.000', 1500.0000);
insert into Income_o(point, datetime, inc) values (3, '2001-09-13 00:00:00.000', 11500.0000);
insert into Income_o(point, datetime, inc) values (3, '2001-10-02 00:00:00.000', 18000.0000);

insert into Outcome_o(point, datetime, out_m) values (1, '2001-03-14 00:00:00.000', 15348.0000);
insert into Outcome_o(point, datetime, out_m) values (1, '2001-03-24 00:00:00.000', 3663.0000);
insert into Outcome_o(point, datetime, out_m) values (1, '2001-03-26 00:00:00.000', 1221.0000);
insert into Outcome_o(point, datetime, out_m) values (1, '2001-03-28 00:00:00.000', 2075.0000);
insert into Outcome_o(point, datetime, out_m) values (1, '2001-03-29 00:00:00.000', 2004.0000);
insert into Outcome_o(point, datetime, out_m) values (1, '2001-04-11 00:00:00.000', 3195.0400);
insert into Outcome_o(point, datetime, out_m) values (1, '2001-04-13 00:00:00.000', 4490.0000);
insert into Outcome_o(point, datetime, out_m) values (1, '2001-04-27 00:00:00.000', 3110.0000);
insert into Outcome_o(point, datetime, out_m) values (1, '2001-05-11 00:00:00.000', 2530.0000);
insert into Outcome_o(point, datetime, out_m) values (2, '2001-03-22 00:00:00.000', 1440.0000);
insert into Outcome_o(point, datetime, out_m) values (2, '2001-03-29 00:00:00.000', 7848.0000);
insert into Outcome_o(point, datetime, out_m) values (2, '2001-04-02 00:00:00.000', 2040.0000);
insert into Outcome_o(point, datetime, out_m) values (3, '2001-09-13 00:00:00.000', 1500.0000);
insert into Outcome_o(point, datetime, out_m) values (3, '2001-09-14 00:00:00.000', 2300.0000);
insert into Outcome_o(point, datetime, out_m) values (3, '2002-09-16 00:00:00.000', 2150.0000);

insert into Income(code, point, datetime, inc) values (1, 1, '2001-03-22 00:00:00.000', 15000.0000);
insert into Income(code, point, datetime, inc) values (10, 1, '2001-04-13 00:00:00.000', 5000.0000);
insert into Income(code, point, datetime, inc) values (11, 1, '2001-03-24 00:00:00.000', 3400.0000);
insert into Income(code, point, datetime, inc) values (12, 3, '2001-09-13 00:00:00.000', 1350.0000);
insert into Income(code, point, datetime, inc) values (13, 3, '2001-09-13 00:00:00.000', 1750.0000);
insert into Income(code, point, datetime, inc) values (2, 1, '2001-03-23 00:00:00.000', 15000.0000);
insert into Income(code, point, datetime, inc) values (3, 1, '2001-03-24 00:00:00.000', 3600.0000);
insert into Income(code, point, datetime, inc) values (4, 2, '2001-03-22 00:00:00.000', 10000.0000);
insert into Income(code, point, datetime, inc) values (5, 2, '2001-03-24 00:00:00.000', 1500.0000);
insert into Income(code, point, datetime, inc) values (6, 1, '2001-04-13 00:00:00.000', 5000.0000);
insert into Income(code, point, datetime, inc) values (7, 1, '2001-05-11 00:00:00.000', 4500.0000);
insert into Income(code, point, datetime, inc) values (8, 1, '2001-03-22 00:00:00.000', 15000.0000);
insert into Income(code, point, datetime, inc) values (9, 2, '2001-03-24 00:00:00.000', 1500.0000);

insert into Outcome(code, point, datetime, out_m) values (1, 1, '2001-03-14 00:00:00.000', 15348.0000);
insert into Outcome(code, point, datetime, out_m) values (10, 2, '2001-03-22 00:00:00.000', 1440.0000);
insert into Outcome(code, point, datetime, out_m) values (11, 2, '2001-03-29 00:00:00.000', 7848.0000);
insert into Outcome(code, point, datetime, out_m) values (12, 2, '2001-04-02 00:00:00.000', 2040.0000);
insert into Outcome(code, point, datetime, out_m) values (13, 1, '2001-03-24 00:00:00.000', 3500.0000);
insert into Outcome(code, point, datetime, out_m) values (14, 2, '2001-03-22 00:00:00.000', 1440.0000);
insert into Outcome(code, point, datetime, out_m) values (15, 1, '2001-03-29 00:00:00.000', 2006.0000);
insert into Outcome(code, point, datetime, out_m) values (16, 3, '2001-09-13 00:00:00.000', 1200.0000);
insert into Outcome(code, point, datetime, out_m) values (17, 3, '2001-09-13 00:00:00.000', 1500.0000);
insert into Outcome(code, point, datetime, out_m) values (18, 3, '2001-09-14 00:00:00.000', 1150.0000);
insert into Outcome(code, point, datetime, out_m) values (2, 1, '2001-03-24 00:00:00.000', 3663.0000);
insert into Outcome(code, point, datetime, out_m) values (3, 1, '2001-03-26 00:00:00.000', 1221.0000);
insert into Outcome(code, point, datetime, out_m) values (4, 1, '2001-03-28 00:00:00.000', 2075.0000);
insert into Outcome(code, point, datetime, out_m) values (5, 1, '2001-03-29 00:00:00.000', 2004.0000);
insert into Outcome(code, point, datetime, out_m) values (6, 1, '2001-04-11 00:00:00.000', 3195.0400);
insert into Outcome(code, point, datetime, out_m) values (7, 1, '2001-04-13 00:00:00.000', 4490.0000);
insert into Outcome(code, point, datetime, out_m) values (8, 1, '2001-04-27 00:00:00.000', 3110.0000);
insert into Outcome(code, point, datetime, out_m) values (9, 1, '2001-05-11 00:00:00.000', 2530.0000);