use databaseproject;

CREATE TABLE wxy_cruise (
    cruise_id INT NOT NULL COMMENT 'cruise id'
);

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


ALTER TABLE wxy_entertainment ADD CONSTRAINT wxy_entertainment_pk PRIMARY KEY ( entertainment_id );

CREATE TABLE wxy_group (
    group_id INT NOT NULL COMMENT 'group id',
    trip_id  INT NOT NULL COMMENT 'trip group beong to'
);

ALTER TABLE wxy_group ADD CONSTRAINT wxy_group_pk PRIMARY KEY ( group_id );

CREATE TABLE wxy_group_invoice (
    group_id   INT NOT NULL,
    invoice_id VARCHAR(8) NOT NULL
);

ALTER TABLE wxy_group_invoice ADD CONSTRAINT wxy_group_invoice_pk PRIMARY KEY ( group_id,
                                                                                invoice_id );

CREATE TABLE wxy_invoice (
    invoice_id   VARCHAR(8) NOT NULL COMMENT 'invoice id',
    amount       INT NOT NULL COMMENT 'amount in us dollar',
    invoice_date DATETIME NOT NULL COMMENT 'date of the invoice'
);

ALTER TABLE wxy_invoice ADD CONSTRAINT wxy_invoice_pk PRIMARY KEY ( invoice_id );

CREATE TABLE wxy_package (
    package_id   INT NOT NULL,
    type         VARCHAR(50) NOT NULL,
    price        INT NOT NULL,
    passenger_id INT
);

ALTER TABLE wxy_package ADD CHECK ( price >= 0 );

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

ALTER TABLE wxy_passenger ADD CONSTRAINT wxy_passenger_pk PRIMARY KEY ( passenger_id );

CREATE TABLE wxy_passenger_room (
    price        INT NOT NULL COMMENT 'price of this room for this passenger',
    room_id      INT NOT NULL,
    passenger_id INT NOT NULL
);

ALTER TABLE wxy_passenger_room ADD CHECK ( price >= 0 );

ALTER TABLE wxy_passenger_room ADD CONSTRAINT wxy_passenger_room_pk PRIMARY KEY ( room_id, passenger_id );

CREATE TABLE wxy_payment (
    payment_id INT NOT NULL COMMENT 'payment id',
    amount     INT NOT NULL COMMENT 'amount in us dollar',
    `DATE`     DATETIME NOT NULL COMMENT 'payment data',
    method     VARCHAR(50) NOT NULL COMMENT 'payment method',
    invoice_id VARCHAR(8) NOT NULL COMMENT 'invoice the payment for'
);

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

ALTER TABLE wxy_port ADD CONSTRAINT wxy_port_pk PRIMARY KEY ( port_id );

CREATE TABLE wxy_restaurant (
    restaurant_id INT NOT NULL COMMENT 'restaurant id',
    type          VARCHAR(20) NOT NULL COMMENT 'restaurant type',
    start_time    DATETIME NOT NULL COMMENT 'restaurant service start time',
    end_time      DATETIME NOT NULL COMMENT 'restaurant service end time',
    floor         INTEGER NOT NULL COMMENT 'restaurant on which floor',
    cruise_id     INT NOT NULL COMMENT 'restaurant belong to which cruise'
);

ALTER TABLE wxy_restaurant
    ADD CHECK ( type IN ( 'Common Buffett', 'Italian Specialty', 'La carte continental', 'Mexican Specialty', 'Ming Work Chinese',
                          'Pool Bar', 'Round Clock Cafe', 'Stout Bar', 'Tokyo Ramen Japanese' ) );

ALTER TABLE wxy_restaurant ADD CONSTRAINT wxy_restaurant_pk PRIMARY KEY ( restaurant_id );

CREATE TABLE wxy_stateroom (
    room_id          INT NOT NULL COMMENT 'stateroom id',
    type             VARCHAR(20) NOT NULL COMMENT 'room type',
    `SIZE`           INT NOT NULL COMMENT 'room size',
    bed_num          INT NOT NULL COMMENT 'bed number',
    bathroom_num     INT NOT NULL COMMENT 'bathroom number',
    balcony          INT NOT NULL COMMENT 'balcony number',
    cruise_id        INT NOT NULL COMMENT 'room belong to which cruise',
    price_per_person INT NOT NULL COMMENT 'price of the stateroom',
    position         VARCHAR(20) NOT NULL
);

ALTER TABLE wxy_stateroom
    ADD CHECK ( type IN ( 'club balcony suite', 'family balcony', 'family large balcony', 'inside stateroom', 'oceanview window',
                          'studio stateroom', 'the haven suite' ) );

ALTER TABLE wxy_stateroom ADD CHECK ( price_per_person >= 0 );

ALTER TABLE wxy_stateroom
    ADD CHECK ( position IN ( 'After', 'Forward', 'Left', 'Right' ) );

ALTER TABLE wxy_stateroom ADD CONSTRAINT wxy_stateroom_pk PRIMARY KEY ( room_id );

