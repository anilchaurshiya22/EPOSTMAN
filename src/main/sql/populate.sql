INSERT INTO `mail_box` (`CODE`, `NUMBER`, `STATUS`) VALUES
('11-22-11', 76, 'N'),
('34-11-23', 75, 'Y'),
('33-34-22', 45, 'Y'),
('45-29-20', 56, 'Y');

INSERT INTO `user` (`DESCRIPTION`, `EMAIL`, `FIRSTNAME`, `LASTLOGINDATE`, `LASTNAME`, `LOGINPASSWORD`, `STATUS`, `CONTACT_NUMBER`, `GENDER`, `ROLE`, `USERNAME`, `PICLOCATION`, `MAILBOX_ID`) VALUES
(NULL, 'admin@gmail.com', 'admin', NULL, 'admin', 'admin123', 1, '4252563461', 'M', 0, 'admin', '/resource/images/4.png', 2),
(NULL, 'user@gmail.com', 'user', NULL, 'user', 'user123', 1, '5437457123', 'F', 1, 'user', NULL, 3);


