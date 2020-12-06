CREATE TABLE `Accounts` (
        `id` bigint NOT NULL AUTO_INCREMENT,
        `login` varchar(255) NOT NULL UNIQUE,
        `password` varchar(255) NOT NULL,
        `accountstatus` varchar(255) NOT NULL,
        PRIMARY KEY (`id`)
);

CREATE TABLE `Skills` (
          `id` bigint NOT NULL AUTO_INCREMENT,
          `name` varchar(255) NOT NULL UNIQUE,
          PRIMARY KEY (`id`)
);

CREATE TABLE `accountstatus` (
         `status` varchar(255) NOT NULL,
         PRIMARY KEY (`status`)
);

CREATE TABLE `developers` (
      `accountid` bigint NOT NULL,
      `skillid` bigint NOT NULL
);

ALTER TABLE `Accounts` ADD CONSTRAINT `Accounts_fk0` FOREIGN KEY (`accountstatus`) REFERENCES `accountstatus`(`status`) ON DELETE CASCADE;

ALTER TABLE `developers` ADD CONSTRAINT `developers_fk0` FOREIGN KEY (`accountid`) REFERENCES `Accounts`(`id`) ON DELETE CASCADE;

ALTER TABLE `developers` ADD CONSTRAINT `developers_fk1` FOREIGN KEY (`skillid`) REFERENCES `Skills`(`id`) ON DELETE CASCADE;

ALTER TABLE `developers` ADD UNIQUE(`accountid`,`skillid`);

INSERT INTO accountstatus values ('DELETED');
INSERT INTO accountstatus values ('BANNED');
INSERT INTO accountstatus values ('ACTIVE');