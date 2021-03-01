/*
MySQL Data Transfer
Source Host: localhost
Source Database: db_shop
Target Host: localhost
Target Database: db_shop
Date: 5/11/2019 6:46:37 PM
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for m_block
-- ----------------------------
DROP TABLE IF EXISTS `m_block`;
CREATE TABLE `m_block` (
  `timestamp` timestamp NULL default NULL,
  `hash` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for m_category
-- ----------------------------
DROP TABLE IF EXISTS `m_category`;
CREATE TABLE `m_category` (
  `c_id` int(4) NOT NULL auto_increment,
  `c_name` varchar(15) NOT NULL,
  `bar_prev_code` varchar(6) NOT NULL default '',
  PRIMARY KEY  (`c_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for m_cust_login
-- ----------------------------
DROP TABLE IF EXISTS `m_cust_login`;
CREATE TABLE `m_cust_login` (
  `email` varchar(30) NOT NULL,
  `pass` varchar(15) NOT NULL,
  PRIMARY KEY  (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for m_customer
-- ----------------------------
DROP TABLE IF EXISTS `m_customer`;
CREATE TABLE `m_customer` (
  `id` int(4) NOT NULL auto_increment,
  `name` varchar(50) NOT NULL,
  `email` varchar(40) NOT NULL,
  `dob` date NOT NULL,
  `gender` char(6) NOT NULL,
  `mobile` varchar(10) NOT NULL,
  `pass` varchar(10) NOT NULL,
  PRIMARY KEY  (`id`,`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for m_hash
-- ----------------------------
DROP TABLE IF EXISTS `m_hash`;
CREATE TABLE `m_hash` (
  `hash` varchar(256) NOT NULL,
  PRIMARY KEY  (`hash`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for m_product
-- ----------------------------
DROP TABLE IF EXISTS `m_product`;
CREATE TABLE `m_product` (
  `p_id` varchar(6) NOT NULL,
  `p_name` varchar(15) NOT NULL,
  `p_catid` int(4) NOT NULL,
  `p_cprice` double(10,0) NOT NULL,
  `p_sprice` double(10,0) NOT NULL,
  PRIMARY KEY  (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for m_puser
-- ----------------------------
DROP TABLE IF EXISTS `m_puser`;
CREATE TABLE `m_puser` (
  `id` int(5) unsigned NOT NULL auto_increment,
  `name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `dob` date NOT NULL,
  `gender` char(6) NOT NULL,
  `mobile` varchar(15) NOT NULL,
  `pass` varchar(20) NOT NULL,
  PRIMARY KEY  (`id`,`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for m_puser_login
-- ----------------------------
DROP TABLE IF EXISTS `m_puser_login`;
CREATE TABLE `m_puser_login` (
  `adminid` varchar(30) NOT NULL,
  `pass` varchar(15) NOT NULL,
  PRIMARY KEY  (`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for m_shop
-- ----------------------------
DROP TABLE IF EXISTS `m_shop`;
CREATE TABLE `m_shop` (
  `shop_id` int(5) unsigned NOT NULL auto_increment,
  `wallet_id` varchar(10) NOT NULL,
  `balance` varchar(20) NOT NULL,
  PRIMARY KEY  (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for m_transaction
-- ----------------------------
DROP TABLE IF EXISTS `m_transaction`;
CREATE TABLE `m_transaction` (
  `t_id` varchar(255) NOT NULL,
  `t_amount` double(10,0) NOT NULL,
  `t_timestamp` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  `t_status` char(10) NOT NULL,
  PRIMARY KEY  (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Table structure for m_wallet
-- ----------------------------
DROP TABLE IF EXISTS `m_wallet`;
CREATE TABLE `m_wallet` (
  `wallet` varchar(10) NOT NULL,
  `uid` varchar(30) NOT NULL,
  `path` varchar(100) NOT NULL,
  PRIMARY KEY  (`wallet`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `m_block` VALUES ('2019-05-10 02:39:52', '314337396');
INSERT INTO `m_category` VALUES ('1', 'Food', 'FOD001');
INSERT INTO `m_category` VALUES ('2', 'Grocery', 'GRY000');
INSERT INTO `m_category` VALUES ('3', 'Beverages', 'BVG000');
INSERT INTO `m_category` VALUES ('4', 'Vegetables', 'VEG001');
INSERT INTO `m_category` VALUES ('5', 'Poultry', 'POU000');
INSERT INTO `m_category` VALUES ('6', 'Electronics', 'ELE000');
INSERT INTO `m_category` VALUES ('7', 'Beauty', 'BEU000');
INSERT INTO `m_cust_login` VALUES ('harsh@gmail.com', '123456');
INSERT INTO `m_customer` VALUES ('1', 'Harsh', 'harsh@gmail.com', '1996-10-21', 'male', '8927456989', '123456');
INSERT INTO `m_product` VALUES ('FOD001', 'Chips', '1', '18', '20');
INSERT INTO `m_product` VALUES ('VEG001', 'Gobhi', '4', '18', '20');
INSERT INTO `m_puser_login` VALUES ('admin@gmail.com', '123456');
INSERT INTO `m_puser_login` VALUES ('shop@gmail.com', '123456');
INSERT INTO `m_transaction` VALUES ('0c1975bef5422559807df05a942086193e9e46906f27ab9cde53246494d39546', '30', '2019-05-10 02:01:57', 'false');
INSERT INTO `m_transaction` VALUES ('0ea1ec7529ec89a90592cce1abb2db834280dbac8f549c538e5737ded9979f52', '10', '2019-05-10 02:03:55', 'false');
INSERT INTO `m_transaction` VALUES ('1646fce2396910636eac22ceb7869fa2bc33bbc5c33711d782acd07feeb35bdd', '30', '2019-04-12 23:39:04', 'true');
INSERT INTO `m_transaction` VALUES ('21154c32c36d7eb10af4546224c71888793643d73fc29395bb1abfca59cdb67b', '30', '2019-05-10 02:00:12', 'false');
INSERT INTO `m_transaction` VALUES ('380452efcbb746b683b26ea2a63b615ebcd2fcc3f93d888f358d4027bcaa0d6f', '10', '2019-05-10 02:00:13', 'false');
INSERT INTO `m_transaction` VALUES ('96f744de4372e5669bc5ad917d5f104fb26a7731efa1d6d4ef90e53f324d8cdc', '10', '2019-04-12 23:40:11', 'true');
INSERT INTO `m_transaction` VALUES ('a5e074a6ff6d13d620a5cdb6f1170676b688f81a5973dd4776096f13ab2e1a45', '30', '2019-05-10 02:03:55', 'false');
INSERT INTO `m_transaction` VALUES ('b1f24e37e3343103f627d20d101d2b71524c057c7f4e1bfd9e68e716b86a696f', '30', '2019-04-12 22:22:54', 'false');
INSERT INTO `m_transaction` VALUES ('b2c06e7f2032bd10847c6be96c52f38a4ef1e53f1e33563551caebf7c0521e03', '10', '2019-04-12 22:22:55', 'false');
INSERT INTO `m_transaction` VALUES ('d0149a15460416834e91325f99b0449b282ffa26efa20c85e9c96ea0dc02f229', '10', '2019-05-10 02:01:57', 'false');
