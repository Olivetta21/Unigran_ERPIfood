--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: bairro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bairro (
    id integer NOT NULL,
    nome character varying(100) NOT NULL
);


ALTER TABLE public.bairro OWNER TO postgres;

--
-- Name: bairro_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.bairro_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.bairro_id_seq OWNER TO postgres;

--
-- Name: bairro_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.bairro_id_seq OWNED BY public.bairro.id;


--
-- Name: carrinho; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.carrinho (
    id integer NOT NULL,
    pedido_id integer NOT NULL,
    produto_id integer NOT NULL,
    quantidade integer NOT NULL
);


ALTER TABLE public.carrinho OWNER TO postgres;

--
-- Name: produto; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.produto (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    valor numeric(10,2) NOT NULL
);


ALTER TABLE public.produto OWNER TO postgres;

--
-- Name: carrinho_completo; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.carrinho_completo AS
 SELECT c.id,
    c.pedido_id,
    p.id AS produto_id,
    p.nome AS produto_nome,
    p.valor AS produto_valor,
    c.quantidade
   FROM (public.carrinho c
     JOIN public.produto p ON ((c.produto_id = p.id)));


ALTER VIEW public.carrinho_completo OWNER TO postgres;

--
-- Name: carrinho_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.carrinho_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.carrinho_id_seq OWNER TO postgres;

--
-- Name: carrinho_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.carrinho_id_seq OWNED BY public.carrinho.id;


--
-- Name: cartao; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cartao (
    id integer NOT NULL,
    numero character varying(16) NOT NULL,
    cvv character varying(3) NOT NULL,
    iscredito boolean NOT NULL,
    cliente_id integer NOT NULL
);


ALTER TABLE public.cartao OWNER TO postgres;

--
-- Name: cliente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cliente (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    telefone_id integer NOT NULL
);


ALTER TABLE public.cliente OWNER TO postgres;

--
-- Name: telefone; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.telefone (
    id integer NOT NULL,
    ddd character varying(3) NOT NULL,
    numero character varying(20) NOT NULL
);


ALTER TABLE public.telefone OWNER TO postgres;

--
-- Name: cliente_completo; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.cliente_completo AS
 SELECT c.id,
    c.nome,
    t.id AS telefone_id,
    t.ddd,
    t.numero
   FROM (public.cliente c
     JOIN public.telefone t ON ((c.telefone_id = t.id)));


ALTER VIEW public.cliente_completo OWNER TO postgres;

--
-- Name: cartao_completo; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.cartao_completo AS
 SELECT c.id,
    c.numero,
    c.cvv,
    c.iscredito,
    cl.id AS cliente_id,
    cl.nome
   FROM (public.cartao c
     JOIN public.cliente_completo cl ON ((c.cliente_id = cl.id)));


ALTER VIEW public.cartao_completo OWNER TO postgres;

--
-- Name: cartao_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cartao_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cartao_id_seq OWNER TO postgres;

--
-- Name: cartao_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cartao_id_seq OWNED BY public.cartao.id;


--
-- Name: cliente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cliente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cliente_id_seq OWNER TO postgres;

--
-- Name: cliente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cliente_id_seq OWNED BY public.cliente.id;


--
-- Name: cupom; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cupom (
    id integer NOT NULL,
    valor numeric(10,2) NOT NULL,
    codigo character varying(50) NOT NULL,
    validade date NOT NULL,
    pagamento_id integer NOT NULL
);


ALTER TABLE public.cupom OWNER TO postgres;

--
-- Name: cupom_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cupom_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.cupom_id_seq OWNER TO postgres;

--
-- Name: cupom_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cupom_id_seq OWNED BY public.cupom.id;


--
-- Name: endereco; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.endereco (
    id integer NOT NULL,
    cep character varying(10) NOT NULL,
    bairro_id integer NOT NULL,
    complemento character varying(100),
    rua character varying(100) NOT NULL,
    numero character varying(10) NOT NULL
);


