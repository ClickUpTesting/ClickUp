Feature: Link a task to another

  @API @SmokeTesting @LinkTask @DeleteTask
  Scenario: As a user I want to add a link to a task
    Given I set the endpoint /task/{task_id}/link/{links_to}
    When I execute a POST request
    Then I verify that the response status is 200