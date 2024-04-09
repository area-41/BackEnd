-- REVISÃO DA LISTA 1
-- Exercicio 1: Quantos itens distintos foram vendidos (item_id)?
SELECT 
	COUNT(DISTINCT item_id) AS quantidade
FROM sales;


-- Exercicio 2: Quantas lojas existem na base (loja_id)?
SELECT 
	COUNT(DISTINCT loja_id) AS qntde_lojas
FROM sales;


-- Exercicio 3: Qual é a cidade que mais tem lojas (loja_id)?
SELECT 
	cidade,
	COUNT(DISTINCT loja_id) AS qntde_lojas
FROM sales
GROUP BY 1
ORDER BY 2 DESC;


-- Exercicio 4: Em qual municipio foi vendido mais itens?
SELECT 
	municipio,
	SUM(garrafas_vendidas) AS itens_vendidos
FROM sales
GROUP BY 1
ORDER BY 2 DESC;


-- Exercicio 5: Qual a cidade mais vendeu em dolares?
SELECT 
	cidade,
	SUM(total_venda) AS total_cidade
FROM sales
GROUP BY 1
ORDER BY 2 DESC;


-- Exercicio 6: Qual foi o dia que mais vendeu itens distintos?
SELECT 
	data_pedido,
	COUNT(DISTINCT item_id) AS total_itens
FROM sales 
GROUP BY 1
ORDER BY 2 DESC;


-- Exercicio 7: Monte o top 5 bebidas (item_id) mais vendidas por valor?
SELECT 
	item_id,
	SUM(total_venda) AS total_vendas
FROM sales 
GROUP BY 1
ORDER BY 2 DESC
LIMIT 5;

-- OBSERVAÇAO: VERIFICANDO A COLUNA total_venda
SELECT 
	venda_garrafa*garrafas_vendidas AS total,
	total_venda
FROM sales;


-- Exercicio 8: Monte o top 5 bebidas (item_id) mais vendidas por volume em litros
SELECT
	item_id,
	sum(volume_litros_vendidos) AS total_volume
FROM sales 
GROUP BY 1
ORDER BY 2 DESC 
LIMIT 5;


-- Exercicio 9: Quais são as 10 empresas (marca_id) que mais lucram com a venda de bebidas?
SELECT 
	marca_id,
	SUM(venda_garrafa*garrafas_vendidas) AS total_venda,
	SUM(custo_garrafa*garrafas_vendidas) AS total_custo,
	SUM((venda_garrafa - custo_garrafa)*garrafas_vendidas) AS lucro
FROM sales
GROUP BY 1
ORDER BY 2 DESC 
LIMIT 10;


-- Exercicio 10: Monte uma tabela com a quantidade de vendas distintas por dia.
SELECT 
	data_pedido,
	COUNT(DISTINCT pedido_id) AS total_pedidos
FROM sales 
GROUP BY 1
ORDER BY 1;





-- JOINS e UNIONS
CREATE TABLE correntista(
	cliente_id integer PRIMARY KEY,
	nome varchar(40),
	cidade varchar(40));

CREATE TABLE saldo(
	cliente_id integer REFERENCES "correntista" (cliente_id),
	saldo NUMERIC(16,2));

CREATE TABLE tipo_transacao(
	tipo_transacao_id integer PRIMARY KEY,
	nome_transacao varchar(40));

CREATE TABLE transacoes(
	transacao_id integer PRIMARY KEY,
	cliente_id integer REFERENCES "correntista" (cliente_id),
	tipo_transacao_id integer REFERENCES "tipo_transacao" (tipo_transacao_id),
	valor numeric (8,2));

INSERT INTO correntista (cliente_id, nome, cidade)
	VALUES  (1,'Francisco','São Paulo'),
			(2,'João','São Paulo'),
			(3,'Lúcia','Rio de Janeiro'),
			(4,'Rosana','São Paulo'),
			(5,'Laura','São Paulo'),
			(6,'Pedro','São Paulo'),
			(7,'Cristina','Rio de Janeiro'),
			(8,'Rosangela','São Paulo'),
			(9,'Augusto','Rio de Janeiro'),
			(10,'Cecilia','Rio de Janeiro');

INSERT INTO saldo (cliente_id, saldo)
	VALUES  (1,2700.00),
			(2,1550.00),
			(3,2278.50),
			(4,30008.00),
			(5,14000.00),
			(6,50000.00),
			(7,9000.00),
			(8,1500.50),
			(9,2000.00),
			(10,4500.00);

		
INSERT INTO tipo_transacao (tipo_transacao_id, nome_transacao)
	VALUES  (1, 'PixIn'),
			(2, 'PixOut'),
			(3, 'Boleto'),
			(4, 'Imposto'),
			(5, 'Tarifa');
		
