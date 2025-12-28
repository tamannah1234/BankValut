# BankVault – Secure Bank Account Management and Transaction System

**BankVault** is a secure web-based banking platform built with **Spring Boot, MySQL, and Lombok**, enabling users to manage accounts and perform transactions safely. REST APIs handle deposits, withdrawals, and transfers, while Spring Security ensures authentication.

---

## 🚀 Features

- **User Management**: Registration, login, and role-based authentication using **Spring Security**.
- **Account Management**: Create accounts with unique numbers and manage balances.
- **Transaction Operations**: Deposit, withdraw, and transfer funds safely with **transaction consistency**.
- **Transaction History**: All transactions are logged with type, amount, accounts, and timestamp.
- **Exception Handling & Data Integrity**: Invalid accounts and insufficient balance are properly handled.
- **API Testing**: Endpoints tested with **Postman** for accuracy.

---

## 🛠 Tech Stack

- **Backend**: Spring Boot, Spring Security, Lombok
- **Database**: MySQL (JPA/Hibernate)
- **Testing**: Postman
- **Build Tool**: Maven
- **Language**: Java 17+

---

## 🗂 Project Structure

com.bankingsystem

├── config # Spring Security & Application Configuration

├── controller # REST Controllers

├── dto # Data Transfer Objects

├── entity # Database Entities (User, Account, Transaction)

├── repository # JPA Repositories

├── service # Service Interfaces

│ └── impl # Service Implementations

├── security # Security Utilities

├── exception # Custom Exception Handling

└── util # Enums & Helpers (e.g., AccountStatus, TransactionType)

---

## ⚡ API Endpoints

| Endpoint                  | Method | Description                        |
|----------------------------|--------|------------------------------------|
| `/api/users/register`      | POST   | Register new user                  |
| `/api/users/login`         | POST   | User login                         |
| `/api/accounts/create`     | POST   | Create a new bank account          |
| `/api/transactions/deposit`| POST   | Deposit money into an account      |
| `/api/transactions/withdraw` | POST | Withdraw money from an account     |
| `/api/transactions/transfer` | POST | Transfer money between accounts   |

---

## 📝 Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-github-repo.git
   cd BankVault
Configure MySQL

Create a database named bankvault

Update application.properties with your credentials:

properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/bankvault
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
Build & Run

bash
Copy code
mvn clean install
mvn spring-boot:run
Test APIs

Use Postman to interact with endpoints

Add sample users and accounts as needed

🔄 Project Flow
User registers and logs in via Spring Security.

Authenticated user creates bank accounts.

User performs deposit, withdrawal, and transfer operations.

Transactions are logged with full details for auditing.

System ensures data integrity and handles exceptions.

👤 Author
Tamanna Singh
---







