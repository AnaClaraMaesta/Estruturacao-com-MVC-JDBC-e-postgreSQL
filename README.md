# Estruturacao-com-MVC-JDBC-e-postgreSQL

#**Cenário3**

#Regras de negocio:

não permitir uma pessoa se matricular no mesmo curso duas vezes

não abrir matricula em um curso que não tem mais vagas disponiveis

valor da matricula não pode ser negativo

não poder matricular aluno sem cadastro

não poder matricular aluno em um curso não cadastrado

cadastrar alunos com nome, e-mail e telefone

cadastrar cursos com nome, descrição carga horaria, nmr max de vagas

registrar matricula informando data, valor pago

consultar alunos matriculados por curso 

consultar cursos por aluno

#entidades:

aluno: id, nome, email, telefone;

curso: id, nome descricao, carga_horaria, vagas_totais, vagas_disponiveis;

matricula: id, id_aluno, id_curso, data_matricula, valor;

#Create table:

create table alunos (id serial primary key, nome varchar(80), email varchar(50), telefone varchar(15) );

create table cursos (id serial primary key, nome varchar (100), descricao varchar (255), carga_horaria varchar(5), vagas_totais smallint, vagas_disponiveis smallint);

create table matricula (id serial primary key, id_aluno int not null, nome_aluno varchar(80),id_curso int not null, nome_curso varchar(100), data_matricula timestamp default current_timestamp, valor numeric(8, 2), CONSTRAINT aluno_curso_unico UNIQUE (id_aluno, id_curso) 
);
