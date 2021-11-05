@API @Checklist
Feature: Delete checklist item

  @Smoke @CreateChecklistItem
  Scenario: As a user I want to delete a checklist item from a checklist
    Given I set the checklistItem with request endpoint to /checklist/{checklist_id}/checklist_item/{checklist_item_id}
    When I execute a DELETE request
    Then I verify that the response status is 200