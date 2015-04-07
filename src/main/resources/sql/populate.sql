
INSERT INTO `MAIL_BOX` (`CODE`, `NUMBER`, `STATUS`) VALUES
('11-22-11', 76, 'N'),
('34-11-23', 75, 'Y'),
('33-34-22', 45, 'Y'),
('45-29-20', 56, 'Y');

INSERT INTO `USER` (`DESCRIPTION`, `EMAIL`, `FIRSTNAME`, `LASTLOGINDATE`, `LASTNAME`, `LOGINPASSWORD`, `STATUS`, `CONTACT_NUMBER`, `GENDER`, `ROLE`, `USERNAME`, `PICLOCATION`, `MAILBOX_ID`) VALUES
(NULL, 'admin@gmail.com', 'admin', NULL, 'admin', 'admin123', 1, '4252563461', 'M', 0, 'admin', '/resource/images/4.png', 2),
(NULL, 'user@gmail.com', 'user', NULL, 'user', 'user123', 1, '5437457123', 'F', 1, 'user', NULL, 3);

INSERT INTO `mail_item` (`ID`, `ARRIVALDATE`, `BARCODE`, `DEPARTUREDATE`, `DESCRIPTION`, `TYPE`, `NAME`, `STATUS`, `USERID`) VALUES
(2, '2014-12-13 00:00:00', '12334345654747877qw', '2014-12-14 00:00:00', 'Jeans Jacket and Tshirt and Pant at affordable price', 0, 'Jeans Jacket and Tshirt and Pant', 1, 1);


