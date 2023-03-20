-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ifsplife
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ifsplife` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ifsplife` ;

-- -----------------------------------------------------
-- Table `ifsplife`.`fornecedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`fornecedores` (
  `codigo_fornecedor` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `cnpj` VARCHAR(14) NOT NULL,
  `telefone` VARCHAR(11) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `endereco` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `uf` VARCHAR(2) NOT NULL,
  PRIMARY KEY (`codigo_fornecedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifsplife`.`compras`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`compras` (
  `codigo_compra` INT NOT NULL AUTO_INCREMENT,
  `codigo_fornecedor` INT NOT NULL,
  `data_compra` DATE NOT NULL,
  `forma_pagamento` CHAR(1) NOT NULL,
  `valortotal` DOUBLE NOT NULL,
  PRIMARY KEY (`codigo_compra`),
  INDEX `codigo_fornecedor` (`codigo_fornecedor` ASC) VISIBLE,
  CONSTRAINT `compras_ibfk_1`
    FOREIGN KEY (`codigo_fornecedor`)
    REFERENCES `ifsplife`.`fornecedores` (`codigo_fornecedor`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifsplife`.`convenios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`convenios` (
  `codigo_convenio` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `desconto` FLOAT NOT NULL,
  `telefone` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`codigo_convenio`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifsplife`.`funcionarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`funcionarios` (
  `codigo_funcionario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `cargo` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(11) NOT NULL,
  `endereco` VARCHAR(45) NOT NULL,
  `cidade` VARCHAR(45) NOT NULL,
  `cep` VARCHAR(8) NOT NULL,
  `uf` VARCHAR(2) NOT NULL,
  `salario` VARCHAR(45) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`codigo_funcionario`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifsplife`.`produtos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`produtos` (
  `codigo_produto` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `dosagem` VARCHAR(255) NULL,
  `descricao` VARCHAR(45) NOT NULL,
  `quantidade` INT NOT NULL,
  `valor` FLOAT NOT NULL,
  PRIMARY KEY (`codigo_produto`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ifsplife`.`caixa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`caixa` (
  `codigo_caixa` INT NOT NULL,
  `status` CHAR(1) NOT NULL,
  `abertura` TIME NOT NULL,
  `valorabertura` DOUBLE NOT NULL,
  `totalentradas` DOUBLE NOT NULL,
  `fechamento` TIME NOT NULL,
  `totalsaidas` DOUBLE NOT NULL,
  `saldo` DOUBLE NOT NULL,
  PRIMARY KEY (`codigo_caixa`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ifsplife`.`vendas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`vendas` (
  `codigo_venda` INT NOT NULL AUTO_INCREMENT,
  `codigo_convenio` INT NOT NULL,
  `data_venda` DATE NOT NULL,
  `valor_venda` FLOAT NOT NULL,
  `forma_pagamento` CHAR(1) NOT NULL,
  `caixa_idcaixa` INT NOT NULL,
  PRIMARY KEY (`codigo_venda`),
  INDEX `codigo_convenio` (`codigo_convenio` ASC) VISIBLE,
  INDEX `fk_vendas_caixa1_idx` (`caixa_idcaixa` ASC) VISIBLE,
  CONSTRAINT `vendas_ibfk_3`
    FOREIGN KEY (`codigo_convenio`)
    REFERENCES `ifsplife`.`convenios` (`codigo_convenio`),
  CONSTRAINT `fk_vendas_caixa1`
    FOREIGN KEY (`caixa_idcaixa`)
    REFERENCES `ifsplife`.`caixa` (`codigo_caixa`)
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
  `codigo_produto` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `preco` FLOAT NOT NULL,
  PRIMARY KEY (`codigo_venda`, `codigo_produto`),
  INDEX `fk_table1_produtos1_idx` (`codigo_produto` ASC) VISIBLE,
  CONSTRAINT `fk_table1_vendas1`
    FOREIGN KEY (`codigo_venda`)
    REFERENCES `ifsplife`.`vendas` (`codigo_venda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_produtos1`
    FOREIGN KEY (`codigo_produto`)
    REFERENCES `ifsplife`.`produtos` (`codigo_produto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ifsplife`.`itemcompra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`itemcompra` (
  `codigo_compra` INT NOT NULL,
  `codigo_produto` INT NOT NULL,
  `quantidade` INT NOT NULL,
  `preco` FLOAT NOT NULL,
  PRIMARY KEY (`codigo_compra`, `codigo_produto`),
  INDEX `fk_table2_produtos1_idx` (`codigo_produto` ASC) VISIBLE,
  CONSTRAINT `fk_table2_compras1`
    FOREIGN KEY (`codigo_compra`)
    REFERENCES `ifsplife`.`compras` (`codigo_compra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table2_produtos1`
    FOREIGN KEY (`codigo_produto`)
    REFERENCES `ifsplife`.`produtos` (`codigo_produto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ifsplife`.`pagamentocompra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ifsplife`.`pagamentocompra` (
  `codigo_compra` INT NOT NULL,
  `parcela` INT NOT NULL,
  `vencimento` DATE NOT NULL,
  `valor` FLOAT NOT NULL,
  `caixa_idcaixa` INT NOT NULL,
  PRIMARY KEY (`codigo_compra`),
  INDEX `fk_table3_caixa1_idx` (`caixa_idcaixa` ASC) VISIBLE,
  CONSTRAINT `fk_table3_compras1`
    FOREIGN KEY (`codigo_compra`)
    REFERENCES `ifsplife`.`compras` (`codigo_compra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table3_caixa1`
    FOREIGN KEY (`caixa_idcaixa`)
    REFERENCES `ifsplife`.`caixa` (`codigo_caixa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
