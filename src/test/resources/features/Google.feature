Feature: Testing google functionalities

  Background:
    Given I navigate to google.com

  @SmokeTest
  Scenario: Happy path Google search functionality
    When I search for Techtorial Academy
    Then I get more than 10 result

  Scenario: Google search negative scenario
    When I search for "kladjfladdlkfjdklajf"
    Then I should get 0 result