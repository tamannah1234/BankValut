# BankVault – Secure Bank Account Management & Transaction System

**BankVault** is a secure banking platform built with **Java 17, Spring Boot, Spring Security, Lombok, and MySQL**. It allows users to manage accounts and perform transactions safely with REST APIs and robust OOP design.

---

## 🚀 Features

- **User & Account Management** – Registration, login, roles, and unique accounts.
- **Transactions** – Deposit, withdraw, transfer with data integrity and audit logs.
- **Security & Validation** – Spring Security authentication and exception handling.

---

## 🛠 Tech Stack

- **Backend**: Spring Boot, Spring Security, Lombok
- **Database**: MySQL (JPA/Hibernate)
- **Build Tool**: Maven
- **Concepts**: OOP, Service/Repository Pattern, Exception Handling

---

## ⚡ API Endpoints

| Endpoint                     | Method | Description                        |
|-------------------------------|--------|------------------------------------|
| `/api/users/register`         | POST   | Register user                       |
| `/api/users/login`            | POST   | User login                          |
| `/api/accounts/create`        | POST   | Create bank account                 |
| `/api/transactions/deposit`   | POST   | Deposit money                       |
| `/api/transactions/withdraw`  | POST   | Withdraw money                      |
| `/api/transactions/transfer`  | POST   | Transfer between accounts           |

---

## 📝 Setup

1. Clone repo:

```bash
git clone https://github.com/your-github-repo.git
cd BankVault
Configure MySQL in application.properties (local/untracked):

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/bankvault
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
Build & Run:

bash
Copy code
mvn clean install
mvn spring-boot:run
Test APIs using Postman.

👤 Author
Tamanna Singh – Java, Spring Boot, REST API, MySQL, Lombok, OOP