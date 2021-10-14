Feature: Create comment

  @DeleteComment
  Scenario: As a user I want to create a comment in list
    Given I set the comment with request endpoint to /list/{list_id}/comment
    When I set the request body with following values:
      | comment_text | list comment content |
      | assignee     | 53480                |
      | notify_all   | false                 |
      And I execute the POST request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/comment/create_comment_in_task.json

  @DeleteComment
  Scenario: As a user I want to create a comment in task
    Given I set the comment with request endpoint to /task/{task_id}/comment
    When I set the request body with following values:
      | comment_text | Task comment content |
      | assignee     | 53480                |
      | notify_all   | true                 |
      And I execute the POST request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/comment/create_comment_in_task.json