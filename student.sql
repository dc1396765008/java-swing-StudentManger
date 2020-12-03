/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80021
Source Host           : localhost:3306
Source Database       : student

Target Server Type    : MYSQL
Target Server Version : 80021
File Encoding         : 65001

Date: 2020-12-03 21:11:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `weather` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `min` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `max` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pressure` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `wind` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`city`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('上海', '小雨', '11', '12', '1112', '45', '南');
INSERT INTO `student` VALUES ('北京', '晴', '10', '14', '1030', '50', '北');
INSERT INTO `student` VALUES ('吉林', '晴', '9', '12', '975', '12', '北');
INSERT INTO `student` VALUES ('四川', '多云', '13', '15', '1042', '33', '南');
INSERT INTO `student` VALUES ('山西', '小雨', '8', '10', '1522', '56', '西');
INSERT INTO `student` VALUES ('广东', '晴', '15', '17', '732', '46', '东');
INSERT INTO `student` VALUES ('广西', '多云', '13', '16', '1421', '41', '东');
INSERT INTO `student` VALUES ('我', '121', '1211', '1212', '12', '12', '');
INSERT INTO `student` VALUES ('我是啊', '123', '123', '123', '123', '123', '123啊');
INSERT INTO `student` VALUES ('江西', '雷雨', '14', '16', '832', '23', '北');
INSERT INTO `student` VALUES ('浙江', '晴', '15', '18', '1123', '26', '南');
INSERT INTO `student` VALUES ('湖北', '阴', '13', '17', '1236', '45', '北');
INSERT INTO `student` VALUES ('湖南', '晴', '12', '15', '1212', '23', '东');
INSERT INTO `student` VALUES ('辽宁', '大雨', '14', '15', '974', '23', '西');
