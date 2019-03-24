CREATE TABLE `users` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`first_name` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '',
	`last_name` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
	`email` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
	`handle` VARCHAR(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
	UNIQUE KEY `unique_email` (`email`) USING BTREE,
    UNIQUE KEY `unique_handle` (`handle`) USING BTREE,
	PRIMARY KEY (`id`)
);

CREATE TABLE `tweets` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`user_id` INT(11) NOT NULL,
	`tweet` VARCHAR(256) NOT NULL,
	`tweet_date` DATETIME NOT NULL,
	PRIMARY KEY (`id`)
);


CREATE TABLE `followers` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`followed` INT(11) NOT NULL,
	`follower` INT(11),
	PRIMARY KEY (`id`)
);