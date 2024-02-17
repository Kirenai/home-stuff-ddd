CREATE TABLE IF NOT EXISTS `hs_user`.`users`
(
    `user_id`    INT          NOT NULL AUTO_INCREMENT,
    `username`   VARCHAR(45)  NULL,
    `password`   VARCHAR(255) NULL,
    `first_name` VARCHAR(30)  NULL,
    `last_name`  VARCHAR(30)  NULL,
    `age`        INT          NULL,
    PRIMARY KEY (`user_id`),
    CONSTRAINT `unq_username` UNIQUE (`username`)
);