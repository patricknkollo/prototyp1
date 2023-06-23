CREATE TABLE OrderDetail
(
    orderdetailid int NOT NULL AUTO_INCREMENT,
    productId  int,
    productName VARCHAR(255),
    quantity   int,
    uniCoast   double,
    subtotal   double,
    PRIMARY KEY (orderdetailid),
    FOREIGN KEY (productId) REFERENCES Product(productId)
);