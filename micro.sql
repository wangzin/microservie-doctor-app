/*
SQLyog Ultimate v8.82 
MySQL - 5.0.86-community-nt : Database - micro
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`micro` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `micro`;

/*Table structure for table `schedule_detail` */

DROP TABLE IF EXISTS `schedule_detail`;

CREATE TABLE `schedule_detail` (
  `Id` int(3) NOT NULL auto_increment,
  `scheduleDetailId` bigint(20) default NULL,
  `appointmentStatus` char(1) NOT NULL,
  `availableFrom` varchar(255) NOT NULL,
  `availableTo` varchar(255) NOT NULL,
  `createdBy` varchar(255) NOT NULL,
  `createdDate` datetime NOT NULL,
  `scheduleDate` varchar(255) NOT NULL,
  `updatedBy` varchar(255) default NULL,
  `updatedDate` datetime default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `schedule_detail` */

insert  into `schedule_detail`(`Id`,`scheduleDetailId`,`appointmentStatus`,`availableFrom`,`availableTo`,`createdBy`,`createdDate`,`scheduleDate`,`updatedBy`,`updatedDate`) values (1,3,'A','3:00PM','4:00PM','Doctor','2020-10-23 14:18:21','23-Oct-2020','Doctor','2020-10-23 14:18:21'),(3,3,'B','3:00PM','5:00PM','Doctor','2020-10-24 00:00:00','23-Oct-2020',NULL,NULL);

/*Table structure for table `schedule_master` */

DROP TABLE IF EXISTS `schedule_master`;

CREATE TABLE `schedule_master` (
  `Id` int(3) NOT NULL auto_increment,
  `scheduleDate` varchar(255) NOT NULL,
  `doctorId` varchar(255) NOT NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `schedule_master` */

insert  into `schedule_master`(`Id`,`scheduleDate`,`doctorId`) values (1,'23-Oct-2020','1'),(2,'23-Oct-2020','2'),(3,'24-Oct-2020','1'),(4,'24-Oct-2020','2');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL auto_increment,
  `birthdayDate` datetime NOT NULL,
  `email` varchar(255) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `gender` char(1) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `users` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
