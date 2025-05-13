# Business Expense Travel Tracker API

This is a Spring Boot REST API designed to manage expenses along with travel logs,
employees, expense categories and reimbursements.

## Table of contents
- [Technologies used](#technologies-used)
- [API Endpoints](#api-endpoints)
- [Setup](#setup)

## Technologies used
* Java
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Lombok
* Maven


## API Endpoints

| Method | Endpoint                 | Description                  |
|--------|--------------------------|------------------------------|
| GET    | `/employee`              | Get all employees            |
| GET    | `/employee/{id}`         | Get a specific employee      |
| GET    | `/expense-category`      | Get all expense categories   |
| GET    | `/expense-category/{id}` | Get a expense category       |
| GET    | `/expense`               | Get all expenses             |
| GET    | `/expense/{id}`          | Get an expense               |
| GET    | `/expense/total-amount`  | Get total amount of expenses |
| GET    | `/reimbursement`         | Get all reimbursements       |
| GET    | `/reimbursement/{id}`    | Get a reimbursement          |
| GET    | `/travel-log`            | Get all travel logs          |
| GET    | `/travel-log/{id}`       | Get a travel log             |
| POST   | `/employee`              | Save a new employee          |
| POST   | `/expense-category`      | Save a new expense category  |
| POST   | `/expense`               | Save an expense              |
| POST   | `/reimbursement`         | Save a new reimbursement     |
| POST   | `/travel-log`            | Save a new travel log        |
| PUT    | `/employee`              | Update an employee           |
| PUT    | `/expense-category`      | Update an expense category   |
| PUT    | `/expense`               | Update an expense            |
| PUT    | `/reimbursement`         | Update a reimbursement       |
| PUT    | `/travel-log`            | Update a travel log          |
| DELETE | `/employee`              | Delete an employee           |
| DELETE | `/expense-category`      | Delete an expense category   |
| DELETE | `/expense`               | Delete an expense            |
| DELETE | `/reimbursement`         | Delete a reimbursement       |
| DELETE | `/travel-log`            | Delete a travel log          |

## Setup

Prerequisites:
- Java 17+
- PostgreSQL

Clone the repository:
```
git clone https://github.com/mateoo04/trip-tracker-api
cd trip-tracker-api
```

Create a PostgreSQL database and application.properties file with the following variables in 
src/main/resources/ directory:

```
spring.application.name=value
spring.datasource.url=value
spring.datasource.username=value
spring.datasource.password=value
spring.jpa.hibernate.ddl-auto=update
```

Run the API.