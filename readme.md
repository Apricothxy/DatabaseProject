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
            "status": "success"
            "userID": ${userid}
        }
        OR
        {
            "status": "fail"
            "message": ${message}
        }
    ]
    ```
  
- **修改密码**
  
  - 方法：`POST`
  
  - URL：`/api/user/cpassword`
  
  - 描述：用户修改密码
  
  - 输入：userid, oldPassword, newPassword 
  
  - 返回值：
  
    ```json
    
    ```
  
    
  
  **修改用户名**
  
  - 方法：`POST`
  
  - URL：`/api/user/cname/`
  
  - 描述：用户修改用户名
  
  - 输入：userid,  newusername
  
  - 返回值：
  
    ```json
    
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
            "tripId": 1,
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
            "tripId": 2,
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

  - 方法：`GET`

  - URL：`/api/users/{userId}`

  - 描述：根据用户ID获取用户信息。

  - 输入：userID

  - 返回值：

    ```json
    {
        "id": 1,
        "username": "test",
        "password": "123",
        "membership": "bronze"
    }
    ```

- **创建乘客同行人**

  - 方法：`POST`

  - URL：`/api/passenger`

  - 删除URL:  `/api/passenger/{passenger_id}`  Method: `DELETE`

  - 描述：创建新的乘客信息。

  - 输入：

    ```json
    {
        "fname": "test1",
        "lname": "Wu",
        "birthDate": "1990-01-01T00:00:00",
        "addressCountry": "China",
        "addressState": "NY",
        "addressCity": "Los Angeles",
        "addressStreet1": "343 Gold St",
        "gender": "Male",
        "nationality": "China",
        "email": "john.doe@example.com",
        "phone": "+1-234-567-890",
        "userId": 1
    }
    ```

  - 输出：

    ```json
    {
        "passengerId": 5,
        "fname": "test2",
        "mname": null,
        "lname": "1234",
        "birthDate": "1991-01-01T00:00:00",
        "addressCountry": "China",
        "addressState": "NY",
        "addressCity": "Los Angeles",
        "addressStreet1": "343 Gold St",
        "addressStreet2": null,
        "gender": "Male",
        "nationality": "China",
        "email": "john.doe@example.com",
        "phone": "+1-234-567-890",
        "groupId": null,
        "userId": 1
    }
    ```

- **根据用户ID获取所有乘客信息**

- - 方法：`GET`

  - URL:  `/api/passenger/user/{user_id}`

  - 返回值：

    ```json
    [
        {
            "passengerId": 1,
            "fname": "John",
            "mname": "A",
            "lname": "Doe",
            "birthDate": "1985-01-01T00:00:00",
            "addressCountry": "USA",
            "addressState": "CA",
            "addressCity": "Los Angeles",
            "addressStreet1": "123 Main St",
            "addressStreet2": null,
            "gender": "Male",
            "nationality": "American",
            "email": "john.doe1@example.com",
            "phone": "1234567890",
            "groupId": null,
            "userId": 1
        },
        {
            "passengerId": 2,
            "fname": "Yuheng",
            "mname": null,
            "lname": "Wu",
            "birthDate": "1990-01-01T00:00:00",
            "addressCountry": "China",
            "addressState": "NY",
            "addressCity": "Los Angeles",
            "addressStreet1": "343 Gold St",
            "addressStreet2": null,
            "gender": "Male",
            "nationality": "China",
            "email": "john.doe@example.com",
            "phone": "+1-234-567-890",
            "groupId": null,
            "userId": 1
        }
    ]
    ```

- **获取乘客信息**

  - 方法：`GET`

  - URL：`/api/passenger/{id}`

  - 描述：获取指定乘客的信息。

  - 输入：passenger_id

  - 输出：

    ```json
    {
        "passengerId": 1,
        "fname": "John",
        "mname": "A",
        "lname": "Doe",
        "birthDate": "1985-01-01T00:00:00",
        "addressCountry": "USA",
        "addressState": "CA",
        "addressCity": "Los Angeles",
        "addressStreet1": "123 Main St",
        "addressStreet2": null,
        "gender": "Male",
        "nationality": "American",
        "email": "john.doe1@example.com",
        "phone": "1234567890",
        "groupId": null,
        "userId": 1
    }
    ```

- **获取旅行详情**

  - 方法：`GET`

  - URL：`/api/tripdetail/{tripId}`

  - 描述：获取特定旅行的详细信息。

  - 输入：tripid

  - 返回值：

    ```json
    {
        "cruiseId": 1,
        "cruiseName": "Black Pearl",
        "entertainments": [
            {
                "entertainmentId": 1,
                "type": "Theaters"
            },
            {
                "entertainmentId": 2,
                "type": "casino"
            }
        ],
        "restaurants": [
            {
                "restaurantId": 1,
                "type": "Common Buffett"
            }
        ],
        "staterooms": [
            {
                "roomId": 1,
                "type": "The Haven Suite",
                "size": 1000,
                "bathroomNum": 3,
                "bedNum": 6,
                "balcony": 2,
                "position": "Forward",
                "pricePerPerson": 500.1
            },
            {
                "roomId": 2,
                "type": "family balcony",
                "size": 1100,
                "bathroomNum": 4,
                "bedNum": 7,
                "balcony": 2,
                "position": "Forward",
                "pricePerPerson": 1500.1
            }
        ]
    }
    ```

