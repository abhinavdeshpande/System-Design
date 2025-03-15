# Factory Design Pattern in Spring Boot

This project demonstrates the **Factory Design Pattern** in a **Spring Boot** application with **MongoDB** for storing orders. The implementation includes **DTOs**, **ResponseEntity-based API responses**, and **multiple payment service implementations**.

---

## Project Structure
```
factory_design_pattern
│── dao
│   └── OrderRepository.java
│
│── dto
│   ├── OrderRequestDTO.java
│   └── OrderResponseDTO.java
│
│── entity
│   └── OrderEntity.java
│
│── rest_controller
│   └── OrderController.java
│
│── service
│   ├── OrderService.java
│   └── PaymentService.java
│
│── service_impl
│   ├── CreditCardPaymentService.java
│   ├── OrderServiceImpl.java
│   └── UPIPaymentService.java
│
│── util
│   └── PaymentFactory.java
```
---
## 🖌️ Factory Design Pattern Explanation

### 📚 What is the Factory Design Pattern?

The Factory Design Pattern is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.

### It is commonly used when:

The exact type of object needed is determined at runtime.

We encapsulate object creation to keep code clean and maintainable.

We decouple object creation from the actual business logic.

### 🎨 Real-Life Analogy

Think of a coffee shop where customers order different types of coffee (Espresso, Cappuccino, Latte, etc.). Instead of the cashier making the coffee themselves, they pass the order to the barista, who knows exactly how to prepare each type of coffee.

The Customer → Calls the cashier and requests a coffee.

The Cashier (Factory) → Decides which coffee should be made.

The Barista (Concrete Class) → Makes the specific coffee.

The Customer receives the coffee → They don’t need to know how it was made.

Here, the **Factory** decides which coffee (object) should be created based on the customer's choice.

---

## 🖌️ Design Pattern Used
This project follows the **Factory Design Pattern** to dynamically select the appropriate **Payment Service** implementation at runtime.

✅ **Decouples business logic from service implementations**  
✅ **Supports multiple payment methods** (Credit Card, UPI, etc.)  
✅ **Easily extensible for new payment methods**

---

## 🚀 How It Works
1. **Client (API Request)** → Calls `POST /orders/process`
2. **Controller** → Calls `OrderServiceImpl`
3. **Service** → Uses `PaymentFactory` to get the required payment service
4. **Payment Service** → Executes the payment logic
5. **MongoDB Repository** → Saves the order details
6. **Response DTO** → Returns structured API response

---

## 🔹 API Endpoints
### 🟢 Create Order (Process Payment)
**`POST /orders/process`**  
Processes an order with the given payment method.

#### 📌 Request
```json
{
  "userId": "user123",
  "amount": 150.0,
  "paymentMethod": "CREDIT_CARD"
}
```

#### 📌 Response (201 - Created)
```json
{
  "orderId": "65f9b2c8a7e3f1a2b4c8d9e1",
  "userId": "user123",
  "amount": 150.0,
  "paymentMethod": "CREDIT_CARD",
  "processed": true,
  "message": "Order processed successfully!"
}
```

#### 📌 Response (400 - Bad Request for Invalid Method)
```json
{
  "orderId": null,
  "userId": "user456",
  "amount": 100.0,
  "paymentMethod": "BITCOIN",
  "processed": false,
  "message": "Invalid payment method: BITCOIN"
}
```
---

## 📈 Extending the Project
✅ **Add More Payment Methods** (e.g., Google Pay, Apple Pay)  
✅ **Implement Refund Processing**  
✅ **Add Authentication (JWT Security)**

---

## 🤝 Contributing
Want to improve this project? Feel free to fork, submit PRs, or suggest ideas!

---

