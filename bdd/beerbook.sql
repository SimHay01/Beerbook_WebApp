-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Sam 18 Novembre 2017 à 15:23
-- Version du serveur :  5.7.11
-- Version de PHP :  5.6.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `beerbook`
--

-- --------------------------------------------------------

--
-- Structure de la table `bar`
--

CREATE TABLE `bar` (
  `idBa` int(11) NOT NULL,
  `nomBa` varchar(25) DEFAULT NULL,
  `villeBa` varchar(25) DEFAULT NULL,
  `paysBa` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `bar`
--

INSERT INTO `bar` (`idBa`, `nomBa`, `villeBa`, `paysBa`) VALUES
(1, 'Palais de la bière', 'Poitiers', 'France'),
(2, 'Jupiter', 'Berkeley', 'États-Unis');

-- --------------------------------------------------------

--
-- Structure de la table `biere`
--

CREATE TABLE `biere` (
  `idBi` int(11) NOT NULL,
  `nomBi` varchar(25) DEFAULT NULL,
  `pourcentBi` int(11) DEFAULT NULL,
  `typeBi` varchar(25) DEFAULT NULL,
  `paysBi` varchar(25) DEFAULT NULL,
  `photoBi` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `biere`
--

INSERT INTO `biere` (`idBi`, `nomBi`, `pourcentBi`, `typeBi`, `paysBi`, `photoBi`) VALUES
(1, 'Chouffe', 8, 'Blonde', 'Belgique', 'photoChouffe'),
(2, 'Faro', 6, 'Brune', 'France', 'photoFaro');

-- --------------------------------------------------------

--
-- Structure de la table `decouvrirbar`
--

CREATE TABLE `decouvrirbar` (
  `idDBa` int(11) NOT NULL,
  `idBa` int(11) DEFAULT NULL,
  `idU` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `decouvrirbiere`
--

CREATE TABLE `decouvrirbiere` (
  `idDBi` int(11) NOT NULL,
  `idBi` int(11) DEFAULT NULL,
  `idU` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `post`
--

CREATE TABLE `post` (
  `idP` int(11) NOT NULL,
  `noteBiereP` int(11) DEFAULT NULL,
  `noteBarP` int(11) DEFAULT NULL,
  `commentP` text,
  `dateP` date DEFAULT NULL,
  `idU` int(11) DEFAULT NULL,
  `idBa` int(11) DEFAULT NULL,
  `idBi` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `post`
--

INSERT INTO `post` (`idP`, `noteBiereP`, `noteBarP`, `commentP`, `dateP`, `idU`, `idBa`, `idBi`) VALUES
(1, 5, 6, 'tres bien', '2017-11-18', 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `sequence`
--

CREATE TABLE `sequence` (
  `SEQ_NAME` varchar(50) NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `sequence`
--

INSERT INTO `sequence` (`SEQ_NAME`, `SEQ_COUNT`) VALUES
('SEQ_GEN', '0');

-- --------------------------------------------------------

--
-- Structure de la table `testdao`
--

CREATE TABLE `testdao` (
  `ID` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `idU` int(11) NOT NULL,
  `pseudoU` varchar(25) DEFAULT NULL,
  `photoU` varchar(25) DEFAULT NULL,
  `mdpU` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`idU`, `pseudoU`, `photoU`, `mdpU`) VALUES
(1, 'shay', 'shay', 'test'),
(2, 'carlito', NULL, 'test'),
(3, 'simonhay', NULL, 'test'),
(4, 'test', NULL, 'test'),
(5, 'eeeeeeee', NULL, 'test'),
(6, 'aaaaaaaa', NULL, 'test'),
(7, 'rrrrrr', NULL, 'test');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `bar`
--
ALTER TABLE `bar`
  ADD PRIMARY KEY (`idBa`);

--
-- Index pour la table `biere`
--
ALTER TABLE `biere`
  ADD PRIMARY KEY (`idBi`);

--
-- Index pour la table `decouvrirbar`
--
ALTER TABLE `decouvrirbar`
  ADD PRIMARY KEY (`idDBa`),
  ADD KEY `FK_DecouvrirBar_idBa` (`idBa`),
  ADD KEY `FK_DecouvrirBar_idU` (`idU`);

--
-- Index pour la table `decouvrirbiere`
--
ALTER TABLE `decouvrirbiere`
  ADD PRIMARY KEY (`idDBi`),
  ADD KEY `FK_DecouvrirBiere_idBi` (`idBi`),
  ADD KEY `FK_DecouvrirBiere_idU` (`idU`);

--
-- Index pour la table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`idP`),
  ADD KEY `FK_Post_idU` (`idU`),
  ADD KEY `FK_Post_idBa` (`idBa`),
  ADD KEY `FK_Post_idBi` (`idBi`);

--
-- Index pour la table `sequence`
--
ALTER TABLE `sequence`
  ADD PRIMARY KEY (`SEQ_NAME`);

--
-- Index pour la table `testdao`
--
ALTER TABLE `testdao`
  ADD PRIMARY KEY (`ID`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`idU`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `bar`
--
ALTER TABLE `bar`
  MODIFY `idBa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `biere`
--
ALTER TABLE `biere`
  MODIFY `idBi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `decouvrirbar`
--
ALTER TABLE `decouvrirbar`
  MODIFY `idDBa` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `decouvrirbiere`
--
ALTER TABLE `decouvrirbiere`
  MODIFY `idDBi` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `post`
--
ALTER TABLE `post`
  MODIFY `idP` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `idU` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `decouvrirbar`
--
ALTER TABLE `decouvrirbar`
  ADD CONSTRAINT `FK_DecouvrirBar_idBa` FOREIGN KEY (`idBa`) REFERENCES `bar` (`idBa`),
  ADD CONSTRAINT `FK_DecouvrirBar_idU` FOREIGN KEY (`idU`) REFERENCES `utilisateur` (`idU`);

--
-- Contraintes pour la table `decouvrirbiere`
--
ALTER TABLE `decouvrirbiere`
  ADD CONSTRAINT `FK_DecouvrirBiere_idBi` FOREIGN KEY (`idBi`) REFERENCES `biere` (`idBi`),
  ADD CONSTRAINT `FK_DecouvrirBiere_idU` FOREIGN KEY (`idU`) REFERENCES `utilisateur` (`idU`);

--
-- Contraintes pour la table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `FK_Post_idBa` FOREIGN KEY (`idBa`) REFERENCES `bar` (`idBa`),
  ADD CONSTRAINT `FK_Post_idBi` FOREIGN KEY (`idBi`) REFERENCES `biere` (`idBi`),
  ADD CONSTRAINT `FK_Post_idU` FOREIGN KEY (`idU`) REFERENCES `utilisateur` (`idU`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
