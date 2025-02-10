# Observer Design Pattern in Java Spring Boot

## Overview

This project demonstrates the **Observer Design Pattern** using **Java Spring Boot**. The Observer Pattern allows objects (observers) to receive automatic updates from another object (subject) whenever there is a state change.

## What is the Observer Design Pattern?

The Observer Pattern is like a notification system. It lets you have objects (called "subjects") that maintain a list of other objects (called "observers") that depend on them. When the subject's state changes, it automatically notifies all its observers.

## Analogy

Think of a news channel (subject) and its viewers (observers). When the news channel has a breaking story (state change), it informs all its viewers.

## General Example

Let's say you have a **WeatherData** object (subject) that tracks temperature, humidity, and pressure. You have several displays (observers) that show this data.

1. **Subject (WeatherData):**
   - Maintains a list of observers.
   - Has methods to set the data and notify observers.

2. **Observer (Display):**
   - Updates its display when notified.

## Benefits of the Observer Pattern

1. **Decoupling:** Subject and observers don't need to know much about each other.
2. **Flexibility:** You can add or remove observers easily.
3. **Event Handling:** Useful for handling events and notifications.

## Project Structure

```
com.system_design.lld.design_patterns.observer_design_pattern
│── dao
│   ├── ItemDao.java
│   ├── UserDao.java
│── dto
│   ├── ItemDto.java
│   ├── UserDto.java
│── rest_controller
│   ├── ItemController.java
│   ├── UserController.java
│── service
│   ├── ItemSubject.java
│   ├── ManageItem.java
│   ├── NotificationStrategy.java
│   ├── UserObserver.java
│── service_impl
│   ├── EmailNotificationImpl.java
│   ├── ItemSubjectImpl.java
│   ├── ManageItemImpl.java
│   ├── SmsNotificationImpl.java
│   ├── UserObserverImpl.java
│   ├── WhatsAppNotificationImpl.java
│── util
│   ├── NotificationMode.java
```

## Components Breakdown

### **DAO Layer**
- **ItemDao.java**: Repository for managing `ItemDto` in MongoDB.
- **UserDao.java**: Repository for managing `UserDto` in MongoDB.

### **DTO Layer**
- **ItemDto.java**: Represents an item entity with properties like name, quantity, and status.
- **UserDto.java**: Represents a user entity who subscribes to item notifications.

### **REST Controllers**
- **ItemController.java**: Handles CRUD operations for items.
- **UserController.java**: Handles user registration and deregistration as observers.

### **Service Interfaces**
- **ItemSubject.java**: Interface for managing item subject and notifications.
- **ManageItem.java**: Interface for handling item-related operations.
- **NotificationStrategy.java**: Defines the notification strategy for users.
- **UserObserver.java**: Interface for observer users receiving notifications.

### **Service Implementations**
- **EmailNotificationImpl.java**: Sends notifications via email.
- **ItemSubjectImpl.java**: Implements subject behavior for managing item notifications.
- **ManageItemImpl.java**: Implements item management functionality.
- **SmsNotificationImpl.java**: Sends notifications via SMS.
- **UserObserverImpl.java**: Implements observer behavior and delegates notifications.
- **WhatsAppNotificationImpl.java**: Sends notifications via WhatsApp.

### **Utility**
- **NotificationMode.java**: Enum defining different notification modes (`EMAIL`, `SMS`, `WHATSAPP`).

## API Endpoints

### **Item Management APIs**

- **Add Item:**
  ```sh
  POST /observer-design-pattern/item/add
  ```
- **Remove Item:**
  ```sh
  PUT /observer-design-pattern/item/remove
  ```
- **Get All Items:**
  ```sh
  GET /observer-design-pattern/item/all
  ```
- **Update Item Detail:**
  ```sh
  PUT /observer-design-pattern/item/detail
  ```
- **Get Item Detail:**
  ```sh
  GET /observer-design-pattern/item/detail?itemId={id}
  ```

### **User Registration APIs**

- **Register Observer:**
  ```sh
  POST /observer-design-pattern/user/registration
  ```
- **Deregister Observer:**
  ```sh
  DELETE /observer-design-pattern/user/deregistration
  ```

## MongoDB Configuration

```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=system_design
```

---
Happy Coding! 🚀

