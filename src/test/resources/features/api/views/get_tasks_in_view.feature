Feature: Get all Tasks in View

  @API @SmokeTesting @View @CreateTeamView @DeleteView @CreateTask @DeleteTask
  Scenario: As a user I want to get all tasks in a View
    Given I set the task with request endpoint to /view/{view_id}/task
      And I set the query parameters as:
      | page | 0 |
    When I execute the GET request
    Then I verify the amount of tasks in the view is 2
      And I verify that the response status is 200