INSERT INTO transacoes (transacao_id, cliente_id, tipo_transacao_id, valor)
	VALUES  (1,1,4,250.90),
			(2,1,5,79.80),
			(3,1,1,216.93),
			(4,8,2,71.74),
			(5,7,2,285.92),
			(6,7,1,220.27),
			(7,2,4,250.90),
			(8,5,1,116.37),
			(9,7,2,263.79),
			(10,10,3,48.73),
			(11,4,3,292.85),
			(12,7,1,177.23),
			(13,5,2,272.99),
			(14,4,2,176.17),
			(15,9,3,65.86),
			(16,5,2,150.51),
			(17,8,1,220.69),
			(18,2,5,79.80),
			(19,3,5,79.80),
			(20,4,5,79.80),
			(21,6,1,143.13),
			(22,6,3,128.54),
			(23,4,1,218.46),
			(24,3,2,229.54),
			(25,7,3,278.86),
			(26,7,2,221.88),
			(27,9,2,217.91),
			(28,3,4,250.90),
			(29,7,1,26.48),
			(30,7,3,109.80),
			(31,2,2,95.76),
			(32,9,1,172.12),
			(33,2,3,15.42),
			(34,6,3,58.18),
			(35,7,2,164.85),
			(36,1,1,64.71),
			(37,8,3,150.62),
			(38,1,1,10.68),
			(39,6,1,186.58),
			(40,8,2,76.40),
			(41,3,3,2.35),
			(42,10,3,138.83),
			(43,2,2,32.37),
			(44,1,2,278.95),
			(45,5,5,79.80),
			(46,6,5,79.80),
			(47,8,2,235.90),
			(48,6,3,56.19),
			(49,4,4,250.90),
			(50,7,3,124.25),
			(51,7,1,225.41),
			(52,5,4,250.90),
			(53,1,3,141.95),
			(54,8,3,141.36),
			(55,4,1,89.35),
			(56,1,2,111.23),
			(57,6,4,250.90),
			(58,9,3,21.21),
			(59,10,3,1.59),
			(60,10,3,153.68),
			(61,7,4,250.90),
			(62,6,3,271.81),
			(63,3,3,231.96),
			(64,4,2,81.15),
			(65,8,4,250.90),
			(66,9,4,250.90),
			(67,9,2,103.73),
			(68,2,2,274.50),
			(69,8,1,198.36),
			(70,10,4,250.90),
			(71,9,1,201.85),
			(72,7,5,79.80),
			(73,8,5,79.80),
			(74,6,2,92.88),
			(75,1,3,292.45),
			(76,10,3,246.89),
			(77,7,1,6.95),
			(78,1,1,106.69),
			(79,9,1,229.65),
			(80,5,2,289.34);

-- JOINS
-- Qual é a cidade que mais transacionou?
		
SELECT * FROM transacoes t

-- LEFT JOIN
SELECT
	B.cidade,
	COUNT(A.*) AS "Qntd transacoes"
FROM transacoes AS A
LEFT JOIN correntista AS B ON A.cliente_id = B.cliente_id
GROUP BY 1
ORDER BY 2 DESC;

-- RIGHT JOIN
SELECT
	A.cidade,
	COUNT(B.*) AS "Qntd transacoes"
FROM correntista AS A
RIGHT JOIN transacoes AS B ON A.cliente_id = B.cliente_id
GROUP BY 1
ORDER BY 2 DESC;

-- total por tipo de transacao
SELECT 
	tipo_transacao_id AS "Tipo de Transação", 
	count(transacao_id) AS "Total Transações" 
FROM transacoes
GROUP BY tipo_transacao_id
ORDER BY 2 DESC;

SELECT 
	A.nome_transacao,
	B.*
FROM tipo_transacao AS A
RIGHT JOIN transacoes AS B ON A.tipo_transacao_id = B.tipo_transacao_id; 

SELECT
	A.nome_transacao AS "Nomes",
	SUM(B.valor) AS "Total de tipos"
FROM tipo_transacao AS A
RIGHT JOIN transacoes AS B ON A.tipo_transacao_id = B.tipo_transacao_id 
GROUP BY 1
ORDER BY 2 DESC;

-- INNER JOIN

----ERRO
SELECT 
	A.tipo_transacao_id AS "Tipo de Transação",
	B.nome_transacao AS nomes,
	A.count(transacao_id) AS "Total Transações"	
FROM transacoes AS A
RIGHT JOIN tipo_transacao AS B ON A.tipo_transacao_id = B.tipo_transacao_id
GROUP BY 1
ORDER BY 2 DESC;

----INNER e FULL JOIN 

CREATE TABLE correntista1 AS 
SELECT *
FROM correntista
WHERE cliente_id > 3;

SELECT * FROM correntista1;


CREATE TABLE correntista2 AS 
SELECT *
FROM saldo
WHERE cliente_id < 7;

SELECT * FROM correntista2;


---INNER
SELECT
	A.cliente_id,
	A.nome,
	B.saldo
FROM correntista1 AS A
INNER JOIN saldo AS B ON A.cliente_id = B.cliente_id;


