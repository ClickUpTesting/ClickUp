Feature: Create checklist item

  @API @SmokeTesting @DeleteChecklistItem
  Scenario: As a user I want to create a checklist item inside a checklist
    Given I set the checklists with request endpoint to /checklist/{checklist_id}/checklist_item
    When I set the request body with following values:
      | name | My checklist item |
      And I execute the POST request
    Then I verify that the response status is 200
      And I verify the checklist item body inside the checklist
      And I verify the schema matches the file: schemas/checklist/create_checklist.json