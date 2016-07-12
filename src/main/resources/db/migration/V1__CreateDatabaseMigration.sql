-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.7.13-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para erudio_api_db
-- DROP DATABASE IF EXISTS `erudio_api_db`;
-- CREATE DATABASE IF NOT EXISTS `erudio_api_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `erudio_api_db`;


-- Copiando estrutura para tabela erudio_api_db.account
-- DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_q0uja26qgu1atulenwup9rxyr` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela erudio_api_db.account: ~2 rows (aproximadamente)
-- DELETE FROM `account`;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` (`id`, `email`, `password`, `role`) VALUES
	(1, 'user', '15ded2cb58264425cc2275f8f880d54828833b7026f42ec744515eb4a9f363cfca67fb485a995dce', 'ROLE_USER'),
	(2, 'admin', 'b91b1ca8b46225713f6a5199304e19a8785e9f9f404badbf4cadbce475cf7780f6e1565690b58ede', 'ROLE_ADMIN');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;


-- Copiando estrutura para tabela erudio_api_db.address
-- DROP TABLE IF EXISTS `address`;
CREATE TABLE IF NOT EXISTS `address` (
  `IdAddress` int(11) NOT NULL AUTO_INCREMENT,
  `Complement` varchar(255) DEFAULT NULL,
  `Neighborhood` varchar(80) DEFAULT NULL,
  `Number` int(11) DEFAULT NULL,
  `PostalCode` varchar(9) DEFAULT NULL,
  `StreetName` varchar(80) DEFAULT NULL,
  `IdAddressType` int(11) NOT NULL,
  `IdCity` int(11) NOT NULL,
  `IdPublicAreaType` int(11) NOT NULL,
  `IdState` int(11) NOT NULL,
  PRIMARY KEY (`IdAddress`),
  KEY `AddressAddressType` (`IdAddressType`),
  KEY `AddressCity` (`IdCity`),
  KEY `AddressPublicAreaType` (`IdPublicAreaType`),
  KEY `AddressState` (`IdState`),
  CONSTRAINT `AddressAddressType` FOREIGN KEY (`IdAddressType`) REFERENCES `address_type` (`IdAddressType`),
  CONSTRAINT `AddressCity` FOREIGN KEY (`IdCity`) REFERENCES `city` (`IdCity`),
  CONSTRAINT `AddressPublicAreaType` FOREIGN KEY (`IdPublicAreaType`) REFERENCES `public_area_type` (`IdPublicAreaType`),
  CONSTRAINT `AddressState` FOREIGN KEY (`IdState`) REFERENCES `state` (`IdState`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela erudio_api_db.address: ~7 rows (aproximadamente)
-- DELETE FROM `address`;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` (`IdAddress`, `Complement`, `Neighborhood`, `Number`, `PostalCode`, `StreetName`, `IdAddressType`, `IdCity`, `IdPublicAreaType`, `IdState`) VALUES
	(1, 'AP 733', 'PRESIDENTE JUSCELINO KUBISTCHECK', 36, '35164122', 'VALENCIA', 1, 12, 1, 1),
	(2, 'AP 733', 'PRESIDENTE JUSCELINO KUBISTCHECK', 36, '35164122', 'VALENCIA', 1, 12, 1, 1),
	(3, 'AP 733', 'PRESIDENTE JUSCELINO KUBISTCHECK', 36, '35164122', 'VALENCIA', 1, 12, 1, 1),
	(4, 'AP 733', 'PRESIDENTE JUSCELINO KUBISTCHECK', 36, '35164122', 'VALENCIA', 1, 12, 1, 1),
	(9, 'AP 733', 'PRESIDENTE JUSCELINO KUBISTCHECK', 36, '35164122', 'VALENCIA', 1, 12, 1, 1),
	(10, 'AP 733', 'PRESIDENTE JUSCELINO KUBISTCHECK', 36, '35164122', 'VALENCIA', 1, 12, 1, 1),
	(11, 'AP 733', 'PRESIDENTE JUSCELINO KUBISTCHECK', 36, '35164122', 'VALENCIA', 1, 12, 1, 1);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;


