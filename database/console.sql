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

CREATE INDEX idx_trip_id_cruise_name ON wxy_cruise (trip_id, cruise_name);
CREATE INDEX idx_trip_port_trip_id_port_id ON wxy_trip_port (trip_id, port_id);
CREATE INDEX idx_port_name ON wxy_port (port_name);
CREATE INDEX idx_user_name_password ON wxy_user (user_name, password);
CREATE INDEX idx_group_invoice ON wxy_invoice (group_id, invoice_id);
CREATE INDEX idx_group_payment ON wxy_payment (invoice_id, payment_id);
CREATE INDEX idx_passenger_package ON wxy_package (package_id, passenger_id);

