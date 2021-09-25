-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema studentdb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema studentdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `studentdb` DEFAULT CHARACTER SET utf8 ;
USE `studentdb` ;

-- -----------------------------------------------------
-- Table `studentdb`.`course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentdb`.`course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentdb`.`student`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentdb`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `creation_date` DATETIME NULL DEFAULT NULL,
  `update_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `studentdb`.`student_has_course`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `studentdb`.`student_has_course` (
  `student_id` INT NOT NULL,
  `course_id` INT NOT NULL,
  PRIMARY KEY (`student_id`, `course_id`),
  INDEX `fk_student_has_course_course1_idx` (`course_id` ASC) VISIBLE,
  INDEX `fk_student_has_course_student1_idx` (`student_id` ASC) VISIBLE,
  CONSTRAINT `fk_student_has_course_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `studentdb`.`course` (`id`),
  CONSTRAINT `fk_student_has_course_student1`
    FOREIGN KEY (`student_id`)
    REFERENCES `studentdb`.`student` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
USE `studentdb`;

DELIMITER $$
USE `studentdb`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `studentdb`.`student_BEFORE_INSERT`
BEFORE INSERT ON `studentdb`.`student`
FOR EACH ROW
BEGIN
SET new.creation_date=now();
SET new.update_date=now();
END$$

USE `studentdb`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `studentdb`.`student_BEFORE_UPDATE`
BEFORE UPDATE ON `studentdb`.`student`
FOR EACH ROW
BEGIN
SET new.creation_date=old.creation_date;
set new.update_date=now();
END$$


DELIMITER ;
