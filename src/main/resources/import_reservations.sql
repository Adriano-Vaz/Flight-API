BEGIN;
INSERT INTO reservations(id, flight_id, passenger_id)VALUES
    (NEXTVAL('reservations_sequence'), 1, 2),
    (NEXTVAL('reservations_sequence'), 2, 3),
    (NEXTVAL('reservations_sequence'), 4, 5);
COMMIT;