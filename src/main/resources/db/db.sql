---- DATABASE FOR SHARDING DEMO

-- create databases
CREATE DATABASE IF NOT EXISTS sharding-01 DEFAULT CHARACTER SET=UTF8 COLLATE UTF8_GENERAL_CI;
CREATE DATABASE IF NOT EXISTS sharding-02 DEFAULT CHARACTER SET=UTF8 COLLATE UTF8_GENERAL_CI;

-- create tables for sharding-01
USE sharding-01;

CREATE TABLE `sys_user1` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_user2` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_user3` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- create tables for sharding-02
USE sharding-02;

CREATE TABLE `sys_user1` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_user2` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sys_user3` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL COMMENT '用户名',
  PRIMARY KEY (`id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
