/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2017-09-12 20:36:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `orderid` bigint(6) NOT NULL auto_increment,
  `state` int(4) default NULL COMMENT '状态,0为已发货,1为签收',
  `trans` varchar(20) default NULL COMMENT '快递单',
  `msg` varchar(100) default NULL COMMENT '目的地',
  `address` varchar(100) default NULL,
  `remark` varchar(200) default NULL COMMENT '备注',
  `tel` varchar(20) default NULL COMMENT '收件人手机',
  `createTime` datetime default NULL COMMENT '创建时间',
  `transTime` datetime default NULL COMMENT '发货时间',
  `updateTime` datetime default NULL COMMENT '更新时间',
  `createBy` bigint(6) default NULL COMMENT '创建人',
  PRIMARY KEY  (`orderid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('23', '0', '23', 'dsfd', null, null, null, null, null, null, null);
INSERT INTO `t_order` VALUES ('24', '0', '32e32', null, null, '23', null, '2017-09-12 20:35:42', null, null, '1');
