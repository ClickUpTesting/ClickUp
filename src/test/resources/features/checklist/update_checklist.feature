Feature: Update checklist

  @CreateChecklist @DeleteList
  Scenario: As a user I want to edit a checklist's name
    Given I set the checklist with request endpoint to /checklist/{checklist_id}
    When I set the request body with following values:
      | name | Updated Checklist |
    And I execute the PUT request
    Then I verify that the response status is 200
    And I verify the schema matches the file: schemas/checklist/create_checklist.json