-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ifsplife
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ifsplife
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ifsplife` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ifsplife` ;

-- -----------------------------------------------------
-- Table `ifsplife`.`funcionarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`funcionarios` (
  `codigo_funcionario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `cpf` VARCHAR(15) NOT NULL,
  `nivelacesso` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(20) NOT NULL,
  `endereco` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(12) NOT NULL,
  `uf` VARCHAR(20) NOT NULL,
  `salario` DOUBLE NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo_funcionario`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifsplife`.`caixa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`caixa` (
  `codigo_caixa` INT NOT NULL,
  `codigo_funcionario` INT NOT NULL,
  `data_abertura` DATE NOT NULL,
  `data_fechamento` DATE NOT NULL,
  `horario_abertura` TIME NOT NULL,
  `horario_fechamento` TIME NOT NULL,
  `valor_inicial` DOUBLE NOT NULL,
  `valor_final` DOUBLE NOT NULL,
  PRIMARY KEY (`codigo_caixa`),
  INDEX `fk_caixa_funcionarios1_idx` (`codigo_funcionario` ASC) VISIBLE,
  CONSTRAINT `fk_caixa_funcionarios1`
    FOREIGN KEY (`codigo_funcionario`)
    REFERENCES `ifsplife`.`funcionarios` (`codigo_funcionario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifsplife`.`fornecedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`fornecedores` (
  `codigo_fornecedor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cnpj` VARCHAR(20) NOT NULL,
  `telefone` VARCHAR(20) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(12) NOT NULL,
  `uf` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`codigo_fornecedor`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifsplife`.`compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`compras` (
  `codigo_compra` INT NOT NULL AUTO_INCREMENT,
  `codigo_fornecedor` INT NOT NULL,
  `codigo_caixa` INT NOT NULL,
  `data_compra` DATE NOT NULL,
  `data_vencimento` DATE NOT NULL,
  `data_pagamento` DATE NULL,
  `valor_total` DOUBLE NOT NULL,
  PRIMARY KEY (`codigo_compra`),
  INDEX `fk_compras_fornecedores_idx` (`codigo_fornecedor` ASC) VISIBLE,
  INDEX `fk_compras_caixa1_idx` (`codigo_caixa` ASC) VISIBLE,
  CONSTRAINT `fk_compras_fornecedores`
    FOREIGN KEY (`codigo_fornecedor`)
    REFERENCES `ifsplife`.`fornecedores` (`codigo_fornecedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compras_caixa1`
    FOREIGN KEY (`codigo_caixa`)
    REFERENCES `ifsplife`.`caixa` (`codigo_caixa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifsplife`.`convenios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`convenios` (
  `codigo_convenio` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `cnpj` VARCHAR(20) NOT NULL,
  `endereco` VARCHAR(255) NOT NULL,
  `telefone` VARCHAR(255) NOT NULL,
  `desconto` DOUBLE NOT NULL,
  PRIMARY KEY (`codigo_convenio`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifsplife`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`item` (
  `codigo_item` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `dosagem` VARCHAR(255) NULL DEFAULT NULL,
  `descricao` VARCHAR(255) NOT NULL,
  `lote` INT NOT NULL,
  `data_fabricacao` DATE NOT NULL,
  `data_validade` DATE NOT NULL,
  `quantidade` INT NOT NULL,
  `valor` FLOAT NOT NULL,
  PRIMARY KEY (`codigo_item`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifsplife`.`itemcompra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`itemcompra` (
  `codigo_compra` INT NOT NULL,
  `codigo_item` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `total` DOUBLE NOT NULL,
  INDEX `fk_itemcompra_compras1_idx` (`codigo_compra` ASC) VISIBLE,
  INDEX `fk_itemcompra_item1_idx` (`codigo_item` ASC) VISIBLE,
  CONSTRAINT `fk_itemcompra_compras1`
    FOREIGN KEY (`codigo_compra`)
    REFERENCES `ifsplife`.`compras` (`codigo_compra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itemcompra_item1`
    FOREIGN KEY (`codigo_item`)
    REFERENCES `ifsplife`.`item` (`codigo_item`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifsplife`.`vendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`vendas` (
  `codigo_venda` INT NOT NULL AUTO_INCREMENT,
  `desconto` DOUBLE NOT NULL,
  `data_venda` DATE NOT NULL,
  `total` DOUBLE NOT NULL,
  `status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo_venda`),
  INDEX `fk_vendas_convenios1_idx` (`desconto` ASC) VISIBLE,
  CONSTRAINT `fk_vendas_convenios1`
    FOREIGN KEY (`desconto`)
    REFERENCES `ifsplife`.`convenios` (`desconto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifsplife`.`itemvenda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`itemvenda` (
  `codigo_venda` INT NOT NULL,
  `codigo_item` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `total` DOUBLE NOT NULL,
  INDEX `fk_itemvenda_vendas1_idx` (`codigo_venda` ASC) VISIBLE,
  INDEX `fk_itemvenda_item1_idx` (`codigo_item` ASC) VISIBLE,
  CONSTRAINT `fk_itemvenda_vendas1`
    FOREIGN KEY (`codigo_venda`)
    REFERENCES `ifsplife`.`vendas` (`codigo_venda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_itemvenda_item1`
    FOREIGN KEY (`codigo_item`)
    REFERENCES `ifsplife`.`item` (`codigo_item`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifsplife`.`pagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`pagamento` (
  `codigo_pagamento` INT NOT NULL,
  `codigo_venda` INT NOT NULL,
  `valor` DOUBLE NOT NULL,
  `forma` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`codigo_pagamento`, `codigo_venda`),
  INDEX `fk_pagamento_vendas1_idx` (`codigo_venda` ASC) VISIBLE,
  CONSTRAINT `fk_pagamento_vendas1`
    FOREIGN KEY (`codigo_venda`)
    REFERENCES `ifsplife`.`vendas` (`codigo_venda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifsplife`.`despesas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`despesas` (
  `codigo_despesa` INT NOT NULL,
  `nome` VARCHAR(60) NOT NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `valor` DOUBLE NOT NULL,
  `data_vencimento` DATE NOT NULL,
  `status` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`codigo_despesa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ifsplife`.`movimentacao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`movimentacao` (
  `codigo_movimentacao` INT NOT NULL,
  `valor` DOUBLE NOT NULL,
  `motivo` VARCHAR(200) NOT NULL,
  `tipo` INT NOT NULL,
  `caixa_codigo_caixa` INT NOT NULL,
  PRIMARY KEY (`codigo_movimentacao`, `caixa_codigo_caixa`),
  INDEX `fk_movimentacao_caixa1_idx` (`caixa_codigo_caixa` ASC) VISIBLE,
  CONSTRAINT `fk_movimentacao_caixa1`
    FOREIGN KEY (`caixa_codigo_caixa`)
    REFERENCES `ifsplife`.`caixa` (`codigo_caixa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ifsplife`.`caixa_has_despesas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`caixa_has_despesas` (
  `codigo_caixa` INT NOT NULL,
  `codigo_despesa` INT NOT NULL,
  `data_pagamento` DATE NOT NULL,
  PRIMARY KEY (`codigo_caixa`, `codigo_despesa`),
  INDEX `fk_caixa_has_despesas_despesas1_idx` (`codigo_despesa` ASC) VISIBLE,
  INDEX `fk_caixa_has_despesas_caixa1_idx` (`codigo_caixa` ASC) VISIBLE,
  CONSTRAINT `fk_caixa_has_despesas_caixa1`
    FOREIGN KEY (`codigo_caixa`)
    REFERENCES `ifsplife`.`caixa` (`codigo_caixa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_caixa_has_despesas_despesas1`
    FOREIGN KEY (`codigo_despesa`)
    REFERENCES `ifsplife`.`despesas` (`codigo_despesa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
