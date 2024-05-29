CREATE DATABASE IF NOT EXISTS EmployeeManagement;
USE EmployeeManagement;

CREATE TABLE IF NOT EXISTS EMPLOYEE (
  `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `firstName` varchar(30) DEFAULT NULL,
  `lastName` varchar(30) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `position` varchar(30) DEFAULT NULL,
  `salary` double DEFAULT NULL
);

CREATE TABLE IF NOT EXISTS `Credential` (
  `userName` varchar(25) NOT NULL PRIMARY KEY,
  `pass` varchar(25) DEFAULT NULL
);



CREATE TABLE IF NOT EXISTS `Role` (
  `id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `RoleName` varchar(30) DEFAULT NULL UNIQUE KEY
);

CREATE TABLE IF NOT EXISTS `USERS` (
  `userId` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `userName` varchar(25) DEFAULT NULL,
  `Role` int DEFAULT NULL,
  FOREIGN KEY(Role) REFERENCES Role(id)
);

INSERT INTO `Credential` (`userName`, `pass`) VALUES
('guninder', 'pass');

INSERT INTO `Role` (`id`, `RoleName`) VALUES
(1, 'Admin');

INSERT INTO `USERS` (`userName`, `Role`) VALUES
('guninder', 1);



