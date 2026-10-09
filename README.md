# MyTaskManager

MyTaskManager is a simple Spring Boot API for managing tasks, days, and users. The application supports JWT authentication and provides Swagger documentation for its endpoints. 

## Features
- Create and retrieve users
- Log in using JWT
- Create, retrieve, update, and delete tasks
- Create days and associate tasks with specific days
- API documentation with Swagger UI
- H2 in-memory database for local development


## Stack

- Java 21
- Spring Boot 4
- Spring Security
- Spring Data JPA
- H2 Database
- JWT (jsonwebtoken)
- OpenAPI / Swagger

## Requirements

- Java 21
- Maven
- A local terminal or IDE such as Intellij IDEA or VS Code

## App starten

1. Open a terminal in the project directory.
2. Run the following commands:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

The application runs by default at:

- http://localhost:8081

## Main Endpoints

### Authentication

- POST /auth/login
  - Login using an email address and password
  - Returns a JWT token

### Users

- POST /users
  - Create a new user
- GET /users
  - Retrieve all users

### Tasks

- POST /tasks
  - Create a task
- GET /tasks
  - Retrieves all tasks
- PUT /tasks/{id}
  - Update a task
- DELETE /tasks/{id}
  - Delete a task
- DELETE /tasks
  - Delete all tasks

### Days

- POST /days
  - Create a new day
- POST /days/{day-id}/tasks/{task-id}
  - Associate a task with a day
- DELETE /days/{day-id}/tasks/{task-id}
  - Remove a task from a day

## Documentation

Swagger UI is available at:

- http://localhost:8081/swagger-ui/index.html

## H2 database

The application uses an in-memory H2 database. The database console is available at:

- http://localhost:8081/taskmanagerdb

## Note

This application is a backend API. Data is stored in memory and is reset whenever the application restarts. 
