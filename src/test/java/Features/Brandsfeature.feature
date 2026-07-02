Feature: Verify Brands functionality on Automation Exercise Website

  Background:
    Given the user launches the browser
    And the user navigates to Automation Exercise Website
    Then the Home page should be displayed successfully
    When the user clicks on the "Products" menu
    Then the All Products page should be displayed

  Scenario: Verify Brands section is displayed
    Then the Brands section should be visible on the left side
    And all available brand names should be displayed

  Scenario Outline: Verify products displayed for selected brand
    When the user clicks on "<BrandName>" brand
    Then the "<BrandName>" brand page should be displayed
    And all displayed products should belong to "<BrandName>"

    Examples:
      | BrandName |
      | Polo      |
      | H&M       |
      | MADAME    |
      | MAST & HARBOUR     |
      |BABYHUG             |
      |ALLEN SOLLY JUNIOR  |
      |KOOKIE KIDS         |
      |BIBA                |


  Scenario Outline: Switch between two brands
    When the user clicks on "<FirstBrand>" brand
    Then the "<FirstBrand>" products should be displayed
    When the user clicks on "<SecondBrand>" brand
    Then the "<SecondBrand>" products should be displayed

    Examples:
      | FirstBrand | SecondBrand |
      | Polo       | H&M         |
      | Madame     | Biba        |

  Scenario Outline: Verify brand page URL for all brands
    When the user clicks on "<BrandName>" brand
    Then the "<BrandName>" brand page should be displayed
    And the URL should contain "brand_products"

    Examples:
      | BrandName |
      | Polo      |
      | H&M       |
      | Madame    |
      | Mast & Harbour |
      | Babyhug   |
      | Allen Solly Junior |
      | Kookie Kids |
      | Biba      |

  Scenario Outline: Verify product details under each brand
    When the user clicks on "<BrandName>" brand
    Then the "<BrandName>" brand page should be displayed
    And the user opens the first product
    Then the product name should be displayed
    And the product category should be displayed
    And the product price should be displayed
    And the product availability should be displayed
    And the product brand should be "<BrandName>"

    Examples:
      | BrandName |
      | Polo |
      | H&M |
      | Madame |
      | Mast & Harbour |
      | Babyhug |
      | Allen Solly Junior |
      | Kookie Kids |
      | Biba |

  Scenario Outline: Add a brand product to cart for all brands
    When the user clicks on "<BrandName>" brand
    Then the "<BrandName>" brand page should be displayed
    When the user adds the first product to the cart
    And the user opens the cart
    Then the selected "<BrandName>" product should be displayed in the cart

    Examples:
      | BrandName |
      | Polo |
      | H&M |
      | Madame |
      | Mast & Harbour |
      | Babyhug |
      | Allen Solly Junior |
      | Kookie Kids |
      | Biba |