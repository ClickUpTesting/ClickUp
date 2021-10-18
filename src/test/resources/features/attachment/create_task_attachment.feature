Feature: create a task attachment

  @API @SmokeTesting @CreateTask @DeleteTask
  Scenario: As a user I want to add dependency to a task
    Given I set the endpoint /task/{task_id}/attachment
    When I Add an attachment to the task
    And I execute a POST request
    Then I verify that the response status is 200