/*
Navicat MySQL Data Transfer

Source Server         : 123
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : tour

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-12 19:58:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL,
  `strategy_id` int(11) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_collectionstrategyid` (`strategy_id`),
  CONSTRAINT `Fk_collectionstrategyid` FOREIGN KEY (`strategy_id`) REFERENCES `strategy` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------

-- ----------------------------
-- Table structure for dianzan
-- ----------------------------
DROP TABLE IF EXISTS `dianzan`;
CREATE TABLE `dianzan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(50) DEFAULT NULL,
  `strategy_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_dianzanstrategyid` (`strategy_id`),
  CONSTRAINT `Fk_dianzanstrategyid` FOREIGN KEY (`strategy_id`) REFERENCES `strategy` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dianzan
-- ----------------------------
INSERT INTO `dianzan` VALUES ('3', '1', '1');
INSERT INTO `dianzan` VALUES ('4', '1', '2');

-- ----------------------------
-- Table structure for focus
-- ----------------------------
DROP TABLE IF EXISTS `focus`;
CREATE TABLE `focus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gather_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gather_id_foucus_idx` (`gather_id`),
  CONSTRAINT `FK_gather_id_foucus` FOREIGN KEY (`gather_id`) REFERENCES `gather` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of focus
-- ----------------------------

-- ----------------------------
-- Table structure for gather
-- ----------------------------
DROP TABLE IF EXISTS `gather`;
CREATE TABLE `gather` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(45) CHARACTER SET utf8 DEFAULT NULL,
  `date` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `content` varchar(225) CHARACTER SET utf8 DEFAULT NULL,
  `travel_city` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `travel_date` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `sex` varchar(4) COLLATE utf8_bin DEFAULT NULL,
  `images` varchar(225) CHARACTER SET utf8 DEFAULT NULL,
  `focus` int(11) DEFAULT NULL,
  `joiner` int(11) DEFAULT NULL,
  `connection` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `con_status` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gatherId` (`user_id`),
  FULLTEXT KEY `testfulltext` (`travel_city`) /*!50100 WITH PARSER `ngram` */ ,
  FULLTEXT KEY `ft_travel` (`travel_city`) /*!50100 WITH PARSER `ngram` */ ,
  FULLTEXT KEY `ft_tour` (`title`,`content`) /*!50100 WITH PARSER `ngram` */ ,
  CONSTRAINT `FK_gatherId` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of gather
