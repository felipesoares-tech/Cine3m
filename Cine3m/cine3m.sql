CREATE TABLE IF NOT EXISTS funcionario (
  id SERIAL PRIMARY KEY,
  nome varchar(45) NOT NULL,
  cpf varchar(11) NOT NULL,
  login VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  del boolean NOT NULL DEFAULT false
);

CREATE TABLE IF NOT EXISTS cliente (
  id SERIAL PRIMARY KEY,
  nome varchar(45) NOT NULL,
  cpf varchar(11) NOT NULL,
  filmes_assistidos INT NOT NULL DEFAULT 0,
  del boolean NOT NULL DEFAULT false
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
  identificador varchar(100) NOT NULL,
--   livre boolean NOT NULL,
  CONSTRAINT fk_poltrona_sala1 FOREIGN KEY (fk_sala) REFERENCES sala (id)
);

CREATE OR REPLACE FUNCTION criar_poltronas()
    RETURNS TRIGGER AS
$$
DECLARE
    num_filas INTEGER;
    identificador VARCHAR(10);
BEGIN
    num_filas := CEIL(NEW.capacidade / 10.0);

    FOR fila IN 0..(num_filas-1) LOOP
        EXIT WHEN (SELECT COUNT(*) FROM poltrona WHERE fk_sala = NEW.id) >= NEW.capacidade;

        FOR numero IN 1..10 LOOP
            EXIT WHEN (SELECT COUNT(*) FROM poltrona WHERE fk_sala = NEW.id) >= NEW.capacidade;

            identificador := chr(ASCII('A') + fila) || numero;

            INSERT INTO poltrona (fk_sala, identificador)
            VALUES (NEW.id, identificador);
        END LOOP;
    END LOOP;

    RETURN NULL;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER inserir_poltronas
AFTER INSERT ON sala
FOR EACH ROW
EXECUTE FUNCTION criar_poltronas();

CREATE TABLE IF NOT EXISTS sessao (
  id SERIAL PRIMARY KEY,
  fk_filme int NOT NULL,
  fk_sala int NOT NULL,
  identificador varchar(100) NOT NULL,
  data date NOT NULL,
  hora time NOT NULL,
  valor double precision NOT NULL,
  hora_final time NOT NULL,
  del boolean NOT NULL DEFAULT false,
  CONSTRAINT fk_sessao_filme1 FOREIGN KEY (fk_filme) REFERENCES filme (id),
  CONSTRAINT fk_sessao_sala1 FOREIGN KEY (fk_sala) REFERENCES sala (id)
);  

CREATE TABLE reserva (
	id serial primary key,
	fk_poltrona int,
	fk_sessao int,
	fk_cliente int,
	livre bool,
	CONSTRAINT fk_reserva_sessao FOREIGN KEY (fk_sessao) REFERENCES sessao (id),
	CONSTRAINT fk_reserva_cliente FOREIGN KEY (fk_cliente) REFERENCES cliente (id),
	CONSTRAINT fk_reserva_poltrona FOREIGN KEY (fk_poltrona) REFERENCES poltrona (id),
	CONSTRAINT fk_poltrona_sessao_unique UNIQUE (fk_poltrona, fk_sessao)
);

CREATE TABLE IF NOT EXISTS venda (
  id SERIAL PRIMARY KEY,
  fk_sessao int NOT NULL,
  fk_cliente int NOT NULL,
  fk_funcionario int NOT NULL,
  identificador varchar(100) NOT NULL,
  cancelada boolean NOT NULL DEFAULT false,
  desconto boolean NOT NULL DEFAULT false,
  valor_total double precision, 
  del boolean NOT NULL DEFAULT false,
  CONSTRAINT fk_venda_sessao1 FOREIGN KEY (fk_sessao) REFERENCES sessao (id),
  CONSTRAINT fk_venda_cliente1 FOREIGN KEY (fk_cliente) REFERENCES cliente (id),
  CONSTRAINT fk_venda_funcionario1 FOREIGN KEY (fk_funcionario) REFERENCES funcionario (id)
); 

CREATE TABLE IF NOT EXISTS item_venda (
  id SERIAL PRIMARY KEY,
  fk_poltrona int NOT NULL,
  fk_venda int NOT NULL,
  tipo_venda VARCHAR(45) NOT NULL,
  valor double precision NOT NULL,
  CONSTRAINT fk_item_venda_poltrona1 FOREIGN KEY (fk_poltrona) REFERENCES poltrona (id),
  CONSTRAINT fk_item_venda_venda1 FOREIGN KEY (fk_venda) REFERENCES venda (id)
);