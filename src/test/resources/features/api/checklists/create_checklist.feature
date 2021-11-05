@API @Checklist
Feature: Create checklist

  @Smoke @DeleteChecklists
  Scenario: As a user I want to create a checklist
    Given I set the checklists with request endpoint to /task/{task_id}/checklist
    When I set the request body with following values:
      | name | My checklist |
      And I execute the POST request
    Then I verify that the response status is 200
      And I verify that the response matches with the body
      And I verify the schema matches the file: schemas/checklist/create_checklist.json