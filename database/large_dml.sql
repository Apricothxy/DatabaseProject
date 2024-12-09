USE databaseproject;

INSERT INTO wxy_user (password, membership, user_name) VALUES
('pass123', 'Gold', 'john_doe'),
('mypwd456', 'Silver', 'jane_smith'),
('secure789', 'Bronze', 'michael_lee'),
('pwdabc', 'Gold', 'anna_johnson'),
('pwdddf', 'Silver', 'mark_wilson'),
('decpass1', 'Bronze', 'william_brown'),
('decpass2', 'Silver', 'lisa_hall'),
('decpass3', 'Gold', 'robert_king'),
('decpass4', 'Bronze', 'chris_taylor'),
('decpass5', 'Silver', 'david_clark');

INSERT INTO wxy_trip (nights_num) VALUES
(7), (10), (5), (14), (3), (7), (4), (9), (12), (5),
(5), (6), (7), (8), (9), (10), (4), (3), (11), (12),
(7), (8), (6), (5), (9), (10), (12), (4), (7), (8),
(6), (11), (5), (9), (7), (10), (3), (4), (11), (12),
(6), (5), (8), (7), (9), (4), (10), (3), (12), (11);

INSERT INTO wxy_group (trip_id) VALUES
(1),
(1),
(2),
(3),
(4),
(6),
(6),
(7),
(8),
(9),
(10);

INSERT INTO wxy_port (port_id, port_name, state, country, address1, address2, nearest_airport_name, number_of_parking_spots) VALUES
(101, 'Los Angeles', 'California', 'USA', 'Pier 93', NULL, 'LAX', 500),
(102, 'Miami', 'Florida', 'USA', 'Port Blvd', NULL, 'MIA', 300),
(103, 'Vancouver', 'British Columbia', 'Canada', 'Canada Place', NULL, 'YVR', 200),
(104, 'New York', 'New York', 'USA', 'Manhattan Cruise Terminal', NULL, 'JFK', 400),
(105, 'Seattle', 'Washington', 'USA', 'Pier 66', NULL, 'SEA', 250),
(106, 'San Francisco', 'California', 'USA', 'Ferry Bldg', NULL, 'SFO', 350),
(107, 'San Diego', 'California', 'USA', 'B St Pier', NULL, 'SAN', 200),
(108, 'Boston', 'Massachusetts', 'USA', 'Black Falcon Ave', NULL, 'BOS', 250),
(109, 'Halifax', 'Nova Scotia', 'Canada', 'Pier 21', NULL, 'YHZ', 150),
(110, 'Tampa', 'Florida', 'USA', 'Channelside Dr', NULL, 'TPA', 300),
(111, 'Anchorage', 'Alaska', 'USA', 'Port Avenue', NULL, 'ANC', 120),
(112, 'Honolulu', 'Hawaii', 'USA', 'Pier 2', NULL, 'HNL', 250),
(113, 'Juneau', 'Alaska', 'USA', 'Marine Way', NULL, 'JNU', 80),
(114, 'Ketchikan', 'Alaska', 'USA', 'Front Street', NULL, 'KTN', 90),
(115, 'Sitka', 'Alaska', 'USA', 'Harbor Way', NULL, 'SIT', 70),
(116, 'Portland', 'Maine', 'USA', 'Commercial Street', NULL, 'PWM', 200),
(117, 'Bar Harbor', 'Maine', 'USA', 'Main Street', NULL, 'BHB', 50),
(118, 'Quebec City', 'Quebec', 'Canada', 'Dalhousie Street', NULL, 'YQB', 150),
(119, 'Montreal', 'Quebec', 'Canada', 'De la Commune Street', NULL, 'YUL', 180),
(120, 'Charlottetown', 'Prince Edward Island', 'Canada', 'Great George Street', NULL, 'YYG', 70),
(121, 'Toronto', 'Ontario', 'Canada', 'Queens Quay', NULL, 'YYZ', 300),
(122, 'Niagara-on-the-Lake', 'Ontario', 'Canada', 'Front Street', NULL, 'IAG', 90),
(123, 'Cleveland', 'Ohio', 'USA', 'Dock 28', NULL, 'CLE', 150),
(124, 'Detroit', 'Michigan', 'USA', 'Jefferson Avenue', NULL, 'DTW', 200),
(125, 'Chicago', 'Illinois', 'USA', 'Navy Pier', NULL, 'ORD', 250),
(126, 'Milwaukee', 'Wisconsin', 'USA', 'Water Street', NULL, 'MKE', 180),
(127, 'Duluth', 'Minnesota', 'USA', 'Canal Park', NULL, 'DLH', 100),
(128, 'Thunder Bay', 'Ontario', 'Canada', 'Waterfront Drive', NULL, 'YQT', 80),
(129, 'Buffalo', 'New York', 'USA', 'Lakefront Blvd', NULL, 'BUF', 200),
(130, 'Erie', 'Pennsylvania', 'USA', 'Bayfront Parkway', NULL, 'ERI', 150),
(131, 'Rochester', 'New York', 'USA', 'Port of Rochester', NULL, 'ROC', 100),
(132, 'Kingston', 'Ontario', 'Canada', 'Ontario Street', NULL, 'YGK', 50),
(133, 'Ottawa', 'Ontario', 'Canada', 'Rideau Street', NULL, 'YOW', 80),
(134, 'Green Bay', 'Wisconsin', 'USA', 'Main Street', NULL, 'GRB', 70),
(135, 'Mackinac Island', 'Michigan', 'USA', 'Fort Street', NULL, 'CIU', 30),
(136, 'Traverse City', 'Michigan', 'USA', 'Front Street', NULL, 'TVC', 50),
(137, 'Bay City', 'Michigan', 'USA', 'Water Street', NULL, 'MBS', 40),
(138, 'Toledo', 'Ohio', 'USA', 'Waterfront', NULL, 'TOL', 90),
(139, 'Sandusky', 'Ohio', 'USA', 'Cedar Point Road', NULL, 'SKY', 60),
(140, 'Manitowoc', 'Wisconsin', 'USA', 'Marina Avenue', NULL, 'MTW', 40),
(141, 'Sturgeon Bay', 'Wisconsin', 'USA', '3rd Avenue', NULL, 'SUE', 30),
(142, 'Sheboygan', 'Wisconsin', 'USA', '8th Street', NULL, 'SBM', 50),
(143, 'Grand Haven', 'Michigan', 'USA', 'Harbor Drive', NULL, 'GRR', 70),
(144, 'Holland', 'Michigan', 'USA', '8th Street', NULL, 'BIV', 50),
(145, 'Muskegon', 'Michigan', 'USA', 'Western Avenue', NULL, 'MKG', 80),
(146, 'South Haven', 'Michigan', 'USA', 'Phoenix Street', NULL, 'BEH', 60),
(147, 'Sault Ste. Marie', 'Michigan', 'USA', 'Portage Avenue', NULL, 'SSM', 40),
(148, 'Bayfield', 'Wisconsin', 'USA', 'Broad Street', NULL, 'ASX', 30),
(149, 'Superior', 'Wisconsin', 'USA', 'Tower Avenue', NULL, 'SUW', 50),
(150, 'Two Harbors', 'Minnesota', 'USA', 'Water Street', NULL, 'TWM', 20);


