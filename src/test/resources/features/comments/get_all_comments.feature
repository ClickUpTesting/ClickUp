Feature: Get all Comments

  @CreateTask @DeleteTask
  Scenario: As a user I want to get all Comments and verity the quantity
    Given I set the comment with request endpoint to /task/{task_id}/comment
    When I add the amount of 3 to the total of comments in the "task"
      And I execute the GET request
    Then I verify the amount of comments has increased by 3
      And I verify that the response status is 200
      And I verify the schema matches the file: schemas/comment/get_comments.json
