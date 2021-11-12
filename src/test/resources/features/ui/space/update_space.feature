@GUI @Space
Feature: Update a Space

  @Smoke @CreateSpace @DeleteSpace
  Scenario: Update a space name from the top bar menu
    Given I login to click up as an admin
      And I navigate to a space menu
    When I update a space with the following parameters
      | name | My space Updated |
    Then I verify that the updated space contains the default values