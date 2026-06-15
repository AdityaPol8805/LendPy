# 💰 LendPy - Loan Management System

## 📖 Overview

The Loan Management System is a web-based application developed using Java Full Stack technologies. It enables users to apply for loans, calculate EMI, track application status, and manage loan records efficiently. Administrators can review applications, approve or reject loans, and monitor loan activities through a centralized dashboard.

---

## ✨ Features

### 👤 User Module

* 📝 User Registration and Login
* 🔒 Secure Session Management
* 💳 Apply for Different Types of Loans
* 🧮 EMI Calculation
* 📊 View Loan Application Status
* 📜 Track Loan History
* ⚙️ Profile Management

### 🛠️ Admin Module

* 🔑 Admin Login
* 📋 View All Loan Applications
* ✅ Approve Loan Requests
* ❌ Reject Loan Requests
* 🔄 Update Loan Status
* 👥 Manage User Records
* 📈 Dashboard for Loan Monitoring

---

## 🚀 Technologies Used

### 🎨 Frontend

* HTML
* CSS
* JavaScript
* JSP

### ⚙️ Backend

* Java
* Servlets
* JDBC

### 🗄️ Database

* MySQL

### 🌐 Server

* Apache Tomcat 10

### 🧰 Development Tools

* Eclipse IDE
* MySQL Workbench
* Git
* GitHub

---

## 📂 Project Structure

```text
LoanManagementSystem/

├── src/
│   ├── controller/
│   ├── dao/
│   ├── model/
│   └── util/

├── WebContent/
│   ├── css/
│   ├── js/
│   ├── images/
│   ├── login.jsp
│   ├── register.jsp
│   ├── dashboard.jsp
│   └── admin/

├── database/
│   └── loan_management.sql

└── README.md
```

---

## 🗃️ Database Configuration

### 1️⃣ Create Database

```sql
CREATE DATABASE loan_management;
```

### 2️⃣ Import SQL File

Import the provided `loan_management.sql` file into MySQL.

### 3️⃣ Configure Database Credentials

```java
String url = "jdbc:mysql://localhost:3306/loan_management";
String username = "root";
String password = "your_password";
```

---

## 📸 Screenshots

* 🔐 Login Page
* 📝 Registration Page
* 🏠 User Dashboard
* 💳 Loan Application Form
* 📊 Loan Status Page
* 🛠️ Admin Dashboard

---

## 🎯 Future Enhancements

* 📧 Email Notifications
* 📄 Document Upload & Verification
* 🤖 Loan Eligibility Prediction using Machine Learning
* 💸 Payment Gateway Integration
* 📑 PDF Report Generation
* 🔗 REST API Integration
---
## 💰 Project Summary

The Loan Management System is a web-based application developed using Java Full Stack technologies that simplifies the loan application and approval process. The system allows users to register, log in securely, apply for various loan types, calculate EMI, and track the status of their loan applications in real time.

Administrators can manage loan requests through a dedicated dashboard, where they can review applications, approve or reject loans, and update loan statuses. The application uses Java Servlets and JDBC for backend processing, JSP for dynamic web pages, and MySQL for secure data storage.

The project aims to automate traditional loan management processes, improve efficiency, reduce manual paperwork, and provide a user-friendly platform for both customers and administrators.