ALTER TABLE public.endereco OWNER TO postgres;

--
-- Name: endereco_completo; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.endereco_completo AS
 SELECT e.id,
    e.cep,
    b.id AS bairro_id,
    b.nome AS bairro_nome,
    e.complemento,
    e.rua,
    e.numero
   FROM (public.endereco e
     JOIN public.bairro b ON ((e.bairro_id = b.id)));


ALTER VIEW public.endereco_completo OWNER TO postgres;

--
-- Name: endereco_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.endereco_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.endereco_id_seq OWNER TO postgres;

--
-- Name: endereco_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.endereco_id_seq OWNED BY public.endereco.id;


--
-- Name: entrega; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.entrega (
    id integer NOT NULL,
    chave character varying(100) NOT NULL,
    endereco_id integer NOT NULL,
    valor numeric(10,2) NOT NULL
);


ALTER TABLE public.entrega OWNER TO postgres;

--
-- Name: entrega_completa; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.entrega_completa AS
 SELECT e.id,
    e.chave,
    ec.id AS ender_id,
    ec.cep,
    ec.bairro_id,
    ec.bairro_nome,
    ec.complemento,
    ec.rua,
    ec.numero,
    e.valor
   FROM (public.entrega e
     JOIN public.endereco_completo ec ON ((e.endereco_id = ec.id)));


ALTER VIEW public.entrega_completa OWNER TO postgres;

--
-- Name: entrega_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.entrega_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.entrega_id_seq OWNER TO postgres;

--
-- Name: entrega_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.entrega_id_seq OWNED BY public.entrega.id;


--
-- Name: funcionario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.funcionario (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    telefone_id integer NOT NULL,
    login_id integer NOT NULL,
    cpf character varying(11) NOT NULL,
    rg character varying(10) NOT NULL
);


ALTER TABLE public.funcionario OWNER TO postgres;

--
-- Name: login; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.login (
    id integer NOT NULL,
    login character varying(100) NOT NULL,
    senha character varying(100) NOT NULL
);


ALTER TABLE public.login OWNER TO postgres;

--
-- Name: funcionario_completo; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.funcionario_completo AS
 SELECT f.id,
    f.nome,
    t.id AS telefone_id,
    t.ddd,
    t.numero,
    l.id AS login_id,
    l.login,
    l.senha,
    f.cpf,
    f.rg
   FROM ((public.funcionario f
     JOIN public.telefone t ON ((f.telefone_id = t.id)))
     JOIN public.login l ON ((f.login_id = l.id)));


ALTER VIEW public.funcionario_completo OWNER TO postgres;

--
-- Name: funcionario_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.funcionario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.funcionario_id_seq OWNER TO postgres;

--
-- Name: funcionario_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.funcionario_id_seq OWNED BY public.funcionario.id;


--
-- Name: ingrediente; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ingrediente (
    id integer NOT NULL,
    nome character varying(100) NOT NULL,
    valor numeric(10,2) NOT NULL
);


ALTER TABLE public.ingrediente OWNER TO postgres;

--
-- Name: ingrediente_escolha; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.ingrediente_escolha (
    id integer NOT NULL,
    ingrediente_id integer NOT NULL,
    carrinho_id integer NOT NULL,
    toexclude boolean DEFAULT false NOT NULL
);


ALTER TABLE public.ingrediente_escolha OWNER TO postgres;

--
-- Name: ingrediente_escolha_completo; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.ingrediente_escolha_completo AS
 SELECT pe.id,
    pe.ingrediente_id,
    i.nome AS ingrediente_nome,
    i.valor AS ingrediente_valor,
    pe.carrinho_id,
    pe.toexclude
   FROM (public.ingrediente_escolha pe
     JOIN public.ingrediente i ON ((pe.ingrediente_id = i.id)));


ALTER VIEW public.ingrediente_escolha_completo OWNER TO postgres;

--
-- Name: ingrediente_escolha_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ingrediente_escolha_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.ingrediente_escolha_id_seq OWNER TO postgres;