- **创建预订**

  - 方法：`POST`(TBD)

  - URL：`/api/bookings`

  - 描述：创建新的预订。

    - 创建Group记录，创建passenger_group记录
    - 创建passenger_room记录，
    - update package中passenger记录
    - 创建invoice记录

  - 输入：

    ```json
    [
      {
        "tripId": 1,
        "passengerId": 1,
        "stateroomId": 1,
        "stateroomNum": 7,
        "packages": [
          { "packageType": "Water and Non-Alcoholic",
          	"packageNum" : 1
          },
          { "packageType": "Unlimited Bar",
          	"packageNum" : 1
          },
          { "packageType": "Internet 200 minutes",
          	"packageNum" : 1
          }
        ]
      },
      {
        "tripId": 1,
        "passengerId": 2,
        "stateroomId": 1,
        "stateroomNum": 7,
        "packages": [
          { "packageType": "Unlimited internet",
          	"packageNum" : 1
          },
          { "packageType": "Specialty dining",
          	"packageNum" : 1
          }
        ]
      }
    ]
    
    ```

  - 返回值：

    ```json
    [  
    	{
            "status": "success"
            "invoiceID": invoiceid
    	    "TotalPrice": totalprice
        }
        OR
        {
            "status": "fail"
            "message": message
    	    "TotalPrice": -1
        }
    ]
    ```

  

- **提交支付**
  - 方法：`POST`
  
  - URL：`/api/payments`
  
  - 描述：提交新的支付信息。
  
  - 输入：
  
    ```json
    {
        "invoiceId": 1,
        "amount": 1000.50,
        "method": "Credit Card"
    }
    
    ```
  
    
  
  - 返回值：
  
    ```json
    {
        "paymentId": 1,
        "invoiceId": 1,
        "amount": 1000.5,
        "method": "Credit Card",
        "date": "2024-12-07T12:34:56.789+00:00"
    }
    
    ```
    
    
  
  
  
- **获取发票/支付信息**
  
  - 方法：`GET`
  
  - URL：`/api/invoices/{user_id}`
  
  - 描述：获取指定发票的详细信息。
  
  - 输入：
  
    ```
    user_id
    ```
  
    
  
  - 返回值：
  
    ```
    [
    	{
    		"tripId": 1
    		"groupId":1
    		"invoiceId": 3 
    		"invoiceAmout": 2000.0
    		(String)"paymentId": "5"
    		"panssgers"[
    			{
    				"passengerId"
    				"passengerFName"
    				"passengerLName"
    			},
    			{
    				"passengerId"
    				"passengerFName"
    				"passengerLName"
    			},
    		]
    	},
    	{
    		"tripId": 2
    		"groupId":1
    		"invoiceId": 4
    		"invoiceAmout": 1000.0
    		(String)"paymentId": "Fail"
    		"panssgers"[
    			{
    				"passengerId"
    				"passengerFName"
    				"passengerLName"
    			},
    			{
    				"passengerId"S
    				"passengerFName"
    				"passengerLName"
    			},
    		]
    	}
    	
    	
    ]
    ```
  
  
  ### Admin
  
  **获取trip信息**
  
  - 方法：`GET`
  
  - URL：`/api/trip/getall`
  
  - 描述：获取全部的trip信息。
  
  - 输入：无
  
  - 返回值
  
    ```json
    {
      "trips": [
        {
          "tripId": 1,
          "cruiseId": 101,
          "cruiseName": "Caribbean Explorer",
          "startPort": {
            "portName": "Miami",
            "startDate": "2024-01-04T12:00:00Z",
            "endDate": "2024-01-04T12:00:00Z"
          },
          "endPort": {
            "portName": "Cozumel",
            "startDate": "2024-01-12T08:00:00Z",
            "endDate": "2024-01-12T08:00:00Z"
          },
          "stopPort": [
            {
              "portName": "Key West",
              "startDate": "2024-01-05T10:00:00Z",
              "endDate": "2024-01-05T20:00:00Z"
            },
            {
              "portName": "Cayman Islands",
              "startDate": "2024-01-06T09:00:00Z",
              "endDate": "2024-01-06T18:00:00Z"
            }
          ]
        },
        {
          "tripId": 2,
          "cruiseId": 104,
          "cruiseName": "Baltic Highlights",
          "startPort": {
            "portName": "Copenhagen",
            "startDate": "2024-04-01T10:00:00Z",
            "endDate": "2024-04-01T10:00:00Z"
          },
          "endPort": {
            "portName": "Stockholm",
            "startDate": "2024-04-07T07:00:00Z",
            "endDate": "2024-04-07T07:00:00Z"
          },
          "stopPort": []
        }
      ]
    }
    
    ```
  
    

**添加一个trip**

- 方法：`POST`

- URL：`/api/trip/add`

- 描述：添加一个trip

- 输入：

  ```json
  
  "cruiseId": 105,
  "startPort": {
    "portId": 201,
    "startDate": "2024-05-01T10:00:00Z",
    "endDate": "2024-05-01T10:00:00Z"
  },
  "endPort": {
    "portId": 202,
    "startDate": "2024-05-10T09:00:00Z",
    "endDate": "2024-05-10T09:00:00Z"
  },
  "stopPort": [
    {
      "portId": 203,
      "startDate": "2024-05-02T07:00:00Z",
      "endDate": "2024-05-02T18:00:00Z"
    },
    {
      "portId": 204,
      "startDate": "2024-05-03T08:00:00Z",
      "endDate": "2024-05-03T16:00:00Z"
    }
  ]
  ```

  

- 返回值

  success ?