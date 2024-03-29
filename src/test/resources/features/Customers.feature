Feature: Customers

  Background: Below are the common steps for each scenario
    Given User Launch Chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then User can view Dashboard

  Scenario: Add a new Customer
    When User click on customers Menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser

  Scenario: Search Customer By EmailID
    When User click on customers Menu
    And click on customers Menu Item
    And Enter customer Email
    When Click on search button
    Then User should found Email in the Search table
    And close browser

  Scenario: Search Customer By Name
    When User click on customers Menu
    And click on customers Menu Item
    And Enter customer FirstName
    And Enter customer LastName
    When Click on search button
    Then User should found Name in the Search table
    And close browser

  Scenario: Search Customer By Company Name
    When User click on customers Menu
    And click on customers Menu Item
    And Enter Company Name
    When Click on search button
    Then User should found Company Name in the Search table
    And close browser