-- FULL JOIN





-- Monte uma tabela com o saldo atual e as atualizacoes de saldo






-- UNIONS
		
CREATE TABLE transacoes2(
	transacao_id integer PRIMARY KEY,
	cliente_id integer REFERENCES "correntista" (cliente_id),
	tipo_transacao_id integer REFERENCES "tipo_transacao" (tipo_transacao_id),
	valor numeric (8,2));

INSERT INTO transacoes2 (transacao_id, cliente_id, tipo_transacao_id, valor)
	VALUES  (81,1,2,182.58),
			(82,10,3,131.67),
			(83,3,2,213.47),
			(84,8,3,105.19),
			(85,9,2,254.57),
			(86,9,2,182.12),
			(87,6,3,75.93),
			(88,5,1,219.25),
			(89,6,2,252.67),
			(90,9,1,174.20),
			(91,10,2,102.83),
			(92,4,2,143.71),
			(93,9,5,79.80),
			(94,10,5,79.80),
			(95,1,3,32.24),
			(96,4,2,75.50),
			(97,1,3,239.13),
			(98,4,1,67.34),
			(99,1,1,196.98),
			(100,9,3,24.84);
		

SELECT * FROM transacoes2;


SELECT * FROM transacoes
UNION ALL
SELECT * FROM transacoes2;


SELECT transacao_id, valor FROM transacoes
UNION ALL
SELECT transacao_id, valor FROM transacoes2;


select cliente_id, 't1' as coluna, nome from correntista 
where cliente_id > 4
union all
select cliente_id, 't2' as coluna, nome from correntista 
where cliente_id < 3

	
-- EXERCICIOS

-- 1) Monte as seguinte tabelas:
-- produtos: produto_id, nome_produto, segmento_produto e valor_unitario
-- clientes: cliente_id, nome, idade, sexo (F ou M) e cidade
-- pedidos: pedido_id, cliente_id, produto_id e quantidade

CREATE TABLE produtos(
	produto_id integer PRIMARY KEY,
	nome_produto varchar(40),
	segmento_produto varchar(40),
	valor_unitario numeric(8,2));

CREATE TABLE clientes(
	cliente_id integer PRIMARY KEY,
	nome varchar(40),
	idade integer,
	sexo varchar(2),
	cidade varchar(40));

CREATE TABLE pedidos(
	pedido_id integer,
	cliente_id integer REFERENCES "clientes" (cliente_id),
	produto_id integer REFERENCES "produtos" (produto_id),
	quantidade integer NOT NULL);
	
-- 2) Preencha as tabelas com os seguintes INSERTS
INSERT INTO produtos (produto_id, nome_produto, segmento_produto, valor_unitario)
	VALUES  (1,'Pasta de Dente','Higiene',5.20),
			(2,'Sabonete','Higiene',2.30),
			(3,'Shampoo','Higiene',12.20),
			(4,'Condicionador','Higiene',14.70),
			(5,'Cotonete','Higiene',8.80),
			(6,'Desinfetante','Limpeza',6.70),
			(7,'Detergente','Limpeza',1.80),
			(8,'Sabão Líquido','Limpeza',23.50),
			(9,'Amaciante','Limpeza',18.60),
			(10,'Água Sanitária','Limpeza',9.60),
			(11,'Arroz','Mantimentos',22.70),
			(12,'Feijão','Mantimentos',9.80),
			(13,'Óleo','Mantimentos',11.20),
			(14,'Macarrão','Mantimentos',4.70),
			(15,'Molho de Tomate','Mantimentos',2.50),
			(16,'Farofa','Mantimentos',5.10),
			(17,'Tapioca','Mantimentos',10.90),
			(18,'Carne Moída','Açougue',29.90),
			(19,'Peito de Frango','Açougue',15.50),
			(20,'Salsicha','Açougue',10.20),
			(21,'Nuggets','Açougue',9.50),
			(22,'Carne de Soja','Açougue',31.70),
			(23,'Patinho','Açougue',42.90),
			(24,'Picanha','Açougue',68.90),
			(25,'Alcatra','Açougue',57.90),
			(26,'Leite','Laticínios',7.60),
			(27,'Leite em Pó','Laticínios',15.40),
			(28,'Queijo','Laticínios',12.20),
			(29,'Queijo Ralado','Laticínios',11.80),
			(30,'Toddynho','Laticínios',3.20),
			(31,'Leite Condensado','Laticínios',7.50),
			(32,'Batata Frita','Congelados',23.00),
			(33,'Blueberry','Congelados',25.50),
			(34,'Lasanha','Congelados',27.90),
			(35,'Sorvete','Congelados',32.50),
			(36,'Açai','Congelados',41.90),
			(37,'Cebola Empanada','Congelados',25.70),
			(38,'Pão de Queijo','Congelados',29.90),
			(39,'Torta Holandesa','Congelados',39.90),
			(40,'Chocolate','Doces',10.50),
			(41,'Paçoca','Doces',24.90),
			(42,'Chicletes','Doces',10.30),
			(43,'Bala de Café','Doces',8.70),
			(44,'Pirulitos','Doces',12.10),
			(45,'Chocolate Branco','Doces',11.20),
			(46,'Bolacha Recheada','Doces',4.30),
			(47,'Pão de Mel','Doces',6.90),
			(48,'Suco','Bebidas',8.90),
			(49,'Refrigerante','Bebidas',9.90),
			(50,'Cerveja','Bebidas',2.20);

