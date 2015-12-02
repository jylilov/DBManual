create table utQ (Q_ID int, Q_NAME varchar(35));

create table utB (B_Q_ID int, B_V_ID int, B_VOL smallint, B_DATETIME timestamp);

create table utV (V_ID int, V_NAME varchar(35), V_COLOR char(1)); 


insert into utQ(Q_ID, Q_NAME) values (1, 'Square # 01');
insert into utQ(Q_ID, Q_NAME) values (10, 'Square # 10');
insert into utQ(Q_ID, Q_NAME) values (11, 'Square # 11');
insert into utQ(Q_ID, Q_NAME) values (12, 'Square # 12');
insert into utQ(Q_ID, Q_NAME) values (13, 'Square # 13');
insert into utQ(Q_ID, Q_NAME) values (14, 'Square # 14');
insert into utQ(Q_ID, Q_NAME) values (15, 'Square # 15');
insert into utQ(Q_ID, Q_NAME) values (16, 'Square # 16');
insert into utQ(Q_ID, Q_NAME) values (17, 'Square # 17');
insert into utQ(Q_ID, Q_NAME) values (18, 'Square # 18');
insert into utQ(Q_ID, Q_NAME) values (19, 'Square # 19');
insert into utQ(Q_ID, Q_NAME) values (2, 'Square # 02');
insert into utQ(Q_ID, Q_NAME) values (20, 'Square # 20');
insert into utQ(Q_ID, Q_NAME) values (21, 'Square # 21');
insert into utQ(Q_ID, Q_NAME) values (22, 'Square # 22');
insert into utQ(Q_ID, Q_NAME) values (23, 'Square # 23');
insert into utQ(Q_ID, Q_NAME) values (25, 'Square # 25');
insert into utQ(Q_ID, Q_NAME) values (3, 'Square # 03');
insert into utQ(Q_ID, Q_NAME) values (4, 'Square # 04');
insert into utQ(Q_ID, Q_NAME) values (5, 'Square # 05');
insert into utQ(Q_ID, Q_NAME) values (6, 'Square # 06');
insert into utQ(Q_ID, Q_NAME) values (7, 'Square # 07');
insert into utQ(Q_ID, Q_NAME) values (8, 'Square # 08');
insert into utQ(Q_ID, Q_NAME) values (9, 'Square # 09');

insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2000-01-01 01:13:36.000', 22, 50, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2001-01-01 01:13:37.000', 22, 50, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2002-01-01 01:13:38.000', 22, 51, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2002-06-01 01:13:39.000', 22, 51, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:01.000', 1, 1, 155
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:03.000', 2, 2, 255
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:04.000', 3, 3, 255
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:05.000', 1, 4, 255
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:06.000', 2, 5, 255
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:07.000', 3, 6, 255
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:08.000', 1, 7, 255
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:09.000', 2, 8, 255
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:10.000', 3, 9, 255
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:11.000', 4, 10, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:12.000', 5, 11, 100
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:13.000', 5, 12, 155
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:14.000', 5, 13, 155
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:15.000', 5, 14, 100
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:16.000', 5, 15, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:17.000', 5, 16, 205
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:18.000', 6, 10, 155
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:19.000', 6, 17, 100
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:20.000', 6, 18, 255
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:21.000', 6, 19, 255
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:22.000', 7, 17, 155
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:23.000', 7, 20, 100
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:24.000', 7, 21, 255
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:25.000', 7, 22, 255
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:26.000', 8, 10, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:27.000', 9, 23, 255
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:28.000', 9, 24, 255
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:29.000', 9, 25, 100
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:30.000', 9, 26, 155
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:31.000', 10, 25, 155
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:31.000', 10, 26, 100
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:33.000', 10, 27, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:34.000', 10, 28, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:35.000', 10, 29, 245
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:36.000', 10, 30, 245
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:37.000', 11, 31, 100
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:38.000', 11, 32, 100
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:39.000', 11, 33, 100
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:40.000', 11, 34, 155
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:41.000', 11, 35, 155
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:42.000', 11, 36, 155
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:43.000', 12, 31, 155
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:44.000', 12, 32, 155
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:45.000', 12, 33, 155
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:46.000', 12, 34, 100
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:47.000', 12, 35, 100
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:12:48.000', 12, 36, 100
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:01.000', 4, 37, 20
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:02.000', 8, 38, 20
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:03.000', 13, 39, 123
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:04.000', 14, 39, 111
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:05.000', 14, 40, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:05.000', 4, 37, 185
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:06.000', 15, 41, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:07.000', 15, 41, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:08.000', 15, 42, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:09.000', 15, 42, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:10.000', 16, 42, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:11.000', 16, 42, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:12.000', 16, 43, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:13.000', 16, 43, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:14.000', 16, 47, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:15.000', 17, 44, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:16.000', 17, 44, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:17.000', 17, 45, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:18.000', 17, 45, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:24.000', 19, 44, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:25.000', 19, 45, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-01-01 01:13:26.000', 19, 45, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-02-01 01:13:19.000', 18, 45, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-02-01 01:13:27.000', 20, 45, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-02-01 01:13:31.000', 21, 49, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-02-02 01:13:32.000', 21, 49, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-02-03 01:13:33.000', 21, 50, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-02-04 01:13:34.000', 21, 50, 50
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-02-05 01:13:35.000', 21, 48, 1
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-03-01 01:13:20.000', 18, 45, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-03-01 01:13:28.000', 20, 45, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-04-01 01:13:21.000', 18, 46, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-04-01 01:13:29.000', 20, 46, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-05-01 01:13:22.000', 18, 46, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-05-01 01:13:30.000', 20, 46, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-06-11 01:13:23.000', 19, 44, 10
insert into utB(B_DATETIME, B_Q_ID, B_V_ID, B_VOL) values ('2003-06-23 01:12:02.000', 1, 1, 100

insert into utV(V_ID, V_NAME, V_COLOR) values (1, 'Balloon # 01', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (10, 'Balloon # 10', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (11, 'Balloon # 11', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (12, 'Balloon # 12', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (13, 'Balloon # 13', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (14, 'Balloon # 14', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (15, 'Balloon # 15', 'B');
insert into utV(V_ID, V_NAME, V_COLOR) values (16, 'Balloon # 16', 'B');
insert into utV(V_ID, V_NAME, V_COLOR) values (17, 'Balloon # 17', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (18, 'Balloon # 18', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (19, 'Balloon # 19', 'B');
insert into utV(V_ID, V_NAME, V_COLOR) values (2, 'Balloon # 02', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (20, 'Balloon # 20', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (21, 'Balloon # 21', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (22, 'Balloon # 22', 'B');
insert into utV(V_ID, V_NAME, V_COLOR) values (23, 'Balloon # 23', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (24, 'Balloon # 24', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (25, 'Balloon # 25', 'B');
insert into utV(V_ID, V_NAME, V_COLOR) values (26, 'Balloon # 26', 'B');
insert into utV(V_ID, V_NAME, V_COLOR) values (27, 'Balloon # 27', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (28, 'Balloon # 28', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (29, 'Balloon # 29', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (3, 'Balloon # 03', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (30, 'Balloon # 30', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (31, 'Balloon # 31', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (32, 'Balloon # 32', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (33, 'Balloon # 33', 'B');
insert into utV(V_ID, V_NAME, V_COLOR) values (34, 'Balloon # 34', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (35, 'Balloon # 35', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (36, 'Balloon # 36', 'B');
insert into utV(V_ID, V_NAME, V_COLOR) values (37, 'Balloon # 37', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (38, 'Balloon # 38', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (39, 'Balloon # 39', 'B');
insert into utV(V_ID, V_NAME, V_COLOR) values (4, 'Balloon # 04', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (40, 'Balloon # 40', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (41, 'Balloon # 41', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (42, 'Balloon # 42', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (43, 'Balloon # 43', 'B');
insert into utV(V_ID, V_NAME, V_COLOR) values (44, 'Balloon # 44', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (45, 'Balloon # 45', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (46, 'Balloon # 46', 'B');
insert into utV(V_ID, V_NAME, V_COLOR) values (47, 'Balloon # 47', 'B');
insert into utV(V_ID, V_NAME, V_COLOR) values (48, 'Balloon # 48', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (49, 'Balloon # 49', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (5, 'Balloon # 05', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (50, 'Balloon # 50', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (51, 'Balloon # 51', 'B');
insert into utV(V_ID, V_NAME, V_COLOR) values (52, 'Balloon # 52', 'R');
insert into utV(V_ID, V_NAME, V_COLOR) values (53, 'Balloon # 53', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (54, 'Balloon # 54', 'B');
insert into utV(V_ID, V_NAME, V_COLOR) values (6, 'Balloon # 06', 'G');
insert into utV(V_ID, V_NAME, V_COLOR) values (7, 'Balloon # 07', 'B');
insert into utV(V_ID, V_NAME, V_COLOR) values (8, 'Balloon # 08', 'B');
insert into utV(V_ID, V_NAME, V_COLOR) values (9, 'Balloon # 09', 'B');


