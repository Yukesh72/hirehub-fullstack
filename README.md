🚀 HireHub – Job Portal Web Application
📌 Project Overview

HireHub is a Full Stack Job Portal web application that allows users to register, login, and apply for jobs.
Admins can manage job postings and monitor users.

This project demonstrates authentication, role-based access, and REST API integration using modern web technologies.

🛠️ Tech Stack
🔹 Frontend

HTML

CSS

JavaScript

Fetch API

🔹 Backend

Java

Spring Boot

Spring Security

JWT Authentication

🔹 Database

MySQL

🔐 Features
👤 User

Register

Login with JWT authentication

View profile

Browse jobs

Apply for jobs

🛠️ Admin

Admin login

Add new jobs

Update jobs

Delete jobs

View registered users

🔑 Authentication Flow

User logs in.

Backend generates JWT token.

Token is stored in frontend (localStorage).

Token is sent in Authorization header for protected APIs.

Backend validates token before allowing access.

📂 Project Structure
HireHub
│
├── frontend/
│   ├── login.html
│   ├── register.html
│   ├── mainuserpage.html
│   └── js/
│
├── backend/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── model/
│   └── security/
▶️ How to Run the Project
Backend

Open project in IDE (IntelliJ / Eclipse)

Configure MySQL in application.properties

Run Spring Boot application

Server runs at:
http://localhost:8080

Frontend

Open HTML files using Live Server

Connects to backend APIs

🎯 Learning Outcomes

REST API development

JWT authentication implementation

Role-based access control

Frontend & Backend integration

CORS configuration

📌 Future Improvements

Token refresh mechanism

Pagination for job listings

Search & filter jobs

Deploy to cloud (AWS / Render)

👨‍💻 Developed By

Mukesh
Full Stack Developer (Java + Spring Boot)