INSERT INTO clientes (cliente_id, nome, idade, sexo, cidade)
	VALUES  (1,'Fabiane',32,'F','São Paulo'),
			(2,'Paulo',28,'M','Campinas'),
			(3,'Gisele',30,'F','Campinas'),
			(4,'Karina',27,'F','Guarulhos'),
			(5,'Sandro',30,'M','São Paulo'),
			(6,'Amanda',29,'F','São Paulo'),
			(7,'Rafael',45,'M','Guarulhos'),
			(8,'Luiza',60,'F','Campinas'),
			(9,'João',70,'M','Guarulhos'),
			(10,'Wesley',30,'M','Campinas'),
			(11,'Vinicius',45,'M','São Paulo'),
			(12,'José',85,'M','São Paulo'),
			(13,'Leticia',20,'F','São Paulo'),
			(14,'Sara',18,'F','Campinas'),
			(15,'Jessica',45,'F','Guarulhos'),
			(16,'Guilherme',42,'M','Guarulhos'),
			(17,'Fabio',40,'M','São Paulo'),
			(18,'Lucas',33,'M','São Paulo'),
			(19,'Luana',38,'F','São Paulo'),
			(20,'Pedro',52,'M','Guarulhos'),
			(21,'Thomaz',65,'M','Campinas');

INSERT INTO pedidos(pedido_id, cliente_id, produto_id, quantidade)
	VALUES  (1,17,19,3),
			(1,17,46,2),
			(1,17,24,5),
			(1,17,38,3),
			(1,17,26,5),
			(2,2,26,3),
			(2,2,25,4),
			(2,2,1,2),
			(2,2,35,3),
			(3,7,41,3),
			(3,7,22,1),
			(3,7,15,3),
			(3,7,49,5),
			(3,7,20,3),
			(3,7,2,3),
			(3,7,4,3),
			(3,7,32,2),
			(4,10,31,5),
			(4,10,32,1),
			(4,10,39,1),
			(4,10,26,2),
			(4,10,38,5),
			(4,10,9,4),
			(4,10,28,5),
			(5,19,11,3),
			(5,19,27,5),
			(6,4,42,2),
			(6,4,32,4),
			(6,4,23,4),
			(6,4,14,2),
			(6,4,50,5),
			(7,3,44,4),
			(7,3,17,3),
			(7,3,31,2),
			(7,3,33,2),
			(7,3,15,2),
			(8,5,49,1),
			(8,5,48,1),
			(8,5,16,3),
			(9,12,43,3),
			(9,12,19,3),
			(9,12,2,2),
			(9,12,1,3),
			(9,12,9,1),
			(10,11,33,2),
			(11,12,16,2),
			(11,12,25,3),
			(11,12,22,1),
			(11,12,47,3),
			(11,12,3,2),
			(12,17,11,3),
			(12,17,34,1),
			(12,17,37,3),
			(12,17,3,4),
			(13,16,44,2),
			(13,16,49,2),
			(13,16,34,2),
			(13,16,10,3),
			(13,16,25,5),
			(13,16,19,4),
			(13,16,20,1),
			(14,20,32,5),
			(14,20,46,3),
			(14,20,13,4),
			(15,2,41,1),
			(15,2,26,4),
			(15,2,33,3),
			(15,2,34,3),
			(16,1,34,4),
			(16,1,6,4),
			(16,1,49,1),
			(16,1,15,3),
			(17,8,36,3),
			(17,8,48,4),
			(17,8,42,1),
			(18,9,45,2),
			(18,9,50,3),
			(19,19,1,1),
			(20,21,8,1),
			(21,20,37,4),
			(21,20,42,2),
			(21,20,45,2),
			(21,20,3,3),
			(21,20,33,5),
			(21,20,9,1),
			(22,13,35,4),
			(22,13,49,3),
			(22,13,30,4),
			(23,12,14,1),
			(23,12,29,2),
			(23,12,40,5),
			(23,12,43,5),
			(24,10,45,5),
			(24,10,31,5),
			(25,9,42,4),
			(25,9,46,1),
			(25,9,14,2),
			(25,9,38,3),
			(25,9,47,3);
		
-- 3) Monte a tabela com o total gasto em cada um dos pedidos
SELECT * FROM pedidos;

SELECT
	A.cliente_id AS "Nomes",
	B.cliente_id AS "Nomes"
FROM pedidos AS A
RIGHT JOIN clientes AS B ON A.cliente_id = B.cliente_id 
GROUP BY 1
ORDER BY 1 DESC;
	

select 
	A.pedido_id,
	Sum(B.valor_unitario *A.quantidade) as valor_total
from pedidos as A
full join produtos as B on A.produto_id = B.produto_id
group by 1
order by 2 desc

SELECT
	cliente_id,
	pedido_id
FROM pedidos AS A
RIGHT JOIN pedidos p AS B
GROUP BY 1
ORDER BY 1 DESC;
		
		
SELECT 
	cidade,
	COUNT(DISTINCT loja_id) AS qntde_lojas
FROM sales
GROUP BY 1
ORDER BY 2 DESC;


select A.pedido_id  , sum(A.quantidade*B.valor_unitario) as Total_gasto
		from pedidos as A
		left join produtos as B on A.produto_id = B.produto_id
		group by 1
	order by 2;


SELECT 
	pedido_id AS "Pedido", 
	SUM(p.quantidade * pr.valor_unitario) AS "Total gasto"
FROM pedidos p
INNER JOIN produtos pr ON p.produto_id = pr.produto_id
GROUP BY p.pedido_id
ORDER BY 2 DESC;


---Professor
SELECT 
	A.pedido_id AS "Pedido", 
	SUM(p.quantidade * pr.valor_unitario) AS "Total gasto"
FROM pedidos A
INNER JOIN produtos B ON A.produto_id = B.produto_id
GROUP BY 1
ORDER BY 2 DESC;


---CHAT
CREATE TABLE 
	total_gasto_por_pedido (pedido_id INT,
  	total_gasto NUMERIC(10, 2),
  	pedido_id REFERENCES pedidos(pedido_id));
 
 INSERT INTO total_gasto_por_pedido (pedido_id, total_gasto)
 
SELECT p.pedido_id, SUM(p.quantidade * pr.valor_unitario) AS total_gasto
FROM pedidos p
INNER JOIN produtos pr ON p.produto_id = pr.produto_id
GROUP BY p.pedido_id;


-- 4) Qual segmento que teve mais itens pedidos (em quantidade)
SELECT 
	segmento_produto AS "Segmento", 
	SUM(pe.quantidade) AS "Total de pedidos"
FROM pedidos pe
INNER JOIN produtos pr ON pe.produto_id = pr.produto_id
GROUP BY pr.segmento_produto
ORDER BY 2 DESC
LIMIT 1;	

---CHAT
SELECT pr.segmento_produto, SUM(pe.quantidade) AS total_pedidos
FROM pedidos pe
INNER JOIN produtos pr ON pe.produto_id = pr.produto_id
GROUP BY pr.segmento_produto
ORDER BY total_pedidos DESC
LIMIT 1;
	
				
		
-- 5) Faça um ranking das cidades onde teve mais pedidos de clientes em valor
SELECT 
	cli.cidade AS "Cidades", 
	SUM(pe.quantidade * pr.valor_unitario) AS "Valor total pedidos"
FROM pedidos pe
INNER JOIN clientes cli ON pe.cliente_id = cli.cliente_id
INNER JOIN produtos pr ON pe.produto_id = pr.produto_id
GROUP BY 1
ORDER BY 2 DESC;		
	
		
---CHAT
SELECT cli.cidade, SUM(pe.quantidade * pr.valor_unitario) AS valor_total_pedidos
FROM pedidos pe
INNER JOIN clientes cli ON pe.cliente_id = cli.cliente_id
INNER JOIN produtos pr ON pe.produto_id = pr.produto_id
GROUP BY cli.cidade
ORDER BY valor_total_pedidos DESC;	
		
-- 6) Quantos pedidos teve por sexo
SELECT 
	sexo AS "Sexo", 
	COUNT(pe.pedido_id) AS "Total de pedidos"
FROM pedidos pe
INNER JOIN clientes cli ON pe.cliente_id = cli.cliente_id
GROUP BY 1
ORDER BY 2 DESC;		

---Professor
SELECT 
	A.sexo AS "Sexo", 
	COUNT(DISTINCT B.pedido_id) AS "Total de pedidos"
FROM clientes A
LEFT JOIN pedidos B ON A.cliente_id = B.cliente_id
GROUP BY 1
ORDER BY 2 DESC;
	
		
---CHAT
SELECT cli.sexo, COUNT(pe.pedido_id) AS total_pedidos
FROM pedidos pe
INNER JOIN clientes cli ON pe.cliente_id = cli.cliente_id
GROUP BY cli.sexo;
		
		
-- 7) Quais os itens mais pedidos para clientes acima de 40 anos
SELECT 
	nome_produto AS "Produtos", 
	SUM(pe.quantidade) AS "Total pedidos"
FROM pedidos pe
INNER JOIN produtos pr ON pe.produto_id = pr.produto_id
INNER JOIN clientes cli ON pe.cliente_id = cli.cliente_id
WHERE cli.idade > 40
GROUP BY pr.nome_produto
ORDER BY 2 DESC;
	
		
---CHAT
SELECT pr.nome_produto, SUM(pe.quantidade) AS total_pedidos
FROM pedidos pe
INNER JOIN produtos pr ON pe.produto_id = pr.produto_id
INNER JOIN clientes cli ON pe.cliente_id = cli.cliente_id
WHERE cli.idade > 40
GROUP BY pr.nome_produto
ORDER BY total_pedidos DESC;
		
		
-- 8) Quanto cada segmento vendeu? (valor total por segmento)
SELECT 
	segmento_produto AS "Segmento",
	SUM(pe.quantidade * pr.valor_unitario) AS "Valor total vendas"
FROM pedidos pe
INNER JOIN produtos pr ON pe.produto_id = pr.produto_id
GROUP BY pr.segmento_produto
ORDER BY 2 DESC;

---Professor
SELECT 
	B.segmento_produto AS "Segmento",
	SUM(A.quantidade * B.valor_unitario) AS "Valor total vendas"
FROM pedidos A
INNER JOIN produtos B ON A.produto_id = B.produto_id
GROUP BY 1
ORDER BY 2 DESC;
		
---CHAT
SELECT pr.segmento_produto, SUM(pe.quantidade * pr.valor_unitario) AS valor_total_vendas
FROM pedidos pe
INNER JOIN produtos pr ON pe.produto_id = pr.produto_id
GROUP BY pr.segmento_produto;


-- 9) Faça um ranking dos clientes que mais pediram no mercado
SELECT
	cli.nome AS "Nomes", 
	COUNT(DISTINCT pe.pedido_id) AS "Total pedidos"
FROM pedidos pe
INNER JOIN clientes cli ON pe.cliente_id = cli.cliente_id
GROUP BY cli.nome
ORDER BY 2 DESC;


---Professor
SELECT
	cli.nome AS "Nomes", 
	COUNT(DISTINCT pe.pedido_id) AS "Total pedidos"
FROM pedidos pe
LEFT JOIN clientes cli ON pe.cliente_id = cli.cliente_id
GROUP BY cli.nome
ORDER BY 2 DESC;

SELECT 
	COUNT(DISTINCT pe.pedido_id) AS "Total pedidos"
FROM pedidos pe
		
---CHAT
SELECT cli.nome, COUNT(pe.pedido_id) AS total_pedidos
FROM pedidos pe
INNER JOIN clientes cli ON pe.cliente_id = cli.cliente_id
GROUP BY cli.nome
ORDER BY total_pedidos DESC;
		
		
		
-- 10) Monte um ranking com o nome do produto, a quantidade de itens vendidos e o total vendido
-- ordenar pelo valor!
SELECT 
	pr.nome_produto AS "Produtos", 
	SUM(pe.quantidade) AS "Total itens vendidos", 
	SUM(pe.quantidade * pr.valor_unitario) AS "Total vendido"
FROM pedidos pe
INNER JOIN produtos pr ON pe.produto_id = pr.produto_id
GROUP BY 1
ORDER BY 3 DESC;


---COM LEFT e HAVING
SELECT 
	pr.nome_produto AS "Produtos", 
	SUM(pe.quantidade) AS "Total itens vendidos", 
	SUM(pe.quantidade * pr.valor_unitario) AS "Total vendido"
FROM pedidos pe
LEFT JOIN produtos pr ON pe.produto_id = pr.produto_id
GROUP BY 1
ORDER BY 3 DESC;

---COM LEFT e HAVING
SELECT 
	A.nome_produto AS "Produtos", 
	SUM(B.quantidade) AS "Total itens vendidos", 
	SUM(B.quantidade * A.valor_unitario) AS "Total vendido"
FROM produtos A
LEFT JOIN pedidos B ON A.produto_id = B.produto_id
GROUP BY 1
HAVING SUM(B.quantidade*A.valor_unitario) IS NOT NULL
ORDER BY 3 DESC;


---COM LEFT e SEM HAVING (mostra os valores nulos)
SELECT 
	A.nome_produto AS "Produtos", 
	SUM(B.quantidade) AS "Total itens vendidos", 
	SUM(B.quantidade * A.valor_unitario) AS "Total vendido"
FROM produtos A
LEFT JOIN pedidos B ON A.produto_id = B.produto_id
GROUP BY 1
ORDER BY 3 DESC;

---CHAT
SELECT pr.nome_produto, SUM(pe.quantidade) AS total_itens_vendidos, SUM(pe.quantidade * pr.valor_unitario) AS total_vendido
FROM pedidos pe
INNER JOIN produtos pr ON pe.produto_id = pr.produto_id
GROUP BY pr.nome_produto
ORDER BY total_vendido DESC;


-- VOLTANDO NOS EXERCICIOS SOBRE CORRENTISTAS

-- Monte uma tabela com saldo atual e as atualizacoes de saldo entradas e saidas
SELECT *
FROM transacoes A;

SELECT *
FROM tipo_transacao B;

--- tabela de entrada
CREATE TABLE tb_entrada AS
SELECT 
	A.cliente_id,
	SUM(A.valor) AS entrada
FROM transacoes A
LEFT JOIN tipo_transacao B ON A.tipo_transacao_id = B.tipo_transacao_id 
WHERE B.nome_transacao = 'PixIn'
GROUP BY 1
ORDER BY 1;


--- tabela de saida
CREATE TABLE tb_saida AS
SELECT 
	A.cliente_id,
	SUM(A.valor) AS saida
FROM transacoes A
LEFT JOIN tipo_transacao B ON A.tipo_transacao_id = B.tipo_transacao_id 
WHERE B.nome_transacao IN ('PixOut', 'Boleto', 'Tarifa', 'Imposto')
GROUP BY 1
ORDER BY 1;

--- tabela final
SELECT *
FROM saldo;


SELECT 
	A.cliente_id,
	A.saldo,
	B.entrada,
	C.saida
FROM saldo A
LEFT JOIN tb_entrada B ON A.cliente_id = B.cliente_id
LEFT JOIN tb_saida C ON A.cliente_id = C.cliente_id;


--- Subqueries

SELECT 
	A.cliente_id,
	A.saldo,
	B.entrada,
	C.saida
FROM saldo A
LEFT JOIN (SELECT 
				A.cliente_id,
				SUM(A.valor) AS entrada
			FROM transacoes A
			LEFT JOIN tipo_transacao B ON A.tipo_transacao_id = B.tipo_transacao_id 
			WHERE B.nome_transacao = 'PixIn'
			GROUP BY 1
			ORDER BY 1) B ON A.cliente_id = B.cliente_id
LEFT JOIN (SELECT 
				A.cliente_id,
				SUM(A.valor) AS saida
			FROM transacoes A
			LEFT JOIN tipo_transacao B ON A.tipo_transacao_id = B.tipo_transacao_id 
			WHERE B.nome_transacao IN ('PixOut', 'Boleto', 'Tarifa', 'Imposto')
			GROUP BY 1
			ORDER BY 1) C ON A.cliente_id = C.cliente_id;

		
--- CASE WHEN		
SELECT 
	A.cliente_id,
	A.saldo,
	CASE WHEN B.entrada IS NULL THEN 0 ELSE B.entrada END AS entrada,
	CASE WHEN C.saida IS NULL THEN 0 ELSE C.saida END AS saida
FROM saldo A
LEFT JOIN tb_entrada B ON A.cliente_id = B.cliente_id
LEFT JOIN tb_saida C ON A.cliente_id = C.cliente_id;


SELECT 
	A.cliente_id,
	A.saldo,
	CASE WHEN B.entrada IS NULL THEN 0 ELSE B.entrada END AS entrada,
	CASE WHEN C.saida IS NULL THEN 0 ELSE C.saida END AS saida,
	A.saldo + (CASE WHEN B.entrada IS NULL THEN 0 ELSE B.entrada END) - (CASE WHEN C.saida IS NULL THEN 0 ELSE C.saida END) AS saldo_atual
FROM saldo A
LEFT JOIN tb_entrada B ON A.cliente_id = B.cliente_id
LEFT JOIN tb_saida C ON A.cliente_id = C.cliente_id;


---- QUERY monstra com tudo

SELECT 
	A.cliente_id,
	A.saldo,
	CASE WHEN B.entrada IS NULL THEN 0 ELSE B.entrada END AS entrada,
	CASE WHEN C.saida IS NULL THEN 0 ELSE C.saida END AS saida,
	A.saldo + (CASE WHEN B.entrada IS NULL THEN 0 ELSE B.entrada END) - (CASE WHEN C.saida IS NULL THEN 0 ELSE C.saida END) AS saldo_atual
FROM saldo A
LEFT JOIN (SELECT 
				A.cliente_id,
				SUM(A.valor) AS entrada
			FROM transacoes A
			LEFT JOIN tipo_transacao B ON A.tipo_transacao_id = B.tipo_transacao_id 
			WHERE B.nome_transacao = 'PixIn'
			GROUP BY 1
			ORDER BY 1) B ON A.cliente_id = B.cliente_id
LEFT JOIN (SELECT 
				A.cliente_id,
				SUM(A.valor) AS saida
			FROM transacoes A
			LEFT JOIN tipo_transacao B ON A.tipo_transacao_id = B.tipo_transacao_id 
			WHERE B.nome_transacao IN ('PixOut', 'Boleto', 'Tarifa', 'Imposto')
			GROUP BY 1
			ORDER BY 1) C ON A.cliente_id = C.cliente_id;
		
		
		
