/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : bysj_fgs

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 18/12/2018 17:38:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ico` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parentid` int(11) NULL DEFAULT NULL,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sort` int(11) NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 'layui-icon-list', '系统菜单', 0, 'sys', 1, 'menu', '/');
INSERT INTO `sys_menu` VALUES (2, 'layui-icon-list', '用户管理', 1, 'sys:user', 1, 'menu', 'admin-web\\user\\user_list.html');
INSERT INTO `sys_menu` VALUES (3, 'layui-icon-list', '角色管理', 1, 'sys:role', 2, 'menu', 'admin-web\\role\\role_list.html');
INSERT INTO `sys_menu` VALUES (4, 'layui-icon-list', '菜单管理', 1, 'sys:menu', 3, 'menu', 'admin-web\\menu\\menu_list.html');
INSERT INTO `sys_menu` VALUES (5, NULL, '菜单查看', 4, 'sys:menu:select', 41, 'btn', '');
INSERT INTO `sys_menu` VALUES (6, NULL, '菜单添加', 4, 'sys:menu:add', 42, 'btn', '');
INSERT INTO `sys_menu` VALUES (7, NULL, '菜单修改', 4, 'sys:menu:update', 43, 'btn', NULL);
INSERT INTO `sys_menu` VALUES (8, NULL, '菜单删除', 4, 'sys:menu:del', 44, 'btn', NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_enable` bit(1) NULL DEFAULT b'1',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, b'1', 'admin');
INSERT INTO `sys_role` VALUES (2, b'1', 'stu');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) NULL DEFAULT NULL,
  `role_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (1, 1, 1);
INSERT INTO `sys_role_menu` VALUES (2, 2, 1);
INSERT INTO `sys_role_menu` VALUES (3, 3, 1);
INSERT INTO `sys_role_menu` VALUES (4, 4, 1);
INSERT INTO `sys_role_menu` VALUES (5, 5, 1);
INSERT INTO `sys_role_menu` VALUES (6, 6, 1);
INSERT INTO `sys_role_menu` VALUES (7, 7, 1);
INSERT INTO `sys_role_menu` VALUES (8, 8, 1);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crate_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `is_enable` bit(1) NULL DEFAULT b'1',
  `is_expired` bit(1) NULL DEFAULT b'0',
  `is_lock` bit(1) NULL DEFAULT b'0',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '2018-12-14 14:23:09', b'1', b'1', b'1', 'admin', '$2a$10$kWoxn2A5nzjHlve1.ct4fuBRjc55hLiJ/BbPM.p3PfQ7hDnD29rzu', '0', 'admin');
INSERT INTO `sys_user` VALUES (2, '2018-12-10 16:17:08', b'1', b'0', b'0', 'test', 'test', '0', 'test');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (1, 1, 1);
INSERT INTO `sys_user_role` VALUES (2, 2, 1);

-- ----------------------------
-- Procedure structure for getMenuListByUserName
-- ----------------------------
DROP PROCEDURE IF EXISTS `getMenuListByUserName`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getMenuListByUserName`(IN name text)
BEGIN
		select t4.* from sys_user t1
		join sys_user_role t2 on t1.id = t2.user_id
		join sys_role_menu t3 on t2.role_id = t3.role_id
		join sys_menu t4 on t3.menu_id = t4.id
		where t1.username = name;
  END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
