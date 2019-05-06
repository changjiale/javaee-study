/*
SQLyog Ultimate v12.3.1 (64 bit)
MySQL - 5.7.24 : Database - permission
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`permission` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `permission`;

/*Table structure for table `log` */

DROP TABLE IF EXISTS `log`;

CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `operateor` varchar(5) DEFAULT NULL,
  `operateType` varchar(20) DEFAULT NULL,
  `operateDate` datetime DEFAULT NULL,
  `operateResult` varchar(4) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `log` */

insert  into `log`(`id`,`operateor`,`operateType`,`operateDate`,`operateResult`,`ip`) values 
(11,'admin','删除角色','2019-05-01 10:25:23','正常','0:0:0:0:0:0:0:1');

/*Table structure for table `menu` */

DROP TABLE IF EXISTS `menu`;

CREATE TABLE `menu` (
  `menuid` varchar(30) NOT NULL DEFAULT '1' COMMENT '编号',
  `menuname` varchar(30) DEFAULT NULL COMMENT '名称',
  `url` varchar(255) DEFAULT NULL COMMENT '对应URL',
  `icon` varchar(100) DEFAULT NULL COMMENT '图标样式',
  `pid` varchar(30) DEFAULT NULL COMMENT '上一级菜单编号',
  `is_parent` tinyint(1) DEFAULT NULL COMMENT '该菜单是否为父菜单，1为true，0为false',
  PRIMARY KEY (`menuid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `menu` */

insert  into `menu`(`menuid`,`menuname`,`url`,`icon`,`pid`,`is_parent`) values 
('0','系统菜单','-','icon-sys','-1',1),
('100','系统管理','-','icon-sys','0',1),
('101','用户管理','user.html','icon-log','100',0),
('102','角色管理','role.html','icon-log','100',0),
('103','菜单管理','menu.html','icon-log','100',1),
('104','角色权限管理','roleMenuSet.html','icon-log','100',0),
('105','用户角色管理','userRoleSet.html','icon-log','100',0),
('106','日志管理','log.html','icon-log','100',1),
('107','数据库监控','druid/index.html','icon-log','100',0),
('200','人事管理','-','icon-sys','0',1),
('201','部门','dept.html','icon-log','200',0),
('202','员工','emp.html','icon-log','200',0);

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `uuid` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(30) NOT NULL COMMENT '名称',
  PRIMARY KEY (`uuid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='角色';

/*Data for the table `role` */

insert  into `role`(`uuid`,`name`) values 
(1,'一级管理员'),
(2,'二级管理员'),
(3,'三级管理员'),
(4,'四级管理员'),
(5,'五级管理员');

/*Table structure for table `role_menu` */

DROP TABLE IF EXISTS `role_menu`;

CREATE TABLE `role_menu` (
  `menuuuid` varchar(20) DEFAULT NULL COMMENT '菜单ID',
  `roleuuid` int(10) DEFAULT NULL COMMENT '菜单ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色菜单中间表';

/*Data for the table `role_menu` */

insert  into `role_menu`(`menuuuid`,`roleuuid`) values 
('104',4),
('100',1),
('101',1),
('102',1),
('103',1),
('104',1),
('105',1),
('106',1),
('107',1),
('200',1),
('201',1),
('202',1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_code` varchar(255) NOT NULL COMMENT '登陆名',
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_pwd` varchar(255) NOT NULL COMMENT '用户密码',
  `user_birthday` date DEFAULT NULL COMMENT '出生日期',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=262 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

/*Data for the table `user` */

insert  into `user`(`user_id`,`user_code`,`user_name`,`user_pwd`,`user_birthday`) values 
(221,'admin','admin','3ef7164d1f6167cb9f2658c07d3c2f0a','2019-04-05'),
(222,'hongzhi','王宏志1111','8594ca5b55a034bfd3efdaa941a4de3d','2019-04-05'),
(223,'fanyinghao','范英豪','09895c7e40f0e09161898d5f2219fd54','2019-04-05'),
(224,'stf','石腾飞','2b7ccd674f4d3cd45ed3197ebc925af3','2019-04-05'),
(225,'gaojun','高俊','d74b0bf6336d5cca1c3dc7029f26e588','2019-04-05'),
(226,'zhangyaxin','张雅欣','522258a2d42904beb739c21ddc2ab8b7','2019-04-05'),
(227,'lihepeng','李贺鹏','bebeee9bffffb24469809ddb7dcfa9da','2019-04-05'),
(228,'zhangyi','张毅','536893c69572b79a12d37223f127b11e','2019-04-05'),
(229,'xuemingxuan','薛明轩','a3969849c8d09542d2055e8f4df17cc1','2019-04-05'),
(230,'xps','徐培珊','b70820940def324b69d6821fe423ca45','2019-04-04'),
(231,'bailinglan','白凌兰','3f03b25babdc83443b72f1763f20d85b','2019-04-05'),
(232,'lixiangqiao','李香巧','63a325116e5ca37bdadd03080087bc14','2019-04-05'),
(233,'zixinzhi','自新之','0f2620059e5b682360fd13ddb5f155b4','2019-04-05'),
(234,'hefeilan','荷飞兰','a9bf6ddde72c432907cd124a15e967f1','2019-04-05'),
(235,'hualiannan','华怜南','92f84a362cc25660f25b52f60ae50572','2019-04-05'),
(236,'lizhenyu','李振宇','0c1fedf337d33673d6ef37dc40530711','2019-04-05'),
(237,'zhangjingping','张景平','6351eaa0f1a8f506ca3fad1fd4aac86d','2019-04-05'),
(238,'longjunhui','龙俊晖','aeb67ed0e6d042d3e9d4371d93af3651','2019-04-05'),
(239,'mingxinpeng','名鑫鹏','900a9d8a4fa495a96c52850e5a7515fa','2019-04-05'),
(240,'fanming','范明','c1a0075077a56b3c018b4c1db51fc045','2019-04-05'),
(241,'gaojong','高旻','4ed92ebb95716aeb7bd3530dfd20dc25','2019-04-05'),
(242,'haojia','昊嘉','7fc52457a78ded1e44d5f410bebbbcc0','2019-04-05'),
(243,'zhangxingpeng','张星鹏','5bc89c6d58c95f1f11d0d1cae8a35a46','2019-04-05'),
(244,'gaoming','高明','98c0c93db267f3bf2b48c02c68936684','2019-04-05'),
(245,'kunjie','昆杰','3d22d19d01fb31cc29e814177d7bd89b','2019-04-05'),
(246,'yuerui','乐蕊','2493e1a6fd7882377e7e28101d900908','2019-04-05'),
(247,'nanlian','南莲','1f4d3a962b6fe6b235fdf2246b88bad0','2019-04-05'),
(248,'yiqing','绮晴','e1a04b014e26397118963ad5412e7cdd','2019-04-05'),
(249,'nianyao','念瑶','7a61e7fa94a33d23f10daa0689b7fbbc','2019-04-05'),
(250,'huwanyuan','户万元','4de68065b8e77be09d8186b54770abe0','2019-04-05'),
(251,'lujinghua','陆江华','444414b8090158496df239d1aa9c5f6f','2019-04-05'),
(252,'zhaotian','赵天','cef2e6c0d34da1519b9dcd025f496e18','2019-04-05'),
(253,'xuyang','徐阳','fb828e929f905ceaee550e737b84cbfe','2019-04-05'),
(254,'mayuena','马乐娜','0a82dc616a0b4e15fba245fc88eddc12','2019-04-05'),
(255,'renshuanghui','任双辉','e72c08527974aeebdc45e509b89ad7e0','2019-04-05'),
(256,'huyouliang','胡有亮','68d33e6b5a3fe5b2287856dc6038abdc','2019-04-05'),
(257,'weidong','魏东','23b458d0c57fc797fa7ca1234f895d7b','2019-04-05'),
(258,'liupan','刘盼','fc527c76b13b33ddc300a51b223bd2a5','2019-04-05');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `userid` int(11) DEFAULT NULL COMMENT '员工编号',
  `roleuuid` int(11) DEFAULT NULL COMMENT '角色编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色中间表';

/*Data for the table `user_role` */

insert  into `user_role`(`userid`,`roleuuid`) values 
(225,1),
(221,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
