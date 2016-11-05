-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 09, 2016 at 06:05 PM
-- Server version: 5.6.26
-- PHP Version: 5.5.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `erp_empsi`
--

-- --------------------------------------------------------

--
-- Table structure for table `absence_ens`
--

CREATE TABLE IF NOT EXISTS `absence_ens` (
  `id_absence_ens` bigint(20) NOT NULL,
  `date_debut` datetime DEFAULT NULL,
  `date_fin` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `heure_debut` datetime DEFAULT NULL,
  `heure_fin` datetime DEFAULT NULL,
  `jour_absence` datetime DEFAULT NULL,
  `nbr_jour` int(11) NOT NULL,
  `id_utilisateur` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `absence_etudiant`
--

CREATE TABLE IF NOT EXISTS `absence_etudiant` (
  `id_absence` bigint(20) NOT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `date_absence` datetime DEFAULT NULL,
  `justification` bit(1) NOT NULL,
  `id_etudiant` bigint(20) DEFAULT NULL,
  `id_seance` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `administrateur`
--

CREATE TABLE IF NOT EXISTS `administrateur` (
  `id` bigint(20) NOT NULL,
  `adresse_utilisateur` varchar(255) DEFAULT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `date_inscription` datetime DEFAULT NULL,
  `date_naissance` datetime DEFAULT NULL,
  `deletable` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `etat_compte` bit(1) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `pays_naissance` varchar(255) DEFAULT NULL,
  `profession_utilisateur` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `tel_fix_utilisateur` varchar(255) DEFAULT NULL,
  `tel_utilisateur` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `ville_naissance` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `annee_scolaire`
--

CREATE TABLE IF NOT EXISTS `annee_scolaire` (
  `id_anne` bigint(20) NOT NULL,
  `desc_anne` varchar(255) DEFAULT NULL,
  `annee_debut` varchar(255) DEFAULT NULL,
  `annee_fin` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `annee_scolaire`
--

INSERT INTO `annee_scolaire` (`id_anne`, `desc_anne`, `annee_debut`, `annee_fin`) VALUES
(1, NULL, '2012', '2013'),
(2, NULL, '2013', '2014'),
(3, NULL, '2014', '2015'),
(4, NULL, '2015', '2016'),
(5, NULL, '2016', '2017'),
(6, NULL, '2012', '2013'),
(7, NULL, '2013', '2014'),
(8, NULL, '2014', '2015'),
(9, NULL, '2015', '2016'),
(10, NULL, '2016', '2017');

-- --------------------------------------------------------

--
-- Table structure for table `chating_message`
--

CREATE TABLE IF NOT EXISTS `chating_message` (
  `id` bigint(20) NOT NULL,
  `id_receiver` bigint(20) DEFAULT NULL,
  `id_sender` bigint(20) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `name_receiver` varchar(255) DEFAULT NULL,
  `name_sender` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `chating_message`
--

INSERT INTO `chating_message` (`id`, `id_receiver`, `id_sender`, `message`, `name_receiver`, `name_sender`, `time`) VALUES
(4, 2, 1, 'i''am fine Thanks', 'etudiant@email.com', 'admin@email.com', '2016-05-30 13:07:21'),
(5, 1, 2, 'hi admin how are you ??', 'admin@email.com', 'etudiant@email.com', '2016-05-30 13:09:14'),
(6, 1, 1, 'salam', 'admin@email.com', 'admin@email.com', '2016-06-09 17:14:48'),
(7, 131072, 131072, 'vcv', 'rami@titour.com', 'rami@titour.com', '2016-06-09 17:21:42'),
(8, 131072, 131072, 'v', 'rami@titour.com', 'rami@titour.com', '2016-06-09 17:21:46'),
(9, 131072, 131072, 'v', 'rami@titour.com', 'rami@titour.com', '2016-06-09 17:21:47'),
(10, 1, 2, 'salut Monsieur', 'admin@email.com', 'etudiant@email.com', '2016-06-09 17:44:28'),
(11, 1, 65536, 'Bonjour Admin', 'admin@email.com', 'said_rahhal@email.com', '2016-06-09 17:53:37');

-- --------------------------------------------------------

--
-- Table structure for table `classe`
--

CREATE TABLE IF NOT EXISTS `classe` (
  `id_classe` bigint(20) NOT NULL,
  `desc_classe` varchar(255) DEFAULT NULL,
  `nbr_etudiant` int(11) NOT NULL,
  `nom_classe` varchar(255) DEFAULT NULL,
  `id_annee` bigint(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `classe`
--

INSERT INTO `classe` (`id_classe`, `desc_classe`, `nbr_etudiant`, `nom_classe`, `id_annee`) VALUES
(1, 'classe license genie informatique', 27, 'LGI', 3),
(2, 'classe license genie Reseaux', 18, 'LGR', 3),
(3, 'classe Master genie Infos', 15, 'MGI', 3);

-- --------------------------------------------------------

--
-- Table structure for table `declaration`
--

CREATE TABLE IF NOT EXISTS `declaration` (
  `id_declaration` bigint(20) NOT NULL,
  `contenu` varchar(255) DEFAULT NULL,
  `datedeclaration` datetime DEFAULT NULL,
  `objet` varchar(255) DEFAULT NULL,
  `type_declaration` varchar(255) DEFAULT NULL,
  `id_user` bigint(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `declaration`
--

INSERT INTO `declaration` (`id_declaration`, `contenu`, `datedeclaration`, `objet`, `type_declaration`, `id_user`) VALUES
(1, 'Bonjour,\nJe ne serai pas present demain.', '2016-05-30 15:09:25', 'absence', 'absence', 16),
(2, 'J ai perdu hier mon portable.', '2016-05-30 15:10:05', 'sans', 'perte', 16);

-- --------------------------------------------------------

--
-- Table structure for table `diplome`
--

CREATE TABLE IF NOT EXISTS `diplome` (
  `id_diplome` bigint(20) NOT NULL,
  `annee_obtention` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `etablissement` varchar(255) DEFAULT NULL,
  `mention` varchar(255) DEFAULT NULL,
  `titre` varchar(255) DEFAULT NULL,
  `id_utilisateur` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `document`
--

CREATE TABLE IF NOT EXISTS `document` (
  `id_document` bigint(20) NOT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  `date_pub` datetime DEFAULT NULL,
  `nom_document` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `id_type` bigint(20) DEFAULT NULL,
  `id_utilisateur` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ens_permanent`
--

CREATE TABLE IF NOT EXISTS `ens_permanent` (
  `id` bigint(20) NOT NULL,
  `adresse_utilisateur` varchar(255) DEFAULT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `date_inscription` datetime DEFAULT NULL,
  `date_naissance` datetime DEFAULT NULL,
  `deletable` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `etat_compte` bit(1) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `pays_naissance` varchar(255) DEFAULT NULL,
  `profession_utilisateur` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `tel_fix_utilisateur` varchar(255) DEFAULT NULL,
  `tel_utilisateur` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `ville_naissance` varchar(255) DEFAULT NULL,
  `nbr_heure_semaine` int(11) NOT NULL,
  `salaire_mensuel` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ens_permanent`
--

INSERT INTO `ens_permanent` (`id`, `adresse_utilisateur`, `cin`, `date_inscription`, `date_naissance`, `deletable`, `email`, `etat_compte`, `first_name`, `last_name`, `password`, `pays_naissance`, `profession_utilisateur`, `sexe`, `tel_fix_utilisateur`, `tel_utilisateur`, `telephone`, `ville_naissance`, `nbr_heure_semaine`, `salaire_mensuel`) VALUES
(98304, 'adress for Mr HEDABOU', 'H65656', NULL, NULL, NULL, 'm_hedabou@email.com', NULL, 'HEDABOU', 'mustapha', 'hedabou1234', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0),
(98305, 'atlas adress', 'L544187', NULL, NULL, NULL, 'atlas@email.com', NULL, 'ATLAS', 'Abd Elghafour', 'atlastst', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `ens_vacataire`
--

CREATE TABLE IF NOT EXISTS `ens_vacataire` (
  `id` bigint(20) NOT NULL,
  `adresse_utilisateur` varchar(255) DEFAULT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `date_inscription` datetime DEFAULT NULL,
  `date_naissance` datetime DEFAULT NULL,
  `deletable` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `etat_compte` bit(1) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `pays_naissance` varchar(255) DEFAULT NULL,
  `profession_utilisateur` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `tel_fix_utilisateur` varchar(255) DEFAULT NULL,
  `tel_utilisateur` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `ville_naissance` varchar(255) DEFAULT NULL,
  `nbr_heure_semaine` int(11) NOT NULL,
  `salaire_heure` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `etudiant`
--

CREATE TABLE IF NOT EXISTS `etudiant` (
  `id` bigint(20) NOT NULL,
  `adresse_utilisateur` varchar(255) DEFAULT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `date_inscription` datetime DEFAULT NULL,
  `date_naissance` datetime DEFAULT NULL,
  `deletable` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `etat_compte` bit(1) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `pays_naissance` varchar(255) DEFAULT NULL,
  `profession_utilisateur` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `tel_fix_utilisateur` varchar(255) DEFAULT NULL,
  `tel_utilisateur` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `ville_naissance` varchar(255) DEFAULT NULL,
  `annee_obtention_bac` varchar(255) DEFAULT NULL,
  `cne` varchar(255) DEFAULT NULL,
  `id_classe` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `etudiant`
--

INSERT INTO `etudiant` (`id`, `adresse_utilisateur`, `cin`, `date_inscription`, `date_naissance`, `deletable`, `email`, `etat_compte`, `first_name`, `last_name`, `password`, `pays_naissance`, `profession_utilisateur`, `sexe`, `tel_fix_utilisateur`, `tel_utilisateur`, `telephone`, `ville_naissance`, `annee_obtention_bac`, `cne`, `id_classe`) VALUES
(5, 'casa', '21225', '2016-04-03 00:00:00', '2016-04-03 00:00:00', NULL, 'zak@zak.com', b'1', 'zakaria', 'el idrissi', 'casablanca', 'Maroc', 'etudiant', 'homme', '0657508989', '0657508989', '0657508989', 'casa', '2011', '1353354', NULL),
(6, 'etudiant01', 'etudiant01', NULL, '1990-04-01 02:00:00', NULL, 'etudiant@email.com', NULL, 'etudiant01', 'etudiant02', 'etudiant01', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'etudiant01', NULL),
(16, 'abdeljabbar', 'belkhalil', '2016-05-09 00:00:00', '2016-05-26 00:00:00', NULL, 'abdeljabar@email.com', b'1', 'abdeljabbar', 'belkhalil', '123456', 'maroc', 'etudiant', 'homme', NULL, NULL, '0652588415', 'ouarzazate', '2011', 'zeadzaedze', 1),
(65536, NULL, '6546848979', '2016-05-30 13:26:55', '1992-02-02 01:00:00', NULL, 'said_rahhal@email.com', b'0', 'Rahhal', 'said', 'said1990', 'maroc', 'etudiant', 'Monsieur', NULL, '0568628288', NULL, 'safi', NULL, NULL, 1),
(131072, 'bernoussi casa', '0000', NULL, '2000-10-09 02:00:00', NULL, 'rami@titour.com', NULL, 'Titour', 'Rami', 'ramirami', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '2222', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `evaluation`
--

CREATE TABLE IF NOT EXISTS `evaluation` (
  `id_evaluation` bigint(20) NOT NULL,
  `date_evaluation` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `objet` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `examen`
--

CREATE TABLE IF NOT EXISTS `examen` (
  `id_devoir` bigint(20) NOT NULL,
  `date_devoir` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `id_matiere` bigint(20) DEFAULT NULL,
  `date_evaluation` datetime DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  `sujet` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `fichier`
--

CREATE TABLE IF NOT EXISTS `fichier` (
  `id_fichier` bigint(20) NOT NULL,
  `date_partage` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `extension` varchar(255) DEFAULT NULL,
  `lien_fichier` varchar(255) DEFAULT NULL,
  `nom_fichier` varchar(255) DEFAULT NULL,
  `id_classe` bigint(20) DEFAULT NULL,
  `id_enseignant` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `formation`
--

CREATE TABLE IF NOT EXISTS `formation` (
  `id_formation` bigint(20) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `desc_formation` varchar(255) DEFAULT NULL,
  `nom_formation` varchar(255) DEFAULT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `formation`
--

INSERT INTO `formation` (`id_formation`, `date_debut`, `date_fin`, `desc_formation`, `nom_formation`, `prix`) VALUES
(1, NULL, NULL, 'formation1', 'formation1', 123),
(2, NULL, NULL, 'formation3', 'form3', 120);

-- --------------------------------------------------------

--
-- Table structure for table `formation_continu`
--

CREATE TABLE IF NOT EXISTS `formation_continu` (
  `id_formation` bigint(20) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `desc_formation` varchar(255) DEFAULT NULL,
  `nom_formation` varchar(255) DEFAULT NULL,
  `prix` double NOT NULL,
  `dure` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `formation_diplomante`
--

CREATE TABLE IF NOT EXISTS `formation_diplomante` (
  `id_formation` bigint(20) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `desc_formation` varchar(255) DEFAULT NULL,
  `nom_formation` varchar(255) DEFAULT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `formation_diplomante`
--

INSERT INTO `formation_diplomante` (`id_formation`, `date_debut`, `date_fin`, `desc_formation`, `nom_formation`, `prix`) VALUES
(1, '2015-09-03', '2016-08-03', 'license genie informatique', 'license genie informatique', 0);

-- --------------------------------------------------------

--
-- Table structure for table `formation_module`
--

CREATE TABLE IF NOT EXISTS `formation_module` (
  `id_module` bigint(20) NOT NULL,
  `id_formation` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `formation_niveau`
--

CREATE TABLE IF NOT EXISTS `formation_niveau` (
  `id_niveau` bigint(20) NOT NULL,
  `id_formation` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `formation_typeformation`
--

CREATE TABLE IF NOT EXISTS `formation_typeformation` (
  `id_formation` bigint(20) NOT NULL,
  `id_type_formation` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `formation_typeformation`
--

INSERT INTO `formation_typeformation` (`id_formation`, `id_type_formation`) VALUES
(1, 3);

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `id` bigint(20) NOT NULL,
  `deletable` bit(1) DEFAULT NULL,
  `group_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`id`, `deletable`, `group_name`) VALUES
(1, b'0', 'Admin'),
(2, b'0', 'etudiant'),
(3, b'0', 'enseignant permanent'),
(4, b'0', 'enseignant vacataire'),
(5, b'0', 'temporary group'),
(6, b'0', 'parent');

-- --------------------------------------------------------

--
-- Table structure for table `group_right_table`
--

CREATE TABLE IF NOT EXISTS `group_right_table` (
  `group_id` bigint(20) NOT NULL,
  `right_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `group_right_table`
--

INSERT INTO `group_right_table` (`group_id`, `right_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 32),
(1, 28),
(1, 16),
(1, 17),
(1, 18),
(1, 19),
(1, 20),
(1, 21),
(1, 22),
(1, 23),
(1, 24),
(1, 25),
(1, 26),
(1, 27),
(1, 29),
(1, 30),
(1, 9),
(1, 11),
(1, 12),
(1, 14),
(2, 5),
(2, 6),
(2, 7),
(2, 8),
(2, 28),
(2, 15),
(2, 13),
(2, 10),
(2, 8),
(6, 5),
(6, 6),
(6, 7),
(6, 8),
(6, 28),
(6, 15),
(6, 13),
(6, 10),
(6, 8),
(3, 5),
(3, 6),
(3, 7),
(3, 8),
(3, 28),
(3, 15),
(3, 13),
(3, 10),
(3, 12),
(3, 14),
(3, 15),
(3, 8),
(4, 5),
(4, 6),
(4, 7),
(4, 8),
(4, 28),
(4, 15),
(4, 13),
(4, 10),
(4, 12),
(4, 14),
(4, 15),
(5, 5),
(5, 6),
(5, 7),
(5, 28),
(5, 31),
(5, 8);

-- --------------------------------------------------------

--
-- Table structure for table `group_user_table`
--

CREATE TABLE IF NOT EXISTS `group_user_table` (
  `group_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `group_user_table`
--

INSERT INTO `group_user_table` (`group_id`, `user_id`) VALUES
(1, 1),
(4, 5),
(6, 3),
(5, 65536),
(3, 4),
(3, 98304),
(3, 98305),
(2, 16),
(2, 2),
(2, 6),
(2, 131072);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequences`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequences` (
  `sequence_name` varchar(255) DEFAULT NULL,
  `sequence_next_hi_value` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequences`
--

INSERT INTO `hibernate_sequences` (`sequence_name`, `sequence_next_hi_value`) VALUES
('users', 5),
('formation', 1);

-- --------------------------------------------------------

--
-- Table structure for table `historique`
--

CREATE TABLE IF NOT EXISTS `historique` (
  `id_historique` bigint(20) NOT NULL,
  `date_action` datetime DEFAULT NULL,
  `methode` varchar(255) DEFAULT NULL,
  `utilisateur` tinyblob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `inscription`
--

CREATE TABLE IF NOT EXISTS `inscription` (
  `id_inscription` bigint(20) NOT NULL,
  `annee_bac` varchar(255) DEFAULT NULL,
  `annee_diplome` varchar(255) DEFAULT NULL,
  `date_insc` datetime DEFAULT NULL,
  `dernier_diplome` varchar(255) DEFAULT NULL,
  `diponibilitè` varchar(255) DEFAULT NULL,
  `extension` varchar(255) DEFAULT NULL,
  `lien_cv` varchar(255) DEFAULT NULL,
  `lien_diplome` varchar(255) DEFAULT NULL,
  `numero_insc` varchar(255) DEFAULT NULL,
  `serie_bac` varchar(255) DEFAULT NULL,
  `id_utilisateur` bigint(20) DEFAULT NULL,
  `id_formatio` bigint(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `inscription`
--

INSERT INTO `inscription` (`id_inscription`, `annee_bac`, `annee_diplome`, `date_insc`, `dernier_diplome`, `diponibilitè`, `extension`, `lien_cv`, `lien_diplome`, `numero_insc`, `serie_bac`, `id_utilisateur`, `id_formatio`) VALUES
(1, NULL, NULL, '2016-05-30 14:12:21', NULL, NULL, NULL, NULL, NULL, '1/EMPSI/2016', NULL, 65536, 1),
(2, '2011', '2015', '2016-05-18 00:00:00', 'licence genie infos ', NULL, NULL, NULL, NULL, '16/EMPSI/2016', NULL, 16, 1);

-- --------------------------------------------------------

--
-- Table structure for table `materiel`
--

CREATE TABLE IF NOT EXISTS `materiel` (
  `id_materiel` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `etat` bit(1) NOT NULL,
  `label_etat` varchar(255) DEFAULT NULL,
  `matricule` varchar(255) DEFAULT NULL,
  `nom_materiel` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `matiere`
--

CREATE TABLE IF NOT EXISTS `matiere` (
  `id_matiere` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nom_matiere` varchar(255) DEFAULT NULL,
  `id_enseignant` bigint(20) DEFAULT NULL,
  `id_module` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `matiere_modules`
--

CREATE TABLE IF NOT EXISTS `matiere_modules` (
  `matiere` bigint(20) NOT NULL,
  `modules` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

CREATE TABLE IF NOT EXISTS `messages` (
  `id` bigint(20) NOT NULL,
  `date_envoi` datetime DEFAULT NULL,
  `date_reception` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `email_sender` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `objet` varchar(255) DEFAULT NULL,
  `id_sender` bigint(20) DEFAULT NULL,
  `id_recepteur` bigint(20) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`id`, `date_envoi`, `date_reception`, `email`, `email_sender`, `message`, `objet`, `id_sender`, `id_recepteur`) VALUES
(1, '2016-05-30 14:49:55', NULL, 'abdeljabar@email.com', 'admin@email.com', 'Vous avez une seance le Lundi à 9h avec Mr. Rahmouni', 'cours le lundi', 1, 16),
(2, '2016-05-30 14:52:41', NULL, 'abdeljabar@email.com', 'said_rahhal@email.com', 'salam cv ?', 'salam', 65536, 16),
(3, '2016-06-09 17:22:39', NULL, 'etudiant01@email.com', 'rami@titour.com', 'salam cv je suis rami.', 'salam', 131072, 6),
(4, '2016-06-09 17:23:43', NULL, 'abdeljabar@email.com', 'rami@titour.com', 'Svp vous m''envoyez le tp d''hier', 'cc', 131072, 16),
(5, '2016-06-09 17:57:03', NULL, 'said_rahhal@email.com', 'abdeljabar@email.com', 'salam said rahhal', 'salam', 16, 65536);

-- --------------------------------------------------------

--
-- Table structure for table `message_classe`
--

CREATE TABLE IF NOT EXISTS `message_classe` (
  `id` bigint(20) NOT NULL,
  `date_envoi` datetime DEFAULT NULL,
  `date_reception` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `objet` varchar(255) DEFAULT NULL,
  `id_classe` bigint(20) DEFAULT NULL,
  `id_user` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `module`
--

CREATE TABLE IF NOT EXISTS `module` (
  `id_module` bigint(20) NOT NULL,
  `desc_module` varchar(255) DEFAULT NULL,
  `nom_module` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `module_matieres`
--

CREATE TABLE IF NOT EXISTS `module_matieres` (
  `module` bigint(20) NOT NULL,
  `matieres` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `module_semestre`
--

CREATE TABLE IF NOT EXISTS `module_semestre` (
  `id_module` bigint(20) NOT NULL,
  `id_semestre` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `niveau`
--

CREATE TABLE IF NOT EXISTS `niveau` (
  `id_niveau` bigint(20) NOT NULL,
  `label_niveau` varchar(255) DEFAULT NULL,
  `nom_niveau` varchar(255) DEFAULT NULL,
  `prix` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `niveau`
--

INSERT INTO `niveau` (`id_niveau`, `label_niveau`, `nom_niveau`, `prix`) VALUES
(1, 'bac+n', 'niv', 12000);

-- --------------------------------------------------------

--
-- Table structure for table `niveau_formations`
--

CREATE TABLE IF NOT EXISTS `niveau_formations` (
  `niveau` bigint(20) NOT NULL,
  `formations` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `niveau_semestres`
--

CREATE TABLE IF NOT EXISTS `niveau_semestres` (
  `niveau` bigint(20) NOT NULL,
  `semestres` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE IF NOT EXISTS `notification` (
  `id_notif` bigint(20) NOT NULL,
  `contenu` varchar(255) DEFAULT NULL,
  `objet` varchar(255) DEFAULT NULL,
  `user` tinyblob,
  `vue` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `notif_user`
--

CREATE TABLE IF NOT EXISTS `notif_user` (
  `id_utilisateur` bigint(20) NOT NULL,
  `id_notification` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `paiement`
--

CREATE TABLE IF NOT EXISTS `paiement` (
  `id_paiement` bigint(20) NOT NULL,
  `date_paiement` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `parent`
--

CREATE TABLE IF NOT EXISTS `parent` (
  `id` bigint(20) NOT NULL,
  `adresse_utilisateur` varchar(255) DEFAULT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `date_inscription` datetime DEFAULT NULL,
  `date_naissance` datetime DEFAULT NULL,
  `deletable` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `etat_compte` bit(1) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `pays_naissance` varchar(255) DEFAULT NULL,
  `profession_utilisateur` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `tel_fix_utilisateur` varchar(255) DEFAULT NULL,
  `tel_utilisateur` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `ville_naissance` varchar(255) DEFAULT NULL,
  `nbr_enfants` int(11) NOT NULL,
  `nom_complet_mere` varchar(255) DEFAULT NULL,
  `nom_complet_pere` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `question_test`
--

CREATE TABLE IF NOT EXISTS `question_test` (
  `id_qestion` bigint(20) NOT NULL,
  `qestion` varchar(255) DEFAULT NULL,
  `reponse1` varchar(255) DEFAULT NULL,
  `reponse2` varchar(255) DEFAULT NULL,
  `bonne_reponse` varchar(255) DEFAULT NULL,
  `id_test` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reservation_materiel`
--

CREATE TABLE IF NOT EXISTS `reservation_materiel` (
  `id_res_materiel` bigint(20) NOT NULL,
  `date_res` datetime DEFAULT NULL,
  `debut_res` datetime DEFAULT NULL,
  `decision` varchar(255) DEFAULT NULL,
  `desc_reservation` varchar(255) DEFAULT NULL,
  `fin_res` datetime DEFAULT NULL,
  `heure_debut` datetime DEFAULT NULL,
  `heure_fin` datetime DEFAULT NULL,
  `id_materiel` bigint(20) DEFAULT NULL,
  `id_utilisateur` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `reservation_salle`
--

CREATE TABLE IF NOT EXISTS `reservation_salle` (
  `id_res_salle` bigint(20) NOT NULL,
  `desc_reservation` varchar(255) DEFAULT NULL,
  `date_res` datetime DEFAULT NULL,
  `debut_res` datetime DEFAULT NULL,
  `decision` varchar(255) DEFAULT NULL,
  `fin_res` datetime DEFAULT NULL,
  `heure_debut` datetime DEFAULT NULL,
  `heure_fin` datetime DEFAULT NULL,
  `id_salle` bigint(20) DEFAULT NULL,
  `id_utilisateur` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `responsable_ped`
--

CREATE TABLE IF NOT EXISTS `responsable_ped` (
  `id` bigint(20) NOT NULL,
  `adresse_utilisateur` varchar(255) DEFAULT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `date_inscription` datetime DEFAULT NULL,
  `date_naissance` datetime DEFAULT NULL,
  `deletable` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `etat_compte` bit(1) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `pays_naissance` varchar(255) DEFAULT NULL,
  `profession_utilisateur` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `tel_fix_utilisateur` varchar(255) DEFAULT NULL,
  `tel_utilisateur` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `ville_naissance` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `resultat_test_enligne`
--

CREATE TABLE IF NOT EXISTS `resultat_test_enligne` (
  `id_reponse_etud` bigint(20) NOT NULL,
  `note` double NOT NULL,
  `id_etudiant` bigint(20) DEFAULT NULL,
  `id_test` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rights`
--

CREATE TABLE IF NOT EXISTS `rights` (
  `id` bigint(20) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `deletable` bit(1) DEFAULT NULL,
  `disc` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rights`
--

INSERT INTO `rights` (`id`, `category`, `deletable`, `disc`, `name`) VALUES
(1, 'gestion des droits d''accès', b'0', 'one of the mean rights can''t be deleted', ' les droirts '),
(2, 'gestion des droits d''accès', b'0', 'one of the mean rights can''t be deleted', ' les utilisateur '),
(3, 'gestion des droits d''accès', b'0', 'one of the mean rights can''t be deleted', ' les groupes '),
(4, 'gestion des inscription', NULL, NULL, ' gestion comptes '),
(5, 'messages', NULL, NULL, ' Nouveau message '),
(6, 'messages', NULL, NULL, ' Messages envoyees '),
(7, 'messages', NULL, NULL, ' Messages Recus '),
(8, 'Declaration', NULL, NULL, ' declaration '),
(9, 'classe', NULL, NULL, ' ajouter classe '),
(10, 'classe', NULL, NULL, ' ma classe '),
(11, 'classe', NULL, NULL, ' gestion etudiants/classes '),
(12, 'classe', NULL, NULL, ' contacter classe '),
(13, 'classe', NULL, NULL, ' message recus de ma classe '),
(14, 'classe', NULL, NULL, ' publier Document '),
(15, 'classe', NULL, NULL, ' les documents partages '),
(16, 'formation', NULL, NULL, ' Enseignant Permanant '),
(17, 'formation', NULL, NULL, ' Enseingant Vacataire '),
(18, 'formation', NULL, NULL, ' Etudiant '),
(19, 'formation', NULL, NULL, ' Formtion Continue '),
(20, 'formation', NULL, NULL, ' Types de formation '),
(21, 'formation', NULL, NULL, ' Formtion Diplomante '),
(22, 'formation', NULL, NULL, ' Niveaux '),
(23, 'formation', NULL, NULL, ' Semestre '),
(24, 'formation', NULL, NULL, ' Module '),
(25, 'formation', NULL, NULL, ' Matieres '),
(26, 'formation', NULL, NULL, ' Seances '),
(27, 'formation', NULL, NULL, ' l''affectation des matieres aux enseignants '),
(28, 'discussion', NULL, NULL, ' discussion instantanée '),
(29, 'Gestion de patrimoine', NULL, NULL, ' Salles '),
(30, 'Gestion de patrimoine', NULL, NULL, ' Materiels '),
(31, 'gestion des inscription', NULL, NULL, ' inscrire a une formation '),
(32, 'Declaration', NULL, NULL, ' gestion Declarations ');

-- --------------------------------------------------------

--
-- Table structure for table `salle`
--

CREATE TABLE IF NOT EXISTS `salle` (
  `id_salle` bigint(20) NOT NULL,
  `desc_salle` varchar(255) DEFAULT NULL,
  `etat_salle` bit(1) DEFAULT NULL,
  `label_etat` varchar(255) DEFAULT NULL,
  `num_salle` int(11) NOT NULL,
  `type_salle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `seance`
--

CREATE TABLE IF NOT EXISTS `seance` (
  `id_seance` bigint(20) NOT NULL,
  `objet` varchar(255) DEFAULT NULL,
  `sommaire` varchar(255) DEFAULT NULL,
  `date_seance` date DEFAULT NULL,
  `desc_seance` varchar(255) DEFAULT NULL,
  `heure_debut` varchar(255) DEFAULT NULL,
  `heure_fin` varchar(255) DEFAULT NULL,
  `presence_ens` bit(1) DEFAULT NULL,
  `id_matiere` bigint(20) DEFAULT NULL,
  `id_salle` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `semestre`
--

CREATE TABLE IF NOT EXISTS `semestre` (
  `id_semestre` bigint(20) NOT NULL,
  `date_debut` date DEFAULT NULL,
  `date_fin` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `nom_semestre` varchar(255) DEFAULT NULL,
  `id_niveau` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `statut`
--

CREATE TABLE IF NOT EXISTS `statut` (
  `id_statut` bigint(20) NOT NULL,
  `contenu` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `id_utilisateur` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `test_en_ligne`
--

CREATE TABLE IF NOT EXISTS `test_en_ligne` (
  `id_devoir` bigint(20) NOT NULL,
  `date_devoir` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `id_matiere` bigint(20) DEFAULT NULL,
  `date_test` datetime DEFAULT NULL,
  `sujet` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `type_document`
--

CREATE TABLE IF NOT EXISTS `type_document` (
  `id_type` bigint(20) NOT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `type_formaton`
--

CREATE TABLE IF NOT EXISTS `type_formaton` (
  `id_type_formation` bigint(20) NOT NULL,
  `label_type_formation` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `type_formaton`
--

INSERT INTO `type_formaton` (`id_type_formation`, `label_type_formation`) VALUES
(1, 'cours de soir'),
(3, 'cours du jour'),
(4, 'cours week end');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` bigint(20) NOT NULL,
  `adresse_utilisateur` varchar(255) DEFAULT NULL,
  `cin` varchar(255) DEFAULT NULL,
  `date_inscription` datetime DEFAULT NULL,
  `date_naissance` datetime DEFAULT NULL,
  `deletable` bit(1) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `etat_compte` bit(1) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `pays_naissance` varchar(255) DEFAULT NULL,
  `profession_utilisateur` varchar(255) DEFAULT NULL,
  `sexe` varchar(255) DEFAULT NULL,
  `tel_fix_utilisateur` varchar(255) DEFAULT NULL,
  `tel_utilisateur` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `ville_naissance` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `adresse_utilisateur`, `cin`, `date_inscription`, `date_naissance`, `deletable`, `email`, `etat_compte`, `first_name`, `last_name`, `password`, `pays_naissance`, `profession_utilisateur`, `sexe`, `tel_fix_utilisateur`, `tel_utilisateur`, `telephone`, `ville_naissance`) VALUES
(1, NULL, NULL, NULL, NULL, NULL, 'admin@email.com', NULL, 'admin', 'admin', 'admin', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(2, NULL, NULL, NULL, NULL, NULL, 'etudiant@email.com', NULL, 'etudiant', 'etudiant', 'etudiant', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(3, NULL, NULL, NULL, NULL, NULL, 'parent@email.com', NULL, 'parent', 'parent', 'parent', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(4, NULL, NULL, NULL, NULL, NULL, 'enseignantP@email.com', NULL, 'enseignantP', 'enseignantP', 'enseignantP', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, NULL, NULL, NULL, NULL, NULL, 'enseignantV@email.com', NULL, 'enseignantV', 'enseignantV', 'enseignantV', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `absence_ens`
--
ALTER TABLE `absence_ens`
  ADD PRIMARY KEY (`id_absence_ens`);

--
-- Indexes for table `absence_etudiant`
--
ALTER TABLE `absence_etudiant`
  ADD PRIMARY KEY (`id_absence`),
  ADD KEY `FK_f9tg3o901dt0mn75aiohjqt6` (`id_etudiant`),
  ADD KEY `FK_tl0e07oc9pf6d38p5cllce5qx` (`id_seance`);

--
-- Indexes for table `administrateur`
--
ALTER TABLE `administrateur`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `annee_scolaire`
--
ALTER TABLE `annee_scolaire`
  ADD PRIMARY KEY (`id_anne`);

--
-- Indexes for table `chating_message`
--
ALTER TABLE `chating_message`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`id_classe`),
  ADD KEY `FK_bcq43o5cqv4wjbvsve9w33t3r` (`id_annee`);

--
-- Indexes for table `declaration`
--
ALTER TABLE `declaration`
  ADD PRIMARY KEY (`id_declaration`);

--
-- Indexes for table `diplome`
--
ALTER TABLE `diplome`
  ADD PRIMARY KEY (`id_diplome`);

--
-- Indexes for table `document`
--
ALTER TABLE `document`
  ADD PRIMARY KEY (`id_document`),
  ADD KEY `FK_asuvmal81ypbxlam92s1demc` (`id_type`);

--
-- Indexes for table `ens_permanent`
--
ALTER TABLE `ens_permanent`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ens_vacataire`
--
ALTER TABLE `ens_vacataire`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_jh1mlcmexao5cetcsm3eq129k` (`id_classe`);

--
-- Indexes for table `evaluation`
--
ALTER TABLE `evaluation`
  ADD PRIMARY KEY (`id_evaluation`);

--
-- Indexes for table `examen`
--
ALTER TABLE `examen`
  ADD PRIMARY KEY (`id_devoir`),
  ADD KEY `FK_81ccnwj97m2aon3cjitnompc` (`id_matiere`);

--
-- Indexes for table `fichier`
--
ALTER TABLE `fichier`
  ADD PRIMARY KEY (`id_fichier`),
  ADD KEY `FK_r9jdqkh3tvyg1bd072mupa1qw` (`id_classe`);

--
-- Indexes for table `formation`
--
ALTER TABLE `formation`
  ADD PRIMARY KEY (`id_formation`);

--
-- Indexes for table `formation_continu`
--
ALTER TABLE `formation_continu`
  ADD PRIMARY KEY (`id_formation`);

--
-- Indexes for table `formation_diplomante`
--
ALTER TABLE `formation_diplomante`
  ADD PRIMARY KEY (`id_formation`);

--
-- Indexes for table `formation_module`
--
ALTER TABLE `formation_module`
  ADD KEY `FK_25j4a6epi1ibnu76d5bd6mjfk` (`id_module`);

--
-- Indexes for table `formation_niveau`
--
ALTER TABLE `formation_niveau`
  ADD KEY `FK_asc22d30ij3u6t8sci2no3ffr` (`id_niveau`);

--
-- Indexes for table `formation_typeformation`
--
ALTER TABLE `formation_typeformation`
  ADD KEY `FK_ltqj6w0mhdpay8n3s0nwolhsj` (`id_type_formation`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `group_right_table`
--
ALTER TABLE `group_right_table`
  ADD KEY `FK_1j03vbbmyk0u4euu8uns7u6vc` (`right_id`),
  ADD KEY `FK_p8u7g4u0xemtu8xq9bate485v` (`group_id`);

--
-- Indexes for table `group_user_table`
--
ALTER TABLE `group_user_table`
  ADD KEY `FK_msi6c7tta106lgv9oejau0dpi` (`group_id`);

--
-- Indexes for table `historique`
--
ALTER TABLE `historique`
  ADD PRIMARY KEY (`id_historique`);

--
-- Indexes for table `inscription`
--
ALTER TABLE `inscription`
  ADD PRIMARY KEY (`id_inscription`),
  ADD KEY `FK_dgyfu5cv70ac9bvlyrg6xqt0q` (`id_utilisateur`);

--
-- Indexes for table `materiel`
--
ALTER TABLE `materiel`
  ADD PRIMARY KEY (`id_materiel`);

--
-- Indexes for table `matiere`
--
ALTER TABLE `matiere`
  ADD PRIMARY KEY (`id_matiere`),
  ADD KEY `FK_mj4gim5h23v68eny4v31qb7e2` (`id_module`);

--
-- Indexes for table `matiere_modules`
--
ALTER TABLE `matiere_modules`
  ADD KEY `FK_6ax440gnmbyx8rc7cn98otdr0` (`modules`),
  ADD KEY `FK_1qil9l2o1uhy20e1tqhokymrj` (`matiere`);

--
-- Indexes for table `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `message_classe`
--
ALTER TABLE `message_classe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_71b3ke6qw0tkj9r6hqlc4hxkl` (`id_classe`);

--
-- Indexes for table `module`
--
ALTER TABLE `module`
  ADD PRIMARY KEY (`id_module`);

--
-- Indexes for table `module_matieres`
--
ALTER TABLE `module_matieres`
  ADD UNIQUE KEY `UK_cbjicd81sfcd81munt5wqcx5t` (`matieres`),
  ADD KEY `FK_jjeugoe617od9xcmbua7f4api` (`module`);

--
-- Indexes for table `module_semestre`
--
ALTER TABLE `module_semestre`
  ADD KEY `FK_cl2v194tlgchi0x3jdxfie6db` (`id_semestre`),
  ADD KEY `FK_25lerh9fk52acois0pqu1f116` (`id_module`);

--
-- Indexes for table `niveau`
--
ALTER TABLE `niveau`
  ADD PRIMARY KEY (`id_niveau`);

--
-- Indexes for table `niveau_formations`
--
ALTER TABLE `niveau_formations`
  ADD UNIQUE KEY `UK_sb7hmcpvedqychsf0y2971erq` (`formations`),
  ADD KEY `FK_n66ekpm85vxgnbjllrd11i9px` (`niveau`);

--
-- Indexes for table `niveau_semestres`
--
ALTER TABLE `niveau_semestres`
  ADD UNIQUE KEY `UK_stm647nagvoj5px953tgve994` (`semestres`),
  ADD KEY `FK_jan6u5h7a56n4jlwpihfc8e79` (`niveau`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`id_notif`);

--
-- Indexes for table `notif_user`
--
ALTER TABLE `notif_user`
  ADD KEY `FK_haowh09t70hxu7kpg4bdvmgry` (`id_notification`);

--
-- Indexes for table `paiement`
--
ALTER TABLE `paiement`
  ADD PRIMARY KEY (`id_paiement`);

--
-- Indexes for table `parent`
--
ALTER TABLE `parent`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `question_test`
--
ALTER TABLE `question_test`
  ADD PRIMARY KEY (`id_qestion`),
  ADD KEY `FK_4uiixbvi86uww8eh17cfva886` (`id_test`);

--
-- Indexes for table `reservation_materiel`
--
ALTER TABLE `reservation_materiel`
  ADD PRIMARY KEY (`id_res_materiel`),
  ADD KEY `FK_7f949ohc2jg1rn481kotmxlab` (`id_materiel`);

--
-- Indexes for table `reservation_salle`
--
ALTER TABLE `reservation_salle`
  ADD PRIMARY KEY (`id_res_salle`),
  ADD KEY `FK_ivm2wlcmpqailkp3q8cchhi5f` (`id_salle`);

--
-- Indexes for table `responsable_ped`
--
ALTER TABLE `responsable_ped`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `resultat_test_enligne`
--
ALTER TABLE `resultat_test_enligne`
  ADD PRIMARY KEY (`id_reponse_etud`),
  ADD KEY `FK_3avmyxywhc4vkbreuk8boqaq1` (`id_etudiant`),
  ADD KEY `FK_50ib6jfllfeyka76j2m15l9cs` (`id_test`);

--
-- Indexes for table `rights`
--
ALTER TABLE `rights`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`id_salle`);

--
-- Indexes for table `seance`
--
ALTER TABLE `seance`
  ADD PRIMARY KEY (`id_seance`),
  ADD KEY `FK_b3ho1ne0hdadqbohbghhleruk` (`id_matiere`),
  ADD KEY `FK_h30jdw4gitybw0owwu08bqkfm` (`id_salle`);

--
-- Indexes for table `semestre`
--
ALTER TABLE `semestre`
  ADD PRIMARY KEY (`id_semestre`),
  ADD KEY `FK_nohv6cqx4u9toyegfj7ng83aj` (`id_niveau`);

--
-- Indexes for table `statut`
--
ALTER TABLE `statut`
  ADD PRIMARY KEY (`id_statut`);

--
-- Indexes for table `test_en_ligne`
--
ALTER TABLE `test_en_ligne`
  ADD PRIMARY KEY (`id_devoir`),
  ADD KEY `FK_pcmpmce500pxoqno57pr9nr7e` (`id_matiere`);

--
-- Indexes for table `type_document`
--
ALTER TABLE `type_document`
  ADD PRIMARY KEY (`id_type`);

--
-- Indexes for table `type_formaton`
--
ALTER TABLE `type_formaton`
  ADD PRIMARY KEY (`id_type_formation`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `absence_ens`
--
ALTER TABLE `absence_ens`
  MODIFY `id_absence_ens` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `absence_etudiant`
--
ALTER TABLE `absence_etudiant`
  MODIFY `id_absence` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `annee_scolaire`
--
ALTER TABLE `annee_scolaire`
  MODIFY `id_anne` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `chating_message`
--
ALTER TABLE `chating_message`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `classe`
--
ALTER TABLE `classe`
  MODIFY `id_classe` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `declaration`
--
ALTER TABLE `declaration`
  MODIFY `id_declaration` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `diplome`
--
ALTER TABLE `diplome`
  MODIFY `id_diplome` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `document`
--
ALTER TABLE `document`
  MODIFY `id_document` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `evaluation`
--
ALTER TABLE `evaluation`
  MODIFY `id_evaluation` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `fichier`
--
ALTER TABLE `fichier`
  MODIFY `id_fichier` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `groups`
--
ALTER TABLE `groups`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `historique`
--
ALTER TABLE `historique`
  MODIFY `id_historique` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `inscription`
--
ALTER TABLE `inscription`
  MODIFY `id_inscription` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `materiel`
--
ALTER TABLE `materiel`
  MODIFY `id_materiel` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `matiere`
--
ALTER TABLE `matiere`
  MODIFY `id_matiere` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `messages`
--
ALTER TABLE `messages`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `message_classe`
--
ALTER TABLE `message_classe`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `module`
--
ALTER TABLE `module`
  MODIFY `id_module` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `niveau`
--
ALTER TABLE `niveau`
  MODIFY `id_niveau` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `id_notif` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `paiement`
--
ALTER TABLE `paiement`
  MODIFY `id_paiement` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `question_test`
--
ALTER TABLE `question_test`
  MODIFY `id_qestion` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `reservation_materiel`
--
ALTER TABLE `reservation_materiel`
  MODIFY `id_res_materiel` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `reservation_salle`
--
ALTER TABLE `reservation_salle`
  MODIFY `id_res_salle` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `resultat_test_enligne`
--
ALTER TABLE `resultat_test_enligne`
  MODIFY `id_reponse_etud` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `rights`
--
ALTER TABLE `rights`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT for table `salle`
--
ALTER TABLE `salle`
  MODIFY `id_salle` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `seance`
--
ALTER TABLE `seance`
  MODIFY `id_seance` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `semestre`
--
ALTER TABLE `semestre`
  MODIFY `id_semestre` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `statut`
--
ALTER TABLE `statut`
  MODIFY `id_statut` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `type_document`
--
ALTER TABLE `type_document`
  MODIFY `id_type` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `type_formaton`
--
ALTER TABLE `type_formaton`
  MODIFY `id_type_formation` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `absence_etudiant`
--
ALTER TABLE `absence_etudiant`
  ADD CONSTRAINT `FK_f9tg3o901dt0mn75aiohjqt6` FOREIGN KEY (`id_etudiant`) REFERENCES `etudiant` (`id`),
  ADD CONSTRAINT `FK_tl0e07oc9pf6d38p5cllce5qx` FOREIGN KEY (`id_seance`) REFERENCES `seance` (`id_seance`);

--
-- Constraints for table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `FK_bcq43o5cqv4wjbvsve9w33t3r` FOREIGN KEY (`id_annee`) REFERENCES `annee_scolaire` (`id_anne`);

--
-- Constraints for table `document`
--
ALTER TABLE `document`
  ADD CONSTRAINT `FK_asuvmal81ypbxlam92s1demc` FOREIGN KEY (`id_type`) REFERENCES `type_document` (`id_type`);

--
-- Constraints for table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `FK_jh1mlcmexao5cetcsm3eq129k` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`);

--
-- Constraints for table `examen`
--
ALTER TABLE `examen`
  ADD CONSTRAINT `FK_81ccnwj97m2aon3cjitnompc` FOREIGN KEY (`id_matiere`) REFERENCES `module` (`id_module`);

--
-- Constraints for table `fichier`
--
ALTER TABLE `fichier`
  ADD CONSTRAINT `FK_r9jdqkh3tvyg1bd072mupa1qw` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`);

--
-- Constraints for table `formation_module`
--
ALTER TABLE `formation_module`
  ADD CONSTRAINT `FK_25j4a6epi1ibnu76d5bd6mjfk` FOREIGN KEY (`id_module`) REFERENCES `module` (`id_module`);

--
-- Constraints for table `formation_niveau`
--
ALTER TABLE `formation_niveau`
  ADD CONSTRAINT `FK_asc22d30ij3u6t8sci2no3ffr` FOREIGN KEY (`id_niveau`) REFERENCES `niveau` (`id_niveau`);

--
-- Constraints for table `formation_typeformation`
--
ALTER TABLE `formation_typeformation`
  ADD CONSTRAINT `FK_ltqj6w0mhdpay8n3s0nwolhsj` FOREIGN KEY (`id_type_formation`) REFERENCES `type_formaton` (`id_type_formation`);

--
-- Constraints for table `group_right_table`
--
ALTER TABLE `group_right_table`
  ADD CONSTRAINT `FK_1j03vbbmyk0u4euu8uns7u6vc` FOREIGN KEY (`right_id`) REFERENCES `rights` (`id`),
  ADD CONSTRAINT `FK_p8u7g4u0xemtu8xq9bate485v` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`);

--
-- Constraints for table `group_user_table`
--
ALTER TABLE `group_user_table`
  ADD CONSTRAINT `FK_msi6c7tta106lgv9oejau0dpi` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`);

--
-- Constraints for table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `FK_dgyfu5cv70ac9bvlyrg6xqt0q` FOREIGN KEY (`id_utilisateur`) REFERENCES `etudiant` (`id`);

--
-- Constraints for table `matiere`
--
ALTER TABLE `matiere`
  ADD CONSTRAINT `FK_mj4gim5h23v68eny4v31qb7e2` FOREIGN KEY (`id_module`) REFERENCES `module` (`id_module`);

--
-- Constraints for table `matiere_modules`
--
ALTER TABLE `matiere_modules`
  ADD CONSTRAINT `FK_1qil9l2o1uhy20e1tqhokymrj` FOREIGN KEY (`matiere`) REFERENCES `matiere` (`id_matiere`),
  ADD CONSTRAINT `FK_6ax440gnmbyx8rc7cn98otdr0` FOREIGN KEY (`modules`) REFERENCES `module` (`id_module`);

--
-- Constraints for table `message_classe`
--
ALTER TABLE `message_classe`
  ADD CONSTRAINT `FK_71b3ke6qw0tkj9r6hqlc4hxkl` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id_classe`);

--
-- Constraints for table `module_matieres`
--
ALTER TABLE `module_matieres`
  ADD CONSTRAINT `FK_cbjicd81sfcd81munt5wqcx5t` FOREIGN KEY (`matieres`) REFERENCES `matiere` (`id_matiere`),
  ADD CONSTRAINT `FK_jjeugoe617od9xcmbua7f4api` FOREIGN KEY (`module`) REFERENCES `module` (`id_module`);

--
-- Constraints for table `module_semestre`
--
ALTER TABLE `module_semestre`
  ADD CONSTRAINT `FK_25lerh9fk52acois0pqu1f116` FOREIGN KEY (`id_module`) REFERENCES `module` (`id_module`),
  ADD CONSTRAINT `FK_cl2v194tlgchi0x3jdxfie6db` FOREIGN KEY (`id_semestre`) REFERENCES `semestre` (`id_semestre`);

--
-- Constraints for table `niveau_formations`
--
ALTER TABLE `niveau_formations`
  ADD CONSTRAINT `FK_n66ekpm85vxgnbjllrd11i9px` FOREIGN KEY (`niveau`) REFERENCES `niveau` (`id_niveau`);

--
-- Constraints for table `niveau_semestres`
--
ALTER TABLE `niveau_semestres`
  ADD CONSTRAINT `FK_jan6u5h7a56n4jlwpihfc8e79` FOREIGN KEY (`niveau`) REFERENCES `niveau` (`id_niveau`),
  ADD CONSTRAINT `FK_stm647nagvoj5px953tgve994` FOREIGN KEY (`semestres`) REFERENCES `semestre` (`id_semestre`);

--
-- Constraints for table `notif_user`
--
ALTER TABLE `notif_user`
  ADD CONSTRAINT `FK_haowh09t70hxu7kpg4bdvmgry` FOREIGN KEY (`id_notification`) REFERENCES `notification` (`id_notif`);

--
-- Constraints for table `question_test`
--
ALTER TABLE `question_test`
  ADD CONSTRAINT `FK_4uiixbvi86uww8eh17cfva886` FOREIGN KEY (`id_test`) REFERENCES `test_en_ligne` (`id_devoir`);

--
-- Constraints for table `reservation_materiel`
--
ALTER TABLE `reservation_materiel`
  ADD CONSTRAINT `FK_7f949ohc2jg1rn481kotmxlab` FOREIGN KEY (`id_materiel`) REFERENCES `materiel` (`id_materiel`);

--
-- Constraints for table `reservation_salle`
--
ALTER TABLE `reservation_salle`
  ADD CONSTRAINT `FK_ivm2wlcmpqailkp3q8cchhi5f` FOREIGN KEY (`id_salle`) REFERENCES `salle` (`id_salle`);

--
-- Constraints for table `resultat_test_enligne`
--
ALTER TABLE `resultat_test_enligne`
  ADD CONSTRAINT `FK_3avmyxywhc4vkbreuk8boqaq1` FOREIGN KEY (`id_etudiant`) REFERENCES `etudiant` (`id`),
  ADD CONSTRAINT `FK_50ib6jfllfeyka76j2m15l9cs` FOREIGN KEY (`id_test`) REFERENCES `test_en_ligne` (`id_devoir`);

--
-- Constraints for table `seance`
--
ALTER TABLE `seance`
  ADD CONSTRAINT `FK_b3ho1ne0hdadqbohbghhleruk` FOREIGN KEY (`id_matiere`) REFERENCES `matiere` (`id_matiere`),
  ADD CONSTRAINT `FK_h30jdw4gitybw0owwu08bqkfm` FOREIGN KEY (`id_salle`) REFERENCES `salle` (`id_salle`);

--
-- Constraints for table `semestre`
--
ALTER TABLE `semestre`
  ADD CONSTRAINT `FK_nohv6cqx4u9toyegfj7ng83aj` FOREIGN KEY (`id_niveau`) REFERENCES `niveau` (`id_niveau`);

--
-- Constraints for table `test_en_ligne`
--
ALTER TABLE `test_en_ligne`
  ADD CONSTRAINT `FK_pcmpmce500pxoqno57pr9nr7e` FOREIGN KEY (`id_matiere`) REFERENCES `module` (`id_module`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
