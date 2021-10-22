Feature: Delete Space

  @API @SmokeTesting @CreateSpace
  Scenario: As a user I want to delete a space
    Given I set the space with request endpoint to /space/{space_id}
    When I execute the DELETE request
    Then I verify that the response status is 200