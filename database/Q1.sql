SELECT
    t.trip_id AS tripId,
    g.group_id AS groupId,
    i.invoice_id AS invoiceId,
    i.amount AS invoiceAmount,
    COALESCE(pa.payment_id, -1) AS paymentId,
    pg.passenger_id AS passengerId,
    p.fname AS passengerFName,
    p.lname AS passengerLName
FROM
    wxy_group g
    JOIN wxy_invoice i ON g.group_id = i.group_id
    LEFT JOIN wxy_payment pa ON i.invoice_id = pa.invoice_id
    JOIN wxy_passenger_group pg ON g.group_id = pg.group_id
    JOIN wxy_passenger p ON pg.passenger_id = p.passenger_id AND p.user_id = 1
    JOIN wxy_trip t ON t.trip_id = g.trip_id
ORDER BY i.invoice_id;