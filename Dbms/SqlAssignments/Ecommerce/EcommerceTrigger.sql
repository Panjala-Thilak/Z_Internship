/*ECommerce*/
DELIMITER $$
USE `mydb`$$
CREATE TRIGGER `mydb`.`Order_BEFORE_INSERT` BEFORE INSERT ON `Order` FOR EACH ROW
BEGIN
	IF(NEW.orderedDate = (SELECT orderedDate FROM orders WHERE Customer.id = NEW.id))
		THEN
        select "Not possible to place the order.Try Again!!";
	END IF;
END$$
DELIMITER ;