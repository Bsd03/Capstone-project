Feature: Verify Products functionality on Automation Exercise Website

Background:
Given the user launches the browser
And the user navigates to Automation exercise Website
Then the Home page should be displayed successfully
When the user clicks on the "Products" menu
Then the Products Page of All Products page should be displayed
 
Scenario: Verify all products are displayed
Then the list of all products should be displayed
 
Scenario Outline: Verify product details
When the user opens the "<ProductName>" product
Then the product details page should be displayed
And the product name should be displayed
And the product category should be displayed
And the product price should be displayed
And the product availability should be displayed
And the product condition should be displayed
And the product brand should be displayed
 
Examples:
| ProductName |
| Blue Top |
| Men Tshirt |
| Sleeveless Dress |
 
Scenario Outline: Search for a product
When the user searches for "<ProductName>"
Then the searched products page should be displayed
And the searched product "<ProductName>" should be displayed
 
Examples:
| ProductName |
| Blue Top |
| Men Tshirt |
| Sleeveless Dress |
 
Scenario Outline: Add product to cart
When the user opens the "<ProductName>" product
And the user clicks the Add to Cart button
And the user opens the cart
Then the product "<ProductName>" should be displayed in the cart
 
Examples:
| ProductName |
| Blue Top |
| Men Tshirt |
| Sleeveless Dress |
 
Scenario Outline: Verify product quantity
When the user opens the "<ProductName>" product
And the user changes the quantity to "<Quantity>"
And the user clicks the Add to Cart button
And the user opens the cart
Then the product quantity should be "<Quantity>"
 
Examples:
| ProductName | Quantity |
| Blue Top | 2 |
| Men Tshirt | 3 |
| Sleeveless Dress | 4 |
 
  