@GUI @Task @TaskGUI
Feature: Create task

  @Smoke @CreateListInFolder @DeleteList
  Scenario: Create a task in a list with default setting
    Given I login to click up as an admin
    When I create a new task with field
      | name | New workspace random |
    Then I verify that the created task contains the default values