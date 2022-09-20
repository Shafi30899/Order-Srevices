CREATE TABLE pricedetails(
id INT  PRIMARY KEY AUTO_INCREMENT
,retailprice INT NOT NULL
,sellingprice INT NOT NULL
,shippingcharges INT NOT NULL
);

CREATE TABLE item(
 id INT PRIMARY KEY AUTO_INCREMENT
,itemname VARCHAR(20)
,itemdescription VARCHAR(50)
,priceid INT UNIQUE
,FOREIGN KEY (priceid)REFERENCES pricedetails(id)
);

CREATE TABLE orders(
  id         BIGINT PRIMARY KEY AUTO_INCREMENT
,createdBy   VARCHAR(20) NOT NULL
,updatedBy   VARCHAR(20) NOT NULL
,orderId     VARCHAR(20) NOT NULL
,frId        VARCHAR(20) NOT NULL
,storeNumber INT  NOT NULL
,orderStatus VARCHAR(20) NOT NULL
,orderType   VARCHAR(20) NOT NULL
,notes       VARCHAR(50) NOT NULL
);

CREATE TABLE orderalerts(
  id               BIGINT PRIMARY KEY AUTO_INCREMENT
,createdBy        VARCHAR(20) NOT NULL
,updatedBy        VARCHAR(20) NOT NULL
,alertType        VARCHAR(20) NOT NULL
,alertDescription VARCHAR(50) NOT NULL
,reProcessable    BOOLEAN  NOT NULL
,isactive           BOOLEAN  NOT NULL
,orderid BIGINT
,FOREIGN KEY (orderid)REFERENCES orders(id)
);

CREATE TABLE orderevents(
  id               BIGINT PRIMARY KEY AUTO_INCREMENT
,createdBy        VARCHAR(20) NOT NULL
,updatedBy        VARCHAR(20) NOT NULL
,eventName        VARCHAR(20) NOT NULL
,eventDescription VARCHAR(50) NOT NULL
,orderid BIGINT
,FOREIGN KEY (orderid)REFERENCES orders(id)
);

CREATE TABLE orderline(
  id                BIGINT PRIMARY KEY AUTO_INCREMENT
,createdBy         VARCHAR(20) NOT NULL
,updatedBy         VARCHAR(20) NOT NULL
,lineNumber        INT  NOT NULL
,frLineId          INT  NOT NULL
,lineStatus        VARCHAR(20) NOT NULL
,carrier           VARCHAR(20) NOT NULL
,shipMode          VARCHAR(20) NOT NULL
,sourceFacility    INT  NOT NULL
,orderedQuantity   INT  NOT NULL
,shippedQuantity   INT  NOT NULL
,invoicedQuantity  INT  NOT NULL
,cancelledQuantity INT  NOT NULL
,availableQuantity INT  NOT NULL
,cancelTimeStamp   VARCHAR(30)
,cancelReason      VARCHAR(30) NOT NULL
,iscancelable        BOOLEAN  NOT NULL
,orderid BIGINT
,itemid INT
,FOREIGN KEY (orderid)REFERENCES orders(id)
,FOREIGN KEY (itemid) REFERENCES item(id)
);


CREATE TABLE packages(
  id               BIGINT PRIMARY KEY AUTO_INCREMENT
,createTimeStamp  VARCHAR(30)
,updateTimeStamp  VARCHAR(30)
,createdBy        VARCHAR(5) NOT NULL
,updatedBy        VARCHAR(3) NOT NULL
,quantity         INT  NOT NULL
,packageId        VARCHAR(10) NOT NULL
,shippedTimeStamp VARCHAR(30)
,trackingNumber   VARCHAR(20) NOT NULL
,carrier          VARCHAR(20) NOT NULL
,serviceLevel     VARCHAR(20) NOT NULL
,attribute VARCHAR(50) NOT NULL
,orderlines BIGINT
,FOREIGN KEY (orderlines)REFERENCES orderline(id)
);



