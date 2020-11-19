-- MySQL Script generated by MySQL Workbench
-- mar 17 nov 2020 10:55:29 CET
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema supercomprin
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `supercomprin` ;

-- -----------------------------------------------------
-- Schema supercomprin
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `supercomprin` DEFAULT CHARACTER SET utf8 ;
USE `supercomprin` ;

-- -----------------------------------------------------
-- Table `supercomprin`.`e-Wallet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supercomprin`.`e-Wallet` ;

CREATE TABLE IF NOT EXISTS `supercomprin`.`e-Wallet` (
  `id_e-Wallet` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `DNI` VARCHAR(45) NOT NULL,
  `Edad` VARCHAR(45) NOT NULL,
  `FechaNacimiento` DATE NOT NULL,
  `Telefono` INT NOT NULL,
  `Saldo` FLOAT NOT NULL,
  PRIMARY KEY (`id_e-Wallet`),
  UNIQUE INDEX `DNI_UNIQUE` (`DNI` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supercomprin`.`Producto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supercomprin`.`Producto` ;

CREATE TABLE IF NOT EXISTS `supercomprin`.`Producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Precio` FLOAT NOT NULL,
  `Puntos` INT NOT NULL,
  `Stock` INT NOT NULL,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supercomprin`.`Compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supercomprin`.`Compra` ;

CREATE TABLE IF NOT EXISTS `supercomprin`.`Compra` (
  `idCompra` INT NOT NULL AUTO_INCREMENT,
  `FechaCompra` DATE NOT NULL,
  `e-Wallet_id_e-Wallet` INT NOT NULL,
  `Producto_idProducto` INT NOT NULL,
  PRIMARY KEY (`idCompra`),
  INDEX `fk_Compra_e-Wallet_idx` (`e-Wallet_id_e-Wallet` ASC),
  INDEX `fk_Compra_Producto1_idx` (`Producto_idProducto` ASC),
  CONSTRAINT `fk_Compra_e-Wallet`
    FOREIGN KEY (`e-Wallet_id_e-Wallet`)
    REFERENCES `supercomprin`.`e-Wallet` (`id_e-Wallet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Compra_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `supercomprin`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `supercomprin`.`Devolucion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `supercomprin`.`Devolucion` ;

CREATE TABLE IF NOT EXISTS `supercomprin`.`Devolucion` (
  `idDevolucion` INT NOT NULL AUTO_INCREMENT,
  `e-Wallet_id_e-Wallet` INT NOT NULL,
  `Producto_idProducto` INT NOT NULL,
  PRIMARY KEY (`idDevolucion`),
  INDEX `fk_Devolucion_e-Wallet1_idx` (`e-Wallet_id_e-Wallet` ASC),
  INDEX `fk_Devolucion_Producto1_idx` (`Producto_idProducto` ASC),
  CONSTRAINT `fk_Devolucion_e-Wallet1`
    FOREIGN KEY (`e-Wallet_id_e-Wallet`)
    REFERENCES `supercomprin`.`e-Wallet` (`id_e-Wallet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Devolucion_Producto1`
    FOREIGN KEY (`Producto_idProducto`)
    REFERENCES `supercomprin`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;