--
-- Name: ingrediente_escolha_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ingrediente_escolha_id_seq OWNED BY public.ingrediente_escolha.id;


--
-- Name: ingrediente_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.ingrediente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.ingrediente_id_seq OWNER TO postgres;

--
-- Name: ingrediente_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.ingrediente_id_seq OWNED BY public.ingrediente.id;


--
-- Name: login_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.login_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.login_id_seq OWNER TO postgres;

--
-- Name: login_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.login_id_seq OWNED BY public.login.id;


--
-- Name: pagamento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pagamento (
    id integer NOT NULL,
    pedido_id integer NOT NULL,
    pix numeric(10,2),
    dinheiro numeric(10,2),
    cartao numeric(10,2),
    CONSTRAINT pagamento_check CHECK (((pix IS NOT NULL) OR (dinheiro IS NOT NULL) OR (cartao IS NOT NULL)))
);


ALTER TABLE public.pagamento OWNER TO postgres;

--
-- Name: pagamento_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pagamento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.pagamento_id_seq OWNER TO postgres;

--
-- Name: pagamento_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pagamento_id_seq OWNED BY public.pagamento.id;


--
-- Name: pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pedido (
    id integer NOT NULL,
    cliente_id integer NOT NULL,
    data_pedido timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    status_pedido_id integer NOT NULL,
    entrega_id integer NOT NULL,
    reembolsado character varying(100)
);


ALTER TABLE public.pedido OWNER TO postgres;

--
-- Name: status_pedido; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.status_pedido (
    id integer NOT NULL,
    progresso character varying(100) NOT NULL
);


ALTER TABLE public.status_pedido OWNER TO postgres;

--
-- Name: pedido_completo; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW public.pedido_completo AS
 SELECT p.id,
    c.id AS cliente_id,
    c.nome AS cliente_nome,
    p.data_pedido,
    sp.id AS status_id,
    sp.progresso AS status_progresso,
    e.id AS entrega_id,
    e.chave,
    e.ender_id,
    e.cep,
    e.bairro_id,
    e.bairro_nome,
    e.complemento,
    e.rua,
    e.numero,
    e.valor,
    p.reembolsado
   FROM (((public.pedido p
     JOIN public.cliente c ON ((p.cliente_id = c.id)))
     JOIN public.status_pedido sp ON ((p.status_pedido_id = sp.id)))
     JOIN public.entrega_completa e ON ((p.entrega_id = e.id)));


ALTER VIEW public.pedido_completo OWNER TO postgres;

--
-- Name: pedido_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.pedido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.pedido_id_seq OWNER TO postgres;

--
-- Name: pedido_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.pedido_id_seq OWNED BY public.pedido.id;


--
-- Name: produto_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.produto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.produto_id_seq OWNER TO postgres;

--
-- Name: produto_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.produto_id_seq OWNED BY public.produto.id;


--
-- Name: status_pedido_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.status_pedido_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.status_pedido_id_seq OWNER TO postgres;

--
-- Name: status_pedido_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.status_pedido_id_seq OWNED BY public.status_pedido.id;


--
-- Name: telefone_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.telefone_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.telefone_id_seq OWNER TO postgres;

--
-- Name: telefone_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.telefone_id_seq OWNED BY public.telefone.id;


--
-- Name: bairro id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bairro ALTER COLUMN id SET DEFAULT nextval('public.bairro_id_seq'::regclass);


--
-- Name: carrinho id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carrinho ALTER COLUMN id SET DEFAULT nextval('public.carrinho_id_seq'::regclass);


--
-- Name: cartao id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cartao ALTER COLUMN id SET DEFAULT nextval('public.cartao_id_seq'::regclass);


--
-- Name: cliente id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente ALTER COLUMN id SET DEFAULT nextval('public.cliente_id_seq'::regclass);


--
-- Name: cupom id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cupom ALTER COLUMN id SET DEFAULT nextval('public.cupom_id_seq'::regclass);


