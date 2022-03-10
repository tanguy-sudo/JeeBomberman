-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : jeu. 10 mars 2022 à 23:01
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `bombermanbdd`
--
CREATE DATABASE IF NOT EXISTS `bombermanbdd` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `bombermanbdd`;

-- --------------------------------------------------------

--
-- Structure de la table `game`
--

DROP TABLE IF EXISTS `game`;
CREATE TABLE IF NOT EXISTS `game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `game`
--

INSERT INTO `game` (`id`, `date`) VALUES
(26, '2022-03-08 22:48:53'),
(25, '2022-03-08 22:44:58');

-- --------------------------------------------------------

--
-- Structure de la table `play`
--

DROP TABLE IF EXISTS `play`;
CREATE TABLE IF NOT EXISTS `play` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `results` varchar(10) DEFAULT NULL,
  `id_game` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_game` (`id_game`),
  KEY `id_user` (`id_user`)
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `play`
--

INSERT INTO `play` (`id`, `results`, `id_game`, `id_user`) VALUES
(6, 'gagné', 25, 17),
(5, 'gagné', 25, 18),
(4, 'perdu', 26, 17),
(7, 'perdu', 26, 18);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `couleur_agent` enum('ROUGE','VERT','JAUNE','BLANC','DEFAULT','BLEU') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `couleur_agent`) VALUES
(17, 'tanguy', 'Bv4FOnZK9qXA9VUncK70dZ2oXxZbU0ttT27V5Dzezjs=', 'VERT'),
(18, 'julien', '4jw9f/dvbmI1zgkfL81f01dIZ3eZ0WN6z1uivKNQ4lg=', 'VERT'),
(21, 'yoann', 'tAH3INJarNq5KFxVFzCS12UAPHGQ2jVAEQwIz7t8khc=', 'DEFAULT');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
