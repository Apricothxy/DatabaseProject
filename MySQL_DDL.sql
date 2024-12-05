-- SQLINES DEMO *** �Oracle SQL Developer Data Modeler 23.1.0.087.0806
-- SQLINES DEMO ***   2024-12-04 23:09:41 EST
-- SQLINES DEMO *** Oracle Database 11g
-- SQLINES DEMO ***     Oracle Database 11g



-- SQLINES DEMO *** no DDL - MDSYS.SDO_GEOMETRY

-- SQLINES DEMO *** no DDL - XMLTYPE

-- SQLINES FOR EVALUATION USE ONLY (14 DAYS)
CREATE TABLE wxy_cruise (
    cruise_id   INT NOT NULL COMMENT 'cruise id',
    trip_id     INT NOT NULL,
    cruise_name VARCHAR(100) NOT NULL
);

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_cruise.cruise_id IS
    'cruise id'; */

CREATE UNIQUE INDEX wxy_cruise__idx ON
    wxy_cruise (
        trip_id
    ASC );

ALTER TABLE wxy_cruise ADD CONSTRAINT wxy_cruise_pk PRIMARY KEY ( cruise_id );

CREATE TABLE wxy_entertainment (
    entertainment_id INT NOT NULL COMMENT 'entertainment id',
    type             VARCHAR(20) NOT NULL COMMENT 'entertainment type',
    units_num        INTEGER NOT NULL COMMENT 'units number',
    floor_1          INTEGER NOT NULL COMMENT 'on which floor',
    floor_2          INTEGER COMMENT 'on which floor',
    floor_3          INTEGER COMMENT 'on which floor',
    age_limits       INT NOT NULL COMMENT 'age limits for passengers',
    cruise_id        INT NOT NULL COMMENT 'on which cruise'
);

ALTER TABLE wxy_entertainment
    ADD CHECK ( type IN ( 'casino', 'children play', 'gym', 'indoor pool', 'library',
                          'night club', 'outdoor pool', 'sona room', 'steam room', 'tennis court',
                          'theaters', 'whirlpool', 'yoga room' ) );

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_entertainment.entertainment_id IS
    'entertainment id'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_entertainment.type IS
    'entertainment type'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_entertainment.units_num IS
    'units number'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_entertainment.floor_1 IS
    'on which floor'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_entertainment.floor_2 IS
    'on which floor'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_entertainment.floor_3 IS
    'on which floor'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_entertainment.age_limits IS
    'age limits for passengers'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_entertainment.cruise_id IS
    'on which cruise'; */

ALTER TABLE wxy_entertainment ADD CONSTRAINT wxy_entertainment_pk PRIMARY KEY ( entertainment_id );

CREATE TABLE wxy_group (
    group_id INT NOT NULL COMMENT 'group id',
    trip_id  INT NOT NULL COMMENT 'trip group beong to'
);

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_group.group_id IS
    'group id'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_group.trip_id IS
    'trip group beong to'; */

ALTER TABLE wxy_group ADD CONSTRAINT wxy_group_pk PRIMARY KEY ( group_id );

CREATE TABLE wxy_invoice (
    invoice_id   VARCHAR(8) NOT NULL COMMENT 'invoice id',
    amount       TINYINT NOT NULL COMMENT 'amount in us dollar',
    invoice_date DATETIME NOT NULL COMMENT 'date of the invoice',
    group_id     INT NOT NULL
);

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_invoice.invoice_id IS
    'invoice id'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_invoice.amount IS
    'amount in us dollar'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_invoice.invoice_date IS
    'date of the invoice'; */

CREATE UNIQUE INDEX wxy_invoice__idx ON
    wxy_invoice (
        group_id
    ASC );

ALTER TABLE wxy_invoice ADD CONSTRAINT wxy_invoice_pk PRIMARY KEY ( invoice_id );

CREATE TABLE wxy_package (
    package_id   INT NOT NULL,
    type         VARCHAR(50) NOT NULL,
    price        TINYINT NOT NULL,
    passenger_id INT
);

ALTER TABLE wxy_package ADD CHECK ( price = 0 );

