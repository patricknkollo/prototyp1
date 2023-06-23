CREATE TABLE Product
(
    cartid        int NOT NULL AUTO_INCREMENT,
    productId     int,
    name          varchar(255),
    description   varchar(255),
    price         double,
    imageFileName varchar(255),
    PRIMARY KEY (cartId)
);