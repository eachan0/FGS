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

 Date: 20/12/2018 20:54:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ico` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图标',
  `menu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `parentid` int(11) NULL DEFAULT NULL COMMENT '父级菜单',
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限',
  `sort` int(11) NULL DEFAULT NULL COMMENT '排序',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '链接',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `sys_menu` VALUES (9, NULL, '角色查看', 3, 'sys:role:select', 21, 'btn', '');
INSERT INTO `sys_menu` VALUES (10, NULL, '角色添加', 3, 'sys:role:add', 22, 'btn', '');
INSERT INTO `sys_menu` VALUES (11, NULL, '角色修改', 3, 'sys:role:update', 23, 'btn', NULL);
INSERT INTO `sys_menu` VALUES (12, NULL, '角色删除', 3, 'sys:role:del', 24, 'btn', NULL);
INSERT INTO `sys_menu` VALUES (13, NULL, '用户查看', 2, 'sys:user:select', 11, 'btn', '');
INSERT INTO `sys_menu` VALUES (14, NULL, '用户添加', 2, 'sys:user:add', 12, 'btn', NULL);
INSERT INTO `sys_menu` VALUES (15, NULL, '用户修改', 2, 'sys:user:update', 13, 'btn', NULL);
INSERT INTO `sys_menu` VALUES (16, NULL, '用户删除', 2, 'sys:user:del', 14, 'btn', NULL);
INSERT INTO `sys_menu` VALUES (17, 'layui-icon-list', '数据监控', 0, 'sys', 2, 'menu', '/');
INSERT INTO `sys_menu` VALUES (18, NULL, '数据监控', 17, 'sys', 171, 'menu', 'admin-web\\druid.html');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_enable` bit(1) NULL DEFAULT b'1' COMMENT '是否启用',
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, b'1', 'sys');
INSERT INTO `sys_role` VALUES (2, b'1', 'AAA');
INSERT INTO `sys_role` VALUES (3, b'1', 'BBB');

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_id` int(11) NULL DEFAULT NULL COMMENT '菜单编号',
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

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
INSERT INTO `sys_role_menu` VALUES (9, 17, 1);
INSERT INTO `sys_role_menu` VALUES (10, 18, 1);
INSERT INTO `sys_role_menu` VALUES (11, 9, 1);
INSERT INTO `sys_role_menu` VALUES (12, 10, 1);
INSERT INTO `sys_role_menu` VALUES (13, 11, 1);
INSERT INTO `sys_role_menu` VALUES (14, 12, 1);
INSERT INTO `sys_role_menu` VALUES (15, 13, 1);
INSERT INTO `sys_role_menu` VALUES (16, 14, 1);
INSERT INTO `sys_role_menu` VALUES (17, 15, 1);
INSERT INTO `sys_role_menu` VALUES (18, 16, 1);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `crate_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `is_enable` bit(1) NULL DEFAULT b'1' COMMENT '是否开启',
  `is_expired` bit(1) NULL DEFAULT b'1' COMMENT '是否过期',
  `is_lock` bit(1) NULL DEFAULT b'1' COMMENT '是否锁定',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '2018-12-20 17:27:06', b'1', b'1', b'1', 'admin', '$2a$10$kWoxn2A5nzjHlve1.ct4fuBRjc55hLiJ/BbPM.p3PfQ7hDnD29rzu', '1', 'admin');
INSERT INTO `sys_user` VALUES (2, '2018-12-20 20:49:16', b'1', b'0', b'0', 'test007', 'test', '0', 'test');
INSERT INTO `sys_user` VALUES (3, '2018-12-20 20:04:59', b'1', b'0', b'0', 'teest', '$2a$10$Lhfdoe7WWp1OtPYSCwrM6eoQUkIQOPJFJ.sgLGSVlacXnEaBDr7w6', NULL, 'test');
INSERT INTO `sys_user` VALUES (4, '2018-12-20 19:51:11', b'1', b'0', b'0', NULL, '$2a$10$wd/ZVvkBb/ZyZ8B2HueM..UdRixtU0ROCqLmvtRpiWH5SxcDLz4cG', NULL, 'test');
INSERT INTO `sys_user` VALUES (5, '2018-12-20 19:51:11', b'1', b'0', b'0', NULL, '$2a$10$9dlnqy1YFsgxEXRQ0Ust2ebwNL3zlcHjrXWQ/kCMixtvcj7YE2nIi', NULL, 'test');
INSERT INTO `sys_user` VALUES (6, '2018-12-20 19:27:51', b'1', b'0', b'0', NULL, NULL, NULL, 'test');
INSERT INTO `sys_user` VALUES (7, '2018-12-20 19:27:51', b'1', b'0', b'0', NULL, NULL, NULL, 'test');
INSERT INTO `sys_user` VALUES (8, '2018-12-20 19:27:52', b'1', b'0', b'0', NULL, NULL, NULL, 'test');
INSERT INTO `sys_user` VALUES (9, '2018-12-20 19:27:53', b'1', b'0', b'0', NULL, NULL, NULL, 'test');
INSERT INTO `sys_user` VALUES (10, '2018-12-20 19:27:53', b'1', b'0', b'0', NULL, NULL, NULL, 'test');
INSERT INTO `sys_user` VALUES (11, '2018-12-20 19:27:54', b'1', b'0', b'0', NULL, NULL, NULL, 'test');
INSERT INTO `sys_user` VALUES (12, '2018-12-20 19:27:54', b'1', b'0', b'0', NULL, NULL, NULL, 'test');
INSERT INTO `sys_user` VALUES (13, '2018-12-20 19:27:55', b'1', b'0', b'0', NULL, NULL, NULL, 'test');
INSERT INTO `sys_user` VALUES (14, '2018-12-20 19:27:56', b'1', b'0', b'0', NULL, NULL, NULL, 'test');
INSERT INTO `sys_user` VALUES (15, '2018-12-20 20:01:01', b'1', b'0', b'0', NULL, '$2a$10$0sM46it9/qgJBMz/D4VbC.0RkkJm12oP13YETG0guk6MFv.vqaTLG', NULL, 'test');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户编号',
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
