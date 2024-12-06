### 后端接口列表

- **注册用户**
  - 方法：`POST`
  - URL：`/api/register`
  - 描述：注册新用户。
  - 输入：username, password
  - 返回值：字符串，描述注册成功或失败
  
- **用户登录**
  
  - 方法：`POST`
  
  - URL：`/api/login`
  
  - 描述：用户登录，获取数据库自增userid。
  
  - 输入：username, password
  
  - 返回值：
  
    ```json
    [  
    	{
            status: "success"
            userID: userid
        }
        OR
        {
            status: "fail"
            message: message
        }
    ]
    ```
  
- **获取旅行列表**
  
  - 方法：`GET`
  
  - URL：`/api/search`
  
  - 描述：获取所有可用的旅行信息。
  
  - 输入：startPortName, endPortName, startDate, endDate
  
  - 返回值
  
    ```json
    [
        {
            "cruiseName": "Cruise A",
            "startTime": "2024-12-05T10:00:00",
            "endTime": "2024-12-10T15:00:00",
            "startPortName": "Port A",
            "endPortName": "Port B",
            "stopPorts": [
                {
                    "portName": "Port C",
                    "arrivalTime": "2024-12-06T12:00:00",
                    "departureTime": "2024-12-06T18:00:00"
                },
                {
                    "portName": "Port D",
                    "arrivalTime": "2024-12-08T09:00:00",
                    "departureTime": "2024-12-08T12:00:00"
                }
            ],
            "pricePerPerson": 299.99
        },
        {
            "cruiseName": "Cruise B",
            "startTime": "2024-12-07T08:00:00",
            "endTime": "2024-12-14T18:00:00",
            "startPortName": "Port X",
            "endPortName": "Port Y",
            "stopPorts": [
                {
                    "portName": "Port Z",
                    "arrivalTime": "2024-12-09T10:00:00",
                    "departureTime": "2024-12-09T14:00:00"
                }
            ],
            "pricePerPerson": 499.99
        }
    ]
    ```
  
- **获取用户信息**
  
  - 方法：`GET`(TBD)
  - URL：`/users/{userId}`
  - 描述：根据用户ID获取用户信息。
  
- **创建乘客同行人**
  - 方法：`POST`(TBD)
  - URL：`/addpassengers`
  - 描述：创建新的乘客信息。
  
- **获取乘客信息**
  - 方法：`GET`(TBD)
  - URL：`/passengers/{passengerId}`
  - 描述：获取指定乘客的信息。

- **获取旅行详情**
  
  - 方法：`GET`(TBD)
  - URL：`/trips/{tripId}`
  - 描述：获取特定旅行的详细信息。
  
- **创建预订**
  - 方法：`POST`(TBD)
  - URL：`/bookings`
  - 描述：创建新的预订。
  
- **获取预订信息**
  - 方法：`GET`(TBD)
  - URL：`/bookings/{bookingId}`
  - 描述：获取指定预订的详细信息。

- **提交支付**
  - 方法：`POST`(TBD)
  - URL：`/payments`
  - 描述：提交新的支付信息。
  
- **获取支付信息**
  - 方法：`GET`(TBD)
  - URL：`/payments/{paymentId}`
  - 描述：获取指定支付的详细信息。

- **获取发票信息**
  - 方法：`GET`(TBD)
  - URL：`/invoices/{invoiceId}`
  - 描述：获取指定发票的详细信息。