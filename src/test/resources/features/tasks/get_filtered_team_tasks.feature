Feature: Get Task in team

  Scenario: As a user I want to get a task
    Given I set the tasks with request endpoint to /team/{team_id}/task
    When I execute the GET request
    Then I verify that the response status is 200
    And I verify the schema matches the file: schemas/task/get_tasks.json
