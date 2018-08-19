# Backend wiki

## 数据库

### 用户MySQL数据库字段说明

#### mysql建表语句

#### user
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

#### openid
CREATE TABLE `openid` (
  `keyId` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(45) NOT NULL,
  PRIMARY KEY (`keyId`),
  UNIQUE KEY `keyId` (`keyId`),
  UNIQUE KEY `openid` (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


#### 字段说明

![1534388259115](.\pictures\1534388259115.png)

## 小程序授权登录页面后端逻辑

```
微信登录界面的用户状态有三种：新用户授权、新用户不授权、老用户
```


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

```
public int updateUserInfo(User user)
```

说明：根据用户修改信息，先获取用户id，并根据用户id动态更新用户信息， 更新成功返回1

```
public String insertOneUser(User user)
```

说明： 动态生成id，插入新用户， 插入成功返回 success，否则返回 fail

```
public  String login(@PathVariable("code") String code, @PathVariable("state") String state)
```
说明：登录接口，根据用户code，以及状态state，生成token，进行用户身份认证。


