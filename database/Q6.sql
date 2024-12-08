SELECT passenger_id, fname, lname, total_amount
FROM (
    SELECT
        p.passenger_id,
        p.fname,
        p.lname,
        SUM(pr.price) AS total_amount
    FROM wxy_passenger AS p
    JOIN wxy_passenger_room AS pr
        ON p.passenger_id = pr.passenger_id
    GROUP BY p.passenger_id, p.fname, p.lname
    ORDER BY total_amount DESC
) AS RankedPassengers
LIMIT 5;
