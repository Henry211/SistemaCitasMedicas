-- MySQL Script generated by MySQL Workbench
-- Sun Apr 17 16:30:19 2022
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema usuarios2
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `usuarios2` ;

-- -----------------------------------------------------
-- Schema usuarios2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `usuarios2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `usuarios2` ;

-- -----------------------------------------------------
-- Table `usuarios2`.`administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuarios2`.`administrador` (
  `idAdministrador` INT NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAdministrador`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `usuarios2`.`localidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuarios2`.`localidad` (
  `idLocalidad` INT NOT NULL,
  `provincia` VARCHAR(45) NULL DEFAULT NULL,
  `canton` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idLocalidad`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `usuarios2`.`medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuarios2`.`medico` (
  `idMedicos` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(20) NOT NULL,
  `foto` VARCHAR(45) NOT NULL,
  `localidad_idLocalidad` INT NOT NULL,
  PRIMARY KEY (`idMedicos`),
  CONSTRAINT `medico_ibfk_1`
    FOREIGN KEY (`localidad_idLocalidad`)
    REFERENCES `usuarios2`.`localidad` (`idLocalidad`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `localidad_idLocalidad` ON `usuarios2`.`medico` (`localidad_idLocalidad` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `usuarios2`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuarios2`.`paciente` (
  `cedula` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cedula`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `usuarios2`.`cita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuarios2`.`cita` (
  `idCitas` INT NOT NULL,
  `estado` VARCHAR(20) NOT NULL,
  `fecha` DATE NOT NULL,
  `Paciente_cedula` VARCHAR(45) NOT NULL,
  `Medico_idMedico` INT NOT NULL,
  PRIMARY KEY (`idCitas`),
  CONSTRAINT `cita_ibfk_1`
    FOREIGN KEY (`Medico_idMedico`)
    REFERENCES `usuarios2`.`medico` (`idMedicos`),
  CONSTRAINT `cita_ibfk_2`
    FOREIGN KEY (`Paciente_cedula`)
    REFERENCES `usuarios2`.`paciente` (`cedula`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `Medico_idMedico` ON `usuarios2`.`cita` (`Medico_idMedico` ASC) VISIBLE;

CREATE INDEX `Paciente_cedula` ON `usuarios2`.`cita` (`Paciente_cedula` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `usuarios2`.`especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuarios2`.`especialidad` (
  `idEspecialidad` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `Medico_idMedico` INT NOT NULL,
  PRIMARY KEY (`idEspecialidad`),
  CONSTRAINT `especialidad_ibfk_1`
    FOREIGN KEY (`Medico_idMedico`)
    REFERENCES `usuarios2`.`medico` (`idMedicos`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

CREATE INDEX `Medico_idMedico` ON `usuarios2`.`especialidad` (`Medico_idMedico` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;