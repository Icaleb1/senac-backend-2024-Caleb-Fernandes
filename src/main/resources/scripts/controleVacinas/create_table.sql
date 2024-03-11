DROP DATABASE IF EXISTS controle_vacinas;

CREATE DATABASE controle_vacinas;

USE controle_vacinas;

CREATE TABLE IF NOT EXISTS controle_vacinas.pessoa (
	id INT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    dataNascimento DATE NOT NULL,
	sexo VARCHAR(50) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    tipoPessoa VARCHAR(255) NOT NULL,
    avaliacao INT NOT NULL,
	CONSTRAINT pessoa_pk PRIMARY KEY (id)
);