INSERT INTO wxy_trip_port (trip_id, port_id, type, start_date, end_date) VALUES
(1, 101, 'start_port', '2024-01-01 09:00:00', '2024-01-01 18:00:00'),
(1, 102, 'stop_port', '2024-01-02 09:00:00', '2024-01-02 20:00:00'),
(1, 103, 'end_port', '2024-01-03 09:00:00', '2024-01-03 18:00:00'),

(2, 104, 'start_port', '2024-02-10 09:00:00', '2024-02-10 18:00:00'),
(2, 105, 'end_port', '2024-02-15 09:00:00', '2024-02-15 18:00:00'),

(3, 102, 'start_port', '2024-03-05 09:00:00', '2024-03-05 18:00:00'),
(3, 103, 'end_port', '2024-03-10 09:00:00', '2024-03-10 18:00:00'),

(4, 104, 'start_port', '2024-12-10 09:00:00' ,'2024-12-10 11:00:00'),
(4, 111, 'stop_port', '2024-12-15 09:00:00' ,'2024-12-15 11:00:00'),
(4, 105, 'stop_port', '2024-12-16 09:00:00' ,'2024-12-16 11:00:00'),
(4, 101, 'end_port', '2024-12-18 09:00:00' ,'2024-12-18 11:00:00'),

