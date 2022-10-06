/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.38 : Database - yan_chao
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yan_chao` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `yan_chao`;

/*Table structure for table `activity` */

DROP TABLE IF EXISTS `activity`;

CREATE TABLE `activity` (
  `activity_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `title` varchar(50) NOT NULL,
  `participate_num` int(11) DEFAULT '0',
  `activity_desc` varchar(1000) NOT NULL,
  `submit_email` varchar(20) NOT NULL,
  `deadline` datetime NOT NULL,
  `over` tinyint(1) DEFAULT '0',
  `stu_name` tinyint(1) DEFAULT '0',
  `stu_id` tinyint(1) DEFAULT '0',
  `clazz` tinyint(1) DEFAULT '0',
  `phone_num` tinyint(1) DEFAULT '0',
  `qq` tinyint(1) DEFAULT '0',
  `stu_email` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `activity` */

insert  into `activity`(`activity_id`,`user_id`,`create_time`,`title`,`participate_num`,`activity_desc`,`submit_email`,`deadline`,`over`,`stu_name`,`stu_id`,`clazz`,`phone_num`,`qq`,`stu_email`) values 
(1,2,'2022-05-08 16:05:41','11111',4,'大家想回学校','290249675@qq.com','2022-05-12 00:00:00',0,0,0,0,0,0,0),
(2,1,'2022-05-08 16:59:38','返校不',0,'大家想回学校','290249675@qq.com','2022-05-12 00:00:00',0,0,0,0,0,0,0),
(3,2,'2022-05-08 19:55:43','蓝桥杯比赛报名',0,'蓝桥杯比赛报名,希望大家参加2','290249675@qq.com','2022-05-08 19:55:43',0,0,0,0,0,0,0),
(4,2,'2022-05-08 16:05:41','返校',1,'大家不要参加啊','290249675@qq.com','2022-05-08 16:05:41',0,1,1,1,1,1,1),
(5,2,'2022-06-18 12:43:57','最新测试',4,'非常牛马的燕巢论坛就要展开活动列表测试了，你说牛不牛，赶紧来测试！','290249675@qq.com','2022-09-01 02:05:41',0,1,1,0,1,0,1),
(6,2,'2022-06-29 12:48:05','最新测试2',0,'1111111111111111111111111111','290249675@qq.com','2022-09-04 02:05:41',0,1,1,0,1,0,1),
(7,2,'2022-06-29 13:15:12','最新测试2',0,'2222222','290249675@qq.com','2022-09-04 02:05:41',0,1,1,0,1,0,1),
(8,2,'2022-06-29 13:49:07','最新测试44',0,'4444444444','290249675@qq.com','2022-09-04 02:05:41',0,1,1,0,1,0,1),
(9,2,'2022-06-29 13:52:05','55',0,'5555','290249675@qq.com','2022-09-04 02:05:41',0,0,1,0,1,0,1),
(10,2,'2022-06-29 13:56:56','hhhhhhhhhhh',0,'123123123','true','2022-09-04 02:05:41',0,1,1,1,0,0,1),
(11,2,'2022-06-29 13:57:34','678',0,'890','true','2022-09-04 02:05:41',0,1,1,1,0,0,1),
(12,2,'2022-10-03 13:09:54','测试linux下的邮件系统如何？',0,'linux','290249675@qq.com','2022-09-04 02:05:41',0,1,1,0,1,0,1),
(13,2,'2022-10-03 13:10:50','测试linux下的邮件系统如何？',2,'linux','290249675@qq.com','2022-10-03 02:05:41',0,1,1,0,1,0,1),
(14,11,'2022-10-04 10:14:02','哈哈哈哈哈',0,'ccccc','1296725034@qq.com','2022-10-03 02:05:41',0,1,1,0,0,0,0);

/*Table structure for table `activity_commit` */

DROP TABLE IF EXISTS `activity_commit`;

