/*
SQLyog Enterprise v12.09 (64 bit)
MySQL - 5.7.18-log : Database - test
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `userinfo_id` varchar(128) NOT NULL,
  `username` varchar(32) DEFAULT NULL,
  `userpassword` varchar(64) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `age` varchar(6) DEFAULT NULL,
  `createtime` varchar(32) DEFAULT NULL,
  `loginname` varchar(32) DEFAULT NULL,
  `aboutuser` varchar(1024) DEFAULT NULL,
  `Email` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`userinfo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

insert  into `userinfo`(`userinfo_id`,`username`,`userpassword`,`sex`,`address`,`age`,`createtime`,`loginname`,`aboutuser`,`Email`) values ('0ee8cc7e-3c47-46fa-b5b1-68ec315f66f9','小狗','4321','男','安徽','23','2017-09-19 17:38:38',NULL,NULL,NULL),('5447857a-d7c3-4aa8-9db1-a7522bea0a23','小猪','1234','男','23','安徽','2017-09-20 10:39:47',NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
