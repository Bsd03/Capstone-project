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
| Programming Language | Java |
| Automation Tool | Selenium |
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

The framework contains reusable utility classes that simplify common automation tasks and improve code maintainability.

| Utility Class | Description |
|---------------|-------------|
| **ConfigReader** | Reads configuration values such as browser name, application URL, and other execution settings from the `config.properties` file. |
| **DriverUtil** | Initializes and manages the Selenium WebDriver instance for different browsers. It is responsible for browser setup and driver lifecycle management. |
| **ExplicitWaitUtil** | Provides reusable explicit wait methods to synchronize test execution by waiting for elements to become visible, clickable, or present before performing actions. |
| **AllureScreenshotUtil** | Captures screenshot during test execution and attatches them to Allure Report for better report and failure  scenarios. |

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

Verify the installations by running the following commands:

```bash
java -version
```

```bash
mvn -version
```

```bash
git --version
```

---

# Project Setup Guide

Follow the steps below to set up and execute the project on your local machine.

## Step 1: Clone the Repository

Open Command Prompt or Git Bash and run:

```bash
git clone https://github.com/<your-github-username>/Capstone-project.git
```

Or click **Code → Download ZIP** from GitHub and extract the project.

---

## Step 2: Open the Project

### Eclipse

1. Open Eclipse.
2. Go to **File → Import**.
3. Select **Existing Maven Projects**.
4. Click **Next**.
5. Browse to the downloaded project folder.
6. Click **Finish**.

### IntelliJ IDEA

1. Open IntelliJ IDEA.
2. Click **Open**.
3. Select the project folder.
4. Wait for Maven dependencies to download.

---

## Step 3: Update Maven Dependencies

If Maven dependencies are not downloaded automatically:

### Eclipse

Right-click the project

```
Maven
    └── Update Project
```

Select **Force Update of Snapshots/Releases**

Click **Finish**.

### IntelliJ IDEA

Right-click **pom.xml**

```
Maven
    └── Reload Project
```

---

## Step 4: Configure the Framework

Open:

```text
src/test/resources/config.properties
```

Update the required values.

Example:

```properties
browser=chrome
url=https://automationexercise.com
```

---

## Step 5: Verify Browser

Ensure that:

- Google Chrome or edge should be installed.
- Chrome version or edge are compatible with Selenium/WebDriver.
- Internet connection is available.

---

## Step 6: Build the Project

Open Terminal in the project directory and run:

```bash
mvn clean install
```

This command:

- Downloads all project dependencies
- Compiles the project
- Builds the framework

---

## Step 7: Execute the Test Suite

Run all test cases:

```bash
mvn clean test
```

or

Run the Test Runner class from Eclipse or IntelliJ.

---

## Step 8: Execute Individual Feature Files

To execute a specific feature:

```bash
mvn test -Dcucumber.features=src/test/java/Features/B_LoginPage.feature
```

Replace the feature name with the required feature file.

Example:

```bash
mvn test -Dcucumber.features=src/test/java/Features/Products.feature
```

---

## Step 9: View Reports

After execution, reports are generated automatically.

### Extent Report

```text
test-output/ExtentReport.html
```

### Cucumber Report

```text
target/cucumber-reports.html
```

### Allure Report

Generate the Allure report:

```bash
allure serve allure-results
```

or

```bash
allure generate allure-results --clean
```

---

## Step 10: Screenshots

Screenshots are captured automatically for every executed scenario.

They are embedded in:

- Extent Report
- Cucumber Report
- Allure Report

This helps in debugging and validating test execution.

---

# Project Workflow

```
Clone Repository
        │
        ▼
Import Maven Project
        │
        ▼
Download Maven Dependencies
        │
        ▼
Update config.properties
        │
        ▼
Execute Test Runner / mvn clean test
        │
        ▼
Generate Reports
        │
        ▼
View Extent / Cucumber / Allure Reports
```

---

# Troubleshooting

### Maven Dependencies Not Downloaded

```bash
mvn clean install
```

or

```
Right Click Project
        ↓
Maven
        ↓
Update Project
```

---

### Browser Not Opening

- Verify Java installation.
- Verify Chrome or edge is installed.
- Verify Selenium dependencies are downloaded.
- Run Maven Update.

---

### Build Failure

Execute:

```bash
mvn clean install
```

Then execute:

```bash
mvn clean test
```

---

### Allure Report Not Opening

Ensure Allure is installed.

Verify installation:

```bash
allure --version
```

If not installed, download it from the official Allure website and add it to your system PATH.

Then run:

```bash
allure serve allure-results
```
---

# Major Maven Dependencies

- Selenium WebDriver
- Cucumber Java
- Cucumber TestNG
- TestNG
- Log4j2
- Extent Reports
- Cucumber Reports
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
