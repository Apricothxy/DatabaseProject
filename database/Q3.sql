-- 查询每位乘客订购价格高于其平均套餐价格的套餐信息
SELECT package_id, passenger_id, type, price
FROM wxy_package AS wp1
WHERE price > (
    SELECT AVG(price)
    FROM wxy_package AS wp2
    WHERE wp2.passenger_id = wp1.passenger_id
);
