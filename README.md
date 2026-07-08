# Automation Exercise Selenium BDD Automation Framework

A robust UI automation framework developed using **Java**, **Selenium WebDriver**, **Cucumber (BDD)**, **TestNG**, and **Maven** for automating the Automation Exercise e-commerce website.

The framework follows the **Page Object Model (POM)** design pattern and is designed with a modular architecture to ensure code reusability, maintainability, and scalability. It includes reusable utility classes, centralized configuration management, explicit waits, logging, automatic screenshot capture, and multiple reporting mechanisms.

---

# Application Under Test

**Website**

https://automationexercise.com/

Automation Exercise is a demo e-commerce application designed for QA Engineers to practice end-to-end UI automation. The application includes modules such as user registration, login, product search, brands, categories, shopping cart, checkout, and contact us.

---

# Technologies Used

| Category | Technology |
|----------|------------|
| Programming Language | Java 17 |
| Automation Tool | Selenium WebDriver |
| BDD Framework | Cucumber |
| Test Framework | TestNG |
| Build Tool | Maven |
| Design Pattern | Page Object Model (POM) |
| Logging | Log4j2 |
| Reporting | Extent Report, Cucumber HTML Report, Allure Report |
| Version Control | Git & GitHub |

---

# Framework Features

- Selenium WebDriver Automation
- Page Object Model (POM)
- Behavior Driven Development (BDD)
- TestNG Integration
- Maven Build Management
- Configurable Framework using Properties File
- Explicit Wait Utility
- Driver Utility
- Reusable Page Classes
- Modular Framework Architecture
- Automatic Screenshot Capture for Every Test Scenario (Pass & Fail)
- Extent Report Generation
- Cucumber HTML Report Generation
- Allure Report Generation
- Log4j2 Logging
- Easy Maintenance and Scalability

---

# Project Structure

```text
Capstone-project
│
├── pom.xml
├── README.md
│
├── src
│
├── main
│   └── java
│       └── utilities
│           ├── ConfigReader.java
│           ├── DriverUtil.java
│           └── ExplicitWaitUtil.java
│
├── test
│   ├── java
│   │
│   ├── base
│   │   └── BaseClass.java
│   │
│   ├── Features
│   │   ├── A_SignUPfeature.feature
│   │   ├── B_LoginPage.feature
│   │   ├── HomePage.feature
│   │   ├── Products.feature
│   │   ├── Brandsfeature.feature
│   │   ├── Category.feature
│   │   ├── Checkout.feature
│   │   └── Contact.feature
│   │
│   ├── Hooks
│   │   └── Hooks.java
│   │
│   ├── pages
│   │   ├── HomePage.java
│   │   ├── LoginPage.java
│   │   ├── SignUPPage.java
│   │   ├── ProductsPage.java
│   │   ├── BrandsPage.java
│   │   ├── CategoryPage.java
│   │   ├── ContactusPage.java
│   │   └── CheckOutPage.java
│   │
│   ├── StepDefinitions
│   │   ├── A_SignUpSteps.java
│   │   ├── B_LoginSteps.java
│   │   ├── HomePageSteps.java
│   │   ├── ProductSteps.java
│   │   ├── BrandStep.java
│   │   ├── CategorySteps.java
│   │   ├── ContactUsSteps.java
│   │   └── CheckoutSteps.java
│   │
│   └── runner
│       └── runner.java
│
└── resources
    ├── config.properties
    └── log4j2.xml

logs/
target/
test-output/
```

---

# Automated Test Modules

## Home Module

- Verify Home Page
- Verify Website Logo
- Verify Navigation Menu
- Verify Home Page Slider
- Verify Featured Products
- Verify Subscription Functionality
- Verify Scroll Up and Scroll Down
- Verify Brands Section
- Verify Categories Section

---

## User Registration Module

- Register New User
- Validate Mandatory Fields
- Validate Existing Email
- Complete Account Registration
- Verify Account Creation

---

## Login Module

- Login with Valid Credentials
- Login with Invalid Credentials
- Verify Login Error Message
- Verify Logged-in User
- Logout Successfully

---

## Products Module

- View All Products
- Search Products
- View Product Details
- Add Products to Cart
- Update Product Quantity
- Navigate to Cart

---

## Brands Module

- Verify Brands Section
- Verify Available Brands
- Navigate Between Brands
- Verify Brand Products
- View Product Details
- Add Brand Products to Cart

---

## Categories Module

- Verify Women Category
- Verify Men Category
- Verify Kids Category
- Verify Dress Category
- Verify Tops Category
- Verify Saree Category
- Navigate Between Categories
- Handle Google Vignette Advertisement Automatically

---

## Contact Us Module

- Submit Contact Form
- Upload File
- Validate Success Message

---

## Checkout Module

- Proceed to Checkout
- Place Order
- Enter Payment Details
- Confirm Order
- Download Invoice
- Continue Shopping

---

# Utility Classes

The framework includes reusable utility classes for common automation tasks.

- ConfigReader
- DriverUtil
- ExplicitWaitUtil

---

# Configuration

Framework execution settings are managed through:

```text
src/test/resources/config.properties
```

Example:

```properties
browser=chrome
url=https://automationexercise.com
```

---

# Running the Framework

## Execute All Tests

```bash
mvn clean test
```

---

## Execute Using TestNG

Run the TestNG Runner class.

---

## Execute a Specific Feature

```bash
mvn test -Dcucumber.features=src/test/java/Features/B_LoginPage.feature
```

---

# Reports

After execution, the framework automatically generates the following reports:

- Extent Report
- Cucumber HTML Report
- Allure Report

Each report contains:

- Test Execution Summary
- Pass and Fail Statistics
- Step-wise Execution Details
- Execution Time
- Screenshots for Every Executed Scenario (Pass & Fail)
- Failure Logs

---

# Screenshots

The framework automatically captures screenshots for every executed scenario.

- Passed Scenarios
- Failed Scenarios

Screenshots are attached to the generated reports, making it easier to analyze failures and verify successful executions.

---

# Framework Design

The framework follows a layered architecture consisting of:

- Base Class
- Hooks
- Page Object Model (POM)
- Step Definitions
- Feature Files
- Driver Utility
- Explicit Wait Utility
- Configuration Management
- Logging
- Reporting

---

# Major Maven Dependencies

- Selenium WebDriver
- Cucumber Java
- Cucumber TestNG
- TestNG
- Log4j2
- Extent Reports
- Allure Reports

---

# Future Enhancements

- Cross Browser Execution
- Parallel Test Execution
- Selenium Grid Integration
- Jenkins CI/CD Integration
- Docker Support
- GitHub Actions
- API Automation
- Database Validation
