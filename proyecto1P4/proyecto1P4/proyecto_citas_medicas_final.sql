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
   `nombre` VARCHAR(45) NOT NULL,
  `idAdministrador` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAdministrador`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

insert into administrador(nombre, idAdministrador,clave) values ('Juan Perez','111','111UNA');
insert into administrador(nombre, idAdministrador,clave) values ('Carolina Hernandez','222','222UNA');

-- -----------------------------------------------------
-- Table `usuarios2`.`localidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuarios2`.`localidad` (
  `provincia` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`provincia`));


-- -----------------------------------------------------
-- Table `usuarios2`.`medico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuarios2`.`medico` (
  `nombre` VARCHAR(45) NOT NULL,
  `idMedicos` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(20) ,
  `nombre_provincia`VARCHAR(45) ,
  `nombre_especialidad` VARCHAR(45) ,
  `image` LONGBLOB,
  PRIMARY KEY (`idMedicos`),
  CONSTRAINT `medico_ibfk_1`
    FOREIGN KEY (`nombre_provincia`)
    REFERENCES `usuarios2`.`localidad` (`provincia`),
     CONSTRAINT `medico_ibfk_2`
    FOREIGN KEY (`nombre_especialidad`)
    REFERENCES `usuarios2`.`especialidad` (`especialidad`));

CREATE INDEX `nombre_provincia` ON `usuarios2`.`medico` (`nombre_provincia` ASC) VISIBLE;
CREATE INDEX `nombre_especialidad` ON `usuarios2`.`medico` (`nombre_especialidad` ASC) VISIBLE;

insert into medico(nombre,idMedicos,clave,estado,nombre_provincia,nombre_especialidad) values
('Martín Elías Acosta','111','11111',null,null,null);

insert into medico(nombre,idMedicos,clave,estado,nombre_provincia,nombre_especialidad) values
('Ana María de la Peña','2234','2222',null,null,null);




-- -----------------------------------------------------
-- Table `usuarios2`.`paciente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuarios2`.`paciente` (
  `nombre` VARCHAR(45) NOT NULL,
  `cedula` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`cedula`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

insert into paciente(nombre,cedula,clave) values ('Maria','123','1111');







-- -----------------------------------------------------
-- Table `usuarios2`.`cita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuarios2`.`cita` (
  `idCitas` INT auto_increment NOT NULL,
  `estado` VARCHAR(20) NOT NULL,
  `dia` VARCHAR(20),
  `hora` VARCHAR(20),
  `Paciente_cedula` VARCHAR(45) NOT NULL,
  `Medico_idMedico` VARCHAR(45)  NOT NULL,
  PRIMARY KEY (`idCitas`),
  CONSTRAINT `cita_ibfk_1`
    FOREIGN KEY (`Medico_idMedico`)
    REFERENCES `usuarios2`.`medico` (`idMedicos`),
  CONSTRAINT `cita_ibfk_2`
    FOREIGN KEY (`Paciente_cedula`)
    REFERENCES `usuarios2`.`paciente` (`cedula`));

CREATE INDEX `Medico_idMedico` ON `usuarios2`.`cita` (`Medico_idMedico` ASC) VISIBLE;

CREATE INDEX `Paciente_cedula` ON `usuarios2`.`cita` (`Paciente_cedula` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `usuarios2`.`especialidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuarios2`.`especialidad` (
  `especialidad` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`especialidad`));

-- -----------------------------------------------------
-- Table `usuarios2`.`Horario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuarios2`.`horario` (
  `numero` INT auto_increment NOT NULL,
  `id_doctor` VARCHAR(45) NOT NULL,
   comienzo_lunes int,
   finaliza_lunes int,
   comienzo_martes int,
   finaliza_martes int,
   comienzo_miercoles int,
   finaliza_miercoles int,
   comienzo_jueves int,
   finaliza_jueves int,
   comienzo_viernes int,
   finaliza_viernes int,
   comienzo_sabado int,
   finaliza_sabado int,
   frecuencia int,
  PRIMARY KEY (`numero`),
  CONSTRAINT `horario_ibfk_1`
  FOREIGN KEY (`id_doctor`)
  REFERENCES `usuarios2`.`medico` (`idMedicos`));

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
