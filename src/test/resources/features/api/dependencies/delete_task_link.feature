Feature: delete a link a task

  @API @SmokeTesting @Dependency @AddLinkTask @DeleteTask
  Scenario: As a user I want to delete a link task
    Given I set the endpoint /task/{task_id}/link/{links_to}
    When I execute a DELETE request
    Then I verify that the response status is 200