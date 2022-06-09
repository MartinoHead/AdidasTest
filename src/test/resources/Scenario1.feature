# new feature
# Tags: optional

Feature: Test cases based on WEB FE Automation challenge

  @E2E
  Scenario Outline: End to end scenario with 2 products
    Given The user is navigated to <URL>
    And The Home Page is displayed
    And Select category laptop
    And Click on product "Sony vaio i5"

    And PDP is displayed
    And Click on add to cart link
    And Accept alert
    When The user go back to Home Page

    Then The Home Page is displayed
    When Select category laptop
    And Click on product "Dell i7 8gb"

    And PDP is displayed
    And Click on add to cart link
    And Accept alert
    When The user navigate to Cart Page

    Then Cart Page is displayed
    When The user delete product "Sony vaio i5" from cart
    When The user click on Place Order button

    And Place Order modal is displayed
    And The user apply <name>, <country>, <city>, <CreditCard>, <month> and <year> in order form
    When The user click on purchase button

    Then Order Confirmation message is displayed
    When Take screenshot! Ka-chick!
    When The user click on Order Confirm OK button

    Examples:
      | URL                                  | name       | country  | city  | CreditCard | month | year |
      | https://www.demoblaze.com/index.html | martyparty | Bulgaria | Sofia | 123        | May   | 1991 |

  @AddToBag @RemoveFromBag
  Scenario Outline: Add Product from PLP page one and product from PLP page two
    Given The user is navigated to <URL>
    And The Home Page is displayed
    And Select category laptop
    And Click on product "ASUS Full HD"

    And PDP is displayed
    And Click on add to cart link
    And Accept alert
    When The user go back to Home Page

    Then The Home Page is displayed
    When Select category laptop
    And Click on product "Dell i7 8gb"

    Examples:
      | URL                                  |
      | https://www.demoblaze.com/index.html |

  @AddToBag @MoreThanOneProduct
  Scenario Outline: Add product multiple times from PDP
    Given The user is navigated to <URL>
    And The Home Page is displayed
    And Select category laptop
    And Click on product "Dell i7 8gb"

    And PDP is displayed
    And Click on add to cart link
    And Accept alert

    And Click on add to cart link
    And Accept alert

    And Click on add to cart link
    And Accept alert

    And Click on add to cart link
    And Accept alert

    Examples:
      | URL                                  |
      | https://www.demoblaze.com/index.html |