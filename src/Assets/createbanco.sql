
create table produto (
    id serial not null primary key,
    nome varchar(100) not null,
    valor decimal(10,2) not null
)