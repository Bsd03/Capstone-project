Feature: Checkout Functionality

  Background:
    Given User is on Automation Exercise home page
    When User logs in with valid credentials

  
  Scenario: Verify checkout page loads successfully
    When User clicks on Products menu
    And User opens the first product
    And User adds the product to cart
    And User views the cart
    And User proceeds to checkout
    Then Checkout page should be displayed

  
  Scenario: Verify checkout with single product
    When User clicks on Products menu
    And User opens the first product
    And User adds the product to cart
    And User views the cart
    Then Cart should contain 1 product
    When User proceeds to checkout
    Then Checkout page should be displayed

  
  Scenario: Verify checkout with multiple products
    When User clicks on Products menu
    And User adds the following products
      | Blue Top         |
      | Men Tshirt       |
      | Sleeveless Dress |
    And User views the cart
    Then Cart should contain 3 products
    When User proceeds to checkout
    Then Checkout page should be displayed


  
  Scenario: Verify delivery address information
    When User clicks on Products menu
    And User opens the first product
    And User adds the product to cart
    And User views the cart
    And User proceeds to checkout
    Then Delivery address should be displayed

  
  Scenario: Verify billing address information
    When User clicks on Products menu
    And User opens the first product
    And User adds the product to cart
    And User views the cart
    And User proceeds to checkout
    Then Billing address should be displayed

  
  Scenario: Verify review order section
    When User clicks on Products menu
    And User opens the first product
    And User adds the product to cart
    And User views the cart
    And User proceeds to checkout
    Then Review order section should be displayed

  
 

  
  Scenario: Verify Place Order button
    When User clicks on Products menu
    And User opens the first product
    And User adds the product to cart
    And User views the cart
    And User proceeds to checkout
    Then Place Order button should be visible

  
  Scenario: Verify successful order placement
    When User clicks on Products menu
    And User opens the first product
    And User adds the product to cart
    And User views the cart
    And User proceeds to checkout
    And User places the order
    And User enters payment details
      | name  | Rakesh Roshan    |
      | card  | 4111111111111111 |
      | cvc   | 123              |
      | month | 12               |
      | year  | 2030             |
    And User confirms the order
    Then Order should be placed successfully

  
  Scenario: Verify invoice download option
    When User clicks on Products menu
    And User opens the first product
    And User adds the product to cart
    And User views the cart
    And User proceeds to checkout
    And User places the order
    And User enters payment details
      | name  | Rakesh Roshan    |
      | card  | 4111111111111111 |
      | cvc   | 123              |
      | month | 12               |
      | year  | 2030             |
    And User confirms the order
    Then Download Invoice button should be visible

  Scenario: Verify Continue button after successful order
    When User clicks on Products menu
    And User opens the first product
    And User adds the product to cart
    And User views the cart
    And User proceeds to checkout
    And User places the order
    And User enters payment details
      | name  | Rakesh Roshan    |
      | card  | 4111111111111111 |
      | cvc   | 123              |
      | month | 12               |
      | year  | 2030             |
    And User confirms the order
    Then Continue button should be visible