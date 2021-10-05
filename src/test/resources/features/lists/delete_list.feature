Feature: Delete List

  @DeleteList
  Scenario: As a user I want to delete a list for tracking an objective
    Given I set the list with request endpoint to /list/{list_id}
    When I execute the DELETE request
    Then I verify that the response status is 200
      And I verify the deleted list doesn't exist in the folder