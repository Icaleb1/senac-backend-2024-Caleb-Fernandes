SELECT * FROM controle_vacinas.vacinacao;
SELECT * FROM controle_vacinas.vacina;
SELECT * FROM controle_vacinas.pessoa;
SELECT * FROM controle_vacinas.pais;

INSERT INTO controle_vacinas.pais (nome, sigla) VALUES ('Brasil', 'BR'), ('Albânia', 'AL'),('Argélia', 'DZ'),('Angola', 'AO'),
('Argentina', 'AR'),('Armênia', 'AM'),('Austrália', 'AU');

INSERT INTO controle_vacinas.pessoa (id_pais, nome, data_nascimento, sexo, cpf, tipo_pessoa) VALUES 
(1, 'Caleb Fernandes', '2004-12-08', 'M', '99999999999', 1),
(2, 'Jonh Smith', '2001-12-08', 'M', '19999999999', 2),
(3, 'Ana Clara', '2002-12-01', 'F', '12999999999', 3),
(4, 'Ana Silva', '2005-12-08', 'F', '12399999999', 1);


INSERT INTO controle_vacinas.vacina (id_pesquisador, id_pais_origem, nome, estagio_pesquisa, data_inicio) VALUES 
(2, 1, 'heroína', 2, "2024-04-04"),
(1, 1, 'Cocaína', 3, "2024-04-05");

INSERT INTO controle_vacinas.vacinacao (id_pessoa, id_vacina, data_aplicacao, avaliacao) VALUES 
(1, 1, '2024-02-02', 3),
(2, 1, '2024-02-01', 4),
(3, 2, '2024-02-05', 3);
