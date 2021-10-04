Feature: Add Tag to Task

  @AddTagToTask
  Scenario: As a user I want to add a tag to a task
    Given I set the Tags composed endpoint /task/{task_id}/tag/{tag_name}
    When I execute the POST request for tags
    Then I verify that the response status is 200