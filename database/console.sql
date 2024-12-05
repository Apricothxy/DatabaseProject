show databases;

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
    user_name  VARCHAR(50) NOT NULL
);

select * from users;

drop table users;
