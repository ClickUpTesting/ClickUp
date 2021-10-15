Feature: Create checklist

  @CreateTask @DeleteTask
  Scenario: As a user I want to create a checklist
    Given I set the endpoint /task/{task_id}/dependency
    When I set dependency on a task
    And I execute a POST request
    Then I verify that the response status is 200