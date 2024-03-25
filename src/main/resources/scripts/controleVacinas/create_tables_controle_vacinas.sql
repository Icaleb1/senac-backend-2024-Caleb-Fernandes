DROP DATABASE IF EXISTS controle_vacinas;
CREATE DATABASE IF NOT EXISTS controle_vacinas;

USE controle_vacinas;


DROP TABLE IF EXISTS controle_vacinas.pais;
CREATE TABLE IF NOT EXISTS controle_vacinas.pais (
	id INT AUTO_INCREMENT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    sigla VARCHAR(50) NOT NULL,
    CONSTRAINT pais_pk PRIMARY KEY (id)
);

DROP TABLE IF EXISTS controle_vacinas.pessoa;
CREATE TABLE IF NOT EXISTS controle_vacinas.pessoa (
	id INT AUTO_INCREMENT NOT NULL,
    id_pais INT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    data_nascimento DATE NOT NULL,
	sexo VARCHAR(50) NOT NULL,
    cpf VARCHAR(11) UNIQUE NOT NULL,
    tipo_pessoa VARCHAR(255) NOT NULL,
	CONSTRAINT pessoa_pk PRIMARY KEY (id),
    CONSTRAINT id_pais FOREIGN KEY (id_pais) REFERENCES controle_vacinas.pais(id)
);

DROP TABLE IF EXISTS controle_vacinas.vacina;
CREATE TABLE IF NOT EXISTS controle_vacinas.vacina (
	id INT AUTO_INCREMENT NOT NULL,
    id_pesquisador INT NOT NULL,
    id_pais_origem INT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    estagio_pesquisa VARCHAR(255) NOT NULL,
    data_inicio DATE NOT NULL,
	CONSTRAINT vacina_pk PRIMARY KEY (id),
	CONSTRAINT id_pesquisador FOREIGN KEY (id_pesquisador) REFERENCES pessoa(id),
	CONSTRAINT id_pais_origem FOREIGN KEY (id_pais_origem) REFERENCES controle_vacinas.pais(id)
    
);

DROP TABLE IF EXISTS controle_vacinas.vacinacao;
CREATE TABLE IF NOT EXISTS controle_vacinas.vacinacao (
	id INT AUTO_INCREMENT NOT NULL,
    id_pessoa INT NOT NULL,
    id_vacina INT NOT NULL,
    data_aplicacao DATE NOT NULL,
    avaliacao INT NOT NULL,
    CONSTRAINT vacinacao_pk PRIMARY KEY (id),
	CONSTRAINT id_pessoa FOREIGN KEY (id_pessoa) REFERENCES controle_vacinas.pessoa(id),
    CONSTRAINT id_vacina FOREIGN KEY (id_vacina) REFERENCES controle_vacinas.vacina(id)

);

