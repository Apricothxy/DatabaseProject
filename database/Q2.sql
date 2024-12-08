SELECT passenger_id, fname, lname, email
FROM wxy_passenger
WHERE passenger_id IN (
    SELECT DISTINCT passenger_id
    FROM wxy_package
    WHERE type = 'Unlimited Bar'
);