(5, 117, 'start_port', '2024-12-07 09:00:00', '2024-12-07 18:00:00'),
(5, 118, 'stop_port',  '2024-12-08 09:00:00', '2024-12-08 20:00:00'),
(5, 119, 'end_port',   '2024-12-09 09:00:00', '2024-12-09 18:00:00'),
(6, 120, 'start_port', '2024-12-10 09:00:00', '2024-12-10 18:00:00'),
(6, 121, 'stop_port',  '2024-12-11 09:00:00', '2024-12-11 20:00:00'),
(6, 122, 'end_port',   '2024-12-12 09:00:00', '2024-12-12 18:00:00'),
(7, 123, 'start_port', '2024-12-13 09:00:00', '2024-12-13 18:00:00'),
(7, 124, 'stop_port',  '2024-12-14 09:00:00', '2024-12-14 20:00:00'),
(7, 125, 'end_port',   '2024-12-15 09:00:00', '2024-12-15 18:00:00'),
(8, 126, 'start_port', '2024-12-16 09:00:00', '2024-12-16 18:00:00'),
(8, 127, 'stop_port',  '2024-12-17 09:00:00', '2024-12-17 20:00:00'),
(8, 128, 'end_port',   '2024-12-18 09:00:00', '2024-12-18 18:00:00'),
(9, 129, 'start_port', '2024-12-19 09:00:00', '2024-12-19 18:00:00'),
(9, 130, 'stop_port',  '2024-12-20 09:00:00', '2024-12-20 20:00:00'),
(9, 131, 'end_port',   '2024-12-21 09:00:00', '2024-12-21 18:00:00'),
(10, 132, 'start_port', '2024-12-22 09:00:00', '2024-12-22 18:00:00'),
(10, 133, 'stop_port',  '2024-12-23 09:00:00', '2024-12-23 20:00:00'),
(10, 134, 'end_port',   '2024-12-24 09:00:00', '2024-12-24 18:00:00'),
(11, 135, 'start_port', '2024-12-25 09:00:00', '2024-12-25 18:00:00'),
(11, 136, 'stop_port',  '2024-12-26 09:00:00', '2024-12-26 20:00:00'),
(11, 137, 'end_port',   '2024-12-27 09:00:00', '2024-12-27 18:00:00'),
(12, 138, 'start_port', '2024-12-28 09:00:00', '2024-12-28 18:00:00'),
(12, 139, 'stop_port',  '2024-12-29 09:00:00', '2024-12-29 20:00:00'),
(12, 140, 'end_port',   '2024-12-30 09:00:00', '2024-12-30 18:00:00'),
(13, 141, 'start_port', '2024-12-01 09:00:00', '2024-12-01 18:00:00'),
(13, 142, 'stop_port',  '2024-12-02 09:00:00', '2024-12-02 20:00:00'),
(13, 143, 'end_port',   '2024-12-03 09:00:00', '2024-12-03 18:00:00'),
(14, 144, 'start_port', '2024-12-04 09:00:00', '2024-12-04 18:00:00'),
(14, 145, 'stop_port',  '2024-12-05 09:00:00', '2024-12-05 20:00:00'),
(14, 146, 'end_port',   '2024-12-06 09:00:00', '2024-12-06 18:00:00'),
(15, 147, 'start_port', '2024-12-07 09:00:00', '2024-12-07 18:00:00'),
(15, 148, 'stop_port',  '2024-12-08 09:00:00', '2024-12-08 20:00:00'),
(15, 149, 'end_port',   '2024-12-09 09:00:00', '2024-12-09 18:00:00'),
(16, 150, 'start_port', '2024-12-10 09:00:00', '2024-12-10 18:00:00'),
(16, 111, 'stop_port',  '2024-12-11 09:00:00', '2024-12-11 20:00:00'),
(16, 112, 'end_port',   '2024-12-12 09:00:00', '2024-12-12 18:00:00'),

(17, 102, 'start_port', '2024-03-05 09:00:00', '2024-03-05 18:00:00'),
(17, 103, 'end_port', '2024-03-10 09:00:00', '2024-03-10 18:00:00'),

(18, 102, 'start_port', '2024-03-05 09:00:00', '2024-03-05 18:00:00'),
(18, 103, 'end_port', '2024-03-10 09:00:00', '2024-03-10 18:00:00'),
(19, 102, 'start_port', '2024-03-05 09:00:00', '2024-03-05 18:00:00'),
(19, 103, 'end_port', '2024-03-10 09:00:00', '2024-03-10 18:00:00'),
(20, 102, 'start_port', '2024-03-05 09:00:00', '2024-03-05 18:00:00'),
(20, 103, 'end_port', '2024-03-10 09:00:00', '2024-03-10 18:00:00'),

(21, 102, 'start_port', '2024-03-05 09:00:00', '2024-03-05 18:00:00'),
(21, 103, 'end_port', '2024-03-10 09:00:00', '2024-03-10 18:00:00'),

