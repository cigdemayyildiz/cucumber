Feature: Testing OrangeHRM functionalities
  Scenario: Happy path OrangeHRM login functionality
    Given I am on OrangeHRM login page
    When I fill up all info for login
    Then I see dashboard page