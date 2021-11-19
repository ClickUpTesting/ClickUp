@GUI @List
Feature: Update a List

  @Smoke @CreateListInSpace @DeleteList
  Scenario: Update a list name from the top bar menu
    Given I login to click up as an admin
      And I navigate to a list menu
    When I update a list with the following parameters
      | name | My List Updated |
    Then I verify that the list contains the default values

  @Smoke @CreateListInFolder @CreateFolder @DeleteFolder
  Scenario: Move the list from folder to folder
    Given I login to click up as an admin
      And I navigate to a list menu
    When I move a list from folder to folder
      And I navigate to a folder menu
    Then I verify that the list has been moved to a different folder