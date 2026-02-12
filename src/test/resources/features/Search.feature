Feature: Search Products

Scenario Outline: Search different products
  Given User launches Flipkart
  When User searches for "<product>"
  Then Search results should be displayed

Examples:
| product |
| iphone |
| xyzinvalid123 |
| @@@@ |

Scenario: Verify search URL
  Given User launches Flipkart
  When User searches for "iphone"
  Then Search URL should contain iphone

Scenario: Verify search box retains keyword
  Given User launches Flipkart
  When User searches for "iphone"
  Then Search box should contain iphone

Scenario: Verify search results count
  Given User launches Flipkart
  When User searches for "iphone"
  Then At least one product should display
  
Scenario: Verify search page URL exists
  Given User launches Flipkart
  When User searches for "iphone"
  Then Search results URL should exist

