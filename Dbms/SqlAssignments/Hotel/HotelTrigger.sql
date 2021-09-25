/*Hotel*/
DELIMITER $$
CREATE DEFINER = CURRENT_USER TRIGGER `mydb`.`Hotel_BEFORE_INSERT` BEFORE INSERT ON Hotel FOR EACH ROW
BEGIN
if(Select count(CustomerID) from Hotel where Hotel.CheckOutTime is null and Hotel_Customer.CustomerID=new.CustomerID)
then
select "Already your are in hotel";
END if;
END$$
DELIMITER ;