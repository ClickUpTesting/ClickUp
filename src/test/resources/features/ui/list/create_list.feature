@GUI @List
Feature: Create Space

  @Smoke @CreateSpace @DeleteSpace
  Scenario: Create a list with default settings
    Given I login to click up as an admin
    When I create a list with the following parameters
      | name | My List created |
    Then I verify that the created list contains the default values

