# Point of Sale

![IntelliJ](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![SpringBoot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)

This is the backend implementation of a Point of Sale (POS) system in which the basics of building a REST API were put into practice. This system was developed in Java 17 using the Spring Boot V3 framework and MySQL 8 as database.

## Tools
- IDE IntelliJ IDEA
- Java 17
- Spring Boot 3
- MySQL 8, MySQL Workbench 8.0

## Features
- Provides a RESTful API for managing point of sale operations.
- Supports CRUD (Create, Read, Update, Delete) operations for various entities such as customers, employees, categories, products and sales.
- Implements validation and error handling for request data.
- Integrates with a MySQL database to store and retrieve data.

## Future Enhancements
- Utilizes JWT (JSON Web Tokens) for authentication and authorization.
- User management and access control
- Multi-language support
- Enhanced error handling and logging

## Prerequisites
- Java 17 or higher installed.
- MySQL 8 or higher installed.
- Maven 3.x or higher installed.

## Getting Started

Follow these steps to get the backend system up and running on your local machine:

1. Clone this repository:

   ```bash
   git clone https://github.com/lguisadom/point-of-sale.git
   ```
   
2. Navigate to the project directory:
    ```bash
    cd point-of-sale
    ```
    
3. Configure the database connection in the application.yml file located inside the `src/main/resources` directory
   ```yaml
     spring:
       datasource:
         url: jdbc:mysql://localhost:3306/db_pos
         username: root
         password: mysql
         driver-class-name: com.mysql.cj.jdbc.Driver
   ```
      
4. Configure the port where the application will run. For example, in my case it is port 8082 since in my local I have port 8080 occupied by another process.
   ```yaml
     server:
       port: 8082
   ```

5. Build the project using Maven:
   ```bash
       mvn clean install
   ```
    
6. Run the application:
   ```bash
       mvn spring-boot:run
   ```
    
The backend system should now be running on http://localhost:8082 (It depends on the port you have configured in the yaml file)

7. You can test the application with Postman by importing the "PointOfSale.postman_collection.json" postman file located inside the `src/main/resources` directory


## API Documentation
The API documentation is available at http://localhost:8082/swagger-ui.html. This documentation provides detailed information about the available endpoints, request and response structures, and authentication requirements.
This documentation was generated using Springdoc V2, a powerful tool that integrates with Spring Boot to automatically generate API documentation from your code.

![Documentation](https://i.imgur.com/sGmBHJp.png "Documentation")


## Database Relational Model

![Relational Model](https://i.imgur.com/qZ6xgYj.png "Relational model")
