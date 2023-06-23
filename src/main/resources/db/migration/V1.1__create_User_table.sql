CREATE TABLE user
(
    userid        int          NOT NULL AUTO_INCREMENT,
    password      varchar(255) NOT NULL,
    loggingStatus varchar(255),
    PRIMARY KEY (userid)
);