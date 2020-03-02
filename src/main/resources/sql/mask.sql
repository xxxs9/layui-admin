/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : mask

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 02/03/2020 09:47:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_access_permission_test
-- ----------------------------
DROP TABLE IF EXISTS `sys_access_permission_test`;
CREATE TABLE `sys_access_permission_test` (
  `ID` varchar(32) NOT NULL COMMENT '访问权限表',
  `URL` varchar(50) DEFAULT NULL COMMENT '访问链接',
  `ROLES` varchar(255) DEFAULT NULL COMMENT '角色列表用,分割',
  `SORT` int(11) DEFAULT NULL COMMENT '排序号',
  `IS_DELETED` int(2) DEFAULT NULL COMMENT '是否删除',
  `CREATE_USER` varchar(32) DEFAULT NULL COMMENT '创建用户',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_USER` varchar(50) DEFAULT NULL COMMENT '更新用户',
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE KEY `uidx_request_url` (`URL`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_access_permission_test
-- ----------------------------
BEGIN;
INSERT INTO `sys_access_permission_test` VALUES ('0fe694661a0a4b3f8485ad465808129c', 'shipment/*', 'authc,roles[admin]', 712, NULL, 'gameloft9', NULL, NULL, NULL);
INSERT INTO `sys_access_permission_test` VALUES ('1', '/', 'anon', 1, 0, 'admin', '2017-12-25 16:41:02', 'admin', '2017-12-25 16:41:02');
INSERT INTO `sys_access_permission_test` VALUES ('2', '/index', 'anon', 2, 0, 'admin', '2017-12-25 16:41:08', 'admin', '2017-12-25 16:41:08');
INSERT INTO `sys_access_permission_test` VALUES ('3', '/login', 'anon', 3, 0, 'admin', '2017-12-25 16:41:08', 'admin', '2017-12-25 16:41:08');
INSERT INTO `sys_access_permission_test` VALUES ('4', '/role/*', 'authc,roles[admin]', 5, 0, 'admin', '2017-12-25 16:41:08', 'admin', '2017-12-25 16:41:08');
INSERT INTO `sys_access_permission_test` VALUES ('473dede0102349b0a69e30dea2d0ad07', 'sale/*', 'authc,roles[admin]', 913, NULL, 'gameloft9', NULL, NULL, NULL);
INSERT INTO `sys_access_permission_test` VALUES ('5', '/getVCode', 'anon', 4, 0, 'admin', '2017-12-25 16:41:09', 'admin', '2017-12-25 16:41:09');
INSERT INTO `sys_access_permission_test` VALUES ('6', '/**/*.do', 'authc', 999, 0, 'admin', '2017-12-25 16:41:09', 'admin', '2017-12-25 16:41:09');
INSERT INTO `sys_access_permission_test` VALUES ('6319f8a7688343139ac4ba0d40877e2c', 'sys/*', 'authc,roles[test,admin]', 201, 0, 'gameloft9', '2017-12-28 11:04:58', NULL, '2017-12-28 11:04:58');
INSERT INTO `sys_access_permission_test` VALUES ('7042e4eeebf5433388ddfdfb09764369', 'log/*', 'authc,roles[test,admin]', 419, 0, 'gameloft9', '2017-12-27 17:04:10', NULL, '2017-12-27 17:04:10');
INSERT INTO `sys_access_permission_test` VALUES ('7c1f21aa63cf4fd6a5be43072e81ab99', 'test/*', 'authc,roles[test,admin]', 135, 0, 'gameloft9', '2017-12-28 11:05:10', NULL, '2017-12-28 11:05:10');
INSERT INTO `sys_access_permission_test` VALUES ('7ee176c20c904536862da37aacb0f7c8', 'org/*', 'authc,roles[test]', 123, 0, 'gameloft9', '2017-12-27 17:04:18', NULL, '2017-12-27 17:04:18');
INSERT INTO `sys_access_permission_test` VALUES ('8e68507e882c4165b06a4a9147d14a34', 'role/*', 'authc,roles[admin]', 669, 0, 'gameloft9', '2017-12-27 17:04:04', NULL, '2017-12-27 17:04:04');
INSERT INTO `sys_access_permission_test` VALUES ('90762decb8874ba0955eb8cef21b6682', 'menu/*', 'authc,roles[admin]', 197, 0, 'gameloft9', '2017-12-28 11:02:26', NULL, '2017-12-28 11:02:26');
INSERT INTO `sys_access_permission_test` VALUES ('a1b603589a8a4f24b597552d6d99ac18', 'depository/*', 'authc,roles[admin]', 229, NULL, 'gameloft9', NULL, NULL, NULL);
INSERT INTO `sys_access_permission_test` VALUES ('c8c4e92a1ece4da79ede1763faecdf77', 'sysUser/*', 'authc,roles[admin]', 170, 0, 'gameloft9', '2017-12-27 17:05:49', NULL, '2017-12-27 17:05:49');
INSERT INTO `sys_access_permission_test` VALUES ('ef8c456e99834708b58b17052e1ec46c', 'salesman/*', 'authc,roles[admin]', 389, NULL, 'gameloft9', NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_menu_role_test
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_role_test`;
CREATE TABLE `sys_menu_role_test` (
  `ID` varchar(32) NOT NULL,
  `MENU_ID` varchar(32) DEFAULT NULL COMMENT '菜单id',
  `ROLE_ID` varchar(32) DEFAULT NULL COMMENT '角色id',
  `CREATE_USER` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_USER` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE KEY `uidx_menu_role` (`MENU_ID`,`ROLE_ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_menu_role_test
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu_role_test` VALUES ('123456789ijhg', '244247008b53450fa16bc503bc861b7c', 'J/F9-+?', NULL, '2017-12-26 09:46:03', NULL, '2017-12-26 09:46:03');
INSERT INTO `sys_menu_role_test` VALUES ('274379523d13415abf4b9d76ea5e591c', 'd525347f788e4f7e8662a35ff8456ff4', 'J/F9-+?', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_role_test` VALUES ('27af18ffd01a4ab683769d3e32d57570', 'ecc0342b579140718f705117a1643502', 'J/F9-+?', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_role_test` VALUES ('2cc73b635ec943e3820223ef099fb440', 'a4cb3bb7ee41498dbc3a15ebd62a460d', 'J/F9-+?', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_role_test` VALUES ('4523b393aae64771aac4f91c5623599b', '244247008b53450fa16bc503bc861b7c', '343859934ece44c988f53700fb34c80a', NULL, '2018-01-11 14:47:33', NULL, '2018-01-11 14:47:33');
INSERT INTO `sys_menu_role_test` VALUES ('5905556900e741a89aafec25948b8fca', '89e9f1eb41a240fea361e0d188375884', 'J/F9-+?', NULL, '2017-12-27 17:04:18', NULL, '2017-12-27 17:04:18');
INSERT INTO `sys_menu_role_test` VALUES ('5b79d6e436154cfb9533a531fb7eb744', '882b26afbdbb4d63bcba0cd826a5b9c1', '343859934ece44c988f53700fb34c80a', NULL, '2018-01-11 14:47:16', NULL, '2018-01-11 14:47:16');
INSERT INTO `sys_menu_role_test` VALUES ('6302f705514e4c839400f804ec29ec5c', '89e9f1eb41a240fea361e0d188375884', '343859934ece44c988f53700fb34c80a', NULL, '2018-01-11 14:46:55', NULL, '2018-01-11 14:46:55');
INSERT INTO `sys_menu_role_test` VALUES ('71fa522e4da04ab9abd6008d2cb1c070', '26b3df2c6d464a0b89858eb896b849d2', 'J/F9-+?', NULL, '2017-12-27 17:05:49', NULL, '2017-12-27 17:05:49');
INSERT INTO `sys_menu_role_test` VALUES ('874970f9c9b14021909485f201479373', '1688998d013c4ebf95be6fd7e1fecb20', 'J/F9-+?', NULL, '2017-12-28 11:05:10', NULL, '2017-12-28 11:05:10');
INSERT INTO `sys_menu_role_test` VALUES ('asdfr456yhbv123', '4a7f3cae133e4a51b8f35769b55163dd', 'J/F9-+?', NULL, '2017-12-26 09:46:29', NULL, '2017-12-26 09:46:29');
INSERT INTO `sys_menu_role_test` VALUES ('bd3b96f8742940e8acc628ff5c940465', 'b53bfdfe33444703aa76c2c1a1b8d820', 'J/F9-+?', NULL, '2017-12-27 17:04:03', NULL, '2017-12-27 17:04:03');
INSERT INTO `sys_menu_role_test` VALUES ('c89cc73ffa1b40da943cb542b9b9819f', '882b26afbdbb4d63bcba0cd826a5b9c1', 'J/F9-+?', NULL, '2017-12-27 17:04:10', NULL, '2017-12-27 17:04:10');
INSERT INTO `sys_menu_role_test` VALUES ('d8347b1cce0a4e06b5175d830fa0c289', 'a132635866894774989f672e7688474a', 'J/F9-+?', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu_role_test` VALUES ('e92a68532e134b2e9b8af46a43ce61e0', '1688998d013c4ebf95be6fd7e1fecb20', '343859934ece44c988f53700fb34c80a', NULL, '2018-01-11 14:47:42', NULL, '2018-01-11 14:47:42');
COMMIT;

-- ----------------------------
-- Table structure for sys_menu_test
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu_test`;
CREATE TABLE `sys_menu_test` (
  `ID` varchar(32) NOT NULL COMMENT '菜单表',
  `TITLE` varchar(100) NOT NULL COMMENT '菜单名称',
  `HREF` varchar(200) NOT NULL COMMENT '访问链接',
  `REQUEST_URL` varchar(200) DEFAULT NULL COMMENT '后台请求url',
  `ICON` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `CODE` varchar(100) DEFAULT NULL COMMENT '菜单编码',
  `TARGET` varchar(50) DEFAULT NULL COMMENT '目标窗口,_blank则直接跳转，否则在子页面打开',
  `PARENT_ID` varchar(32) DEFAULT NULL COMMENT '父菜单',
  `SORT` int(2) DEFAULT NULL COMMENT '排序号',
  `CREATE_USER` varchar(32) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `UPDATE_USER` varchar(32) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE KEY `uidx_title` (`TITLE`) USING BTREE,
  UNIQUE KEY `uidx_menu_req_url` (`REQUEST_URL`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_menu_test
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu_test` VALUES ('1688998d013c4ebf95be6fd7e1fecb20', '测试一级菜单', '/memCard/index.do', 'test/*', 'icon-text', '2', NULL, NULL, 2, 'gameloft9', '2017-12-27 17:09:17', NULL, '2017-12-27 17:09:17');
INSERT INTO `sys_menu_test` VALUES ('244247008b53450fa16bc503bc861b7c', '系统管理', '#', 'sys/*', 'icon-text', '1', NULL, NULL, 1, 'gameloft9', '2017-12-25 19:31:22', NULL, '2017-12-25 19:31:22');
INSERT INTO `sys_menu_test` VALUES ('26b3df2c6d464a0b89858eb896b849d2', '系统用户管理', 'page/system/sysUser/allUsers.html', 'sysUser/*', 'icon-text', '1-5', NULL, '244247008b53450fa16bc503bc861b7c', 4, 'gameloft9', '2017-12-27 17:05:40', NULL, '2017-12-27 17:05:40');
INSERT INTO `sys_menu_test` VALUES ('4a7f3cae133e4a51b8f35769b55163dd', '菜单管理', 'page/system/sysMenu/allMenus.html', 'menu/*', 'icon-text', '1-1', NULL, '244247008b53450fa16bc503bc861b7c', 1, 'gameloft9', '2017-12-25 19:32:25', NULL, '2017-12-25 19:32:25');
INSERT INTO `sys_menu_test` VALUES ('882b26afbdbb4d63bcba0cd826a5b9c1', '系统日志管理', 'page/system/sysLog/allLogs.html', 'log/*', 'icon-text', '1-4', NULL, '244247008b53450fa16bc503bc861b7c', 5, 'gameloft9', '2017-12-27 17:03:41', NULL, '2017-12-27 17:03:41');
INSERT INTO `sys_menu_test` VALUES ('89e9f1eb41a240fea361e0d188375884', '机构管理', 'page/system/sysOrg/allOrgs.html', 'org/*', 'icon-text', '1-2', NULL, '244247008b53450fa16bc503bc861b7c', 3, 'gameloft9', '2017-12-27 17:01:58', NULL, '2017-12-27 17:01:58');
INSERT INTO `sys_menu_test` VALUES ('a132635866894774989f672e7688474a', '出库记录', 'page/depository/shipment/allShipment.html', 'shipment/*', 'icon-text', '4-1', NULL, 'a4cb3bb7ee41498dbc3a15ebd62a460d', 31, 'gameloft9', NULL, NULL, NULL);
INSERT INTO `sys_menu_test` VALUES ('a4cb3bb7ee41498dbc3a15ebd62a460d', '库存管理', '#', 'depository/*', 'icon-text', '4', NULL, NULL, 3, 'gameloft9', NULL, NULL, NULL);
INSERT INTO `sys_menu_test` VALUES ('b53bfdfe33444703aa76c2c1a1b8d820', '角色管理', 'page/system/sysRole/allRoles.html', 'role/*', 'icon-text', '1-3', NULL, '244247008b53450fa16bc503bc861b7c', 2, 'gameloft9', '2017-12-27 17:02:42', NULL, '2017-12-27 17:02:42');
INSERT INTO `sys_menu_test` VALUES ('d525347f788e4f7e8662a35ff8456ff4', '销售管理', '#', 'sale/*', 'icon-text', '3', NULL, NULL, 2, 'gameloft9', NULL, NULL, NULL);
INSERT INTO `sys_menu_test` VALUES ('ecc0342b579140718f705117a1643502', '销售人员管理', 'page/sale/salesman/allSalesman.html', 'salesman/*', 'icon-text', '3-1', NULL, 'd525347f788e4f7e8662a35ff8456ff4', 21, 'gameloft9', NULL, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for sys_oper_log_test
-- ----------------------------
DROP TABLE IF EXISTS `sys_oper_log_test`;
CREATE TABLE `sys_oper_log_test` (
  `ID` varchar(32) NOT NULL COMMENT '应用日志表',
  `USER_ID` varchar(32) DEFAULT NULL,
  `LOGIN_NAME` varchar(32) DEFAULT NULL,
  `IP_ADDR` varchar(64) DEFAULT NULL,
  `OPER_TYPE` varchar(200) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `MEMO` varchar(1500) DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_oper_log_test
-- ----------------------------
BEGIN;
INSERT INTO `sys_oper_log_test` VALUES ('435a7c8a114e4cdaa1350dcf5be1ad99', '123', 'gameloft9', '0:0:0:0:0:0:0:1', 'upd', '2020-02-27 01:34:30', '更新菜单');
INSERT INTO `sys_oper_log_test` VALUES ('5574fb2e0f1a4ee88d764c527b687205', '123', 'gameloft9', '0:0:0:0:0:0:0:1', 'upd', '2020-02-27 05:54:29', '更新菜单');
INSERT INTO `sys_oper_log_test` VALUES ('9dd526abac5e49389e45aa4e55b3445c', '123', 'gameloft9', '0:0:0:0:0:0:0:1', 'upd', '2020-02-27 01:34:24', '更新菜单');
INSERT INTO `sys_oper_log_test` VALUES ('abba4202a1784e9d9498dca0e079e9d5', '123', 'gameloft9', '0:0:0:0:0:0:0:1', 'add', '2020-02-27 01:34:05', '添加菜单');
INSERT INTO `sys_oper_log_test` VALUES ('af14161e1214462f8c9e9493b8652192', '123', 'gameloft9', '0:0:0:0:0:0:0:1', 'add', '2020-02-27 05:53:03', '添加菜单');
INSERT INTO `sys_oper_log_test` VALUES ('c21e3ff6c3b8406fa5d237426bdb1e13', '123', 'gameloft9', '0:0:0:0:0:0:0:1', 'upd', '2020-02-27 05:54:22', '更新菜单');
INSERT INTO `sys_oper_log_test` VALUES ('c4c7c11aef8f4f49b8238c3f4fe566be', '123', 'gameloft9', '0:0:0:0:0:0:0:1', 'add', '2020-02-27 05:53:55', '添加菜单');
INSERT INTO `sys_oper_log_test` VALUES ('f7d79f54e931470c829f156e0661dfd2', '123', 'gameloft9', '0:0:0:0:0:0:0:1', 'add', '2020-02-27 01:32:46', '添加菜单');
COMMIT;

-- ----------------------------
-- Table structure for sys_organize_test
-- ----------------------------
DROP TABLE IF EXISTS `sys_organize_test`;
CREATE TABLE `sys_organize_test` (
  `ID` varchar(32) NOT NULL COMMENT '组织机构表',
  `PARENT_ID` varchar(32) DEFAULT NULL,
  `ORGANIZE_NAME` varchar(255) NOT NULL COMMENT '机构名称',
  `ORGANIZE_CODE` varchar(8) NOT NULL COMMENT '机构编码',
  `TREE_LEVEL` int(11) NOT NULL COMMENT '机构级别',
  `TREE_PATH` varchar(200) DEFAULT NULL COMMENT '机构路径',
  `CREATE_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE KEY `uidx_org_name` (`ORGANIZE_NAME`) USING BTREE,
  UNIQUE KEY `uidx_org_code` (`ORGANIZE_CODE`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_organize_test
-- ----------------------------
BEGIN;
INSERT INTO `sys_organize_test` VALUES ('21a6ff8a6abf410eaf97981c1da039d8', NULL, '总公司', '010001', 1, '21a6ff8a6abf410eaf97981c1da039d8', '2017-12-27 17:06:04', '2017-12-27 17:06:04');
INSERT INTO `sys_organize_test` VALUES ('54fa67f3d443427c9f47432ead20f2f4', '21a6ff8a6abf410eaf97981c1da039d8', '湖北分公司', '010002', 2, '21a6ff8a6abf410eaf97981c1da039d8#54fa67f3d443427c9f47432ead20f2f4', '2017-12-27 17:06:22', '2017-12-27 17:06:22');
COMMIT;

-- ----------------------------
-- Table structure for sys_role_test
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_test`;
CREATE TABLE `sys_role_test` (
  `ID` varchar(32) NOT NULL COMMENT '角色表',
  `ROLE_NAME` varchar(50) NOT NULL COMMENT '角色名',
  `IS_SUPER` int(2) DEFAULT NULL COMMENT '是否是超级管理员',
  `IS_DELETED` int(2) DEFAULT NULL COMMENT '是否删除',
  `CREATE_USER` varchar(50) DEFAULT NULL COMMENT '创建用户',
  `CREATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_USER` varchar(50) DEFAULT NULL COMMENT '更新用户',
  `UPDATE_TIME` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_role_test
-- ----------------------------
BEGIN;
INSERT INTO `sys_role_test` VALUES ('343859934ece44c988f53700fb34c80a', 'test', 0, 0, 'gameloft9', '2018-01-11 14:46:22', NULL, '2018-01-11 14:46:22');
INSERT INTO `sys_role_test` VALUES ('J/F9-+?', 'admin', 1, 0, 'v[l_4zL8', '2008-03-01 04:17:00', ':9He2+GW', '2002-09-27 03:13:16');
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` varchar(32) NOT NULL COMMENT '用户测试表',
  `LOGIN_NAME` varchar(10) DEFAULT NULL,
  `PASSWORD` varchar(128) DEFAULT NULL,
  `REAL_NAME` varchar(50) DEFAULT NULL,
  `IS_FORBIDDEN` varchar(2) DEFAULT NULL,
  `MOBILE` varchar(11) DEFAULT NULL,
  `ICON` varchar(200) DEFAULT NULL,
  `ORG_ID` varchar(32) DEFAULT NULL,
  `ORG_NAME` varchar(50) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `UPDATE_DATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE KEY `uidx_login_name` (`LOGIN_NAME`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES ('123', 'gameloft9', '7C4A8D09CA3762AF61E59520943DC26494F8941B', 'leiyao', '0', '13618629441', NULL, 'gameloft9', '总公司', '2017-12-28 16:24:32', '2017-12-28 16:32:57');
COMMIT;

-- ----------------------------
-- Table structure for sys_user_role_test
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role_test`;
CREATE TABLE `sys_user_role_test` (
  `ID` varchar(32) NOT NULL COMMENT '用户角色表',
  `USER_ID` varchar(32) DEFAULT NULL COMMENT '用户ID',
  `ROLE_ID` varchar(32) DEFAULT NULL COMMENT '角色ID',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_user_role_test
-- ----------------------------
BEGIN;
INSERT INTO `sys_user_role_test` VALUES ('03f9afb1d42e49d6a026f537d9f033b6', '9dbdc3a6cc444190bb5ac4e15df6234b', '343859934ece44c988f53700fb34c80a');
INSERT INTO `sys_user_role_test` VALUES ('2fb2a9fb965e462eb72c14361a83f006', '123', 'J/F9-+?');
COMMIT;

-- ----------------------------
-- Table structure for t_depository_shipment_record
-- ----------------------------
DROP TABLE IF EXISTS `t_depository_shipment_record`;
CREATE TABLE `t_depository_shipment_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shipment_type_id` int(11) DEFAULT NULL,
  `shipment_mode_type_id` int(11) DEFAULT NULL,
  `relation_id` varchar(64) NOT NULL,
  `mark` varchar(200) DEFAULT NULL,
  `shipment_date` bigint(20) DEFAULT NULL,
  `create_id` varchar(64) NOT NULL,
  `create_date` bigint(20) NOT NULL,
  `is_del` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_depository_shipment_record_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_depository_shipment_record_detail`;
CREATE TABLE `t_depository_shipment_record_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shipment_record_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `carton_box_number` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_depository_storage_record
-- ----------------------------
DROP TABLE IF EXISTS `t_depository_storage_record`;
CREATE TABLE `t_depository_storage_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `storage_type_id` int(11) DEFAULT NULL,
  `relation_id` varchar(64) NOT NULL,
  `mark` varchar(200) DEFAULT NULL,
  `create_id` varchar(64) NOT NULL,
  `create_date` bigint(20) NOT NULL,
  `is_del` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_depository_storage_record_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_depository_storage_record_detail`;
CREATE TABLE `t_depository_storage_record_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `storage_record_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_finance_payable
-- ----------------------------
DROP TABLE IF EXISTS `t_finance_payable`;
CREATE TABLE `t_finance_payable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `relation_id` varchar(64) NOT NULL,
  `payable_type_id` int(11) DEFAULT NULL,
  `payee` varchar(50) NOT NULL,
  `payable_amount` decimal(10,2) NOT NULL,
  `mark` varchar(200) DEFAULT NULL,
  `create_id` varchar(64) NOT NULL,
  `create_date` bigint(20) NOT NULL,
  `is_del` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_finance_payment_record
-- ----------------------------
DROP TABLE IF EXISTS `t_finance_payment_record`;
CREATE TABLE `t_finance_payment_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `payable_id` int(11) NOT NULL,
  `relation_id` varchar(64) NOT NULL,
  `payment_type_id` int(11) DEFAULT NULL,
  `payee` varchar(50) NOT NULL,
  `payment_amount` decimal(10,2) NOT NULL,
  `mark` varchar(200) DEFAULT NULL,
  `create_id` varchar(64) NOT NULL,
  `create_date` bigint(20) NOT NULL,
  `is_del` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_finance_receipt_record
-- ----------------------------
DROP TABLE IF EXISTS `t_finance_receipt_record`;
CREATE TABLE `t_finance_receipt_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `receivables_id` int(11) NOT NULL,
  `relation_id` varchar(64) NOT NULL,
  `payer` varchar(50) DEFAULT NULL,
  `receipt_type_id` int(11) NOT NULL,
  `receipt_amount` decimal(10,2) NOT NULL,
  `receipt_account_type_id` int(11) DEFAULT NULL,
  `mark` varchar(200) DEFAULT NULL,
  `receipt_date` bigint(20) DEFAULT NULL,
  `create_id` varchar(64) NOT NULL,
  `create_date` bigint(20) NOT NULL,
  `is_del` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_finance_receivables
-- ----------------------------
DROP TABLE IF EXISTS `t_finance_receivables`;
CREATE TABLE `t_finance_receivables` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `relation_id` varchar(64) NOT NULL,
  `receivables_type_id` int(11) NOT NULL,
  `payer` varchar(50) DEFAULT NULL,
  `receivables_amount` decimal(10,2) NOT NULL,
  `mark` varchar(200) DEFAULT NULL,
  `create_id` varchar(64) NOT NULL,
  `create_date` bigint(20) NOT NULL,
  `is_del` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_produce_record
-- ----------------------------
DROP TABLE IF EXISTS `t_produce_record`;
CREATE TABLE `t_produce_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_id` varchar(64) NOT NULL,
  `create_date` bigint(20) NOT NULL,
  `mark` varchar(200) DEFAULT NULL,
  `is_del` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_produce_record_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_produce_record_detail`;
CREATE TABLE `t_produce_record_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `produce_record_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `number` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_sale_order
-- ----------------------------
DROP TABLE IF EXISTS `t_sale_order`;
CREATE TABLE `t_sale_order` (
  `sale_order_number` varchar(64) NOT NULL,
  `buyer` varchar(50) DEFAULT NULL,
  `salesman_id` int(11) DEFAULT NULL,
  `total_price` decimal(10,2) NOT NULL,
  `order_amount` decimal(10,2) NOT NULL,
  `expected_delivery_date` bigint(20) DEFAULT NULL,
  `create_id` varchar(64) NOT NULL,
  `create_date` bigint(20) NOT NULL,
  `is_del` tinyint(1) NOT NULL DEFAULT '0',
  `payment_state` int(8) NOT NULL,
  `shipment_state` int(8) NOT NULL,
  `order_state` int(8) NOT NULL,
  PRIMARY KEY (`sale_order_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_sale_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_sale_order_detail`;
CREATE TABLE `t_sale_order_detail` (
  `sale_order_detail_number` varchar(64) NOT NULL,
  `sale_order_number` varchar(64) NOT NULL,
  `product_id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `unit_price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`sale_order_detail_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_sale_salesman
-- ----------------------------
DROP TABLE IF EXISTS `t_sale_salesman`;
CREATE TABLE `t_sale_salesman` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `salesman_name` varchar(20) NOT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `account` varchar(50) DEFAULT NULL,
  `create_id` varchar(64) NOT NULL,
  `create_date` bigint(20) NOT NULL,
  `is_del` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_sale_salesman
-- ----------------------------
BEGIN;
INSERT INTO `t_sale_salesman` VALUES (1, '王彬', '', '', '123', 1582769828976, 0);
INSERT INTO `t_sale_salesman` VALUES (2, '曾小丽', '', '', '123', 1582770908403, 0);
COMMIT;

-- ----------------------------
-- Procedure structure for prc_init_db
-- ----------------------------
DROP PROCEDURE IF EXISTS `prc_init_db`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `prc_init_db`()
begin
   /*
   清空表
   */
   delete from   `sys_access_permission_test`;
   delete from   `sys_menu_role_test`;
   delete from   `sys_menu_test`;
   delete from   `sys_oper_log_test`;
   delete from   `sys_organize_test`;
   delete from   `sys_role_test`;
   delete from   `sys_user_role_test`;


   /*初始化数据-user_test*/
   insert into `user_test`(`ID`,`LOGIN_NAME`,`PASSWORD`,`REAL_NAME`,`IS_FORBIDDEN`,`MOBILE`,`ICON`,`ORG_ID`,`ORG_NAME`,`CREATE_DATE`,`UPDATE_DATE`)
values('123','gameloft9','7C4A8D09CA3762AF61E59520943DC26494F8941B','leiyao','0','13618629441',null,'gameloft9','总公司','2017-12-28 16:24:32','2017-12-28 16:32:57');

/*初始化数据-sys_access_permission_test*/
insert into `sys_access_permission_test`(`ID`,`URL`,`ROLES`,`SORT`,`IS_DELETED`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`) values
('c8c4e92a1ece4da79ede1763faecdf77','/sysUser/**','authc,roles[admin]','170','0','gameloft9','2017-12-27 17:05:49',null,'2017-12-27 17:05:49'),
('90762decb8874ba0955eb8cef21b6682','/menu/**','authc,roles[admin]','197','0','gameloft9','2017-12-28 11:02:26',null,'2017-12-28 11:02:26'),
('7ee176c20c904536862da37aacb0f7c8','/org/**','authc,roles[test]','123','0','gameloft9','2017-12-27 17:04:18',null,'2017-12-27 17:04:18'),
('7c1f21aa63cf4fd6a5be43072e81ab99','/test/**','authc,roleOr[test,admin]','135','0','gameloft9','2017-12-28 11:05:10',null,'2017-12-28 11:05:10'),
('7042e4eeebf5433388ddfdfb09764369','/log/**','authc,roleOr[test,admin]','419','0','gameloft9','2017-12-27 17:04:10',null,'2017-12-27 17:04:10'),
('6319f8a7688343139ac4ba0d40877e2c','/sys/**','authc,roleOr[test,admin]','201','0','gameloft9','2017-12-28 11:04:58',null,'2017-12-28 11:04:58'),
('6','/**/*.do','authc','999','0','admin','2017-12-25 16:41:09','admin','2017-12-25 16:41:09'),
('5','/getVCode','anon','4','0','admin','2017-12-25 16:41:09','admin','2017-12-25 16:41:09'),
('4','/role/**','authc,roles[admin]','5','0','admin','2017-12-25 16:41:08','admin','2017-12-25 16:41:08'),
('3','/login','anon','3','0','admin','2017-12-25 16:41:08','admin','2017-12-25 16:41:08'),
('2','/index','anon','2','0','admin','2017-12-25 16:41:08','admin','2017-12-25 16:41:08'),
('1','/','anon','1','0','admin','2017-12-25 16:41:02','admin','2017-12-25 16:41:02');

/*初始化数据-sys_menu_role_test*/
insert into `sys_menu_role_test`(`ID`,`MENU_ID`,`ROLE_ID`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`) values
('e92a68532e134b2e9b8af46a43ce61e0','1688998d013c4ebf95be6fd7e1fecb20','343859934ece44c988f53700fb34c80a',null,'2018-01-11 14:47:42',null,'2018-01-11 14:47:42'),
('c89cc73ffa1b40da943cb542b9b9819f','882b26afbdbb4d63bcba0cd826a5b9c1','J/F9-+?',null,'2017-12-27 17:04:10',null,'2017-12-27 17:04:10'),
('bd3b96f8742940e8acc628ff5c940465','b53bfdfe33444703aa76c2c1a1b8d820','J/F9-+?',null,'2017-12-27 17:04:03',null,'2017-12-27 17:04:03'),
('asdfr456yhbv123','4a7f3cae133e4a51b8f35769b55163dd','J/F9-+?',null,'2017-12-26 09:46:29',null,'2017-12-26 09:46:29'),
('874970f9c9b14021909485f201479373','1688998d013c4ebf95be6fd7e1fecb20','J/F9-+?',null,'2017-12-28 11:05:10',null,'2017-12-28 11:05:10'),
('71fa522e4da04ab9abd6008d2cb1c070','26b3df2c6d464a0b89858eb896b849d2','J/F9-+?',null,'2017-12-27 17:05:49',null,'2017-12-27 17:05:49'),
('6302f705514e4c839400f804ec29ec5c','89e9f1eb41a240fea361e0d188375884','343859934ece44c988f53700fb34c80a',null,'2018-01-11 14:46:55',null,'2018-01-11 14:46:55'),
('5b79d6e436154cfb9533a531fb7eb744','882b26afbdbb4d63bcba0cd826a5b9c1','343859934ece44c988f53700fb34c80a',null,'2018-01-11 14:47:16',null,'2018-01-11 14:47:16'),
('5905556900e741a89aafec25948b8fca','89e9f1eb41a240fea361e0d188375884','J/F9-+?',null,'2017-12-27 17:04:18',null,'2017-12-27 17:04:18'),
('4523b393aae64771aac4f91c5623599b','244247008b53450fa16bc503bc861b7c','343859934ece44c988f53700fb34c80a',null,'2018-01-11 14:47:33',null,'2018-01-11 14:47:33'),
('123456789ijhg','244247008b53450fa16bc503bc861b7c','J/F9-+?',null,'2017-12-26 09:46:03',null,'2017-12-26 09:46:03');

/*初始化数据-sys_menu_test*/
insert into `sys_menu_test`(`ID`,`TITLE`,`HREF`,`REQUEST_URL`,`ICON`,`CODE`,`TARGET`,`PARENT_ID`,`SORT`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`) values
('b53bfdfe33444703aa76c2c1a1b8d820','角色管理','page/system/sysRole/allRoles.html','/role/**','icon-text','1-3',null,'244247008b53450fa16bc503bc861b7c','2','gameloft9','2017-12-27 17:02:42',null,'2017-12-27 17:02:42'),
('89e9f1eb41a240fea361e0d188375884','机构管理','page/system/sysOrg/allOrgs.html','/org/**','icon-text','1-2',null,'244247008b53450fa16bc503bc861b7c','3','gameloft9','2017-12-27 17:01:58',null,'2017-12-27 17:01:58'),
('882b26afbdbb4d63bcba0cd826a5b9c1','系统日志管理','page/system/sysLog/allLogs.html','/log/**','icon-text','1-4',null,'244247008b53450fa16bc503bc861b7c','5','gameloft9','2017-12-27 17:03:41',null,'2017-12-27 17:03:41'),
('4a7f3cae133e4a51b8f35769b55163dd','菜单管理','page/system/sysMenu/allMenus.html','/menu/**','icon-text','1-1',null,'244247008b53450fa16bc503bc861b7c','1','gameloft9','2017-12-25 19:32:25',null,'2017-12-25 19:32:25'),
('26b3df2c6d464a0b89858eb896b849d2','系统用户管理','page/system/sysUser/allUsers.html','/sysUser/**','icon-text','1-5',null,'244247008b53450fa16bc503bc861b7c','4','gameloft9','2017-12-27 17:05:40',null,'2017-12-27 17:05:40'),
('244247008b53450fa16bc503bc861b7c','系统管理','#','/sys/**','icon-text','1',null,null,'1','gameloft9','2017-12-25 19:31:22',null,'2017-12-25 19:31:22'),
('1688998d013c4ebf95be6fd7e1fecb20','测试一级菜单','/memCard/index.do','test/**','icon-text','2',null,null,'2','gameloft9','2017-12-27 17:09:17',null,'2017-12-27 17:09:17');

/*初始化数据-sys_organize_test*/
insert into `sys_organize_test`(`ID`,`PARENT_ID`,`ORGANIZE_NAME`,`ORGANIZE_CODE`,`TREE_LEVEL`,`TREE_PATH`,`CREATE_DATE`,`UPDATE_DATE`) values
('54fa67f3d443427c9f47432ead20f2f4','21a6ff8a6abf410eaf97981c1da039d8','湖北分公司','010002','2','21a6ff8a6abf410eaf97981c1da039d8#54fa67f3d443427c9f47432ead20f2f4','2017-12-27 17:06:22','2017-12-27 17:06:22'),
('21a6ff8a6abf410eaf97981c1da039d8',null,'总公司','010001','1','21a6ff8a6abf410eaf97981c1da039d8','2017-12-27 17:06:04','2017-12-27 17:06:04');

/*初始化数据-sys_role_test*/
insert into `sys_role_test`(`ID`,`ROLE_NAME`,`IS_SUPER`,`IS_DELETED`,`CREATE_USER`,`CREATE_TIME`,`UPDATE_USER`,`UPDATE_TIME`) values
('J/F9-+?','admin','1','0','v[l_4zL8','2008-03-01 04:17:00',':9He2+GW','2002-09-27 03:13:16'),
('343859934ece44c988f53700fb34c80a','test','0','0','gameloft9','2018-01-11 14:46:22',null,'2018-01-11 14:46:22');

/*初始化数据-sys_user_role_test*/
insert into `sys_user_role_test`(`ID`,`USER_ID`,`ROLE_ID`) values
('2fb2a9fb965e462eb72c14361a83f006','123','J/F9-+?'),
('03f9afb1d42e49d6a026f537d9f033b6','9dbdc3a6cc444190bb5ac4e15df6234b','343859934ece44c988f53700fb34c80a');
   
end;
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
