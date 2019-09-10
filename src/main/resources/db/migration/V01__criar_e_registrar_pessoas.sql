		CREATE TABLE IF NOT EXISTS pessoa(
		id BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
		nome VARCHAR(50) NOT NULL,
		idade INT(3) NOT NULL
		)ENGINE=InnODB DEFAULT CHARSET=UTF8;
		
		INSERT INTO pessoa(nome, idade) values ('José', 20);
		INSERT INTO pessoa(nome, idade) values ('Alexandre', 29);
		INSERT INTO pessoa(nome, idade) values ('Rebeca', 24);
		INSERT INTO pessoa(nome, idade) values ('Rosana', 32);
		INSERT INTO pessoa(nome, idade) values ('Bruna', 13);