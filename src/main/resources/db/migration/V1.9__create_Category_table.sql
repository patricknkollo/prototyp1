CREATE TABLE Category
(
    categoryid   int NOT NULL AUTO_INCREMENT,
    departmentId int,
    categoryName VARCHAR(255),
    description  VARCHAR(255),
    PRIMARY KEY (categoryid)
);