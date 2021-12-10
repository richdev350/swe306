-- MySQL dump 10.13  Distrib 8.0.25, for macos11 (x86_64)
--
-- Host: 127.0.0.1    Database: RoomReservation
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Reservation`
--

DROP TABLE IF EXISTS `Reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Reservation` (
  `reserve_id` int NOT NULL,
  `user_id` varchar(10) NOT NULL,
  `room_id` varchar(10) NOT NULL,
  `member_num` int NOT NULL,
  `member_list` json NOT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `status` tinyint NOT NULL,
  PRIMARY KEY (`reserve_id`),
  KEY `Reservation_Room__Room_id` (`room_id`),
  KEY `Reservation_User__User_id` (`user_id`),
  CONSTRAINT `Reservation_Room__Room_id` FOREIGN KEY (`room_id`) REFERENCES `Room` (`room_id`),
  CONSTRAINT `Reservation_User__User_id` FOREIGN KEY (`user_id`) REFERENCES `User` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Reservation`
--

LOCK TABLES `Reservation` WRITE;
/*!40000 ALTER TABLE `Reservation` DISABLE KEYS */;
INSERT INTO `Reservation` VALUES (1,'SWE1909484','A5-G11',4,'{\"name\": \"Gao Jiaxiang, Liang Jiazheng, Zhang Jinbiao\"}','2021-12-25 09:00:00','2021-12-25 10:00:00',2),(2,'SWE1909484','B1-201',3,'{\"name\": \"Gao Jiaxiang, Liang Jiazheng\"}','2021-12-01 16:00:00','2021-12-01 17:00:00',1),(3,'SWE1909484','B1-201',3,'{\"name\": \"Shen Yuxuan, Li Zhixuan\"}','2021-12-31 14:00:00','2021-12-31 16:30:00',0);
/*!40000 ALTER TABLE `Reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Room`
--

DROP TABLE IF EXISTS `Room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Room` (
  `room_id` varchar(10) NOT NULL,
  `location` varchar(30) NOT NULL,
  `status` tinyint NOT NULL,
  `room_name` varchar(100) NOT NULL,
  `capacity_min` int DEFAULT NULL,
  `capacity_max` int DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Room`
--

LOCK TABLES `Room` WRITE;
/*!40000 ALTER TABLE `Room` DISABLE KEYS */;
INSERT INTO `Room` VALUES ('A5-G07','A5',1,'Classroom at A5 G07',3,10),('A5-G09','A5',1,'Discussion room at A5 G09',3,10),('A5-G11','A5',1,'Self study room at A5 G11',3,6),('B1-201','B1',1,'Meeting room at B1 201',3,8),('B1-202','B1',1,'Meeting room at B1 202',3,8),('B1-203','B1',0,'Meeting rom at B1 203',3,8),('B1-204','B1',0,'Meeting rom at B1 204',3,8);
/*!40000 ALTER TABLE `Room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `User` (
  `user_id` varchar(10) NOT NULL,
  `firstname` varchar(10) NOT NULL,
  `lastname` varchar(10) NOT NULL,
  `phone_num` int NOT NULL,
  `is_admin` tinyint DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES ('ADMIN001','Admin','1',12345674,1),('ADMIN002','Admin','2',12345675,1),('SEW1909468','Jiaxiang','Gao',12345671,0),('SWE1909480','Jiazheng','Liang',12345672,0),('SWE1909484','Yicen','Liu',12345670,0),('SWE1909503','Jinbiao','Zhang',12345673,0);
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-10 20:21:14
