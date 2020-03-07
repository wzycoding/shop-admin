/*
Navicat MySQL Data Transfer

Source Server         : jinchacha-local
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2020-03-07 21:49:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `acl`
-- ----------------------------
DROP TABLE IF EXISTS `acl`;
CREATE TABLE `acl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) NOT NULL COMMENT '权限名称',
  `path` varchar(100) NOT NULL COMMENT '路径',
  `level` int(11) NOT NULL COMMENT '权限等级',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `updated_time` datetime NOT NULL COMMENT '修改时间',
  `delete` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='权限表';

-- ----------------------------
-- Records of acl
-- ----------------------------
INSERT INTO `acl` VALUES ('1', '添加用户', '/user/add', '1', '2020-02-24 18:36:34', '2020-02-24 18:36:38', '0');
INSERT INTO `acl` VALUES ('2', '删除用户', '/user/delete', '3', '2020-02-24 18:37:29', '2020-02-24 18:37:33', '0');
INSERT INTO `acl` VALUES ('3', '查询用户', '/user/find', '2', '2020-02-24 18:37:56', '2020-02-24 18:37:59', '0');

-- ----------------------------
-- Table structure for `acl_role`
-- ----------------------------
DROP TABLE IF EXISTS `acl_role`;
CREATE TABLE `acl_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `acl_id` bigint(20) NOT NULL COMMENT '权限id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `updated_time` datetime NOT NULL COMMENT '修改时间',
  `delete` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色权限表';

-- ----------------------------
-- Records of acl_role
-- ----------------------------

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `auth_name` varchar(20) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父id',
  `level_index` int(11) NOT NULL DEFAULT '0' COMMENT '层级索引',
  `path` varchar(100) NOT NULL DEFAULT '' COMMENT '菜单指向路径',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `updated_time` datetime NOT NULL COMMENT '修改时间',
  `delete` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='菜单表';

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '用户管理', '0', '0', '', '2020-02-19 15:53:15', '2020-02-19 15:53:18', '0');
INSERT INTO `menu` VALUES ('2', '权限管理', '0', '0', '', '2020-02-19 15:53:44', '2020-02-19 15:53:48', '0');
INSERT INTO `menu` VALUES ('3', '商品管理', '0', '0', '', '2020-02-19 15:56:21', '2020-02-19 15:56:24', '0');
INSERT INTO `menu` VALUES ('4', '订单管理', '0', '0', '', '2020-02-19 15:56:38', '2020-02-19 15:56:40', '0');
INSERT INTO `menu` VALUES ('5', '数据统计', '0', '0', '', '2020-02-19 15:57:07', '2020-02-19 15:57:09', '0');
INSERT INTO `menu` VALUES ('6', '用户列表', '1', '1', 'users', '2020-02-19 15:57:45', '2020-02-19 15:57:49', '0');
INSERT INTO `menu` VALUES ('7', '角色列表', '2', '1', 'roles', '2020-02-19 15:59:01', '2020-02-19 15:59:04', '0');
INSERT INTO `menu` VALUES ('8', '权限列表', '2', '1', 'rights', '2020-02-19 15:59:24', '2020-02-19 15:59:29', '0');
INSERT INTO `menu` VALUES ('9', '商品列表', '3', '1', 'goods', '2020-02-19 16:00:02', '2020-02-19 16:00:17', '0');
INSERT INTO `menu` VALUES ('10', '分类参数', '3', '1', 'cateParam', '2020-02-19 16:00:51', '2020-02-19 16:00:56', '0');
INSERT INTO `menu` VALUES ('11', '商品分类', '3', '1', 'goodsCate', '2020-02-19 16:01:28', '2020-02-19 16:01:31', '0');
INSERT INTO `menu` VALUES ('12', '订单列表', '4', '1', 'order', '2020-02-19 16:05:35', '2020-02-19 16:05:40', '0');
INSERT INTO `menu` VALUES ('13', '统计结果', '5', '1', 'result', '2020-02-19 16:06:16', '2020-02-19 16:06:19', '0');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) NOT NULL COMMENT '角色名称',
  `type` int(11) NOT NULL COMMENT '角色类型',
  `seq` int(11) NOT NULL COMMENT '优先级',
  `remark` varchar(200) NOT NULL DEFAULT '' COMMENT '角色备注',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `updated_time` datetime NOT NULL COMMENT '修改时间',
  `delete` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for `role_user`
-- ----------------------------
DROP TABLE IF EXISTS `role_user`;
CREATE TABLE `role_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `role_id` bigint(20) NOT NULL COMMENT '角色id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `updated_time` datetime NOT NULL COMMENT '修改时间',
  `delete` int(11) NOT NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户角色表';

-- ----------------------------
-- Records of role_user
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '閻㈤潧鐡欓柇顔绢唸',
  `avatar` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '澶村儚',
  `nickname` varchar(20) NOT NULL COMMENT '昵称',
  `phone` varchar(11) NOT NULL COMMENT '手机号码',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `last_login_time` datetime NOT NULL COMMENT '最后登录时间',
  `delete` int(11) NOT NULL DEFAULT '0' COMMENT '鍒犻櫎鏍囪',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'admin', '842089160@qq.com', 'a.jpg', '风云', '13191919919', '2020-02-04 16:18:24', '2020-01-07 16:18:28', '0');
INSERT INTO `user` VALUES ('2', '圆猪头', 'aaaa', '1234567@qq.com', 'aaaa', '圆猪头', '13498987871', '2020-02-21 13:38:16', '2020-02-21 13:38:20', '1');
INSERT INTO `user` VALUES ('3', 'xiaoyuan', 'xiaoyuan521', '79797979@qq.com', '', '圆可爱', '17681826211', '2020-02-22 22:43:03', '2020-02-22 22:43:03', '1');
INSERT INTO `user` VALUES ('4', '圆圆521', 'll03001360', '7777737273@qq.com', '', '圆撇五', '17681826219', '2020-02-23 11:44:37', '2020-02-23 11:44:37', '1');
INSERT INTO `user` VALUES ('5', '袁小滨', '123456', '83883838@qq.com', '', '滨滨', '13199299299', '2020-02-23 15:05:50', '2020-02-23 15:05:50', '1');
INSERT INTO `user` VALUES ('6', '袁小婷', '1234567', '6666@qq.com', '', '小婷', '13199399911', '2020-02-23 15:06:42', '2020-02-23 15:06:42', '0');
