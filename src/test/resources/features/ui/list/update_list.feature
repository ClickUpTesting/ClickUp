@GUI @List
Feature: Update a List

  @Smoke @CreateListInSpace @DeleteList
  Scenario: Update a list name from the top bar menu
    Given I login to click up as an admin
      And I navigate to a list menu
    When I update a list with the following parameters
      | name | My List Updated |
    Then I verify that the list contains the default values