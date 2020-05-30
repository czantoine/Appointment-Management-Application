-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost:8889
-- Généré le :  sam. 30 mai 2020 à 10:02
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
  `type` varchar(10) NOT NULL DEFAULT 'Patient',
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

INSERT INTO `patient` (`id_patient`, `type`, `Nom`, `Prenom`, `Nd_Prenom`, `Sexe`, `Connaissance`, `Profession_actuelle`, `Profession_anterieur`, `Classification`, `email`, `password`) VALUES
(0, 'admin', 'admin', 'admin', '', '', '', '', '', 'Enfant', 'admin@gmail.com', 'azerty'),
(4, 'patient', 'Billy', 'Elish ', 'kebab', 'Autre', 'Bouche à oreille', 'Singer', 'Dancer', 'Femme', 'bylli@email.com', ''),
(8, 'patient', 'Ah', 'Billy', 'Robert', 'Homme', 'Docteur', 'efreiens', 'chauffeur', 'Ado', 'ahbilly@gmail.com', ''),
(17, 'patient', 'Billy', 'Elish ', 'test', 'Autre', 'Docteur', 'Singer', 'Dancer', 'Femme', 'bylli@email.com', ''),
(19, 'Patient', 'a', 'a', 'a', 'Homme', 'Autre patient', '', '', 'Enfant', 'a', ''),
(20, 'Patient', 'b', 'b', '', 'Homme', 'Autre patient', '', '', 'Enfant', 'b', 'b');

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
  `id_patient` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `rdv`
--

INSERT INTO `rdv` (`id_rdv`, `Date`, `Heure`, `Prix`, `Reglement`, `id_patient`) VALUES
(7, '2021-04-21', '18:00', 20, 'Cheque', 8),
(11, '2020-05-09', '09:00', 32, 'Espèce', 8),
(12, '2020-05-02', '08:30', 2, 'Espèce', 8);

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
  ADD PRIMARY KEY (`id_rdv`),
  ADD KEY `fk1` (`id_rdv`),
  ADD KEY `fk_patient` (`id_patient`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `patient`
--
ALTER TABLE `patient`
  MODIFY `id_patient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `rdv`
--
ALTER TABLE `rdv`
  MODIFY `id_rdv` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `rdv`
--
ALTER TABLE `rdv`
  ADD CONSTRAINT `fk_patient` FOREIGN KEY (`id_patient`) REFERENCES `patient` (`id_patient`) ON DELETE CASCADE;
