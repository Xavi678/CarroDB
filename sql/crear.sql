DROP DATABASE IF EXISTS CarroCompra1;
CREATE DATABASE CarroCompra1;
use CarroCompra1;
DROP TABLE IF EXISTS Productes;
DROP TABLE IF EXISTS usuaris;
DROP TABLE IF EXISTS CARRO;





CREATE TABLE usuaris(
login varchar(100) primary key not null,
password varchar(100) not null);

CREATE TABLE Productes(
id int not null primary key auto_increment,
nom varchar(100) not null,
disponibilitat int not null,
descripcio varchar(100) not null,
preu int not null,
propietari varchar(100) not null,
data varchar(100) not null,

foreign key(propietari) references usuaris(login)
 on update cascade
 on delete cascade)ENGINE=INNODB;
 
 
 
 create table carro(
     id int not null,
     nom varchar(100) not null,
     disponibilitat int not null,
     descripcio varchar(100) not null,
     preu int not null,
    propietari varchar(100) not null,
    primary key(id,propietari),
    
     foreign key(propietari) references usuaris(login)
      on update cascade
    on delete cascade
   , foreign key(id) references productes(id) on update cascade on delete cascade)ENGINE=INNODB;
   
 delimiter |

CREATE TRIGGER testref AFTER insert ON carro
  FOR EACH ROW
  BEGIN   
    UPDATE productes SET productes.disponibilitat = productes.disponibilitat - 1 WHERE productes.id = new.id;
  END;



CREATE TRIGGER testref2 AFTER update ON carro
  FOR EACH ROW
  BEGIN   
    UPDATE productes SET productes.disponibilitat = productes.disponibilitat -1 WHERE productes.id = new.id;
  END;
  
  
  
 
CREATE TRIGGER borrar AFTER delete ON carro
  FOR EACH ROW
  BEGIN   
    UPDATE productes SET productes.disponibilitat = productes.disponibilitat +old.disponibilitat WHERE productes.id = old.id;
  END;
  |
  
  delimiter ;
 