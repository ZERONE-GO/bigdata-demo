CREATE DATABASE IF NOT EXISTS BigData;

USE BigData;
CREATE TABLE IF NOT EXISTS USER(
    `id` int NOT NULL AUTO_INCREMENT,
    `userName` varchar(32) NOT NULL,
    `password` varchar(50) NOT NULL,
    `nickName` varchar(32) NOT NULL,
    PRIMARY KEY(`id`)
) ENGINE=InnoDB auto_increment=5 DEFAULT CHARSET=utf8;

-- init data
INSERT INTO USER(`userName`, `password`, `nickName`) values ('TEST001', '123456', 'NT001');
INSERT INTO USER(`userName`, `password`, `nickName`) values ('TEST002', '123456', 'NT002');