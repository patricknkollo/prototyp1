CREATE TABLE ShippingInfo
(
    shippingid       int NOT NULL AUTO_INCREMENT,
    shippingType     varchar(255),
    shippingCost     double,
    shippingRegionId int,
    PRIMARY KEY (shippingid)
);