(22, 102, 'start_port', '2024-03-05 09:00:00', '2024-03-05 18:00:00'),
(22, 103, 'end_port', '2024-03-10 09:00:00', '2024-03-10 18:00:00'),

(23, 102, 'start_port', '2024-03-05 09:00:00', '2024-03-05 18:00:00'),
(23, 103, 'end_port', '2024-03-10 09:00:00', '2024-03-10 18:00:00');

INSERT INTO wxy_cruise (trip_id, cruise_name) VALUES
(1, 'Pacific Explorer'),
(2, 'Caribbean Dream'),
(3, 'Alaskan Venture'),
(4, 'Atlantic Adventure'),
(5, 'Gulf Navigator'),
(6, 'Arctic Breeze'),
(7, 'Tropic Express'),
(8, 'Eastern Voyager'),
(9, 'Northern Star'),
(10, 'Western Horizon'),
(11, 'Western Escape'),
(12, 'Alaskan Marvel'),
(13, 'Pacific Splendor'),
(14, 'Ocean Breeze'),
(15, 'Southern Cross'),
(16, 'Great Lakes Explorer'),
(17, 'Hudson River Cruise'),
(18, 'St. Lawrence Seaway'),
(19, 'Panama Passage'),
(20, 'Gulf Coast Adventure'),
(21, 'Mexican Riviera'),
(22, 'Bayou Breeze'),
(23, 'California Coastline'),
(24, 'Midwest Marvel'),
(25, 'Deep South Sojourn'),
(26, 'Cape Cod Circuit'),
(27, 'Alaskan Heritage'),
(28, 'Vancouver Voyage'),
(29, 'Rocky Shores'),
(30, 'Columbia River Ride'),
(31, 'Florida Fantasy'),
(32, 'Bahamas Bliss'),
(33, 'Key West Express'),
(34, 'Cuba Explorer'),
(35, 'Atlantic Odyssey'),
(36, 'Gulf Shores Delight'),
(37, 'New England Charm'),
(38, 'Big Apple Sail'),
(39, 'Great White North'),
(40, 'Alaskan Majesty'),
(41, 'Sapphire Journey'),
(42, 'Emerald Voyage'),
(43, 'Ruby Dream'),
(44, 'Diamond Serenity'),
(45, 'Crystal Ocean'),
(46, 'Golden Horizon'),
(47, 'Silver Wave'),
(48, 'Platinum Expedition'),
(49, 'Titanic Heritage'),
(50, 'Legacy of the Seas');

INSERT INTO wxy_passenger (fname, mname, lname, birth_date, address_country, address_state, address_city, address_street_1, address_street_2, gender, nationality, email, phone, user_id)
VALUES
('John', NULL, 'Doe', '1990-05-20 00:00:00', 'USA', 'California', 'Los Angeles', 'Sunset Blvd', NULL, 'Male', 'USA', 'john.doe@example.com', '123-456-7890', 1),
('Jane', 'A', 'Smith', '1985-07-10 00:00:00', 'USA', 'Florida', 'Miami', 'Ocean Dr', NULL, 'Female', 'USA', 'jane.smith@example.com', '234-567-8901', 2),
('Michael', 'B', 'Lee', '1992-03-15 00:00:00', 'Canada', 'BC', 'Vancouver', 'Water St', NULL, 'Male', 'Canada', 'michael.lee@example.com', '345-678-9012', 3),
('Anna', NULL, 'Johnson', '1995-11-05 00:00:00', 'USA', 'New York', 'New York', '5th Ave', 'Apt 101', 'Female', 'USA', 'anna.johnson@example.com', '456-789-0123', 4),
('Mark', 'C', 'Wilson', '1988-01-25 00:00:00', 'USA', 'Washington', 'Seattle', '1st Ave', NULL, 'Male', 'USA', 'mark.wilson@example.com', '567-890-1234', 5),
('William', NULL, 'Brown', '1980-12-05 00:00:00', 'USA', 'California', 'San Francisco', 'Market St', NULL, 'Male', 'USA', 'william.brown@example.com', '111-222-3333', 6),
('Lisa', 'M', 'Hall', '1990-12-10 00:00:00', 'USA', 'California', 'San Diego', 'C St', NULL, 'Female', 'USA', 'lisa.hall@example.com', '222-333-4444', 7),
('Robert', NULL, 'King', '1985-12-15 00:00:00', 'USA', 'Massachusetts', 'Boston', 'Beacon St', 'Apt 2', 'Male', 'USA', 'robert.king@example.com', '333-444-5555', 8),
('Chris', 'A', 'Taylor', '1992-12-20 00:00:00', 'Canada', 'Nova Scotia', 'Halifax', 'Lower Water St', NULL, 'Male', 'Canada', 'chris.taylor@example.com', '444-555-6666', 9),
('David', 'C', 'Clark', '1978-12-25 00:00:00', 'USA', 'Florida', 'Tampa', 'Channelside Dr', NULL, 'Male', 'USA', 'david.clark@example.com', '555-666-7777', 10),
('Sophia', NULL, 'Lopez', '1995-12-02 00:00:00', 'USA', 'California', 'Los Angeles', 'Broadway', NULL, 'Female', 'USA', 'sophia.lopez@example.com', '666-777-8888', 1),
('Emily', 'J', 'Davis', '1987-12-12 00:00:00', 'USA', 'Florida', 'Miami', 'Flagler St', NULL, 'Female', 'USA', 'emily.davis@example.com', '777-888-9999', 1),
('James', NULL, 'Martinez', '1991-12-22 00:00:00', 'USA', 'Washington', 'Seattle', 'Pike St', NULL, 'Male', 'USA', 'james.martinez@example.com', '888-999-0000', 2),
('Mia', 'F', 'Johnson', '1993-12-18 00:00:00', 'Canada', 'BC', 'Vancouver', 'Cordova St', NULL, 'Female', 'Canada', 'mia.johnson@example.com', '999-000-1111', 3),
('Daniel', 'H', 'Smith', '1986-12-28 00:00:00', 'USA', 'New York', 'New York', 'Madison Ave', 'Floor 10', 'Male', 'USA', 'daniel.smith@example.com', '000-111-2222', 4);

