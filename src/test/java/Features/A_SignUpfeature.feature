Feature: User Registration

  Background:
    Given the user launches the browser
    And the user navigates to Automation Exercise Website
    Then the Home page should be displayed successfully
    When the user clicks on the Signup / Login menu
    Then the New User Signup! section should be displayed
    Then the Name field should be displayed
    And the Signup button should be enabled

  Scenario: Verify registration with valid details
    When the user enters Name "Rohini"
    And the user enters a random Email Address
    And the user clicks the Signup button
    And the user enters Account Information
      | Title    | Mrs      |
      | Password | Test@123 |
      | Day      | 10       |
      | Month    | May      |
      | Year     | 2002     |
    And the user enters Address Information
      | FirstName | Rohini     |
      | LastName  | Pitta      |
      | Company   | ABC        |
      | Address   | Hyderabad  |
      | Country   | India      |
      | State     | Telangana  |
      | City      | Hyderabad  |
      | Zipcode   | 506313     |
      | Mobile    | 9876543210 |
    And the user clicks the Create Account button
    Then the account should be created successfully
    And the "ACCOUNT CREATED!" message should be displayed
    And User clicks on Continue Button

    Given User is on the Home page
    When User clicks on Delete Account
    Then Account Deleted message should be displayed


  Scenario Outline: Verify registration with an existing email address
    When the user enters Name "<Name>"
    And the user enters Email Address "<Email>"
    And the user clicks the Signup button
    Then the error message "Email Address already exist!" should be displayed

    Examples:
      | Name   | Email                  |
      | Rohini | rohinipitta@gmail.com  |

  Scenario Outline: Verify registration with invalid email format
    When the user enters Name "<Name>"
    And the user enters Email Address "<Email>"
    And the user clicks the Signup button
    Then the appropriate email validation message should be displayed

    Examples:
      | Name   | Email      |
      | Rohini | rohini     |
      | Rohini | rohini@    |
      | Rohini | abc.com    |
      | Rohini | @gmail.com |

  Scenario: Verify registration with mandatory fields left empty
    When the user clicks the Signup button without entering Name and Email
    Then the required field validation messages should displayed.



