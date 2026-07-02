Feature: User Login
 
Background:
    Given the user launches the browser
    And the user navigates to "https://automationexercise.com"
    Then the Home page should be displayed successfully
    When the user clicks on the "Signup / Login" menu
    Then the "Login to your account" section should be displayed
 
Scenario: Verify Login page loads successfully
    Then the Email Address field should be displayed
    And the Password field should be displayed
    And the Login button should be enabled
 
Scenario Outline: Verify login with valid credentials
    When the user enters Email Address "<Email>"
    And the user enters Password "<Password>"
    And the user clicks the Login button
    Then the user should be logged in successfully
    And the "Logged in as <UserName>" message should be displayed
 
Examples:
| Email                    | Password | UserName |
| rohinipitta@gmail.com    | Test@123 | Rohini   |
 
Scenario Outline: Verify login with invalid credentials
    When the user enters Email Address "<Email>"
    And the user enters Password "<Password>"
    And the user clicks the Login button
    Then the error message "Your email or password is incorrect!" should be displayed
 
Examples:
| Email                  | Password |
| abc@gmail.com          | Test123  |
| rohinipitta@gmail.com  | Wrong123 |
| invalid@gmail.com      | Admin123 |
 
Scenario Outline: Verify login with invalid email format
    When the user enters Email Address "<Email>"
    And the user enters Password "<Password>"
    And the user clicks the Login button
    Then the appropriate email validation message should be displayed
 
Examples:
| Email      | Password |
| rohini     | Test@123 |
| abc.com    | Test@123 |
| @gmail.com | Test@123 |
| abc@       | Test@123 |
 
Scenario: Verify login with mandatory fields left empty
    When the user clicks the Login button without entering Email Address and Password
    Then the required field validation messages should be displayed
 
Scenario Outline: Verify login with empty Email Address
    When the user enters Email Address "<Email>"
    And the user enters Password "<Password>"
    And the user clicks the Login button
    Then the required email validation message should be displayed
 
Examples:
| Email | Password |
|       | Test@123 |
 
Scenario Outline: Verify login with empty Password
    When the user enters Email Address "<Email>"
    And the user enters Password "<Password>"
    And the user clicks the Login button
    Then the required password validation message should be displayed
 
Examples:
| Email                 | Password |
| rohinipitta@gmail.com |          |
 
Scenario Outline: Verify login with leading and trailing spaces
    When the user enters Email Address "<Email>"
    And the user enters Password "<Password>"
    And the user clicks the Login button
    Then the user should be logged in successfully
 
Examples:
| Email                      | Password   |
|  rohinipitta@gmail.com     |  Test@123  |
 
Scenario Outline: Verify login with case-sensitive password
    When the user enters Email Address "<Email>"
    And the user enters Password "<Password>"
    And the user clicks the Login button
    Then the error message "Your email or password is incorrect!" should be displayed
 
Examples:
| Email                   | Password |
| rohinipitta@gmail.com   | test@123 |
 
Scenario: Verify Logout functionality
    Given the user is logged in successfully
    When the user clicks the Logout button
    Then the user should be navigated to the Login page
    And the "Login to your account" section should be displayed
 
Scenario: Verify user cannot access account after logout using browser Back button
    Given the user is logged in successfully
    When the user clicks the Logout button
    And the user clicks the Browser Back button
    Then the Login page should be displayed