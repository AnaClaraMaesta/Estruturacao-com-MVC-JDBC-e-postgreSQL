# Cenario 1


create table tutor(
	id serial primary key,
	nome varchar(100) not null,
	endereco varchar(14),
	telefone varchar(255)
)

create table animal(
	id serial primary key,
	nome varchar(100) not null,
	raca varchar(100),
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
