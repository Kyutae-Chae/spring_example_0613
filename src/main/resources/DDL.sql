CREATE TABLE `account` (
  `idaccount` int NOT NULL AUTO_INCREMENT,
  `userid` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `useremail` varchar(45) NOT NULL,
  PRIMARY KEY (`idaccount`),
  UNIQUE KEY `idaccount_UNIQUE` (`idaccount`),
  UNIQUE KEY `userid_UNIQUE` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


CREATE TABLE `board` (
  `idboard` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `contents` varchar(45) NOT NULL,
  `readcnt` int DEFAULT '0',
  `createuser` varchar(45) NOT NULL,
  PRIMARY KEY (`idboard`),
  UNIQUE KEY `idboard_UNIQUE` (`idboard`),
  KEY `userid_idx` (`createuser`),
  CONSTRAINT `userid` FOREIGN KEY (`createuser`) REFERENCES `account` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci