

-- Base de dados - sales

-- Exercicio 1: Quantos itens distintos foram vendidos (item_id)?
SELECT 
	COUNT(DISTINCT item_id) AS itens distintos 
FROM sales;
	
-- Exercicio 2: Quantas lojas existem na base (loja_id)?
SELECT 
	COUNT(DISTINCT loja_id) AS lojas 
FROM sales;

-- Exercicio 3: Qual é a cidade que mais tem lojas (loja_id)?
SELECT 
	cidade,
	COUNT(DISTINCT loja_id) AS lojas 
FROM sales
GROUP BY cidade
ORDER BY 2 DESC
LIMIT 1;

-- Exercicio 4: Em qual municipio foi vendido mais itens?
SELECT 
	cidade,
	SUM(garrafas_vendidas) AS itens 
FROM sales
GROUP BY cidade
ORDER BY 2 DESC
LIMIT 1;

-- Exercicio 5: Qual a cidade mais vendeu em dolares?
SELECT 
	cidade,
	SUM(total_venda) AS vendas 
FROM sales
GROUP BY cidade
ORDER BY 2 DESC
LIMIT 1;

-- Exercicio 6: Qual foi o dia que mais vendeu itens distintos?
SELECT 
	data_pedido, 
	COUNT(DISTINCT item_id) AS itens 
FROM sales
GROUP BY data_pedido
ORDER BY 2 DESC
LIMIT 1;


-- Exercicio 7: Monte o top 5 bebidas (item_id) mais vendidas por valor?
SELECT
	item_id,
	COUNT(DISTINCT garrafas_vendidas) AS itens,
	SUM(total_venda) 
FROM sales
GROUP BY item_id
ORDER BY 3 DESC
LIMIT 5;

-- Exercicio 8: Monte o top 5 bebidas (item_id) mais vendidas por volume em litros
SELECT
	item_id,
	COUNT(DISTINCT garrafas_vendidas) AS itens,
	SUM(volume_litros_vendidos) AS litros
FROM sales
GROUP BY item_id
ORDER BY 3 DESC
LIMIT 5;

-- Exercicio 9: Quais são as 10 empresas (marca_id) que mais lucram com a venda de bebidas?
SELECT
	marca_id,
	COUNT(DISTINCT garrafas_vendidas) AS itens,
	SUM((venda_garrafa - custo_garrafa)*garrafas_vendidas)  AS lucro
FROM sales
GROUP BY marca_id
ORDER BY 3 DESC
LIMIT 10;

-- Exercicio 10: Monte uma tabela com a quantidade de vendas distintas por dia.
SELECT
	data_pedido,	
	COUNT(DISTINCT pedido_id) AS itens
FROM sales
GROUP BY data_pedido
ORDER BY 1 ASC;