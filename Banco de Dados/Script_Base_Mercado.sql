DROP table if EXISTS professores;

CREATE TABLE professores(
	professor_id SERIAL not NULL,
	nome varchar(40),
	dominio1 varchar(40),
	dominio2 varchar(40),
	dominio3 varchar(40));
	
INSERT INTO professores (nome, dominio1, dominio2, dominio3)
	VALUES ('Sandro Saorin', 'SQL', 'Estatistica', 'Data Science');

INSERT INTO professores (nome, dominio1, dominio2, dominio3)
	values ('Willian', 'Web 1', 'POO', 'Back-End'),
			('Alex', 'POO', 'POO 2', 'Cloud'),
			('Gabriela', 'POO 2', 'Padores de Projeto', 'Java');
			
update professores
set nome = 'Sandro'
where professor_id = 1;


update professores
set dominio3 = 'XML'


CREATE TABLE alunos(
	professor_id integer UNIQUE not NULL,
	nome varchar(40),
	dominio1 varchar(40),
	dominio2 varchar(40),
	dominio3 varchar(40));

INSERT INTO alunos (professor_id, nome, dominio1, dominio2, dominio3)
	values (2, 'Joao', 'Web 1', 'POO', 'Back-End'),
			(3, 'Pedro', 'POO', 'POO 2', 'Cloud'),
			(4, 'Victor', 'POO 2', 'Padores de Projeto', 'Java');

drop table mercado;
create table mercado(
	produto_id integer UNIQUE NOT NULL,
	nome_produto varchar(40),
	tipo_produto varchar(40),
	estoque integer CHECK (estoque > 0),
	valor_produto NUMERIC(8,2) DEFAULT 0.0);

INSERT INTO mercado (produto_id, nome_produto, tipo_produto) 
	VALUES (1, 'Leite', 'Laticinios'),
	(2, 'Pão', 'Massa'),
	(3, 'Mortadela', 'Frios'),
	(4, 'Arroz', 'Grãos'),
	(5, 'Macarrão', 'Massas'),
	(6, 'Queijo', 'Laticinios'),
	(7, 'Miojo', 'Massa'),
	(8, 'Lasanha', 'Massa'),
	(9, 'Manteiga', 'Laticinios'),
	(10, 'Biscoito', 'Doces'),
	(11, 'Donut', 'Doces'),
	(12, 'Bolacha doce', 'Doces'),
	(13, 'Bolacha de água e sal', 'Massa'),
	(14, 'Café', 'Grãos');

drop table estoque;
create table estoque(
	produto_id integer unique not null,
	nome_produto varchar(40),
	tipo_produto varchar(40),
	estoque integer check (estoque > 0),
	valor_produto numeric(8, 2) default 0.0);
	


insert into estoque (produto_id, nome_produto, tipo_produto, estoque, valor_produto)
	values (1, )

update mercado set estoque = 5 where produto_id = 1;

update mercado set estoque = 10
where produto_id = 2;
update mercado set estoque = 15
where produto_id = 3;
update mercado set estoque = 7
where produto_id = 4;
update mercado set estoque = 9
where produto_id = 5;
update mercado set estoque = 20
where produto_id = 6;
update mercado set estoque = 13
where produto_id = 7;
update mercado set estoque = 11
where produto_id = 8;
update mercado set estoque = 1
where produto_id = 9;

update mercado set estoque = 1
where produto_id = 10;
update mercado set estoque = 33
where produto_id = 11;
update mercado set estoque = 27
where produto_id = 12;
update mercado set estoque = 3
where produto_id = 13;
update mercado set estoque = 50
where produto_id = 14;
update mercado set valor_produto = 23
where produto_id = 1;
update mercado set valor_produto = 30
where produto_id = 2;
update mercado set valor_produto = 13
where produto_id = 3;
update mercado set valor_produto = 17
where produto_id = 4;
update mercado set valor_produto = 16.90
where produto_id = 5;
update mercado set valor_produto = 19.9
where produto_id = 6;
update mercado set valor_produto = 13.4
where produto_id = 7;
update mercado set valor_produto = 12.9
where produto_id = 8;
update mercado set valor_produto = 9.99
where produto_id = 9;
update mercado set valor_produto = 10.25
where produto_id = 10;
update mercado set valor_produto = 24.56
where produto_id = 11;
update mercado set valor_produto = 13.75
where produto_id = 12;
update mercado set valor_produto = 11.33
where produto_id = 13;
update mercado set valor_produto = 19.25
where produto_id = 14;

