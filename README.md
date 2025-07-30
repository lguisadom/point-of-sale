# Point of Sale (POS) System

![IntelliJ](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
![SpringBoot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=Swagger&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![HATEOAS](https://img.shields.io/badge/HATEOAS-FF6B6B?style=for-the-badge&logo=spring&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-FF6B6B?style=for-the-badge&logo=lombok&logoColor=white)

## 📋 Description

Point of Sale (POS) system developed in Java 21 with Spring Boot 3.2.0. This project implements a complete REST API for supermarket management, including sales, inventory, customers, employees, and suppliers.

## 🛠️ Technologies Used

- **Java 21** - Programming language
- **Spring Boot 3.2.0** - Development framework
- **Spring Data JPA** - Data persistence
- **Spring Security** - Security (basic configuration)
- **Spring HATEOAS** - Hypermedia API (Level 3 Richardson)
- **MySQL 8** - Database
- **Maven** - Dependency management
- **Lombok** - Boilerplate code reduction
- **ModelMapper** - Object mapping
- **Bean Validation** - Data validation
- **SpringDoc OpenAPI** - API documentation
- **Swagger UI** - Documentation interface

## 🚀 Implemented Features

### ✅ Complete CRUD Operations
- **Customers** (`/api/v1/customers`) - Complete management with HATEOAS
- **Sales** (`/api/v1/sales`) - Sales creation with details
- **Departments** (`/api/v1/departments`) - Location management
- **Provinces** (`/api/v1/provinces`) - Location management
- **Districts** (`/api/v1/districts`) - Location management
- **Document Types** (`/api/v1/document-types`) - System configuration
- **Person Types** (`/api/v1/person-types`) - System configuration
- **Genders** (`/api/v1/genders`) - System configuration

### ✅ System Features
- **RESTful API** with complete CRUD operations
- **Data validation** with custom messages
- **Centralized exception handling**
- **Automatic documentation** with Swagger/OpenAPI
- **Multi-language support** (Spanish, English, French)
- **HATEOAS** implemented for resource navigation
- **Automatic object mapping** with ModelMapper
- **Test data** included for development

### ✅ Complete Data Model
The system includes the following entities:
- **Sales and Sale Details** - Transaction management
- **Products** - Inventory with stock control
- **Categories** - Product classification
- **Providers** - Supplier management
- **Employees** - Staff management
- **Customers** - Customer management
- **Purchases and Purchase Details** - Acquisition management
- **Users and Roles** - User system (entities created)
- **Menus** - Navigation system (entity created)

## ⚠️ Features in Development

### 🔄 Pending Implementation
- **Missing controllers** for Product, Employee, Category, Provider, User
- **JWT Authentication** - Basic configuration present but not active
- **Role-based authorization** - Entities created but not implemented
- **Complete tests** - Only tests exist for some entities
- **Inventory management** - Business logic for stock
- **Reports** - Sales report generation

## 📋 Prerequisites

- **Java 21** or higher
- **MySQL 8** or higher
- **Maven 3.x** or higher
- **IDE** (recommended: IntelliJ IDEA)

## 🚀 Installation and Configuration

### 1. Clone the repository
```bash
git clone https://github.com/lguisadom/point-of-sale.git
cd point-of-sale
```

### 2. Configure the database
Edit `src/main/resources/application.yml`:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/db_pos
    username: root
    password: mysql
    driver-class-name: com.mysql.cj.jdbc.Driver
```

### 3. Configure the port (optional)
```yaml
server:
  port: 8082  # Change if port 8082 is occupied
```

### 4. Build and run
```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will be available at: **http://localhost:8082**

> **Note**: This project is configured for **Java 21** and **Spring Boot 3.2.0**. Make sure you have the correct Java version installed.

## 📚 API Documentation

### Swagger UI
Access the interactive documentation at: **http://localhost:8082/swagger-ui.html**

![Swagger Documentation](https://i.imgur.com/sGmBHJp.png "Swagger Documentation")

### Main Endpoints

| Endpoint | Description | Methods | Authentication |
|----------|-------------|---------|----------------|
| `/api/v1/public/health` | Health check | GET | ❌ Public |
| `/api/v1/public/info` | System information | GET | ❌ Public |
| `/api/v1/customers` | Customer management | GET, POST, PUT, DELETE | ✅ Required |
| `/api/v1/sales` | Sales creation | POST | ✅ Required |
| `/api/v1/departments` | Department management | GET, POST, PUT, DELETE | ✅ Required |
| `/api/v1/provinces` | Province management | GET, POST, PUT, DELETE | ✅ Required |
| `/api/v1/districts` | District management | GET, POST, PUT, DELETE | ✅ Required |
| `/api/v1/document-types` | Document types | GET, POST, PUT, DELETE | ✅ Required |
| `/api/v1/person-types` | Person types | GET, POST, PUT, DELETE | ✅ Required |
| `/api/v1/genders` | Genders | GET, POST, PUT, DELETE | ✅ Required |

### Authentication

The system uses **Basic Authentication** with the following users created automatically:

| Username | Password | Role | Description |
|----------|----------|------|-------------|
| `admin` | `admin123` | ADMIN | Full access to all endpoints |
| `user01` | `user01123` | READ | Read-only access |
| `user02` | `user02123` | WRITE | Read and write access |

#### Using Basic Authentication

**With cURL:**
```bash
# Public endpoint (no authentication required)
curl http://localhost:8082/api/v1/public/health

# Protected endpoint (authentication required)
curl -u admin:admin123 http://localhost:8082/api/v1/customers
```

**With Postman:**
1. Go to the **Authorization** tab
2. Select **Basic Auth** from the Type dropdown
3. Enter username and password
4. Send the request

### Postman Usage Example
Import the Postman collection located at: `src/main/resources/PointOfSale.postman_collection.json`

## 🗄️ Database Model

The system uses a complete relational model that includes:

![Relational Model](https://i.imgur.com/qZ6xgYj.png "Relational Model")

### Main Entities:
- **Sales** - Sales with details
- **Products** - Products with stock control
- **Customers** - Customers with complete information
- **Employees** - System employees
- **Providers** - Product suppliers
- **Categories** - Product categories

## 🧪 Testing

### Available Tests
- `GenderDtoUnitTest` - Unit tests for DTOs
- `GenderServiceImplTest` - Service tests
- `DistrictServiceImplTest` - Service tests

### Run Tests
```bash
mvn test
```

## 🌐 Multi-language Support

The system includes support for multiple languages:
- `messages.properties` - Spanish (default)
- `messages_en.properties` - English
- `messages_fr.properties` - French

## 🔧 Additional Configurations

### Logging
```yaml
logging:
  level:
    org.hibernate.SQL: debug  # View SQL queries
```

### HATEOAS
Implemented for navigation between related resources.

### Validations
Custom validation messages for each entity.

## 📝 Development Notes

- **Java Version**: Updated to Java 21 for better performance and latest features
- **Spring Boot**: Updated to 3.2.0 for full Java 21 compatibility
- **Security**: Basic Authentication implemented with database users
- **JWT**: Mentioned in code but not completely implemented
- **Tests**: More tests are needed to cover all functionality
- **Documentation**: API is documented with Swagger/OpenAPI

## 🤝 Contributing

1. Fork the project
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is under the MIT License. See the `LICENSE` file for more details.

## 👨‍💻 Author

**Luis Guisado** - [GitHub](https://github.com/lguisadom)

---

⭐ If this project has been useful to you, give it a star!
