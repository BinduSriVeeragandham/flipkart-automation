Feature: Product Listing

Scenario: Verify products displayed
  Given User launches Flipkart
  When User searches for "iphone"
  Then Multiple products should be listed

Scenario: Apply filters
  Given User launches Flipkart
  When User searches for "iphone"
  And User applies price filter
  And User applies brand filter
  Then Filtered results should display

Scenario: Verify listing page title loads
  Given User launches Flipkart
  When User searches for "iphone"
  Then Listing page title should load
