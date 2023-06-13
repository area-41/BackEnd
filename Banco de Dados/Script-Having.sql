-- EXERCICIOS - tb_sales - HAVING

--1- Quais são as 10 marcas que lucraram acima de 1000 dolares no dia 30/11/2022?
SELECT
	marca_id AS "Marca",
	data_pedido, 
	SUM((venda_garrafa-custo_garrafa)*garrafas_vendidas) AS "Lucro"
FROM sales
GROUP BY data_pedido, marca_id  
HAVING 2 > 1.000 AND data_pedido = '2022-11-30'
ORDER BY 3 DESC
LIMIT 10;


--2- Qual a cidade que mais vendeu litros para aqueles que venderam mais do que 2000 litros de bebidas?
SELECT
	cidade,
	SUM(volume_litros_vendidos)
FROM sales
GROUP BY 1
HAVING SUM(volume_litros_vendidos) > 2000
ORDER BY 2 DESC;

--3-  Qual o municipio que mais vendeu em dolares para totais menores que 15 mil dolares?
SELECT 
	municipio,
	SUM(venda_garrafa*garrafas_vendidas) AS "Vendas"
FROM sales
GROUP BY 1
HAVING SUM(venda_garrafa*garrafas_vendidas) < 15000
ORDER BY 2 DESC;

--4- Quais as 5 marcas que tiveram os menores custos nas cidades de WATERLOO e DES MOINES?
SELECT
	marca_id AS "Marca",
	cidade AS "Cidade",
	SUM(custo_garrafa*garrafas_vendidas) AS "Custos em R$"
FROM sales
GROUP BY cidade, marca_id 
HAVING cidade IN ('WATERLOO', 'DES MOINES')
--HAVING cidade = 'WATERLOO' OR cidade = 'DES MOINES'
ORDER BY 3
LIMIT 5;



-- EXERCICIOS - SubQueries, Case When, Datas e Texto

-- 1) Usando a tabela sales, crie uma tabela onde teremos uma coluna categorica
--com as semanas e uma coluna númerica com o lucro total para cada semana.

SELECT
	EXTRACT(WEEK FROM data_pedido) AS semana,
	SUM((venda_garrafa-custo_garrafa)*garrafas_vendidas) AS "Lucro"
FROM sales
GROUP BY 1
ORDER BY 2 DESC;


SELECT 
	CASE WHEN data_pedido <= '2022-11-05' THEN '1 Semana'
		WHEN data_pedido <= '2022-11-12' THEN '2 Semana'
		WHEN data_pedido <= '2022-11-19' THEN '3 Semana'
		WHEN data_pedido <= '2022-11-30' THEN '4 Semana' ELSE '5 Semana' AS semana
FROM sales
GROUP BY 1
ORDER BY 1;
	
-- 2) Usando a tabela sales, identifique todas as cidades que tem no nome
--as letras DE juntas, e calcule a quantidade de cidades

SELECT
	COUNT(DISTINCT cidade) AS qtd_cidade
FROM sales
WHERE cidade LIKE '%DE%'

-- 3) Utilizando as tabelas do exercicio sobre o mercado, categorize os pedidos de acordo
--com o valor total gasto (sugira uma separação entre 6 categorias)

SELECT 
	A.pedido_id,
	SUM(A.quantidade*B.valor_unitario) AS total
FROM pedidos A
LEFT JOIN produtos B ON A.produto_id = B.produto_id 
GROUP BY 1
ORDER BY 1;


SELECT 
	CASE WHEN total_pedido <= 100 THEN 'F1 - Ate 100 Reais'
		WHEN total_pedido <= 200 THEN 'F2 - Ate 100-200 Reais'
		WHEN total_pedido <= 300 THEN 'F3 - Ate 200 Reais'
		WHEN total_pedido <= 400 THEN 'F4 - Ate 100 Reais'
		WHEN total_pedido <= 500 THEN 'F5 - Ate 100 Reais' ELSE 'F6 ' END AS faixas,
	COUNT(pedido_id) AS qtd,
	SUM()
FROM (SELECT 
		A.pedido_id,
		SUM(A.quantidade*B.valor_unitario) AS total
		FROM pedidos A
		LEFT JOIN produtos B ON A.produto_id = B.produto_id 
		GROUP BY 1
		ORDER BY 1) A
GROUP BY 1
ORDER BY 1;


-- 4) Usando as tabelas do exercicio sobre correntistas, monte uma tabela com saldo e saldo_atual (parecido com o que foi feito em aula),
--mas agora utilizando as 100 transações, usando subqueries


SELECT * FROM transacoes
UNION ALL
SELECT * FROM transacoes2 
