CREATE TABLE aluno (
    id INT PRIMARY KEY AUTO_INCREMENT,
    CPF VARCHAR(11) UNIQUE,
	nome VARCHAR(255),
    data_nascimento varchar(15),
    peso_inicial DECIMAL(5,2),
    altura DECIMAL(5,2) 
);

CREATE TABLE historicopeso (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_aluno INT,
    peso_novo DECIMAL(5,2),
    data_novo_peso varchar(15),
    FOREIGN KEY (id_aluno) REFERENCES aluno(id) ON UPDATE CASCADE ON DELETE CASCADE
);

