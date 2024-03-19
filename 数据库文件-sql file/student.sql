/*
 Navicat Premium Data Transfer

 Source Server         : Localhost
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : student

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 19/03/2024 12:25:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gid` int(11) NULL DEFAULT NULL,
  `gname` char(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `gid`(`gid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES (1, 1, '软件');
INSERT INTO `grade` VALUES (2, 2, '物联网');
INSERT INTO `grade` VALUES (3, 3, '硬件');
INSERT INTO `grade` VALUES (4, 4, '市教');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用于存放学生的学号',
  `name` varchar(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '用于存储学生的姓名',
  `age` int(11) NULL DEFAULT NULL COMMENT '用于存储学生的年龄',
  `tel` char(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '用于存储学生的电话',
  `address` char(60) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL COMMENT '用于存放学生的地址',
  `gid` int(11) NULL DEFAULT NULL COMMENT '用于存储学生的班级id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `gid`(`gid`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 145 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '李思思', 30, '13012301105', '聚龙大道98号', 1);
INSERT INTO `student` VALUES (2, '刘洋', 20, '13102101010', '聚龙大道98号', 1);
INSERT INTO `student` VALUES (3, '王大花', 19, '15201031431', '聚龙大道98号', 1);
INSERT INTO `student` VALUES (4, '范云', 22, '13102310460', '聚龙大道98号', 2);
INSERT INTO `student` VALUES (5, '程阳', 20, '13210152341', '聚龙大道98号', 2);
INSERT INTO `student` VALUES (6, '张三', 21, '13277192719', '聚龙大道98号', 3);
INSERT INTO `student` VALUES (7, '李四', 22, '13188726482', '聚龙大道98号', 3);
INSERT INTO `student` VALUES (8, '王五', 19, '13272738793', '聚龙大道98号', 3);
INSERT INTO `student` VALUES (9, '陆六', 25, '13899872792', '聚龙大道98号', 1);
INSERT INTO `student` VALUES (10, '赵七', 23, '13797269839', '聚龙大道98号', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  `password` char(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 2 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456');

SET FOREIGN_KEY_CHECKS = 1;
