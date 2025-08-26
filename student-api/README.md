# Student API (Spring Boot)

Java 17 + Spring Boot 3.5 (Maven) REST API with CRUD for Students, using Spring Data JPA and H2 in-memory DB.

## Requirements
- Java 17+
- Maven 3.9+

## Run
```bash
mvn spring-boot:run
```
App starts at http://localhost:8080

H2 console: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:studentdb`
- User: `sa`
- Password: (empty)

## Endpoints
- GET `/students`
- GET `/students/{id}`
- POST `/students`
- PUT `/students/{id}`
- DELETE `/students/{id}`

## Sample JSON

POST `/students`
```json
{
  "name": "Alice Johnson",
  "email": "alice.johnson@example.com",
  "course": "Physics",
  "age": 23
}
```

Response 201 Created
```json
{
  "id": 1,
  "name": "Alice Johnson",
  "email": "alice.johnson@example.com",
  "course": "Physics",
  "age": 23
}
```

GET `/students`
```json
[
  {
    "id": 1,
    "name": "Alice Johnson",
    "email": "alice.johnson@example.com",
    "course": "Physics",
    "age": 23
  }
]
```

GET `/students/1`
```json
{
  "id": 1,
  "name": "Alice Johnson",
  "email": "alice.johnson@example.com",
  "course": "Physics",
  "age": 23
}
```

PUT `/students/1`
```json
{
  "name": "Alice J.",
  "email": "alice.johnson@example.com",
  "course": "Astrophysics",
  "age": 24
}
```

DELETE `/students/1` -> 204 No Content

## cURL examples
```bash
curl -X POST http://localhost:8080/students \
  -H 'Content-Type: application/json' \
  -d '{"name":"John Doe","email":"john.doe@example.com","course":"CS","age":22}'

curl http://localhost:8080/students

curl http://localhost:8080/students/1

curl -X PUT http://localhost:8080/students/1 \
  -H 'Content-Type: application/json' \
  -d '{"name":"John D.","email":"john.doe@example.com","course":"CS","age":23}'

curl -X DELETE http://localhost:8080/students/1
```