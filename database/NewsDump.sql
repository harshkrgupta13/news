CREATE DATABASE  IF NOT EXISTS `news` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `news`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: news
-- ------------------------------------------------------
-- Server version	5.6.39-log

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
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `article` (
  `ar_id` int(11) NOT NULL AUTO_INCREMENT,
  `ar_author` varchar(255) DEFAULT NULL,
  `ar_title` varchar(2550) DEFAULT NULL,
  `ar_description` varchar(2550) DEFAULT NULL,
  `ar_url` varchar(2550) DEFAULT NULL,
  `ar_url_to_image` varchar(2550) DEFAULT NULL,
  `ar_content` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`ar_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (20,'The Economist','The battle for Venezuela’s future','The world’s democracies are right to seek change in Latin America’s worst-governed country','http://www.economist.com/leaders/2019/02/02/the-battle-for-venezuelas-future','https://cdn.static-economist.com/sites/default/files/images/print-edition/20190202_LDD001_0.jpg','IF PROTESTS ALONE could oust a president, Nicolás Maduro would already be on a plane to Cuba. On January 23rd at least 1m Venezuelans from across the country took to the streets demanding Mr Maduro step down. They were answering the call of Juan Guaidó, who l… [+6496 chars]'),(21,'The Economist','How Brussels should respond to Britain’s confused demands','Brexit is a problem that only Britain can fix—but the EU must give it the time to do so','http://www.economist.com/leaders/2019/02/02/how-brussels-should-respond-to-britains-confused-demands','https://cdn.static-economist.com/sites/default/files/images/2019/01/articles/main/20190202_ldp501.jpg','THERESA MAY has become so used to losing votes in the House of Commons that when, on January 29th, the prime minister got MPs to back her on a motion regarding her Brexit deal, it was treated as a breakthrough. She did it! announced one front page the next mo… [+4365 chars]'),(22,'The Economist','Italy’s slump reflects trouble both at home and abroad','The weak economy complicates a fraught fiscal position','http://www.economist.com/finance-and-economics/2019/02/02/italys-slump-reflects-trouble-both-at-home-and-abroad','https://cdn.static-economist.com/sites/default/files/images/2019/01/articles/main/20190202_fnp505.jpg','ITALY BOASTS no glittering economic record. GDP growth has trailed the euro-area average every year since 1999. Despite a decent showing in 2016-17, the economy has yet to regain fully the output lost during the global crisis a decade ago and a domestic banki… [+4308 chars]'),(23,NULL,'Budget 2019 polls','Times of India brings the Latest & Top Breaking News on Politics and Current Affairs in India & around the World, Cricket, Sports, Business, Bollywood News and Entertainment, Science, Technology, Health & Fitness news & opinions from leading columnists.','https://timesofindia.indiatimes.com/is-the-budget-good-for-you/polls/67795360.cms','http://timesofindia.indiatimes.com/photo/47529300.cms',NULL),(24,NULL,'Julian Edelman is Super Bowl MVP','','https://www.jpost.com/Diaspora/Julian-Edelman-is-Super-Bowl-MVP-579607','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/393503','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+3111 chars]'),(28,'Eytan Halon','Israel\'s highest-ever credit rating shows confidence in economy','The AA- rating from S&P is the highest rating Israel has ever received from the credit agency, on par with the Czech Republic, Estonia and Qatar. The highest rating is AAA.','https://www.jpost.com/Israel-News/Israels-highest-ever-credit-rating-shows-confidence-in-economy-579631','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/435208','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+5002 chars]'),(30,'Maayan Jaffe-Hoffman','52% of public, 10% of Likud: Netanyahu should resign if indicted - poll','However, there is not a consensus when the data is analyzed by party.','https://www.jpost.com/Israel-News/Over-half-of-Israelis-say-Netanyahu-should-resign-if-A-G-moves-to-indict-579628','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/435127','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+848 chars]'),(32,'xgdhfzdh','harfdhfcofhdfdhfdhfdm','sghsdghsdgsdgsdgsdgsdgsdg','sghsdghsdgsdgsdgsdgsdgsdg','rhfsdgh','rhfsdgh'),(35,'harsh','harsh','harsh','harsh','harsh','harsh'),(36,NULL,'Cradle of \'Arab Spring\' in flux as massive protests rock Tunisia','The IMF has urged the country to freeze public sector wages and reduce the government’s ballooning deficit','https://www.jpost.com/Middle-East/Cradle-of-Arab-Spring-in-flux-as-massive-protests-rock-Tunisia-579711','https://images.jpost.com/image/upload/f_auto,fl_lossy/t_Article2016_ControlFaceDetect/422733','X\r\n Dear Reader,\r\n As you can imagine, more people are reading The Jerusalem Post than ever before.\r\n Nevertheless, traditional business models are no longer sustainable and high-quality publications,\r\n like ours, are being forced to look for new ways to keep… [+5431 chars]'),(37,'FOCUS Online','Berliner Fluggesellschaft Germania beantragt Insolvenz','Die Berliner Fluggesellschaft Germania hat beim Amtsgericht Berlin-Charlottenburg Insolvenz beantragt. Das teilte das Unternehmen mit. Der Flugbetrieb wurde in der Nacht eingestellt.','https://www.focus.de/finanzen/news/betrieb-eingestellt-berliner-fluggesellschaft-germania-beantragt-insolvenz_id_10277465.html','https://p5.focus.de/img/fotos/crop10276125/3692718133-w1200-h627-o-q75-p5/urn-newsml-dpa-com-20090101-190204-99-849540-large-4-3.jpg','Die Berliner Fluggesellschaft Germania hat beim Amtsgericht Berlin-Charlottenburg Insolvenz beantragt. Das teilte das Unternehmen mit. Der Flugbetrieb wurde in der Nacht eingestellt. Betroffen sind die Germania Fluggesellschaft mbH und ihr Schwesterunternehme… [+1349 chars]'),(38,'Spiegel Online','+++ Der Morgen live +++: Sieben Tote bei Großbrand in Paris','Das Feuer in einem achtstöckigen Wohnhaus war zunächst aus unbekannter Ursache ausgebrochen. Die Zahl der Todesopfer könne noch steigen. Die Live-News.','http://www.spiegel.de/politik/deutschland/nachrichten-am-morgen-die-news-in-echtzeit-a-1251018.html','http://cdn1.spiegel.de/images/image-1391614-860_poster_16x9-nqjx-1391614.jpg',NULL),(39,'Erica Zingher','5. Februar 2019: Muss Nicolás Maduro gehen?','In Venezuela verhärten sich weiter die Fronten. Wird die Lage eskalieren? Außerdem im Podcast: Mitarbeiter der AfD sollen sich in der Identitären Bewegung engagieren.','https://www.zeit.de/politik/2019-02/nachrichtenpodcast-was-jetzt-05-februar-19','https://img.zeit.de/politik/2017-09/illu-podcast-news/wide__8ed8a6__1300x731','In Venezuela streiten Präsident Nicolás Maduro und Oppositionsführer Juan Guaidó weiter um die Macht. Maduro ließ am Wochenende ein Ultimatum von acht EU-Ländern verstreichen, vorgezogene Präsidentschaftswahlen anzusetzen. Stattdessen drohte er der Opposition… [+996 chars]'),(40,NULL,'Paris: Feuer in Wohnhaus – Mindestens sieben Tote, viele Verletzte','Bei einem Brand in einem Mehrfamilienhaus in Paris sind in der Nacht zu Dienstag  mindestens sieben Menschen gestorben. Außerdem gab es viele Verletzte.','http://www.bild.de/news/ausland/news-ausland/paris-feuer-in-wohnhaus-mindestens-sieben-tote-59955314.bild.html','https://bilder.bild.de/fotos/paris-feuer-in-wohnhaus--mindestens-sieben-tote-viele-verletzte-201045655-59955340/Bild/2.bild.jpg','Feuer-Drama in Paris!\r\nParis Bei einem Brand in einem Mehrfamilienhaus in Paris sind in der Nacht zu Dienstag mindestens sieben Menschen gestorben. Ein weiteres Opfer wurde nach Angaben der Feuerwehr bei dem Unglück schwer verletzt. Außerdem erlitten 28 Mensc… [+622 chars]'),(41,'Spiegel Online','Die Lage am Dienstag: Liebe Leserin, lieber Leser,','endlich ist es soweit: Eine Woche später als eigentlich geplant darf Donald Trump heute Abend seine Rede zur Lage der Nation vor beiden Kammern des US-Kongresses halten. Nancy Pelosi, die demokratische Sprecherin des Repräsentantenhauses, hatte ihm...','http://www.spiegel.de/politik/deutschland/news-donald-trump-state-of-the-union-venezuela-spd-rente-emmanuel-macron-a-1251437.html','http://cdn1.spiegel.de/images/image-977108-breitwandaufmacher-bxmr-977108.jpg','endlich ist es soweit: Eine Woche später als eigentlich geplant darf Donald Trump heute Abend seine Rede zur Lage der Nation vor beiden Kammern des US-Kongresses halten. Nancy Pelosi, die demokratische Sprecherin des Repräsentantenhauses, hatte ihm diesen gro… [+5069 chars]'),(42,NULL,'Germania ist insolvent – Flugbetrieb sofort eingestellt','Erneut muss eine Berliner Fluggesellschaft Insolvenz anmelden. Die Flieger bleiben ab sofort am Boden, die Mitarbeiter stehen vor einer ungewissen Zukunft.','https://www.tagesspiegel.de/wirtschaft/berliner-airline-germania-ist-insolvent-flugbetrieb-sofort-eingestellt/23948796.html','https://www.tagesspiegel.de/images/airline-germania/23948814/1-format530.jpg','Die Berliner Fluggesellschaft Germania hat Insolvenz beantragt und ihren Flugbetrieb mit sofortiger Wirkung eingestellt. Wie das Unternehmen in der Nacht mitteilte, sind die Germania Fluggesellschaft GmbH und ihr Schwesterunternehmen für technische Dienstleis… [+3290 chars]'),(43,NULL,'Democrats dismiss Trump’s call for comity as more broken promises','What party leaders said was a disingenuous plea for bipartisanship fell unheeded in a capital riven by anger over policy differences and recriminations.','https://www.washingtonpost.com/politics/democrats-dismiss-trump-call-for-comity-as-more-broken-promises/2019/02/06/f3883f22-2963-11e9-984d-9b8fba003e81_story.html','https://www.washingtonpost.com/resizer/eRZ7V4fVM1SyOimHZwDtOf5YHjg=/1484x0/arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/DD7WMUBJXUI6TEDOTVK3MRI6WQ.jpg','Former Georgia gubernatorial candidate Stacey Abrams said President Trump had abandoned not just our people but our values. Sen. Kamala D. Harris, a presidential candidate, dismissed his insecure appeals to unity. And House Speaker Nancy Pelosi offered her cr… [+7095 chars]');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `favourite_article`
--

DROP TABLE IF EXISTS `favourite_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `favourite_article` (
  `fa_id` int(11) NOT NULL AUTO_INCREMENT,
  `fa_us_id` int(11) NOT NULL,
  `fa_ar_id` int(11) NOT NULL,
  PRIMARY KEY (`fa_id`),
  KEY `fa_us_fk_idx` (`fa_us_id`),
  KEY `fa_ar_fk_idx` (`fa_ar_id`),
  CONSTRAINT `fa_ar_fk` FOREIGN KEY (`fa_ar_id`) REFERENCES `article` (`ar_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fa_us_fk` FOREIGN KEY (`fa_us_id`) REFERENCES `user` (`us_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `favourite_article`
--

LOCK TABLES `favourite_article` WRITE;
/*!40000 ALTER TABLE `favourite_article` DISABLE KEYS */;
INSERT INTO `favourite_article` VALUES (145,42,37),(166,46,38),(167,46,39),(168,46,40);
/*!40000 ALTER TABLE `favourite_article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `language` (
  `la_id` int(11) NOT NULL AUTO_INCREMENT,
  `la_name` varchar(45) DEFAULT NULL,
  `la_code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`la_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` VALUES (1,'English','en'),(2,'German','de');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `us_id` int(11) NOT NULL AUTO_INCREMENT,
  `us_name` varchar(45) DEFAULT NULL,
  `us_email` varchar(45) DEFAULT NULL,
  `us_password` varchar(255) DEFAULT NULL,
  `us_blacklisted` tinyint(4) DEFAULT NULL,
  `us_ur_id` int(11) NOT NULL,
  `us_la_id` int(11) NOT NULL,
  PRIMARY KEY (`us_id`),
  KEY `us_ur_fk_idx` (`us_ur_id`),
  KEY `us_la_fk_idx` (`us_la_id`),
  CONSTRAINT `us_la_fk` FOREIGN KEY (`us_la_id`) REFERENCES `language` (`la_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `us_ur_fk` FOREIGN KEY (`us_ur_id`) REFERENCES `user_role` (`ur_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Admin','admin@email.com','123456',0,1,1),(4,'aaaaaa','a@email.com','111111',0,2,1),(6,'abc','abc@email.com','abcabc',0,2,1),(42,'bbbbbb','b@email.com','222222',0,2,2),(44,'cccccc','c@email.com','333333',0,2,1),(46,'Smith','Smith@email.com','888888',0,2,2),(51,'Harsh','harsh@email.com','harsh1',0,2,1),(52,'HarshGupta','har@gmail.com','harshgupta',0,2,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `ur_id` int(11) NOT NULL AUTO_INCREMENT,
  `ur_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ur_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'Admin'),(2,'News Analyst');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-06 15:38:01
