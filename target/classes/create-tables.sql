CREATE TABLE PERSON(
ID BIGINT PRIMARY KEY,
FIRST_NAME VARCHAR(50),
LAST_NAME VARCHAR(50),
ADDRESS VARCHAR(255),
EMAIL_ID VARCHAR(100),
PHONE VARCHAR(15)
)
/;

CREATE TABLE PERSON_HISTORY AS (SELECT * FROM PERSON) WITH NO DATA;