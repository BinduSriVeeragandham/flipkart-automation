Feature: Home Page

  Scenario: Verify home page loads
    Given User launches Flipkart
    Then Search box should be visible

  Scenario: Close login popup
    Given User launches Flipkart
    When User closes login popup
    Then Search box should be visible

  Scenario: Verify Flipkart page title loads
  Given User launches Flipkart
  Then Home page title should load