CREATE TABLE wxy_trip (
    trip_id    INT NOT NULL COMMENT 'trip id',
    nights_num INTEGER NOT NULL COMMENT 'total number of nights'
);

ALTER TABLE wxy_trip ADD CONSTRAINT wxy_trip_pk PRIMARY KEY ( trip_id );

CREATE TABLE wxy_trip_cruise (
    trip_id   INT NOT NULL COMMENT 'trip id',
    cruise_id INT NOT NULL COMMENT 'cruise id'
);

ALTER TABLE wxy_trip_cruise ADD CONSTRAINT wxy_trip_cruise_pk PRIMARY KEY ( trip_id,
                                                                            cruise_id );

CREATE TABLE wxy_trip_port (
    trip_id    INT NOT NULL COMMENT 'trip id',
    port_id    INT NOT NULL COMMENT 'port id',
    type       VARCHAR(20) NOT NULL COMMENT 'port type: start, end, stop',
    start_date DATETIME NOT NULL COMMENT 'port start date',
    end_date   DATETIME NOT NULL COMMENT 'port end data'
);

ALTER TABLE wxy_trip_port
    ADD CHECK ( type IN ( 'end_port', 'start_port', 'stop_port' ) );

ALTER TABLE wxy_trip_port ADD CONSTRAINT wxy_trip_port_pk PRIMARY KEY ( port_id,
                                                                        trip_id );

CREATE TABLE wxy_user (
    user_id    INT NOT NULL,
    password   VARCHAR(50) NOT NULL,
    membership VARCHAR(50) NOT NULL
);

ALTER TABLE wxy_user ADD CONSTRAINT wxy_user_pk PRIMARY KEY ( user_id );

ALTER TABLE wxy_entertainment
    ADD CONSTRAINT wxy_entertainment_cruise_fk FOREIGN KEY ( cruise_id )
        REFERENCES wxy_cruise ( cruise_id );

ALTER TABLE wxy_group_invoice
    ADD CONSTRAINT wxy_group_invoice_fk FOREIGN KEY ( invoice_id )
        REFERENCES wxy_invoice ( invoice_id );

ALTER TABLE wxy_group_invoice
    ADD CONSTRAINT wxy_group_invoice_wxy_group_fk FOREIGN KEY ( group_id )
        REFERENCES wxy_group ( group_id );

ALTER TABLE wxy_group
    ADD CONSTRAINT wxy_group_wxy_trip_fk FOREIGN KEY ( trip_id )
        REFERENCES wxy_trip ( trip_id );

ALTER TABLE wxy_package
    ADD CONSTRAINT wxy_package_wxy_passenger_fk FOREIGN KEY ( passenger_id )
        REFERENCES wxy_passenger ( passenger_id );

ALTER TABLE wxy_passenger_room
    ADD CONSTRAINT wxy_passenger_room_fk FOREIGN KEY ( passenger_id )
        REFERENCES wxy_passenger ( passenger_id );

ALTER TABLE wxy_passenger
    ADD CONSTRAINT wxy_passenger_wxy_group_fk FOREIGN KEY ( group_id )
        REFERENCES wxy_group ( group_id );

ALTER TABLE wxy_passenger
    ADD CONSTRAINT wxy_passenger_wxy_user_fk FOREIGN KEY ( user_id )
        REFERENCES wxy_user ( user_id );

ALTER TABLE wxy_passenger_room
    ADD CONSTRAINT wxy_passroom_stateroom_fk FOREIGN KEY ( room_id )
        REFERENCES wxy_stateroom ( room_id );

ALTER TABLE wxy_payment
    ADD CONSTRAINT wxy_payment_wxy_invoice_fk FOREIGN KEY ( invoice_id )
        REFERENCES wxy_invoice ( invoice_id );

ALTER TABLE wxy_restaurant
    ADD CONSTRAINT wxy_restaurant_wxy_cruise_fk FOREIGN KEY ( cruise_id )
        REFERENCES wxy_cruise ( cruise_id );

ALTER TABLE wxy_stateroom
    ADD CONSTRAINT wxy_stateroom_wxy_cruise_fk FOREIGN KEY ( cruise_id )
        REFERENCES wxy_cruise ( cruise_id );

ALTER TABLE wxy_trip_cruise
    ADD CONSTRAINT wxy_trip_cruise_wxy_cruise_fk FOREIGN KEY ( cruise_id )
        REFERENCES wxy_cruise ( cruise_id );

ALTER TABLE wxy_trip_cruise
    ADD CONSTRAINT wxy_trip_cruise_wxy_trip_fk FOREIGN KEY ( trip_id )
        REFERENCES wxy_trip ( trip_id );

ALTER TABLE wxy_trip_port
    ADD CONSTRAINT wxy_trip_port_wxy_port_fk FOREIGN KEY ( port_id )
        REFERENCES wxy_port ( port_id );

ALTER TABLE wxy_trip_port
    ADD CONSTRAINT wxy_trip_port_wxy_trip_fk FOREIGN KEY ( trip_id )
        REFERENCES wxy_trip ( trip_id );