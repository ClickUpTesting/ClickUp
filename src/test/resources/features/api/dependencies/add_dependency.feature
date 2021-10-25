Feature: Add dependency to a task

  @API @SmokeTesting @Dependency @CreateTask @DeleteTask
  Scenario: As a user I want to add dependency from a task to another one
    Given I set the endpoint /task/{task_id}/dependency
    When I make a task depends on another one
     And I execute a POST request
    Then I verify that the response status is 200