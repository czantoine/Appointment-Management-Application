-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le :  lun. 27 avr. 2020 à 06:13
-- Version du serveur :  5.7.26
-- Version de PHP :  7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données :  `Projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

CREATE TABLE `patient` (
  `id_patient` int(11) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Nd_Prenom` varchar(50) NOT NULL,
  `Sexe` varchar(10) NOT NULL,
  `Connaissance` varchar(50) NOT NULL,
  `Profession_actuelle` varchar(50) NOT NULL,
  `Profession_anterieur` varchar(50) NOT NULL,
  `Classification` varchar(50) NOT NULL,
  `email` varchar(320) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `patient`
--

INSERT INTO `patient` (`id_patient`, `Nom`, `Prenom`, `Nd_Prenom`, `Sexe`, `Connaissance`, `Profession_actuelle`, `Profession_anterieur`, `Classification`, `email`, `password`) VALUES
(1, 'Teller ', 'Patrick', '', 'Homme', 'Autre', 'Mathématicien', 'BG', 'Couple', '', ''),
(4, 'Billy', 'Elish ', '', 'Autre', 'Bouche à oreille', 'Singer', 'Dancer', 'Femme', 'bylli@email.com', 'aaa'),
(5, 'Panieux', 'Quentin', '', 'Homme', 'Bouche à oreille', 'student', '', 'Homme', 'qqq@email.com', 'qqq'),
(6, 'Hernandez', 'Patrick', '', 'Homme', 'Internet', 'Chanteur', '', 'Homme', 'dj@gmail.com', 'aaa'),
(7, 'test', 'test', '', 'Femme', 'Docteur', '', '', 'Enfant', 'test@gmail.com', 'a'),
(8, 'Ah', 'Billy', 'Robert', 'Homme', 'Docteur', 'efreiens', 'chauffeur', 'Ado', 'ahbilly@gmail.com', 'a');

-- --------------------------------------------------------

--
-- Structure de la table `rdv`
--

CREATE TABLE `rdv` (
  `id_rdv` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Heure` varchar(10) NOT NULL,
  `Prix` int(3) NOT NULL,
  `Reglement` varchar(50) NOT NULL,
  `id_patient` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `rdv`
--

INSERT INTO `rdv` (`id_rdv`, `Date`, `Heure`, `Prix`, `Reglement`, `id_patient`) VALUES
(1, '2020-04-04', '08:00', 12, 'Espèce', 0),
(2, '2020-04-04', '08:00', 12, 'Cheque', 0),
(3, '2020-04-04', '08:00', 1223, 'Carte Bleue', 0),
(4, '2020-04-25', '09:00', 21, 'Cheque', 6),
(5, '2023-04-15', '11:00', 222, 'Cheque', 7),
(6, '2020-04-18', '09:00', 2, 'Cheque', 1),
(7, '2021-04-21', '18:00', 20, 'Cheque', 8);

-- --------------------------------------------------------

--
-- Structure de la table `spy`
--

CREATE TABLE `spy` (
  `id_psy` int(11) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Num_phone` int(10) NOT NULL,
  `email` varchar(320) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `spy`
--

INSERT INTO `spy` (`id_psy`, `Nom`, `Prenom`, `Num_phone`, `email`, `password`) VALUES
(1, 'cichowicz', 'antoine', 651607802, 'ac11f@free.fr', '12345');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id_patient`);

--
-- Index pour la table `rdv`
--
ALTER TABLE `rdv`
  ADD PRIMARY KEY (`id_rdv`);

--
-- Index pour la table `spy`
--
ALTER TABLE `spy`
  ADD PRIMARY KEY (`id_psy`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `id_patient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `rdv`
--
ALTER TABLE `rdv`
  MODIFY `id_rdv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `spy`
--
ALTER TABLE `spy`
  MODIFY `id_psy` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
