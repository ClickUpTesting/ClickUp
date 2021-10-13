Feature: Get Space

  @CreateSpace @DeleteSpace
  Scenario: As a user I want to get a space
    Given I set the space with request endpoint to /space/{space_id}
    When I execute the GET request
    Then I verify that the response status is 200
    And I verify the schema matches the file: schemas/space/create_space.json