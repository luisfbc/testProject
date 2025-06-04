Feature: Amazon Web Page | Shopping Cart
  As a user
  I want to shop products from Amazon Web Page

  Scenario: Validate the displayed price in the cart is correct.
    Given I go to Amazon web page
    When I search for "TV" in the search bar
      And I validate the option "3" from the list
      And I add the product "3" to my cart
      And I add the product "5" to my cart
      And I add the product "8" to my cart
      And I add the product "9" to my cart
    Then I go to my cart
      And I validate the displayed "price" in the cart
      And I expect the search price is the same as the cart price