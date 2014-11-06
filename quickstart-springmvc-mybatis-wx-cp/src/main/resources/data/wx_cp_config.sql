-- MySQL dump 10.13  Distrib 5.6.19, for Win64 (x86_64)
--
-- Host: localhost    Database: test
-- ------------------------------------------------------
-- Server version	5.6.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `wx_cp_config`
--

DROP TABLE IF EXISTS `wx_cp_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wx_cp_config` (
  `corp_id` varchar(255) NOT NULL,
  `agent_id` varchar(255) NOT NULL,
  `corp_secret` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `aes_key` varchar(255) NOT NULL,
  `access_token` varchar(255) DEFAULT NULL,
  `expires_in` int(11) DEFAULT NULL,
  `http_proxy_host` varchar(255) DEFAULT NULL,
  `http_proxy_port` int(11) DEFAULT NULL,
  `http_proxy_username` varchar(255) DEFAULT NULL,
  `http_proxy_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`corp_id`,`agent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wx_cp_config`
--

LOCK TABLES `wx_cp_config` WRITE;
/*!40000 ALTER TABLE `wx_cp_config` DISABLE KEYS */;
INSERT INTO `wx_cp_config` VALUES ('wx9fcb4407341b3293','1','nzSybDuJPnknkdIdqvSQMavIFbAuNK0_t-09wgBpCraLgniWyzTHzNg7p6Mp_axO','5YRCo','qX3nwFcoDKvXuoWYmoMTsHbBixpYerkF6zPAr7YGwlZ','BSGDH7BviMuy8_RR_BWbprvjvRDIMPemnBCKkb3dBXZjXBCqMxgL05U-SFX-23ce',7200,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `wx_cp_config` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-11-06 10:51:05
