
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

create table pedido (
    id serial not null primary key,
    cliente_id integer not null references cliente(id),
    data_pedido timestamp not null default current_timestamp,
    status_pedido_id integer not null references status_pedido(id),
    entrega_id integer not null references entrega(id),
    reembolsado varchar(100)
);

create view pedido_completo as (
    select  p.id,
            c.id as cliente_id, c.nome as cliente_nome,
            p.data_pedido,
            sp.id as status_id, sp.progresso as status_progresso,
            e.id as entrega_id, e.chave, e.ender_id, e.cep, e.bairro_id, e.bairro_nome, e.complemento, e.rua, e.numero, e.valor,
            p.reembolsado
    from pedido p
    join cliente c on p.cliente_id = c.id
    join status_pedido sp on p.status_pedido_id = sp.id
    join entrega_completa e on p.entrega_id = e.id
);

create table carrinho (
    id serial not null primary key,
    pedido_id integer not null references pedido(id),
    produto_id integer not null references produto(id),
    quantidade integer not null
);

create view carrinho_completo as (
    select c.id, c.pedido_id, p.id as produto_id, p.nome as produto_nome, p.valor as produto_valor, c.quantidade
    from carrinho c
    join produto p on c.produto_id = p.id
);


create table ingrediente_escolha (
    id serial not null primary key,
    ingrediente_id integer not null references ingrediente(id),
    carrinho_id integer not null references carrinho(id),
    toExclude boolean not null default false
);

create view ingrediente_escolha_completo as (
    select pe.id, pe.ingrediente_id, i.nome as ingrediente_nome, i.valor as ingrediente_valor, pe.carrinho_id, pe.toExclude
    from ingrediente_escolha pe
    join ingrediente i on pe.ingrediente_id = i.id
);

create table pagamento (
    id serial not null primary key,
    pedido_id integer not null references pedido(id),
    pix decimal(10,2),
    dinheiro decimal(10,2),
    cartao decimal(10,2),
    check (pix is not null or dinheiro is not null or cartao is not null)
);

create table cupom (
    id serial not null primary key,
    valor decimal(10,2) not null,
    codigo varchar(50) not null,
    validade date not null,
    pagamento_id integer not null references pagamento(id)
);
