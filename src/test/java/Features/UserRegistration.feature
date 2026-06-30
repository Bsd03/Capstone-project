Feature: User Registration
  Background:
    Given the user launches the browser
    And the user navigates to "https://automationexercise.com"
    Then the Home page should ne displayed successfullly
    When the user clicks on the "Signup / Login" menu
    Then the "New User Signup!" section should be displayed
  Scenario: Verify Registraion page load successfully
    Then the Name field should be displayed
    And the Signup button should be enabled
  Scenario Outline: Verify user registration with vaild  details
    When the user enters Name "<Name>"
    And the user enters a random Email Address
    And the user enters Account Information
      |Title|<Title>|
      |Password|<Password>|
      |Day     |<Day>     |
      |Month   |<Month>   |
      |Year    |<Year>    |
    And the user enters Address Information
      |First Name|<FirstName>|
      |LastName  |<LastName> |
      |Company   |<Company>  |
      |Address   |<Address>  |
      |Country   |<Country>  |
      |State     |<State>    |
      |City      |<City>     |
      |Zipcode   |<Zipcode>  |
      |Mobile    |<Mobile>   |
    And the user  clicks the Create Acoount button
    Then the account shpuld be created successfully
    And the "ACCOUNT CREATED!" message should be displayed
    Examples:
      |Name|Title|Password|Day|Month|Year|FirstName|LastName|Company|Address|Country|State|City|Zipcode|Mobile|
      |Rohini|Mrs|Test@123|10 |May  |2002|Rohini   |Pitta   |ABC    |HYderabad|India|Telanagana|Hyderbad|506313|1234567890|

  Scenario Outline: Verify registration with and existing email address
    When the user enters Name "<Name>"
    And the user enters Email Adress "<Email>"
    And the user clicks the Signup button
    Then the error message "Email Address already exisy!" should be displayed
    Examples:
      |Name |Email|
      |Rohini|rohinipitta@gmail.com|
  Scenario Outline: Verify registration with invalid email format
    When the user enters Name"<Name>"
    And the user enters Email Address "<Email>"
    And the user clicks the Signup button
    Then the appropriate email validation message should be displayed
    Examples:
      |Name|Email|
      |Rohini| rohini|
      |Rohini|rohini |
      |Rohini|abc.com|
      |Rohini|@gmail.com|
  Scenario: Verify registration with madatory fields left empty
    When the user clicks the Signup button without entering Name and Email
    Then the required field validation messages should displayed.







