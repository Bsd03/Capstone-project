Feature: User Login

Background:
    Given the login browser is launched successfully
    And the user navigates to "https://automationexercise.com"
    Then the user should be redirected to the login home page
    When the user clicks on the login menu
    Then the login section should be displayed

Scenario: Verify Login page loads successfully
    Then the login email address field should be displayed
    And the login password field should be displayed
    And the login button should be enabled

Scenario Outline: Verify login with valid credentials
    When the user enters login Email Address "<Email>"
    And the user enters login Password "<Password>"
    And the user clicks the login button
    Then the user should be logged in successfully
    And the "Logged in as <UserName>" login message should be displayed

Examples:
| Email         | Password  | UserName |
| iut@gmail.com | Afrin*123 | afrin    |

Scenario Outline: Verify login with invalid credentials
    When the user enters login Email Address "<Email>"
    And the user enters login Password "<Password>"
    And the user clicks the login button
    Then the login error message "Your email or password is incorrect!" should be displayed

Examples:
| Email                 | Password |
| abc@gmail.com         | Test123  |
| rohinipitta@gmail.com | Wrong123 |
| invalid@gmail.com     | Admin123 |

Scenario Outline: Verify login with invalid email format
    When the user enters login Email Address "<Email>"
    And the user enters login Password "<Password>"
    And the user clicks the login button
    Then the appropriate login email validation message should be displayed

Examples:
| Email      | Password |
| rohini     | Test@123 |
| abc.com    | Test@123 |
| @gmail.com | Test@123 |
| abc@       | Test@123 |

Scenario: Verify login with mandatory fields left empty
    When the user clicks the login button without entering email address and password
    Then the login required field validation messages should be displayed

Scenario Outline: Verify login with empty Email Address
    When the user enters login Email Address "<Email>"
    And the user enters login Password "<Password>"
    And the user clicks the login button
    Then the required login email validation message should be displayed

Examples:
| Email | Password |
|       | Test@123 |

Scenario Outline: Verify login with empty Password
    When the user enters login Email Address "<Email>"
    And the user enters login Password "<Password>"
    And the user clicks the login button
    Then the required login password validation message should be displayed

Examples:
| Email                 | Password |
| rohinipitta@gmail.com |          |

Scenario Outline: Verify login with leading and trailing spaces
    When the user enters login Email Address "<Email>"
    And the user enters login Password "<Password>"
    And the user clicks the login button
    Then the user should be logged in successfully

Examples:
| Email            | Password   |
|  iut@gmail.com   | Afrin*123  |

Scenario Outline: Verify login with case-sensitive password
    When the user enters login Email Address "<Email>"
    And the user enters login Password "<Password>"
    And the user clicks the login button
    Then the login error message "Your email or password is incorrect!" should be displayed

Examples:
| Email         | Password  |
| iut@gmail.com | afrin*123 |

Scenario: Verify Logout functionality
    Given the user is logged in successfully
    When the user clicks the logout button
    Then the user should be navigated to the login page
    And the login section should be displayed