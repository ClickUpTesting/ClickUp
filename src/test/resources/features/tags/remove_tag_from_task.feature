Feature: Remove a Tag from a Task

  @AddTagToTask @DeleteTag
  Scenario: As a user I want to remove a tag from a task
    Given I set the tags composed endpoint /task/{task_id}/tag/{tag_name}
    When I execute the DELETE request for tags
    Then I verify that the tag does not exist in the task
      And I verify that the response status is 200