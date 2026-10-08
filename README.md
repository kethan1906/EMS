# Employee Management System

A backend REST API built using **Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL** for managing employee information.

The application provides APIs for creating, retrieving, updating, deleting, and filtering employees based on salary.

## Features

* Create a new employee
* Retrieve an employee by ID
* Retrieve all employees
* Update employee information
* Delete an employee
* Find employees whose salary is greater than a specified amount
* Persistent employee data using MySQL
* Database operations using Spring Data JPA
* Hibernate second-level caching support

## Tech Stack

* **Java 17**
* **Spring Boot 3.5.5**
* **Spring Web**
* **Spring Data JPA**
* **Hibernate**
* **MySQL**
* **Maven**
* **Ehcache / JCache**

## Project Architecture

The project follows a layered backend architecture:

```text
Client
   |
   v
Controller Layer
   |
   v
Service Layer
   |
   v
Repository Layer
   |
   v
MySQL Database
```

### Controller

`EmployeeController`

Responsible for:

* Receiving HTTP requests
* Mapping API endpoints
* Reading request parameters/body
* Calling the service layer
* Returning HTTP responses

### Service

`EmployeeService`
`EmployeeServiceImpl`

Contains the application's business logic.

The service layer separates business operations from the HTTP/API layer.

### Repository

`EmployeeRepo`

Uses Spring Data JPA's `CrudRepository` to perform database operations.

It also defines a derived query:

```java
List<Employee> findBySalaryGreaterThan(int sal);
```

Spring Data JPA generates the required database query from the method name.

### Entity

`Employee`

Represents an employee record in the database.

The entity contains:

* Employee ID
* Full name
* Age
* Salary

The class is mapped to the database using JPA annotations.

### DTO

`EmployeeDTO`

Used for receiving employee information when creating an employee.

It contains:

* Full name
* Age
* Salary

Using a DTO separates the API input structure from the database entity.

## Database

The application uses MySQL.

Database configuration is provided in:

```text
src/main/resources/application.properties
```

The configured database is:

```text
emp_db
```

The application uses:

```properties
spring.jpa.hibernate.ddl-auto=update
```

so Hibernate can automatically update the database schema based on the entity structure during development.

## API Endpoints

Base URL:

```text
/employee
```

### 1. Add Employee

```http
POST /employee/add
```

Example request:

```json
{
  "fullName": "John Doe",
  "age": 25,
  "salary": 60000
}
```

Returns the created employee.

HTTP status:

```text
201 CREATED
```

---

### 2. Get Employee

```http
GET /employee/get/{empid}
```

Example:

```http
GET /employee/get/1
```

Returns the employee associated with the specified ID.

---

### 3. Get All Employees

```http
GET /employee/all
```

Returns all employees stored in the database.

---

### 4. Find Employees by Salary

```http
GET /employee/getBySalGt/{sal}
```

Example:

```http
GET /employee/getBySalGt/50000
```

Returns employees whose salary is greater than the specified amount.

This functionality is implemented using the Spring Data JPA derived query:

```java
findBySalaryGreaterThan(int sal)
```

---

### 5. Update Employee

```http
PUT /employee/update
```

Example request:

```json
{
  "empid": 1,
  "name": "John Doe",
  "age": 26,
  "salary": 70000
}
```

Updates the employee using the repository's save operation.

---

### 6. Delete Employee

```http
DELETE /employee/delete?empid=1
```

Deletes the employee with the specified ID.

## Database Interaction

The project uses:

```java
CrudRepository<Employee, Integer>
```

This provides common database operations such as:

```text
save()
findById()
findAll()
deleteById()
```

Therefore, the application does not need to manually write SQL for basic CRUD operations.

## JPA Entity

The `Employee` class is mapped as a JPA entity.

Important annotations include:

```java
@Entity
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
```

These annotations tell Hibernate how the Java class maps to the database.

## Caching

The project also includes Hibernate second-level caching using JCache/Ehcache.

The `Employee` entity is configured with:

```java
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
```

The application configuration enables Hibernate's second-level cache.

The service also contains a method demonstrating repeated retrieval of the same employee inside a transaction.

## Running the Application

### Prerequisites

Install:

* Java 17
* Maven
* MySQL

### 1. Create the database

Create a MySQL database:

```sql
CREATE DATABASE emp_db;
```

### 2. Configure MySQL

Update:

```text
src/main/resources/application.properties
```

with your MySQL username and password.

Example:

```properties
spring.datasource.username=root
spring.datasource.password=root
```

### 3. Start the application

Using Maven:

```bash
./mvnw spring-boot:run
```

On Windows:

```bash
mvnw.cmd spring-boot:run
```

The application will start using the configured Spring Boot server.

## Testing the API

You can test the API using:

* Postman
* Insomnia
* curl
* any REST client

A typical workflow is:

```text
1. Create employee
       ↓
2. Retrieve employee
       ↓
3. Retrieve all employees
       ↓
4. Filter employees by salary
       ↓
5. Update employee
       ↓
6. Delete employee
```

## Important Concepts Used

This project demonstrates:

* Java
* Spring Boot
* REST APIs
* HTTP methods
* Dependency Injection
* Controller-Service-Repository architecture
* DTOs
* JPA
* Hibernate
* Spring Data JPA
* CRUD operations
* Derived queries
* MySQL
* Entity mapping
* Transactions
* Caching

## Future Improvements

Possible improvements include:

* Request validation using Bean Validation
* Global exception handling using `@ControllerAdvice`
* Better HTTP error responses
* Pagination and sorting
* More comprehensive unit and integration tests
* Authentication and authorization
* OpenAPI/Swagger documentation
* Environment-based database configuration
* PostgreSQL support
* Docker deployment

## Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── com/example/demo/
│   │       ├── controller/
│   │       │   └── EmployeeController.java
│   │       ├── dto/
│   │       │   └── EmployeeDTO.java
│   │       ├── entity/
│   │       │   └── Employee.java
│   │       ├── jdbcCrud/
│   │       │   └── EmployeeRepo.java
│   │       ├── service/
│   │       │   ├── EmployeeService.java
│   │       │   └── EmployeeServiceImpl.java
│   │       └── EmployeeManagementSystemApplication.java
│   │
│   └── resources/
│       ├── application.properties
│       └── application.yml
│
└── test/
    └── java/
        └── com/example/demo/
            └── EmployeeManagementSystemApplicationTests.java
```

## Learning Goal

The main purpose of this project is to understand how a Java Spring Boot backend is structured and how a REST request travels through the application:

```text
HTTP Request
     ↓
Controller
     ↓
Service
     ↓
Repository
     ↓
JPA / Hibernate
     ↓
MySQL
     ↓
HTTP Response
```

Understanding this flow is more important than memorizing individual annotations.
