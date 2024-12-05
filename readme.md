### 后端需要编写的接口列表

- **注册用户**
  - 方法：`POST`(TBD)
  - URL：`/users/signup`
  - 描述：注册新用户。
- **用户登录**
  - 方法：`POST`(TBD)
  - URL：`/users/login`
  - 描述：用户登录，获取认证令牌。
- **获取用户信息**
  - 方法：`GET`
  - URL：`/users/{userId}`
  - 描述：根据用户ID获取用户信息。

- **创建乘客同行人**
  - 方法：`POST`
  - URL：`/addpassengers`
  - 描述：创建新的乘客信息。
- **获取乘客信息**
  - 方法：`GET`
  - URL：`/passengers/{passengerId}`
  - 描述：获取指定乘客的信息。

- **获取旅行列表**
  - 方法：`GET`
  - URL：`/search`
  - 描述：获取所有可用的旅行信息。
- **获取旅行详情**
  - 方法：`GET`
  - URL：`/trips/{tripId}`
  - 描述：获取特定旅行的详细信息。

- **创建预订**
  - 方法：`POST`
  - URL：`/bookings`
  - 描述：创建新的预订。
- **获取预订信息**
  - 方法：`GET`
  - URL：`/bookings/{bookingId}`
  - 描述：获取指定预订的详细信息。

- **提交支付**
  - 方法：`POST`
  - URL：`/payments`
  - 描述：提交新的支付信息。
- **获取支付信息**
  - 方法：`GET`
  - URL：`/payments/{paymentId}`
  - 描述：获取指定支付的详细信息。

- **获取发票信息**
  - 方法：`GET`
  - URL：`/invoices/{invoiceId}`
  - 描述：获取指定发票的详细信息。