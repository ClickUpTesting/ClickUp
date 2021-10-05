Feature: Get all List

  @DeleteLists
  Scenario: As a user I want to get all lists and verity the that was created
    Given I set the 4 list with the endpoint to /space/{space_id}/list
    Then I verify the list exists in the "space"
      And I verify that the response status is 200

  @DeleteLists
  Scenario: As a user I want to get all lists and verity the that was created in folder
    Given I set the 3 list with the endpoint to /folder/{folder_id}/list
    Then I verify the list exists in the "folder"
    And I verify that the response status is 200
