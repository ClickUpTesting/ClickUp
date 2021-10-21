Feature: Create comment

  @API @SmokeTesting @DeleteComment
  Scenario: As a user I want to create a comment in list
    Given I set the comment with request endpoint to /list/{list_id}/comment
    When I set the request body with following values:
      | comment_text | list comment content |
      | assignee     | 53480                |
      | notify_all   | false                 |
      And I execute the POST request
    Then I verify that the response status is 200
      And I verify the values on the comments list
      And I verify the schema matches the file: schemas/comment/create_comment_in_task.json

  @API @SmokeTesting @DeleteComment
  Scenario: As a user I want to create a comment in task
    Given I set the comment with request endpoint to /task/{task_id}/comment
    When I set the request body with following values:
      | comment_text | Task comment content |
      | assignee     | 53480                |
      | notify_all   | true                 |
      And I execute the POST request
    Then I verify that the response status is 200
      And I verify the values on the comments task
      And I verify the schema matches the file: schemas/comment/create_comment_in_task.json

  @API @SmokeTesting @CreateTeamViewTypeConversation @DeleteView
  Scenario: As a user I want to create a comment in team view
    Given I set the comment with request endpoint to /view/{view_id}/comment
    When I set the request body with following values:
      |comment_text | View comment content |
      |notify_all   | true                 |
      And I execute the POST request
    Then I verify that the response status is 200
      And I verify the values on the comments chat view
      And I verify the schema matches the file: schemas/comment/create_comment_in_task.json