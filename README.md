# Real Estate Agent Finder and Appointment System

A Java Spring Boot REST API for a real estate platform that connects **buyers, sellers and agents**. It was built as a group project for the Object-Oriented Programming module (BSc (Hons) in IT, SLIIT, Year 1 Semester 2).

**My part (Ishki M A): the user module**, covering registration for the three user roles, login, and user management.

## Features

| Area | What it covers |
|---|---|
| Users (my part) | Buyer, seller and agent registration, login, view all users, view a user by ID, delete a user |
| Properties | Property listings and their status |
| Appointments | Booking appointments between buyers and agents, with appointment status |
| Reviews | Reviews and ratings |
| Notifications | Notifications for users |
| Admin | Admin operations |

The properties, appointments, reviews, notifications and admin modules were built by other members of the group.

## My contribution: user module

Endpoints in `UserController`, with the logic in `UserService`:

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/users/register/buyer` | Register a buyer |
| POST | `/users/register/seller` | Register a seller |
| POST | `/users/register/agent` | Register an agent |
| POST | `/users/login` | Log in with email and password |
| GET | `/users` | List all users |
| GET | `/users/{id}` | Get one user by ID |
| POST | `/users` | Create a user |
| DELETE | `/users/{id}` | Delete a user |

Registration assigns the role (`BUYER`, `SELLER` or `AGENT`) and sets the join date automatically. Users are stored in a MySQL table through Spring Data JPA.

## Tech stack

Java 17, Spring Boot, Spring Web MVC, Spring Data JPA, Bean Validation, MySQL, Lombok, Maven.

## Project structure

```
src/main/java/com/example/project/
├── controller/   REST controllers (users, properties, appointments, reviews, notifications, admin)
├── service/      business logic
├── repository/   Spring Data JPA repositories
├── entity/       JPA entities (User, Property, Appointment, Review, Notification)
├── dto/          request and response objects
└── enums/        Role, PropertyStatus, AppointmentStatus
```

## How to run

1. Install Java 17 and MySQL.
2. Create a database named `mydata`.
3. Check the database username and password in `src/main/resources/application.properties` and change them to match your MySQL setup.
4. Run `./mvnw spring-boot:run` (or `mvnw.cmd spring-boot:run` on Windows).
5. The API starts at `http://localhost:8080`. Tables are created automatically.

Example registration request:

```
POST http://localhost:8080/users/register/buyer
{ "name": "Test Buyer", "email": "buyer@example.com", "password": "test123", "contactNumber": "0710000000" }
```

## Known limitations

This is a learning project, so some parts are deliberately simple:

- Passwords are stored and compared as **plain text**. A real system would hash them (for example with BCrypt through Spring Security).
- Login returns a message only. There is no session or token (JWT), so the other endpoints are not protected.
- The API has no authentication or role-based access control yet.

## Possible improvements

- Hash passwords and add Spring Security with JWT.
- Validate registration input (email format, password strength, duplicate emails).
- Return proper HTTP status codes and error messages.
- Add unit tests for the service layer.
