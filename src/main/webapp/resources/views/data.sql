INSERT INTO `rights` (`id`, `category`, `deletable`, `disc`, `name`) VALUES
(1, 'gestion des droits d''accès', false, '', ' les droirts '),
(2, 'gestion des droits d''accès', false, '', ' les utilisateur '),
(3, 'gestion des droits d''accès', false, '', ' les groupes ');

INSERT INTO `users` (`id`, `adresse_utilisateur`, `cin`, `date_inscription`, `date_naissance`, `deletable`, `email`, `etat_compte`, `first_name`, `last_name`, `password`, `pays_naissance`, `profession_utilisateur`, `sexe`, `tel_fix_utilisateur`, `tel_utilisateur`, `telephone`, `ville_naissance`) VALUES
(1, NULL, NULL, NULL, NULL,false, 'admin@admin.com', NULL, 'admin', 'admin', 'admin', NULL, NULL, NULL, NULL, NULL, '06668845122', NULL),
(2, NULL, NULL, NULL, NULL,false, 'user@user.com', NULL, 'user', 'user', 'user', NULL, NULL, NULL, NULL, NULL, '06258866658', NULL);

INSERT INTO `groups` (`id`, `deletable`, `group_name`) VALUES
(1, b'0', 'admin'),
(2, b'0', 'etudiant'),
(3, b'0', 'enseignant permanent'),
(4, b'0', 'enseignant vacataire');

INSERT INTO `group_right_table` (`right_id`, `group_id`) VALUES
(1, 1),
(2, 1),
(3, 1);

INSERT INTO `group_user_table` (`user_id`, `group_id`) VALUES
(1, 1);
INSERT INTO `annee_scolaire` (`id_anne`, `desc_anne`, `annee_debut`, `annee_fin`) VALUES
(1, 'fitst', '2010', '2011'),
(2, 'second', '2011', '2012'),
(3, ' 3 ', '2013', '2014'),
(4, ' 4 ', '2014', '2015'),
(5, ' 5 ', '2015', '2016');
--INSERT INTO `inscription` (`id_inscription`, `date_insc`, `diponibilitè`, `numero_insc`, `id_utilisateur`, `id_formation`) VALUES
--(1, '2016-04-14 00:00:00', 'lundi prochain', '12/empsi/2016', 1, NULL),
--(2, '2016-04-29 00:00:00', 'now', '21/empsi/206', 2, NULL);
