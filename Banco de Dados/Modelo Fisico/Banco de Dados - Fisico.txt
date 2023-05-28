CREATE DATABASE ifsplife;
USE ifsplife ;

-- -----------------------------------------------------
-- TABELA CAIXA
-- -----------------------------------------------------
CREATE TABLE  caixa (
  codigo_caixa INT NOT NULL,
  abertura TIME NOT NULL,
  fechamento TIME NOT NULL,
  saldo DOUBLE NOT NULL,
  status CHAR(1) NOT NULL,
  totalentradas DOUBLE NOT NULL,
  totalsaidas DOUBLE NOT NULL,
  valorabertura DOUBLE NOT NULL,
  PRIMARY KEY (codigo_caixa));

-- -----------------------------------------------------
-- TABELA FORNECEDORES
-- -----------------------------------------------------
CREATE TABLE  fornecedores (
  codigo_fornecedor INT NOT NULL AUTO_INCREMENT,
  cep VARCHAR(12) NOT NULL,
  cidade VARCHAR(45) NOT NULL,
  cnpj VARCHAR(20) NOT NULL,
  email VARCHAR(45) NOT NULL,
  endereco VARCHAR(45) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  responsavel VARCHAR(45) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  uf VARCHAR(20) NOT NULL,
  PRIMARY KEY (codigo_fornecedor));

-- -----------------------------------------------------
-- TABELA COMPRAS
-- -----------------------------------------------------
CREATE TABLE  compras (
  codigo_compra INT NOT NULL AUTO_INCREMENT,
  data_compra DATE NOT NULL,
  forma_pagamento CHAR(1) NOT NULL,
  valortotal DOUBLE NOT NULL,
  codigo_fornecedor INT NULL DEFAULT NULL,
  PRIMARY KEY (codigo_compra),
  FOREIGN KEY (codigo_fornecedor) REFERENCES fornecedores (codigo_fornecedor));

-- -----------------------------------------------------
-- TABELA CONVENIO
-- -----------------------------------------------------
CREATE TABLE  convenios (
  codigo_convenio INT NOT NULL AUTO_INCREMENT,
  cnpj VARCHAR(20) NOT NULL,
  desconto FLOAT NOT NULL,
  email VARCHAR(255) NOT NULL,
  endereco VARCHAR(255) NOT NULL,
  nome VARCHAR(255) NOT NULL,
  telefone VARCHAR(255) NOT NULL,
  PRIMARY KEY (codigo_convenio));

-- -----------------------------------------------------
-- TABELA DESPESAS
-- -----------------------------------------------------
CREATE TABLE  despesas (
  codigo_despesa INT NOT NULL,
  data_vencimento DATE NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  status VARCHAR(20) NOT NULL,
  valor DOUBLE NOT NULL,
  caixa_codigo_caixa INT NOT NULL,
  PRIMARY KEY (codigo_despesa),
    FOREIGN KEY (caixa_codigo_caixa) REFERENCES caixa (codigo_caixa));

-- -----------------------------------------------------
-- TABELA FUNCIONARIOS
-- -----------------------------------------------------
CREATE TABLE  funcionarios (
  codigo_funcionario INT NOT NULL AUTO_INCREMENT,
  cep VARCHAR(12) NOT NULL,
  cidade VARCHAR(45) NOT NULL,
  cpf VARCHAR(15) NOT NULL,
  endereco VARCHAR(45) NOT NULL,
  login VARCHAR(45) NOT NULL,
  nivelacesso VARCHAR(45) NOT NULL,
  nome VARCHAR(255) NOT NULL,
  salario VARCHAR(50) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  uf VARCHAR(20) NOT NULL,
  PRIMARY KEY (codigo_funcionario));

