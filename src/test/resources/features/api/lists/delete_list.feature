@API @List
Feature: Delete List

  @Smoke @CreateListInFolder
  Scenario: As a user I want to delete a list
    Given I set the list with request endpoint to /list/{list_id}
    When I execute the DELETE request
    Then I verify that the response status is 200
      And I verify the deleted list doesn't exist in the folder