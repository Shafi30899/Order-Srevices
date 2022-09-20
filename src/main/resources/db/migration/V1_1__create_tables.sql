CREATE TABLE price_details(
id INT  PRIMARY KEY AUTO_INCREMENT
,retail_price INT NOT NULL
,selling_price INT NOT NULL
,shipping_charges INT NOT NULL
);

CREATE TABLE item(
 id INT PRIMARY KEY AUTO_INCREMENT
,item_name VARCHAR(20)
,item_description VARCHAR(50)
,priceid INT UNIQUE
,FOREIGN KEY (priceid)REFERENCES price_details(id)
);

CREATE TABLE orders(
  id         BIGINT PRIMARY KEY AUTO_INCREMENT
,created_by   VARCHAR(20) NOT NULL
,updated_by   VARCHAR(20) NOT NULL
,order_id     VARCHAR(20) NOT NULL
,fr_id        VARCHAR(20) NOT NULL
,store_number INT  NOT NULL
,order_status VARCHAR(20) NOT NULL
,order_type   VARCHAR(20) NOT NULL
,notes       VARCHAR(50) NOT NULL
);

CREATE TABLE order_alerts(
  id               BIGINT PRIMARY KEY AUTO_INCREMENT
,created_by        VARCHAR(20) NOT NULL
,updated_by        VARCHAR(20) NOT NULL
,alert_type        VARCHAR(20) NOT NULL
,alert_description VARCHAR(50) NOT NULL
,re_processable    BOOLEAN  NOT NULL
,is_active           BOOLEAN  NOT NULL
,orderid BIGINT
,FOREIGN KEY (orderid)REFERENCES orders(id)
);

CREATE TABLE order_events(
  id               BIGINT PRIMARY KEY AUTO_INCREMENT
,created_by        VARCHAR(20) NOT NULL
,updated_by        VARCHAR(20) NOT NULL
,event_name        VARCHAR(20) NOT NULL
,event_description VARCHAR(50) NOT NULL
,orderid BIGINT
,FOREIGN KEY (orderid)REFERENCES orders(id)
);

CREATE TABLE order_line(
  id                BIGINT PRIMARY KEY AUTO_INCREMENT
,created_by         VARCHAR(20) NOT NULL
,updated_by         VARCHAR(20) NOT NULL
,line_number        INT  NOT NULL
,fr_line_id          INT  NOT NULL
,line_status        VARCHAR(20) NOT NULL
,carrier           VARCHAR(20) NOT NULL
,ship_mode          VARCHAR(20) NOT NULL
,source_facility    INT  NOT NULL
,ordered_quantity   INT  NOT NULL
,shipped_quantity   INT  NOT NULL
,invoiced_quantity  INT  NOT NULL
,cancelled_quantity INT  NOT NULL
,available_quantity INT  NOT NULL
,cancel_time_stamp   VARCHAR(30)
,cancel_reason      VARCHAR(30) NOT NULL
,is_cancelable        BOOLEAN  NOT NULL
,orderid BIGINT
,itemid INT
,FOREIGN KEY (orderid)REFERENCES orders(id)
,FOREIGN KEY (itemid) REFERENCES item(id)
);


CREATE TABLE packages(
  id               BIGINT PRIMARY KEY AUTO_INCREMENT
,create_time_stamp  VARCHAR(30)
,update_time_stamp  VARCHAR(30)
,created_by        VARCHAR(5) NOT NULL
,updated_by        VARCHAR(3) NOT NULL
,quantity         INT  NOT NULL
,package_id        VARCHAR(10) NOT NULL
,shipped_time_stamp VARCHAR(30)
,tracking_number   VARCHAR(20) NOT NULL
,carrier          VARCHAR(20) NOT NULL
,service_level     VARCHAR(20) NOT NULL
,attribute VARCHAR(50) NOT NULL
,orderlines BIGINT
,FOREIGN KEY (orderlines)REFERENCES order_line(id)
);



