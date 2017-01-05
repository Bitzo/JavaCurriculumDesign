
DROP TABLE IF EXISTS `courseinfo`;
CREATE TABLE `courseinfo` (
  `CNO` int(11) NOT NULL AUTO_INCREMENT,
  `CName` varchar(50) NOT NULL,
  `CTeacher` int(10) NOT NULL,
  `grade` varchar(50) NOT NULL,
  PRIMARY KEY (`CNO`),
  KEY `FK_Cteacher` (`CTeacher`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;


INSERT INTO `courseinfo` VALUES ('1', 'JAVA����', '10002', '���');
INSERT INTO `courseinfo` VALUES ('2', '���ݽṹ���㷨����', '10006', '���');
INSERT INTO `courseinfo` VALUES ('3', 'c++�������', '10007', '��һ');
INSERT INTO `courseinfo` VALUES ('4', '��������ԭ��', '10013', '����');
INSERT INTO `courseinfo` VALUES ('5', 'C���Գ������', '10014', '��һ');
INSERT INTO `courseinfo` VALUES ('6', '��ѧ�����������', '10015', '��һ');


DROP TABLE IF EXISTS `scoreinfo`;
CREATE TABLE `scoreinfo` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CNO` int(11) NOT NULL,
  `SNO` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_SNO` (`SNO`),
  KEY `FK_CNO` (`CNO`)
) ENGINE=MyISAM AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;


INSERT INTO `scoreinfo` VALUES ('1', '1', '10004', '90');
INSERT INTO `scoreinfo` VALUES ('2', '1', '10003', '99');
INSERT INTO `scoreinfo` VALUES ('3', '1', '10001', '80');
INSERT INTO `scoreinfo` VALUES ('4', '2', '10001', '90');
INSERT INTO `scoreinfo` VALUES ('5', '2', '10003', '80');
INSERT INTO `scoreinfo` VALUES ('6', '2', '10005', '99');
INSERT INTO `scoreinfo` VALUES ('7', '2', '10004', '80');
INSERT INTO `scoreinfo` VALUES ('10', '1', '10012', '85');
INSERT INTO `scoreinfo` VALUES ('11', '1', '10003', '90');
INSERT INTO `scoreinfo` VALUES ('12', '1', '10005', '90');
INSERT INTO `scoreinfo` VALUES ('13', '1', '10010', '89');
INSERT INTO `scoreinfo` VALUES ('14', '1', '10008', '90');
INSERT INTO `scoreinfo` VALUES ('16', '3', '10001', '90');
INSERT INTO `scoreinfo` VALUES ('17', '3', '10003', '90');
INSERT INTO `scoreinfo` VALUES ('18', '3', '10005', '89');
INSERT INTO `scoreinfo` VALUES ('19', '3', '10005', '89');
INSERT INTO `scoreinfo` VALUES ('20', '3', '10009', '87');
INSERT INTO `scoreinfo` VALUES ('21', '3', '10011', '97');
INSERT INTO `scoreinfo` VALUES ('22', '4', '10001', '95');
INSERT INTO `scoreinfo` VALUES ('23', '4', '10003', '89');
INSERT INTO `scoreinfo` VALUES ('24', '4', '10008', '89');
INSERT INTO `scoreinfo` VALUES ('25', '4', '10010', '87');
INSERT INTO `scoreinfo` VALUES ('26', '4', '10009', '99');
INSERT INTO `scoreinfo` VALUES ('27', '4', '10012', '78');
INSERT INTO `scoreinfo` VALUES ('28', '5', '10001', '98');
INSERT INTO `scoreinfo` VALUES ('29', '5', '10003', '89');
INSERT INTO `scoreinfo` VALUES ('30', '5', '10005', '78');
INSERT INTO `scoreinfo` VALUES ('31', '5', '10010', '78');
INSERT INTO `scoreinfo` VALUES ('32', '5', '10009', '97');
INSERT INTO `scoreinfo` VALUES ('33', '5', '10011', '78');
INSERT INTO `scoreinfo` VALUES ('34', '6', '10003', '89');
INSERT INTO `scoreinfo` VALUES ('35', '6', '10012', '68');
INSERT INTO `scoreinfo` VALUES ('36', '6', '10001', '86');
INSERT INTO `scoreinfo` VALUES ('37', '6', '10005', '78');
INSERT INTO `scoreinfo` VALUES ('38', '6', '10011', '75');
INSERT INTO `scoreinfo` VALUES ('39', '6', '10009', '99');


DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `AccountID` int(10) NOT NULL AUTO_INCREMENT,
  `UserName` varchar(5) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `age` int(2) NOT NULL,
  `gender` varchar(2) NOT NULL DEFAULT '',
  `address` varchar(100) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `grade` varchar(10) NOT NULL,
  `type` varchar(5) NOT NULL,
  PRIMARY KEY (`AccountID`)
) ENGINE=MyISAM AUTO_INCREMENT=10026 DEFAULT CHARSET=utf8;


