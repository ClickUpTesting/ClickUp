Feature: Get task members

  @API @SmokeTesting @CreateTask @DeleteTask
  Scenario: As a user I want to get the task's members
    Given I set the endpoint /task/{task_id}/member
    When I execute a GET request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/members/task_members.json