ALTER TABLE wxy_package ADD CONSTRAINT wxy_package_pk PRIMARY KEY ( package_id );

CREATE TABLE wxy_passenger (
    passenger_id     INT NOT NULL COMMENT 'passenger id',
    fname            VARCHAR(50) NOT NULL COMMENT 'first name',
    mname            VARCHAR(50) COMMENT 'middle name',
    lname            VARCHAR(50) NOT NULL COMMENT 'last name',
    birth_date       DATETIME NOT NULL COMMENT 'age',
    address_country  VARCHAR(50) NOT NULL COMMENT 'address country',
    address_state    VARCHAR(50) NOT NULL COMMENT 'address state',
    address_city     VARCHAR(50) NOT NULL COMMENT 'address city',
    address_street_1 VARCHAR(50) NOT NULL COMMENT 'address street 1',
    address_street_2 VARCHAR(50) COMMENT 'address street 2 optional',
    gender           VARCHAR(50) NOT NULL COMMENT 'gender, feel free to identify',
    nationality      VARCHAR(50) NOT NULL COMMENT 'nationality',
    email            VARCHAR(50) NOT NULL COMMENT 'email address',
    phone            VARCHAR(50) NOT NULL COMMENT 'phone number',
    group_id         INT NOT NULL,
    user_id          INT
);

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_passenger.passenger_id IS
    'passenger id'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_passenger.fname IS
    'first name'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_passenger.mname IS
    'middle name'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_passenger.lname IS
    'last name'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_passenger.birth_date IS
    'age'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_passenger.address_country IS
    'address country'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_passenger.address_state IS
    'address state'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_passenger.address_city IS
    'address city'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_passenger.address_street_1 IS
    'address street 1'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_passenger.address_street_2 IS
    'address street 2 optional'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_passenger.gender IS
    'gender, feel free to identify'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_passenger.nationality IS
    'nationality'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_passenger.email IS
    'email address'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_passenger.phone IS
    'phone number'; */

ALTER TABLE wxy_passenger ADD CONSTRAINT wxy_passenger_pk PRIMARY KEY ( passenger_id );

CREATE TABLE wxy_passenger_room (
    price        TINYINT NOT NULL COMMENT 'price of this room for this passenger
',
    room_id      INT NOT NULL,
    passenger_id INT NOT NULL
);

ALTER TABLE wxy_passenger_room ADD CHECK ( price = 0 );

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_passenger_room.price IS
    'price of this room for this passenger
'; */

ALTER TABLE wxy_passenger_room ADD CONSTRAINT wxy_passenger_room_pk PRIMARY KEY ( room_id,
                                                                                  passenger_id );

CREATE TABLE wxy_payment (
    payment_id INT NOT NULL COMMENT 'payment id',
    amount     TINYINT NOT NULL COMMENT 'amount in us dollar',
    `DATE`     DATETIME NOT NULL COMMENT 'payment data',
    method     VARCHAR(50) NOT NULL COMMENT 'payment method',
    invoice_id VARCHAR(8) NOT NULL COMMENT 'invoice the payment for'
);

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_payment.payment_id IS
    'payment id'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_payment.amount IS
    'amount in us dollar'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_payment.`DATE` IS
    'payment data'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_payment.method IS
    'payment method'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_payment.invoice_id IS
    'invoice the payment for'; */

ALTER TABLE wxy_payment ADD CONSTRAINT wxy_payment_pk PRIMARY KEY ( payment_id );

CREATE TABLE wxy_port (
    port_id                 INT NOT NULL COMMENT 'port id',
    port_name               VARCHAR(50) NOT NULL COMMENT 'port name',
    state                   VARCHAR(50) NOT NULL COMMENT 'state address',
    country                 VARCHAR(50) NOT NULL COMMENT 'country address',
    address1                VARCHAR(50) NOT NULL COMMENT 'address1',
    address2                VARCHAR(50) COMMENT 'address2, optional',
    nearest_airport_name    VARCHAR(50) NOT NULL COMMENT 'nearest airport name',
    number_of_parking_spots INT NOT NULL COMMENT 'number of parking spots'
);

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_port.port_id IS
    'port id'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_port.port_name IS
    'port name'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_port.state IS
    'state address'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_port.country IS
    'country address'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_port.address1 IS
    'address1'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_port.address2 IS
    'address2, optional'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_port.nearest_airport_name IS
    'nearest airport name'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_port.number_of_parking_spots IS
    'number of parking spots'; */

