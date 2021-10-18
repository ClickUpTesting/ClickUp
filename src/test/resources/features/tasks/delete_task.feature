Feature: Delete task

  @API @SmokeTesting @CreateTask
  Scenario: As a user I want to delete a task
    Given I set the task with request endpoint to /task/{task_id}
    When I execute the DELETE request
    Then I verify that the response status is 200