-- Copiando estrutura para tabela erudio_api_db.address_type
-- DROP TABLE IF EXISTS `address_type`;
CREATE TABLE IF NOT EXISTS `address_type` (
  `IdAddressType` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(35) NOT NULL,
  PRIMARY KEY (`IdAddressType`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela erudio_api_db.address_type: ~2 rows (aproximadamente)
-- DELETE FROM `address_type`;
/*!40000 ALTER TABLE `address_type` DISABLE KEYS */;
INSERT INTO `address_type` (`IdAddressType`, `Description`) VALUES
	(1, 'RESIDENCIAL'),
	(2, 'COMERCIAL');
/*!40000 ALTER TABLE `address_type` ENABLE KEYS */;


-- Copiando estrutura para tabela erudio_api_db.city
-- DROP TABLE IF EXISTS `city`;
CREATE TABLE IF NOT EXISTS `city` (
  `IdCity` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(80) NOT NULL,
  `IdUserInsert` int(11) NOT NULL,
  `IdUserUpdate` int(11) DEFAULT NULL,
  `InsertDate` date NOT NULL,
  `UpdatedDate` date NOT NULL,
  `Active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`IdCity`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela erudio_api_db.city: ~19 rows (aproximadamente)
-- DELETE FROM `city`;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` (`IdCity`, `Name`, `IdUserInsert`, `IdUserUpdate`, `InsertDate`, `UpdatedDate`, `Active`) VALUES
	(1, 'UBERLANDIA', 0, NULL, '2016-04-28', '2016-04-28', NULL),
	(2, 'PATOS DE MINAS', 0, NULL, '2016-04-28', '2016-04-28', NULL),
	(3, 'PORTO ALEGRE', 0, NULL, '2016-04-28', '2016-04-28', NULL),
	(4, 'MARINGÁ', 0, NULL, '2016-04-28', '2016-04-28', NULL),
	(5, 'PATROCÍNIO', 0, NULL, '2016-04-28', '2016-04-28', NULL),
	(7, 'PARACATU', 0, NULL, '2016-04-28', '2016-04-28', NULL),
	(8, 'LAGOA FORMOSA', 0, NULL, '2016-04-28', '2016-04-28', NULL),
	(9, 'FORTALEZA', 0, NULL, '2016-04-28', '2016-04-28', NULL),
	(10, 'MACEIÓ', 0, NULL, '2016-04-28', '2016-04-28', NULL),
	(11, 'BRASÍLIA', 0, NULL, '2016-04-28', '2016-04-28', NULL),
	(12, 'IPATINGA', 0, NULL, '2016-04-28', '2016-04-28', NULL);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;


-- Copiando estrutura para tabela erudio_api_db.gender
-- DROP TABLE IF EXISTS `gender`;
CREATE TABLE IF NOT EXISTS `gender` (
  `IdGender` int(11) NOT NULL AUTO_INCREMENT,
  `Description` varchar(9) NOT NULL,
  PRIMARY KEY (`IdGender`),
  UNIQUE KEY `UK_54bhxtxwqa35ojccc3sep5oss` (`Description`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela erudio_api_db.gender: ~2 rows (aproximadamente)
-- DELETE FROM `gender`;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` (`IdGender`, `Description`) VALUES
	(2, 'FEMALE'),
	(1, 'MALE');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;


-- Copiando estrutura para tabela erudio_api_db.greeting
-- DROP TABLE IF EXISTS `greeting`;
CREATE TABLE IF NOT EXISTS `greeting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela erudio_api_db.greeting: ~0 rows (aproximadamente)
-- DELETE FROM `greeting`;
/*!40000 ALTER TABLE `greeting` DISABLE KEYS */;
/*!40000 ALTER TABLE `greeting` ENABLE KEYS */;


-- Copiando estrutura para tabela erudio_api_db.person
-- DROP TABLE IF EXISTS `person`;
CREATE TABLE IF NOT EXISTS `person` (
  `IdPerson` int(11) NOT NULL AUTO_INCREMENT,
  `BirthDayDate` date NOT NULL,
  `CPF` varchar(14) NOT NULL,
  `Email` varchar(80) NOT NULL,
  `InsertDate` datetime NOT NULL,
  `Login` varchar(25) DEFAULT NULL,
  `Name` varchar(80) NOT NULL,
  `Password` varchar(40) DEFAULT NULL,
  `Permission` varchar(36) DEFAULT NULL,
  `Phone` varchar(16) NOT NULL,
  `IdGender` int(11) NOT NULL,
  `IdUserInsert` int(11) NOT NULL,
  `IdUserUpdate` int(11) DEFAULT NULL,
  `UpdatedDate` datetime NOT NULL,
  `Active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`IdPerson`),
  UNIQUE KEY `UK_3v3v5acnykxp2o52fg3a9367a` (`Login`),
  KEY `PersonGender` (`IdGender`),
  CONSTRAINT `PersonGender` FOREIGN KEY (`IdGender`) REFERENCES `gender` (`IdGender`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela erudio_api_db.person: ~16 rows (aproximadamente)
-- DELETE FROM `person`;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`IdPerson`, `BirthDayDate`, `CPF`, `Email`, `InsertDate`, `Login`, `Name`, `Password`, `Permission`, `Phone`, `IdGender`, `IdUserInsert`, `IdUserUpdate`, `UpdatedDate`, `Active`) VALUES
	(1, '1984-12-02', '64421743283', 'a@b.c', '2016-02-06 00:00:00', 'flavio', 'MAURO JOSÉ DE PAULA', '123456', 'ROLE_ADMIN', '12345678901', 1, 0, NULL, '2016-04-27 00:00:00', NULL),
	(7, '1984-02-02', '64421743283', 'a@b.c', '2016-02-02 00:00:00', 'siamo', 'GERALDO SIMAO', 'teste', 'ROLE_ADMIN', '12312121', 1, 0, NULL, '2016-04-27 00:00:00', NULL),
	(14, '1984-02-01', '64421743283', 'a@b.c', '2016-02-01 00:00:00', 'leo', 'LEODAVIO JOSE', 'teste', 'ROLE_ADMIN', '12312121', 1, 0, NULL, '2016-04-27 00:00:00', NULL),
	(15, '1984-02-02', '64421743283', 'a@b.c', '2016-02-02 00:00:00', 'epaminondas', 'EPAMINONDAS MURICI', 'teste', 'ROLE_ADMIN', '12312121', 1, 0, NULL, '2016-04-23 00:00:00', NULL),
	(16, '1969-12-31', '123456789', 'gabiru@g.g', '2016-02-01 00:00:00', 'asdfgh', 'GABIRU DA SILVA', 'asdfgh', 'ASDFGHJ', '123456789', 1, 0, NULL, '2016-04-27 00:00:00', NULL),
	(18, '1969-12-31', '64421743283', 'charlie.blanche@mailinator.com', '1992-02-01 00:00:00', '121212', 'JUSSARA', '123123', '123112', '123213', 2, 0, NULL, '2016-04-27 00:00:00', NULL),
	(20, '1969-12-31', '91202238629', 'oliva.mair@mailinator.com', '1992-02-01 00:00:00', 'gervaz', 'GERVÁZIO MOREIRA', 'gervaz', 'GERVAZ', '23123123', 1, 0, NULL, '2016-04-27 00:00:00', NULL),
	(21, '1969-12-31', '59283656911', 'hildegarde.madsen@mailinator.com', '1992-02-01 00:00:00', 'qweqwe', 'GAMBEROVICH', 'qwewqe', 'EWEQWE', '112321312', 1, 0, NULL, '2016-04-27 00:00:00', NULL),
	(25, '1970-01-01', '57208524505', 'cherri.bronner@mailinator.com', '1992-02-02 00:00:00', 'diego', 'DIEGO SAMUEL', 'diego', 'DIEGO', '12345', 1, 0, NULL, '2016-04-27 00:00:00', NULL);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;


-- Copiando estrutura para tabela erudio_api_db.person_address
-- DROP TABLE IF EXISTS `person_address`;
CREATE TABLE IF NOT EXISTS `person_address` (
  `IdAddress` int(11) NOT NULL,
  `IdPerson` int(11) NOT NULL,
  KEY `PersonPersonAddress` (`IdPerson`),
  KEY `AddressPersonAddress` (`IdAddress`),
  CONSTRAINT `AddressPersonAddress` FOREIGN KEY (`IdAddress`) REFERENCES `address` (`IdAddress`),
  CONSTRAINT `PersonPersonAddress` FOREIGN KEY (`IdPerson`) REFERENCES `person` (`IdPerson`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela erudio_api_db.person_address: ~15 rows (aproximadamente)
-- DELETE FROM `person_address`;
/*!40000 ALTER TABLE `person_address` DISABLE KEYS */;
INSERT INTO `person_address` (`IdAddress`, `IdPerson`) VALUES
	(2, 7),
	(1, 1),
	(4, 15),
	(9, 16),
	(11, 20),
	(4, 21),
	(10, 18),
	(3, 14),
	(2, 25);
/*!40000 ALTER TABLE `person_address` ENABLE KEYS */;


-- Copiando estrutura para tabela erudio_api_db.public_area_type
-- DROP TABLE IF EXISTS `public_area_type`;
CREATE TABLE IF NOT EXISTS `public_area_type` (
  `IdPublicAreaType` int(11) NOT NULL AUTO_INCREMENT,
  `PublicAreaTypeDescription` varchar(40) NOT NULL,
  PRIMARY KEY (`IdPublicAreaType`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela erudio_api_db.public_area_type: ~2 rows (aproximadamente)
-- DELETE FROM `public_area_type`;
/*!40000 ALTER TABLE `public_area_type` DISABLE KEYS */;
INSERT INTO `public_area_type` (`IdPublicAreaType`, `PublicAreaTypeDescription`) VALUES
	(1, 'RUA'),
	(2, 'AVENIDA');
/*!40000 ALTER TABLE `public_area_type` ENABLE KEYS */;


-- Copiando estrutura para tabela erudio_api_db.role
-- DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela erudio_api_db.role: ~3 rows (aproximadamente)
-- DELETE FROM `role`;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`) VALUES
	(1, 'ROLE_USER'),
	(2, 'ROLE_ADMIN'),
	(3, 'ROLE_GUEST');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


-- Copiando estrutura para tabela erudio_api_db.state
-- DROP TABLE IF EXISTS `state`;
CREATE TABLE IF NOT EXISTS `state` (
  `IdState` int(11) NOT NULL AUTO_INCREMENT,
  `StateName` varchar(40) NOT NULL,
  PRIMARY KEY (`IdState`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela erudio_api_db.state: ~0 rows (aproximadamente)
-- DELETE FROM `state`;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` (`IdState`, `StateName`) VALUES
	(1, 'MINAS GERAIS');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;


-- Copiando estrutura para tabela erudio_api_db.user
-- DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_587tdsv8u5cvheyo9i261xhry` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela erudio_api_db.user: ~3 rows (aproximadamente)
-- DELETE FROM `user`;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `login`, `name`, `password`) VALUES
	(1, 'roy', 'Roy', 'spring'),
	(2, 'craig', 'Craig', 'spring'),
	(3, 'greg', 'Greg', 'spring');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Copiando estrutura para tabela erudio_api_db.user_role
-- DROP TABLE IF EXISTS `user_role`;
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_it77eq964jhfqtu54081ebtio` (`role_id`),
  CONSTRAINT `FK_apcc8lxk2xnug8377fatvbn04` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_it77eq964jhfqtu54081ebtio` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Copiando dados para a tabela erudio_api_db.user_role: ~4 rows (aproximadamente)
-- DELETE FROM `user_role`;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
	(1, 1),
	(2, 1),
	(3, 1),
	(1, 2);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
