#  Bank Management System (JDBC + Java)

A console-based banking system built using Java, JDBC, and MySQL.

---

##  Features
- Create bank account
- Login authentication (hashed password)
- Deposit money
- Withdraw money
- Transfer money
- View account details
- Transaction history

---

##  Tech Stack
- Java
- JDBC
- MySQL
- IntelliJ IDEA

---

##  Architecture
- DAO Pattern
- Service Layer
- Utility Classes
- Model Layer (Record classes)

---

## Database Setup
Run `database.sql` in MySQL.

---

## Configuration
Update `config.properties`:

url=jdbc:mysql://localhost:your_Portno/your_db_name  
user=root  
password=your_password

---

##  How to Run
1. Clone repository
2. Open in IntelliJ IDEA
3. Add MySQL JDBC driver
4. Run `Main.java`

---

## Security
- Passwords are hashed using SHA-256
- Sensitive config excluded via `.gitignore`

---

## Author
Your Name