--
-- Name: endereco id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco ALTER COLUMN id SET DEFAULT nextval('public.endereco_id_seq'::regclass);


--
-- Name: entrega id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entrega ALTER COLUMN id SET DEFAULT nextval('public.entrega_id_seq'::regclass);


--
-- Name: funcionario id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario ALTER COLUMN id SET DEFAULT nextval('public.funcionario_id_seq'::regclass);


--
-- Name: ingrediente id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingrediente ALTER COLUMN id SET DEFAULT nextval('public.ingrediente_id_seq'::regclass);


--
-- Name: ingrediente_escolha id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingrediente_escolha ALTER COLUMN id SET DEFAULT nextval('public.ingrediente_escolha_id_seq'::regclass);


--
-- Name: login id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.login ALTER COLUMN id SET DEFAULT nextval('public.login_id_seq'::regclass);


--
-- Name: pagamento id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamento ALTER COLUMN id SET DEFAULT nextval('public.pagamento_id_seq'::regclass);


--
-- Name: pedido id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido ALTER COLUMN id SET DEFAULT nextval('public.pedido_id_seq'::regclass);


--
-- Name: produto id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto ALTER COLUMN id SET DEFAULT nextval('public.produto_id_seq'::regclass);


--
-- Name: status_pedido id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.status_pedido ALTER COLUMN id SET DEFAULT nextval('public.status_pedido_id_seq'::regclass);


--
-- Name: telefone id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.telefone ALTER COLUMN id SET DEFAULT nextval('public.telefone_id_seq'::regclass);


--
-- Data for Name: bairro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.bairro (id, nome) FROM stdin;
1	teste
2	22
5	Numero tres
6	Numero tres
7	Numero tres
8	Numero tres
9	Numero tres
11	Numero tres
12	Numero tres
13	Numero tres
14	Numero tres
15	Numero tres
17	Numero tres
18	Numero tres
19	Numero tres
20	Numero qqq
23	Numero qqq
25	Numero qqq
26	Numero qqq
27	Numero qqq
28	Numero qqq
29	Numero qqq
30	Numero qqq
3	Vila Avestruz Que Voa
16	Reaven Clouds
35	Canaa III
\.


--
-- Data for Name: carrinho; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.carrinho (id, pedido_id, produto_id, quantidade) FROM stdin;
1	2	8	1
3	4	10	5
4	4	8	2
5	2	10	3
\.


--
-- Data for Name: cartao; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cartao (id, numero, cvv, iscredito, cliente_id) FROM stdin;
4	1231224412312244	412	f	1
2	5553834681730222	321	f	2
5	8872874295717522	777	t	1
\.


--
-- Data for Name: cliente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cliente (id, nome, telefone_id) FROM stdin;
1	Cliente Premium	4
2	Cliente Bad Boys	5
4	Cliente	2
5	Ivan Luiz Pivetta de Oliveira	7
\.


--
-- Data for Name: cupom; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cupom (id, valor, codigo, validade, pagamento_id) FROM stdin;
1	5.00	f345	2025-01-01	3
2	6.00	hesoyam	2026-12-31	5
4	3.00	asdasd	2025-12-31	6
\.


--
-- Data for Name: endereco; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.endereco (id, cep, bairro_id, complemento, rua, numero) FROM stdin;
3	79804020	3	Escritorio	Mangueiras	99
4	79820200	16	Casa	Éther	111
5	79840497	35	casa	Tio Juca	3240
\.


--
-- Data for Name: entrega; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.entrega (id, chave, endereco_id, valor) FROM stdin;
2	PEIXE	4	12.50
4	JANELA	3	7.81
5	COLA	5	10.50
\.


--
-- Data for Name: funcionario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.funcionario (id, nome, telefone_id, login_id, cpf, rg) FROM stdin;
3	Kelvin Pivetta	3	3	89883113883	8319494
1	Ivan Luiz Pivetta de Oliveira	2	1	12332112344	1234321
\.


