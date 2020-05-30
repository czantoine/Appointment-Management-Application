-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3308
-- Généré le :  sam. 30 mai 2020 à 20:32
-- Version du serveur :  8.0.18
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `consultation`
--

DROP TABLE IF EXISTS `consultation`;
CREATE TABLE IF NOT EXISTS `consultation` (
  `id_consultation` int(32) NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `heure` time NOT NULL,
  `nb_pers` int(32) NOT NULL,
  `type_paiement` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `prix` double(64,2) NOT NULL,
  `etat_consultation` tinyint(1) NOT NULL DEFAULT '0',
  `type_consultation` varchar(250) NOT NULL,
  `nb_anxiete` int(32) DEFAULT NULL,
  `WeekMonth` char(32) NOT NULL,
  PRIMARY KEY (`id_consultation`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `consultation`
--

INSERT INTO `consultation` (`id_consultation`, `date`, `heure`, `nb_pers`, `type_paiement`, `prix`, `etat_consultation`, `type_consultation`, `nb_anxiete`, `WeekMonth`) VALUES
(1, '2020-05-20', '00:00:00', 1, 'carte', 20.40, 0, 'Anxiety', 2, ''),
(2, '2020-05-18', '15:30:00', 1, 'cheque', 70.80, 0, 'Anxiety', 2, ''),
(3, '2020-05-19', '13:00:00', 1, 'espèce', 70.90, 0, 'Depression', 0, ''),
(4, '2020-05-31', '15:00:00', 2, 'carte', 700.00, 0, 'Couple Therapy', NULL, ''),
(5, '2020-08-12', '07:00:00', 3, 'chèque', 1000.24, 0, 'Depression', NULL, ''),
(6, '2020-05-27', '16:00:00', 2, 'carte', 96.02, 0, 'Anxiety', 2, ''),
(7, '2020-07-29', '15:00:00', 1, 'espèce', 60.00, 0, 'Advice', NULL, ''),
(8, '2020-07-14', '08:30:00', 2, 'chèque', 200.80, 0, 'Advice', NULL, ''),
(9, '2020-05-27', '13:00:00', 3, 'carte', 960.70, 0, 'Depression', NULL, ''),
(10, '2023-05-10', '07:00:00', 1, 'carte', 250.23, 0, 'Advice', NULL, ''),
(11, '2020-05-16', '07:00:00', 1, 'carte', 27.80, 0, 'Advice', NULL, ''),
(12, '2020-05-10', '13:00:00', 1, 'carte', 987.05, 0, 'Advice', NULL, '');

-- --------------------------------------------------------

--
-- Structure de la table `consulte`
--

DROP TABLE IF EXISTS `consulte`;
CREATE TABLE IF NOT EXISTS `consulte` (
  `id_consulte` int(32) NOT NULL AUTO_INCREMENT,
  `id_patientcons` int(32) NOT NULL,
  `id_consultation` int(32) NOT NULL,
  PRIMARY KEY (`id_consulte`),
  KEY `fk_consultation` (`id_consultation`),
  KEY `fk_patient` (`id_patientcons`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `consulte`
--

INSERT INTO `consulte` (`id_consulte`, `id_patientcons`, `id_consultation`) VALUES
(1, 4, 7),
(2, 2, 8),
(3, 3, 8),
(4, 2, 9),
(5, 3, 9),
(6, 4, 9),
(7, 2, 10),
(8, 2, 11),
(9, 5, 12);

-- --------------------------------------------------------

--
-- Structure de la table `patients`
--

DROP TABLE IF EXISTS `patients`;
CREATE TABLE IF NOT EXISTS `patients` (
  `id_patient` int(32) NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `age` int(32) NOT NULL,
  `sexe` varchar(50) NOT NULL,
  `relation` varchar(50) NOT NULL,
  `moyen_connaissance` varchar(250) NOT NULL,
  `profession_actuelle` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id_patient`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `patients`
--

INSERT INTO `patients` (`id_patient`, `nom`, `prenom`, `age`, `sexe`, `relation`, `moyen_connaissance`, `profession_actuelle`) VALUES
(2, 'mysta', 'mysta', 17, 'F', 'Single', 'internet', 'avocate'),
(3, 'feder', 'feder', 20, 'M', 'Single', 'pages jaunes', 'fleuriste'),
(4, 'marc', 'marc', 27, 'M', 'Couple', 'net', 'ingenieur'),
(5, 'test', 'test', 17, 'f', 'Couple', 'net', 'apiculteur');

-- --------------------------------------------------------

--
-- Structure de la table `posture`
--

DROP TABLE IF EXISTS `posture`;
CREATE TABLE IF NOT EXISTS `posture` (
  `id_posture` int(32) NOT NULL AUTO_INCREMENT,
  `nom_posture` varchar(250) NOT NULL,
  `id_consultation` int(32) NOT NULL,
  PRIMARY KEY (`id_posture`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `professions_anterieures`
--

DROP TABLE IF EXISTS `professions_anterieures`;
CREATE TABLE IF NOT EXISTS `professions_anterieures` (
  `idprofessions_anterieures` int(32) NOT NULL AUTO_INCREMENT,
  `idpatient` int(32) NOT NULL,
  `profession_ant` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`idprofessions_anterieures`),
  KEY `fk_idpatient_prof_ant` (`idpatient`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `professions_anterieures`
--

INSERT INTO `professions_anterieures` (`idprofessions_anterieures`, `idpatient`, `profession_ant`) VALUES
(1, 2, 'mannequin'),
(2, 3, 'ingenieur'),
(5, 4, ''),
(6, 5, ''),
(7, 2, 'danseur ');

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id_user` int(32) NOT NULL AUTO_INCREMENT,
  `mail` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type` varchar(50) NOT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id_user`, `mail`, `password`, `type`) VALUES
(1, 'psy', '1234', 'admin'),
(2, 'mysta', '1022', 'user'),
(3, 'feder', '1457', 'user'),
(4, 'marc', '5874', 'user'),
(5, 'test', 'test', 'user');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `consulte`
--
ALTER TABLE `consulte`
  ADD CONSTRAINT `fk_consultation` FOREIGN KEY (`id_consultation`) REFERENCES `consultation` (`id_consultation`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_patient` FOREIGN KEY (`id_patientcons`) REFERENCES `patients` (`id_patient`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `patients`
--
ALTER TABLE `patients`
  ADD CONSTRAINT `id_user_fk` FOREIGN KEY (`id_patient`) REFERENCES `users` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `professions_anterieures`
--
ALTER TABLE `professions_anterieures`
  ADD CONSTRAINT `fk_idpatient_prof_ant` FOREIGN KEY (`idpatient`) REFERENCES `patients` (`id_patient`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
