CREATE TABLE Customer
(
    customerid     int NOT NULL AUTO_INCREMENT,
    customerName   varchar(255),
    address        varchar(255),
    email          varchar(255),
    phone          varchar(255),
    creditCardInfo varchar(255),
    shippingInfo   varchar(255),
    PRIMARY KEY (customerid)
);