ALTER TABLE wxy_port ADD CONSTRAINT wxy_port_pk PRIMARY KEY ( port_id );

CREATE TABLE wxy_restaurant (
    restaurant_id INT NOT NULL COMMENT 'resturant id',
    type          VARCHAR(20) NOT NULL COMMENT 'resurant type',
    start_time    DATETIME NOT NULL COMMENT 'resturant service start time',
    end_time      DATETIME NOT NULL COMMENT 'resturant service end time',
    floor         INTEGER NOT NULL COMMENT 'resturant on which floor',
    cruise_id     INT NOT NULL COMMENT 'returant belong to which cruise'
);

ALTER TABLE wxy_restaurant
    ADD CHECK ( type IN ( 'Common Buffett', 'Italian Specialty', 'La carte continental', 'Mexican Specialty', 'Ming Work Chinese',
                          'Pool Bar', 'Round Clock Cafe', 'Stout Bar', 'Tokyo Ramen Japanese' ) );

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_restaurant.restaurant_id IS
    'resturant id'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_restaurant.type IS
    'resurant type'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_restaurant.start_time IS
    'resturant service start time'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_restaurant.end_time IS
    'resturant service end time'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_restaurant.floor IS
    'resturant on which floor'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_restaurant.cruise_id IS
    'returant belong to which cruise'; */

ALTER TABLE wxy_restaurant ADD CONSTRAINT wxy_restaurant_pk PRIMARY KEY ( restaurant_id );

CREATE TABLE wxy_stateroom (
    room_id          INT NOT NULL COMMENT 'stateroom id',
    type             VARCHAR(20) NOT NULL COMMENT 'room type',
    `SIZE`           INT NOT NULL COMMENT 'room size',
    bed_num          INT NOT NULL COMMENT 'bed number',
    bathroom_num     INT NOT NULL COMMENT 'bathroom number',
    balcony          INT NOT NULL COMMENT 'balcony number',
    cruise_id        INT NOT NULL COMMENT 'room belong to which cruise',
    price_per_person TINYINT NOT NULL COMMENT 'price of the stateroom',
    position         VARCHAR(20) NOT NULL
);

ALTER TABLE wxy_stateroom
    ADD CHECK ( type IN ( 'club balcony suite', 'family balcony', 'family large balcony', 'inside stateroom', 'oceanview window',
                          'studio stateroom', 'the haven suite' ) );

ALTER TABLE wxy_stateroom ADD CHECK ( price_per_person = 0 );

ALTER TABLE wxy_stateroom
    ADD CHECK ( position IN ( 'After', 'Forward', 'Left', 'Right' ) );

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_stateroom.room_id IS
    'stateroom id'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_stateroom.type IS
    'room type'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_stateroom.`SIZE` IS
    'room size'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_stateroom.bed_num IS
    'bed number'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_stateroom.bathroom_num IS
    'bathroom number'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_stateroom.balcony IS
    'balcony number'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_stateroom.cruise_id IS
    'room belong to which cruise'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_stateroom.price_per_person IS
    'price of the stateroom'; */

ALTER TABLE wxy_stateroom ADD CONSTRAINT wxy_stateroom_pk PRIMARY KEY ( room_id );

CREATE TABLE wxy_trip (
    trip_id    INT NOT NULL COMMENT 'trip id',
    nights_num INTEGER NOT NULL COMMENT 'total number of nights'
);

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_trip.trip_id IS
    'trip id'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_trip.nights_num IS
    'total number of nights'; */

ALTER TABLE wxy_trip ADD CONSTRAINT wxy_trip_pk PRIMARY KEY ( trip_id );

