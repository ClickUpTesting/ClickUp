@API @Checklist
Feature: Update checklist

  @Smoke @CreateChecklist @DeleteChecklist
  Scenario: As a user I want to edit a checklist's name
    Given I set the checklists with request endpoint to /checklist/{checklist_id}
    When I set the request body with following values:
      | name | Updated Checklist |
      And I execute the PUT request
    Then I verify that the response status is 200
      And I verify that the response matches with the body
      And I verify the schema matches the file: schemas/checklist/create_checklist.json