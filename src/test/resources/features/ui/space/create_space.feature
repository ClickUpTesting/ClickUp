@GUI @Space
Feature: Create Space

  @Smoke @DeleteSpace
  Scenario: Create a space with default settings
    Given I login to click up as an admin
    When I create a space with the following parameters
      | name | My space created |
    Then I verify that the created space contains the default values

