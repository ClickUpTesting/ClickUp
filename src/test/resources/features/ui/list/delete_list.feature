@GUI @List
Feature: Delete a List

  @Smoke @CreateListInSpace
  Scenario: Delete a list from the top bar menu
    Given I login to click up as an admin
      And I navigate to a list menu
    When I delete a list
    Then I verify that the list does not exist in the space