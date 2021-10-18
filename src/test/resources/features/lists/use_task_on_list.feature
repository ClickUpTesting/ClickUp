Feature: Use task on list

  @API @SmokeTesting @CreateListInFolder @CreateTask @DeleteList
  Scenario: As a user I want to add a task to a list
    Given I set the list with request endpoint to /list/{list_id}/task/{task_id}
    When I execute a POST request
    Then I verify that the response status is 200