CREATE TABLE `activity_commit` (
  `activity_commit_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `activity_id` int(11) NOT NULL,
  `stu_name` varchar(5) DEFAULT NULL,
  `stu_id` char(12) DEFAULT NULL,
  `clazz` int(11) DEFAULT NULL,
  `phone_num` char(11) DEFAULT NULL,
  `qq` varchar(15) DEFAULT NULL,
  `stu_email` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`activity_commit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `activity_commit` */

insert  into `activity_commit`(`activity_commit_id`,`user_id`,`activity_id`,`stu_name`,`stu_id`,`clazz`,`phone_num`,`qq`,`stu_email`) values 
(1,1,1,'魂之子','201911040113',4,'13180961888','290249675',NULL),
(2,1,1,'魂之子','201911040113',4,'13179290325','290249675','290249675@qq.com'),
(3,2,1,'张牛子','201911040114',4,'18728828603','1296725034','1296725034@qq.com'),
(4,2,5,'牛','1',NULL,'19932715039','3445218889','1296725034@qq.com'),
(5,2,5,'牛','1',NULL,'19932715039','3445218889','1296725034@qq.com'),
(6,4,5,'牛','1',NULL,'19932715039','3445218889','1296725034@qq.com'),
(7,4,5,'321','32',NULL,'1211121','','4565'),
(8,4,1,'','',NULL,'','',''),
(9,4,4,'周少','201911040113',NULL,'123456789','2216546546','hunzhizi@163.com'),
(10,2,13,'周少','201911040114',4,'18728828603','1296725034','1296725034@qq.com'),
(11,2,13,'周少','201911040114',4,'18728828603','1296725034','290249675@qq.com');

/*Table structure for table `certificate` */

DROP TABLE IF EXISTS `certificate`;

CREATE TABLE `certificate` (
  `certificate_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `stu_name` varchar(10) DEFAULT NULL,
  `stu_id` varchar(12) DEFAULT NULL,
  `desc` varchar(100) DEFAULT NULL,
  `img_addr` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`certificate_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `certificate` */

insert  into `certificate`(`certificate_id`,`user_id`,`stu_name`,`stu_id`,`desc`,`img_addr`) values 
(1,1,NULL,NULL,'建巢者认证',NULL);

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL,
  `up_num` int(11) NOT NULL,
  `down_num` int(11) NOT NULL,
  `content` varchar(1000) NOT NULL,
  `comment_create_time` datetime NOT NULL,
  `parent_comment_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

/*Data for the table `comment` */

insert  into `comment`(`comment_id`,`user_id`,`post_id`,`up_num`,`down_num`,`content`,`comment_create_time`,`parent_comment_id`) values 
(1,2,3,100,3,'鼠鼠不想返校捏','2022-05-08 12:54:45',NULL),
(2,2,3,9,9,'xdm，有无知道什么时候放暑假的','2022-05-08 12:59:58',NULL),
(3,2,3,3,4,'6月份返校考试了捏','2022-05-08 13:39:36',NULL),
(4,2,1,0,0,'我是建巢者之一捏，欢迎大家来到燕巢','2022-05-22 15:37:02',NULL),
(5,2,1,1,0,'我是建巢者之一捏，我叫张傻傻，欢迎大家来到燕巢','2022-05-22 16:12:19',NULL),
(6,2,5,0,0,'我牛马','2022-06-02 13:00:11',NULL),
(7,2,8,0,0,'我牛马','2022-06-02 13:01:31',NULL),
(8,2,1,0,0,'hhhhhhhhhhhhhhhh','2022-06-03 07:59:52',NULL),
(9,2,1,0,0,'test','2022-06-03 08:05:24',NULL),
(10,2,1,0,0,'TETT','2022-06-03 08:06:21',NULL),
(11,2,1,0,0,'确实','2022-06-03 08:21:20',NULL),
(12,2,8,0,0,'你先别急','2022-06-03 08:22:14',NULL),
(13,2,9,0,0,'真不错','2022-06-04 10:52:16',NULL),
(14,2,9,0,0,'非常不错','2022-06-04 10:52:29',NULL),
(15,2,9,0,0,'test','2022-06-05 02:10:59',NULL),
(16,2,9,0,0,'123','2022-06-22 14:12:39',NULL),
(17,2,9,0,0,'321','2022-06-22 14:14:14',NULL),
(18,2,48,0,0,'123','2022-08-24 11:22:54',NULL),
(19,2,3,0,0,'我是建巢者之一捏，我叫张傻傻，欢迎大家来到燕巢','2022-08-26 08:28:19',3),
(20,11,21,0,0,'？','2022-10-04 13:08:32',NULL),
(21,11,71,2,0,'不愧是我的华为p30战狼冷锋爱国红，速度真快','2022-10-04 13:17:15',NULL),
(22,11,11,0,0,'牛','2022-10-04 13:17:45',NULL),
(23,11,71,1,0,'111','2022-10-04 13:28:22',NULL),
(24,11,71,0,0,'222','2022-10-04 13:30:05',NULL),
(25,11,66,0,0,'33','2022-10-04 13:31:52',NULL),
(26,11,74,0,0,'图片效率过慢','2022-10-05 05:46:45',NULL),
(27,13,74,0,0,'冒个泡','2022-10-06 05:37:00',NULL);

/*Table structure for table `my_collection` */

DROP TABLE IF EXISTS `my_collection`;

CREATE TABLE `my_collection` (
  `user_id` int(11) NOT NULL,
  `post_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `my_collection` */

insert  into `my_collection`(`user_id`,`post_id`) values 
(1,9),
(55,11),
(55,11),
(55,11),
(55,11),
(11,9),
(13,9),
(12,9);

/*Table structure for table `post` */

DROP TABLE IF EXISTS `post`;

CREATE TABLE `post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `up_num` int(11) NOT NULL DEFAULT '0',
  `collection_num` int(11) NOT NULL DEFAULT '0',
  `comment_num` int(11) NOT NULL DEFAULT '0',
  `report_num` int(11) NOT NULL DEFAULT '0',
  `content` varchar(1000) NOT NULL,
  `create_time` datetime NOT NULL,
  `last_edit_time` datetime NOT NULL,
  `post_type` int(11) NOT NULL DEFAULT '0',
  `img_addr_list` varchar(1000) DEFAULT NULL,
  `priority` int(11) NOT NULL DEFAULT '0',
  `parent_zhi_hu` int(11) DEFAULT NULL,
  PRIMARY KEY (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

/*Data for the table `post` */

insert  into `post`(`post_id`,`user_id`,`up_num`,`collection_num`,`comment_num`,`report_num`,`content`,`create_time`,`last_edit_time`,`post_type`,`img_addr_list`,`priority`,`parent_zhi_hu`) values 
(1,1,10,0,5,0,'欢迎来到燕巢','2022-05-02 11:05:28','2022-10-06 14:14:28',0,NULL,-77,NULL),
(3,1,0,0,1,0,'今天天气不错，粗去玩！！！！#@￥@','2022-05-02 12:57:24','2022-10-06 12:10:14',0,NULL,-142,NULL),
(4,1,0,0,0,0,'阿珍爱上了阿强','2022-05-02 12:57:56','2022-10-06 14:14:24',0,NULL,-157,NULL),
(5,1,0,0,1,0,'我爱iu~~~~~~~~~~~~','2022-05-02 12:58:10','2022-10-06 14:14:24',0,NULL,-143,NULL),
(6,1,0,0,0,0,'听说黄老板出新专辑了','2022-05-02 12:58:43','2022-10-06 14:14:26',0,NULL,-157,NULL),
(7,1,0,0,0,0,'兄弟们，有无约球的？','2022-05-02 12:59:07','2022-10-06 12:10:14',0,NULL,-156,NULL),
(8,1,0,0,2,0,'马上又要答辩了捏，好紧张啊','2022-05-22 13:13:50','2022-10-06 14:14:10',0,NULL,-109,NULL),
(9,1,124,3,5,0,'我爱iu我爱iu我爱iu~~~~~~~~~~~~','2022-05-22 13:32:01','2022-10-06 14:17:42',0,NULL,0,NULL),
(10,1,0,-1,0,0,'我爱iu~~~~~~~~~~~~','2022-05-29 08:39:43','2022-10-06 14:14:21',0,NULL,-133,NULL),
(14,1,0,0,0,0,'表白zny！','2022-06-03 12:19:02','2022-10-06 14:14:17',0,NULL,-125,NULL),
(15,1,0,0,0,0,'燕巢确实顶呱呱','2022-06-03 12:19:48','2022-10-06 14:14:21',0,NULL,-125,NULL),
(16,1,0,0,0,0,'生活不易，谁都叹气','2022-06-03 12:20:52','2022-10-06 12:07:25',0,NULL,-124,NULL),
(17,1,0,0,0,0,'今天2022，6.4','2022-06-04 10:53:33','2022-10-06 14:14:17',0,NULL,-124,NULL),
(18,1,0,0,0,0,'燕巢确实顶呱呱123','2022-06-05 02:11:12','2022-10-06 14:14:10',0,NULL,-123,NULL),
(21,1,0,0,1,0,'1+1=？','2022-06-24 10:18:14','2022-10-06 14:22:25',2,NULL,-90,NULL),
(22,1,2,0,0,0,'出售二手电动车，加Q12346','2022-06-24 10:19:57','2022-10-06 14:23:00',3,NULL,-102,NULL),
(23,1,0,0,0,0,'出售二手书桌，加Q12346','2022-06-24 10:20:09','2022-10-06 14:23:00',3,NULL,-104,NULL),
(24,1,0,0,0,0,'出售二手吉他，加Q12346','2022-06-24 10:20:15','2022-10-06 14:23:16',3,NULL,-104,NULL),
(25,1,0,0,0,0,'全新计算机考研复习资料，加Q2312346','2022-06-24 10:20:32','2022-10-06 14:31:58',3,NULL,-104,NULL),
(26,1,0,0,0,0,'其实我是个二次元，压力好大','2022-06-24 12:31:31','2022-10-06 14:20:51',1,NULL,-104,NULL),
(27,1,0,0,0,0,'身边的人都在卷，我不卷怎么办','2022-06-24 12:31:50','2022-10-06 14:20:51',1,NULL,-104,NULL),
(28,2,0,0,0,0,'不想上班了，太累了','2022-06-24 12:32:01','2022-10-06 14:12:04',1,NULL,-104,NULL),
(29,2,0,0,0,0,'芜湖，我成功上岸了兄弟们','2022-06-24 12:32:15','2022-10-06 14:12:04',1,NULL,-104,NULL),
(30,2,2,0,0,0,'今天生日，可是没人给我说生日快乐','2022-06-24 12:32:31','2022-10-06 14:20:51',1,NULL,-102,NULL),
(31,2,0,0,0,0,'人生不可能一帆风顺','2022-06-24 12:32:47','2022-10-06 14:14:40',1,NULL,-104,NULL),
(37,1,0,0,0,0,'开学统计人数','2022-06-29 13:13:13','2022-10-06 14:14:04',0,NULL,-99,NULL),
(38,1,0,0,0,0,'统计人数','2022-06-29 13:14:59','2022-10-06 14:14:30',0,NULL,-99,NULL),
(39,1,0,0,0,0,'燕巢统计','2022-06-29 13:20:50','2022-10-06 14:14:05',0,NULL,-99,NULL),
(40,1,0,0,0,0,'333','2022-06-29 13:23:16','2022-10-06 14:14:05',0,NULL,-99,NULL),
(41,1,0,0,0,0,'3333','2022-06-29 13:26:55','2022-10-06 12:07:13',0,NULL,-98,NULL),
(42,1,0,0,0,0,'333','2022-06-29 13:31:19','2022-10-06 12:07:23',0,NULL,-98,NULL),
(43,1,0,0,0,0,'燕巢确实顶呱呱','2022-06-29 13:34:33','2022-10-06 14:14:07',0,NULL,-99,NULL),
(44,1,0,0,0,0,'333','2022-06-29 13:42:22','2022-10-06 14:14:07',0,NULL,-99,NULL),
(45,1,0,0,0,0,'333','2022-06-29 13:43:42','2022-10-06 14:14:07',0,NULL,-99,NULL),
(46,1,0,0,0,0,'燕巢确实顶呱呱','2022-06-29 13:49:07','2022-10-06 14:14:10',0,NULL,-99,NULL),
(47,1,0,0,0,0,'5555','2022-06-29 13:52:05','2022-10-06 14:14:30',0,NULL,-99,NULL),
(48,1,0,0,1,0,'666','2022-06-29 13:54:36','2022-10-06 14:14:30',0,NULL,-85,NULL),
(49,1,0,0,0,0,'123123123','2022-06-29 13:56:56','2022-10-06 12:07:23',0,NULL,-98,NULL),
(50,1,0,0,0,0,'777','2022-06-29 13:57:20','2022-10-06 14:14:05',0,NULL,-99,NULL),
(51,1,0,0,0,0,'890','2022-06-29 13:57:34','2022-10-06 12:07:19',0,NULL,-98,NULL),
(52,1,0,0,0,0,'0000','2022-06-29 15:33:22','2022-10-06 12:07:24',0,NULL,-98,NULL),
(55,1,2,0,0,0,'2022/8/24','2022-08-24 11:49:15','2022-10-06 14:14:28',0,NULL,-41,NULL),
(59,11,0,0,0,0,'燕巢确实顶呱呱','2022-10-02 07:32:28','2022-10-06 14:14:26',0,NULL,-4,NULL),
(62,11,0,0,0,0,'广场大头','2022-10-02 13:19:29','2022-10-06 14:14:28',0,NULL,-4,NULL),
(64,11,0,0,0,0,'最新表白','2022-10-02 13:48:25','2022-10-06 14:22:20',4,NULL,-4,NULL),
(65,11,0,0,0,0,'ysu头子','2022-10-02 13:48:43','2022-10-06 14:22:20',4,NULL,-4,NULL),
(66,11,1,0,1,0,'user11的第一个活动','2022-10-04 10:12:32','2022-10-06 14:22:09',0,NULL,13,NULL),
(67,11,0,0,0,0,'ccccc','2022-10-04 10:14:02','2022-10-06 14:14:22',0,NULL,-2,NULL),
(68,11,0,0,0,0,'燕巢默认图片','2022-10-04 10:31:03','2022-10-06 14:22:20',4,NULL,-2,NULL),
(69,11,0,0,0,0,'这能叫学术？','2022-10-04 13:10:20','2022-10-06 14:22:56',2,NULL,-2,NULL),
(70,11,0,0,0,0,'为什么不能是学术？','2022-10-04 13:11:12','2022-10-06 14:22:56',2,NULL,-2,NULL),
(71,11,3,0,3,0,'手机上传图片。','2022-10-04 13:15:56','2022-10-06 14:22:09',0,NULL,43,NULL),
(72,11,0,0,0,0,'2022.10.4','2022-10-04 13:32:42','2022-10-06 14:14:26',0,NULL,-2,NULL),
(73,11,0,0,0,0,'图片','2022-10-04 13:33:54','2022-10-06 14:14:26',0,NULL,-2,NULL),
(74,11,1,0,2,0,'第二次行知训练营测试','2022-10-05 05:46:06','2022-10-06 14:22:09',0,NULL,28,NULL),
(75,13,1,0,0,0,'路演测试','2022-10-06 11:27:43','2022-10-06 14:14:22',0,NULL,1,NULL),
(76,12,0,0,0,0,'读个研hhh','2022-10-06 14:22:51','2022-10-06 14:22:56',2,NULL,0,NULL);

/*Table structure for table `post_img` */

DROP TABLE IF EXISTS `post_img`;

CREATE TABLE `post_img` (
  `post_id` int(11) NOT NULL,
  `img_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `post_img` */

insert  into `post_img`(`post_id`,`img_name`) values 
(4,'3c83f7fb-78d1-4a86-aa74-cf8c02f7b80ao.jpg'),
(4,'347da6cf-9a6c-4923-b32e-ee5650d70185o.jpg'),
(10,'636cfc62-e7bd-4521-9a27-a6fcd53efc12d.png'),
(20,'bdbfd1c5-a0f5-4394-bf9f-7be38325acb9w.jpg'),
(20,'681f26b9-d1db-443e-891d-bb6b501e291e4.jpg'),
(36,'13afdb27-658e-4fea-b6e9-b2b38e4492a05.jpg'),
(53,'274bafd2-dc2b-41ff-a231-869df3a493df4.jpg'),
(54,'1bc579d8-6bff-461f-8cfa-6ae342e6a9eb4.jpg'),
(60,'a5250b42-b434-4805-8d48-4fd2a76f0d624.jpg'),
(60,'e2889242-d447-4d7a-8794-13f38a6c304d照.jpg'),
(60,'2d0b7f18-7a4f-4b6c-8163-2c5714666b7e像.jpg'),
(60,'6fa059bb-aacf-4afe-afb5-bedd51a171fb照.jpg'),
(61,'928726ca-e77d-4cc4-84f7-1531caaa17d95.jpg'),
(62,'ccca4a23-c9f1-47b5-9f0f-050d66b0fef15.jpg'),
(63,'a89d9260-f8ac-4c75-91fd-9aa930d80acb5.jpg'),
(64,'cd6f3c77-4d4b-4a26-a4e6-0d4071d7e7175.png'),
(65,'015a2ffa-a790-4489-b69b-e9647b01572a5.jpg'),
(68,'45898d43-1ae1-415b-8c93-a1d71faed0632.png'),
(71,'b307ee7b-4699-41c9-b968-6bda6e6946e94.png'),
(73,'36cc26c0-f550-4375-94e2-5390071704bf2.png'),
(74,'65f3afe0-b777-4b71-b781-16acc0ac0fdca.jpg'),
(75,'87b60f42-66a9-4aa1-a722-7c16cc5e081e9.jpg');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(10) DEFAULT NULL,
  `gender` int(1) DEFAULT '0',
  `user_type` int(11) DEFAULT '0',
  `report_num` int(11) DEFAULT '0',
  `forbidden` tinyint(1) DEFAULT '0',
  `recognized` tinyint(1) DEFAULT '0',
  `anonymous` tinyint(1) DEFAULT '0',
  `official_name` varchar(10) DEFAULT NULL,
  `bio` varchar(100) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `last_edit_time` datetime NOT NULL,
  `profile_addr` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`user_id`,`nickname`,`gender`,`user_type`,`report_num`,`forbidden`,`recognized`,`anonymous`,`official_name`,`bio`,`create_time`,`last_edit_time`,`profile_addr`) values 
(1,'hunzhizi',0,0,0,0,1,0,'周少','周少真nb，年薪250','2022-04-30 00:40:18','2022-05-22 17:07:35','E:\\img\\yanChao\\upload\\images\\item\\profile\\1\\1.png'),
(2,'张酋长',0,0,0,0,0,0,NULL,'众生皆是小丑','2022-05-01 17:05:14','2022-05-01 17:05:14',NULL),
(3,'魂之子',0,0,0,0,1,0,NULL,'我爱iu~~','2022-05-22 14:34:55','2022-05-22 16:48:48',NULL),
(4,'hunzhizi',1,0,0,0,1,1,'周少','周少nb','2022-05-22 17:07:35','2022-05-22 17:07:35','test'),
(10,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2022-08-26 06:35:52','2022-08-26 06:35:52',NULL),
(11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2022-09-16 03:35:24','2022-09-16 03:35:24',NULL),
(12,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2022-10-04 10:38:30','2022-10-04 10:38:30',NULL),
(13,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2022-10-06 05:35:03','2022-10-06 05:35:03',NULL);

/*Table structure for table `wechat_auth` */

DROP TABLE IF EXISTS `wechat_auth`;

CREATE TABLE `wechat_auth` (
  `wechat_auth_id` int(11) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(28) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`wechat_auth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `wechat_auth` */

insert  into `wechat_auth`(`wechat_auth_id`,`open_id`,`user_id`) values 
(1,'1234567890123456789012345678',1),
(2,'test1',2),
(3,'test',10),
(4,'oCmo45bvXHcrSEvJRyaRQcVzNQs8',11),
(5,'oCmo45bzVuwHlQAzwVOh6t4SuF8o',12),
(6,'oCmo45W8JsxdWt0Dxa4s55QK24zc',13);

/*Table structure for table `zhi_hu_question` */

DROP TABLE IF EXISTS `zhi_hu_question`;

CREATE TABLE `zhi_hu_question` (
  `zhi_hu_question_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `priority` int(11) NOT NULL DEFAULT '0',
  `up_num` int(11) NOT NULL DEFAULT '0',
  `report_num` int(11) NOT NULL DEFAULT '0',
  `create_time` datetime NOT NULL,
  `last_edit_time` datetime NOT NULL,
  `question_content` varchar(1000) NOT NULL,
  PRIMARY KEY (`zhi_hu_question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `zhi_hu_question` */

insert  into `zhi_hu_question`(`zhi_hu_question_id`,`user_id`,`priority`,`up_num`,`report_num`,`create_time`,`last_edit_time`,`question_content`) values 
(1,1,0,0,0,'2022-05-09 16:57:42','2022-05-09 17:25:26','欢迎大家来到燕巢的校园知乎，有什么问题尽管提问hhh'),
(3,2,0,0,0,'2022-05-09 17:34:14','2022-05-09 17:34:14','如何看待燕带落选双一流hhh'),
(4,1,0,0,0,'2022-05-22 16:53:04','2022-05-22 16:54:18','没什么好说的呢'),
(5,11,0,0,0,'2022-10-04 10:02:26','2022-10-04 10:02:26','如何看代燕巢'),
(6,11,0,0,0,'2022-10-04 10:03:17','2022-10-04 10:03:17','如何看代牛马');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
