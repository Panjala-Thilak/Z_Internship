/*Train Ticket*/

DELIMITER $$
USE `mydb`$$
CREATE TRIGGER `mydb`.`Ticket_BEFORE_INSERT` BEFORE INSERT ON `Ticket` FOR EACH ROW
BEGIN
	IF(select count(ticket.id) from ticket where ticket.TravellerId=new.id)
    THEN
		IF((select scheduledDepature from ticket where ticket.TravellerId) < (select station.arrivalTime from station where station.TrainNumber=new.TrainNumber))
		THEN
        select "Not possible to book the ticket";
        END IF;
	END IF;
END$$
DELIMITER ;