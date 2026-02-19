-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: citydungeon
-- ------------------------------------------------------
-- Server version	8.0.43

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `calabozo`
--

DROP TABLE IF EXISTS `calabozo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calabozo` (
  `id` bigint NOT NULL,
  `dificulty` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `id_ciudad` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKvqvsg223ra7eivkhedk2fmlv` (`id_ciudad`),
  CONSTRAINT `FKvqvsg223ra7eivkhedk2fmlv` FOREIGN KEY (`id_ciudad`) REFERENCES `ciudad` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calabozo`
--

LOCK TABLES `calabozo` WRITE;
/*!40000 ALTER TABLE `calabozo` DISABLE KEYS */;
INSERT INTO `calabozo` VALUES (1,3,'Cripta de los Austrias',1),(2,5,'Mazmorras del Palacio Real',1),(3,4,'Catacumbas de la Almudena',1),(4,7,'Sótanos de la Sagrada Familia',2),(5,5,'Laberinto del Parque Güell',2),(6,4,'Túneles Góticos',2),(7,6,'Caverna del Tibidabo',2),(8,4,'Torres de Serranos Subterráneas',3),(9,3,'Refugio de las Fallas',3),(10,5,'Acueducto Olvidado',3),(11,6,'Mazmorras de la Giralda',4),(12,7,'Cripta del Alcázar',4),(13,5,'Basílica Subterránea del Pilar',5),(14,4,'Fortaleza Romana Perdida',5),(15,3,'Cuevas del Ebro',5),(16,8,'Catacumbas de París',6),(17,6,'Criptas de Notre-Dame',6),(18,5,'Alcantarillado Maldito',6),(19,9,'Torre Eiffel Invertida',6),(20,4,'Túneles de la Croix-Rousse',7),(21,5,'Anfiteatro Romano Oculto',7),(22,7,'Fortaleza del If',8),(23,6,'Puerto Antiguo Sumergido',8),(24,5,'Cuevas de Calanques',8),(25,9,'Coliseo Subterráneo',9),(26,7,'Catacumbas de San Calixto',9),(27,8,'Foro Romano Secreto',9),(28,6,'Termas de Caracalla Malditas',9),(29,6,'Cripta del Duomo',10),(30,7,'Castillo Sforzesco Oculto',10),(31,5,'Canales Subterráneos',10),(32,8,'Napoli Sotterranea',11),(33,9,'Cavernas del Vesubio',11),(34,5,'Bunker de la Guerra Fría',12),(35,4,'Túneles del Muro',12),(36,6,'Reichstag Subterráneo',12),(37,7,'Catacumbas Prusianas',12),(38,4,'Sótanos de Hofbräuhaus',13),(39,6,'Castillo de Nymphenburg Oscuro',13),(40,5,'Cripta Bávara',13),(41,5,'Almacenes Portuarios Abandonados',14),(42,6,'Túneles del Elba',14),(43,8,'Torre de Londres Maldita',15),(44,6,'Metro Fantasma',15),(45,7,'Criptas de Westminster',15),(46,5,'Alcantarillas Victorianas',15),(47,5,'Fábricas Industriales Olvidadas',16),(48,4,'Canales Subterráneos',16),(49,3,'Refugio Antiaéreo',16),(50,7,'Bóvedas de South Bridge',17),(51,8,'Castillo Encantado',17),(52,6,'Callejones Embrujados',17),(53,5,'Acueducto de las Aguas Libres',18),(54,6,'Castillo de San Jorge Subterráneo',18),(55,4,'Bodegas Malditas',19),(56,5,'Puente Don Luis Invertido',19),(57,3,'Ribera Antigua',19),(58,5,'Canales Ocultos',20),(59,4,'Ático de Ana Frank Alternativo',20),(60,6,'Molinos Subterráneos',20),(61,5,'Cripta de la Iglesia Vieja',20),(62,6,'Grand Place Subterránea',21),(63,7,'Atomium Invertido',21),(64,7,'Catacumbas de San Esteban',22),(65,8,'Palacio de Schönbrunn Secreto',22),(66,6,'Cripta Imperial',22),(67,9,'Golem de Praga',23),(68,7,'Castillo Subterráneo',23),(69,8,'Reloj Astronómico Maldito',23),(70,6,'Puente de Carlos Oculto',23),(71,7,'Laberinto del Castillo de Buda',24),(72,6,'Baños Termales Oscuros',24),(73,5,'Bastión de los Pescadores Secreto',24),(74,6,'Túneles de la Resistencia',25),(75,7,'Palacio Real Subterráneo',25),(76,5,'Metro Artístico Encantado',26),(77,7,'Palacio Real Vikingo',26),(78,6,'Museo Vasa Maldito',26),(79,5,'Jardines de Tivoli Oscuros',27),(80,4,'Sirenita Sumergida',27),(81,8,'Castillo de Kronborg',27),(82,6,'Nyhavn Subterráneo',27),(83,6,'Fortaleza de Akershus',28),(84,7,'Barco Vikingo Maldito',28),(85,5,'Almacenes de Guinness Olvidados',29),(86,6,'Castillo de Dublín Secreto',29),(87,4,'Criptas de la Catedral',29),(88,10,'Laberinto del Minotauro',30),(89,9,'Partenón Subterráneo',30),(90,8,'Ágora Antigua Maldita',30),(91,9,'Templo de Poseidón Sumergido',30);
/*!40000 ALTER TABLE `calabozo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calabozo_seq`
--

DROP TABLE IF EXISTS `calabozo_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `calabozo_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calabozo_seq`
--

LOCK TABLES `calabozo_seq` WRITE;
/*!40000 ALTER TABLE `calabozo_seq` DISABLE KEYS */;
/*!40000 ALTER TABLE `calabozo_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudad` (
  `id` bigint NOT NULL,
  `extension` double NOT NULL,
  `fecha_fundacion` date DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `num_habitantes` int NOT NULL,
  `pais` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad`
--

LOCK TABLES `ciudad` WRITE;
/*!40000 ALTER TABLE `ciudad` DISABLE KEYS */;
INSERT INTO `ciudad` VALUES (1,605.77,'1561-01-01','Madrid',3200000,'España'),(2,101.9,'1000-01-01','Barcelona',1620000,'España'),(3,134.6,'1138-01-01','Valencia',791000,'España'),(4,140.8,'1248-01-01','Sevilla',688000,'España'),(5,973.8,'1118-01-01','Zaragoza',674000,'España'),(6,105.4,'1000-01-01','París',2165000,'Francia'),(7,47.87,'1043-01-01','Lyon',516000,'Francia'),(8,240.6,'1000-01-01','Marsella',869000,'Francia'),(9,1285,'1000-01-01','Roma',2873000,'Italia'),(10,181.8,'1000-01-01','Milán',1352000,'Italia'),(11,117.3,'1000-01-01','Nápoles',967000,'Italia'),(12,891.8,'1237-01-01','Berlín',3645000,'Alemania'),(13,310.4,'1158-01-01','Múnich',1472000,'Alemania'),(14,755.2,'1189-01-01','Hamburgo',1841000,'Alemania'),(15,1572,'1066-01-01','Londres',8982000,'Reino Unido'),(16,115.6,'1301-01-01','Manchester',547000,'Reino Unido'),(17,264,'1124-01-01','Edimburgo',488000,'Reino Unido'),(18,100.1,'1147-01-01','Lisboa',505000,'Portugal'),(19,41.42,'1123-01-01','Oporto',237000,'Portugal'),(20,219.3,'1275-01-01','Ámsterdam',872000,'Países Bajos'),(21,161.4,'1040-01-01','Bruselas',1209000,'Bélgica'),(22,414.6,'1137-01-01','Viena',1897000,'Austria'),(23,496.1,'1230-01-01','Praga',1309000,'República Checa'),(24,525.2,'1241-01-01','Budapest',1752000,'Hungría'),(25,517.2,'1300-01-01','Varsovia',1765000,'Polonia'),(26,188,'1252-01-01','Estocolmo',975000,'Suecia'),(27,86.4,'1167-01-01','Copenhague',799000,'Dinamarca'),(28,454,'1048-01-01','Oslo',697000,'Noruega'),(29,115,'1204-01-01','Dublín',554000,'Irlanda'),(30,38.96,'1834-01-01','Atenas',664000,'Grecia');
/*!40000 ALTER TABLE `ciudad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ciudad_seq`
--

DROP TABLE IF EXISTS `ciudad_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ciudad_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ciudad_seq`
--

LOCK TABLES `ciudad_seq` WRITE;
/*!40000 ALTER TABLE `ciudad_seq` DISABLE KEYS */;
INSERT INTO `ciudad_seq` VALUES (401);
/*!40000 ALTER TABLE `ciudad_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario`
--

DROP TABLE IF EXISTS `inventario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario` (
  `id` bigint NOT NULL,
  `apariencia` varchar(255) DEFAULT NULL,
  `capacidad` int NOT NULL,
  `personaje_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKgr7vqoh1ptgh6q3bgtw3ynlpd` (`personaje_id`),
  CONSTRAINT `FKetg66um5w6ldludpnovnjxnx` FOREIGN KEY (`personaje_id`) REFERENCES `personaje` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario`
--

LOCK TABLES `inventario` WRITE;
/*!40000 ALTER TABLE `inventario` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario_item`
--

DROP TABLE IF EXISTS `inventario_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario_item` (
  `inventario_id` bigint NOT NULL,
  `item_id` bigint NOT NULL,
  KEY `FKt28pivpxbbgy5mns0yibyd62m` (`item_id`),
  KEY `FK4evf23kjkcho8621icwgkvqpx` (`inventario_id`),
  CONSTRAINT `FK4evf23kjkcho8621icwgkvqpx` FOREIGN KEY (`inventario_id`) REFERENCES `inventario` (`id`),
  CONSTRAINT `FKt28pivpxbbgy5mns0yibyd62m` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario_item`
--

LOCK TABLES `inventario_item` WRITE;
/*!40000 ALTER TABLE `inventario_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventario_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventario_seq`
--

DROP TABLE IF EXISTS `inventario_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventario_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventario_seq`
--

LOCK TABLES `inventario_seq` WRITE;
/*!40000 ALTER TABLE `inventario_seq` DISABLE KEYS */;
INSERT INTO `inventario_seq` VALUES (1);
/*!40000 ALTER TABLE `inventario_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `weight` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_seq`
--

DROP TABLE IF EXISTS `item_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_seq`
--

LOCK TABLES `item_seq` WRITE;
/*!40000 ALTER TABLE `item_seq` DISABLE KEYS */;
INSERT INTO `item_seq` VALUES (1);
/*!40000 ALTER TABLE `item_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personaje`
--

DROP TABLE IF EXISTS `personaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personaje` (
  `id` bigint NOT NULL,
  `hp` int NOT NULL,
  `level` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `race` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaje`
--

LOCK TABLES `personaje` WRITE;
/*!40000 ALTER TABLE `personaje` DISABLE KEYS */;
/*!40000 ALTER TABLE `personaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `personaje_seq`
--

DROP TABLE IF EXISTS `personaje_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `personaje_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `personaje_seq`
--

LOCK TABLES `personaje_seq` WRITE;
/*!40000 ALTER TABLE `personaje_seq` DISABLE KEYS */;
INSERT INTO `personaje_seq` VALUES (1);
/*!40000 ALTER TABLE `personaje_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `google_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `provider` enum('FACEBOOK','GITHUB','GOOGLE','LOCAL') DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UKovh8xmu9ac27t18m56gri58i1` (`google_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-05 13:48:23
