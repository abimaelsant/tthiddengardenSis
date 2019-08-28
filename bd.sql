create database dbsis;

use dbsis;

create table produto (
	id int(11) auto_increment,
    nome varchar(130),
    quantidade int,
    custoLote double,
    freteTotal double,
    freteUnitario double,
    custoUnitario double,
    custoUnitarioComFrete double,
    precoUnitario double,
	lucroUnitario double,
    lucroLote double,
    primary key (id)
);

create table servico (
	id int(11) auto_increment,
    nome varchar(300),
    descricao varchar (600),
    valor double,
    primary key(id)
);

create table cliente (
	id int(11) auto_increment,
    nome varchar(200),
    cpf varchar(11),
    rg varchar(20),
    dataNascimento date,
    primary key(id)
);