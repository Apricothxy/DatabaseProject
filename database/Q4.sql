-- 查询预订了房间但未订购任何套餐的乘客ID
SELECT DISTINCT passenger_id
FROM wxy_passenger_room
EXCEPT
SELECT DISTINCT passenger_id
FROM wxy_package;
