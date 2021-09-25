DELIMITER $$
CREATE DEFINER = CURRENT_USER TRIGGER `mydb`.`Customer_Accounts_BEFORE_INSERT1` BEFORE INSERT ON `Customer_Accounts` FOR EACH ROW
BEGIN
if(new.branch_id=(select branch_id from branch where customer.customer_id=new.customer_id))
then
 select "Customer cannot hold two accounts";
end if;
END$$
DELIMITER ;