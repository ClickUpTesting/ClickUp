Feature: Update Space

  @API @SmokeTesting @Spaces @CreateSpace @DeleteSpace
  Scenario: As a user I want to update a space name
    Given I set the space with request endpoint to /space/{space_id}
    When I set the request body with following values:
      | name | Space For Testing With New Name |
      And I execute the PUT request
    Then I verify that the response status is 200
      And I verify that the response matches with the body
      And I verify the schema matches the file: schemas/space/create_space.json
