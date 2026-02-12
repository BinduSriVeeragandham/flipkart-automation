Feature: Product Details

Scenario: Open product details
  Given User launches Flipkart
  When User searches for "iphone"
  And User clicks first product
  Then Product details page should open

Scenario: Verify product information
  Given User launches Flipkart
  When User searches for "iphone"
  And User clicks first product
  Then Product title should be visible
  And Product price should be visible
  And Product images should be displayed

Scenario: Verify product page URL
  Given User launches Flipkart
  When User searches for "iphone"
  And User clicks first product
  Then Product URL should contain product

Scenario: Verify Add to Cart button visible
  Given User launches Flipkart
  When User searches for "iphone"
  And User clicks first product
  Then Add to Cart button should be visible

Scenario: Verify product page title loads

  Given User launches Flipkart
  When User searches for "iphone"
  And User clicks first product
  Then Product page title should load

Scenario: Verify product page URL exists

  Given User launches Flipkart
  When User searches for "iphone"
  And User clicks first product
  Then Product page URL should exist
  
Scenario: Verify product page loads completely

  Given User launches Flipkart
  When User searches for "iphone"
  And User clicks first product
  Then Product page should load completely
  
Scenario: Verify Flipkart title on product page

  Given User launches Flipkart
  When User searches for "iphone"
  And User clicks first product
  Then Page title should contain Flipkart
  
Scenario: Verify product page opens for another search

  Given User launches Flipkart
  When User searches for "samsung mobile"
  And User clicks first product
  Then Product details page should open



