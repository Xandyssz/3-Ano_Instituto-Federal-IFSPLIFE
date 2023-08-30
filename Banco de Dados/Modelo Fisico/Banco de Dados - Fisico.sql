CREATE DATABASE ifsplife;
USE ifsplife;

CREATE TABLE  caixa (
  codigo_caixa INT NOT NULL AUTO_INCREMENT,
  data_abertura DATE NOT NULL,
  data_fechamento DATE NULL DEFAULT NULL,
  horario_abertura TIME NOT NULL,
  horario_fechamento TIME NULL DEFAULT NULL,
  status VARCHAR(255) NOT NULL,
  total_entradas DOUBLE NULL DEFAULT NULL,
  total_saidas DOUBLE NULL DEFAULT NULL,
  valor_abertura DOUBLE NULL DEFAULT NULL,
  valor_fechamento DOUBLE NULL DEFAULT NULL,
  PRIMARY KEY (codigo_caixa));

CREATE TABLE  despesas (
  codigo_despesa INT NOT NULL,
  data_vencimento DATE NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  status VARCHAR(20) NOT NULL,
  valor DOUBLE NOT NULL,
  PRIMARY KEY (codigo_despesa));

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

CREATE TABLE  compras (
  codigo_compra INT NOT NULL AUTO_INCREMENT,
  data_compra DATE NOT NULL,
  forma_pagamento VARCHAR(255) NOT NULL,
  valortotal DOUBLE NOT NULL,
  codigo_fornecedor INT NOT NULL,
  PRIMARY KEY (codigo_compra),
    FOREIGN KEY (codigo_fornecedor) REFERENCES fornecedores (codigo_fornecedor));

CREATE TABLE  convenios (
  codigo_convenio INT NOT NULL AUTO_INCREMENT,
  cnpj VARCHAR(20) NOT NULL,
  desconto DOUBLE NOT NULL,
  email VARCHAR(255) NOT NULL,
  endereco VARCHAR(255) NOT NULL,
  nome VARCHAR(255) NOT NULL,
  telefone VARCHAR(255) NOT NULL,
  PRIMARY KEY (codigo_convenio));

CREATE TABLE  funcionarios (
  codigo_funcionario INT NOT NULL AUTO_INCREMENT,
  cep VARCHAR(12) NOT NULL,
  cidade VARCHAR(45) NOT NULL,
  cpf VARCHAR(15) NOT NULL,
  endereco VARCHAR(45) NOT NULL,
  login VARCHAR(45) NOT NULL,
  nivelacesso VARCHAR(45) NOT NULL,
  nome VARCHAR(255) NOT NULL,
  salario DOUBLE NOT NULL,
  senha VARCHAR(45) NOT NULL,
  telefone VARCHAR(20) NOT NULL,
  uf VARCHAR(20) NOT NULL,
  PRIMARY KEY (codigo_funcionario));

CREATE TABLE  movimentacao (
  codigo_movimentacao INT NOT NULL AUTO_INCREMENT,
  codigo_caixa INT NOT NULL,
  motivo VARCHAR(200) NOT NULL,
  tipo VARCHAR(255) NOT NULL,
  valor DOUBLE NOT NULL,
  PRIMARY KEY (codigo_movimentacao, codigo_caixa),
    FOREIGN KEY (codigo_caixa) REFERENCES caixa (codigo_caixa));

CREATE TABLE  pagamentocompra (
  parcela INT NOT NULL,
  valor DOUBLE NOT NULL,
  vencimento DATE NOT NULL,
  status VARCHAR(45) NULL DEFAULT 'Pendente',
  codigo_caixa INT NOT NULL,
  codigo_compra INT NOT NULL,
  PRIMARY KEY (codigo_compra, parcela),
    FOREIGN KEY (codigo_caixa) REFERENCES caixa (codigo_caixa),
    FOREIGN KEY (codigo_compra) REFERENCES compras (codigo_compra));

CREATE TABLE  produto (
  codigo_produto INT NOT NULL AUTO_INCREMENT,
  categoria VARCHAR(45) NOT NULL,
  data_fabricacao DATE NOT NULL,
  data_validade DATE NOT NULL,
  descricao VARCHAR(255) NOT NULL,
  dosagem VARCHAR(255) NULL DEFAULT NULL,
  lote INT NOT NULL,
  nome VARCHAR(255) NOT NULL,
  quantidade INT NOT NULL,
  valor DOUBLE NOT NULL,
  PRIMARY KEY (codigo_produto));