INSERT INTO wxy_passenger_group (group_id, passenger_id) VALUES
(1, 1),
(1, 2),
(2, 3),
(3, 4),
(4, 5),
(5, 6),
(6, 7),
(7, 8),
(7, 9),
(8, 10),
(9, 11),
(9, 12),
(10,13),
(10,14),
(10,15);

INSERT INTO wxy_package (type, price, passenger_id) VALUES
('Water and Non-Alcoholic', 99.99, 1),
('Unlimited Bar', 199.99, 2),
('Internet 200 minutes, 100 GB', 49.99, 3),
('Unlimited Internet', 149.99, 4),
('Specialty dining', 79.99, 5),
('Water and Non-Alcoholic', 89.99, 6),
('Unlimited Bar', 199.99, 7),
('Internet 200 minutes, 100 GB', 59.99, 8),
('Unlimited Internet', 159.99, 9),
('Specialty dining', 79.99, 10),
('Unlimited Bar', 189.99, 11),
('Water and Non-Alcoholic', 99.99, 12);

INSERT INTO wxy_invoice (amount, invoice_date, group_id) VALUES
(500.00, '2024-01-01 10:00:00', 1),
(1000.00, '2024-01-02 11:00:00', 2),
(750.00, '2024-02-10 12:00:00', 3),
(200.00, '2024-03-05 13:00:00', 4),
(300.00, '2024-04-01 14:00:00', 5),
(400.00, '2024-12-01 10:00:00', 6),
(1200.00, '2024-12-02 10:30:00',7),
(800.00, '2024-12-10 11:00:00', 8),
(100.00, '2024-12-15 11:30:00', 9),
(200.00, '2024-12-20 12:00:00', 10);


INSERT INTO wxy_payment (amount, `DATE`, method, invoice_id) VALUES
(500.00, '2024-01-03 10:00:00', 'applepay', 1),
(1000.00, '2024-01-04 11:00:00', 'applepay', 2),
(750.00, '2024-02-12 12:00:00', 'applepay', 3),
(200.00, '2024-03-06 13:00:00', 'applepay', 4),
(300.00, '2024-04-02 14:00:00', 'googlepay', 5),
(400.00, '2024-12-01 15:00:00', 'googlepay', 6),
(1200.00, '2024-12-03 16:00:00', 'googlepay', 7),
(800.00, '2024-12-11 17:00:00', 'paypal', 8);


INSERT INTO wxy_stateroom (type, SIZE, bed_num, bathroom_num, balcony, cruise_id, price_per_person, position) VALUES
('inside stateroom', 180, 2, 1, 0, 1, 299.99, 'Forward'),
('oceanview window', 250, 2, 1, 0, 1, 399.99, 'After'),
('family balcony', 300, 4, 2, 1, 1, 599.99, 'Left'),
('club balcony suite', 350, 2, 2, 1, 1, 799.99, 'Right'),
('the haven suite', 400, 2, 2, 1, 1, 1299.99, 'Forward'),

