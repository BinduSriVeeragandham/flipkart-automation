Feature: Cart

Scenario: Add product to cart
Given User launches Flipkart
When User searches for "iphone"
And User clicks first product
And User adds product to cart
Then Product should be added to cart

Scenario: Remove product from cart
Given User launches Flipkart
When User searches for "iphone"
And User clicks first product
And User adds product to cart
When User opens cart
And User removes product
Then Cart should be empty

Scenario: Verify cart page URL
  Given User launches Flipkart
  When User searches for "iphone"
  And User clicks first product
  And User adds product to cart
  Then Cart URL should contain cart

Scenario: Verify cart page title
  Given User launches Flipkart
  When User searches for "iphone"
  And User clicks first product
  And User adds product to cart
  Then Cart title should be visible
  
Scenario: Verify cart URL exists
  Given User launches Flipkart
  When User searches for "iphone"
  And User clicks first product
  And User adds product to cart
  Then Cart URL should exist

