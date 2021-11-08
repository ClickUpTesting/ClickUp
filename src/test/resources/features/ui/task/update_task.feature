@GUI @Task @TaskGUI
Feature: Update task

  @Smoke @CreateTask @DeleteTask
  Scenario: Update a task with default setting
    Given I login to click up as an admin
      And I open a task
    When I update a new task with field
      | name | New task updated |
    Then I verify that the updated task contains the default values