('inside stateroom', 180, 2, 1, 0, 2, 299.99, 'Forward'),
('oceanview window', 250, 2, 1, 0, 2, 399.99, 'After'),
('family balcony', 300, 4, 2, 1, 2, 599.99, 'Left'),
('club balcony suite', 350, 2, 2, 1, 2, 799.99, 'Right'),
('the haven suite', 400, 2, 2, 1, 2, 1299.99, 'Forward'),

('inside stateroom', 180, 2, 1, 0, 3, 299.99, 'Forward'),
('oceanview window', 250, 2, 1, 0, 3, 399.99, 'After'),
('family balcony', 300, 4, 2, 1, 3, 599.99, 'Left'),
('club balcony suite', 350, 2, 2, 1, 3, 799.99, 'Right'),
('the haven suite', 400, 2, 2, 1, 3, 1299.99, 'Forward'),

('inside stateroom', 180, 2, 1, 0, 4, 289.99, 'Left'),
('oceanview window', 250, 2, 1, 0, 4, 389.99, 'Right'),
('family balcony', 300, 4, 2, 1, 4, 589.99, 'After'),
('club balcony suite', 350, 2, 2, 1, 4, 789.99, 'Forward'),
('the haven suite', 400, 2, 2, 1, 4, 1289.99, 'Left'),

('inside stateroom', 180, 2, 1, 0, 5, 279.99, 'Right'),
('oceanview window', 250, 2, 1, 0, 5, 379.99, 'Forward'),
('family balcony', 300, 4, 2, 1, 5, 579.99, 'Left'),
('club balcony suite', 350, 2, 2, 1, 5, 779.99, 'After'),
('the haven suite', 400, 2, 2, 1, 5, 1279.99, 'Right'),

('inside stateroom', 180, 2, 1, 0, 6, 269.99, 'Forward'),
('oceanview window', 250, 2, 1, 0, 6, 369.99, 'After'),
('family balcony', 300, 4, 2, 1, 6, 569.99, 'Left'),
('club balcony suite', 350, 2, 2, 1, 6, 769.99, 'Right'),
('the haven suite', 400, 2, 2, 1, 6, 1269.99, 'Forward'),

('inside stateroom', 180, 2, 1, 0, 7, 259.99, 'After'),
('oceanview window', 250, 2, 1, 0, 7, 359.99, 'Forward'),
('family balcony', 300, 4, 2, 1, 7, 559.99, 'Right'),
('club balcony suite', 350, 2, 2, 1, 7, 759.99, 'Left'),
('the haven suite', 400, 2, 2, 1, 7, 1259.99, 'After'),

('inside stateroom', 180, 2, 1, 0, 8, 249.99, 'Left'),
('oceanview window', 250, 2, 1, 0, 8, 349.99, 'Right'),
('family balcony', 300, 4, 2, 1, 8, 549.99, 'Forward'),
('club balcony suite', 350, 2, 2, 1, 8, 749.99, 'After'),
('the haven suite', 400, 2, 2, 1, 8, 1249.99, 'Left'),

('inside stateroom', 180, 2, 1, 0, 9, 239.99, 'Forward'),
('oceanview window', 250, 2, 1, 0, 9, 339.99, 'After'),
('family balcony', 300, 4, 2, 1, 9, 539.99, 'Left'),
('club balcony suite', 350, 2, 2, 1, 9, 739.99, 'Right'),
('the haven suite', 400, 2, 2, 1, 9, 1239.99, 'Forward'),

('inside stateroom', 180, 2, 1, 0, 10, 229.99, 'After'),
('oceanview window', 250, 2, 1, 0, 10, 329.99, 'Forward'),
('family balcony', 300, 4, 2, 1, 10, 529.99, 'Right'),
('club balcony suite', 350, 2, 2, 1, 10, 729.99, 'Left'),
('the haven suite', 400, 2, 2, 1, 10, 1229.99, 'After'),

('inside stateroom', 180, 2, 1, 0, 11, 229.99, 'After'),
('oceanview window', 250, 2, 1, 0, 11, 329.99, 'Forward'),
('family balcony', 300, 4, 2, 1, 11, 529.99, 'Right'),
('club balcony suite', 350, 2, 2, 1, 11, 729.99, 'Left'),
('the haven suite', 400, 2, 2, 1, 11, 1229.99, 'After'),

