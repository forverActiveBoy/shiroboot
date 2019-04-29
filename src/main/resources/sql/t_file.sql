/*
Navicat MySQL Data Transfer

Source Server         : 192.168.2.173
Source Server Version : 50505
Source Host           : 192.168.2.173:3306
Source Database       : cheweibao

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-04-29 15:31:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_file
-- ----------------------------
DROP TABLE IF EXISTS `t_file`;
CREATE TABLE `t_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_file
-- ----------------------------
INSERT INTO `t_file` VALUES ('12', null, 'http://localhost:8080//activity/2dbf1add-bef0-4dbc-8034-4e2f7d2fb2cf.jpg');
INSERT INTO `t_file` VALUES ('13', null, 'http://localhost:8080//activity/043e00d6-ac76-4262-8a53-bfd228258aed.jpg');
