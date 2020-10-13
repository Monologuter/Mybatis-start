/*
 Navicat Premium Data Transfer

 Source Server         : docker5.7 密码123456
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3307
 Source Schema         : easy_mybatis

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 13/10/2020 16:33:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `ID` int(11) NOT NULL COMMENT '编号',
  `UID` int(11) DEFAULT NULL COMMENT '用户编号',
  `MONEY` double DEFAULT NULL COMMENT '金额',
  PRIMARY KEY (`ID`),
  KEY `FK_Reference_8` (`UID`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`UID`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
BEGIN;
INSERT INTO `account` VALUES (1, 41, 1000);
INSERT INTO `account` VALUES (2, 45, 1000);
INSERT INTO `account` VALUES (3, 41, 2000);
COMMIT;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
  `id` varchar(50) NOT NULL COMMENT '博客id',
  `title` varchar(100) NOT NULL COMMENT '博客标题',
  `author` varchar(30) NOT NULL COMMENT '博客作者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `views` int(30) NOT NULL COMMENT '浏览量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog
-- ----------------------------
BEGIN;
INSERT INTO `blog` VALUES ('1', 'springboot888', '狂神', '2020-10-12 14:11:53', 1000);
INSERT INTO `blog` VALUES ('2', 'spring', '陈亚', '2020-10-12 14:03:17', 100);
INSERT INTO `blog` VALUES ('26ed03773b604aa6a67ff9a115f3106d', 'redis', '陈亚', '2020-10-12 17:19:21', 99);
INSERT INTO `blog` VALUES ('3', 'Java', '黑马程序员', '2020-10-12 14:05:51', 999);
INSERT INTO `blog` VALUES ('4', 'SpringMVC', '狂神说', '2020-10-12 14:11:12', 999);
INSERT INTO `blog` VALUES ('5', 'Mysql', '陈亚', '2020-10-12 14:12:14', 99);
INSERT INTO `blog` VALUES ('6', 'Python', '狂神说', '2020-10-12 14:11:35', 1000);
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `ID` int(11) NOT NULL COMMENT '编号',
  `ROLE_NAME` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(60) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, '院长', '管理整个学院');
INSERT INTO `role` VALUES (2, '总裁', '管理整个公司');
INSERT INTO `role` VALUES (3, '校长', '管理整个学校');
COMMIT;

-- ----------------------------
-- Table structure for s_admin
-- ----------------------------
DROP TABLE IF EXISTS `s_admin`;
CREATE TABLE `s_admin` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`,`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of s_admin
-- ----------------------------
BEGIN;
INSERT INTO `s_admin` VALUES (1, 'admin', '123456', 1);
COMMIT;

-- ----------------------------
-- Table structure for s_clazz
-- ----------------------------
DROP TABLE IF EXISTS `s_clazz`;
CREATE TABLE `s_clazz` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `info` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of s_clazz
-- ----------------------------
BEGIN;
INSERT INTO `s_clazz` VALUES (1, '软件一班', '软件工程专业。');
INSERT INTO `s_clazz` VALUES (4, '数学一班', '大学数学专业');
INSERT INTO `s_clazz` VALUES (5, '计算机科学与技术一班', '计算机专业');
COMMIT;

-- ----------------------------
-- Table structure for s_course
-- ----------------------------
DROP TABLE IF EXISTS `s_course`;
CREATE TABLE `s_course` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL,
  `teacher_id` int(5) NOT NULL,
  `course_date` varchar(32) DEFAULT NULL,
  `selected_num` int(5) NOT NULL DEFAULT '0',
  `max_num` int(5) NOT NULL DEFAULT '50',
  `info` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `course_teacher_foreign` (`teacher_id`) USING BTREE,
  CONSTRAINT `course_teacher_foreign` FOREIGN KEY (`teacher_id`) REFERENCES `s_teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of s_course
-- ----------------------------
BEGIN;
INSERT INTO `s_course` VALUES (1, '大学英语', 9, '周三上午8点', 49, 50, '英语。');
INSERT INTO `s_course` VALUES (2, '大学数学', 10, '周三上午10点', 4, 50, '数学。');
INSERT INTO `s_course` VALUES (3, '计算机基础', 11, '周三上午', 3, 50, '计算机课程。');
COMMIT;

-- ----------------------------
-- Table structure for s_score
-- ----------------------------
DROP TABLE IF EXISTS `s_score`;
CREATE TABLE `s_score` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `student_id` int(5) NOT NULL,
  `course_id` int(5) NOT NULL,
  `score` double(5,2) NOT NULL,
  `remark` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `selected_course_student_fk` (`student_id`) USING BTREE,
  KEY `selected_course_course_fk` (`course_id`) USING BTREE,
  CONSTRAINT `s_score_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `s_course` (`id`),
  CONSTRAINT `s_score_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `s_student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of s_score
-- ----------------------------
BEGIN;
INSERT INTO `s_score` VALUES (67, 4, 2, 78.00, '中等');
INSERT INTO `s_score` VALUES (68, 9, 1, 50.00, '不及格');
COMMIT;

-- ----------------------------
-- Table structure for s_student
-- ----------------------------
DROP TABLE IF EXISTS `s_student`;
CREATE TABLE `s_student` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `sn` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `clazz_id` int(5) NOT NULL,
  `sex` varchar(5) NOT NULL DEFAULT '男',
  `mobile` varchar(12) DEFAULT NULL,
  `qq` varchar(18) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`sn`) USING BTREE,
  KEY `student_clazz_id_foreign` (`clazz_id`) USING BTREE,
  CONSTRAINT `student_clazz_id_foreign` FOREIGN KEY (`clazz_id`) REFERENCES `s_clazz` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of s_student
-- ----------------------------
BEGIN;
INSERT INTO `s_student` VALUES (2, 'S51528202992845', '韩立', '123456', 1, '男', '13545454548', '1332365656', NULL);
INSERT INTO `s_student` VALUES (4, 'S51528379586807', '南宫婉', '111111', 5, '女', '13356565656', '123456', NULL);
INSERT INTO `s_student` VALUES (9, 'S41528633634989', '银月', '1', 5, '女', '13333332133', '131313132323', 'bb12326f-ef6c-4d3d-a2ae-f9eb30a15ad4.jpg');
COMMIT;

-- ----------------------------
-- Table structure for s_teacher
-- ----------------------------
DROP TABLE IF EXISTS `s_teacher`;
CREATE TABLE `s_teacher` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `sn` varchar(32) NOT NULL,
  `username` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `clazz_id` int(5) NOT NULL,
  `sex` varchar(5) NOT NULL DEFAULT '男',
  `mobile` varchar(12) DEFAULT NULL,
  `qq` varchar(18) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`sn`) USING BTREE,
  KEY `student_clazz_id_foreign` (`clazz_id`) USING BTREE,
  CONSTRAINT `s_teacher_ibfk_1` FOREIGN KEY (`clazz_id`) REFERENCES `s_clazz` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of s_teacher
-- ----------------------------
BEGIN;
INSERT INTO `s_teacher` VALUES (9, 'T11528608730648', '墨居仁', '111', 4, '男', '13918655656', '1193284480', NULL);
INSERT INTO `s_teacher` VALUES (10, 'T11528609224588', '李元华', '111', 4, '男', '13656565656', '123456', NULL);
INSERT INTO `s_teacher` VALUES (11, 'T51528617262403', '大衍神君', '123456', 5, '男', '18989898989', '1456655565', NULL);
INSERT INTO `s_teacher` VALUES (18, 'T11561727746515', '青元子', '123456', 1, '男', '15174857845', '1745854125', '5d447b8b-ec54-4a8e-919a-453aa7b6d33b.jpg');
COMMIT;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(10) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `tid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fktid` (`tid`),
  CONSTRAINT `fktid` FOREIGN KEY (`tid`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES (1, '张三', 1);
INSERT INTO `student` VALUES (2, '李四', 1);
INSERT INTO `student` VALUES (3, '王五', 1);
INSERT INTO `student` VALUES (4, '赵六', 1);
INSERT INTO `student` VALUES (7, '田七', 1);
COMMIT;

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(10) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
BEGIN;
INSERT INTO `teacher` VALUES (1, '陈亚');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '用户名称',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (41, '陈亚9999', '2020-10-08 00:00:00', '男', '上海');
INSERT INTO `user` VALUES (42, '小二王', '2018-03-02 15:09:37', '女', '北京金燕龙');
INSERT INTO `user` VALUES (43, '小二王', '2018-03-04 11:34:34', '女', '北京金燕龙');
INSERT INTO `user` VALUES (45, '传智播客', '2018-03-04 12:04:06', '男', '北京金燕龙');
INSERT INTO `user` VALUES (46, '老王', '2018-03-07 17:37:26', '男', '北京');
INSERT INTO `user` VALUES (48, '小马宝莉', '2018-03-08 11:44:00', '女', '北京修正');
INSERT INTO `user` VALUES (54, '陈亚jjj', '2020-09-30 11:05:07', '男', '江苏省');
INSERT INTO `user` VALUES (63, '华妍', NULL, '女', NULL);
INSERT INTO `user` VALUES (64, '华妍', NULL, '女', NULL);
INSERT INTO `user` VALUES (65, '华妍', NULL, '女', NULL);
INSERT INTO `user` VALUES (66, '李五', NULL, '女', NULL);
INSERT INTO `user` VALUES (68, '李五', NULL, '女', NULL);
INSERT INTO `user` VALUES (69, '李四', NULL, '女', NULL);
INSERT INTO `user` VALUES (71, '李四', NULL, '女', NULL);
INSERT INTO `user` VALUES (73, '李四', NULL, '女', NULL);
INSERT INTO `user` VALUES (75, '李四', NULL, '女', NULL);
INSERT INTO `user` VALUES (80, '李四', NULL, '女', NULL);
INSERT INTO `user` VALUES (82, '李四', NULL, '女', NULL);
INSERT INTO `user` VALUES (85, '李四', NULL, '女', NULL);
INSERT INTO `user` VALUES (87, '李四', NULL, '女', NULL);
INSERT INTO `user` VALUES (89, '李四', NULL, '女', NULL);
INSERT INTO `user` VALUES (91, '李四', NULL, '女', NULL);
INSERT INTO `user` VALUES (94, '李四', NULL, '女', NULL);
INSERT INTO `user` VALUES (97, '李四', NULL, '女', NULL);
INSERT INTO `user` VALUES (98, '李四', NULL, '女', NULL);
INSERT INTO `user` VALUES (99, '陈亚', '2020-10-08 16:12:36', '男', '江苏省');
INSERT INTO `user` VALUES (100, '陈亚6666', '2020-10-08 16:13:02', '男', '江苏省');
INSERT INTO `user` VALUES (102, '乔碧萝', '2020-10-09 17:28:41', '女', '常州市');
INSERT INTO `user` VALUES (103, '陈亚', '2020-10-09 17:34:22', '男', '江苏省');
COMMIT;

-- ----------------------------
-- Table structure for user02
-- ----------------------------
DROP TABLE IF EXISTS `user02`;
CREATE TABLE `user02` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_username` varchar(32) NOT NULL COMMENT '用户名称',
  `t_birthday` datetime DEFAULT NULL COMMENT '生日',
  `t_sex` char(1) DEFAULT NULL COMMENT '性别',
  `t_address` varchar(256) DEFAULT NULL COMMENT '地址',
  `t_password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`t_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user02
-- ----------------------------
BEGIN;
INSERT INTO `user02` VALUES (1, '陈亚', '2020-10-03 21:39:42', '男', '江苏省', '123456');
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `UID` int(11) NOT NULL COMMENT '用户编号',
  `RID` int(11) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`UID`,`RID`),
  KEY `FK_Reference_10` (`RID`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`RID`) REFERENCES `role` (`ID`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`UID`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO `user_role` VALUES (41, 1);
INSERT INTO `user_role` VALUES (45, 1);
INSERT INTO `user_role` VALUES (41, 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
