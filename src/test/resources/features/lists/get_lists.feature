Feature: Get all List

  @GetAllList
  Scenario: As a user I want to get all lists and verity the that was created
    Given I set the 4 list with the endpoint to /space/{space_id}/list
    Then I verify the list exists in the space
      And I verify that the response status is 200
