		CREATE TABLE IF NOT EXISTS pessoa(
		id BIGINT(20) PRIMARY KEY AUTO_INCREMENT NOT NULL,
		nome VARCHAR(50) NOT NULL,
		idade INT(3) NOT NULL,
		sexo VARCHAR(10) NOT NULL
		)ENGINE=InnODB DEFAULT CHARSET=UTF8;
		
		INSERT INTO pessoa(nome, idade, sexo) values ('José', 20, 'Masculino');
		INSERT INTO pessoa(nome, idade, sexo) values ('Alexandre', 29, 'Masculino');
		INSERT INTO pessoa(nome, idade, sexo) values ('Rebeca', 24, 'Feminino');
		INSERT INTO pessoa(nome, idade, sexo) values ('Rosana', 32, 'Feminino');
		INSERT INTO pessoa(nome, idade, sexo) values ('Bruna', 13, 'Feminino');