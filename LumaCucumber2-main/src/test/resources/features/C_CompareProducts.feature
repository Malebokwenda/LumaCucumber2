Feature: Compare Products

  Scenario: Compare Products from Hot Sellers
    Given User is on Luma Home page "https://magento.softwaretestingboard.com"
    When user scrolls down to view products under Hot Sellers
    And user hover over the product name to add to compare
    And user clicks on the comparison list link in the confirmation message
    Then user should see a confirmation message


#    clicked image for product details
  Scenario: Compare Products from Hot Sellers
    When user scrolls down to view products under Hot Sellers
    And user clicks on product name to add to compare product
    And  user clicks on the comparison list link in the confirmation message
    Then user should be redirected to the comparison list page

  Scenario: Compare Products in Hot Sellers List
    When user scrolls down to view products under Hot Sellers
    And user clicks on the product name to add product to compare product
    And  user clicks on the comparison list link in the confirmation message
    And user clicks on the remove icon for product name
    And user select OK from the confirmation alert
    Then the product name should be successfully removed from the comparison list

