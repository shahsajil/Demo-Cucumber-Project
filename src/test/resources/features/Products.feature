Feature: Products

Scenario: Add a new Product
  Given User Launch Chrome browser
  When User open URL "https://admin-demo.nopcommerce.com/login"
  And User enters Email as "admin@yourstore.com" and Password as "admin"
  And click on Login
  Then User can view Dashboard
  When User click on Catalog Menu
  And click on Products Menu Item
  And click on Add new button
  Then User can view Add new product page
  When User enter product info
  And click on product save button
  Then User can view product confirmation message "The new product has been added successfully."
  And close browser

  Scenario Outline: Add more Products (Data Driven)
    Given User Launch Chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then User can view Dashboard
    When User click on Catalog Menu
    And click on Products Menu Item
    And click on Add new button
    Then User can view Add new product page
    When User enter Product Name info as "<product>" and SKU info as "<sku>";
    And click on product save button
    Then User can view product confirmation message "The new product has been added successfully."
    And close browser

    Examples:
    | product | sku |
    | Dell Laptop | dell_laptop |
    | Dell Monitor | dell_monitor |