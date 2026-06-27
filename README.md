# Cenario 1

# TABLES

create table tutor(
	id serial primary key,
	nome varchar(100) not null,
	endereco varchar(14) not null,
	telefone varchar(255) not null
)

create table animal(
	id serial primary key,
	nome varchar(100) not null,
	raca varchar(100) not null,
	especie varchar(100) not null
)

create table consulta(
	id serial primary key,
	tutor_id int references tutor(id),
	animal_id int references animal(id) not null,
	data_consulta DATE not null,
	descricao varchar(255) not null,
	valor Numeric(10,2)
)

#REGRA DE NEGOCIO

#Tutor precisa informar pelo menos nome, endereco e telefone;
#Tutor Cadastrar o animal de um tutor, pelo menos nome, especie e raca;
#Um tutor pode ter mais de um animal cadastrado
#Cada consulta deve informar qual
animal foi atendido, a data do atendimento, o motivo do atendimento e o valor cobrado.
#Não registrar consulta para um animal não cadastrado
#Valor da consulta não pode ser negativo
#Conseguir consultar todas as consultas de um animal específico
#Buscar animais por tutor