INSERT INTO `userinfo` VALUES ('10001', 'ʯ����', '123456', '21', '��', '�����Ͼ�', '15651837665', '���', 'ѧ��');
INSERT INTO `userinfo` VALUES ('10002', '������', '123123', '30', '��', '�����Ͼ�', '15624167517', '��ְ��', '��ʦ');
INSERT INTO `userinfo` VALUES ('10003', '�����', '1231234', '21', '��', '��������', '13260906020', '���', 'ѧ��');
INSERT INTO `userinfo` VALUES ('10004', '���Ф', '1231231', '21', '��', '���ջ���', '13212347128', '���', 'ѧ��');
INSERT INTO `userinfo` VALUES ('10005', 'ɣ����', '3213122', '21', '��', '������ͨ', '12312314412', '���', 'ѧ��');
INSERT INTO `userinfo` VALUES ('10006', '���ˮ', '123123', '40', '��', '�����Ͼ�', '12324124446', '��ְ��', '��ʦ');
INSERT INTO `userinfo` VALUES ('10007', '��չ', '123123', '35', '��', '�����Ͼ�', '14231741457', '��ְ��', '��ʦ');
INSERT INTO `userinfo` VALUES ('10008', '������', '123132', '20', '��', '��������', '13212461241', '���', 'ѧ��');
INSERT INTO `userinfo` VALUES ('10009', 'ʯ��', '3213121', '20', '��', '������ͨ', '13142412468', '���', 'ѧ��');
INSERT INTO `userinfo` VALUES ('10010', '���ΰ', '1234121', '20', '��', '�����γ�', '13213648126', '���', 'ѧ��');
INSERT INTO `userinfo` VALUES ('10012', '��_��', '112321', '20', '��', '��������', '13133141412', '���', 'ѧ��');
INSERT INTO `userinfo` VALUES ('10013', '����־', '123123', '35', '��', '�����Ͼ�', '16712354612', '��ְ��', '��ʦ');
INSERT INTO `userinfo` VALUES ('10014', '����', '123123', '35', 'Ů', '�����Ͼ�', '13276471567', '��ְ��', '��ʦ');
INSERT INTO `userinfo` VALUES ('10015', '������', '123123', '35', 'Ů', '�����Ͼ�', '13261724612', '��ְ��', '��ʦ');
INSERT INTO `userinfo` VALUES ('10016', 'admin', '123123', '20', '��', '�����Ͼ�', '13262842191', '��', '����Ա');
INSERT INTO `userinfo` VALUES ('10017', '����', '123456', '21', '��', null, null, '���', 'ѧ��');
INSERT INTO `userinfo` VALUES ('10024', '����', '123456', '23', '��', null, null, '���', 'ѧ��');
INSERT INTO `userinfo` VALUES ('10023', '����', '123456', '34', 'Ů', null, null, '��ְ��', '��ʦ');


DROP VIEW IF EXISTS `v_stu`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `v_stu` AS select AccountID,UserName,age,gender,grade
from userinfo 
where type = 'ѧ��' ;


DROP VIEW IF EXISTS `v_stuscore`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `v_stuscore` AS select v_Stu.SNO,SName,TNO,TName,courseinfo.CNO,courseinfo.CName,score
FROM v_Stu,v_Tea,courseinfo,scoreinfo
WHERE v_Stu.SNO=scoreinfo.SNO and courseinfo.CNO=scoreinfo.CNO and courseinfo.CTeacher=v_Tea.TNO ;


DROP VIEW IF EXISTS `v_tea`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `v_tea` AS select AccountID,UserName,age,gender,grade
from userinfo 
where type = '��ʦ' ;