CREATE TABLE  produtocompra (
  preco DOUBLE NOT NULL,
  quantidade INT NOT NULL,
  subtotal DOUBLE NOT NULL,
  codigo_compra INT NOT NULL,
  codigo_produto INT NOT NULL,
  PRIMARY KEY (codigo_compra, codigo_produto),
    FOREIGN KEY (codigo_compra) REFERENCES compras (codigo_compra),
    FOREIGN KEY (codigo_produto) REFERENCES produto (codigo_produto));

CREATE TABLE  vendas (
  codigo_venda INT NOT NULL AUTO_INCREMENT,
  data_venda DATE NOT NULL,
  forma_pagamento VARCHAR(255) NOT NULL,
  valor_venda DOUBLE NOT NULL,
  codigo_caixa INT NOT NULL,
  codigo_convenio INT NOT NULL,
  PRIMARY KEY (codigo_venda),
    FOREIGN KEY (codigo_caixa) REFERENCES caixa (codigo_caixa),
    FOREIGN KEY (codigo_convenio) REFERENCES convenios (codigo_convenio));

CREATE TABLE  produtovenda (
  preco DOUBLE NOT NULL,
  quantidade INT NOT NULL,
  subtotal DOUBLE NOT NULL,
  codigo_produto INT NOT NULL,
  codigo_venda INT NOT NULL,
  PRIMARY KEY (codigo_produto, codigo_venda),
    FOREIGN KEY (codigo_produto) REFERENCES produto (codigo_produto),
    FOREIGN KEY (codigo_venda) REFERENCES vendas (codigo_venda));

# INSERTS DE FUNCIONARIOS
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('1', '19470-000', 'Presidente Epitácio', '527.550.908.12', 'Presidente Epitácio', 'admin', 'Administrador', 'Alexandre', '123', 'admin', '(18)98103-8758', 'SP');

INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('2', '11111-111', 'Presidente Epitácio', '111.111.111.11', 'Presidente Epitácio', 'andre', 'Administrador', 'André', '111', 'andre', '(11)11111-1111', 'SP');

INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('3', '22222-222', 'Presidente Epitácio', '222.222.222.22', 'Presidente Epitácio', 'vilson', 'Administrador', 'Vilson', '222', 'vilson', '(22)22222-2222', 'SP');

#------------------------------------------------------------------------------------------------------------

# INSERTS DE PRODUTOS

INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('1', 'Cosméticos', '2023-07-15', '2023-07-20', 'Um Comestimo', '1', 'Cosmético', '5', '13.00');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('2', 'Perfumes', '2023-07-15', '2023-07-20', 'Um Perfume', '2', 'Perfume', '10', '07.00');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('3', 'Medicamentos', '2023-07-15', '2023-07-20', 'Um Medicamento', '3', 'Medicamento', '12', '4.50');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('4', 'Higiene Pessoal', '2023-07-15', '2023-07-20', 'Um objeto de Higiene Pessoal', '4', 'Higiene Pessoal', '16', '6.59');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('5', 'Alimentos', '2023-07-15', '2023-07-20', 'Um Alimento', '5', 'Alimento', '3', '8.00');

#------------------------------------------------------------------------------------------------------------

# INSERTS DE FORNECEDORES

INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('1', '19470-000', 'Presidente Epitácio', '11.111.111/1111.11', 'Alexandre@gmail.com', 'Presidente Epitácio - Alexandre', 'IFSP', 'Alexandre', '(11)11111-1111', 'SP');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('2', '19470-000', 'Presidente Epitácio', '22.222.222/2222.22', 'Andre@gmail.com', 'Presidente Epitácio - Andre', 'IFSP', 'Andre', '(22)22222-2222', 'SP');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('3', '19470-000', 'Presidente Epitácio', '33.333.333/3333.33', 'Vilson@gmail.com', 'Presidente Epitácio - Vilson', 'IFSP', 'Vilson', '(33)33333-3333', 'SP');

#------------------------------------------------------------------------------------------------------------

# INSERTS DE CONVENIOS

INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('1', '11.111.111/1111.11', '10.00', 'unimed@gmail.com', 'São Paulo', 'UNIMED', '(11)11111-1111');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('2', '22.222.222/2222.22', '05.00', 'ifsp@gmail.com', 'Presidente Epitácio', 'IFSP', '(22)22222-2222');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('3', '33.333.333/3333.33', '05.00', 'etec@gmail.com', 'Presidente Venceslau', 'ETEC', '(33)33333-3333');
