Feature: Logging in to the site using different usernames

  Background: I am on the site's authorization page
    Given  Opening the site "https://www.saucedemo.com"

    Scenario: Enter your username and password for standard_user, click the login button, and you'll be taken to the product page.
      When I enter the login from standard_user
      And I enter the password for standard_user
      And I press the login button
      Then I get to the product page where the shopping cart is displayed

  Scenario: I enter the login and password for locked_out_user, click the login button, and receive a warning-login error, since the user is locked out.
    When I enter the login from locked_out_user
    And I enter the password for locked_out_user
    And I press the login button
    Then I get a warning - login error because the user is blocked

