DROP database databaseproject;
create database databaseproject;
use databaseproject;
show tables;


-- INSERT INTO wxy_package (passenger_id, package_type, price) VALUES (1000, "Water and Non-Alcoholic", 100.0)

-- INSERT INTO wxy_group (group_id, trip_id) VALUES (NULL,1);
-- INSERT INTO wxy_invoice (group_id, amount, invoice_date) VALUES (1, 1000.0, NOW());

-- SELECT
--     t.trip_id AS tripId,
--     g.group_id AS groupId,
--     i.invoice_id AS invoiceId,
--     i.amount AS invoiceAmount,
--     COALESCE(pa.payment_id, -1) AS paymentId,
--     pg.passenger_id AS passengerId,
--     p.fname AS passengerFName,
--     p.lname AS passengerLName
-- FROM
--     wxy_group g
--     JOIN wxy_invoice i ON g.group_id = i.group_id
--     LEFT JOIN wxy_payment pa ON i.invoice_id = pa.invoice_id
--     JOIN wxy_passenger_group pg ON g.group_id = pg.group_id
--     JOIN wxy_passenger p ON pg.passenger_id = p.passenger_id AND p.user_id = 1
--     JOIN wxy_trip t ON t.trip_id = g.trip_id
-- ORDER BY t.trip_id;


-- INSERT INTO WXY_TRIP (TRIP_ID, NIGHTS_NUM)
-- VALUES (2, 6);

-- INSERT INTO WXY_PORT (PORT_ID, PORT_NAME, STATE, COUNTRY, ADDRESS1, ADDRESS2, NEAREST_AIRPORT_NAME, NUMBER_OF_PARKING_SPOTS)
-- VALUES (4, 'Cancun', 'Quintana Roo', 'Mexico', '200 Holiday Blvd', NULL, 'Cancun International Airport', 300);

-- -- Add a new port for Panama
-- INSERT INTO WXY_PORT (PORT_ID, PORT_NAME, STATE, COUNTRY, ADDRESS1, ADDRESS2, NEAREST_AIRPORT_NAME, NUMBER_OF_PARKING_SPOTS)
-- VALUES (5, 'Panama City', 'Panama', 'Panama', '300 Harbor Road', NULL, 'Tocumen International Airport', 400);

-- -- Set the route for trip_id=2:
-- -- Start at New York (2), stop at Miami (1), stop at Panama (4), end at Cancun (3)
-- INSERT INTO WXY_TRIP_PORT (TRIP_ID, PORT_ID, TYPE, START_DATE, END_DATE)
-- VALUES (2, 2, 'start_port', '2024-12-01', '2024-12-01');

-- INSERT INTO WXY_TRIP_PORT (TRIP_ID, PORT_ID, TYPE, START_DATE, END_DATE)
-- VALUES (2, 1, 'stop_port', '2024-12-02', '2024-12-02');

-- INSERT INTO WXY_TRIP_PORT (TRIP_ID, PORT_ID, TYPE, START_DATE, END_DATE)
-- VALUES (2, 5, 'stop_port', '2024-12-04', '2024-12-04');

-- INSERT INTO WXY_TRIP_PORT (TRIP_ID, PORT_ID, TYPE, START_DATE, END_DATE)
-- VALUES (2, 4, 'end_port', '2024-12-07', '2024-12-07');


-- INSERT INTO WXY_CRUISE (cruise_name, trip_id) VALUES("Ocean Explorer", 2);
