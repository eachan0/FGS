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

 Date: 20/01/2019 21:40:51
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
) ENGINE = MyISAM AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (1, b'1', 'SYS');
INSERT INTO `sys_role` VALUES (2, b'0', 'AAA');
INSERT INTO `sys_role` VALUES (3, b'0', 'BBB');
INSERT INTO `sys_role` VALUES (4, b'1', 'TEST');
INSERT INTO `sys_role` VALUES (12, b'1', 'FGSSYS');

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
INSERT INTO `sys_role_menu` VALUES (81, 18, 4);
INSERT INTO `sys_role_menu` VALUES (80, 17, 4);

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
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 31 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '2019-01-20 15:02:19', b'1', b'1', b'1', 'admin', '$2a$10$Be.gjFzNoeBM1XSCNHFPv.H/NxNrzZRXLOwMKtJEp0tP9BrnKZQ4q', '0', 'admin');
INSERT INTO `sys_user` VALUES (2, '2018-12-20 20:49:16', b'1', b'0', b'0', 'test007', 'test', '0', 'test');
INSERT INTO `sys_user` VALUES (19, '2018-12-21 04:54:10', b'1', b'1', b'1', '123', '$2a$10$PFcYhZtUKl2x2icANCEBQOaGED.MPeech4l8Yt9MtD4IQ20s6iwZS', '男', 'admin007');
INSERT INTO `sys_user` VALUES (20, '2018-12-21 05:08:15', b'1', b'1', b'1', '123', '$2a$10$L4JbT6PZnFLoqCcFR7TAC.4xk.StrSo03EZ4a19Wv2p.rjwS.Id0q', '男', 'admin008');
INSERT INTO `sys_user` VALUES (21, NULL, b'1', b'1', b'1', NULL, NULL, NULL, 'admin1');
INSERT INTO `sys_user` VALUES (22, NULL, b'1', b'1', b'1', NULL, NULL, NULL, 'admin2');
INSERT INTO `sys_user` VALUES (23, NULL, b'1', b'1', b'1', NULL, NULL, NULL, 'admin3');
INSERT INTO `sys_user` VALUES (24, NULL, b'1', b'1', b'1', NULL, NULL, NULL, 'admin4');
INSERT INTO `sys_user` VALUES (25, NULL, b'1', b'1', b'1', NULL, NULL, NULL, 'admin5');
INSERT INTO `sys_user` VALUES (26, NULL, b'1', b'1', b'1', NULL, NULL, NULL, 'admin6');
INSERT INTO `sys_user` VALUES (27, NULL, b'1', b'1', b'1', NULL, NULL, NULL, 'admin7');
INSERT INTO `sys_user` VALUES (28, NULL, b'1', b'1', b'1', NULL, NULL, NULL, 'admin8');
INSERT INTO `sys_user` VALUES (29, NULL, b'1', b'1', b'1', NULL, NULL, NULL, 'admin9');
INSERT INTO `sys_user` VALUES (30, NULL, b'1', b'1', b'1', NULL, NULL, NULL, 'admin10');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL COMMENT '角色编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (12, 2, 1);
INSERT INTO `sys_user_role` VALUES (11, 1, 1);
INSERT INTO `sys_user_role` VALUES (10, 3, 20);
INSERT INTO `sys_user_role` VALUES (9, 2, 20);
INSERT INTO `sys_user_role` VALUES (8, 1, 19);
INSERT INTO `sys_user_role` VALUES (13, 3, 1);

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
