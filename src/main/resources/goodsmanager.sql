CREATE DATABASE  IF NOT EXISTS `spring_cahce`;
use `spring_cahce`;

DROP TABLE  if exists `user`;
create table `user`(
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

DROP TABLE if exists `goods_type`;
create table `goods_type` (
 `id` int(11) not null AUTO_INCREMENT primary key,
 `goods_type` varchar(100) not null
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

DROP TABLE if exists `goods`;
create table `goods` (
`id` int(11) not null AUTO_INCREMENT,
`info` varchar(100) not null,
`goodstype` int(11) not null,
`estimate` varchar(100) not null,
primary key(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
Alter 	table `goods` add foreign key(`goodstype`)references `goods_type`(`id`);