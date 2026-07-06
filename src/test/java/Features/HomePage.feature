Feature: Home Page Functionality

  As a user
  I want to access and interact with the Home page
  So that I can browse products and navigate through the website

  Background:
    Given User launches the browser
    And User navigates to "https://automationexercise.com"
	
  Scenario: Verify Home page is displayed successfully
    Then Home page should be displayed
    And Website logo should be visible

  Scenario: Verify navigation menu options
    Then Home menu should be visible
    And Products menu should be visible
    And Cart menu should be visible
    And Signup Login menu should be visible

  Scenario: Verify homepage carousel slider
    Then Homepage slider should be displayed
    When User clicks next slider button
    Then Next banner should be displayed

  Scenario: Verify category section is displayed
    Then Category section should be visible
    And Women category should be displayed
    And Men category should be displayed
    And Kids category should be displayed

  Scenario: Verify Women category expansion
    When User expands Women category
    Then Women category subcategories should be displayed

  Scenario: Verify Men category expansion
    When User expands Men category
    Then Men category subcategories should be displayed

  Scenario: Verify Kids category expansion
    When User expands Kids category
    Then Kids category subcategories should be displayed

  Scenario: Verify Features Items section
    Then Features Items section should be displayed


  Scenario: Verify product details from home page
    When User clicks View Product for a product
    Then Product details page should be displayed

  Scenario: Verify Add to Cart from home page
    When User clicks Add to Cart for a product
    Then Product should be added to cart successfully

  Scenario: Verify Brands section
    Then Brands section should be displayed
    And Brand names should be listed

  Scenario: Verify brand selection
    When User clicks on a brand
    Then Brand products page should be displayed
  Scenario: Verify Scroll Up button
    When User scrolls down the page
    Then Scroll Up button should be visible
    When User clicks Scroll Up button
    Then User should be navigated to the top of the page
    
  Scenario: Verify footer section
    When User scrolls to bottom of page
    Then Footer should be displayed
    
  Scenario: Verify subscription functionality
    When User enters valid email address
    And User clicks Subscribe button
    Then Subscription success message should be displayed
