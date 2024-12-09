SELECT DISTINCT passenger_id
FROM wxy_passenger_room
EXCEPT
SELECT DISTINCT passenger_id
FROM wxy_package;
