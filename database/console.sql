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