('inside stateroom', 180, 2, 1, 0, 12, 239.99, 'Forward'),
('oceanview window', 250, 2, 1, 0, 12, 339.99, 'After'),
('family balcony', 300, 4, 2, 1, 12, 539.99, 'Left'),
('club balcony suite', 350, 2, 2, 1, 12, 739.99, 'Right'),
('the haven suite', 400, 2, 2, 1, 12, 1239.99, 'Forward'),

('inside stateroom', 180, 2, 1, 0, 13, 249.99, 'After'),
('oceanview window', 250, 2, 1, 0, 13, 349.99, 'Forward'),
('family balcony', 300, 4, 2, 1, 13, 549.99, 'Right'),
('club balcony suite', 350, 2, 2, 1, 13, 749.99, 'Left'),
('the haven suite', 400, 2, 2, 1, 13, 1249.99, 'After'),

('inside stateroom', 180, 2, 1, 0, 14, 259.99, 'Forward'),
('oceanview window', 250, 2, 1, 0, 14, 359.99, 'After'),
('family balcony', 300, 4, 2, 1, 14, 559.99, 'Left'),
('club balcony suite', 350, 2, 2, 1, 14, 759.99, 'Right'),
('the haven suite', 400, 2, 2, 1, 14, 1259.99, 'Forward'),

('inside stateroom', 180, 2, 1, 0, 15, 259.99, 'Forward'),
('oceanview window', 250, 2, 1, 0, 15, 359.99, 'After'),
('family balcony', 300, 4, 2, 1, 15, 559.99, 'Left'),
('club balcony suite', 350, 2, 2, 1, 15, 759.99, 'Right'),
('the haven suite', 400, 2, 2, 1, 15, 1259.99, 'Forward'),

('inside stateroom', 180, 2, 1, 0, 16, 259.99, 'Forward'),
('oceanview window', 250, 2, 1, 0, 16, 359.99, 'After'),
('family balcony', 300, 4, 2, 1, 16, 559.99, 'Left'),
('club balcony suite', 350, 2, 2, 1, 16, 759.99, 'Right'),
('the haven suite', 400, 2, 2, 1, 16, 1259.99, 'Forward');

INSERT INTO wxy_passenger_room (price, room_id, passenger_id) VALUES
(300.00, 1, 1),
(300.00, 2, 2),
(600.00, 3, 3),
(320.00, 4, 4),
(800.00, 5, 5),
(290.00, 9, 6),
(390.00,10, 7),
(580.00,11, 8),
(760.00,12, 9),
(1299.99,13,10),
(280.00,14,11),
(960.00,15,12),
(250.00,16,13);

INSERT INTO wxy_restaurant (type, start_time, end_time, floor, cruise_id) VALUES
('Common Buffett', '2024-12-01 07:00:00', '2024-12-01 23:00:00', 5, 1),
('Italian Specialty', '2024-12-01 11:00:00', '2024-12-01 22:00:00', 6, 1),
('Tokyo Ramen Japanese', '2024-12-01 09:00:00', '2024-12-01 22:00:00', 7, 1),

('Common Buffett', '2024-12-02 07:00:00', '2024-12-02 23:00:00', 5, 2),
('Mexican Specialty', '2024-12-02 10:00:00', '2024-12-02 22:00:00', 6, 2),

('La carte continental', '2024-12-03 07:00:00', '2024-12-03 22:00:00', 5, 3),

-- 邮轮 4 的餐厅
('Italian Specialty', '2024-12-04 11:00:00', '2024-12-04 22:00:00', 6, 4),
('Ming Work Chinese', '2024-12-04 12:00:00', '2024-12-04 21:00:00', 7, 4),

-- 邮轮 5 的餐厅
('Pool Bar', '2024-12-05 09:00:00', '2024-12-05 21:00:00', 3, 5),
('Round Clock Cafe', '2024-12-05 08:00:00', '2024-12-05 20:00:00', 4, 5),

-- 邮轮 6 的餐厅
('Tokyo Ramen Japanese', '2024-12-06 09:00:00', '2024-12-06 22:00:00', 7, 6),

-- 邮轮 7 的餐厅
('Italian Specialty', '2024-12-07 11:00:00', '2024-12-07 22:00:00', 6, 7),
('Mexican Specialty', '2024-12-07 12:00:00', '2024-12-07 21:00:00', 7, 7),
('Stout Bar', '2024-12-07 14:00:00', '2024-12-07 23:00:00', 8, 7),

-- 邮轮 8 的餐厅
('Common Buffett', '2024-12-08 07:00:00', '2024-12-08 23:00:00', 5, 8),
('Pool Bar', '2024-12-08 09:00:00', '2024-12-08 21:00:00', 3, 8),

