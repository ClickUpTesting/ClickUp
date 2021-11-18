@GUI @Task @TaskGUI
Feature: Update task

  @Smoke @CreateTask @DeleteTask
  Scenario: Update a task with default setting
    Given I login to click up as an admin
    And I navigate to a task menu
    When I update a new task with field
      | name | New task updated |
    Then I verify that the updated task contains the default values

  @Smoke @CreateTask @DeleteTask
  Scenario: Update a task with default setting
    Given I login to click up as an admin
    And I navigate to a task menu
    When I update a new task with field
      | due date | Tomorrow |
    Then I verify that the updated task contains the default values