-- -----------------------------------------------------
-- TABELA ITEM
-- -----------------------------------------------------
CREATE TABLE  item (
  codigo_item INT NOT NULL AUTO_INCREMENT,
  categoria VARCHAR(45) NOT NULL,
  data_fabricacao DATE NOT NULL,
  data_validade DATE NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  dosagem VARCHAR(255) NULL DEFAULT NULL,
  lote INT NOT NULL,
  nome VARCHAR(255) NOT NULL,
  quantidade INT NOT NULL,
  valor FLOAT NOT NULL,
  PRIMARY KEY (codigo_item));

-- -----------------------------------------------------
-- TABELA ITEM COMPRA
-- -----------------------------------------------------
CREATE TABLE  itemcompra (
  preco FLOAT NOT NULL,
  subtotal FLOAT NOT NULL,
  quantidade INT NOT NULL,
  codigo_compra INT NOT NULL,
  codigo_item INT NOT NULL,
  PRIMARY KEY (codigo_compra, codigo_item),
    FOREIGN KEY (codigo_compra) REFERENCES compras (codigo_compra),
    FOREIGN KEY (codigo_item) REFERENCES item (codigo_item));

-- -----------------------------------------------------
-- TABELA VENDAS
-- -----------------------------------------------------
CREATE TABLE  vendas (
  codigo_venda INT NOT NULL AUTO_INCREMENT,
  data_venda DATE NOT NULL,
  forma_pagamento CHAR(1) NOT NULL,
  valor_venda FLOAT NOT NULL,
  caixa_idcaixa INT NULL DEFAULT NULL,
  codigo_convenio INT NULL DEFAULT NULL,
  PRIMARY KEY (codigo_venda),
    FOREIGN KEY (caixa_idcaixa) REFERENCES caixa (codigo_caixa),
    FOREIGN KEY (codigo_convenio) REFERENCES convenios (codigo_convenio));

-- -----------------------------------------------------
-- TABELA ITEM VENDA
-- -----------------------------------------------------
CREATE TABLE  itemvenda (
  preco FLOAT NOT NULL,
  subtotal FLOAT NOT NULL,
  quantidade INT NOT NULL,
  codigo_item INT NOT NULL,
  codigo_venda INT NOT NULL,
  PRIMARY KEY (codigo_item, codigo_venda),
    FOREIGN KEY (codigo_item) REFERENCES item (codigo_item),
    FOREIGN KEY (codigo_venda) REFERENCES vendas (codigo_venda));

-- -----------------------------------------------------
-- TABELA MOVIMENTACAO
-- -----------------------------------------------------
CREATE TABLE  movimentacao (
  idMovimentacao INT NOT NULL AUTO_INCREMENT,
  motivo VARCHAR(200) NOT NULL,
  tipo INT NOT NULL,
  valor DOUBLE NOT NULL,
  codigo_caixa INT NOT NULL,
  PRIMARY KEY (idMovimentacao, codigo_caixa),
    FOREIGN KEY (codigo_caixa) REFERENCES caixa (codigo_caixa));
    
-- -----------------------------------------------------
-- TABELA PAGAMENTO
-- -----------------------------------------------------
CREATE TABLE  pagamento (
  codigo_pagamento INT NOT NULL AUTO_INCREMENT,
  forma VARCHAR(10) NOT NULL,
  valor DOUBLE NOT NULL,
  codigo_venda INT NOT NULL,
  PRIMARY KEY (codigo_pagamento, codigo_venda),
    FOREIGN KEY (codigo_venda) REFERENCES vendas (codigo_venda));

-- -----------------------------------------------------
-- TABELA PAGAMENTO COMPRA
-- -----------------------------------------------------
CREATE TABLE  pagamentocompra (
  parcela INT NOT NULL,
  valor FLOAT NOT NULL,
  vencimento DATE NOT NULL,
  caixa_idcaixa INT NULL DEFAULT NULL,
  codigo_compra INT NOT NULL,
  PRIMARY KEY (codigo_compra),
    FOREIGN KEY (caixa_idcaixa) REFERENCES caixa (codigo_caixa),
    FOREIGN KEY (codigo_compra) REFERENCES compras (codigo_compra));

-- -----------------------------------------------------
-- INSERTS
-- -----------------------------------------------------