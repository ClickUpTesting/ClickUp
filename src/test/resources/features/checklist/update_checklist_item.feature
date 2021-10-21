Feature: Update checklist item

  @API @SmokeTesting @CreateChecklistItem @DeleteChecklistItem
  Scenario: As a user I want to update a checklist item's name
    Given I set the checklists with request endpoint to /checklist/{checklist_id}/checklist_item/{checklist_item_id}
    When I set the request body with following values:
      | name | Updated checklist item |
      And I execute the PUT request
    Then I verify that the response status is 200
      And I verify the checklist item body inside the checklist
      And I verify the schema matches the file: schemas/checklist/create_checklist.json