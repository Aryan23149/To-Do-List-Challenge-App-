# ChallengeApp

A Spring Boot REST API application for managing coding challenges. The application uses PostgreSQL as the database and follows a layered architecture using Spring Boot, Spring Data JPA, and Hibernate.

## Features

* Create new challenges
* View all challenges
* Retrieve challenge by ID
* Update existing challenges
* Delete challenges
* PostgreSQL database integration
* RESTful API architecture
* Spring Data JPA persistence
* Hibernate ORM support

## Tech Stack

### Backend

* Java 21
* Spring Boot 3
* Spring Data JPA
* Hibernate
* Maven

### Database

* PostgreSQL

### Deployment

* AWS RDS (PostgreSQL)
* AWS Elastic Beanstalk
* AWS EC2
* AWS S3

## Project Structure

```text
src
 ├── main
 │   ├── java
 │   │   ├── controller
 │   │   ├── service
 │   │   ├── repository
 │   │   ├── model
 │   │   └── ChallengeAppApplication.java
 │   └── resources
 │       └── application.properties
 └── test
```

## Installation

### Clone Repository

```bash
git clone <repository-url>
cd ChallengeApp
```

### Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=your_password
```

### Run Application

Using Maven Wrapper:

```bash
./mvnw spring-boot:run
```

Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

## Build Executable JAR

```powershell
.\mvnw.cmd clean package
```

Generated JAR:

```text
target/ChallengeApp-0.0.1-SNAPSHOT.jar
```

Run:

```bash
java -jar target/ChallengeApp-0.0.1-SNAPSHOT.jar
```

## API Endpoints

| Method | Endpoint         | Description         |
| ------ | ---------------- | ------------------- |
| GET    | /challenges      | Get all challenges  |
| GET    | /challenges/{id} | Get challenge by ID |
| POST   | /challenges      | Create challenge    |
| PUT    | /challenges/{id} | Update challenge    |
| DELETE | /challenges/{id} | Delete challenge    |

## Database Configuration

Example PostgreSQL configuration:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

## Deployment

The application can be deployed using:

* AWS Elastic Beanstalk
* AWS EC2
* Docker
* Render
* Railway

## Future Improvements

* User Authentication with Spring Security
* JWT Authorization
* Pagination and Sorting
* Search Functionality
* API Documentation using Swagger/OpenAPI
* Unit and Integration Testing
* Docker Containerization

## Author

Aryan
