
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

create table cliente (
    id serial not null primary key,
    nome varchar(100) not null,
    telefone_id integer not null references telefone(id)
);

create view cliente_completo as (
    select c.id, c.nome, t.id as telefone_id, t.ddd, t.numero
    from cliente c
    join telefone t on c.telefone_id = t.id
);

create table funcionario (
    id serial not null primary key,
    nome varchar(100) not null,
    telefone_id integer not null references telefone(id),
    login_id integer not null references login(id),
    cpf varchar(11) not null,
    rg varchar(10) not null
);

create view funcionario_completo as (
    select f.id, f.nome, t.id as telefone_id, t.ddd, t.numero, l.id as login_id, l.login, l.senha, f.cpf, f.rg
    from funcionario f
    join telefone t on f.telefone_id = t.id
    join login l on f.login_id = l.id
);

create table cartao (
    id serial not null primary key,
    numero varchar(16) not null,
    cvv varchar(3) not null,
    isCredito boolean not null,
    cliente_id integer not null references cliente(id)
);

create view cartao_completo as (
    select c.id, c.numero, c.cvv, c.isCredito, cl.id as cliente_id, cl.nome
    from cartao c
    join cliente_completo cl on c.cliente_id = cl.id
);