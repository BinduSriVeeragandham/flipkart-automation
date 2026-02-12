Feature: Product Sorting

Scenario: Sort Low to High
  Given User launches Flipkart
  When User searches for "iphone"
  And User sorts price low to high
  Then Products should be sorted low to high

Scenario: Sort High to Low
  Given User launches Flipkart
  When User searches for "iphone"
  And User sorts price high to low
  Then Products should be sorted high to low

Scenario: Sort by Popularity
  Given User launches Flipkart
  When User searches for "iphone"
  And User sorts by popularity
  Then Products should be sorted
