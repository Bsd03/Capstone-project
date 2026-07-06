Feature: Category Navigation on AutomationExercise

  Background:
    Given User launches the browser
    And User navigates to Automation Exercise Website
    And User is on the home page

  @WomenCategory
  Scenario: Verify Women Dress Category
    When User clicks on Women category
    And User clicks on Dress subcategory
    Then User should see Dress category title

  @WomenTops
  Scenario: Verify Women Tops Category
    When User clicks on Women category
    And User clicks on Tops subcategory
    Then User should see Top category page title

  @WomenSaree
  Scenario: Verify Women Saree Category
    When User clicks on Women category
    And User clicks on Saree subcategory
    Then User should see Saree page title

  @MenCategory
  Scenario: Verify Men Tshirt Category
    When User clicks on Men category
    And User clicks on Tshirt subcategory
    Then User should see Tshirt category page title

  @MenJeans
  Scenario: Verify Men Jeans Category
    When User clicks on Men category
    And User clicks on Jeans subcategory
    Then User should see Jeans category page title

  @KidsDress
  Scenario: Verify Kids Dress Category
    When User clicks on Kids category
    And User clicks on Kids Dress subcategory
    Then User should see Dress page title

  @KidsTops
  Scenario: Verify Kids Tops & Shirts Category
    When User clicks on Kids category
    And User clicks on Tops & Shirts subcategory
    Then User should see Tops & Shirts  page title