-- ----------------------------
INSERT INTO `gather` VALUES ('2', '相约呼伦贝尔', '1', 'Benny', '2017-08-27 17:58:23', '北京到呼伦贝尔！有想去的小伙伴吗？', '北京市市辖区-呼伦贝尔市', '2017-08-27至2017-09-07', '3', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ971f56b3bd3c454fcdfbc7d25cc18bb4.jpg', '0', '0', '1252367043', 'true');
INSERT INTO `gather` VALUES ('3', '重庆山城穷游小分队！', '1', 'Benny', '2017-08-27 21:24:54', '想去重庆很久啦！有没有同城出发的小伙伴一起呢？', '西安市-重庆市市辖区', '2017-08-31至2017-09-05', '3', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ2c8411f24145505eca170fc386ce32a4.jpg', '0', '1', 'qq：1252367043', 'true');
INSERT INTO `gather` VALUES ('5', '河北石家庄走一遭', '1', 'Benny', '2017-09-10 13:54:21', '想去河北旅游的小伙伴看过来！', '北京市市辖区-石家庄市', '2017-09-10至2017-09-14', '3', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ8a29c21c72e9d9372f54b86179b46f22.jpg', '0', '0', 'qq1252367043', 'false');

-- ----------------------------
-- Table structure for level
-- ----------------------------
DROP TABLE IF EXISTS `level`;
CREATE TABLE `level` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of level
-- ----------------------------
INSERT INTO `level` VALUES ('1', 'http://localhost:8090/MyWe/images/11111.png');
INSERT INTO `level` VALUES ('2', 'http://localhost:8090/MyWe/images/22222.png');
INSERT INTO `level` VALUES ('3', 'http://localhost:8090/MyWe/images/33333.png');
INSERT INTO `level` VALUES ('4', 'http://localhost:8090/MyWe/images/44444.png');
INSERT INTO `level` VALUES ('5', 'http://localhost:8090/MyWe/images/55555.png');
INSERT INTO `level` VALUES ('6', 'http://localhost:8090/MyWe/images/66666.png');
INSERT INTO `level` VALUES ('7', 'http://localhost:8090/MyWe/images/gray111.png');
INSERT INTO `level` VALUES ('8', 'http://localhost:8090/MyWe/images/gray222.png');
INSERT INTO `level` VALUES ('9', 'http://localhost:8090/MyWe/images/gray333.png');
INSERT INTO `level` VALUES ('10', 'http://localhost:8090/MyWe/images/gray444.png');
INSERT INTO `level` VALUES ('11', 'http://localhost:8090/MyWe/images/gray555.png');
INSERT INTO `level` VALUES ('12', 'http://localhost:8090/MyWe/images/gray666.png');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gather_id` int(11) DEFAULT NULL,
  `member_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Fk_membergatherid` (`gather_id`),
  CONSTRAINT `Fk_membergatherid` FOREIGN KEY (`gather_id`) REFERENCES `gather` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('7', '3', '1');

-- ----------------------------
-- Table structure for sercret
-- ----------------------------
DROP TABLE IF EXISTS `sercret`;
CREATE TABLE `sercret` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gather_id` int(11) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `act_img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_gather_id_sercret_idx` (`gather_id`),
  CONSTRAINT `FK_gather_id_sercret` FOREIGN KEY (`gather_id`) REFERENCES `gather` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sercret
-- ----------------------------

-- ----------------------------
-- Table structure for strategy
-- ----------------------------
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `date` varchar(20) DEFAULT NULL,
  `place` varchar(45) DEFAULT NULL,
  `content` varchar(225) DEFAULT NULL,
  `dianzan` int(11) DEFAULT NULL,
  `shoucang` int(11) DEFAULT NULL,
  `cover` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_strategyuser_id` (`user_id`),
  FULLTEXT KEY `testfulltext` (`title`,`content`) /*!50100 WITH PARSER `ngram` */ ,
  FULLTEXT KEY `ft_name` (`title`,`content`) /*!50100 WITH PARSER `ngram` */ ,
  CONSTRAINT `FK_strategyuser_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of strategy
-- ----------------------------
INSERT INTO `strategy` VALUES ('1', '1', 'Benny', '西藏你不得不看的三大风景', '2017-08-20 16:53:38', '西藏自治区拉萨市', '眺望苍穹，暖暖地感受雪域阳光，映照出另一个自己', '100', '30', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQd8920df00d4263589691180c26b72ef8.jpg');
INSERT INTO `strategy` VALUES ('2', '1', 'Benny', '成都最强美食攻略', '2017-08-22 15:20:07', '四川省达州市', '吃货至上！成都除了看不完的风景，更有吃不完的美食！', '101', '68', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQd0f951200f11de735c7f9396936c0633.jpg');
INSERT INTO `strategy` VALUES ('4', '1', 'Benny', '别样丽江情', '2017-08-22 19:14:04', '四川省达州市', '起初我也不懂旅行的意义，直到我一次次脱离熟悉的环境。\r ', '0', '0', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ5876c271c93f92a24bd7798e16039717.jpg');
INSERT INTO `strategy` VALUES ('5', '1', 'Benny', '广州旅游攻略', '2017-08-23 13:34:28', '四川省成都市', '第一次的攻略撰写！多有不足哈哈哈', '0', '0', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ518db32571aefb709085d455eaf21223.jpg');
INSERT INTO `strategy` VALUES ('7', '1', 'Benny', '试用标题', '2017-09-10 14:03:14', '江苏省徐州市', '试用内容，在此输入内容！存在排版问题', '0', '0', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQbc2ddfed3066c9b1f708db9cccc3723e.jpg');
INSERT INTO `strategy` VALUES ('8', '1', 'Benny', '南京游', '2017-09-11 16:18:17', '江苏省苏州市', '南京真好玩！真的好玩！', '0', '0', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ8fb888908960ff4334e0faea8ff09612.JPG');
INSERT INTO `strategy` VALUES ('9', '1', 'Benny', '北京游记！', '2017-09-11 16:19:56', '江苏省苏州市', '北京真好玩！真的好玩！很高兴能够在这里玩', '0', '0', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQca6dbc7d33636f5a724c74a1af2c0690.jpg');

-- ----------------------------
-- Table structure for strategy_photo
-- ----------------------------
DROP TABLE IF EXISTS `strategy_photo`;
CREATE TABLE `strategy_photo` (
  `id` int(11) NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  KEY `FK_STRATEGY_id` (`id`),
  CONSTRAINT `FK_STRATEGY_id` FOREIGN KEY (`id`) REFERENCES `strategy` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of strategy_photo
-- ----------------------------
INSERT INTO `strategy_photo` VALUES ('2', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQd00e6942be1ca0d69ab9121f4e7c841d.jpg');
INSERT INTO `strategy_photo` VALUES ('2', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ568ff22c73a58b3bfe7e38c1eb3c54a8.jpg');
INSERT INTO `strategy_photo` VALUES ('2', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ2a0ccb93d9a5610d24ffc8f4eba8d2b6.jpg');
INSERT INTO `strategy_photo` VALUES ('2', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ0117055564473954130d5ecccc5e0750.jpg');
INSERT INTO `strategy_photo` VALUES ('2', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQc833f739fe9800e718424bf8b47be928.jpg');
INSERT INTO `strategy_photo` VALUES ('2', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ513c66e09c1014ccfd856b53a622b61c.jpg');
INSERT INTO `strategy_photo` VALUES ('2', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ651d8889c7d80f6d7f1703e92c2b2567.jpg');
INSERT INTO `strategy_photo` VALUES ('2', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQe19b16e23fbd34b6c1807c2127d006f0.jpg');
INSERT INTO `strategy_photo` VALUES ('1', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ0b2c5ce3d5ac7a2ff798b1ef5a988473.jpg');
INSERT INTO `strategy_photo` VALUES ('1', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ1aa109c15df8c30244e7f143a896d5c9.jpg');
INSERT INTO `strategy_photo` VALUES ('1', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ1fb715c63a20766dbaf0c18d3799c4e1.jpg');
INSERT INTO `strategy_photo` VALUES ('1', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ130cda2adcee92bd656fc7021147fcd6.jpg');
INSERT INTO `strategy_photo` VALUES ('1', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ316be79a8b7cd5274cb32abafc11c8dd.jpg');
INSERT INTO `strategy_photo` VALUES ('4', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQacd1148d8e45b91b4709f77946108ed0.jpg');
INSERT INTO `strategy_photo` VALUES ('4', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ02be79b4f3d71248d3d259dff2da2908.jpg');
INSERT INTO `strategy_photo` VALUES ('4', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ77cedafa85151c8026f7702f1c1bd0ac.jpg');
INSERT INTO `strategy_photo` VALUES ('4', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ4cd7765ebc10e89caaa15789a1a43d32.jpg');
INSERT INTO `strategy_photo` VALUES ('4', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQfaebfa12b8397c7b0d4eac1c6063ef98.jpg');
INSERT INTO `strategy_photo` VALUES ('5', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQf8936e40e3d85a5d5edc1dac6fe6f540.jpg');
INSERT INTO `strategy_photo` VALUES ('5', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQe7d168332faaefcb36b1b54062ce14d1.jpg');
INSERT INTO `strategy_photo` VALUES ('5', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ4de22cd27c58851fcc174faee4b9ef60.jpg');
INSERT INTO `strategy_photo` VALUES ('5', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQa3107d0a70d0a5d6bd909c7cf627f4fc.jpg');
INSERT INTO `strategy_photo` VALUES ('5', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ29c248b283e3b2d0cf1d0f081d6921a7.jpg');
INSERT INTO `strategy_photo` VALUES ('5', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ917320e8b7a50e2a4b7ae6a809a3bbed.jpg');
INSERT INTO `strategy_photo` VALUES ('5', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ0789f029cfbb75a023d2ccb23eb7b702.jpg');
INSERT INTO `strategy_photo` VALUES ('7', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ2982d499e7fa16fe4e6840c8f3078694.jpg');
INSERT INTO `strategy_photo` VALUES ('7', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ3075c5d8b83f5ee7c3511c287aff88fe.jpeg');
INSERT INTO `strategy_photo` VALUES ('7', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ41ef490c6114eea3ceeaf7a65eb4adeb.png');
INSERT INTO `strategy_photo` VALUES ('7', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQd0521acfdd83dbab1181109e3f83aab1.jpeg');
INSERT INTO `strategy_photo` VALUES ('7', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQc4d3d8a51c2e56d9d1146ddfc9c2072e.jpg');
INSERT INTO `strategy_photo` VALUES ('8', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQf781b77e3ad2d7e58e9335b6b69dac1c.jpg');
INSERT INTO `strategy_photo` VALUES ('8', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ88c024c3a536dea8d8e13a43c3f087a9.jpg');
INSERT INTO `strategy_photo` VALUES ('9', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQecbbc8a7db4464b099be8719a315317c.jpg');
INSERT INTO `strategy_photo` VALUES ('9', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ1d377aa5bd118796187a13c64e45e5ca.jpg');
INSERT INTO `strategy_photo` VALUES ('9', 'http://localhost:8090/MyWe/upload/tmp_778098350o6zAJs6yBEFwhIANfMjoNAZh9eiQ9edbc339c238cfb91e501c1e3e84db25.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(50) NOT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `user_img` varchar(255) DEFAULT NULL,
  `focus` int(11) DEFAULT NULL,
  `fans` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'oMuoO0THnQE6nk_mpGaszP9clPwI', 'Benny', 'https://wx.qlogo.cn/mmopen/vi_32/Mg1JdOm4Hf8Cl40MLfBzZ7QypPia1T47BBF3iaNRXClVbmIkLQBv0NONg3d9mT43S58AP91clJx7Ccv1NBiaUz8ng/0', '0', '0');

-- ----------------------------
-- Table structure for userfocus
-- ----------------------------
DROP TABLE IF EXISTS `userfocus`;
CREATE TABLE `userfocus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_focus` int(11) DEFAULT NULL,
  `focus_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_focus_user_id_focus_idx` (`user_focus`,`focus_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userfocus
-- ----------------------------
