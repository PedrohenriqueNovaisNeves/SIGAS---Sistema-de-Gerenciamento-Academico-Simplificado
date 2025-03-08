create database db_sigas;
use db_sigas;

create table tb_Usuario(
	idUser int primary key auto_increment,
	username varchar(250),
	userRg char(9),
	userCpf char(11)
)

select * from tb_Usuario;

drop table tb_Usuario;

delete from tb_Usuario;

create table tb_professor(
	idProfessor int primary key auto_increment,
	matricula char(10),
	idUser int,
	foreign key (idUser) references tb_Usuario (idUser)
)

drop table tb_professor;

select * from tb_professor;

delete from tb_professor;

CREATE TABLE tb_Aluno(
	idAluno int primary key auto_increment,
	registroAcademico char(12),
	idUser int,
	foreign key (idUser) references tb_Usuario (idUser)
)

drop table tb_Aluno;

SELECT * FROM tb_Aluno;

delete from tb_Aluno;

CREATE TABLE tb_notas(
	a1 int,
	a2 int,
	a3 int,
	notaFinal int,
	idAluno int,
	foreign key (idAluno) references tb_Aluno (idAluno)
)

select * from tb_notas;

drop table tb_notas;

delete from tb_notas;