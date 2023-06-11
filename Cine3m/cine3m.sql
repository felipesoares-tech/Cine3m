CREATE TABLE IF NOT EXISTS pessoa (
  id SERIAL PRIMARY KEY,
  nome varchar(45) NOT NULL,
  cpf varchar(11) NOT NULL,
  del boolean NOT NULL DEFAULT false
);  

CREATE TABLE IF NOT EXISTS funcionario (
  fk_funcionario SERIAL PRIMARY KEY,
  login VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  CONSTRAINT fk_table1_pessoa
    FOREIGN KEY (fk_funcionario)
    REFERENCES pessoa (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS cliente (
  fk_cliente SERIAL PRIMARY KEY,
  filmes_assistidos INT NULL,
  CONSTRAINT fk_cliente_pessoa1
    FOREIGN KEY (fk_cliente)
    REFERENCES pessoa (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS filme (
  id SERIAL PRIMARY KEY,
  tipo_genero VARCHAR(45) NOT NULL,
  nome varchar(45) NOT NULL,
  descricao varchar(45) NOT NULL,
  diretor varchar(45) NOT NULL,
  duracao time NOT NULL,
  del boolean NOT NULL DEFAULT false
);

CREATE TABLE IF NOT EXISTS sala (
  id SERIAL PRIMARY KEY,
  nome varchar(45) NOT NULL,
  capacidade int NOT NULL,
  del boolean NOT NULL DEFAULT false
);  

CREATE TABLE IF NOT EXISTS poltrona (
  id SERIAL PRIMARY KEY,
  fk_sala int NOT NULL,
  identificador varchar(45) NOT NULL,
  livre boolean NOT NULL,
  CONSTRAINT identificador_UNIQUE UNIQUE (identificador),
  CONSTRAINT fk_poltrona_sala1 FOREIGN KEY (fk_sala) REFERENCES sala (id)
); 

CREATE TABLE IF NOT EXISTS item_venda (
  id SERIAL PRIMARY KEY,
  fk_poltrona int NOT NULL,
  tipo_venda VARCHAR(45) NOT NULL,
  CONSTRAINT fk_item_venda_poltrona1 FOREIGN KEY (fk_poltrona) REFERENCES poltrona (id)

);

CREATE TABLE IF NOT EXISTS sessao (
  id SERIAL PRIMARY KEY,
  fk_filme int NOT NULL,
  fk_sala int NOT NULL,
  identificador varchar(45) NOT NULL,
  data date NOT NULL,
  hora time NOT NULL,
  hora_final time NOT NULL,
  del boolean NOT NULL DEFAULT false,
  CONSTRAINT fk_sessao_filme1 FOREIGN KEY (fk_filme) REFERENCES filme (id),
  CONSTRAINT fk_sessao_sala1 FOREIGN KEY (fk_sala) REFERENCES sala (id)
);  

CREATE TABLE IF NOT EXISTS venda (
  id SERIAL PRIMARY KEY,
  sessao_id int NOT NULL,
  fk_cliente int NOT NULL,
  fk_funcionario int NOT NULL,
  fk_item_venda int NOT NULL,
  cancelada boolean NOT NULL DEFAULT false,
  desconto boolean NOT NULL DEFAULT false,
  del boolean NOT NULL DEFAULT false,
  CONSTRAINT fk_venda_sessao1 FOREIGN KEY (sessao_id) REFERENCES sessao (id),
  CONSTRAINT fk_venda_cliente1 FOREIGN KEY (fk_cliente) REFERENCES cliente (fk_cliente),
  CONSTRAINT fk_venda_funcionario1 FOREIGN KEY (fk_funcionario) REFERENCES funcionario (fk_funcionario),
  CONSTRAINT fk_venda_item_venda1 FOREIGN KEY (fk_item_venda) REFERENCES item_venda (id)
); 