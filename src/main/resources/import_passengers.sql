BEGIN;
INSERT INTO passengers(id, surname, name, email)VALUES
(NEXTVAL('passengers_sequence'), 'Michel', 'Forever', 'michel.forever@wanadoo.com'),
(NEXTVAL('passengers_sequence'), 'Nicolas', 'Dailly', 'nicolas.dailly@unilasalle.fr');
COMMIT;