--
-- Data for Name: ingrediente; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ingrediente (id, nome, valor) FROM stdin;
1	Alface	0.50
2	Bacon	2.00
\.


--
-- Data for Name: ingrediente_escolha; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.ingrediente_escolha (id, ingrediente_id, carrinho_id, toexclude) FROM stdin;
1	1	4	f
2	2	4	t
4	2	5	f
\.


--
-- Data for Name: login; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.login (id, login, senha) FROM stdin;
1	ivan	senhaivan
3	Kelvin	senhakervins
\.


--
-- Data for Name: pagamento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pagamento (id, pedido_id, pix, dinheiro, cartao) FROM stdin;
3	4	44.00	66.00	55.00
2	4	0.00	88.00	77.00
5	2	20.00	0.00	0.00
6	3	0.00	0.00	30.00
\.


--
-- Data for Name: pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pedido (id, cliente_id, data_pedido, status_pedido_id, entrega_id, reembolsado) FROM stdin;
3	1	2025-06-01 20:47:21.423849	1	2	no
2	1	2025-06-01 20:47:08.974378	3	4	
4	5	2025-06-01 20:54:16.459069	2	5	\N
\.


--
-- Data for Name: produto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.produto (id, nome, valor) FROM stdin;
8	X salada	18.00
10	X Tudo	25.99
\.


--
-- Data for Name: status_pedido; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.status_pedido (id, progresso) FROM stdin;
1	Aguardando Pagamento
2	Em preparação
3	Saiu para Entrega
\.


--
-- Data for Name: telefone; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.telefone (id, ddd, numero) FROM stdin;
2	67	99999999
3	48	88888888
4	33	40301020
5	12	10203040
7	67	996021942
\.


--
-- Name: bairro_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.bairro_id_seq', 35, true);


--
-- Name: carrinho_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.carrinho_id_seq', 5, true);


--
-- Name: cartao_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cartao_id_seq', 7, true);


--
-- Name: cliente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cliente_id_seq', 5, true);


--
-- Name: cupom_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cupom_id_seq', 4, true);


--
-- Name: endereco_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.endereco_id_seq', 5, true);


--
-- Name: entrega_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.entrega_id_seq', 5, true);


--
-- Name: funcionario_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.funcionario_id_seq', 4, true);


--
-- Name: ingrediente_escolha_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ingrediente_escolha_id_seq', 4, true);


--
-- Name: ingrediente_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.ingrediente_id_seq', 3, true);


--
-- Name: login_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.login_id_seq', 3, true);


--
-- Name: pagamento_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pagamento_id_seq', 8, true);


--
-- Name: pedido_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.pedido_id_seq', 4, true);


--
-- Name: produto_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.produto_id_seq', 10, true);


--
-- Name: status_pedido_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.status_pedido_id_seq', 4, true);


--
-- Name: telefone_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.telefone_id_seq', 7, true);


--
-- Name: bairro bairro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bairro
    ADD CONSTRAINT bairro_pkey PRIMARY KEY (id);


--
-- Name: carrinho carrinho_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carrinho
    ADD CONSTRAINT carrinho_pkey PRIMARY KEY (id);


--
-- Name: cartao cartao_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cartao
    ADD CONSTRAINT cartao_pkey PRIMARY KEY (id);


--
-- Name: cliente cliente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_pkey PRIMARY KEY (id);


--
-- Name: cupom cupom_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cupom
    ADD CONSTRAINT cupom_pkey PRIMARY KEY (id);


--
-- Name: endereco endereco_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_pkey PRIMARY KEY (id);


--
-- Name: entrega entrega_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entrega
    ADD CONSTRAINT entrega_pkey PRIMARY KEY (id);


--
-- Name: funcionario funcionario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (id);


--
-- Name: ingrediente_escolha ingrediente_escolha_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingrediente_escolha
    ADD CONSTRAINT ingrediente_escolha_pkey PRIMARY KEY (id);


