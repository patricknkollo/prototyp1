CREATE TABLE CartItem
(
    cartItemId int NOT NULL AUTO_INCREMENT,
    productId  int,
    quantity   int,
    uniCoast   double,
    subtotal   double,
    PRIMARY KEY (cartItemId)
);