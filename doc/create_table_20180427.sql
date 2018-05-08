drop table `bus_user`;
CREATE TABLE `bus_user` (
  `user_id`          varchar(12) NOT NULL,
  `user_name`        varchar(100) DEFAULT NULL,
  `user_passwd`      varchar(50) DEFAULT NULL,
  `user_tell`        varchar(20) DEFAULT NULL,
  `user_line`        varchar(1) DEFAULT NULL,
  `user_mode`        varchar(1) DEFAULT NULL,
  `user_longitude`   varchar(10) DEFAULT NULL,
  `user_latitude`    varchar(10) DEFAULT NULL,
  `user_chgdt`       varchar(8) DEFAULT NULL,
  `user_chgtm`       varchar(12) DEFAULT NULL,  
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


insert into `bus_user` values('ling123','小林','123456','13511111111','1','P','11111.1234','11111.5678','20180208','072500');
insert into `bus_user` values('zhou123','周总','123456','13522222222','2','P','22222.1234','22222.5678','20180208','072500');
insert into `bus_user` values('chen123','老陈','123456','13533333333','3','D','33333.1234','33333.5678','20180208','072500');

drop table `bus_line`;
CREATE TABLE `bus_line` (
  `line_id`          varchar(1) NOT NULL,
  `line_stanum`        varchar(2) NOT NULL,
  `line_staname`      varchar(200) DEFAULT NULL,
  `line_longitude`        varchar(10) DEFAULT NULL,
  `line_latitude`        varchar(10) DEFAULT NULL,
  `line_uptime`        varchar(12) DEFAULT NULL,
  `line_downtime`   varchar(12) DEFAULT NULL,
  `line_chgdt`       varchar(8) DEFAULT NULL,
  `line_chgtm`       varchar(12) DEFAULT NULL,
  PRIMARY KEY (`line_id`,`line_stanum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `bus_line` values('1','1','坪洲地铁站','116.481028','36.989643','072300','181000','20180208','072500');
insert into `bus_line` values('1','2','同仁医院','115.481028','35.989643','072300','181000','20180208','072500');
insert into `bus_line` values('1','3','西乡路口','115.581028','35.089643','072300','181000','20180208','072500');
insert into `bus_line` values('1','4','群贤花园','114.481028','34.989643','072300','181000','20180208','072500');
insert into `bus_line` values('1','5','宝体东','113.481028','33.989643','072300','181000','20180208','072500');
insert into `bus_line` values('1','6','径贝花园','112.481028','32.989643','072300','181000','20180208','072500');
insert into `bus_line` values('1','7','南头检查站','111.481028','31.989643','072300','181000','20180208','072500');



insert into `bus_line` values('2','1','宝体东','11111.1234','11111.5678','072300','181000','20180208','072500');
insert into `bus_line` values('2','2','径贝花园','11111.1234','11111.5678','072300','181000','20180208','072500');
insert into `bus_line` values('2','3','南头检查站','11111.1234','11111.5678','072300','181000','20180208','072500');

insert into `bus_line` values('3','1','西丽地铁站','11111.1234','11111.5678','072300','181000','20180208','072500');
insert into `bus_line` values('3','2','茶光村口','11111.1234','11111.5678','072300','181000','20180208','072500');
insert into `bus_line` values('3','3','朗山路口','11111.1234','11111.5678','072300','181000','20180208','072500');

drop table `bus_bus`;
CREATE TABLE `bus_bus` (
  `bus_id`          varchar(1) NOT NULL,
  `bus_num`        varchar(100) DEFAULT NULL,
  `bus_line`      varchar(1) DEFAULT NULL,
  `bus_driver`        varchar(100) DEFAULT NULL,
  `bus_tell`        varchar(20) DEFAULT NULL,
  `bus_longitude1`        varchar(10) DEFAULT NULL,
  `bus_latitude1`   varchar(10) DEFAULT NULL,
  `bus_longitude2`        varchar(10) DEFAULT NULL,
  `bus_latitude2`   varchar(10) DEFAULT NULL,
  `bus_longitude3`        varchar(10) DEFAULT NULL,
  `bus_latitude3`   varchar(10) DEFAULT NULL,
  `bus_uploadid`   varchar(12) DEFAULT NULL,
  `bus_uploaddt`   varchar(8) DEFAULT NULL,
  `bus_uploadtm`   varchar(12) DEFAULT NULL,
  `bus_laststa`        varchar(200) DEFAULT NULL,
  `bus_lasttm`      varchar(12) DEFAULT NULL,
  `bus_nextsta`        varchar(200) DEFAULT NULL,
  `bus_nexttm`        varchar(12) DEFAULT NULL,
  `bus_nextdis`        varchar(200) DEFAULT NULL,
  `bus_chgdt`       varchar(8) DEFAULT NULL,
  `bus_chgtm`       varchar(12) DEFAULT NULL,
  PRIMARY KEY (`bus_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `bus_bus` values('1','B11boc','1','周师傅','13511111111','116.481028','39.989643','114.481028','39.989643','115.481028','39.989643','ling123','20180208','102400','1','072300','2','073000','1000m','20180208','072500');
insert into `bus_bus` values('2','B22boc','2','陈师傅','13522222222','116.481028','39.989643','114.481028','39.989643','115.481028','39.989643','ling123','20180208','102400','1','072300','2','073000','1000m','20180208','072500');
insert into `bus_bus` values('3','B33boc','3','李师傅','13533333333','116.481028','39.989643','114.481028','39.989643','115.481028','39.989643','ling123','20180208','102400','1','072300','2','073000','1000m','20180208','072500');