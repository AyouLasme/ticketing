-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 05 mars 2024 à 14:27
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_ticket_git`
--

-- --------------------------------------------------------

--
-- Structure de la table `affectations`
--

CREATE TABLE `affectations` (
  `date_creation` datetime(6) NOT NULL,
  `date_update` datetime(6) NOT NULL,
  `id` varchar(255) NOT NULL,
  `ticket_id` varchar(255) DEFAULT NULL,
  `utilisateur_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `messages`
--

CREATE TABLE `messages` (
  `date_creation` datetime(6) NOT NULL,
  `date_update` datetime(6) NOT NULL,
  `contenu` varchar(200) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  `ticket_id` varchar(255) NOT NULL,
  `utilisateur_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `tags`
--

CREATE TABLE `tags` (
  `date_creation` datetime(6) NOT NULL,
  `date_update` datetime(6) NOT NULL,
  `libelle` varchar(200) DEFAULT NULL,
  `id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `tickets`
--

CREATE TABLE `tickets` (
  `date_creation` datetime(6) NOT NULL,
  `date_update` datetime(6) NOT NULL,
  `creer_par_id` varchar(255) NOT NULL,
  `ferme_par_id` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `tickets`
--

INSERT INTO `tickets` (`date_creation`, `date_update`, `creer_par_id`, `ferme_par_id`, `id`, `libelle`) VALUES
('2024-03-04 17:19:44.000000', '2024-03-04 17:19:44.000000', '0ac18c8c-8e07-1683-818e-076694260000', NULL, '0ac18c8c-8e07-18cf-818e-0a4394df0001', 'gate coeur');

-- --------------------------------------------------------

--
-- Structure de la table `ticket_by_tag`
--

CREATE TABLE `ticket_by_tag` (
  `tag_id` varchar(255) NOT NULL,
  `ticket_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE `utilisateurs` (
  `date_creation` datetime(6) NOT NULL,
  `date_update` datetime(6) NOT NULL,
  `nom` varchar(30) DEFAULT NULL,
  `prenom` varchar(30) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`date_creation`, `date_update`, `nom`, `prenom`, `email`, `id`) VALUES
('2024-03-04 03:59:06.000000', '2024-03-04 03:59:06.000000', 'Mia', 'Kayla', 'Mia@GMAIL.COM', '0ac18c8c-8e07-1683-818e-076694260000'),
('2024-03-04 04:02:43.000000', '2024-03-04 04:02:43.000000', 'JACOB', 'waouh', 'JAabba@GMAIL.COM', '0ac18c8c-8e07-18cf-818e-0769e4000000'),
('2024-03-04 03:46:52.000000', '2024-03-04 03:46:52.000000', 'dez', 'tra', 'dezgrossetete@GMAIL.COM', '0ac18c8c-8e07-1b53-818e-075b5f380000');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `affectations`
--
ALTER TABLE `affectations`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgudvlj9ay3hyyxv7asv9k51w0` (`ticket_id`),
  ADD KEY `FKn20b3xvg1jrgueumndjmmx1qk` (`utilisateur_id`);

--
-- Index pour la table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6iv985o3ybdk63srj731en4ba` (`ticket_id`),
  ADD KEY `FK4ay19p4s5md13an9urvshwy70` (`utilisateur_id`);

--
-- Index pour la table `tags`
--
ALTER TABLE `tags`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_r3hs2l6s68qlilokhha3tvahr` (`libelle`);

--
-- Index pour la table `tickets`
--
ALTER TABLE `tickets`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK241aenatoaudqheciarumaibp` (`creer_par_id`),
  ADD KEY `FKr3h54r6ainjifv7o6i1alnngh` (`ferme_par_id`);

--
-- Index pour la table `ticket_by_tag`
--
ALTER TABLE `ticket_by_tag`
  ADD KEY `FKihkidajo0eln83bc0xpdvbr0d` (`tag_id`),
  ADD KEY `FKq8smu75hjjtt7hw4l5qlty8w8` (`ticket_id`);

--
-- Index pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_6ldvumu3hqvnmmxy1b6lsxwqy` (`email`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `affectations`
--
ALTER TABLE `affectations`
  ADD CONSTRAINT `FKgudvlj9ay3hyyxv7asv9k51w0` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`),
  ADD CONSTRAINT `FKn20b3xvg1jrgueumndjmmx1qk` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateurs` (`id`);

--
-- Contraintes pour la table `messages`
--
ALTER TABLE `messages`
  ADD CONSTRAINT `FK4ay19p4s5md13an9urvshwy70` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateurs` (`id`),
  ADD CONSTRAINT `FK6iv985o3ybdk63srj731en4ba` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`);

--
-- Contraintes pour la table `tickets`
--
ALTER TABLE `tickets`
  ADD CONSTRAINT `FK241aenatoaudqheciarumaibp` FOREIGN KEY (`creer_par_id`) REFERENCES `utilisateurs` (`id`),
  ADD CONSTRAINT `FKr3h54r6ainjifv7o6i1alnngh` FOREIGN KEY (`ferme_par_id`) REFERENCES `utilisateurs` (`id`);

--
-- Contraintes pour la table `ticket_by_tag`
--
ALTER TABLE `ticket_by_tag`
  ADD CONSTRAINT `FKihkidajo0eln83bc0xpdvbr0d` FOREIGN KEY (`tag_id`) REFERENCES `tags` (`id`),
  ADD CONSTRAINT `FKq8smu75hjjtt7hw4l5qlty8w8` FOREIGN KEY (`ticket_id`) REFERENCES `tickets` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
