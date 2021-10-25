Feature: Update task

  @API @SmokeTesting @Task @CreateTask @DeleteTask
  Scenario: As a user I want to update a task with required field
    Given I set the task with request endpoint to /task/{task_id}
    When I set the request body with following values:
      | name          | Updated Task Name    |
    And I execute the PUT request
    Then I verify that the response status is 200
      And I verify that the response matches with the body
      And I verify the schema matches the file: schemas/task/update_task_required_field.json

  @API @SmokeTesting @Task @CreateTask @DeleteTask
  Scenario: As a user I want to update a task with all fields enabled
    Given I set the task with request endpoint to /task/{task_id}
    When I set the request body with following values:
      | name          | Updated Task Name    |
      | description   | Updated Task Content |
      | status        | complete             |
      | priority      | 1                    |
      | time_estimate | 8640031              |
      | archived      | false                |
      And I execute the PUT request
    Then I verify that the response status is 200
      And I verify that the response matches with the body
      And I verify the schema matches the file: schemas/task/update_task_all_fields.json