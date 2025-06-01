
create table produto (
    id serial not null primary key,
    nome varchar(100) not null,
    valor decimal(10,2) not null
)

create table ingrediente (
    id serial not null primary key,
    nome varchar(100) not null,
    valor decimal(10,2) not null
)

create table bairro (
    id serial not null primary key,
    nome varchar(100) not null
)

create table login (
    id serial not null primary key,
    login varchar(100) not null,
    senha varchar(100) not null
)

create table telefone (
    id serial not null primary key,
    ddd varchar(3) not null,
    numero varchar(20) not null
)

create table status_pedido (
    id serial not null primary key,
    progresso varchar(100) not null
)