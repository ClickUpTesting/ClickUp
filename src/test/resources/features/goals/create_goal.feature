Feature: Create Goal

  Scenario: As a user I want to create a goal for tracking an objective
    Given I build a POST request
    When I create a goal body with parameters
      | name | My goal |
    And I execute the request on create goal endpoint
    Then I check that the response status is OK
    And I see that the schema matches the provided on the file schemas/create_goal.json
    Then I check that the goal was created with provided parameters
