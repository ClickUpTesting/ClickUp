Feature: Create Goal

  Scenario: As a user I want to create a goal for tracking an objective
    Given I set the request endpoint to /team/{team_id}/goal
    When I set the request body as goal with following values:
      | name | My goal |
      And I execute the POST request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/create_goal.json
      And I verify the values set on the feature
