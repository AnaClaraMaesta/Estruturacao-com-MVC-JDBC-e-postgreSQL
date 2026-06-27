# Estruturacao-com-MVC-JDBC-e-postgreSQL
#Tables
Create table cliente(
	id serial primary key,
	nome varchar(100) not null,
	telefone varchar(20) not null
)

create table veiculo(
	id serial primary key,
	placa varchar(7) not null,
	modelo varchar(100) not null,
	ano int not null
)

create table servico(
	id serial primary key,
	id_cliente references cliente(id),
	id_veiculo references veiculo(id),
	valor numeric(10,2),
	descricao varchar(255)
)
#Regras de negócio
Não permitir abrir uma ordem de serviço para um veículo que não esteja cadastrado;
O valor do serviço não pode ser negativo;
E preciso conseguir consultar todo o histórico de manutenções de um determinado veículo;
Informar em cliente nome e telefone;
Informar em veículo Placa, Modelo e ano;
Informar em servico o cliente, veículo, valor, motivo e se a operação foi concluida ou se ainda está aberta;
