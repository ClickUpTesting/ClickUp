Feature: Create comment in task

  @CreateTeamViewTypeConversation @DeleteView
  Scenario: As a user I want to create a comment in team view
    Given I set the comment with request endpoint to /view/{view_id}/comment
    When I set the request body with following values:
      |comment_text | View comment content |
      |notify_all   | true                 |
      And I execute the POST request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/comment/create_comment_in_task.json