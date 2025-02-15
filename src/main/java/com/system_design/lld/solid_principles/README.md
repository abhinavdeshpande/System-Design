# SOLID Principles in Spring Boot

## Overview
The **SOLID** principles are five design principles that help developers write maintainable, scalable, and testable software. These principles were introduced by **Robert C. Martin** (Uncle Bob) and are widely used in **object-oriented programming**.

This repository demonstrates **SOLID principles** in a **Spring Boot application** with MongoDB, DTOs, Entities, DAO, Service, and Controller layers.

---

## **1. Single Responsibility Principle (SRP)**
- **Definition:** A class should have **only one reason to change** (one responsibility).
- **Analogy:** Imagine a **restaurant waiter**. Their job is to take orders and serve food. If they also start cooking, managing accounts, and cleaning tables, it becomes chaotic.
- **Example in Spring Boot:**
    - The `OrderService` should only handle business logic, not database queries or controller logic.

### **Implementation**
#### **Entity: Order**
```java
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String userId;
    private List<String> itemIds;
    private double price;
    
    // Getters & Setters
}
```
#### **DTO: OrderDTO**
```java
public class OrderDTO {
    private String userId;
    private List<String> itemIds;
    
    // Getters & Setters
}
```
#### **DAO Layer (Repository)**
```java
@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByUserId(String userId);
}
```
#### **Service Layer (Only Business Logic)**
```java
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setUserId(orderDTO.getUserId());
        order.setItemIds(orderDTO.getItemIds());
        order.setPrice(calculatePrice(orderDTO.getItemIds()));
        return orderRepository.save(order);
    }

    private double calculatePrice(List<String> itemIds) {
        return itemIds.size() * 10.0; // Example price calculation
    }
}
```
#### **Controller (Only Handles Requests)**
```java
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
        Order order = orderService.createOrder(orderDTO);
        return ResponseEntity.ok(order);
    }
}
```
---

## **2. Open/Closed Principle (OCP)**
- **Definition:** Classes should be **open for extension** but **closed for modification**.
- **Analogy:** A **USB port** on a laptop. You can plug in different devices (mouse, keyboard, flash drive) without modifying the laptop's motherboard.
- **Example in Spring Boot:**
    - We should not modify the existing `OrderService` but allow new pricing strategies to be added.

### **Implementation**
#### **Create an Interface for Pricing Strategy**
```java
public interface PricingStrategy {
    double calculatePrice(List<String> itemIds);
}
```
#### **Implement Default Pricing Strategy**
```java
@Component
public class DefaultPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(List<String> itemIds) {
        return itemIds.size() * 10.0;
    }
}
```
#### **Modify OrderService to Use Strategy**
```java
@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final PricingStrategy pricingStrategy;

    public OrderService(OrderRepository orderRepository, PricingStrategy pricingStrategy) {
        this.orderRepository = orderRepository;
        this.pricingStrategy = pricingStrategy;
    }

    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setUserId(orderDTO.getUserId());
        order.setItemIds(orderDTO.getItemIds());
        order.setPrice(pricingStrategy.calculatePrice(orderDTO.getItemIds()));
        return orderRepository.save(order);
    }
}
```
---

## **3. Liskov Substitution Principle (LSP)**
- **Definition:** Subtypes should be **substitutable** for their base types.
- **Analogy:** A **credit card** and a **debit card** should work interchangeably for payments.
- **Example in Spring Boot:**
    - A `DiscountedPricingStrategy` should be usable wherever `PricingStrategy` is expected.

#### **Implement Discounted Pricing Strategy**
```java
@Component
public class DiscountedPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(List<String> itemIds) {
        return (itemIds.size() * 10.0) * 0.9; // 10% discount
    }
}
```
---

## **4. Interface Segregation Principle (ISP)**
- **Definition:** Clients should not be forced to depend on **interfaces they do not use**.
- **Analogy:** A **smartphone charger** should not require a laptop connector.
- **Example in Spring Boot:**
    - Instead of a **monolithic** `UserService`, we create **separate interfaces**.

#### **Good Design (Following ISP)**
```java
public interface UserManagementService {
    void createUser(User user);
    void deleteUser(String id);
}

public interface EmailNotificationService {
    void sendPromotionalEmail(String email);
}
```
---

## **5. Dependency Inversion Principle (DIP)**
- **Definition:** High-level modules should not depend on low-level modules. Instead, both should depend on **abstractions**.
- **Analogy:** A **remote control** depends on an **interface** (button press), not the internal circuit of the TV.
- **Example in Spring Boot:**
    - The `OrderService` should depend on an **interface**, not a concrete repository.

#### **Good Design (Following DIP)**
```java
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
```
---

## **Final Thoughts**
The **SOLID** principles improve code maintainability, testability, and scalability. When applied to a **Spring Boot application**, they:
- **Ensure clear separation of concerns.**
- **Promote flexibility through abstraction.**
- **Avoid unnecessary modifications in existing code.**

---

Happy Coding! 🚀

