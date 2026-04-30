CREATE DATABASE bank_db;
USE bank_db;

CREATE TABLE accounts(
    account_id INT PRIMARY KEY  AUTO_INCREMENT,
    name VARCHAR(100),
email VARCHAR(100),
    balance DOUBLE ,
    password VARCHAR(255)
);

CREATE TABLE transactions(
transaction_id INT PRIMARY KEY  AUTO_INCREMENT,
account_id INT,
type VARCHAR(30),
amount DOUBLE ,
FOREIGN KEY (account_id) REFERENCES accounts(account_id)

)