-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 18, 2014 at 10:07 PM
-- Server version: 5.5.27
-- PHP Version: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `epostman_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `mail_box`
--

CREATE TABLE IF NOT EXISTS `mail_box` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CODE` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `NUMBER` int(11) NOT NULL,
  `STATUS` varchar(1) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

--
-- Dumping data for table `mail_box`
--

INSERT INTO `mail_box` (`ID`, `CODE`, `NUMBER`, `STATUS`) VALUES
(1, '11-22-12', 76, 'Y'),
(2, '34-11-23', 75, 'Y'),
(3, '33-34-22', 45, 'Y'),
(4, '45-29-20', 56, 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `mail_item`
--

CREATE TABLE IF NOT EXISTS `mail_item` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ARRIVALDATE` datetime NOT NULL,
  `BARCODE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DEPARTUREDATE` datetime NOT NULL,
  `DESCRIPTION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TYPE` int(11) DEFAULT NULL,
  `NAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  `USERID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK9576289BF6895D3A` (`USERID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=10 ;

--
-- Dumping data for table `mail_item`
--

INSERT INTO `mail_item` (`ID`, `ARRIVALDATE`, `BARCODE`, `DEPARTUREDATE`, `DESCRIPTION`, `TYPE`, `NAME`, `STATUS`, `USERID`) VALUES
(2, '2014-12-13 00:00:00', '12334345654747877qw', '2014-12-14 00:00:00', 'Jeans Jacket and Tshirt and Pant at affordable price', 0, 'Jeans Jacket and Tshirt and Pant', 1, 5),
(4, '2014-12-13 00:00:00', '12334345654747877qwdfdgdf', '2014-12-14 00:00:00', 'Jeans Jacket and Tshirt and Pant......', 0, 'Jeans Jacket and Tshirt and Pant......', 1, 3),
(5, '2014-12-13 00:00:00', '12334345654747877qw', '2014-12-14 00:00:00', 'Jeans Jacket and Tshirt and Pant at affordable price', 0, 'Jeans Jacket and Tshirt and Pant', 1, 5),
(6, '2014-12-13 00:00:00', '12334345654747877', '2014-12-14 00:00:00', 'Jeans Jacket and Tshirt and Pant at affordable price', 0, 'Jeans Jacket and Tshirt and Pant', 1, 5),
(7, '2014-12-13 00:00:00', '6227457685697', '2014-12-14 00:00:00', 'Jeans Jacket and Tshirt and Pant at affordable price', 0, 'Jeans Jacket and Tshirt and Pant', 1, 5),
(8, '2014-12-13 00:00:00', '12334345654747877qw', '2014-12-14 00:00:00', 'Jeans Jacket and Tshirt and Pant at affordable price', 0, 'Jeans Jacket and Tshirt and Pantdsgsdagsga', 0, 5),
(9, '2014-12-13 00:00:00', '12334345654747877qw', '2014-12-14 00:00:00', 'Jeans Jacket and Tshirt and Pant at affordable price', 0, 'Jeans Jacket and Tshirt and Pant....', 0, 4);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CONTACT_NUMBER` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `DESCRIPTION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `EMAIL` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `FIRSTNAME` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `GENDER` char(1) COLLATE utf8_unicode_ci NOT NULL,
  `LASTLOGINDATE` datetime DEFAULT NULL,
  `LASTNAME` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `LOGINPASSWORD` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `PICLOCATION` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ROLE` int(11) NOT NULL,
  `STATUS` int(11) NOT NULL,
  `USERNAME` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `MAILBOX_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `EMAIL` (`EMAIL`),
  UNIQUE KEY `USERNAME` (`USERNAME`),
  KEY `FK27E3CBAC035D31` (`MAILBOX_ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=6 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`ID`, `CONTACT_NUMBER`, `DESCRIPTION`, `EMAIL`, `FIRSTNAME`, `GENDER`, `LASTLOGINDATE`, `LASTNAME`, `LOGINPASSWORD`, `PICLOCATION`, `ROLE`, `STATUS`, `USERNAME`, `MAILBOX_ID`) VALUES
(1, '4252563461', 'Hello I am Admin', 'admin@gmail.com', 'Super', 'M', NULL, 'Admin', 'admin123', '/resource/images/1.png', 0, 1, 'admin', 2),
(2, '5437457123', '', 'user@gmail.com', 'Simple', 'M', NULL, 'User', 'user123', NULL, 1, 1, 'user', 4),
(3, '3525346356', 'I am Aniel', 'anil.chaurshiya@gmail.com', 'Anil', 'M', NULL, 'Chaurshiya', 'anil123', '/resource/images/3.png', 1, 1, 'anil', 4),
(4, '1234567890', '', 'syraz37@gmail.com', 'Suraj', 'M', NULL, 'Shrestha', 'suraj123', '/resource/images/4.png', 1, 1, 'suraj', 4),
(5, '1232456789', '', 'risal.deep@gmail.com', 'Deep', 'M', NULL, 'Risal', 'deep123', NULL, 1, 1, 'drisal', 4);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mail_item`
--
ALTER TABLE `mail_item`
  ADD CONSTRAINT `FK9576289BF6895D3A` FOREIGN KEY (`USERID`) REFERENCES `user` (`ID`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK27E3CBAC035D31` FOREIGN KEY (`MAILBOX_ID`) REFERENCES `mail_box` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
