Feature: Login

  Scenario: Successful Login with credentials
    Given User Launch Chrome browser
    When User open URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And click on Login
    Then Page Title Should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title Should be "Your store. Login"
    And close browser

    Scenario Outline: Login Data Driven
      Given User Launch Chrome browser
      When User open URL "https://admin-demo.nopcommerce.com/login"
      And User enters Email as "<email>" and Password as "<password>"
      And click on Login
      Then Page Title Should be "Dashboard / nopCommerce administration"
      When User click on Log out link
      Then Page Title Should be "Your store. Login"
      And close browser

      Examples:
        | email    | password |
        | admin@yourstore.com | admin |
        | admin103@yourstore.com | admin1239 |

