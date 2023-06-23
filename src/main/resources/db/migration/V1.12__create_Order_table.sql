CREATE TABLE Orders
(
    orderid      int NOT NULL AUTO_INCREMENT,
    dateCreated  date,
    dateShipped  date,
    customerName VARCHAR(255),
    customerId   int,
    status       VARCHAR(255),
    shippingId   int,
    PRIMARY KEY (orderid),
    FOREIGN KEY (customerId) REFERENCES customer (customerId),
    FOREIGN KEY (shippingId) REFERENCES shippingInfo (shippingId)
);