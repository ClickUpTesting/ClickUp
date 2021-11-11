@GUI @Space
Feature: Delete a space

  @Smoke @CreateSpace
  Scenario: Delete a list from the top bar menu
    Given I login to click up as an admin
      And I navigate to a space menu
    When I delete a scape
    Then I verify that the space does not exist in the sidebar