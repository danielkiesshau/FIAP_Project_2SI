CREATE TABLE spacecup_equipes(

    nome_equipe VARCHAR2(100) CONSTRAINT spacecup_equipes PRIMARY KEY,
    senha       VARCHAR2(100) NOT NULL,
    turma       VARCHAR(20) NOT NULL

);

CREATE TABLE spacecup_alunos(

    rm          NUMBER(5) CONSTRAINT spacecup_alunos_pk PRIMARY KEY,
    nome        VARCHAR2(100) NOT NULL,
    nome_equipe VARCHAR(100) NOT NULL
    
);

CREATE TABLE spacecup_lancamentos(

    nr_lancamento    NUMBER(5) NOT NULL,
    angulolancamento NUMBER(10),
    distalvo         NUMBER(10),
    velvento         NUMBER(10),
    altmax           NUMBER(10),
    velmax           NUMBER(10),   
    tempoprop        NUMBER(10),   
    picoacel         NUMBER(10),
    acelmedia        NUMBER(10),
    tmpapogdesc      NUMBER(10),   
    tempoeje         NUMBER(10),   
    alteje           NUMBER(10),   
    taxdesc          NUMBER(10),   
    durvoo           NUMBER(10),       
    data             DATE,   
    hora             VARCHAR2(50),
    nome_equipe      VARCHAR2(100) NOT NULL,
    codigo_foguete   NUMBER(5) NOT NULL

);

CREATE TABLE spacecup_foguetes(

  codigo_foguete NUMBER(5) CONSTRAINT spacecup_fog_pk PRIMARY KEY,
  peso           NUMBER(10) NOT NULL,
  cor            VARCHAR2(100) NOT NULL,
  nome           VARCHAR2(100) NOT NULL

);

ALTER TABLE spacecup_lancamentos
ADD CONSTRAINT spacecup_lancamentos_pk 
PRIMARY KEY(nr_lancamento,nome_equipe);

ALTER TABLE spacecup_lancamentos
ADD CONSTRAINT lancamentos_equipes_fk 
FOREIGN KEY(nome_equipe)
REFERENCES spacecup_equipes(nome_equipe);

ALTER TABLE spacecup_lancamentos
ADD CONSTRAINT lanc_fog_fk
FOREIGN KEY(codigo_foguete)
REFERENCES spacecup_foguetes(codigo_foguete);

ALTER TABLE spacecup_alunos
ADD CONSTRAINT alunos_equipes_fk
FOREIGN KEY(nome_equipe)
REFERENCES spacecup_equipes(nome_equipe);



