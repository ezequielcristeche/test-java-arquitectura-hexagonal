DROP TABLE PRICES IF EXISTS CASCADE;

CREATE TABLE PRICES (
   ID BIGINT(20) NOT NULL,
   BRAND_ID BIGINT(20) NOT NULL,
   START_DATE TIMESTAMP NOT NULL,
   END_DATE TIMESTAMP NOT NULL,
   PRICE_LIST BIGINT NOT NULL,
   PRODUCT_ID BIGINT NOT NULL,
   PRIORITY BIGINT NOT NULL,
   PRICE DECIMAL(13,2) NOT NULL,
   CURRENCY VARCHAR(60) NOT NULL,
   PRIMARY KEY (ID),
   CONSTRAINT prices_brand_fk FOREIGN KEY (BRAND_ID) REFERENCES brands (ID) ON UPDATE CASCADE);

INSERT INTO PRICES
(ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURRENCY)
VALUES (1, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR');

INSERT INTO PRICES
(ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURRENCY)
VALUES (2, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR');

INSERT INTO PRICES
(ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURRENCY)
VALUES (3, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR');

INSERT INTO PRICES
(ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURRENCY)
VALUES (4, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');


