BEGIN;
INSERT INTO flights(id, number, origin, destination, departure_date, arrival_date, departure_time, arrival_time, plane_id)VALUES
(NEXTVAL('flights_sequence'), 'FR 4368', 'BVA', 'ZAZ', '2023-12-09', '2023-12-09', '13:30', '15:15', 1),
(NEXTVAL('flights_sequence'), 'FR 4369', 'ZAZ', 'BVA', '2023-12-16', '2023-12-16', '15:50', '17:35', 1);
COMMIT;