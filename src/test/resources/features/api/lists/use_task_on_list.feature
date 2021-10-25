Feature: Use task on list

  @API @SmokeTesting @List @CreateListInFolder @CreateTask @DeleteTask @DeleteList
  Scenario: As a user I want to add a task to a list
    Given I set the list with request endpoint to /list/{list_id}/task/{task_id}
    When I execute a POST request
    Then I verify that the response status is 200

  @API @SmokeTesting @List @CreateListInFolder @CreateTask @DeleteTask @DeleteList
  Scenario: As a user I want to remove a task to a list
    Given I set the list with request endpoint to /list/{list_id}/task/{task_id}
      And I add a task to list
    When I execute a DELETE request
    Then I verify that the response status is 200