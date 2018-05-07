CREATE TABLE `t_user` (
  `user_id`          int(11) NOT NULL auto_increment,
  `user_name`        varchar(30) DEFAULT NULL,
  `credits`          int(11) DEFAULT NULL,
  `password`         varchar(32) DEFAULT NULL,
  `last_visit`       datetime DEFAULT NULL,
  `last_ip`          varchar(23) DEFAULT NULL, 
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `t_user` values('001','linyk3','444444444','111111','20180411','22.11.11.00');
insert into `t_user` values('002','admin','123456','111111','20180411','22.11.11.00');

CREATE TABLE `t_login_log` (
	`login_log_id`     int(11) NOT NULL auto_increment, 
	`user_id`          int(11) DEFAULT NULL, 
	`ip`               varchar(23) DEFAULT NULL,
	`login_datetime`   datetime DEFAULT NULL,
	PRIMARY KEY (`login_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `t_login_log` values(
	'00000001','001','22.11.11.00','2018-04-11 00:00:00.0');
