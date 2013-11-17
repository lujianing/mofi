/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50521
Source Host           : localhost:3306
Source Database       : mofi

Target Server Type    : MYSQL
Target Server Version : 50521
File Encoding         : 65001

Date: 2013-11-17 13:55:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `applyinfo`
-- ----------------------------
DROP TABLE IF EXISTS `applyinfo`;
CREATE TABLE `applyinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `hwbh` varchar(255) DEFAULT NULL,
  `hwsl` bigint(20) DEFAULT NULL,
  `mdbh` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `userid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of applyinfo
-- ----------------------------
INSERT INTO `applyinfo` VALUES ('29', '80', '50', '100', '椴乀est', '0', '瀹屾垚浜ゆ槗', '2012-04-12 14:38:50', '1044765297');
INSERT INTO `applyinfo` VALUES ('30', '50', '50', '100', '椴乀est', '0', '閫氳繃瀹℃牳', '2012-04-12 14:39:33', '1044765297');
INSERT INTO `applyinfo` VALUES ('31', '100', '100', '100', '椴乀est', '0', '閫氳繃瀹℃牳', '2012-04-12 18:47:32', '1044765297');
INSERT INTO `applyinfo` VALUES ('32', '500', '500', '100', '椴乀est', '0', '瀹屾垚浜ゆ槗', '2012-04-12 18:47:32', '1044765297');
INSERT INTO `applyinfo` VALUES ('33', '50', '50', '101', '椴乀est', '0', '閫氳繃瀹℃牳', '2012-04-12 20:12:50', '1044765297');
INSERT INTO `applyinfo` VALUES ('34', '60', '60', '101', '椴乀est', '0', '閫氳繃瀹℃牳', '2012-04-12 20:12:50', '1044765297');
INSERT INTO `applyinfo` VALUES ('35', '70', '70', '101', '椴乀est', '0', '閫氳繃瀹℃牳', '2012-04-12 20:12:50', '1044765297');
INSERT INTO `applyinfo` VALUES ('36', '80', '80', '101', '椴乀est', '0', '閫氳繃瀹℃牳', '2012-04-12 20:12:50', '1044765297');
INSERT INTO `applyinfo` VALUES ('37', '90', '90', '102', '椴乀est', '0', '閫氳繃瀹℃牳', '2012-04-12 20:18:03', '1044765297');
INSERT INTO `applyinfo` VALUES ('38', '80', '80', '10011111', '椴乀est', '0', '閫氳繃瀹℃牳', '2012-04-13 17:20:40', '1044765297');
INSERT INTO `applyinfo` VALUES ('39', '90', '90', '068109303', '椴乀est', '0', '閫氳繃瀹℃牳', '2012-04-13 17:21:07', '1044765297');
INSERT INTO `applyinfo` VALUES ('40', '100', '100', '068109303', '椴乀est', '0', '绛夊緟瀹℃牳', '2012-04-13 17:21:07', '1044765297');
INSERT INTO `applyinfo` VALUES ('41', '101', '101', '068109303', '椴乀est', '0', '绛夊緟瀹℃牳', '2012-04-13 17:21:07', '1044765297');
INSERT INTO `applyinfo` VALUES ('42', '100', '100', '555', '椴乀est', '0', '绛夊緟瀹℃牳', '2012-04-14 19:52:33', '1044765297');
INSERT INTO `applyinfo` VALUES ('43', '99', '99', '666', '椴乀est', '0', '绛夊緟瀹℃牳', '2012-04-14 19:53:06', '1044765297');
INSERT INTO `applyinfo` VALUES ('44', '101', '101', '666', '椴乀est', '0', '绛夊緟瀹℃牳', '2012-04-14 19:53:06', '1044765297');
INSERT INTO `applyinfo` VALUES ('45', '鐗涘ザ', '100', '068109303', '椴乀est', '0', '绛夊緟瀹℃牳', '2012-04-15 17:03:33', '1044765297');
INSERT INTO `applyinfo` VALUES ('46', '閰稿ザ', '100', '068109303', '椴乀est', '0', '绛夊緟瀹℃牳', '2012-04-15 17:04:08', '1044765297');
INSERT INTO `applyinfo` VALUES ('47', '闈㈠寘', '200', '068109303', '椴乀est', '0', '绛夊緟瀹℃牳', '2012-04-15 17:04:08', '1044765297');
INSERT INTO `applyinfo` VALUES ('48', '111111111', '100', '068109303', '椴?, '0', '绛夊緟瀹℃牳', '2012-04-15 17:04:53', '1044765297');
INSERT INTO `applyinfo` VALUES ('49', '222222222', '200', '068109303', '椴乀est', '0', '绛夊緟瀹℃牳', '2012-04-15 17:04:53', '1044765297');
INSERT INTO `applyinfo` VALUES ('50', '1111', '100', '068109303', '椴乀est', '0', '閫氳繃瀹℃牳', '2012-04-15 17:05:05', '1044765297');
INSERT INTO `applyinfo` VALUES ('51', '222222222', '200', '068109303', '椴乀est', '0', '閫氳繃瀹℃牳', '2012-04-15 17:05:05', '1044765297');
INSERT INTO `applyinfo` VALUES ('52', '188', '188', '199', '椴乀est', '0', '閫氳繃瀹℃牳', '2012-04-17 19:38:34', '1044765297');
INSERT INTO `applyinfo` VALUES ('54', '100', '100', '1000', '椴乀est', '0', '閫氳繃瀹℃牳', '2012-04-19 09:39:25', '1044765297');
INSERT INTO `applyinfo` VALUES ('55', '200', '200', '1000', '椴乀est', '0', '閫氳繃瀹℃牳', '2012-04-19 09:39:25', '1044765297');
INSERT INTO `applyinfo` VALUES ('57', '901', '901', '100001', '褰柊鏄?, '15936940365', '閫氳繃瀹℃牳', '2012-04-19 09:59:36', '630795646');
INSERT INTO `applyinfo` VALUES ('58', '902', '902', '100001', '褰柊鏄?, '15936940365', '閫氳繃瀹℃牳', '2012-04-19 09:59:36', '630795646');
INSERT INTO `applyinfo` VALUES ('60', '556', '556', '1000001', '褰柊鏄?, '15936940365', '绛夊緟瀹℃牳', '2012-04-20 09:53:28', '630795646');
INSERT INTO `applyinfo` VALUES ('61', '557', '557', '1000001', '褰柊鏄?, '15936940365', '绛夊緟瀹℃牳', '2012-04-20 09:53:28', '630795646');

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `userid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '浣犲ソ鍟?瀛╁瓙', '椴乀est', '2012-04-15 17:01:55', '1044765297');
INSERT INTO `message` VALUES ('2', '浠婂ぉ澶╂皵涓嶉敊鍟?, '椴乀est', '2012-04-15 17:02:19', '1044765297');
INSERT INTO `message` VALUES ('3', '068109303锛氱墰濂讹紝100锛?, '椴乀est', '2012-04-15 17:03:07', '1044765297');
INSERT INTO `message` VALUES ('4', '068109303:鐗涘ザ锛?00锛?, '椴乀est', '2012-04-15 17:03:33', '1044765297');
INSERT INTO `message` VALUES ('5', '068109303:閰稿ザ锛?00锛涢潰鍖咃紝200锛?, '椴乀est', '2012-04-15 17:04:08', '1044765297');
INSERT INTO `message` VALUES ('6', '068109303:111111111锛?00锛?22222222锛?00锛?', '椴乀est', '2012-04-15 17:04:53', '1044765297');
INSERT INTO `message` VALUES ('7', '068109303:1111锛?00锛?22222222锛?00锛?, '椴乀est', '2012-04-15 17:05:05', '1044765297');
INSERT INTO `message` VALUES ('8', '鍝堝搱鍝堝搱', '椴乀est', '2012-04-15 17:05:20', '1044765297');
INSERT INTO `message` VALUES ('9', '鍝堝搱鍝堝搱', '椴乀est', '2012-04-15 17:05:22', '1044765297');
INSERT INTO `message` VALUES ('10', '鍝堝搱鍝堝搱', '椴乀est', '2012-04-15 17:05:23', '1044765297');
INSERT INTO `message` VALUES ('11', '鍝堝搱鍝堝搱', '椴乀est', '2012-04-15 17:05:29', '1044765297');
INSERT INTO `message` VALUES ('12', '鍝堝搱鍝堝搱', '椴乀est', '2012-04-15 17:05:30', '1044765297');
INSERT INTO `message` VALUES ('13', '199:188锛?88锛?99,199锛?, '椴乀est', '2012-04-17 19:38:34', '1044765297');
INSERT INTO `message` VALUES ('14', '1000:100,100;200,200;', '椴乀est', '2012-04-19 09:39:25', '1044765297');
INSERT INTO `message` VALUES ('15', '100:50', '椴乀est', '2012-04-19 09:39:40', '1044765297');
INSERT INTO `message` VALUES ('16', '10000:999,999;', '褰柊鏄?, '2012-04-19 09:59:15', '630795646');
INSERT INTO `message` VALUES ('17', '100001:901,901;902,902;', '褰柊鏄?, '2012-04-19 09:59:36', '630795646');
INSERT INTO `message` VALUES ('18', '122313', '褰柊鏄?, '2012-04-19 09:59:48', '630795646');
INSERT INTO `message` VALUES ('19', 'hello', '褰柊鏄?, '2012-04-20 09:52:55', '630795646');
INSERT INTO `message` VALUES ('20', '1000001:555,555;', '褰柊鏄?, '2012-04-20 09:53:08', '630795646');
INSERT INTO `message` VALUES ('21', '1000001:556,556;557,557;', '褰柊鏄?, '2012-04-20 09:53:28', '630795646');