--
-- Name: ingrediente ingrediente_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingrediente
    ADD CONSTRAINT ingrediente_pkey PRIMARY KEY (id);


--
-- Name: login login_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.login
    ADD CONSTRAINT login_pkey PRIMARY KEY (id);


--
-- Name: pagamento pagamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamento
    ADD CONSTRAINT pagamento_pkey PRIMARY KEY (id);


--
-- Name: pedido pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_pkey PRIMARY KEY (id);


--
-- Name: produto produto_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.produto
    ADD CONSTRAINT produto_pkey PRIMARY KEY (id);


--
-- Name: status_pedido status_pedido_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.status_pedido
    ADD CONSTRAINT status_pedido_pkey PRIMARY KEY (id);


--
-- Name: telefone telefone_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.telefone
    ADD CONSTRAINT telefone_pkey PRIMARY KEY (id);


--
-- Name: carrinho carrinho_pedido_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carrinho
    ADD CONSTRAINT carrinho_pedido_id_fkey FOREIGN KEY (pedido_id) REFERENCES public.pedido(id);


--
-- Name: carrinho carrinho_produto_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.carrinho
    ADD CONSTRAINT carrinho_produto_id_fkey FOREIGN KEY (produto_id) REFERENCES public.produto(id);


--
-- Name: cartao cartao_cliente_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cartao
    ADD CONSTRAINT cartao_cliente_id_fkey FOREIGN KEY (cliente_id) REFERENCES public.cliente(id);


--
-- Name: cliente cliente_telefone_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cliente
    ADD CONSTRAINT cliente_telefone_id_fkey FOREIGN KEY (telefone_id) REFERENCES public.telefone(id);


--
-- Name: cupom cupom_pagamento_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cupom
    ADD CONSTRAINT cupom_pagamento_id_fkey FOREIGN KEY (pagamento_id) REFERENCES public.pagamento(id);


--
-- Name: endereco endereco_bairro_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.endereco
    ADD CONSTRAINT endereco_bairro_id_fkey FOREIGN KEY (bairro_id) REFERENCES public.bairro(id);


--
-- Name: entrega entrega_endereco_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entrega
    ADD CONSTRAINT entrega_endereco_id_fkey FOREIGN KEY (endereco_id) REFERENCES public.endereco(id);


--
-- Name: funcionario funcionario_login_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_login_id_fkey FOREIGN KEY (login_id) REFERENCES public.login(id);


--
-- Name: funcionario funcionario_telefone_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_telefone_id_fkey FOREIGN KEY (telefone_id) REFERENCES public.telefone(id);


--
-- Name: ingrediente_escolha ingrediente_escolha_carrinho_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingrediente_escolha
    ADD CONSTRAINT ingrediente_escolha_carrinho_id_fkey FOREIGN KEY (carrinho_id) REFERENCES public.carrinho(id);


--
-- Name: ingrediente_escolha ingrediente_escolha_ingrediente_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.ingrediente_escolha
    ADD CONSTRAINT ingrediente_escolha_ingrediente_id_fkey FOREIGN KEY (ingrediente_id) REFERENCES public.ingrediente(id);


--
-- Name: pagamento pagamento_pedido_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pagamento
    ADD CONSTRAINT pagamento_pedido_id_fkey FOREIGN KEY (pedido_id) REFERENCES public.pedido(id);


--
-- Name: pedido pedido_cliente_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_cliente_id_fkey FOREIGN KEY (cliente_id) REFERENCES public.cliente(id);


--
-- Name: pedido pedido_entrega_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_entrega_id_fkey FOREIGN KEY (entrega_id) REFERENCES public.entrega(id);


--
-- Name: pedido pedido_status_pedido_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pedido
    ADD CONSTRAINT pedido_status_pedido_id_fkey FOREIGN KEY (status_pedido_id) REFERENCES public.status_pedido(id);


--
-- PostgreSQL database dump complete
--

