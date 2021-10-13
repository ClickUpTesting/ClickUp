Feature: Create comment in task

  @CreateTask @DeleteTask
  Scenario: As a user I want to create a task with required field
    Given I set the comment with request endpoint to /task/{task_id}/comment
    When I set the request body with following values:
      | comment_text | Task comment content |
      | assignee     | 53480                |
      | notify_all   | true                 |
    And I execute the POST request
    Then I verify that the response status is 200
    And I verify the schema matches the file: schemas/comment/create_comment_in_task.json
