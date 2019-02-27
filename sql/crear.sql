DROP DATABASE IF EXISTS CarroCompra;
DROP TABLE IF EXISTS Productes;
DROP TABLE IF EXISTS usuaris;
DROP TABLE IF EXISTS CARRO;

CREATE DATABASE CarroCompra;

use CarroCompra;

CREATE TABLE usuaris(
login varchar(100) primary key not null,
password varchar(100) not null));

CREATE TABLE Productes(
id int not null primary key auto_increment,
nom varchar(100) not null,
disponibilitat int not null,
descripcio varchar(100) not null,
preu int not null,
propietari varchar(100) not null,

foreign key(propietari) references usuaris(login)
 on update cascade
 on delete cascade)ENGINE=INNODB;
 
 
 
 create table carro(
     id int not null primary key,
     nom varchar(100) not null,
     disponibilitat int not null,
     descripcio varchar(100) not null,
     preu int not null,
    propietari varchar(100) not null,
     foreign key(propietari) references usuaris(login)
      on update cascade
    on delete cascade
   , foreign key(id) references productes(id) on update cascade on delete cascade)ENGINE=INNODB;