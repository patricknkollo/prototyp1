CREATE TABLE SessionManager
(
    userid int NOT NULL AUTO_INCREMENT,
    departmentName VARCHAR(255),
    PRIMARY KEY (userid)
--FOREIGN KEY (departmentName) REFERENCES Product(departmentName)
);