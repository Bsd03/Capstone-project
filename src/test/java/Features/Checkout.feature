Feature: Checkout Page Functionality
 
Background:
    Given the user launches the browser
    And the user navigates to "https://automationexercise.com"
    Then the Home page should be displayed successfully
    And the user logs in with valid credentials
    And the user has at least one product in the cart
    When the user clicks the "Cart" menu
    And the user clicks the "Proceed To Checkout" button
    Then the Checkout page should be displayed successfully
 
Scenario: Verify Checkout page loads successfully
    Then the Delivery Address section should be displayed
    And the Billing Address section should be displayed
    And the Review Your Order section should be displayed
    And the Place Order button should be enabled
 
Scenario Outline: Verify checkout with products
    Given the user has "<ProductCount>" product(s) in the cart
    When the user clicks the "Proceed To Checkout" button
    Then the Checkout page should be displayed successfully
    And the Delivery Address should be displayed correctly
    And the Order Summary should display all selected products
    And the Place Order button should be enabled
 
Examples:
| ProductCount |
| 1            |
| 2            |
| 3            |
 
Scenario: Verify checkout with empty cart
    Given the user removes all products from the cart
    When the user clicks the "Proceed To Checkout" button
    Then the appropriate message "Your cart is empty!" should be displayed
    And the Checkout page should not be opened
 
Scenario Outline: Verify Delivery Address information
    Given the user has added products to the cart
    When the user clicks the "Proceed To Checkout" button
    Then the following delivery details should be displayed
 
        | Name       | <Name> |
        | Company    | <Company> |
        | Address    | <Address> |
        | City       | <City> |
        | State      | <State> |
        | Country    | <Country> |
        | Zipcode    | <Zipcode> |
        | Mobile     | <Mobile> |
 
Examples:
| Name   | Company | Address  | City      | State     | Country | Zipcode | Mobile     |
| Rohini | ABC Ltd | Hyderabad| Hyderabad | Telangana | India   | 500001  | 9876543210 |
 
Scenario Outline: Verify Billing Address information
    Given the user has added products to the cart
    When the user clicks the "Proceed To Checkout" button
    Then the following billing details should be displayed
 
        | Name       | <Name> |
        | Company    | <Company> |
        | Address    | <Address> |
        | City       | <City> |
        | State      | <State> |
        | Country    | <Country> |
        | Zipcode    | <Zipcode> |
        | Mobile     | <Mobile> |
 
Examples:
| Name   | Company | Address  | City      | State     | Country | Zipcode | Mobile     |
| Rohini | ABC Ltd | Hyderabad| Hyderabad | Telangana | India   | 500001  | 9876543210 |
 
Scenario Outline: Verify Order Summary
    Given the user has "<ProductName>" in the cart
    When the user proceeds to Checkout
    Then the Order Summary should display
 
        | Product Name | <ProductName> |
        | Quantity     | <Quantity> |
        | Unit Price   | <Price> |
        | Total Price  | <Total> |
 
Examples:
| ProductName           | Quantity | Price | Total |
| Blue Top              | 1        | 500   | 500   |
| Men Tshirt            | 2        | 400   | 800   |
| Stylish Dress         | 3        | 600   | 1800  |
 
Scenario Outline: Verify order comment
    Given the user is on the Checkout page
    When the user enters "<Comment>" in the Comment box
    And the user clicks the Place Order button
    Then the Payment page should be displayed successfully
 
Examples:
| Comment                                 |
| Please deliver in the morning           |
| Leave the package at the front door     |
| Handle the package carefully            |
 
Scenario: Verify Place Order button
    Given the user is on the Checkout page
    When the user clicks the Place Order button
    Then the Payment page should be displayed successfully
 
Scenario: Verify Checkout page after refreshing
    Given the user is on the Checkout page
    When the user refreshes the browser
    Then the Checkout page should still be displayed
    And the cart details should remain unchanged
 
Scenario: Verify Checkout with multiple products
    Given the user has multiple products in the cart
    When the user clicks the "Proceed To Checkout" button
    Then all selected products should be displayed in the Order Summary
    And the total amount should be calculated correctly
 
Scenario: Verify Checkout after updating product quantity
    Given the user updates the product quantity in the cart
    When the user proceeds to Checkout
    Then the updated quantity should be displayed in the Order Summary
    And the total price should be updated correctly