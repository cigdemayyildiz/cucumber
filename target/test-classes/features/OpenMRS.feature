@SmokeTest
Feature: OpenMRS tests

  @Ignore @BadScenario @NotRun
  Scenario: Register a patient
    Given I'm logged in to OpenMRS with following credentials:
    |username|admin|
    |password|Admin123|
    When I register a new patient with following info:
    |GivenName  |John         |
    |FamilyName |Smith        |
    |Gender     |Male         |
    |Day        |1            |
    |Month      |January      |
    |Year       |1999         |
    |Address    |2200 E Devon |
    |PhoneNumber|3123123123   |

  Scenario Outline:
    Given I'm logged in to OpenMRS with "<username>" and "<password>"
    When I register a new patient with "<GivenName>", "<FamilyName>", "<Gender>", <Day>, "<Month>", <Year>, "<Address>" and <PhoneNumber>
    Examples:
    | GivenName | FamilyName | Gender | Day | Month | Year | Address | PhoneNumber | username | password |
    | Jerry     | White      | Male   | 11  | January | 1963 | Chicago | 43434343  | admin    | Admin123 |
    | Sarah     | Green      | Female | 31  | March   | 1969 | Chicago | 56756567  | admin    | Admin123 |


#  @Test
#  Scenario: Test scenario
#    When I test OpenMRS
#    Then Test passes
