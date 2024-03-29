/*
Navicat MySQL Data Transfer

Source Server         : localhost_3307
Source Server Version : 50562
Source Host           : localhost:3307
Source Database       : sprdxsjszhglxthsg4193wece

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2022-04-04 20:13:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin_info`
-- ----------------------------
DROP TABLE IF EXISTS `admin_info`;
CREATE TABLE `admin_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `mima` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `nickName` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `sex` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `age` int(10) DEFAULT NULL COMMENT '年龄',
  `birthday` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '生日',
  `phone` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `address` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `code` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '编号',
  `email` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `cardId` varchar(175) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '身份证',
  `account` double(10,2) DEFAULT NULL COMMENT '余额',
  `level` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '管理员' COMMENT '权限等级',
  `fileIds` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '商品图片id，用英文逗号隔开',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `uk_name` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='管理员信息表';

-- ----------------------------
-- Records of admin_info
-- ----------------------------
INSERT INTO `admin_info` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '何升高', '男', '222', '2020-11-02 00:04:25', '18843232356', '上海市ddff33', '111fsfsggsss11', 'aa@163.com', '342425199001116372', '2100.00', '管理员', '[56]');

-- ----------------------------
-- Table structure for `bankuai_info`
-- ----------------------------
DROP TABLE IF EXISTS `bankuai_info`;
CREATE TABLE `bankuai_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bankuaimingcheng` varchar(50) DEFAULT NULL,
  `jianjie` varchar(500) DEFAULT NULL,
  `banzhu` varchar(50) DEFAULT NULL,
  `yiyoutieshu` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT '是',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of bankuai_info
-- ----------------------------
INSERT INTO `bankuai_info` VALUES ('2', 'D版块', '暂无', '胩', '0', '是', '2022-04-03 11:08:49');
INSERT INTO `bankuai_info` VALUES ('3', 'J版块', 'ok', '有', '0', '是', '2022-04-03 11:08:49');
INSERT INTO `bankuai_info` VALUES ('4', 'K版块', '暂无', 'gewgew', '0', '是', '2022-04-03 11:08:49');
INSERT INTO `bankuai_info` VALUES ('5', 'F版块', '没问题', 'heh', '0', '是', '2022-04-03 11:08:49');
INSERT INTO `bankuai_info` VALUES ('6', 'N版块', '无', 'rh', '0', '是', '2022-04-03 11:08:49');
INSERT INTO `bankuai_info` VALUES ('10', '体育交流版块', '体育交流版块', '陈先生', '0', '是', '2022-04-04 03:42:01');

-- ----------------------------
-- Table structure for `bisaixinxi_info`
-- ----------------------------
DROP TABLE IF EXISTS `bisaixinxi_info`;
CREATE TABLE `bisaixinxi_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cansaibianhao` varchar(50) DEFAULT NULL,
  `baomingbianhao` varchar(50) DEFAULT NULL,
  `saishimingcheng` varchar(50) DEFAULT NULL,
  `saishididian` varchar(50) DEFAULT NULL,
  `yonghuming` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `shenfenzheng` varchar(50) DEFAULT NULL,
  `shoujihao` varchar(50) DEFAULT NULL,
  `shifouhuomingci` varchar(50) DEFAULT NULL,
  `bisaichengji` varchar(50) DEFAULT NULL,
  `tianjiaren` varchar(50) DEFAULT NULL,
  `beizhu` varchar(500) DEFAULT NULL,
  `status` varchar(10) DEFAULT '是',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of bisaixinxi_info
-- ----------------------------
INSERT INTO `bisaixinxi_info` VALUES ('8', '11355060302', '77622213634', '省乒乓球联赛', 'AA体育场', '008', '王宝顺', '男', '330324198952165487', '13587835380', '铜牌', '闯入半决赛', '赵娟', '很好再接再厉。', '是', '2022-04-04 03:45:48');

-- ----------------------------
-- Table structure for `collect_info`
-- ----------------------------
DROP TABLE IF EXISTS `collect_info`;
CREATE TABLE `collect_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `shoucangmingcheng` varchar(255) CHARACTER SET utf8mb4 DEFAULT NULL,
  `userId` bigint(20) DEFAULT NULL,
  `shangpinxinxiid` bigint(20) DEFAULT NULL,
  `level` varchar(10) CHARACTER SET utf8mb4 DEFAULT NULL,
  `biao` varchar(20) DEFAULT NULL,
  `addtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of collect_info
-- ----------------------------
INSERT INTO `collect_info` VALUES ('9', '经典赛', '9', '2', '注册用户', 'jingsaixinxi', '2022-04-04 02:21:34');
INSERT INTO `collect_info` VALUES ('10', '本次赛事必须佩戴口罩', '14', '37', '注册用户', 'xinwentongzhi', '2022-04-04 03:43:44');

-- ----------------------------
-- Table structure for `comment_info`
-- ----------------------------
DROP TABLE IF EXISTS `comment_info`;
CREATE TABLE `comment_info` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `content` varchar(175) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '评价内容',
  `shujuid` bigint(10) NOT NULL DEFAULT '0' COMMENT '所属商品',
  `userId` bigint(10) NOT NULL DEFAULT '0' COMMENT '评价人id',
  `level` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户等级',
  `createTime` varchar(175) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '创建时间',
  `biao` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='商品评价表';

-- ----------------------------
-- Records of comment_info
-- ----------------------------

-- ----------------------------
-- Table structure for `jingsaixinxi_info`
-- ----------------------------
DROP TABLE IF EXISTS `jingsaixinxi_info`;
CREATE TABLE `jingsaixinxi_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `saishimingcheng` varchar(50) DEFAULT NULL,
  `tupian` varchar(50) DEFAULT NULL,
  `saishididian` varchar(50) DEFAULT NULL,
  `baomingfei` varchar(50) DEFAULT NULL,
  `saishishijian` date DEFAULT NULL,
  `zhuangtai` varchar(50) DEFAULT NULL,
  `cansaiyaoqiu` varchar(50) DEFAULT NULL,
  `saishijianjie` varchar(500) DEFAULT NULL,
  `status` varchar(10) DEFAULT '是',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of jingsaixinxi_info
-- ----------------------------
INSERT INTO `jingsaixinxi_info` VALUES ('2', '经典赛', '[208]', '泰兴路22号', '200', '2022-04-30', '', '穿运动装', 'abc', '是', '2022-04-04 01:13:07');
INSERT INTO `jingsaixinxi_info` VALUES ('3', '公开赛', '', '方城丽圆11幢201室', '200', '2022-03-07', '', '穿运动装', '没问题', '是', '2022-04-04 01:13:07');
INSERT INTO `jingsaixinxi_info` VALUES ('4', ' 国际赛', '', '龙翔路11号', '200', '2022-03-22', '', '穿运动装', 'abc', '是', '2022-04-04 01:13:07');
INSERT INTO `jingsaixinxi_info` VALUES ('5', '大奖赛', '', '东城路99号', '300', '2022-03-07', '', '穿运动装', 'abc', '是', '2022-04-04 01:13:07');
INSERT INTO `jingsaixinxi_info` VALUES ('7', '大师赛', '', '开明路22号', '300', '2022-03-07', '', '穿运动装', 'abc', '是', '2022-04-04 01:13:07');
INSERT INTO `jingsaixinxi_info` VALUES ('8', '职业联赛', '', '复兴街27号', '300', '2022-03-22', '', '穿运动装', '暂无', '是', '2022-04-04 01:13:07');
INSERT INTO `jingsaixinxi_info` VALUES ('9', '锦标赛', '', '河滨东路139号', '300', '2022-04-29', '', '穿运动装', '没问题', '是', '2022-04-04 01:13:07');
INSERT INTO `jingsaixinxi_info` VALUES ('10', '省乒乓球联赛', '[212]', 'AA体育场', '300', '2022-04-08', null, '穿运动装', '省乒乓球联赛省乒乓球联赛省乒乓球联赛省乒乓球联赛', '是', '2022-04-04 03:40:43');

-- ----------------------------
-- Table structure for `liuyanban_info`
-- ----------------------------
DROP TABLE IF EXISTS `liuyanban_info`;
CREATE TABLE `liuyanban_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuming` varchar(50) DEFAULT NULL,
  `cheng` varchar(50) DEFAULT NULL,
  `touxiang` varchar(50) DEFAULT NULL,
  `biaoti` varchar(50) DEFAULT NULL,
  `neirong` varchar(500) DEFAULT NULL,
  `huifu` varchar(500) DEFAULT NULL,
  `status` varchar(10) DEFAULT '是',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of liuyanban_info
-- ----------------------------
INSERT INTO `liuyanban_info` VALUES ('2', '022', 'ewg', '1', '在温卖水果的熊先生：试验五年种出了两棵榴莲树', 'few', 'weggfff', '是', '2021-12-25 10:23:51');
INSERT INTO `liuyanban_info` VALUES ('3', '021', 'ew', '2', '在温卖水果的熊先生：试验五年种出了两棵榴莲树', 'htr', 'rjrgggg', '是', '2021-12-25 10:23:51');
INSERT INTO `liuyanban_info` VALUES ('4', '003', 'reh', '3', '第11届《温州年鉴》“菱华奖”摄影赛获奖名单', 'jtrj', 'vdsvsdvsd', '是', '2021-12-25 10:23:51');
INSERT INTO `liuyanban_info` VALUES ('5', '009', 'gw', '4', '浙江绍兴出现罕见强对流天气', 'rjrt', 'jtrj', '是', '2021-12-25 10:23:51');
INSERT INTO `liuyanban_info` VALUES ('6', '020', 'g', '5', '在温卖水果的熊先生：试验五年种出了两棵榴莲树', 'trhrt', 'hrthrt', '是', '2021-12-25 10:23:51');
INSERT INTO `liuyanban_info` VALUES ('7', '023', 'htrh', '3', '2011年温州经济技术开发区事业单位选调工作人员公告', 'h', 'herher', '是', '2021-12-25 10:23:51');
INSERT INTO `liuyanban_info` VALUES ('9', '001', 'htr', '3', '北京赏秋好去处 地坛钓鱼台看银杏', 'er', 'ehehe', '是', '2021-12-25 10:23:51');
INSERT INTO `liuyanban_info` VALUES ('10', 'hsg', 'wegweg', '4', 'd', 'ww', null, '是', '2021-12-25 10:38:07');
INSERT INTO `liuyanban_info` VALUES ('11', 'hsg', 'fgwegw', '2', 'gwegw', 'gwgwe', null, '是', '2021-12-25 10:43:26');
INSERT INTO `liuyanban_info` VALUES ('12', 'hsg', 'fgwegw', '3', 'gwegw', 'gwgwe', null, '是', '2021-12-25 10:43:32');
INSERT INTO `liuyanban_info` VALUES ('13', 'hsg', 'dd', '1', null, null, null, '是', '2021-12-25 10:46:09');
INSERT INTO `liuyanban_info` VALUES ('14', 'hsg', 'geew', '1', 'eww', 'feefw', null, '是', '2021-12-25 13:36:41');

-- ----------------------------
-- Table structure for `nx_system_file_info`
-- ----------------------------
DROP TABLE IF EXISTS `nx_system_file_info`;
CREATE TABLE `nx_system_file_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `originName` varchar(175) CHARACTER SET gb2312 DEFAULT NULL COMMENT '原始文件名',
  `fileName` varchar(175) CHARACTER SET gb2312 DEFAULT NULL COMMENT '存储文件名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='文件信息表';

-- ----------------------------
-- Records of nx_system_file_info
-- ----------------------------
INSERT INTO `nx_system_file_info` VALUES ('188', 'yhtx1.jpg', 'yhtx1.jpg');
INSERT INTO `nx_system_file_info` VALUES ('189', 'yhtx2.jpg', 'yhtx2.jpg');
INSERT INTO `nx_system_file_info` VALUES ('190', 'yhtx3.jpg', 'yhtx3.jpg');
INSERT INTO `nx_system_file_info` VALUES ('191', 'yhtx4.jpg', 'yhtx4.jpg');
INSERT INTO `nx_system_file_info` VALUES ('192', 'yhtx5.jpg', 'yhtx5.jpg');
INSERT INTO `nx_system_file_info` VALUES ('193', 'yhtx6.jpg', 'yhtx6.jpg');
INSERT INTO `nx_system_file_info` VALUES ('194', 'yhtx7.jpg', 'yhtx7.jpg');
INSERT INTO `nx_system_file_info` VALUES ('195', 'yhtx8.jpg', 'yhtx8.jpg');
INSERT INTO `nx_system_file_info` VALUES ('196', 'jingsaixinxi1.jpg', 'jingsaixinxi1.jpg');
INSERT INTO `nx_system_file_info` VALUES ('197', 'jingsaixinxi2.jpg', 'jingsaixinxi2.jpg');
INSERT INTO `nx_system_file_info` VALUES ('198', 'jingsaixinxi3.jpg', 'jingsaixinxi3.jpg');
INSERT INTO `nx_system_file_info` VALUES ('199', 'jingsaixinxi4.jpg', 'jingsaixinxi4.jpg');
INSERT INTO `nx_system_file_info` VALUES ('200', 'jingsaixinxi5.jpg', 'jingsaixinxi5.jpg');
INSERT INTO `nx_system_file_info` VALUES ('201', 'jingsaixinxi6.jpg', 'jingsaixinxi6.jpg');
INSERT INTO `nx_system_file_info` VALUES ('202', 'jingsaixinxi7.jpg', 'jingsaixinxi7.jpg');
INSERT INTO `nx_system_file_info` VALUES ('203', 'jingsaixinxi8.jpg', 'jingsaixinxi8.jpg');
INSERT INTO `nx_system_file_info` VALUES ('204', 'QQ截图20210424034455.jpg', 'QQ截图202104240344551649008442134.jpg');
INSERT INTO `nx_system_file_info` VALUES ('205', 'QQ截图20210424034455.jpg', 'QQ截图202104240344551649008464181.jpg');
INSERT INTO `nx_system_file_info` VALUES ('206', 'QQ截图20210424034518.jpg', 'QQ截图202104240345181649008474812.jpg');
INSERT INTO `nx_system_file_info` VALUES ('207', 'QQ截图20210424034455.jpg', 'QQ截图202104240344551649008524062.jpg');
INSERT INTO `nx_system_file_info` VALUES ('208', 'QQ截图20210424034455.jpg', 'QQ截图202104240344551649008549873.jpg');
INSERT INTO `nx_system_file_info` VALUES ('209', 'QQ截图20210424034536.jpg', 'QQ截图202104240345361649011355596.jpg');
INSERT INTO `nx_system_file_info` VALUES ('210', '312123.jpg', '3121231649014747987.jpg');
INSERT INTO `nx_system_file_info` VALUES ('211', '44.jpg', '441649014789873.jpg');
INSERT INTO `nx_system_file_info` VALUES ('212', 'QQ截图20210424034609.jpg', 'QQ截图202104240346091649014823801.jpg');
INSERT INTO `nx_system_file_info` VALUES ('213', 'timg (3).jpg', 'timg (3)1649074324220.jpg');

-- ----------------------------
-- Table structure for `richtext_info`
-- ----------------------------
DROP TABLE IF EXISTS `richtext_info`;
CREATE TABLE `richtext_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(175) CHARACTER SET gb2312 DEFAULT NULL COMMENT '名称',
  `content` longtext CHARACTER SET utf8 COMMENT '公告内容',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='用户上传信息表';

-- ----------------------------
-- Records of richtext_info
-- ----------------------------

-- ----------------------------
-- Table structure for `saishibaoming_info`
-- ----------------------------
DROP TABLE IF EXISTS `saishibaoming_info`;
CREATE TABLE `saishibaoming_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `baomingbianhao` varchar(50) DEFAULT NULL,
  `saishimingcheng` varchar(50) DEFAULT NULL,
  `saishididian` varchar(50) DEFAULT NULL,
  `baomingfei` varchar(50) DEFAULT NULL,
  `yonghuming` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `shenfenzheng` varchar(50) DEFAULT NULL,
  `shoujihao` varchar(50) DEFAULT NULL,
  `zhuangtai` varchar(50) DEFAULT NULL,
  `shenhehuifu` varchar(500) DEFAULT NULL,
  `status` varchar(10) DEFAULT '是',
  `iszf` varchar(10) DEFAULT '否',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of saishibaoming_info
-- ----------------------------
INSERT INTO `saishibaoming_info` VALUES ('2', '01107733000', '经典赛', '泰兴路22号', '200', '008', '王宝顺', '男', '330324198952165487', '13587835380', '审核通过', 'asd 阿萨德阿萨德阿萨德', '是', '是', '2022-04-04 20:07:58');

-- ----------------------------
-- Table structure for `tiezi_info`
-- ----------------------------
DROP TABLE IF EXISTS `tiezi_info`;
CREATE TABLE `tiezi_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `suozaibankuai` varchar(50) DEFAULT NULL,
  `biaoti` varchar(50) DEFAULT NULL,
  `neirong` varchar(500) DEFAULT NULL,
  `leixing` varchar(50) DEFAULT NULL,
  `faburen` varchar(50) DEFAULT NULL,
  `huitieshu` varchar(50) DEFAULT '0',
  `status` varchar(10) DEFAULT '是',
  `dianzan_d` int(11) DEFAULT '0',
  `dianzan_c` int(11) DEFAULT '0',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fid` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=122 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tiezi_info
-- ----------------------------
INSERT INTO `tiezi_info` VALUES ('117', 'D版块', 'as dasd ', 'asd asd 阿萨德阿萨德阿萨德阿萨德阿萨德阿萨德', 'putong', 'admin', '0', '是', '1', '0', '2022-04-04 01:26:45', '0');
INSERT INTO `tiezi_info` VALUES ('118', null, null, '阿萨德阿萨德阿萨德阿萨德阿萨德阿萨德阿萨德阿萨德', null, null, '0', '是', '0', '0', '2022-04-04 01:27:03', '117');
INSERT INTO `tiezi_info` VALUES ('119', 'D版块', '阿萨斯吗大声道', '阿萨德阿萨德阿萨德阿萨德阿萨德', 'putong', '001', '0', '是', '0', '0', '2022-04-04 02:37:48', '0');
INSERT INTO `tiezi_info` VALUES ('120', '体育交流版块', '大家平时穿什么品牌的运动服', '大家平时穿什么品牌的运动服大家平时穿什么品牌的运动服大家平时穿什么品牌的运动服大家平时穿什么品牌的运动服', 'putong', '008', '0', '是', '1', '0', '2022-04-04 03:43:16', '0');
INSERT INTO `tiezi_info` VALUES ('121', null, null, '阿萨德阿萨德阿萨德阿萨德', null, '008', '0', '是', '0', '0', '2022-04-04 03:43:31', '120');

-- ----------------------------
-- Table structure for `xinwentongzhi_info`
-- ----------------------------
DROP TABLE IF EXISTS `xinwentongzhi_info`;
CREATE TABLE `xinwentongzhi_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `biaoti` varchar(50) DEFAULT NULL,
  `leibie` varchar(50) DEFAULT NULL,
  `neirong` longtext CHARACTER SET utf8,
  `shouyetupian` varchar(50) DEFAULT NULL,
  `zhaiyao` varchar(500) DEFAULT NULL,
  `dianjilv` varchar(50) DEFAULT NULL,
  `faburen` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT '是',
  `dianzan_d` int(11) DEFAULT '0',
  `dianzan_c` int(11) DEFAULT '0',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of xinwentongzhi_info
-- ----------------------------
INSERT INTO `xinwentongzhi_info` VALUES ('36', '最新竞赛公告', '竞赛公告', '<p>最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告</p>', '[209]', '最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告最新竞赛公告', '5', 'admin', '是', '0', '0', '2022-04-04 02:42:36');
INSERT INTO `xinwentongzhi_info` VALUES ('37', '本次赛事必须佩戴口罩', '竞赛公告', '<p>本次赛事必须佩戴口罩本次赛事必须佩戴口罩本次赛事必须佩戴口罩本次赛事必须佩戴口罩本次赛事必须佩戴口罩本次赛事必须佩戴口罩本次赛事必须佩戴口罩本次赛事必须佩戴口罩本次赛事必须佩戴口罩本次赛事必须佩戴口罩本次赛事必须佩戴口罩本次赛事必须佩戴口罩本次赛事必须佩戴口罩本次赛事必须佩戴口罩本次赛事必须佩戴口罩本次赛事必须佩戴口罩本次赛事必须佩戴口罩本次赛事必须佩戴口罩本次赛事必须佩戴口罩</p>', '[211]', '本次赛事必须佩戴口罩', '2', 'admin', '是', '0', '0', '2022-04-04 03:39:52');

-- ----------------------------
-- Table structure for `xitongjianjie_info`
-- ----------------------------
DROP TABLE IF EXISTS `xitongjianjie_info`;
CREATE TABLE `xitongjianjie_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `leibie` varchar(50) DEFAULT NULL,
  `neirong` longtext CHARACTER SET utf8,
  `status` varchar(10) DEFAULT '是',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of xitongjianjie_info
-- ----------------------------
INSERT INTO `xitongjianjie_info` VALUES ('2', '系统简介', '<p>系统简介阿萨德阿萨德阿萨德阿萨德阿萨德阿萨德</p>', '是', '2021-12-24 15:09:13');

-- ----------------------------
-- Table structure for `yonghuxinxi_info`
-- ----------------------------
DROP TABLE IF EXISTS `yonghuxinxi_info`;
CREATE TABLE `yonghuxinxi_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yonghuming` varchar(50) DEFAULT NULL,
  `mima` varchar(50) DEFAULT NULL,
  `xingming` varchar(50) DEFAULT NULL,
  `xingbie` varchar(50) DEFAULT NULL,
  `shouji` varchar(50) DEFAULT NULL,
  `shenfenzheng` varchar(50) DEFAULT NULL,
  `youxiang` varchar(50) DEFAULT NULL,
  `zhaopian` varchar(50) DEFAULT NULL,
  `beizhu` varchar(500) DEFAULT NULL,
  `level` varchar(10) DEFAULT '注册用户',
  `status` varchar(10) DEFAULT '是',
  `addtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of yonghuxinxi_info
-- ----------------------------
INSERT INTO `yonghuxinxi_info` VALUES ('2', '002', 'dc5c7986daef50c1e02ab09b442ee34f', '吴亦凡', '男', '13186835555', '330327199010142546', '2352352@qq.com', '[188]', '无', '注册用户', '是', '2021-12-13 13:16:12');
INSERT INTO `yonghuxinxi_info` VALUES ('3', '020', 'dc5c7986daef50c1e02ab09b442ee34f', '李景阳', '女', '6460848', '330327199504059511', '56547474@qq.com', '[189]', 'abc', '注册用户', '是', '2021-12-13 13:16:12');
INSERT INTO `yonghuxinxi_info` VALUES ('4', '016', 'dc5c7986daef50c1e02ab09b442ee34f', '鹿晗', '女', '4231999', '330327198501020300', 'grorti@qq.com', '[190]', 'abc', '注册用户', '是', '2021-12-13 13:16:12');
INSERT INTO `yonghuxinxi_info` VALUES ('5', '021', 'dc5c7986daef50c1e02ab09b442ee34f', '陈小巧', '女', '7856954', '330327198708070789', 'grhtrhk@163.com', '[191]', '没问题', '注册用户', '是', '2021-12-13 13:16:12');
INSERT INTO `yonghuxinxi_info` VALUES ('6', '022', 'dc5c7986daef50c1e02ab09b442ee34f', '梅邹雁', '男', '6498567', '330327198615482633', '43643933@qq.com', '[192]', 'ok', '注册用户', '是', '2021-12-13 13:16:12');
INSERT INTO `yonghuxinxi_info` VALUES ('7', '019', 'dc5c7986daef50c1e02ab09b442ee34f', '陈智一', '女', '8945622', '330327185403060589', 'trodd@yahoo.com', '[193]', 'ok', '注册用户', '是', '2021-12-13 13:16:12');
INSERT INTO `yonghuxinxi_info` VALUES ('8', '009', 'dc5c7986daef50c1e02ab09b442ee34f', '哈登', '男', '6460233', '330327198406150488', '	fegge@163.com', '[194]', '暂无', '注册用户', '是', '2021-12-13 13:16:12');
INSERT INTO `yonghuxinxi_info` VALUES ('9', '001', 'dc5c7986daef50c1e02ab09b442ee34f', '胡歌', '男', '4265325', '330327198811020456', 'regrodd@qq.com', '[195]', 'ok', '注册用户', '是', '2021-12-13 13:16:12');
INSERT INTO `yonghuxinxi_info` VALUES ('14', '008', 'a13ee062eff9d7295bfc800a11f33704', '王宝顺', '男', '13587835380', '330324198952165487', '123@qq.com', '[210]', 'asd 阿萨德阿萨德', '注册用户', '是', '2022-04-04 03:39:11');
