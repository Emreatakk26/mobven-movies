CREATE DATABASE `movie` /*!40100 DEFAULT CHARACTER SET latin1 */;

CREATE TABLE `m_movie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `imdbid` varchar(255) DEFAULT NULL,
  `poster` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `year` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

SELECT * FROM movie.m_movie;