INSERT INTO `user` (`ID`, `DESCRIPTION`, `EMAIL`, `FIRSTNAME`, `LASTLOGINDATE`, `LASTNAME`, `LOGINPASSWORD`, `STATUS`, `CONTACT_NUMBER`, `GENDER`, `ROLE`, `USERNAME`, `PICLOCATION`, `MAILBOX_ID`) VALUES
(1, NULL, 'anil.chaurshiya', 'anil', '0000-00-00 00:00:00', 'chaurshiya', 'anil', 1, '6419808234', 'M', 0, 'anil', NULL, 2),
(4, NULL, 'admin@gmail.com', 'admin', NULL, 'admin', 'admin123', 1, '4252563461', 'M', 0, 'admin', '/resource/images/4.png', 2),
(5, NULL, 'user@gmail.com', 'user', NULL, 'user', 'user123', 1, '5437457123', 'F', 1, 'user', NULL, 3);


INSERT INTO `mail_item` (`ID`, `ARRIVALDATE`, `BARCODE`, `DEPARTUREDATE`, `DESCRIPTION`, `TYPE`, `NAME`, `USERID`) VALUES
(1, '2014-12-15 02:05:06', '23232232', '2014-12-18 04:12:16', 'laptop', 1, 'Dell Laptop', 5);

INSERT INTO `mail_box` (`ID`, `CODE`, `NUMBER`, `STATUS`) VALUES
(2, '11-22-11', 76, 'N'),
(3, '343', 75, 'Y'),
(4, '33', 45, 'Y'),
(5, '45', 56, 'Y');
