DROP DATABASE coronakitdb;

CREATE DATABASE coronakitdb;

USE coronakitdb;

CREATE TABLE coronakit (
 pId INT(3) PRIMARY KEY,
 pName VARCHAR(255) NOT NULL,
 pDesc VARCHAR(255) NOT NULL, pCost INT(11) NOT NULL 
);

INSERT INTO coronakit (pId,pName,pDesc,pCost) VALUES

(1, "Sanitizer 50-ml", "Sanitizer protects from virus", 100),
(2, "Sanitizer 100-ml", "Sanitizer is made by Sun Pharma infections", 200),
(3, "Mask N-95", "Mask imported from America", 450),
(4, "Mask N-85", "N-85 Mask made in india", 300),
(5, "Dettol Soap 100 gm", "Soap by Pharma industries", 100),
(6, "Face Shield", "Protects From direct infection", 800),
(7, "Gloves", "Gloves are handy in opeartions", 450);