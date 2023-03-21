/*
Navicat MySQL Data Transfer
Source Database       : echarts

Target Server Type    : MYSQL
Target Server Version : 50740
File Encoding         : 65001

Date: 2023-03-21 22:02:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for shareholder
-- ----------------------------
DROP TABLE IF EXISTS `shareholder`;
CREATE TABLE `shareholder` (
  `name` varchar(255) NOT NULL,
  `value` int(11) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
