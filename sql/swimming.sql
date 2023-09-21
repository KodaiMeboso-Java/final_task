DROP TABLE IF EXISTS swimmers;

CREATE TABLE swimmers (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  stroke VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO swimmers (id, name, stroke) VALUES (1,'目細広大','平泳ぎ');
INSERT INTO swimmers (id, name, stroke) VALUES (2,'入江凌介','背泳ぎ');
INSERT INTO swimmers (id, name, stroke) VALUES (3,'瀬戸大也','個人メドレー');