-- 邮轮 9 的餐厅
('La carte continental', '2024-12-09 07:00:00', '2024-12-09 22:00:00', 5, 9),
('Round Clock Cafe', '2024-12-09 08:00:00', '2024-12-09 20:00:00', 4, 9),

-- 邮轮 10 的餐厅
('Mexican Specialty', '2024-12-10 10:00:00', '2024-12-10 22:00:00', 6, 10),
('Tokyo Ramen Japanese', '2024-12-10 09:00:00', '2024-12-10 22:00:00', 7, 10),

-- 邮轮 11 的餐厅
('Common Buffett', '2024-12-11 07:00:00', '2024-12-11 23:00:00', 5, 11),
('Italian Specialty', '2024-12-11 11:00:00', '2024-12-11 22:00:00', 6, 11),

-- 邮轮 12 的餐厅
('Ming Work Chinese', '2024-12-12 12:00:00', '2024-12-12 21:00:00', 7, 12),

-- 邮轮 13 的餐厅
('Pool Bar', '2024-12-13 09:00:00', '2024-12-13 21:00:00', 3, 13),
('Round Clock Cafe', '2024-12-13 08:00:00', '2024-12-13 20:00:00', 4, 13),
('Tokyo Ramen Japanese', '2024-12-13 09:00:00', '2024-12-13 22:00:00', 7, 13),

-- 邮轮 14 的餐厅
('Common Buffett', '2024-12-14 07:00:00', '2024-12-14 23:00:00', 5, 14),
('Mexican Specialty', '2024-12-14 10:00:00', '2024-12-14 22:00:00', 6, 14),
('Stout Bar', '2024-12-14 14:00:00', '2024-12-14 23:00:00', 8, 14);

-- 为 cruise_id 从 1 到 14 插入娱乐设施，每个邮轮 1 至 3 个
INSERT INTO wxy_entertainment (type, units_num, floor_1, floor_2, floor_3, age_limits, cruise_id) VALUES
-- 邮轮 1 的娱乐设施
('casino', 1, 10, NULL, NULL, 18, 1),
('gym', 1, 8, NULL, NULL, 16, 1),
('theaters', 1, 9, NULL, NULL, 0, 1),

-- 邮轮 2 的娱乐设施
('children play', 1, 4, NULL, NULL, 0, 2),
('indoor pool', 1, 5, NULL, NULL, 0, 2),

-- 邮轮 3 的娱乐设施
('night club', 1, 7, NULL, NULL, 18, 3),

-- 邮轮 4 的娱乐设施
('outdoor pool', 1, 5, NULL, NULL, 0, 4),
('tennis court', 1, 6, NULL, NULL, 0, 4),

-- 邮轮 5 的娱乐设施
('sona room', 1, 8, NULL, NULL, 18, 5),
('steam room', 1, 9, NULL, NULL, 16, 5),

-- 邮轮 6 的娱乐设施
('theaters', 2, 9, NULL, NULL, 0, 6),

-- 邮轮 7 的娱乐设施
('yoga room', 1, 4, NULL, NULL, 16, 7),
('indoor pool', 1, 5, NULL, NULL, 0, 7),
('casino', 1, 10, NULL, NULL, 18, 7),

-- 邮轮 8 的娱乐设施
('children play', 1, 4, NULL, NULL, 0, 8),
('outdoor pool', 1, 5, NULL, NULL, 0, 8),

-- 邮轮 9 的娱乐设施
('tennis court', 1, 6, NULL, NULL, 0, 9),
('steam room', 1, 8, NULL, NULL, 16, 9),

-- 邮轮 10 的娱乐设施
('sona room', 1, 9, NULL, NULL, 18, 10),
('yoga room', 1, 4, NULL, NULL, 16, 10),

-- 邮轮 11 的娱乐设施
('indoor pool', 1, 5, NULL, NULL, 0, 11),
('theaters', 1, 9, NULL, NULL, 0, 11),

-- 邮轮 12 的娱乐设施
('children play', 1, 4, NULL, NULL, 0, 12),

-- 邮轮 13 的娱乐设施
('night club', 1, 7, NULL, NULL, 18, 13),
('outdoor pool', 1, 5, NULL, NULL, 0, 13),
('casino', 1, 10, NULL, NULL, 18, 13),

-- 邮轮 14 的娱乐设施
('gym', 2, 8, NULL, NULL, 16, 14),
('steam room', 1, 9, NULL, NULL, 16, 14),
('tennis court', 1, 6, NULL, NULL, 0, 14);







