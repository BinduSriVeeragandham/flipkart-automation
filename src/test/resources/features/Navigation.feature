Feature: Navigation

Scenario: Navigate to mobiles category
Given User launches Flipkart
When User navigates to mobiles category
Then Mobiles page should display

Scenario: Navigate back using logo
Given User launches Flipkart
When User navigates to mobiles category
And User clicks Flipkart logo
Then User should be on home page

Scenario: Verify homepage URL
  Given User launches Flipkart
  Then Homepage URL should be correct

Scenario: Verify search box placeholder
  Given User launches Flipkart
  Then Search placeholder should be visible
