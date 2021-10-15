Feature: remove dependency

  @AddDependency @DeleteTask
  Scenario: As a user I want to remove a dependency from a task
    Given I set the endpoint /task/{task_id}/dependency
    When I remove the dependency from a task
      And I execute a DELETE request
    Then I verify that the response status is 200