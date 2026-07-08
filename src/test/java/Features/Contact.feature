Feature: Contact Us Functionality

  Background:
    Given User launches browser
    And User navigates to the Automation Exercise website
    When User clicks Contact Us menu

  Scenario: Verify Contact Us page
    Then Contact Us page should be displayed
    And Get In Touch section should be visible

  Scenario: Submit contact form with valid details
    When User enters name "Sayani"
    And User enters email "sayani@test.com"
    And User enters subject "Testing"
    And User enters message "Automation Testing Project"
    And User uploads file
    And User clicks Submit button
    Then Success message should be displayed

  Scenario: Verify Feedback For Us section
    Then Feedback For Us section should be displayed
    And Feedback email should be visible