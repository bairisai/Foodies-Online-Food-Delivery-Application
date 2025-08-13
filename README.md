# 🍽️ Foodies - Online Food Delivery Application

[![Made with React](https://img.shields.io/badge/Made%20with-React-blue)](https://react.dev/)
[![Spring Boot](https://img.shields.io/badge/Backend-Spring%20Boot-brightgreen)](https://spring.io/projects/spring-boot)
[![MongoDB](https://img.shields.io/badge/Database-MongoDB-green)](https://www.mongodb.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A **full-stack online food delivery platform** with **Admin Panel**, **User Web App**, and **Spring Boot REST APIs**. Includes **JWT authentication**, **Razorpay payments**, **Amazon S3 image storage**, and **MongoDB** database integration.

---

## 📑 Table of Contents
- [✨ Features](#-features)
- [🛠️ Tech Stack](#️-tech-stack)
- [📂 Project Structure](#-project-structure)
- [⚙️ Installation & Setup](#️-installation--setup)
- [🔐 Environment Variables](#-environment-variables)


---

## ✨ Features

### **1. Admin Panel** (`adminpanel`)
- 📊 **React** frontend + **Spring Boot** backend
- 🥗 Food Management:
  - Add, delete, and view food items
- 📦 Order Management:
  - View and update order status
- 💾 Data stored in **MongoDB**
- 🖼 Food images stored in **Amazon S3**

---

### **2. User-Facing Web App** (`foodies`)
- 🔐 **JWT Authentication**
- 🍔 Browse all available foods
- 🔍 Search foods by name
- 🏷 Filter foods by category
- 📝 Sign-in / Sign-up functionality
- 📞 Contact page
- 📜 Orders page to track placed orders
- 💳 **Razorpay payment integration** (Test mode)

---

### **3. Spring Boot REST APIs** (`foodiesapi`)
- 🔑 JWT-based authentication
- 🏛 MVC architecture
- 📡 APIs for:
  - Admin operations (foods, orders)
  - User operations (browse, order, payment)
- ☁️ Amazon S3 for image storage
- 🗄 MongoDB for data storage

---

## 🛠️ Tech Stack

**Frontend:** React, HTML5, CSS3, JavaScript  
**Backend:** Java, Spring Boot, Spring MVC  
**Database:** MongoDB  
**Storage:** Amazon S3  
**Payments:** Razorpay  
**Authentication:** JWT

---

## 📂 Project Structure

---

## ⚙️ Installation & Setup

1.  **Clone the repository**
    ```bash
    git clone <repository_url>
    cd foodies-online-food-delivery
    ```

2.  **Backend Setup** (`foodiesapi`)
    ```bash
    cd foodiesapi
    # Configure application.properties for MongoDB, S3, and Razorpay credentials
    mvn clean install
    mvn spring-boot:run
    ```

3.  **Admin Panel Setup** (`adminpanel`)
    ```bash
    cd adminpanel
    npm install
    npm start
    ```

4.  **User Web App Setup** (`foodies`)
    ```bash
    cd foodies
    npm install
    npm start
    ```

---

## 🔐 Environment Variables

### Backend (`application.properties`)
```properties
spring.data.mongodb.uri=<MONGODB_URI>
jwt.secret.key=<JWT_SECRET>
aws.access.key=<AWS_ACCESS_KEY>
aws.secret.key=<AWS_SECRET_KEY>
aws.region=<AWS_REGION>
aws.s3.bucket.name=<S3_BUCKET_NAME>
razorpay.key.id=<RAZORPAY_KEY_ID>
razorpay.key.secret=<RAZORPAY_KEY_SECRET>
```
---

