This is a series of System Design concepts with examples in Java Spring Boot.

Here are the steps to clone the repository and run it locally:
1. Clone the Repository:
   git clone https://github.com/abhinavdeshpande/System-Design.git

2. Navigate to the repository directory:
   cd System-Design

3. Build the Maven Project:
   mvn clean install

4. Import the project in any IDE

5. Configure your IDE [Java version 23]

6. Run the Project

7. Install any API Testing Tools. (ex. Postman, Insomnia)

8. Hit the APIs to get the result of the corresponding design pattern.

List of APIs:

1. Strategy Design Pattern:

   a. api: /lld/design-pattern/strategy-design-pattern/shipping
   
   b. payload (values of properties can be changed): Array of {name, price}

   ex. [{ "name": "Show Piece", "price": 300 }, { "name": "Wall Paper", "price": 1000	},	{ "name": "Door Mat", "price": 100 }]
   
   c. query params: shippingMode=one-day || shippingMode=express || shippingMode=null
   
   d. url preview:

   	i. shippingMode=one-day: 
         http://localhost:8080/lld/design-pattern/observer-design-pattern/?shippingMode=one-day
   
      ii. shippingMode=express: 
          http://localhost:8080/lld/design-pattern/observer-design-pattern/?shippingMode=express
   
      iii. shippingMode=null: 
           http://localhost:8080/lld/design-pattern/observer-design-pattern/?shippingMode=null
