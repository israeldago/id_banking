DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `users`;

-----------USERS TABLE CREATION------------------
CREATE TABLE `users` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `date_of_birth` date NOT NULL,
  `first_name` varchar(40),
  `identity_card_number` varchar(20) NOT NULL,
  `last_name` varchar(40),
  `password` varchar(40) NOT NULL,
  `registration_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `username` varchar(40) NOT NULL);

-----------ROLES TABLE CREATION------------------

CREATE TABLE `roles` (
  `id` int(11) PRIMARY KEY AUTO_INCREMENT,
  `app_role` varchar(255) NOT NULL,
  `user_id` int(11) NOT NULL,
  FOREIGN KEY (`user_id`) REFERENCES users(`id`) ON DELETE CASCADE);

