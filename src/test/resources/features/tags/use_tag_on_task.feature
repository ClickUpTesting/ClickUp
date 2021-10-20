Feature: Use Tag on Task

  @API @SmokeTesting @CreateTag @RemoveTagFromTask
  Scenario: As a user I want to add a tag to a task
    Given I set the endpoint /task/{task_id}/tag/{tag_name}
    When I execute a POST request
    Then I verify that the response status is 200

  @API @SmokeTesting @AddTagToTask @DeleteTag
  Scenario: As a user I want to remove a tag from a task
    Given I set the endpoint /task/{task_id}/tag/{tag_name}
    When I execute a DELETE request
    Then I verify that the tag does not exist in the task
      And I verify that the response status is 200