# Backend wiki

## 数据库

### 用户MySQL数据库字段说明

#### mysql建表语句

CREATE TABLE `user` (
  `usrId` int(11) NOT NULL AUTO_INCREMENT,
  `usrWechat` varchar(45) NOT NULL,
  `usrName` varchar(45) NOT NULL,
  `usrTelephone` varchar(45) NOT NULL,
  `usrHeight` float NOT NULL,
  `usrAge` int(11) NOT NULL,
  `homeTown` varchar(45) NOT NULL,
  `currentCity` varchar(45) NOT NULL,
  `usrSex` varchar(45) NOT NULL,
  `usrEducation` varchar(45) NOT NULL,
  `isStudent` varchar(45) NOT NULL,
  `atUniversity` varchar(45) DEFAULT NULL,
  `gradUniversity` varchar(45) DEFAULT NULL,
  `usrHobby` varchar(45) DEFAULT NULL,
  `birthDay` date DEFAULT NULL,
  `usrMotto` text,
  `selfIntro` text,
  `usrPicture` varchar(45) DEFAULT NULL,
  `loverExpect` text,
  `sayWords` text,
  `invitationCards` int(11) DEFAULT '0',
  `calloutNum` int(11) DEFAULT '0',
  PRIMARY KEY (`usrId`),
  UNIQUE KEY `usrId_UNIQUE` (`usrId`),
  UNIQUE KEY `usrWechat_UNIQUE` (`usrWechat`),
  UNIQUE KEY `usrTelephone_UNIQUE` (`usrTelephone`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

#### 字段说明

![1534388259115](C:\Users\xuym3\AppData\Local\Temp\1534388259115.png)

## 后端接口

### 初始爱情首页接口

```
public List<User> getTestUsrInHomepage(String usrSex, String isStudent, String usrEducation)
```

说明：根据年龄，是否在读，学历，返回年龄（20<=usrAge<=27）及相应选项的所有用户



```
public String getUserByName(@PathVariable("usrName") String usrName)
```

说明： 根据昵称，返回所有同名用户

```
public User getTestUsrById(@PathVariable("usrId") Integer usrId)
```

说明：根据用户id， 返回usrId所有信息