CREATE TABLE wxy_trip_port (
    trip_id    INT NOT NULL COMMENT 'trip id',
    port_id    INT NOT NULL COMMENT 'port id',
    type       VARCHAR(20) NOT NULL COMMENT 'port type: start, end, stop',
    start_date DATETIME NOT NULL COMMENT 'port start date',
    end_date   DATETIME NOT NULL COMMENT 'port end data'
);

ALTER TABLE wxy_trip_port
    ADD CHECK ( type IN ( 'end_port', 'start_port', 'stop_port' ) );

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_trip_port.trip_id IS
    'trip id'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_trip_port.port_id IS
    'port id'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_trip_port.type IS
    'port type: start, end, stop'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_trip_port.start_date IS
    'port start date'; */

/* Moved to CREATE TABLE
COMMENT ON COLUMN wxy_trip_port.end_date IS
    'port end data'; */

ALTER TABLE wxy_trip_port ADD CONSTRAINT wxy_trip_port_pk PRIMARY KEY ( port_id,
                                                                        trip_id );

CREATE TABLE wxy_user (
    user_id    INT NOT NULL,
    password   VARCHAR(50) NOT NULL,
    membership VARCHAR(50) NOT NULL,
    user_name  VARCHAR(50) NOT NULL
);

ALTER TABLE wxy_user ADD CONSTRAINT wxy_user_pk PRIMARY KEY ( user_id );

ALTER TABLE wxy_cruise
    ADD CONSTRAINT wxy_cruise_wxy_trip_fk FOREIGN KEY ( trip_id )
        REFERENCES wxy_trip ( trip_id );

ALTER TABLE wxy_entertainment
    ADD CONSTRAINT wxy_entertainment_cruise_fk FOREIGN KEY ( cruise_id )
        REFERENCES wxy_cruise ( cruise_id );

ALTER TABLE wxy_group
    ADD CONSTRAINT wxy_group_wxy_trip_fk FOREIGN KEY ( trip_id )
        REFERENCES wxy_trip ( trip_id );

ALTER TABLE wxy_invoice
    ADD CONSTRAINT wxy_invoice_wxy_group_fk FOREIGN KEY ( group_id )
        REFERENCES wxy_group ( group_id );

ALTER TABLE wxy_package
    ADD CONSTRAINT wxy_package_wxy_passenger_fk FOREIGN KEY ( passenger_id )
        REFERENCES wxy_passenger ( passenger_id );

ALTER TABLE wxy_passenger
    ADD CONSTRAINT wxy_passenger_wxy_group_fk FOREIGN KEY ( group_id )
        REFERENCES wxy_group ( group_id );

ALTER TABLE wxy_passenger
    ADD CONSTRAINT wxy_passenger_wxy_user_fk FOREIGN KEY ( user_id )
        REFERENCES wxy_user ( user_id );

ALTER TABLE wxy_payment
    ADD CONSTRAINT wxy_payment_wxy_invoice_fk FOREIGN KEY ( invoice_id )
        REFERENCES wxy_invoice ( invoice_id );

ALTER TABLE wxy_restaurant
    ADD CONSTRAINT wxy_restaurant_wxy_cruise_fk FOREIGN KEY ( cruise_id )
        REFERENCES wxy_cruise ( cruise_id );

ALTER TABLE wxy_passenger_room
    ADD CONSTRAINT wxy_room_passenger_fk FOREIGN KEY ( passenger_id )
        REFERENCES wxy_passenger ( passenger_id );

ALTER TABLE wxy_passenger_room
    ADD CONSTRAINT wxy_room_stateroom_fk FOREIGN KEY ( room_id )
        REFERENCES wxy_stateroom ( room_id );

ALTER TABLE wxy_stateroom
    ADD CONSTRAINT wxy_stateroom_wxy_cruise_fk FOREIGN KEY ( cruise_id )
        REFERENCES wxy_cruise ( cruise_id );

ALTER TABLE wxy_trip_port
    ADD CONSTRAINT wxy_trip_port_wxy_port_fk FOREIGN KEY ( port_id )
        REFERENCES wxy_port ( port_id );

ALTER TABLE wxy_trip_port
    ADD CONSTRAINT wxy_trip_port_wxy_trip_fk FOREIGN KEY ( trip_id )
        REFERENCES wxy_trip ( trip_id );



