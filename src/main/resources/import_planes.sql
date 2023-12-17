BEGIN;
INSERT INTO planes(id, operator, model, registration, capacity)VALUES
    (NEXTVAL('planes_sequence'), 'Jean Luc', 'A320', 'AX97B', 300),
    (NEXTVAL('planes_sequence'), 'Jean Charles', 'A320', 'KSDKJ', 290),
    (NEXTVAL('planes_sequence'), 'Jean Celestin', '737', 'YZ69X', 380),
    (NEXTVAL('planes_sequence'), 'Jean Michel', '737', 'GDSOZ', 360),
    (NEXTVAL('planes_sequence'), 'Jean Theodule', 'F22', 'ZZZZZ', 1);
COMMIT;