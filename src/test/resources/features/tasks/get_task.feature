Feature: Get Task

  @API @SmokeTesting @CreateTask @DeleteTask
  Scenario: As a user I want to get a task
    Given I set the task with request endpoint to /task/{task_id}
    When I execute the GET request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/task/create_task_required_field.json
