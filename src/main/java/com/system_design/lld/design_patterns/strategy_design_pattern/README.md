# Strategy Design Pattern in Java Spring Boot

Let's break down the Strategy Design Pattern in a simple way, with an easy example and a visual representation.

## What is the Strategy Pattern?

The Strategy Pattern lets you define a family of algorithms (or strategies) and make them interchangeable at runtime.  Instead of hardcoding a specific behavior into your class, you can choose which algorithm to use dynamically.  This makes your code more flexible and easier to maintain.

## Analogy

Imagine you're traveling. You might choose different modes of transportation (strategies) depending on the distance, cost, and your preferences: walking, taking a bus, or flying in a plane.  The Strategy Pattern is like having a system that can dynamically choose the best transportation strategy for your trip.

## Benefits of the Strategy Pattern:

- Flexibility: You can easily add new strategies without modifying the Order class.
- Maintainability: The code is more organized and easier to understand. Each strategy is encapsulated in its own class.
- Reusability: Strategies can be reused in other parts of your application.
- Open/Closed Principle: You can add new strategies without modifying existing code.
   
This example demonstrates the core idea of the Strategy Pattern. You can apply it to various situations where you need to choose between different algorithms or behaviors at runtime.  Remember to adapt the example to your specific needs and programming language.

## Overview

This project demonstrates the **Strategy Design Pattern** using **Java Spring Boot**. The Strategy Pattern allows selecting an algorithm's behavior at runtime. Here, we use different shipping strategies for calculating the total order cost dynamically.

## Project Structure

```
com.system_design.lld.design_patterns.strategy_design_pattern
│── dto
│   ├── Item.java
│   ├── Order.java
│── rest_controller
│   ├── StrategyDPRestController.java
│── service
│   ├── ShippingStrategy.java
│── service_impl
│   ├── ExpressShipping.java
│   ├── OneDayShipping.java
│   ├── StandardShipping.java
```

## Components Breakdown

### 1. DTO (Data Transfer Objects)
- **Item.java**: Represents an item in the order.
- **Order.java**: Represents an order containing multiple items and applies a chosen shipping strategy.

### 2. Service Interface
- **ShippingStrategy.java**: Defines a contract for different shipping strategies.

### 3. Service Implementations
- **ExpressShipping.java**: Implements express shipping with a fixed cost of Rs. 50.
- **OneDayShipping.java**: Implements one-day shipping with a fixed cost of Rs. 100.
- **StandardShipping.java**: Implements standard shipping with a fixed cost of Rs. 10.

### 4. REST Controller
- **StrategyDPRestController.java**: Exposes an API endpoint for applying different shipping strategies dynamically.

## How It Works

1. The client sends a request with a list of items and a selected `shippingMode`.
2. The controller dynamically assigns the appropriate shipping strategy.
3. The total cost is calculated based on the item prices and the selected shipping strategy.

## API Endpoint
```sh
   GET /strategy-design-pattern/shipping?shippingMode=express
   ```

```sh
   GET /strategy-design-pattern/shipping?shippingMode=one-day
   ```

```sh
   GET /strategy-design-pattern/shipping?shippingMode=null
   ```
---
Happy Coding! 🚀

