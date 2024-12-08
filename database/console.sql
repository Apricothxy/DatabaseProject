show databases;

create database databaseproject;
drop database databaseproject;
create database databaseproject;



select * from databaseproject.WXY_CRUISE;
select * from databaseproject.WXY_STATEROOM;
select * from databaseproject.WXY_RESTAURANT;
select * from databaseproject.WXY_PACKAGE;
select * from databaseproject.WXY_ENTERTAINMENT;
select * from databaseproject.WXY_TRIP;
select * from databaseproject.WXY_PORT;
select * from databaseproject.WXY_TRIP_PORT;
select * from databaseproject.WXY_INVOICE;
select * from databaseproject.WXY_GROUP;
select * from databaseproject.WXY_PAYMENT;
select * from databaseproject.WXY_USER;
select * from databaseproject.WXY_PASSENGER;
select * from databaseproject.WXY_PASSENGER_ROOM;

show tables;

create table users (
    user_id    INT AUTO_INCREMENT PRIMARY KEY,
    password   VARCHAR(50) NOT NULL,
    membership VARCHAR(50) NOT NULL,
    user_name  VARCHAR(50) NOT NULL
);

select * from users;

drop table users;

use databaseproject;
select *
from wxy_trip_port tp_start
            JOIN wxy_trip_port tp_end ON tp_start.trip_id = tp_end.trip_id AND tp_end.type = 'end_port'
            JOIN wxy_cruise c ON tp_start.trip_id = c.trip_id
            JOIN wxy_port p_start ON tp_start.port_id = p_start.port_id AND tp_start.type = 'start_port'
            JOIN wxy_port p_end ON tp_end.port_id = p_end.port_id
            LEFT JOIN wxy_trip_port tp_stop ON tp_start.trip_id = tp_stop.trip_id AND tp_stop.type = 'stop_port'
            LEFT JOIN wxy_port p_stop ON tp_stop.port_id = p_stop.port_id;

INSERT INTO WXY_TRIP (TRIP_ID, NIGHTS_NUM)
VALUES (2, 6);

INSERT INTO WXY_PORT (PORT_ID, PORT_NAME, STATE, COUNTRY, ADDRESS1, ADDRESS2, NEAREST_AIRPORT_NAME, NUMBER_OF_PARKING_SPOTS)
VALUES (4, 'Cancun', 'Quintana Roo', 'Mexico', '200 Holiday Blvd', NULL, 'Cancun International Airport', 300);

-- Add a new port for Panama
INSERT INTO WXY_PORT (PORT_ID, PORT_NAME, STATE, COUNTRY, ADDRESS1, ADDRESS2, NEAREST_AIRPORT_NAME, NUMBER_OF_PARKING_SPOTS)
VALUES (5, 'Panama City', 'Panama', 'Panama', '300 Harbor Road', NULL, 'Tocumen International Airport', 400);

-- Set the route for trip_id=2:
-- Start at New York (2), stop at Miami (1), stop at Panama (4), end at Cancun (3)
INSERT INTO WXY_TRIP_PORT (TRIP_ID, PORT_ID, TYPE, START_DATE, END_DATE)
VALUES (2, 2, 'start_port', '2024-12-01', '2024-12-01');

INSERT INTO WXY_TRIP_PORT (TRIP_ID, PORT_ID, TYPE, START_DATE, END_DATE)
VALUES (2, 1, 'stop_port', '2024-12-02', '2024-12-02');

INSERT INTO WXY_TRIP_PORT (TRIP_ID, PORT_ID, TYPE, START_DATE, END_DATE)
VALUES (2, 5, 'stop_port', '2024-12-04', '2024-12-04');

INSERT INTO WXY_TRIP_PORT (TRIP_ID, PORT_ID, TYPE, START_DATE, END_DATE)
VALUES (2, 4, 'end_port', '2024-12-07', '2024-12-07');

update wxy_cruise set trip_id = 2 where cruise_name = 'Ocean Explorer';

SELECT
            tp_start.trip_id,
            c.cruise_name,
            tp_start.start_date AS start_time,
            tp_end.end_date AS end_time,
            p_start.port_name AS start_port_name,
            p_end.port_name AS end_port_name
        FROM
            wxy_trip_port tp_start
            JOIN wxy_trip_port tp_end ON tp_start.trip_id = tp_end.trip_id AND tp_end.type = 'end_port'
            JOIN wxy_cruise c ON tp_start.trip_id = c.trip_id
            JOIN wxy_port p_start ON tp_start.port_id = p_start.port_id AND tp_start.type = 'start_port'
            JOIN wxy_port p_end ON tp_end.port_id = p_end.port_id
        WHERE
            tp_start.trip_id = 1;