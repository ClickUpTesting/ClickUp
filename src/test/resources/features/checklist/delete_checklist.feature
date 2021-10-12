Feature: Delete checklist

  @CreateChecklist
  Scenario: As a user I want to delete a checklist
    Given I set the checklist with request endpoint to /checklist/{checklist_id}
    When I execute a DELETE request
    Then I verify that the response status is 200