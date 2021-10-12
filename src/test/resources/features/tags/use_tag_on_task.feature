Feature: Use Tag on Task

  @CreateTag @RemoveTagFromTask
  Scenario: As a user I want to add a tag to a task
    Given I set the tags with request endpoint to /task/{task_id}/tag/{tag_name}
    When I execute a POST request
    Then I verify that the response status is 200

  @AddTagToTask @DeleteTag
  Scenario: As a user I want to remove a tag from a task
    Given I set the tags with request endpoint to /task/{task_id}/tag/{tag_name}
    When I execute a DELETE request
    Then I verify that the tag does not exist in the task
    And I verify that the response status is 200