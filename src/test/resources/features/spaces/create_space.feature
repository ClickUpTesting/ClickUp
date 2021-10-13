Feature: Create Space

  @DeleteSpace
  Scenario: As a user I want to create a space
    Given I set the space with request endpoint to /team/{team_id}/space
    When I set the request body with following values:
      | name | Space For Testing |
      And I execute the POST request
    Then I verify that the response status is 200
      And I verify the schema matches the file: schemas/space/create_space.json
