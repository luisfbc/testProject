Feature: Amazon Web Page | Shopping Cart
  As a user
  I want to shop products from Amazon Web Page

  Scenario Outline: Validate the displayed price in the cart is correct.
    Given I go to Amazon web page in "<browser>" browser
    When I search for "TV" in the search bar
      And I validate the option "3" from the list
      And I add the product "3" to my cart
    Then I go to my cart
      And I validate the displayed "price" in the cart
      And I expect the search price is the same as the cart price

    Examples:
      | browser |
      | chrome  |
      | firefox |