---- SEQUENCIA DE PROCESSAMENTO
FROM
ON 
JOIN 
WHERE
GROUP BY 
HAVING 
SELECT 
ORDER BY
LIMIT 

--- VOLTANDO AO CASE WHEN 
SELECT *
FROM clientes;

SELECT 
	cliente_id,
	idade,
	CASE WHEN idade < 30 THEN 'FX1 - menor que 30 anos'
		WHEN idade < 40 THEN 'FX2 - 30 a 40 anos'
		WHEN idade < 50 THEN 'FX3 - 40 a 50 anos'
		WHEN idade < 60 THEN 'FX4 - 50 a 60 anos' ELSE 'FX5 - maior ou igual 60 anos' END AS fx_idade
FROM clientes;


SELECT 
	fx_idade,
	COUNT(*) AS qtde_clientes
FROM (SELECT 
	cliente_id,
	idade,
	CASE WHEN idade < 30 THEN 'FX1 - menor que 30 anos'
		WHEN idade < 40 THEN 'FX2 - 30 a 40 anos'
		WHEN idade < 50 THEN 'FX3 - 40 a 50 anos'
		WHEN idade < 60 THEN 'FX4 - 50 a 60 anos' ELSE 'FX5 - maior ou igual 60 anos' END AS fx_idade
FROM clientes) A
GROUP BY 1
ORDER BY 1;


--- MANIPULANDO DATAS E TEXTOS
--- TEXTOS

--- MAIUSCULAS
SELECT 
	('Boa noite turma tudo bem?'),
	UPPER('Boa noite turma tudo bem?')
	

--- MINUSCULAS
SELECT 
	('Boa Noite TURMA tudo bem?'),
	LOWER('Boa noite turma tudo bem?')
	
--- LIKE 
--- Exemplo de like que vai dar falso

SELECT
	'SANDRO' LIKE UPPER('Sandro');

SELECT
	'SANDRO SAORIN' LIKE 'SANDRO%';

SELECT
	'SANDRO SAORIN' LIKE UPPER('Sandro%');

SELECT
	'SANDRO SAORIN' LIKE '%ORIN';

SELECT
	'SANDRO SAORIN' LIKE '%OR%';


--- CONCAT
SELECT 
	CONCAT('SANDRO', 'SAORIN', 'DA', 'SILVA');
	
--- SUBSTRING (SUBSTR)
--- SUBSTR(PALAVRA ou STRING, POSICAO INICIAL, TAMANHO DO PEDACO)

SELECT 
	SUBSTRING('SANDRO SAORIN DA SILVA', 4, 12);
	

SELECT 
	SUBSTRING('SANDRO SAORIN DA SILVA', 0, 12);
	
SELECT 
	SUBSTRING('SANDRO SAORIN DA SILVA', -4, 6);
	

--- DATAS
SELECT 
	data_pedido
FROM sales s 
LIMIT 10;


SELECT 
	data_pedido,
	TO_CHAR(data_pedido, 'dd/mm/yyyy') AS data1,
	TO_CHAR(data_pedido, 'dd mon YY') AS data2
FROM sales s 
LIMIT 10;


SELECT 
	data_pedido,
	EXTRACT(DAY FROM data_pedido) AS dia,
	EXTRACT(MONTH FROM data_pedido) AS mes,
	EXTRACT(YEAR FROM data_pedido) AS ano,
	EXTRACT(WEEK FROM data_pedido) AS semana,
	TO_CHAR(data_pedido, 'dd/mm/yyyy') AS data1,
	TO_CHAR(data_pedido, 'dd mon YY') AS data2
FROM sales s 
LIMIT 10;


SELECT
	data_pedido,
	EXTRACT(DAY FROM data_pedido) AS dia,
	EXTRACT(MONTH FROM data_pedido) AS mes,
	EXTRACT(YEAR FROM data_pedido) AS ano,
	EXTRACT(WEEK FROM data_pedido) AS semana,
	TO_CHAR(data_pedido, 'dd/mm/yyyy') AS data1,
	TO_CHAR(data_pedido, 'dd mon YY') AS data2,
	TO_CHAR(data_pedido, 'MONTH') AS nome_mes,
	TO_CHAR(data_pedido, 'Month') AS nome_mes2,
	TO_CHAR(data_pedido, 'month') AS nome_mes3,
	TO_CHAR(data_pedido, 'MON') AS nome_mes4,
	TO_CHAR(data_pedido, 'Mon') AS nome_mes5,
	TO_CHAR(data_pedido, 'mon') AS nome_mes6
FROM sales s 
LIMIT 10;


--- Data de HOJE
SELECT current_date AS hoje;

SELECT current_time AS hora;

SELECT current_timestamp AS timestamp;

SELECT EXTRACT(MONTH FROM current_date) AS mes_hoje;

SELECT 
	EXTRACT(HOUR FROM current_timestamp) AS "Hora AGORA",
	EXTRACT(MINUTE FROM current_timestamp) AS "Minutos AGORA";
