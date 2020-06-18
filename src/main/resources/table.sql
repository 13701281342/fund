SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_employee
-- ----------------------------
DROP TABLE IF EXISTS `tbl_employee`;
CREATE TABLE `kyl_employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `last_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '名称',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `gender` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '重量',
  `age` int(11) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tbl_employee
-- ----------------------------
INSERT INTO `kyl_employee` VALUES ('1', 'tom', 'tom@qq.com', '1', '18');
INSERT INTO `kyl_employee` VALUES ('2', 'jone', 'jone@qq.com', '1', '18');
INSERT INTO `kyl_employee` VALUES ('3', 'lili', 'lili@qq.com', '1', '18');
INSERT INTO `kyl_employee` VALUES ('5', 'kyl', 'kyl@qq.com', '1', '20');
INSERT INTO `kyl_employee` VALUES ('6', 'kyl', 'kyl@qq.com', '1', '20');
