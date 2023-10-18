DROP DATABASE if exists ifsplife;
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

#------------------------------------------------------------------------------------------------------------
# INSERTS DE FUNCIONARIOS
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('1', '19470-000', 'Presidente Epitácio', '527.550.908-12', 'Presidente Epitácio', 'admin', 'Administrador', 'Alexandre', '123', 'admin', '(18) 98103-8758', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('2', '11111-111', 'Presidente Epitácio', '111.111.111-11', 'Presidente Epitácio', 'andre', 'Administrador', 'André', '111', 'andre', '(11) 11111-1111', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('3', '22222-222', 'Presidente Epitácio', '222.222.222-22', 'Presidente Epitácio', 'vilson', 'Funcionario', 'Vilson', '222', 'vilson', '(22) 22222-2222', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('4', '33333-333', 'Presidente Epitácio', '333.333.333-33', 'Presidente Epitácio', 'lucia', 'Funcionario', 'Lúcia', '333', 'lucia', '(33) 33333-3333', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('5', '44444-444', 'Presidente Epitácio', '444.444.444-44', 'Presidente Epitácio', 'carlos', 'Funcionario', 'Carlos', '444', 'carlos', '(44) 44444-4444', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('6', '55555-555', 'Presidente Epitácio', '555.555.555-55', 'Presidente Epitácio', 'maria', 'Funcionario', 'Maria', '555', 'maria', '(55) 55555-5555', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('7', '66666-666', 'Presidente Epitácio', '666.666.666-66', 'Presidente Epitácio', 'joao', 'Funcionario', 'João', '666', 'joao', '(66) 66666-6666', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('8', '77777-777', 'Presidente Epitácio', '777.777.777-77', 'Presidente Epitácio', 'ana', 'Funcionario', 'Ana', '777', 'ana', '(77) 77777-7777', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('9', '88888-888', 'Presidente Epitácio', '888.888.888-88', 'Presidente Epitácio', 'pedro', 'Funcionario', 'Pedro', '888', 'pedro', '(88) 88888-8888', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('10', '99999-999', 'Presidente Epitácio', '999.999.999-99', 'Presidente Epitácio', 'laura', 'Funcionario', 'Laura', '999', 'laura', '(99) 99999-9999', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('11', '12345-678', 'Presidente Epitácio', '123.456.789-01', 'Presidente Epitácio', 'marcio', 'Funcionario', 'Márcio', '1234', 'marcio', '(12) 34567-8901', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('12', '98765-432', 'Presidente Epitácio', '987.654.321-09', 'Presidente Epitácio', 'elisa', 'Funcionario', 'Elisa', '9876', 'elisa', '(98) 76543-2109', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('13', '54321-987', 'Presidente Epitácio', '543.219.875-05', 'Presidente Epitácio', 'gabriel', 'Funcionario', 'Gabriel', '5432', 'gabriel', '(54) 32198-7505', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('14', '98712-345', 'Presidente Epitácio', '987.123.456-01', 'Presidente Epitácio', 'lara', 'Funcionario', 'Lara', '9871', 'lara', '(98) 71234-5601', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('15', '87654-321', 'Presidente Epitácio', '876.543.210-09', 'Presidente Epitácio', 'marcos', 'Funcionario', 'Marcos', '8765', 'marcos', '(87) 65432-1009', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('16', '76543-219', 'Presidente Epitácio', '765.432.198-05', 'Presidente Epitácio', 'leticia', 'Funcionario', 'Leticia', '7654', 'leticia', '(76) 54321-9805', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('17', '65432-198', 'Presidente Epitácio', '654.321.980-01', 'Presidente Epitácio', 'renato', 'Funcionario', 'Renato', '6543', 'renato', '(65) 43219-8001', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('18', '54321-987', 'Presidente Epitácio', '543.219.870-09', 'Presidente Epitácio', 'silvia', 'Funcionario', 'Silvia', '5432', 'silvia', '(54) 32198-7009', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('19', '43219-876', 'Presidente Epitácio', '432.198.765-05', 'Presidente Epitácio', 'vitor', 'Funcionario', 'Vitor', '4321', 'vitor', '(43) 21987-6505', 'SP');
INSERT INTO funcionarios (codigo_funcionario, cep, cidade, cpf, endereco, login, nivelacesso, nome, salario, senha, telefone, uf) VALUES ('20', '32198-765', 'Presidente Epitácio', '321.987.650-01', 'Presidente Epitácio', 'marina', 'Funcionario', 'Marina', '3219', 'marina', '(32) 19876-5001', 'SP');

#------------------------------------------------------------------------------------------------------------
# INSERTS DE PRODUTOS
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('1', 'Cosméticos', '2023-07-15', '2023-07-20', 'Um Comestimo', '1', 'Loção Facial', '5', '13.00');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('2', 'Perfumes', '2023-07-15', '2023-07-20', 'Um Perfume', '2', 'Perfume Exótico', '10', '07.00');
INSERT INTO produto (codigo_produto, categoria, dosagem, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('3', 'Medicamentos', '5mg', '2023-07-15', '2023-07-20', 'Aspirina', '3', 'Medicamento', '12', '4.50');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('4', 'Higiene Pessoal', '2023-07-15', '2023-07-20', 'Sabonete Corporal', '4', 'Higiene Pessoal', '16', '6.59');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('5', 'Alimentos', '2023-07-15', '2023-07-20', 'Um Alimento', '5', 'Barras de Chocolate', '3', '8.00');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('6', 'Medicamentos', '2023-07-16', '2023-07-21', 'Outro Medicamento', '6', 'Xarope para Tosse', '8', '5.25');
INSERT INTO produto (codigo_produto, categoria, dosagem, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('7', 'Medicamentos', '10mg', '2023-07-16', '2023-07-21', 'Medicamento Forte', '7', 'Analgésico', '15', '9.99');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('8', 'Cosméticos', '2023-07-16', '2023-07-21', 'Outro Cosmético', '8', 'Creme para o Rosto', '7', '11.50');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('9', 'Higiene Pessoal', '2023-07-16', '2023-07-21', 'Outro objeto de Higiene Pessoal', '9', 'Escova de Cabelo', '20', '4.99');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('10', 'Perfumes', '2023-07-16', '2023-07-21', 'Outro Perfume', '10', 'Perfume Floral', '9', '8.75');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('11', 'Medicamentos', '2023-07-17', '2023-07-22', 'Medicamento Anti-inflamatório', '11', 'Ibuprofeno', '10', '6.75');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('12', 'Higiene Pessoal', '2023-07-17', '2023-07-22', 'Sabonete Líquido', '12', 'Sabonete Líquido Suave', '15', '3.49');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('13', 'Cosméticos', '2023-07-17', '2023-07-22', 'Creme Facial', '13', 'CosméticoCreme Facial Hidratante', '6', '12.99');
INSERT INTO produto (codigo_produto, categoria, dosagem, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('14', 'Medicamentos', '20mg', '2023-07-17', '2023-07-22', 'Medicamento Relaxante', '14', 'Relaxante Muscular', '8', '7.25');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('15', 'Alimentos', '2023-07-17', '2023-07-22', 'Barra de Cereal', '15', 'Barra de Cereal de Frutas', '11', '2.99');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('16', 'Cosméticos', '2023-07-18', '2023-07-23', 'Loção Corporal', '16', 'Loção Corporal Hidratante', '9', '10.99');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('17', 'Higiene Pessoal', '2023-07-18', '2023-07-23', 'Escova de Dentes', '17', 'Escova de Dentes Média', '18', '1.99');
INSERT INTO produto (codigo_produto, categoria, dosagem, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('18', 'Medicamentos', '15mg', '2023-07-18', '2023-07-23', 'Medicamento para Dor de Cabeça', '18', 'Analgésico para Dor de Cabeça', '7', '3.75');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('19', 'Perfumes', '2023-07-18', '2023-07-23', 'Perfume Floral', '19', 'Perfume Floral Amadeirado', '12', '15.50');
INSERT INTO produto (codigo_produto, categoria, data_fabricacao, data_validade, descricao, lote, nome, quantidade, valor) VALUES ('20', 'Alimentos', '2023-07-18', '2023-07-23', 'Vitaminas em Goma', '20', 'Vitaminas em Goma de Frutas', '14', '6.99');
#------------------------------------------------------------------------------------------------------------
# INSERTS DE FORNECEDORES
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('1', '19470-000', 'Presidente Epitácio', '11.111.111/1111.11', 'Alexandre@gmail.com', 'Presidente Epitácio - Alexandre', 'IFSP', 'Alexandre', '(11) 11111-1111', 'SP');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('2', '19470-000', 'Presidente Epitácio', '22.222.222/2222.22', 'Andre@gmail.com', 'Presidente Epitácio - Andre', 'IFSP', 'Andre', '(22) 22222-2222', 'SP');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('3', '19470-000', 'Presidente Epitácio', '33.333.333/3333.33', 'Vilson@gmail.com', 'Presidente Epitácio - Vilson', 'IFSP', 'Vilson', '(33) 33333-3333', 'SP');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('4', '20000-000', 'São Paulo', '44.444.444/4444.44', 'Maria@gmail.com', 'Rua Alegre, 123', 'TechCorp', 'Maria', '(44) 44444-4444', 'SP');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('5', '21000-000', 'Rio de Janeiro', '55.555.555/5555.55', 'Lucas@gmail.com', 'Avenida Principal, 456', 'TechWorld', 'Lucas', '(55) 55555-5555', 'RJ');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('6', '18000-000', 'Sorocaba', '66.666.666/6666.66', 'Pedro@gmail.com', 'Rua das Flores, 789', 'TechSolutions', 'Pedro', '(66) 66666-6666', 'SP');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('7', '23000-000', 'Belém', '77.777.777/7777.77', 'Ana@gmail.com', 'Avenida da Paz, 101', 'TechBrasil', 'Ana', '(77) 77777-7777', 'PA');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('8', '24000-000', 'Natal', '88.888.888/8888.88', 'Carlos@gmail.com', 'Rua das Palmeiras, 303', 'TechNatal', 'Carlos', '(88) 88888-8888', 'RN');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('9', '25000-000', 'Curitiba', '99.999.999/9999.99', 'Mariana@gmail.com', 'Avenida da Inovação, 505', 'TechParaná', 'Mariana', '(99) 99999-9999', 'PR');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('10', '26000-000', 'Recife', '10.101.101/1010.10', 'Paulo@gmail.com', 'Rua do Progresso, 707', 'TechPE', 'Paulo', '(10) 10101-1010', 'PE');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('11', '27000-000', 'Fortaleza', '11.111.111/1111.11', 'Tatiana@gmail.com', 'Avenida do Futuro, 909', 'TechCE', 'Tatiana', '(11) 11111-1111', 'CE');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('12', '28000-000', 'Salvador', '12.121.121/1212.12', 'Rafael@gmail.com', 'Rua Salvador, 111', 'TechBahia', 'Rafael', '(12) 12121-1212', 'BA');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('13', '29000-000', 'Vitória', '13.131.131/1313.13', 'Aline@gmail.com', 'Avenida das Ondas, 606', 'TechVitória', 'Aline', '(13) 13131-1313', 'ES');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('14', '30000-000', 'Belo Horizonte', '14.141.141/1414.14', 'Diego@gmail.com', 'Rua das Montanhas, 212', 'TechMinas', 'Diego', '(14) 14141-1414', 'MG');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('15', '31000-000', 'Brasília', '15.151.151/1515.15', 'Camila@gmail.com', 'Avenida do Planalto, 313', 'TechDF', 'Camila', '(15) 15151-1515', 'DF');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('16', '32000-000', 'Belo Horizonte', '16.161.161/1616.16', 'Renata@gmail.com', 'Avenida das Flores, 111', 'TechBelo', 'Renata', '(16) 16161-1616', 'MG');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('17', '33000-000', 'Niterói', '17.171.171/1717.17', 'Fernando@gmail.com', 'Rua das Palmeiras, 212', 'TechNiterói', 'Fernando', '(17) 17171-1717', 'RJ');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('18', '34000-000', 'Porto Alegre', '18.181.181/1818.18', 'Patricia@gmail.com', 'Avenida da Inovação, 313', 'TechRS', 'Patricia', '(18) 18181-1818', 'RS');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('19', '35000-000', 'Goiânia', '19.191.191/1919.19', 'Ricardo@gmail.com', 'Rua Goiás, 414', 'TechGoiás', 'Ricardo', '(19) 19191-1919', 'GO');
INSERT INTO fornecedores (codigo_fornecedor, cep, cidade, cnpj, email, endereco, nome, responsavel, telefone, uf) VALUES ('20', '36000-000', 'Manaus', '20.202.202/2020.20', 'Laura@gmail.com', 'Avenida do Amazonas, 515', 'TechManaus', 'Laura', '(20) 20202-2020', 'AM');
#------------------------------------------------------------------------------------------------------------
# INSERTS DE CONVENIOS
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('1', '11.111.111/1111.11', '10.00', 'unimed@gmail.com', 'São Paulo', 'UNIMED', '(11) 11111-1111');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('2', '22.222.222/2222.22', '05.00', 'ifsp@gmail.com', 'Presidente Epitácio', 'IFSP', '(22) 22222-2222');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('3', '33.333.333/3333.33', '05.00', 'etec@gmail.com', 'Presidente Venceslau', 'ETEC', '(33) 33333-3333');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('4', '44.444.444/4444.44', '15.00', 'bradesco@gmail.com', 'Rio de Janeiro', 'Bradesco', '(44) 44444-4444');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('5', '55.555.555/5555.55', '12.00', 'itau@gmail.com', 'São Paulo', 'Itaú', '(55) 55555-5555');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('6', '66.666.666/6666.66', '10.00', 'caixa@gmail.com', 'Rio de Janeiro', 'Caixa Econômica', '(66) 66666-6666');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('7', '77.777.777/7777.77', '10.00', 'santander@gmail.com', 'São Paulo', 'Santander', '(77) 77777-7777');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('8', '88.888.888/8888.88', '08.00', 'brasil@gmail.com', 'Rio de Janeiro', 'Banco do Brasil', '(88) 88888-8888');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('9', '99.999.999/9999.99', '07.00', 'ibm@gmail.com', 'São Paulo', 'IBM', '(99) 99999-9999');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('10', '10.101.010/1010.10', '05.00', 'apple@gmail.com', 'Cupertino', 'Apple Inc.', '(10) 10101-0101');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('11', '11.111.111/1111.11', '10.00', 'google@gmail.com', 'Mountain View', 'Google LLC', '(11) 11111-1111');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('12', '12.121.212/1212.12', '15.00', 'microsoft@gmail.com', 'Redmond', 'Microsoft', '(12) 12121-2121');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('13', '13.131.313/1313.13', '10.00', 'amazon@gmail.com', 'Seattle', 'Amazon', '(13) 13131-3131');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('14', '14.141.414/1414.14', '08.00', 'facebook@gmail.com', 'Menlo Park', 'Facebook', '(14) 14141-4141');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('15', '15.151.515/1515.15', '07.00', 'twitter@gmail.com', 'San Francisco', 'Twitter', '(15) 15151-5151');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('16', '16.161.616/1616.16', '06.00', 'linkedin@gmail.com', 'Sunnyvale', 'LinkedIn', '(16) 16161-6161');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('17', '17.171.717/1717.17', '12.00', 'netflix@gmail.com', 'Los Gatos', 'Netflix', '(17) 17171-7171');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('18', '18.181.818/1818.18', '10.00', 'uber@gmail.com', 'San Francisco', 'Uber', '(18) 18181-8181');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('19', '19.191.919/1919.19', '08.00', 'airbnb@gmail.com', 'San Francisco', 'Airbnb', '(19) 19191-9191');
INSERT INTO convenios (codigo_convenio, cnpj, desconto, email, endereco, nome, telefone) VALUES ('20', '20.202.020/2020.20', '07.00', 'tesla@gmail.com', 'Palo Alto', 'Tesla', '(20) 20202-0202');