CREATE PROCEDURE MOVE_TO_HISTORY(IN person_id_in INT , OUT status_out BOOLEAN )
MODIFIES SQL DATA
BEGIN ATOMIC

DECLARE temp_count INTEGER
SET temp_count = -1;
SET status_out = FALSE;

select count(*) int temp_count from PERSON p where p.id = person_id_in;
if temp_count>-1 THEN
    SET status_out = TRUE
    insert into PERSON_HISTORY(select * from PERSON p where p.id=person_id_in);
    delete form PERSON p where p.id = person_id_in;
end if;
END
/;