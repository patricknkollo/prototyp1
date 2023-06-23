CREATE TABLE ShoppingCart
(
    cartId    int NOT NULL AUTO_INCREMENT,
    productId int NOT NULL,
    quantity  int,
    PRIMARY KEY (cartId),
    FOREIGN KEY (productId) REFERENCES Product (productId)
);