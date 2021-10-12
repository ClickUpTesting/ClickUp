Feature: Get List

  @CreateTask @DeleteTask
  Scenario: As a user I want to get a list for tracking an objective
    Given I set the task with request endpoint to /task/{task_id}
    When I execute the GET request
    Then I verify that the response status is 200
