WITH PackageTotal AS (
    SELECT
        passenger_id,
        SUM(price) AS total_amount
    FROM wxy_package
    GROUP BY passenger_id
)
SELECT
    p.passenger_id,
    p.fname,
    p.lname,
    pt.total_amount
FROM wxy_passenger AS p
JOIN PackageTotal AS pt
    ON p.passenger_id = pt.passenger_id
WHERE pt.total_amount > 200;
