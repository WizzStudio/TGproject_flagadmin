 INSERT INTO `admin` VALUES (1, 0, 'test1', 'test1');
 INSERT INTO admin VALUES (2, 3, 'test2', 'test2');
 INSERT INTO admin VALUES (3, 4, 'test3', 'test3');
 INSERT INTO admin VALUES (4, 3, 'test4', 'test4');
 INSERT INTO admin VALUES (5, 4, 'test5', 'test5');

 INSERT INTO department VALUES (1, 'authcode', 1, 'depart name'), (2, 'authcode2', 1, 'depart name2'), (3, '123123', 1, 'aaab');

 INSERT INTO place VALUES (1, 0, 0, 'description', 0, 'place name');
 INSERT INTO place VALUES (3, 2, 0, 'description', 2, 'place name1');
 INSERT INTO place VALUES (2, 2, 0, 'description', 2, 'place name2');
 INSERT INTO place VALUES (4, 2, 0, 'description', 2, 'place name3');

 INSERT INTO user VALUES (1, 1, 'user name', 'openid', 'position', 0, '161310000');

 insert into place_order values(1,1,1,1,current_timestamp,1,current_timestamp,1,1,1,1,1,current_timestamp,0,1,current_timestamp);

 INSERT INTO council_order values (1, 'subject1', 'name1', 2, current_timestamp, current_timestamp, 'equip1', null, 10, 10, '123456', 'admin1', 'measuer1', current_timestamp, 0, 'team1', 1, current_timestamp), (2, 'subject2', 'name1', 2, current_timestamp, current_timestamp, 'equip1', null, 10, 10, '123456', 'admin1', 'measuer1', current_timestamp, 1, 'team1', 1, current_timestamp), (3, 'subject3', 'name1', 2, current_timestamp, current_timestamp, 'equip1', null, 10, 10, '123456', 'admin1', 'measuer1', current_timestamp, 2, 'team1', 1, current_timestamp), (4, 'subject4', 'name1', 2, current_timestamp, current_timestamp, 'equip1', null, 10, 10, '123456', 'admin1', 'measuer1', current_timestamp, 3, 'team1', 1, current_timestamp), (5, 'subject5', 'name1', 2, current_timestamp, current_timestamp, 'equip1', null, 10, 10, '123456', 'admin1', 'measuer1', current_timestamp, 4, 'team1', 1, current_timestamp);
 INSERT INTO council_order values (6, 'subject1', 'name1', 2, '2018-04-06 18:00:000', '2018-04-06 19:00:000', 'equip1', null, 10, 10, '123456', 'admin1', 'measuer1',  '2018-04-06 17:00:000', 0, 'team1', 1, current_timestamp), (7, 'subject2', 'name1', 2,  '2018-04-07 18:00:000',  '2018-04-07 19:00:000', 'equip1', null, 0, 10, '123456', 'admin1', 'measuer1',  '2018-04-07 17:00:000', 0, 'team1', 1, current_timestamp);
