
create table produto (
    id serial not null primary key,
    nome varchar(100) not null,
    valor decimal(10,2) not null
);

create table ingrediente (
    id serial not null primary key,
    nome varchar(100) not null,
    valor decimal(10,2) not null
);

create table bairro (
    id serial not null primary key,
    nome varchar(100) not null
);

create table login (
    id serial not null primary key,
    login varchar(100) not null,
    senha varchar(100) not null
);

create table telefone (
    id serial not null primary key,
    ddd varchar(3) not null,
    numero varchar(20) not null
);

create table status_pedido (
    id serial not null primary key,
    progresso varchar(100) not null
);


create table endereco (
    id serial not null primary key,
    cep varchar(10) not null,
    bairro_id integer not null references bairro(id),
    complemento varchar(100),
    rua varchar(100) not null,
    numero varchar(10) not null
);

create view endereco_completo as (
    select e.id, e.cep, b.id as bairro_id, b.nome as bairro_nome, e.complemento, e.rua, e.numero
    from endereco e
    join bairro b on e.bairro_id = b.id
);

create table entrega (
    id serial not null primary key,
    chave varchar(100) not null,
    endereco_id integer not null references endereco(id),
    valor decimal(10,2) not null
);

create view entrega_completa as (
    select e.id, e.chave, ec.id as ender_id, ec.cep, ec.bairro_id, ec.bairro_nome, ec.complemento, ec.rua, ec.numero, e.valor
    from entrega e
    join endereco_completo ec on e.endereco_id = ec.id
);