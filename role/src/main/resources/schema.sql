CREATE TABLE IF NOT EXISTS `hs_role`.`roles`
(
    `role_id` INT         NOT NULL AUTO_INCREMENT,
    `name`    VARCHAR(45) NULL,
    PRIMARY KEY (`role_id`),
    CONSTRAINT `unq_name` UNIQUE (`name`)
);

CREATE TABLE IF NOT EXISTS `hs_role`.`roles_users`
(
    `role_id` INT NULL,
    `user_id` INT NULL,
    CONSTRAINT `fk_role` FOREIGN KEY (`role_id`) REFERENCES `hs_role`.`roles` (`role_id`)
);