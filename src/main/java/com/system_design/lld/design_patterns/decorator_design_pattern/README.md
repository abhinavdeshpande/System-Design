# Decorator Design Pattern - Spring Boot Implementation

## What is the Decorator Design Pattern?

The **Decorator Pattern** is a **structural design pattern** that allows us to dynamically add behavior to an object without modifying its existing code. Instead of using inheritance, it follows the **composition principle** by wrapping objects inside decorators that add extra functionalities.

## Analogy

Imagine you order a **coffee** at a café. A simple coffee is just plain black coffee. Now, if you want to **add milk, sugar, or caramel**, you don’t create a new type of coffee for each combination. Instead, you decorate the base coffee with **add-ons**.

- **Base Component:** Plain Coffee
- **Decorators:** Milk, Sugar, Caramel, Whipped Cream

You can **dynamically** add or remove these decorators as needed, rather than creating multiple subclasses for each coffee variation.

## Benefits of Using the Decorator Pattern

1. **Extensibility** – Allows adding new functionalities at runtime without modifying the base class.
2. **Follows Open-Closed Principle** – The original class remains unchanged.
3. **Flexible Design** – Avoids subclass explosion (i.e., multiple subclasses for every combination of behavior).
4. **Composition Over Inheritance** – Uses object composition rather than deep inheritance trees.

---

## Project Structure

```
com.system_design.lld.design_patterns.decorator_design_pattern
│── dao
│   ├── OrderRepository.java
│   ├── UserRepository.java
│── dto
│   ├── OrderRequestDTO.java
│   ├── OrderResponseDTO.java
│   ├── UserRequestDTO.java
│   ├── UserResponseDTO.java
│── rest_controller
│   ├── DDP_OrderController.java
│   ├── DDP_UserController.java
│── service
│   ├── OrderService.java
│   ├── UserService.java
│── service_impl
│   ├── OrderServiceImpl.java
│   ├── UserServiceImpl.java
│── util
│   ├── DiscountDecorator.java
│   ├── GiftWrapDecorator.java
│   ├── OrderDecorator.java
│   ├── PriorityOrderDecorator.java
```

### Component Breakdown

#### **DAO (Data Access Object)**
Manages database operations for storing and retrieving `Order` and `User` data.

#### **DTO (Data Transfer Object)**
Provides structured representations of `Order` and `User` data for API requests and responses.

#### **Rest Controllers**
Handles incoming HTTP requests and maps them to the appropriate services:
- `DDP_OrderController.java`: Manages order-related operations.
- `DDP_UserController.java`: Handles user-related operations.

#### **Service Interfaces**
Defines business logic contracts that must be implemented:
- `OrderService.java`: Interface for managing order processing.
- `UserService.java`: Interface for handling user-related operations.

#### **Service Implementations**
Implements the business logic defined in service interfaces:
- `OrderServiceImpl.java`: Processes orders, applies decorators, and saves to the database.
- `UserServiceImpl.java`: Manages user creation, updates, and retrieval.

#### **Util (Utility Classes)**
Contains decorators that dynamically modify order behavior:
- `DiscountDecorator.java`: Applies a discount to the order.
- `GiftWrapDecorator.java`: Adds gift-wrapping to the order.
- `OrderDecorator.java`: Base decorator class for modifying order behavior.
- `PriorityOrderDecorator.java`: Marks an order as high priority.

---

## API Endpoints

### 1️⃣ User Management APIs

#### Create User

**Endpoint:** `POST /decorator-design-pattern/user/create`

```json
{
    "name": "Alice",
    "email": "alice@example.com"
}
```

#### Update User

**Endpoint:** `PUT /decorator-design-pattern/user/update`

```json
{
    "userId": "65f5b8e3c7a12",
    "name": "Alice Updated",
    "email": "alice.new@example.com"
}
```

#### Delete User

**Endpoint:** `PUT /decorator-design-pattern/user/delete`

```json
{
    "userId": "65f5b8e3c7a12"
}
```

#### Get User

**Endpoint:** `GET /decorator-design-pattern/user/get?userId=65f5b8e3c7a12`

#### Get All Users

**Endpoint:** `GET /decorator-design-pattern/user/all`

---

### 2️⃣ Order Processing APIs

#### Process Order

**Endpoint:** `POST /decorator-design-pattern/order/process`

```json
{
    "userId": "65f5b8e3c7a12",
    "details": "New Laptop",
    "price": 500.0,
    "decorators": ["discount", "priority", "gift wrap"]
}
```

---

Happy Coding 🚀

