select * from mercado where estoque > 10 or valor_produto > 15.90

select * from mercado where tipo_produto = 'Massa' and estoque > 10 or valor_produto > 15.90

select * from mercado where tipo_produto = 'Frios'

select * from mercado where tipo_produto in ('Massa', 'Laticinios', 'Grãos') and valor_produto > 10

select * from mercado where valor_produto between 10 and 25
select * from mercado where valor_produto > 10 and valor_produto < 25

select * from mercado where valor_produto <= estoque

select * from mercado where tipo_produto <> 'Massa'

select * from mercado where tipo_produto not in ('Massa', 'Frios') and valor_produto > 10

select * from professores p
alter table professores add cpf varchar(14)

update professores set cpf = '34.243.243-24' where professor_id = 1;
update professores set cpf = '45.654.657-34' where professor_id = 2;
update professores set cpf = '55.456.656-44' where professor_id = 3;
update professores set cpf = '78.334.221-11' where professor_id = 4;

select * from professores p where cpf like '%5%'

select * from professores p where cpf like '__.6%'

select * from professores p where cpf like '__.6__.___-3%'

select * from professores p order by cpf asc
