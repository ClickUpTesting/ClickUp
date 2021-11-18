@GUI @TaskGUI
Feature: Delete a task

  @Smoke @CreateTask
  Scenario: Delete a task in a list
    Given I login to click up as an admin
      And I navigate to a task menu
    When I delete a task
    Then I verify that the task does not exist in the list