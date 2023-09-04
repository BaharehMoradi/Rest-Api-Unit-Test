# Rest-Api-Unit-Test
This project is a Java Spring REST API for performing unit tests. It includes controllers, DTOs (Data Transfer Objects), entities, exceptions, repositories, services, and configuration files.

## Technologies Used

- Java 19
- Spring Boot 3.1.3
- Spring Boot Data JPA
- Spring Boot Web
- Spring Boot Validation
- Spring Boot Test
- Lombok 1.18.28
- ModelMapper 3.1.1
- Oracle JDBC Driver (ojdbc8)

## Getting Started

To run the project locally, follow these steps:

1. Make sure you have Java 19 installed.
2. Clone this repository to your local machine.
3. Open the project in your favorite Java IDE.
4. Build the project using Maven.
5. Run the `RestApiUnitTestApplication` class to start the application.
6. The API will be accessible at `http://localhost:8080/api/users`.

## API Endpoints

### Add User

- URL: `POST /api/users`
- Request Body:
```json
{
  "email": "user@example.com",
  "firstName": "John",
  "lastName": "Doe",
  "passWord": "password"
}
```
- Response:
```json
{
  "id": 1,
  "email": "user@example.com",
  "firstName": "John",
  "lastName": "Doe"
}
```

### Get User

- URL: `GET /api/users/{id}`
- Path Variable: `id` (User ID)
- Response:
```json
{
  "id": 1,
  "email": "user@example.com",
  "firstName": "John",
  "lastName": "Doe"
}
```

### List Users

- URL: `GET /api/users`
- Response:
```json
[
  {
    "id": 1,
    "email": "user@example.com",
    "firstName": "John",
    "lastName": "Doe"
  },
  {
    "id": 2,
    "email": "anotheruser@example.com",
    "firstName": "Jane",
    "lastName": "Smith"
  }
]
```

### Update User

- URL: `PUT /api/users/{id}`
- Path Variable: `id` (User ID)
- Request Body:
```json
{
  "email": "updated@example.com",
  "firstName": "Updated",
  "lastName": "User",
  "passWord": "newpassword"
}
```
- Response:
```json
{
  "id": 1,
  "email": "updated@example.com",
  "firstName": "Updated",
  "lastName": "User"
}
```

### Delete User

- URL: `DELETE /api/users/{id}`
- Path Variable: `id` (User ID)
- Response: No content (204)



