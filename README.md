# 🛒 Automation Exercise - Selenium BDD Automation Framework

A robust test automation framework developed using **Java**, **Selenium WebDriver**, **Cucumber (BDD)**, **TestNG**, and **Page Object Model (POM)** to automate the **Automation Exercise** e-commerce website.

This project demonstrates industry-standard Selenium automation practices including reusable page objects, BDD implementation, reporting, logging, screenshots, configuration management, and utility classes.

---

## 🌐 Application Under Test

**Website:** https://automationexercise.com/

Automation Exercise is a free e-commerce practice website designed for QA Engineers to learn and practice UI automation, API automation, and end-to-end testing. It provides realistic shopping, authentication, product search, cart, and checkout workflows. :contentReference[oaicite:2]{index=2}

---

# 🚀 Technologies Used

- Java
- Selenium WebDriver
- Cucumber (BDD)
- TestNG
- Maven
- Page Object Model (POM)
- Apache POI
- Log4j2
- Extent Reports
- Git & GitHub

---

# 📁 Project Structure

```
CapstoneProject
│
├── pom.xml
├── testng.xml
├── README.md
│
├── src
│   ├── test
│   │
│   ├── java
│   │   ├── base
│   │   ├── hooks
│   │   ├── pages
│   │   ├── runners
│   │   ├── stepdefinitions
│   │   └── utilities
│   │
│   └── resources
│       ├── Features
│       ├── config.properties
│       ├── log4j2.xml
│       └── testdata
│
├── Reports
├── Screenshots
└── Logs
```

---

# ✨ Framework Features

- Selenium WebDriver Automation
- BDD using Cucumber
- Page Object Model (POM)
- TestNG Integration
- Cross Browser Execution
- Configuration using Properties File
- Excel Data Handling using Apache POI
- Explicit Wait Utilities
- Screenshot Capture on Failure
- Log4j2 Logging
- Extent Report Generation
- Reusable Utility Classes
- Easy Maintenance & Scalability

---

# ✅ Automated Modules

### 🏠 Home

- Verify Home Page
- Verify Navigation Menu

### 👤 User Registration

- Register New User
- Validate Mandatory Fields
- Invalid Registration Validation

### 🔐 Login

- Login with Valid Credentials
- Login with Invalid Credentials
- Verify Error Messages
- Logout Validation

### 🛍 Products

- View All Products
- Search Products
- Verify Product Details

### 🏷 Brands

- Verify Brands Section
- Filter Products by Brand

### 📂 Categories

- Verify Category Navigation
- Verify Category Products

### 📞 Contact Us

- Submit Contact Form
- Validate Success Message

### 🛒 Cart & Checkout

- Add Products to Cart
- Verify Cart Details
- Checkout Workflow
- Order Confirmation Validation

---

# ⚙ Configuration

Update execution settings inside:

```
src/test/resources/config.properties
```

Example:

```properties
browser=chrome
url=https://automationexercise.com
implicitWait=10
```

---

# ▶ Running the Project

### Run All Tests

```bash
mvn clean test
```

### Run Using TestNG

```bash
testng.xml
```

### Run a Specific Feature

```bash
mvn test -Dcucumber.features=src/test/resources/Features/Login.feature
```

---

# 📊 Reports

After execution, Extent Reports are generated under:

```
Reports/
```

or

```
test-output/
```

(depending on project configuration)

---

# 📸 Screenshots

Failed test screenshots are automatically saved under:

```
Screenshots/
```

---

# 🧩 Framework Design

- Page Object Model (POM)
- Cucumber BDD
- TestNG Runner
- Maven Build Management
- Utility-Based Architecture
- Config Reader
- Driver Factory
- Screenshot Utility
- Wait Utility
- Excel Utility
- Logger Utility

---

# 📦 Maven Dependencies

- Selenium Java
- Cucumber Java
- Cucumber TestNG
- TestNG
- Apache POI
- WebDriverManager
- Log4j2
- Extent Reports

---

# 🎯 Project Highlights

✔ Selenium WebDriver Automation

✔ Java-Based Framework

✔ Cucumber BDD Implementation

✔ Page Object Model Design

✔ Cross Browser Support

✔ Data-Driven Testing

✔ Logging & Reporting

✔ Screenshot Capture

✔ Reusable Utilities

✔ Easy to Maintain

✔ GitHub Version Controlled

---

# 👩‍💻 Author

**Sayani Maity**

SDET | Selenium Automation Engineer

Java • Selenium • Cucumber • TestNG • Maven • POM • Apache POI • Extent Reports
