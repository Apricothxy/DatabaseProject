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
    JSON {
    	status: "success"
    	userID: userid
    }
    or
    JSON {
        status: "fail"
    	message: message
    }
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

- **获取旅行列表**
  - 方法：`GET`(TBD)
  - URL：`/search`
  - 描述：获取所有可用的旅行信息。
  
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